package net.stormdragon_64.create_ca.mixin;


import com.simibubi.create.content.kinetics.base.AbstractEncasedShaftBlock;
import com.simibubi.create.content.kinetics.transmission.GearshiftBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.create_ca.block.ModBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GearshiftBlock.class)
public abstract class InvertibleGearshiftMixin extends AbstractEncasedShaftBlock {
    public InvertibleGearshiftMixin(Properties properties) {
        super(properties);
    }

    @Shadow(remap=false) @Final
    public static BooleanProperty POWERED;

    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() == Items.REDSTONE_TORCH) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
                level.setBlockAndUpdate(blockPos, ModBlocks.INVERTED_GEARSHIFT
                        .getDefaultState()
                        .setValue(POWERED, !state.getValue(POWERED))
                        .setValue(AXIS, state.getValue(AXIS)));
                return InteractionResult.SUCCESS;

            } else {return InteractionResult.CONSUME_PARTIAL;}
        } else {return InteractionResult.FAIL;}
    }

}