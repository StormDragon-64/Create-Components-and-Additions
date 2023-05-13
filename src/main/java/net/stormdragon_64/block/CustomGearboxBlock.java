package net.stormdragon_64.block;

import com.simibubi.create.content.contraptions.relays.gearbox.GearboxBlock;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.HitResult;
import net.stormdragon_64.block.tile_entity.ModTileEntities;
import net.stormdragon_64.item.ModItems;

import java.util.List;

public class CustomGearboxBlock extends GearboxBlock {
    public CustomGearboxBlock(Properties properties) {
        super(properties);
    }
@Override
public BlockEntityType<? extends GearboxTileEntity> getTileEntityType() {
    return ModTileEntities.CUSTOM_GEARBOX.get();
}

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
