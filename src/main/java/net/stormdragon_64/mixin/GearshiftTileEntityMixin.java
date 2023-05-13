package net.stormdragon_64.mixin;

import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import com.simibubi.create.content.contraptions.relays.gearbox.GearshiftTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stormdragon_64.create_plus.CustomBlockStates;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GearshiftTileEntity.class)
abstract class GearshiftTileEntityMixin extends SplitShaftTileEntity {

    public GearshiftTileEntityMixin(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {super(typeIn, pos, state);}

    //Change to injector if it works
    @Overwrite(remap = false)
    public float getRotationSpeedModifier(Direction face) {
        if (hasSource()) {
            if (face != getSourceFacing() && !getBlockState().getValue(BlockStateProperties.POWERED) && !getBlockState().getValue(CustomBlockStates.IS_INVERTED)) {
                return 1;
            } else if (face != getSourceFacing() && !getBlockState().getValue(BlockStateProperties.POWERED) && getBlockState().getValue(CustomBlockStates.IS_INVERTED)) {
                return -1;
            } else if (face != getSourceFacing() && getBlockState().getValue(BlockStateProperties.POWERED) && getBlockState().getValue(CustomBlockStates.IS_INVERTED)) {
                return 1;
            } else if (face != getSourceFacing() && getBlockState().getValue(BlockStateProperties.POWERED) && !getBlockState().getValue(CustomBlockStates.IS_INVERTED)) {
                return -1;
            }
        }
        return 1;
    }

}
