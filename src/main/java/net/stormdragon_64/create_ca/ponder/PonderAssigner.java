package net.stormdragon_64.create_ca.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.infrastructure.ponder.AllPonderTags;
import com.simibubi.create.infrastructure.ponder.scenes.ChainDriveScenes;
import com.simibubi.create.infrastructure.ponder.scenes.KineticsScenes;
import com.simibubi.create.infrastructure.ponder.scenes.ProcessingScenes;
import net.stormdragon_64.create_ca.block.ModBlocks;
import net.stormdragon_64.create_ca.item.ModItems;


public class PonderAssigner {
    //Allows access to schematics included in Create
    static final PonderRegistrationHelper CREATE_HELPER = new PonderRegistrationHelper("create");
    //Gets schematics from my namespace
    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper("create_ca");



    public static void register() {
        //Fix ponder ordering by redefining Create's ponders before defining my ponders
        CREATE_HELPER.addStoryBoard(AllBlocks.GEARSHIFT, "gearshift", KineticsScenes::gearshift, AllPonderTags.KINETIC_RELAYS);
        CREATE_HELPER.addStoryBoard(AllBlocks.CLUTCH, "clutch", KineticsScenes::clutch, AllPonderTags.KINETIC_RELAYS);
        CREATE_HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("gearbox", KineticsScenes::gearbox, AllPonderTags.KINETIC_RELAYS);
        //Give blocks Create's ponders


        CREATE_HELPER.addStoryBoard(ModBlocks.BRASS_CHAIN_DRIVE, "chain_drive/relay", ChainDriveScenes::chainDriveAsRelay,
                AllPonderTags.KINETIC_RELAYS);
        CREATE_HELPER.forComponents(ModBlocks.BRASS_CHAIN_DRIVE, ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .addStoryBoard("chain_drive/gearshift", ChainDriveScenes::adjustableChainGearshift, AllPonderTags.KINETIC_RELAYS);
        CREATE_HELPER.forComponents(ModBlocks.BRASS_BASIN)
                .addStoryBoard("basin", ProcessingScenes::basin)
                .addStoryBoard("mechanical_mixer/mixing", ProcessingScenes::mixing)
                .addStoryBoard("mechanical_press/compacting", ProcessingScenes::compacting);

        //Give blocks my ponders

        HELPER.forComponents(ModBlocks.INVERTED_GEARSHIFT, AllBlocks.GEARSHIFT)
                .addStoryBoard("inverted_gearshift", PonderScenes::invertedGearshift, AllPonderTags.KINETIC_RELAYS);

        HELPER.forComponents(ModBlocks.INVERTED_CLUTCH, AllBlocks.CLUTCH)
                .addStoryBoard("inverted_clutch", PonderScenes::invertedClutch, AllPonderTags.KINETIC_RELAYS);

        HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("brass_gearbox", PonderScenes::brassGearbox, AllPonderTags.KINETIC_RELAYS);

    }
}
