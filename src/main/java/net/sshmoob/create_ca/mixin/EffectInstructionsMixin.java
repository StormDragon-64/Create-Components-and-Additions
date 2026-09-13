package net.sshmoob.create_ca.mixin;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.minecraft.core.BlockPos;
import net.sshmoob.create_ca.util.ISceneBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreateSceneBuilder.EffectInstructions.class)
public abstract class EffectInstructionsMixin implements ISceneBuilder {

    @Override
    public void rotationDirectionIndicator(BlockPos pos, BlockPos displayPos) {
        rotationIndicator(pos, true, displayPos);
    }
@Shadow
    private void rotationIndicator(BlockPos pos, boolean b, BlockPos displayPos) {
    }
}
