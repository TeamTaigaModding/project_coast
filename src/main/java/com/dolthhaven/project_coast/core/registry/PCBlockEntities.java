package com.dolthhaven.project_coast.core.registry;

import com.dolthhaven.project_coast.ProjectCoast;
import com.dolthhaven.project_coast.common.blocks.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ProjectCoast.MOD_ID);

    public static final RegistryObject<BlockEntityType<NestBlockEntity>> NEST = TILES.register("seagull_nest",
            () -> BlockEntityType.Builder.of(NestBlockEntity::new, PCBlocks.SEAGULL_NEST.get()).build(null));
}
