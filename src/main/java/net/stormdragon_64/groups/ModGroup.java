package net.stormdragon_64.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stormdragon_64.block.ModBlocks;
import net.stormdragon_64.create_plus.CreatePlus;
public class ModGroup extends CreativeModeTab {
    //TODO: Fix Creative Mode Tab
    public static ModGroup MAIN_TAB;

    public ModGroup(String name) {
        super(CreatePlus.MOD_ID+":"+name);
        MAIN_TAB = this;
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModBlocks.BRASS_CHAIN_DRIVE.get());
    }
}
