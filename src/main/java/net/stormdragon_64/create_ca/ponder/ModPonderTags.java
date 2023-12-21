package net.stormdragon_64.create_ca.ponder;

import com.simibubi.create.foundation.ponder.PonderRegistry;
import net.stormdragon_64.create_ca.block.ModBlocks;
import net.stormdragon_64.create_ca.item.ModItems;

import static com.simibubi.create.infrastructure.ponder.AllPonderTags.KINETIC_RELAYS;

public class ModPonderTags {
    public static void register() {
        PonderRegistry.TAGS.forTag(KINETIC_RELAYS)
                .add(ModItems.VERTICAL_BRASS_GEARBOX)
                .add(ModBlocks.BRASS_CHAIN_DRIVE)
                .add(ModBlocks.INVERTED_CLUTCH)
                .add(ModBlocks.INVERTED_GEARSHIFT)
                .add(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .add(ModBlocks.BRASS_GEARBOX);
    }
}
