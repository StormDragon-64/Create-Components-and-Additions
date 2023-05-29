package net.stormdragon_64.create_plus.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.infrastructure.ponder.AllPonderTags;
import com.simibubi.create.infrastructure.ponder.scenes.ChainDriveScenes;
import com.simibubi.create.infrastructure.ponder.scenes.KineticsScenes;
import net.stormdragon_64.create_plus.CreatePlus;
import net.stormdragon_64.create_plus.block.ModBlocks;
import net.stormdragon_64.create_plus.item.ModItems;


public class PonderAssigner {
    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(CreatePlus.MOD_ID);
    //Allows access to Create's schematics, so that it's not just a storyboard narrating the void.
    static final PonderRegistrationHelper CI_HELPER = new PonderRegistrationHelper(Create.ID);


    public static void register() {
        HELPER.forComponents(AllBlocks.GEARSHIFT, ModBlocks.INVERTED_GEARSHIFT)
                .addStoryBoard("inverted_gearshift", PonderScenes::invertedGearshift, AllPonderTags.KINETIC_RELAYS);

        //Give blocks Create's ponders
        CI_HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("gearbox", KineticsScenes::gearbox);

        CI_HELPER.addStoryBoard(ModBlocks.BRASS_CHAIN_DRIVE, "chain_drive/relay", ChainDriveScenes::chainDriveAsRelay,
                AllPonderTags.KINETIC_RELAYS);
        CI_HELPER.forComponents(ModBlocks.BRASS_CHAIN_DRIVE, ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .addStoryBoard("chain_drive/gearshift", ChainDriveScenes::adjustableChainGearshift, AllPonderTags.KINETIC_RELAYS);

    }
}
