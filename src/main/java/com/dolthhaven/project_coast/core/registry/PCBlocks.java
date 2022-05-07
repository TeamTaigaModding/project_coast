package com.dolthhaven.project_coast.core.registry;

import com.dolthhaven.project_coast.ProjectCoast;
import com.dolthhaven.project_coast.common.blocks.NestBlock;
import com.dolthhaven.project_coast.common.blocks.BlockProperties;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;

@Mod.EventBusSubscriber(modid = ProjectCoast.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCBlocks {
    public static final BlockSubRegistryHelper HELPER = ProjectCoast.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> SEAGULL_NEST = HELPER.createBlock("seagull_nest", () -> new NestBlock(BlockProperties.SEAGULL_NEST), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> SEAGRASS_BLOCK = HELPER.createBlock("seagrass_block", () -> new NestBlock(BlockProperties.SEAGRASS_BLOCK), CreativeModeTab.TAB_MISC);

}
