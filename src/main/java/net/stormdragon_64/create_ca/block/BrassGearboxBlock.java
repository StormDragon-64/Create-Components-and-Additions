package net.stormdragon_64.create_ca.block;


import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.RotationPropagator;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.ticks.TickPriority;
import net.stormdragon_64.create_ca.block_entity.ModBlockEntities;
import net.stormdragon_64.create_ca.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BrassGearboxBlock extends GearboxBlock {
    public BrassGearboxBlock(Properties properties) {
        super(properties);

        registerDefaultState(defaultBlockState()
                .setValue(SHAFT_N, true)
                .setValue(SHAFT_E, true)
                .setValue(SHAFT_S, true)
                .setValue(SHAFT_W, true));
    }

//Blockstate stuff for casing blocking
//Note: these values only match up with their directions on a non-vertical (Axis Y) gearbox.
    public static final BooleanProperty SHAFT_N = BooleanProperty.create("north_shaft");
    public static final BooleanProperty SHAFT_E = BooleanProperty.create("east_shaft");
    public static final BooleanProperty SHAFT_S = BooleanProperty.create("south_shaft");
    public static final BooleanProperty SHAFT_W = BooleanProperty.create("west_shaft");
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(SHAFT_N, SHAFT_E, SHAFT_S, SHAFT_W));
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos blockPos,
                                          Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() == AllBlocks.BRASS_CASING.get().asItem()) {
            //update kinetic transfer after side blocked
            BlockEntity be = level.getBlockEntity(blockPos);
            if ((be instanceof KineticBlockEntity)) {
                RotationPropagator.handleRemoved(level, blockPos, (KineticBlockEntity) be);
            }
        updateIndirectNeighbourShapes(state, level, blockPos, 3, 0);
            level.scheduleTick(blockPos, this, 0, TickPriority.EXTREMELY_HIGH);

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

            } else
                return InteractionResult.FAIL;

        } else
            return InteractionResult.FAIL;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        boolean north = false;
        boolean east = false;
        boolean south = false;
        boolean west = false;

        if (state.getValue(AXIS) == Direction.Axis.Y) {
            if (state.getValue(SHAFT_N)) {
                north = face == Direction.NORTH;
            }
            if (state.getValue(SHAFT_E)) {
                east = face == Direction.EAST;
            }
            if (state.getValue(SHAFT_S)) {
                south = face == Direction.SOUTH;
            }
            if (state.getValue(SHAFT_W)) {
                west = face == Direction.WEST;
            }
        }

        if (state.getValue(AXIS) == Direction.Axis.X) {
            if (state.getValue(SHAFT_N)) {
                north = face == Direction.NORTH;
            }
            if (state.getValue(SHAFT_E)) {
                east = face == Direction.UP;
            }
            if (state.getValue(SHAFT_S)) {
                south = face == Direction.SOUTH;
            }
            if (state.getValue(SHAFT_W)) {
                west = face == Direction.DOWN;
            }
        }

        if (state.getValue(AXIS) == Direction.Axis.Z) {
            if (state.getValue(SHAFT_N)) {
                north = face == Direction.UP;
            }
            if (state.getValue(SHAFT_E)) {
                east = face == Direction.EAST;
            }
            if (state.getValue(SHAFT_S)) {
                south = face == Direction.DOWN;
            }
            if (state.getValue(SHAFT_W)) {
                west = face == Direction.WEST;
            }
        }

        return north || east || south || west;
    }

//Change block entity
@Override
public BlockEntityType<? extends GearboxBlockEntity> getBlockEntityType() {
    return ModBlockEntities.BRASS_GEARBOX.get();
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
