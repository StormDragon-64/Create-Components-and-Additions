package net.stormdragon_64.create_plus.ponder;

import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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


        ElementLink<WorldSectionElement> mainSection =
                scene.world.showIndependentSection(kineticPoweredSection, Direction.DOWN);

        //scene
        scene.title("inverted_gearshift", "Using Inverted Gearshifts");

        scene.showBasePlate();
        scene.idle(5);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 15);
        scene.idle(5);
        //stuff, I guess


//explanation
        scene.overlay.showText(50)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.WEST))
                .placeNearTarget()
                .text("While the gearshift is useful, it doesn't fit all use cases.");
        scene.idle(60);

        scene.overlay.showText(80)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .placeNearTarget()
                .text("For example, what if you wanted a gearshift that reverses the direction of rotation when §nnot powered§r, and acts like a shaft when it §nis powered§r?");
        scene.idle(90);

        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.WEST))
                .placeNearTarget()
                .text("Or in other words, you want an inverted form of the gearshift?");
        scene.idle(70);
        //Redstone Torch
        scene.overlay.showText(55)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .attachKeyFrame()
                .placeNearTarget()
                .text("While you could use a redstone torch to do the same thing...");
        scene.idle(50);

        scene.world.moveSection(mainSection, util.vector.of(0, 2, 0), 15);
        scene.idle(10);
        scene.world.showSection(torchStuff, Direction.UP);
        scene.idle(10);

        scene.overlay.showText(45)
                .pointAt(util.vector.blockSurface(middleBlock.above(), Direction.WEST))
                .placeNearTarget()
                .text("This can easily be considered bulky depending on the machine your making.");

        scene.idle(55);
        scene.world.hideSection(torchStuff, Direction.SOUTH);
        scene.world.moveSection(mainSection, util.vector.of(0, -2, 0), 15);
        scene.idle(10);

        scene.overlay.showText(45)
                .pointAt(util.vector.blockSurface(middleBlock.above(), Direction.UP))
                .independent(2)
                .text("This is where the inverted gearshift comes into play.");
        scene.idle(55);

        //Inverted Gearshift
        scene.overlay.showText(35)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .attachKeyFrame()
                .placeNearTarget()
                .text("By right clicking a gearshift with a redstone torch...");
        scene.idle(45);
//right click with redstone torch
        scene.overlay.showControls(new InputWindowElement(util.vector.of(2, 2.5, 2), Pointing.DOWN).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH)), 30);
        scene.idle(15);
        scene.world.replaceBlocks(util.select.position(2,1,2),
                ModBlocks.INVERTED_GEARSHIFT.getDefaultState().
                        setValue(BlockStateProperties.POWERED, true)
                        .setValue(BlockStateProperties.AXIS, Direction.Axis.Z), true);
        //explain inverted gearshift
        scene.overlay.showText(45)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.WEST))
                .placeNearTarget()
                .text("...it will be converted into an inverted gearshift.");
        scene.idle(55);
        scene.overlay.showText(50)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted gearshift reverses rotation direction when §nnot powered§r...");
        scene.idle(25);

        scene.world.setBlock(util.grid.at(2, 2, 2),
                Blocks.REDSTONE_LAMP.defaultBlockState().setValue(BlockStateProperties.LIT, false), true);
        scene.idle(5);
        scene.world.setBlock(util.grid.at(2, 3, 2),
                Blocks.LEVER.defaultBlockState().setValue(BlockStateProperties.POWERED, false), true);
        scene.idle(25);

        scene.overlay.showText(50)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.WEST))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and acts like a shaft when it is §npowered§.");
        scene.idle(15);

        scene.world.setBlock(util.grid.at(2, 3, 2),
                Blocks.LEVER.defaultBlockState().setValue(BlockStateProperties.POWERED, true), false);
        scene.world.setBlock(util.grid.at(2, 2, 2),
                Blocks.REDSTONE_LAMP.defaultBlockState().setValue(BlockStateProperties.LIT, true), false);
        scene.idle(45);

        scene.overlay.showText(45)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .placeNearTarget()
                .text("Just like you wanted in the example from earlier!");
        scene.idle(55);

        scene.world.destroyBlock(util.grid.at(2, 3, 2));
        scene.world.destroyBlock(util.grid.at(2, 2, 2));
        scene.idle(10);

        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.WEST))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock, Direction.EAST))
                .placeNearTarget()
                .text("...it also means that you don't need to power the gearshift just to change the direction of rotation, compacting things further!");
        scene.idle(70);

//TODO: add scene where there is normal gearshift and inverted gearshift, with the gearshift powered and the inverted one not, to show your saving a lever.
//TODO: Fix ponder being entirely borken towards the end (spelling mistake on purpose)
    }
}
