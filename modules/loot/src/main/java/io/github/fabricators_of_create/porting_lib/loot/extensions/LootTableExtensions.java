package io.github.fabricators_of_create.porting_lib.loot.extensions;

import net.minecraft.resources.Identifier;

public interface LootTableExtensions {
	// hack to access a field defined in one mixin in another.
	default void setLootTableId(final Identifier id) {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}

	default Identifier getLootTableId() {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}
}
