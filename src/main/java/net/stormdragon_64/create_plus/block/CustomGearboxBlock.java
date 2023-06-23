package net.stormdragon_64.create_plus.block;


import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlock;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;
import net.stormdragon_64.create_plus.item.ModItems;

import java.util.List;

public class CustomGearboxBlock extends GearboxBlock {
    public CustomGearboxBlock(Properties properties) {
        super(properties);

        registerDefaultState(defaultBlockState()
                .setValue(SHAFT_N, true)
                .setValue(SHAFT_E, true)
                .setValue(SHAFT_S, true)
                .setValue(SHAFT_W, true));
    }

//Blockstate stuff for casing blocking
//Note: these values only match up with their directions on a non-vertical gearbox.
    public static final BooleanProperty SHAFT_N = BooleanProperty.create("north_shaft");
    public static final BooleanProperty SHAFT_E = BooleanProperty.create("east_shaft");
    public static final BooleanProperty SHAFT_S = BooleanProperty.create("south_shaft");
    public static final BooleanProperty SHAFT_W = BooleanProperty.create("west_shaft");
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(SHAFT_N, SHAFT_E, SHAFT_S, SHAFT_W));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() == AllBlocks.BRASS_CASING.get().asItem()) {
                //Change states here
            //If axis direction is Y
            if (state.getValue(AXIS) == Direction.Axis.Y) {
                switch (result.getDirection()) {
                    case NORTH -> level.setBlock(blockPos, state.cycle(SHAFT_N), 3);
                    case EAST -> level.setBlock(blockPos, state.cycle(SHAFT_E), 3);
                    case SOUTH -> level.setBlock(blockPos, state.cycle(SHAFT_S), 3);
                    case WEST -> level.setBlock(blockPos, state.cycle(SHAFT_W), 3);
                    default -> {return InteractionResult.FAIL;}
                }
                return InteractionResult.sidedSuccess(true);

                //If axis direction is X
            } else if (state.getValue(AXIS) == Direction.Axis.X) {
                switch (result.getDirection()) {
                    case NORTH -> level.setBlock(blockPos, state.cycle(SHAFT_N), 3);
                    case UP -> level.setBlock(blockPos, state.cycle(SHAFT_E), 3);
                    case SOUTH -> level.setBlock(blockPos, state.cycle(SHAFT_S), 3);
                    case DOWN -> level.setBlock(blockPos, state.cycle(SHAFT_W), 3);
                    default -> {return InteractionResult.FAIL;}
                }
                return InteractionResult.sidedSuccess(true);

                //If axis direction is Z
            } else if (state.getValue(AXIS) == Direction.Axis.Z) {
                switch (result.getDirection()) {
                    case UP -> level.setBlock(blockPos, state.cycle(SHAFT_N), 3);
                    case EAST -> level.setBlock(blockPos, state.cycle(SHAFT_E), 3);
                    case DOWN -> level.setBlock(blockPos, state.cycle(SHAFT_S), 3);
                    case WEST -> level.setBlock(blockPos, state.cycle(SHAFT_W), 3);
                    default -> {return InteractionResult.FAIL;}
                }
                return InteractionResult.sidedSuccess(true);

            } else return InteractionResult.FAIL;

        } else return InteractionResult.FAIL;
    }
//TODO: stop kinetic transfer when covered
//Change block entity
@Override
public BlockEntityType<? extends GearboxBlockEntity> getBlockEntityType() {
    return ModBlockEntities.CUSTOM_GEARBOX.get();
}



//Vertical gearbox
    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        items.add(ModItems.VERTICAL_BRASS_GEARBOX.asStack());
        items.add(ModBlocks.BRASS_GEARBOX.asStack());
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if (state.getValue(AXIS).isVertical())
            return super.getDrops(state, builder);
        return List.of(new ItemStack(ModItems.VERTICAL_BRASS_GEARBOX.get()));
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos,
                                       Player player) {
        if (state.getValue(AXIS).isVertical())
            return super.getCloneItemStack(state, target, world, pos, player);
        return new ItemStack(ModItems.VERTICAL_BRASS_GEARBOX.get());
    }
    }
