package net.stormdragon_64.create_plus.ponder;

import com.simibubi.create.foundation.ponder.*;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class PonderScenes {
    public static void invertedGearshift(SceneBuilder scene, SceneBuildingUtil util) {
        //define stuff
        BlockPos middleBlock = util.grid.at(2,1,2);
        BlockPos invertedBlock = middleBlock.above(2).west(2);
        Selection torchStuff = util.select
                .fromTo(2, 2, 2, 4, 1, 2);
        Selection kineticPoweredSection = util.select
                .fromTo(2, 3, 0, 2, 3 ,4);
        Selection leverSection = util.select.fromTo(2,4,2,2,5,2);



        ElementLink<WorldSectionElement> mainSection =
                scene.world.showIndependentSection(kineticPoweredSection, Direction.DOWN);


        //scene
        scene.title("inverted_gearshift", "Converting to and using Inverted Gearshifts");

        scene.showBasePlate();
        scene.idle(5);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 20);
        scene.idle(15);
        //stuff, I guess


//explanation
        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock))
                .placeNearTarget()
                .text("While the gearshift is useful, it doesn't fit all use cases.");
        scene.idle(60);

        scene.overlay.showText(80)
                .placeNearTarget()
                .colored(PonderPalette.BLUE)
                .text("For example, what if you wanted a gearshift that reverses the direction of rotation when §nnot powered§r, and acts like a shaft when it §nis powered§r?");
        scene.idle(90);

        scene.overlay.showText(60)
                .placeNearTarget()
                .text("Or in other words, you want an inverted form of a gearshift?");
        scene.idle(70);
        //Redstone Torch
        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock.above(1)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("While you could use a redstone torch to do just that...");
        scene.idle(10);

        scene.world.moveSection(mainSection, util.vector.of(0, 2, 0), 15);
        scene.idle(10);
        scene.world.showSection(torchStuff, Direction.UP);
        scene.idle(45);


        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock.above(1)))
                .colored(PonderPalette.RED)
                .placeNearTarget()
                .text("This can easily be considered bulky depending on the machine your making.");

        scene.idle(55);
        scene.world.hideSection(torchStuff, Direction.SOUTH);
        scene.idle(10);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 15);
        scene.idle(10);

        scene.overlay.showText(45)
                .colored(PonderPalette.GREEN)
                .independent()
                .text("This is where the inverted gearshift comes into play.");
        scene.idle(55);

        //Inverted Gearshift
        scene.overlay.showText(35)
                .pointAt(util.vector.centerOf(middleBlock))
                .attachKeyFrame()
                .placeNearTarget()
                .text("By right clicking a gearshift with a redstone torch...");
        scene.idle(5);
//right click with redstone torch

        scene.overlay.showControls(new InputWindowElement(util.vector.of(2, 2.5, 2), Pointing.DOWN).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH)), 30);
        scene.idle(15);
        //Convert to inverted

scene.world.hideIndependentSectionImmediately(mainSection);
        ElementLink<WorldSectionElement> invertedGearshift =
                scene.world.showIndependentSectionImmediately(util.select.fromTo(0, 3, 0, 0, 3 ,4));
        scene.world.moveSection(invertedGearshift, util.vector.of(2,-2,0), 0);
        //Apply effects of inversion
        scene.effects.indicateSuccess(middleBlock);


        scene.idle(25);

        //explain inverted gearshift
        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock))
                .colored(PonderPalette.GREEN)
                .placeNearTarget()
                .text("...it will be converted into an inverted gearshift.");
        scene.idle(60);
        scene.effects.rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        scene.effects.rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));

        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted gearshift reverses rotation direction when §nnot powered§r...");
        scene.idle(10);
        ElementLink<WorldSectionElement> powerablelamp =
                scene.world.showIndependentSection(leverSection, Direction.DOWN);
        scene.world.moveSection(powerablelamp, util.vector.of(0,-2,0), 10);
        scene.idle(55);


        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and simply relays rotation when it §nis powered§.");

        scene.world.toggleRedstonePower(util.select.fromTo(2,5,2, 2,4,2).add(util.select.position(invertedBlock)));
scene.effects.indicateRedstone(middleBlock.atY(3));
        scene.world.modifyKineticSpeed(util.select.fromTo(0,3,2, 0,3,4), f -> -f);

        scene.effects.rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        scene.effects.rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));
        scene.idle(60);

        scene.overlay.showText(45)
                .independent()
                .placeNearTarget()
                .colored(PonderPalette.GREEN)
                .text("Just like you wanted in the example from earlier!");
        scene.idle(55);

      scene.world.hideIndependentSection(powerablelamp, Direction.UP);
       scene.world.toggleRedstonePower(util.select.position(invertedBlock));
        scene.world.modifyKineticSpeed(util.select.fromTo(0,3,2, 0,3,4), f -> -f);

        scene.idle(20);

        scene.overlay.showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay.showText(90)
                .placeNearTarget()
                .text("...it also means that you don't need to power the gearshift just to change the direction of rotation, compacting things further!");
        scene.idle(10);
        //Show both
        ElementLink<WorldSectionElement> mainSectionAgain =
                scene.world.showIndependentSectionImmediately(kineticPoweredSection);
        scene.world.modifyKineticSpeed(kineticPoweredSection, f -> -f);
        scene.world.moveSection(mainSectionAgain, util.vector.of(0,-2,0), 0);
        scene.world.moveSection(mainSectionAgain, util.vector.of(-1,0,0), 10);
        scene.world.moveSection(invertedGearshift, util.vector.of(1,0,0), 10);

        scene.idle(80);
        ElementLink<WorldSectionElement> powerableLampAgain =
                scene.world.showIndependentSectionImmediately(leverSection);
        scene.world.moveSection(powerableLampAgain, util.vector.of(-1,0,0), 0);
        scene.world.moveSection(powerableLampAgain, util.vector.of(0,-2,0), 10);
        scene.idle(10);
        scene.world.toggleRedstonePower(util.select.position(2,3,2));
        scene.effects.indicateRedstone(middleBlock.west());
        scene.world.modifyKineticSpeed(util.select.fromTo(2,3,2, 2,3,4), f -> -f);
        scene.idle(5);
        scene.overlay.showText(120)
                .colored(PonderPalette.GREEN)
                .attachKeyFrame()
                .placeNearTarget()
                .text("This means that not only will the inverted gearshift take at least 1 less block of space, but it also fixes the problem of everything around the power source being powered, since you no longer need one!");
        scene.idle(10);
        scene.effects.rotationDirectionIndicator(util.grid.at(2,3,4), middleBlock.south(2).west(1));
        scene.effects.rotationDirectionIndicator(util.grid.at(0,3,4), middleBlock.south(2).east(1));

        scene.idle(140);
        scene.markAsFinished();
    }




    //I know it's copy and pasted but the ponder system doesn't allow you to make a modified version of another ponder without doing it this way


    public static void invertedClutch(SceneBuilder scene, SceneBuildingUtil util) {
        //define stuff
        BlockPos middleBlock = util.grid.at(2,1,2);
        BlockPos invertedBlock = middleBlock.above(2).west(2);
        Selection torchStuff = util.select
                .fromTo(2, 2, 2, 4, 1, 2);
        Selection kineticPoweredSection = util.select
                .fromTo(2, 3, 0, 2, 3 ,4);
        Selection leverSection = util.select.fromTo(2,4,2,2,5,2);



        ElementLink<WorldSectionElement> mainSection =
                scene.world.showIndependentSection(kineticPoweredSection, Direction.DOWN);


        //scene
        scene.title("inverted_clutch", "Converting to and using Inverted Clutches");
        scene.rotateCameraY(-90.0F);

        scene.showBasePlate();
        scene.idle(5);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 20);
        scene.idle(15);
        //stuff, I guess


//explanation
        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock))
                .placeNearTarget()
                .text("While the clutch is useful, it doesn't fit all use cases.");
        scene.idle(60);

        scene.overlay.showText(80)
                .placeNearTarget()
                .colored(PonderPalette.BLUE)
                .text("For example, what if you wanted a clutch that blocks rotation when §nnot powered§r, and acts like a shaft when it §nis powered§r?");
        scene.idle(90);

        scene.overlay.showText(60)
                .placeNearTarget()
                .text("Or in other words, you want an inverted form of a clutch?");
        scene.idle(70);
        //Redstone Torch
        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock.above(1)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("While you could use a redstone torch to do just that...");
        scene.idle(10);

        scene.world.moveSection(mainSection, util.vector.of(0, 2, 0), 15);
        scene.idle(10);
        scene.world.showSection(torchStuff, Direction.UP);
        scene.idle(45);


        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock.above(1)))
                .colored(PonderPalette.RED)
                .placeNearTarget()
                .text("This can easily be considered bulky depending on the machine your making.");

        scene.idle(55);
        scene.world.hideSection(torchStuff, Direction.SOUTH);
        scene.idle(10);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 15);
        scene.idle(10);

        scene.overlay.showText(45)
                .colored(PonderPalette.GREEN)
                .independent()
                .text("This is where the inverted clutch comes into play.");
        scene.idle(55);

        //Inverted Gearshift
        scene.overlay.showText(35)
                .pointAt(util.vector.centerOf(middleBlock))
                .attachKeyFrame()
                .placeNearTarget()
                .text("By right clicking a clutch with a redstone torch...");
        scene.idle(5);
//right click with redstone torch

        scene.overlay.showControls(new InputWindowElement(util.vector.of(2, 2.5, 2), Pointing.DOWN).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH)), 30);
        scene.idle(15);
        //Convert to inverted

        scene.world.hideIndependentSectionImmediately(mainSection);
        ElementLink<WorldSectionElement> invertedClutch =
                scene.world.showIndependentSectionImmediately(util.select.fromTo(0, 3, 0, 0, 3 ,4));
        scene.world.toggleRedstonePower(util.select.position(invertedBlock));
        scene.world.modifyKineticSpeed(util.select.fromTo(0,3,3, 0,3,4), f -> 0f);
        scene.world.moveSection(invertedClutch, util.vector.of(2,-2,0), 0);
        //Apply effects of inversion
        scene.effects.indicateSuccess(middleBlock);


        scene.idle(25);

        //explain inverted clutch
        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock))
                .colored(PonderPalette.GREEN)
                .placeNearTarget()
                .text("...it will be converted into an inverted clutch.");
        scene.idle(60);
        scene.effects.rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        scene.effects.rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));

        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted clutch prevents rotation when §nnot powered§r...");
        scene.idle(10);
        ElementLink<WorldSectionElement> powerablelamp =
                scene.world.showIndependentSection(leverSection, Direction.DOWN);
        scene.world.moveSection(powerablelamp, util.vector.of(0,-2,0), 10);
        scene.idle(55);


        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and simply relays rotation when it §nis powered§.");

        scene.world.toggleRedstonePower(util.select.fromTo(2,5,2, 2,4,2).add(util.select.position(invertedBlock)));
        scene.effects.indicateRedstone(middleBlock.atY(3));
        scene.world.setKineticSpeed(util.select.fromTo(0,3,2, 0,3,4), -32f);

        scene.effects.rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        scene.effects.rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));
        scene.idle(60);

        scene.overlay.showText(45)
                .independent()
                .placeNearTarget()
                .colored(PonderPalette.GREEN)
                .text("Just like you wanted in the example from earlier!");
        scene.idle(55);

        scene.world.hideIndependentSection(powerablelamp, Direction.UP);
        scene.world.toggleRedstonePower(util.select.position(invertedBlock));
        scene.world.modifyKineticSpeed(util.select.fromTo(0,3,3, 0,3,4), f -> 0f);

        scene.idle(20);

        scene.overlay.showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay.showText(90)
                .placeNearTarget()
                .text("...it also means that you don't need to power the clutch just to prevent rotation, compacting things further!");
        scene.idle(10);
        //Show both
        ElementLink<WorldSectionElement> mainSectionAgain =
                scene.world.showIndependentSectionImmediately(kineticPoweredSection);
        scene.world.moveSection(mainSectionAgain, util.vector.of(0,-2,0), 0);
        scene.world.moveSection(mainSectionAgain, util.vector.of(-1,0,0), 10);
        scene.world.moveSection(invertedClutch, util.vector.of(1,0,0), 10);

        scene.idle(80);
        ElementLink<WorldSectionElement> powerableLampAgain =
                scene.world.showIndependentSectionImmediately(leverSection);
        scene.world.moveSection(powerableLampAgain, util.vector.of(-1,0,0), 0);
        scene.world.moveSection(powerableLampAgain, util.vector.of(0,-2,0), 10);
        scene.idle(10);
        scene.world.toggleRedstonePower(util.select.position(2,3,2));
        scene.effects.indicateRedstone(middleBlock.west());
        scene.world.modifyKineticSpeed(util.select.fromTo(2,3,3, 2,3,4), f -> 0f);

        scene.idle(5);
        scene.overlay.showText(120)
                .colored(PonderPalette.GREEN)
                .attachKeyFrame()
                .placeNearTarget()
                .text("This means that not only will the inverted gearshift take at least 1 less block of space, but it also fixes the problem of everything around the power source being powered, since you no longer need one!");
        scene.idle(10);
        scene.effects.rotationDirectionIndicator(util.grid.at(2,3,4), middleBlock.south(2).west(1));
        scene.effects.rotationDirectionIndicator(util.grid.at(0,3,4), middleBlock.south(2).east(1));

        scene.idle(140);
        scene.markAsFinished();
    }
}
