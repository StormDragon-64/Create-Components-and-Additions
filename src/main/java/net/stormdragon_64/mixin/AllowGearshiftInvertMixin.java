package net.stormdragon_64.mixin;

import com.simibubi.create.content.contraptions.relays.encased.AbstractEncasedShaftBlock;
import com.simibubi.create.content.contraptions.relays.encased.GearshiftBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.stormdragon_64.create_plus.CustomBlockStates;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//This is my first time using mixins. Don't judge me, and submit a pull request if you want to fix it.
@Mixin(GearshiftBlock.class)
public abstract class AllowGearshiftInvertMixin  extends AbstractEncasedShaftBlock {
    public AllowGearshiftInvertMixin(Properties properties) {
        super(properties);
    }
    @Inject(method = "<init>", at = @At("RETURN"))
    private void OnGearshiftBlock(CallbackInfo ci) {
        registerDefaultState(defaultBlockState()
                .setValue(IS_INVERTED, false));
    }



    //delete this when blockstate builder is switched to injector
    @Shadow @Final
    private static BooleanProperty POWERED;

    @Shadow
    public void detachKinetics(Level worldIn, BlockPos pos, boolean reAttachNextTick) {}


    private static final BooleanProperty IS_INVERTED = CustomBlockStates.IS_INVERTED;

    public InteractionResult use(BlockState state, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            ItemStack item = player.getMainHandItem();
            if (item.getItem() == Items.REDSTONE_TORCH) {
                level.setBlock(blockPos, state.cycle(IS_INVERTED), 2);
                detachKinetics(level, blockPos, true);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            return InteractionResult.FAIL;
        }
    }

    //move to injector once everything else works
    @Overwrite
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, IS_INVERTED);
        super.createBlockStateDefinition(builder);
    }
}