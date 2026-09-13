package net.sshmoob.create_ca.util;

import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.minecraft.core.BlockPos;

public interface ISceneBuilder extends SceneBuilder {

     void hideIndependentSectionImmediately(ElementLink<WorldSectionElement> link);


     void rotationDirectionIndicator(BlockPos pos, BlockPos displayPos);

}
