package com.dolthhaven.project_coast.common.blocks.entity;

import com.dolthhaven.project_coast.core.registry.PCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Properties;

public class NestBlockEntity extends BlockEntity {

    public NestBlockEntity(BlockPos pos, BlockState state) {
        super(PCBlockEntities.NEST.get(), pos, state);
    }





}
