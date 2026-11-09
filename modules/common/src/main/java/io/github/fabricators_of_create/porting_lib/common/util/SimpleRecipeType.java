package io.github.fabricators_of_create.porting_lib.common.util;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public record SimpleRecipeType<T extends Recipe<?>>(Identifier name) implements RecipeType<T> {
	@Override
	public String toString() {
		return name.toString();
	}
}
