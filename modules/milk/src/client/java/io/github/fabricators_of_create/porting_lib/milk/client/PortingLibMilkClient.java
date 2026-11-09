package io.github.fabricators_of_create.porting_lib.milk.client;

import io.github.fabricators_of_create.porting_lib.core.PortingLib;
import io.github.fabricators_of_create.porting_lib.milk.PortingLibMilk;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.resources.Identifier;

public class PortingLibMilkClient {
	private static boolean enableMilkFluid = false;

	public static void enableMilkRenderer() {
		if (!enableMilkFluid) {
			Identifier MILK_STILL = PortingLib.id("block/milk_still");
			Identifier MILK_FLOW = PortingLib.id("block/milk_flowing");
			FluidRenderHandlerRegistry.INSTANCE.register(PortingLibMilk.MILK.get(), PortingLibMilk.FLOWING_MILK.get(), new SimpleFluidRenderHandler(MILK_STILL, MILK_FLOW));
		}
		enableMilkFluid = true;
	}
}
