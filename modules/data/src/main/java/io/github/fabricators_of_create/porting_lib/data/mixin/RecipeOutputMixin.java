package io.github.fabricators_of_create.porting_lib.data.mixin;

import io.github.fabricators_of_create.porting_lib.data.extensions.RecipeOutputExtension;
import io.github.fabricators_of_create.porting_lib.resources.conditions.ICondition;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.data.recipes.RecipeOutput;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;

import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RecipeOutput.class)
public interface RecipeOutputMixin extends RecipeOutputExtension {
	@Shadow
	void accept(Identifier location, Recipe<?> recipe, @Nullable AdvancementHolder advancement);

	@Override
	default void accept(Identifier id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition... conditions) {
		accept(id, recipe, advancement);
	}
}
