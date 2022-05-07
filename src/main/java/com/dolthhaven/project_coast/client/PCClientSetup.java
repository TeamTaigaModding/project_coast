package com.dolthhaven.project_coast.client;

import com.dolthhaven.project_coast.core.registry.PCBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PCClientSetup {
    public static void setup(final FMLClientSetupEvent EVENT) {
        ItemBlockRenderTypes.setRenderLayer(PCBlocks.SEAGULL_NEST.get(), RenderType.cutout());
    }
}
