package net.sudopos.create_ca.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.simibubi.create.infrastructure.ponder.scenes.ChainDriveScenes;
import com.simibubi.create.infrastructure.ponder.scenes.KineticsScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ProcessingScenes;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.sudopos.create_ca.ModBlocks;
import net.sudopos.create_ca.ModItems;
import net.sudopos.create_ca.features.brass_gearbox.BrassGearboxBlock;
import net.sudopos.create_ca.util.ISceneBuilder;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.AXIS;
import static net.sudopos.create_ca.features.brass_gearbox.BrassGearboxBlock.SHAFT_N;


public class ModPonderScenes {
    public static void invertedGearshift(ISceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        //define stuff
        BlockPos middleBlock = util.grid().at(2,1,2);
        BlockPos invertedBlock = middleBlock.above(2).west(2);
        Selection torchStuff = util.select()
                .fromTo(2, 2, 2, 4, 1, 2);
        Selection kineticPoweredSection = util.select()
                .fromTo(2, 3, 0, 2, 3 ,4);
        Selection leverSection = util.select().fromTo(2,4,2,2,5,2);



        ElementLink<WorldSectionElement> mainSection =
                scene.world().showIndependentSection(kineticPoweredSection, Direction.DOWN);


        //scene
        scene.title("inverted_gearshift", "Converting to and using Inverted Gearshifts");

        scene.showBasePlate();
        scene.idle(5);
        scene.world().moveSection(mainSection, util.vector().of(0, -2, 0), 20);
        scene.idle(15);
        //stuff, I guess


//explanation
        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock))
                .placeNearTarget()
                .text("While the gearshift is useful, it doesn't fit all use cases.");
        scene.idle(60);

        scene.overlay().showText(80)
                .placeNearTarget()
                .colored(PonderPalette.BLUE)
                .text("Often, you might wish for a gearshift that reverses the direction of rotation when §nnot powered§r, and acts like a shaft when it §nis powered§r, since it works better for your application.");
        scene.idle(90);

        scene.overlay().showText(60)
                .placeNearTarget()
                .text("Or in other words, you wish for an inverted form of a gearshift.");
        scene.idle(70);
        //Redstone Torch
        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock.above(1)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("You could use a redstone torch to do just that...");
        scene.idle(10);

        scene.world().moveSection(mainSection, util.vector().of(0, 2, 0), 15);
        scene.idle(10);
        scene.world().showSection(torchStuff, Direction.UP);
        scene.idle(45);


        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock.above(1)))
                .colored(PonderPalette.RED)
                .placeNearTarget()
                .text("However, this can easily be considered bulky depending on what you are making.");

        scene.idle(55);
        scene.world().hideSection(torchStuff, Direction.SOUTH);
        scene.idle(10);
        scene.world().moveSection(mainSection, util.vector().of(0, -2, 0), 15);
        scene.idle(10);

        scene.overlay().showText(45)
                .colored(PonderPalette.GREEN)
                .independent()
                .text("This is where the inverted gearshift comes into play.");
        scene.idle(55);

        //Inverted Gearshift
        scene.overlay().showText(35)
                .pointAt(util.vector().centerOf(middleBlock))
                .attachKeyFrame()
                .placeNearTarget()
                .text("By right clicking a gearshift with a redstone torch...");
        scene.idle(5);
//right click with redstone torch

        scene.overlay().showControls(util.vector().of(2, 2.5, 2), Pointing.DOWN, 30).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH));
        scene.idle(15);
        //Convert to inverted

        builder.hideIndependentSectionImmediately(mainSection);
        ElementLink<WorldSectionElement> invertedGearshift =
                scene.world().showIndependentSectionImmediately(util.select().fromTo(0, 3, 0, 0, 3 ,4));
        scene.world().moveSection(invertedGearshift, util.vector().of(2,-2,0), 0);
        //Apply effects of inversion
        scene.effects().indicateSuccess(middleBlock);


        scene.idle(25);

        //explain inverted gearshift
        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock))
                .colored(PonderPalette.GREEN)
                .placeNearTarget()
                .text("...it will be converted into an inverted gearshift.");
        scene.idle(60);
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));

        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted gearshift reverses rotation direction when §nnot powered§r...");
        scene.idle(10);
        ElementLink<WorldSectionElement> powerablelamp =
                scene.world().showIndependentSection(leverSection, Direction.DOWN);
        scene.world().moveSection(powerablelamp, util.vector().of(0,-2,0), 10);
        scene.idle(55);


        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and simply relays rotation when it §nis powered§.");

        scene.world().toggleRedstonePower(util.select().fromTo(2,5,2, 2,4,2).add(util.select().position(invertedBlock)));
scene.effects().indicateRedstone(middleBlock.atY(3));
        scene.world().modifyKineticSpeed(util.select().fromTo(0,3,2, 0,3,4), f -> -f);

        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));
        scene.idle(60);

        scene.world().hideIndependentSection(powerablelamp, Direction.UP);
        scene.world().toggleRedstonePower(util.select().position(invertedBlock));
        scene.world().modifyKineticSpeed(util.select().fromTo(0,3,2, 0,3,4), f -> -f);

        scene.idle(20);

        scene.overlay().showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay().showText(90)
                .placeNearTarget()
                .text("...it also means that you don't need to power the gearshift just to change the direction of rotation, compacting things further!");
        //Show both
        ElementLink<WorldSectionElement> mainSectionAgain =
                scene.world().showIndependentSectionImmediately(kineticPoweredSection);
        scene.world().modifyKineticSpeed(kineticPoweredSection, f -> -f);
        scene.world().moveSection(mainSectionAgain, util.vector().of(0,-2,0), 0);
        scene.world().moveSection(mainSectionAgain, util.vector().of(-1,0,0), 10);
        scene.world().moveSection(invertedGearshift, util.vector().of(1,0,0), 10);

        scene.idle(5);
        ElementLink<WorldSectionElement> powerableLampAgain =
                scene.world().showIndependentSectionImmediately(leverSection);
        scene.world().moveSection(powerableLampAgain, util.vector().of(-1,0,0), 0);
        scene.world().moveSection(powerableLampAgain, util.vector().of(0,-2,0), 10);
        scene.idle(10);
        scene.world().toggleRedstonePower(util.select().position(2,3,2));
        scene.effects().indicateRedstone(middleBlock.west());
        scene.world().modifyKineticSpeed(util.select().fromTo(2,3,2, 2,3,4), f -> -f);
        scene.idle(10);
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(util.grid().at(2,3,4), middleBlock.south(2).west(1));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(util.grid().at(0,3,4), middleBlock.south(2).east(1));

        scene.idle(140);
        scene.markAsFinished();
    }










    //I know it's copy and pasted but the ponder system doesn't allow you to make a modified version of another ponder without doing it this way


    public static void invertedClutch(ISceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        //define stuff
        BlockPos middleBlock = util.grid().at(2,1,2);
        BlockPos invertedBlock = middleBlock.above(2).west(2);
        Selection torchStuff = util.select()
                .fromTo(2, 2, 2, 4, 1, 2);
        Selection kineticPoweredSection = util.select()
                .fromTo(2, 3, 0, 2, 3 ,4);
        Selection leverSection = util.select().fromTo(2,4,2,2,5,2);



        ElementLink<WorldSectionElement> mainSection =
                scene.world().showIndependentSection(kineticPoweredSection, Direction.DOWN);


        //scene
        scene.title("inverted_clutch", "Converting to and using Inverted Clutches");
        scene.rotateCameraY(-90.0F);

        scene.showBasePlate();
        scene.idle(5);
        scene.world().moveSection(mainSection, util.vector().of(0, -2, 0), 20);
        scene.idle(15);
        //stuff, I guess


//explanation
        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock))
                .placeNearTarget()
                .text("While the clutch is useful, it doesn't fit all use cases.");
        scene.idle(60);

        scene.overlay().showText(80)
                .placeNearTarget()
                .colored(PonderPalette.BLUE)
                .text("Often, you might wish for a clutch that blocks rotation when §nnot powered§r, and acts like a shaft when it §nis powered§r, since it works better for your application.");
        scene.idle(90);

        scene.overlay().showText(60)
                .placeNearTarget()
                .text("Or in other words, you wish for an inverted form of a clutch.");
        scene.idle(70);
        //Redstone Torch
        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock.above(1)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("You could use a redstone torch to do just that...");
        scene.idle(10);

        scene.world().moveSection(mainSection, util.vector().of(0, 2, 0), 15);
        scene.idle(10);
        scene.world().showSection(torchStuff, Direction.UP);
        scene.idle(45);


        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock.above(1)))
                .colored(PonderPalette.RED)
                .placeNearTarget()
                .text("However, this can easily be considered bulky depending on what you are making.");

        scene.idle(55);
        scene.world().hideSection(torchStuff, Direction.SOUTH);
        scene.idle(10);
        scene.world().moveSection(mainSection, util.vector().of(0, -2, 0), 15);
        scene.idle(10);

        scene.overlay().showText(45)
                .colored(PonderPalette.GREEN)
                .independent()
                .text("This is where the inverted clutch comes into play.");
        scene.idle(55);

        //Inverted Gearshift
        scene.overlay().showText(35)
                .pointAt(util.vector().centerOf(middleBlock))
                .attachKeyFrame()
                .placeNearTarget()
                .text("By right clicking a clutch with a redstone torch...");
        scene.idle(5);
//right click with redstone torch

        scene.overlay().showControls(util.vector().of(2, 2.5, 2), Pointing.DOWN, 30).rightClick()
                .withItem(new ItemStack(Items.REDSTONE_TORCH));
        scene.idle(15);
        //Convert to inverted

        builder.hideIndependentSectionImmediately(mainSection);
        ElementLink<WorldSectionElement> invertedClutch =
                scene.world().showIndependentSectionImmediately(util.select().fromTo(0, 3, 0, 0, 3 ,4));
        scene.world().toggleRedstonePower(util.select().position(invertedBlock));
        scene.world().modifyKineticSpeed(util.select().fromTo(0,3,3, 0,3,4), f -> 0f);
        scene.world().moveSection(invertedClutch, util.vector().of(2,-2,0), 0);
        //Apply effects of inversion
        scene.effects().indicateSuccess(middleBlock);


        scene.idle(25);

        //explain inverted clutch
        scene.overlay().showText(45)
                .pointAt(util.vector().centerOf(middleBlock))
                .colored(PonderPalette.GREEN)
                .placeNearTarget()
                .text("...it will be converted into an inverted clutch.");
        scene.idle(60);
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));

        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("An inverted clutch prevents rotation when §nnot powered§r...");
        scene.idle(10);
        ElementLink<WorldSectionElement> powerablelamp =
                scene.world().showIndependentSection(leverSection, Direction.DOWN);
        scene.world().moveSection(powerablelamp, util.vector().of(0,-2,0), 10);
        scene.idle(55);


        scene.overlay().showText(50)
                .pointAt(util.vector().centerOf(middleBlock.south(2)))
                .attachKeyFrame()
                .placeNearTarget()
                .text("...and simply relays rotation when it §nis powered§.");

        scene.world().toggleRedstonePower(util.select().fromTo(2,5,2, 2,4,2).add(util.select().position(invertedBlock)));
        scene.effects().indicateRedstone(middleBlock.atY(3));
        scene.world().setKineticSpeed(util.select().fromTo(0,3,2, 0,3,4), -32f);

        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.south(2), middleBlock.south(2));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(invertedBlock.north(2), middleBlock.north(2));
        scene.idle(60);

        scene.world().hideIndependentSection(powerablelamp, Direction.UP);
        scene.world().toggleRedstonePower(util.select().position(invertedBlock));
        scene.world().modifyKineticSpeed(util.select().fromTo(0,3,3, 0,3,4), f -> 0f);

        scene.idle(20);

        scene.overlay().showText(60)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Not only does this mean that we don't need that bulky redstone torch setup anymore...");
        scene.idle(70);

        scene.overlay().showText(90)
                .placeNearTarget()
                .text("...it also means that you don't need to power the clutch just to prevent rotation, compacting things further!");
        //Show both
        ElementLink<WorldSectionElement> mainSectionAgain =
                scene.world().showIndependentSectionImmediately(kineticPoweredSection);
        scene.world().moveSection(mainSectionAgain, util.vector().of(0,-2,0), 0);
        scene.world().moveSection(mainSectionAgain, util.vector().of(-1,0,0), 10);
        scene.world().moveSection(invertedClutch, util.vector().of(1,0,0), 10);

        scene.idle(5);
        ElementLink<WorldSectionElement> powerableLampAgain =
                scene.world().showIndependentSectionImmediately(leverSection);
        scene.world().moveSection(powerableLampAgain, util.vector().of(-1,0,0), 0);
        scene.world().moveSection(powerableLampAgain, util.vector().of(0,-2,0), 10);
        scene.idle(10);
        scene.world().toggleRedstonePower(util.select().position(2,3,2));
        scene.effects().indicateRedstone(middleBlock.west());
        scene.world().modifyKineticSpeed(util.select().fromTo(2,3,3, 2,3,4), f -> 0f);

        scene.idle(10);
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(util.grid().at(2,3,4), middleBlock.south(2).west(1));
        ((ISceneBuilder) scene.effects()).rotationDirectionIndicator(util.grid().at(0,3,4), middleBlock.south(2).east(1));

        scene.idle(140);
        scene.markAsFinished();
    }


//End of scene







    public static void brassGearbox(ISceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        //setup
        Selection secondBelt = util.select().fromTo(2,3,3, 0,0,3)
                .substract(util.select().fromTo(2,1,3, 1,1,3));

        scene.title("brass_gearbox", "Covering the shafts of a Brass Gearbox.");
        scene.setSceneOffsetY(-2);
        scene.removeShadow();
        scene.world().showSection(util.select().layers(0, 4).substract(secondBelt), Direction.UP);


        BlockPos middleBlock = util.grid().at(3,3,3);
        BlockPos inputShaft = util.grid().at(3,3,2);

        scene.world().modifyBlockEntity(middleBlock, GearboxBlockEntity.class, be -> be.source=inputShaft);
        //Actual scene
        scene.idle(10);
        scene.overlay().showText(65)
                .text("The brass gearbox behaves exactly like an andesite gearbox by default.")
                .pointAt(util.vector().centerOf(middleBlock));

        scene.idle(10);
        scene.effects().rotationSpeedIndicator(inputShaft);
        scene.effects().rotationSpeedIndicator(util.grid().at(3,3, 5));
        scene.effects().rotationSpeedIndicator(util.grid().at(5,3,3));

        scene.idle(60);
        scene.overlay().showText(60)
                .text("However, it does have some additional functionality available: side blocking!")
                .independent()
                        .colored(PonderPalette.GREEN);
        scene.idle(70);
        scene.overlay().showText(60)
                .text("By right clicking the side of a brass gearbox with brass casing...")
                .pointAt(util.vector().blockSurface(middleBlock, Direction.DOWN))
                .attachKeyFrame();
        scene.idle(20);
        scene.overlay().showControls(util.vector().of(4, 3.5, 3), Pointing.RIGHT, 30).rightClick()
                .withItem(new ItemStack(AllBlocks.BRASS_CASING.get().asItem()));
        scene.idle(15);
        scene.world().modifyKineticSpeed(util.select().fromTo(3,3,3,3,3,5).add(util.select().fromTo(4,3,3,5,3,3)), f -> 0f);
        scene.world().setBlock(middleBlock, ModBlocks.BRASS_GEARBOX.getDefaultState().setValue(AXIS, Direction.Axis.Y).setValue(SHAFT_N, false), true);
        scene.idle(35);
        scene.overlay().showText(60)
                .text("...that side will be blocked.")
                .pointAt(util.vector().blockSurface(middleBlock, Direction.NORTH))
                .placeNearTarget()
                .colored(PonderPalette.BLUE);
        scene.idle(70);
        scene.overlay().showText(60)
                .text("Blocking one of the sides of a brass gearbox will stop rotation from transferring to...")
                .pointAt(util.vector().blockSurface(middleBlock, Direction.NORTH))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(10);
        scene.effects().rotationSpeedIndicator(inputShaft);
        scene.effects().rotationSpeedIndicator(util.grid().at(3,3, 5));
        scene.effects().rotationSpeedIndicator(util.grid().at(5,3,3));
        scene.idle(65);
        scene.rotateCameraY(-180.0F);
        scene.idle(15);
        scene.world().showSection(secondBelt, Direction.EAST);
        scene.idle(16);
        scene.world().setKineticSpeed(util.select().fromTo(3,3,3,3,3,5), -32f);
        scene.world().setKineticSpeed(util.select().fromTo(4,3,3,5,3,3), 32f);
        scene.world().modifyBlockEntity(middleBlock, GearboxBlockEntity.class, be -> be.source=util.grid().at(2,3,3));
        scene.effects().rotationSpeedIndicator(util.grid().at(2,3, 3));
        scene.idle(20);
        scene.overlay().showText(60)
                .text("...and from a brass gearbox.")
                .pointAt(util.vector().blockSurface(middleBlock, Direction.SOUTH))
                .placeNearTarget();
        scene.idle(20);
        scene.overlay().showControls(util.vector().of(3, 3.5, 4), Pointing.RIGHT, 30).rightClick()
                .withItem(new ItemStack(AllBlocks.BRASS_CASING.get().asItem()));
        scene.world().modifyKineticSpeed(util.select().fromTo(3,3,4,3,3,5), f -> 0f);
        scene.world().setBlock(middleBlock, ModBlocks.BRASS_GEARBOX.getDefaultState().setValue(AXIS, Direction.Axis.Y).setValue(SHAFT_N, false).setValue(BrassGearboxBlock.SHAFT_S, false), true);
        scene.idle(10);
        scene.effects().rotationSpeedIndicator(util.grid().at(3,3, 5));
        scene.effects().rotationSpeedIndicator(util.grid().at(5,3,3));
        scene.idle(50);
        scene.overlay().showText(100)
                .text("In order to unblock the side of a brass gearbox, just click the side you no longer want to be blocked with brass casing again.")
                .pointAt(util.vector().blockSurface(middleBlock, Direction.SOUTH))
                .placeNearTarget()
                .attachKeyFrame()
                .colored(PonderPalette.BLUE);
        scene.idle(20);
        scene.overlay().showControls(util.vector().of(3, 3.5, 4), Pointing.RIGHT, 30).rightClick()
                .withItem(new ItemStack(AllBlocks.BRASS_CASING.get().asItem()));
        scene.world().setKineticSpeed(util.select().fromTo(3,3,4,3,3,5), -32f);
        scene.world().setBlock(middleBlock, ModBlocks.BRASS_GEARBOX.getDefaultState().setValue(AXIS, Direction.Axis.Y).setValue(SHAFT_N, false), true);
        scene.effects().rotationSpeedIndicator(util.grid().at(3,3, 5));
        scene.idle(10);

    }

    // Wrapper methods so I can mixin hideIndependentSectionImmediately() back into existence without it breaking everything else

    public static void invertedGearshiftWrapper(SceneBuilder builder, SceneBuildingUtil util) {
        invertedGearshift((ISceneBuilder) builder, util);
    }

    public static void invertedClutchWrapper(SceneBuilder builder, SceneBuildingUtil util) {
        invertedClutch((ISceneBuilder) builder, util);
    }

    public static void brassGearboxWrapper(SceneBuilder builder, SceneBuildingUtil util) {
        brassGearbox((ISceneBuilder) builder, util);
    }

    //Assign Ponder scenes to different blocks.

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("gearbox", KineticsScenes::gearbox, AllCreatePonderTags.KINETIC_RELAYS);

        //Give blocks Create's ponders
        HELPER.addStoryBoard(ModBlocks.BRASS_CHAIN_DRIVE, "chain_drive/relay", ChainDriveScenes::chainDriveAsRelay,
                AllCreatePonderTags.KINETIC_RELAYS);
        HELPER.forComponents(ModBlocks.BRASS_CHAIN_DRIVE, ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                        .addStoryBoard("chain_drive/gearshift", ChainDriveScenes::adjustableChainGearshift, AllCreatePonderTags.KINETIC_RELAYS);
        HELPER.forComponents(ModBlocks.BRASS_BASIN)
                .addStoryBoard("basin", ProcessingScenes::basin)
                .addStoryBoard("mechanical_mixer/mixing", ProcessingScenes::mixing)
                .addStoryBoard("mechanical_press/compacting", ProcessingScenes::compacting);

        //Give blocks my ponders
        HELPER.forComponents(ModBlocks.INVERTED_GEARSHIFT, AllBlocks.GEARSHIFT)
                .addStoryBoard("inverted_gearshift", ModPonderScenes::invertedGearshiftWrapper, AllCreatePonderTags.KINETIC_RELAYS);

        HELPER.forComponents(ModBlocks.INVERTED_CLUTCH, AllBlocks.CLUTCH)
                .addStoryBoard("inverted_clutch", ModPonderScenes::invertedClutchWrapper, AllCreatePonderTags.KINETIC_RELAYS);

        HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("brass_gearbox", ModPonderScenes::brassGearboxWrapper, AllCreatePonderTags.KINETIC_RELAYS);

    }
}
