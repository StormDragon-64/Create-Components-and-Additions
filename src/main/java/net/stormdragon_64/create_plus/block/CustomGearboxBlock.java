package net.stormdragon_64.create_plus.block;


import com.simibubi.create.content.kinetics.gearbox.GearboxBlock;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.HitResult;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;
import net.stormdragon_64.create_plus.item.ModItems;

import java.util.List;

public class CustomGearboxBlock extends GearboxBlock {
    public CustomGearboxBlock(Properties properties) {
        super(properties);

        registerDefaultState(defaultBlockState()
                .setValue(LEFT_SHAFT, true)
                .setValue(RIGHT_SHAFT, true)
                .setValue(TOP_SHAFT, true)
                .setValue(BOTTOM_SHAFT, true));
    }

//Blockstate stuff for casing blocking

    public static final BooleanProperty LEFT_SHAFT = BooleanProperty.create("left_shaft");
    public static final BooleanProperty RIGHT_SHAFT = BooleanProperty.create("right_shaft");
    public static final BooleanProperty TOP_SHAFT = BooleanProperty.create("top_shaft");
    public static final BooleanProperty BOTTOM_SHAFT = BooleanProperty.create("bottom_shaft");
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(LEFT_SHAFT, RIGHT_SHAFT, TOP_SHAFT, BOTTOM_SHAFT));
    }

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
