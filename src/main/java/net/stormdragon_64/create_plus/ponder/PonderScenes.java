package net.stormdragon_64.create_plus.ponder;

import com.simibubi.create.foundation.ponder.*;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stormdragon_64.create_plus.block.ModBlocks;


public class PonderScenes {
    public static void invertedGearshift(SceneBuilder scene, SceneBuildingUtil util) {
        //define stuff
        BlockPos middleBlock = util.grid.at(2,1,2);
        Selection torchStuff = util.select
                .fromTo(2, 2, 2, 4, 1, 2);
        Selection kineticPoweredSection = util.select
                .fromTo(2, 3, 0, 2, 3 ,4);
        Selection leverSection = util.select.fromTo(2,4,2,2,5,2);



        ElementLink<WorldSectionElement> mainSection =
                scene.world.showIndependentSection(kineticPoweredSection, Direction.DOWN);

        //scene
        scene.title("inverted_gearshift", "Using Inverted Gearshifts");

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
                .text("Or in other words, you want an inverted form of the gearshift?");
        scene.idle(70);
        //Redstone Torch
        scene.overlay.showText(55)
                .pointAt(util.vector.centerOf(middleBlock.above(1)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("While you could use a redstone torch to do the same thing...");
        scene.idle(10);

        scene.world.moveSection(mainSection, util.vector.of(0, 2, 0), 15);
        scene.idle(10);
        scene.world.showSection(torchStuff, Direction.UP);
        scene.idle(15);


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
        scene.world.setBlock(middleBlock.atY(3),
                ModBlocks.INVERTED_GEARSHIFT.getDefaultState()
                        .setValue(BlockStateProperties.AXIS, Direction.Axis.Z), true);
        scene.world.setKineticSpeed(util.select.fromTo(2,3,3, 2,3,4), -32);
        scene.world.setKineticSpeed(util.select.position(middleBlock), 32);

        scene.idle(25);

        //explain inverted gearshift
        scene.overlay.showText(45)
                .pointAt(util.vector.centerOf(middleBlock))
                .colored(PonderPalette.GREEN)
                .placeNearTarget()
                .text("...it will be converted into an inverted gearshift.");
        scene.idle(60);
        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted gearshift reverses rotation direction when §nnot powered§r...");
        scene.idle(10);
        ElementLink<WorldSectionElement> powerablelamp =
                scene.world.showIndependentSection(leverSection, Direction.WEST);
        scene.world.moveSection(powerablelamp, util.vector.of(0,-2,0), 10);
        scene.idle(50);

        scene.overlay.showText(50)
                .pointAt(util.vector.centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and acts like a shaft when it is §npowered§.");
        scene.idle(5);

        scene.world.setBlock(util.grid.at(2, 5, 2),
                Blocks.LEVER.defaultBlockState().setValue(BlockStateProperties.POWERED, true).setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR), false);
        scene.world.setBlock(util.grid.at(2, 4, 2),
                Blocks.REDSTONE_LAMP.defaultBlockState().setValue(BlockStateProperties.LIT, true), false);
        scene.world.setKineticSpeed(util.select.fromTo(2,3,3, 2,3,4), 32);

        scene.idle(55);

        scene.overlay.showText(45)
                .independent()
                .placeNearTarget()
                .colored(PonderPalette.GREEN)
                .text("Just like you wanted in the example from earlier!");
        scene.idle(55);

      scene.world.hideIndependentSection(powerablelamp, Direction.EAST);
        scene.idle(20);

        scene.overlay.showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.UP))
                .placeNearTarget()
                .text("...it also means that you don't need to power the gearshift just to change the direction of rotation, compacting things further!");
        scene.idle(70);

//TODO: add scene where there is normal gearshift and inverted gearshift, with the gearshift powered and the inverted one not, to show your saving a lever.
    }
}
