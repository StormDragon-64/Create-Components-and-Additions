package net.sshmoob.create_ca;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simibubi.create.AllCreativeModeTabs.PALETTES_CREATIVE_TAB;
import static net.minecraft.network.chat.Component.translatable;

public class ModCreativeTab {

    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCA.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_MODE_TAB = REGISTER.register("create_ca",
            () -> CreativeModeTab.builder()
                    .title(translatable("itemGroup.create_ca"))
                    .withTabsBefore(PALETTES_CREATIVE_TAB.getKey())
                    .icon(ModBlocks.BRASS_GEARBOX::asStack)
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.BRASS_BASIN, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModBlocks.BRASS_GEARBOX, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModItems.VERTICAL_BRASS_GEARBOX, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModBlocks.BRASS_CHAIN_DRIVE, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModBlocks.INVERTED_CLUTCH, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                        output.accept(ModBlocks.INVERTED_GEARSHIFT, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }

}

