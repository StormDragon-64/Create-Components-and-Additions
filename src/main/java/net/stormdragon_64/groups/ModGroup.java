package net.stormdragon_64.groups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stormdragon_64.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class ModGroup extends CreativeModeTab {
    public static ModGroup MAIN_TAB;

    public ModGroup(String name) {
        super("Create++");
        MAIN_TAB = this;
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModBlocks.BRASS_CHAIN_DRIVE.get());
    }
}
