package io.github.fabricators_of_create.porting_lib.data.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.data.JsonCodecProvider;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;

/**
 * <p>Data provider for atlas configuration files.<br>
 * An atlas configuration is bound to a specific texture atlas such as the {@code minecraft:blocks} atlas and
 * allows adding additional textures to the atlas by adding {@link SpriteSource}s to the configuration.</p>
 * <p>See {@link SpriteSources} for the available sources and the constants in this class for the
 * atlases used in vanilla Minecraft</p>
 */
public abstract class SpriteSourceProvider extends JsonCodecProvider<List<SpriteSource>> {
	protected static final Identifier BLOCKS_ATLAS = Identifier.withDefaultNamespace("blocks");
	protected static final Identifier BANNER_PATTERNS_ATLAS = Identifier.withDefaultNamespace("banner_patterns");
	protected static final Identifier BEDS_ATLAS = Identifier.withDefaultNamespace("beds");
	protected static final Identifier CHESTS_ATLAS = Identifier.withDefaultNamespace("chests");
	protected static final Identifier SHIELD_PATTERNS_ATLAS = Identifier.withDefaultNamespace("shield_patterns");
	protected static final Identifier SHULKER_BOXES_ATLAS = Identifier.withDefaultNamespace("shulker_boxes");
	protected static final Identifier SIGNS_ATLAS = Identifier.withDefaultNamespace("signs");
	protected static final Identifier MOB_EFFECTS_ATLAS = Identifier.withDefaultNamespace("mob_effects");
	protected static final Identifier PAINTINGS_ATLAS = Identifier.withDefaultNamespace("paintings");
	protected static final Identifier PARTICLES_ATLAS = Identifier.withDefaultNamespace("particles");

	private final Map<Identifier, SourceList> atlases = new HashMap<>();

	public SpriteSourceProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
		super(output, PackOutput.Target.RESOURCE_PACK, "atlases", PackType.CLIENT_RESOURCES, SpriteSources.FILE_CODEC, lookupProvider, modId, existingFileHelper);
	}

	/**
	 * Get or create a {@link SourceList} for the given atlas
	 *
	 * @param id The texture atlas the sources should be added to, see constants at the top for the format
	 *           and the vanilla atlases
	 * @return an existing {@code SourceList} for the given atlas or a new one if not present yet
	 */
	protected final SourceList atlas(Identifier id) {
		return atlases.computeIfAbsent(id, i -> {
			final SourceList newAtlas = new SourceList(new ArrayList<>());
			unconditional(i, newAtlas.sources());
			return newAtlas;
		});
	}

	protected record SourceList(List<SpriteSource> sources) {
		/**
		 * Add the given {@link SpriteSource} to this atlas configuration
		 *
		 * @param source The {@code SpriteSource} to be added
		 */
		public SourceList addSource(SpriteSource source) {
			sources.add(source);
			return this;
		}
	}
}
