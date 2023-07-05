package net.stormdragon_64.create_plus;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stormdragon_64.create_plus.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class ModGroup{
        public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("create_plus") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(ModBlocks.BRASS_GEARBOX.get());
            }
        };
    }

