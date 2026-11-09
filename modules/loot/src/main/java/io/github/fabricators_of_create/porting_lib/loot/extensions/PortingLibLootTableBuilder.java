package io.github.fabricators_of_create.porting_lib.loot.extensions;

import net.minecraft.resources.Identifier;

public interface PortingLibLootTableBuilder {
	default Identifier getPortingLibLootTableId() {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}

	default void setPortingLibLootTableId(Identifier id) {
		throw new RuntimeException("this should be overridden via mixin. what?");
	}
}
