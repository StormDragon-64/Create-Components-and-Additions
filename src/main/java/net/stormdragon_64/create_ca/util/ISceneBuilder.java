package net.stormdragon_64.create_ca.util;

import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;

public interface ISceneBuilder extends SceneBuilder {

     void hideIndependentSectionImmediately(ElementLink<WorldSectionElement> link);

}
