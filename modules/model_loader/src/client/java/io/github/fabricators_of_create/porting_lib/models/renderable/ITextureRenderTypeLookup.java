package io.github.fabricators_of_create.porting_lib.models.renderable;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.Identifier;

/**
 * A generic lookup for {@link RenderType} implementations that use the specified texture.
 */
@FunctionalInterface
public interface ITextureRenderTypeLookup {
	RenderType get(Identifier name);
}
