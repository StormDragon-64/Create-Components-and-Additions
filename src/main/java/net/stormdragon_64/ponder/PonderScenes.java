package net.stormdragon_64.ponder;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.Selection;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.stormdragon_64.block.ModBlocks;


public class PonderScenes {
    public static void invertedGearshift(SceneBuilder scene, SceneBuildingUtil util) {
        //show scene
        scene.title("inverted_gearshift", "Using Inverted Gearshifts");
        scene.showBasePlate();
        scene.idle(10);
        scene.world.showSection(util.select.layersFrom(1), Direction.DOWN);
        //stuff, I guess
        BlockPos middleBlock = util.grid.at(2,1,2);
        Selection torchStuff = util.select
        .fromTo(3, 2, 1, 3, 3 ,5)
        .add(util.select.fromTo(4, 1, 3, 5, 1, 3));
//explanation
        scene.overlay.showText(70)
                .pointAt(util.vector.blockSurface(middleBlock.west(), Direction.WEST))
                .placeNearTarget()
                .text("There is one problem you might face with the Gearshift, however; What if you want to it to always be on and turn off when powered?");
        scene.idle(75);
        //Redstone Torch
        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock.east(), Direction.EAST))
                .placeNearTarget()
                .text("While you could use a redstone torch... ");


        //Inverted Gearshift
        scene.overlay.showText(35)
                .pointAt(util.vector.blockSurface(middleBlock.west(), Direction.WEST))
                .placeNearTarget()
                .text("By right clicking a gearshift with a redstone torch...");
        scene.idle(36);
//right click with redstone torch
        scene.overlay.showControls(new InputWindowElement(util.vector.of(2, 2.5, 2), Pointing.DOWN).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH)), 30);
        scene.idle(15);
        scene.world.replaceBlocks(util.select.position(2,1,2),
                ModBlocks.INVERTED_GEARSHIFT.getDefaultState().
                        setValue(BlockStateProperties.POWERED, true)
                        .setValue(BlockStateProperties.AXIS, Direction.Axis.Z), true);
        //explain inverted gearshift
        scene.overlay.showText(30)
                .pointAt(util.vector.blockSurface(middleBlock.east(), Direction.EAST))
                .placeNearTarget()
                .text("You'll get an inverted gearshift.");
        scene.idle(35);
        scene.overlay.showText(50)
                .pointAt(util.vector.blockSurface(middleBlock.west(), Direction.WEST))
                .placeNearTarget()
                .text("An inverted gearshift reverses rotation direction when not powered and acts like a shaft when powered.");
        scene.idle(55);
        scene.overlay.showText(60)
                .pointAt(util.vector.blockSurface(middleBlock.east(), Direction.EAST))
                .placeNearTarget()
                .text("Not only does this mean that ");
        scene.idle(65);



    }
}
