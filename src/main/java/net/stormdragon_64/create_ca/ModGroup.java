package net.stormdragon_64.create_ca;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stormdragon_64.create_ca.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class ModGroup{
        public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("create_ca") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(ModBlocks.BRASS_GEARBOX.get());
            }
        };
    }

