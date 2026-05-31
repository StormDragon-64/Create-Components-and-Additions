package net.sudopos.create_ca.mixin;


import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.foundation.PonderSceneBuilder;
import net.createmod.ponder.foundation.instruction.FadeOutOfSceneInstruction;
import net.minecraft.core.Direction;
import net.sudopos.create_ca.util.ISceneBuilder;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(PonderSceneBuilder.class)
public abstract class PonderSceneBuilderMixin implements ISceneBuilder {

    @Override
    public void hideIndependentSectionImmediately(ElementLink<WorldSectionElement> link) {
        addInstruction(new FadeOutOfSceneInstruction<>(0, Direction.DOWN, link));
    }
}
