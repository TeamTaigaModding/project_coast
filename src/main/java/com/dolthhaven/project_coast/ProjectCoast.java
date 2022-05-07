package com.dolthhaven.project_coast;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.dolthhaven.project_coast.core.registry.*;
import com.dolthhaven.project_coast.client.PCClientSetup;
import org.slf4j.Logger;

@Mod(ProjectCoast.MOD_ID)
public class ProjectCoast {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "project_coast";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public ProjectCoast() {
        IEventBus EventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBus.addListener(this::setup);
        EventBus.addListener(PCClientSetup::setup);


        MinecraftForge.EVENT_BUS.register(EventBus);
        REGISTRY_HELPER.register(EventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
