package com.dolthhaven.project_coast.common.blocks;

import com.dolthhaven.project_coast.core.registry.PCItems;
import com.mojang.realmsclient.util.WorldGenerationInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NestBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    public static final IntegerProperty EGGS = IntegerProperty.create("egg", 0, 4);

    public NestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(EGGS, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EGGS);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int eggs = state.getValue(EGGS);
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.getItem() == PCItems.SEAGULL_EGG.get() && eggs != 4) {
            worldIn.setBlock(pos, state.setValue(EGGS, eggs + 1), 1);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        else if (eggs != 0 && itemstack.getItem() != PCItems.SEAGULL_EGG.get()) {
            popResource(worldIn, pos, new ItemStack(PCItems.SEAGULL_EGG.get(), 1));
            worldIn.setBlock(pos, state.setValue(EGGS, eggs - 1), 1);
            return InteractionResult.SUCCESS;
        }
        else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
        this.spawnDestroyParticles(worldIn, player, pos, state);
        if (!worldIn.isClientSide() && !(player.getAbilities().instabuild) && state.getValue(EGGS) > 0) {
            popResource(worldIn, pos, new ItemStack(PCItems.SEAGULL_EGG.get(), state.getValue(EGGS)));
        }
    }


    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return blockState.getValue(EGGS) * 3;
    }
}
