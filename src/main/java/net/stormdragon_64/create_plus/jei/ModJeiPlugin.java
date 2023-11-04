package net.stormdragon_64.create_plus.jei;

import com.progwml6.ironchest.common.block.IronChestsBlocks;
import de.maxhenkel.easyvillagers.items.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class ModJeiPlugin implements IModPlugin {

    private static final ResourceLocation UID = new ResourceLocation("create_plus", "create_plus");
    List<ItemStack> disabledItems = new ArrayList<>();



    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }
    //@Override

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        //list of disabled items
        //easy villagers
        disabledItems.add(ModItems.FARMER.get().asItem().getDefaultInstance());
        disabledItems.add(ModItems.IRON_FARM.get().asItem().getDefaultInstance());
        //storage drawers
        disabledItems.add(com.jaquadro.minecraft.storagedrawers.core.ModItems.OBSIDIAN_STORAGE_UPGRADE.get().asItem().getDefaultInstance());
        disabledItems.add(com.jaquadro.minecraft.storagedrawers.core.ModItems.IRON_STORAGE_UPGRADE.get().asItem().getDefaultInstance());
        disabledItems.add(com.jaquadro.minecraft.storagedrawers.core.ModItems.GOLD_STORAGE_UPGRADE.get().asItem().getDefaultInstance());
        disabledItems.add(com.jaquadro.minecraft.storagedrawers.core.ModItems.EMERALD_STORAGE_UPGRADE.get().asItem().getDefaultInstance());
        // iron chests - regular
        disabledItems.add(IronChestsBlocks.DIRT_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.COPPER_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.IRON_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.GOLD_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.DIAMOND_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.CRYSTAL_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.OBSIDIAN_CHEST.get().asItem().getDefaultInstance());
        //iron chests - trapped
        disabledItems.add(IronChestsBlocks.TRAPPED_DIRT_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_COPPER_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_IRON_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_GOLD_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_DIAMOND_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_CRYSTAL_CHEST.get().asItem().getDefaultInstance());
        disabledItems.add(IronChestsBlocks.TRAPPED_OBSIDIAN_CHEST.get().asItem().getDefaultInstance());
        //iron chests - upgrades
//WHERE ARE THESE REGISTERED
        //I CAN'T FIGURE IT OUT
//PLEASE SEND HELP

        //actually disable the items from showing in JEI
        registration.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, disabledItems);
    }
}

