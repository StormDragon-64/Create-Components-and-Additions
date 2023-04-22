package net.stormdragon_64.create_plus;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stormdragon_64.block.ModBlocks;

public class ModGroup{
        public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("create_plus") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ModBlocks.BRASS_CHAIN_DRIVE.get());
            }
        };
    }

