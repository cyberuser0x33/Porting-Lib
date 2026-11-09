package io.github.fabricators_of_create.porting_lib.loot.extensions;

import net.minecraft.resources.Identifier;

public interface LootContextExtensions {
	default void setQueriedLootTableId(Identifier queriedLootTableId) {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}
	default Identifier getQueriedLootTableId() {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}
}
