package net.stormdragon_64.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;
import com.simibubi.create.foundation.ponder.content.ChainDriveScenes;
import com.simibubi.create.foundation.ponder.content.KineticsScenes;
import net.stormdragon_64.block.ModBlocks;
import net.stormdragon_64.create_plus.CreatePlus;
import net.stormdragon_64.item.ModItems;


public class PonderAssigner {
    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(CreatePlus.MOD_ID);
    static final PonderRegistrationHelper CMI_HELPER = new PonderRegistrationHelper(Create.ID);

    public static void register() {
        HELPER.forComponents(AllBlocks.GEARSHIFT, ModBlocks.INVERTED_GEARSHIFT)
                .addStoryBoard("inverted_gearshift", PonderScenes::invertedGearshift, PonderTag.KINETIC_RELAYS);

        //Give blocks create's ponders
        CMI_HELPER.forComponents(ModBlocks.BRASS_GEARBOX, ModItems.VERTICAL_BRASS_GEARBOX)
                .addStoryBoard("gearbox", KineticsScenes::gearbox);

        CMI_HELPER.addStoryBoard(ModBlocks.BRASS_CHAIN_DRIVE, "chain_drive/relay", ChainDriveScenes::chainDriveAsRelay,
                PonderTag.KINETIC_RELAYS);
        CMI_HELPER.forComponents(ModBlocks.BRASS_CHAIN_DRIVE, ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .addStoryBoard("chain_drive/gearshift", ChainDriveScenes::adjustableChainGearshift, PonderTag.KINETIC_RELAYS);

    }


    public static void registerTags() {

        PonderRegistry.TAGS.forTag(PonderTag.KINETIC_RELAYS)
                .add(ModBlocks.INVERTED_GEARSHIFT)
                .add(ModBlocks.INVERTED_CLUTCH)
                .add(ModBlocks.BRASS_CHAIN_DRIVE)
                .add(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .add(ModBlocks.BRASS_GEARBOX)
                .add(ModItems.VERTICAL_BRASS_GEARBOX);

    }
}
