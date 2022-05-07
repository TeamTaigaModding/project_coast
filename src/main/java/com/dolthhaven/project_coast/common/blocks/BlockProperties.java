package com.dolthhaven.project_coast.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockProperties {
    public static final BlockBehaviour.Properties SEAGULL_NEST = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).strength(0.8F).sound(SoundType.CROP);

    public static final BlockBehaviour.Properties SEAGRASS_BLOCK = BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_BROWN).strength(0.8F).sound(SoundType.SAND);
}
