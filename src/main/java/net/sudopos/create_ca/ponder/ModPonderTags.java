package net.sudopos.create_ca.ponder;


import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.sudopos.create_ca.ModBlocks;
import net.sudopos.create_ca.ModItems;

import static com.simibubi.create.infrastructure.ponder.AllCreatePonderTags.KINETIC_RELAYS;


public class ModPonderTags {

    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

       HELPER.addToTag(KINETIC_RELAYS)
                .add(ModItems.VERTICAL_BRASS_GEARBOX)
                .add(ModBlocks.BRASS_CHAIN_DRIVE)
                .add(ModBlocks.INVERTED_CLUTCH)
                .add(ModBlocks.INVERTED_GEARSHIFT)
                .add(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
                .add(ModBlocks.BRASS_GEARBOX);
    }
}
