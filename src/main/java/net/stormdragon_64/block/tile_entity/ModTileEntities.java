package net.stormdragon_64.block.tile_entity;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.*;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxInstance;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxRenderer;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxTileEntity;
import com.simibubi.create.content.contraptions.relays.gearbox.GearshiftTileEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.stormdragon_64.block.ModBlocks;

import static com.simibubi.create.Create.REGISTRATE;


public class ModTileEntities {
    public static final BlockEntityEntry<KineticTileEntity> CUSTOM_CHAIN_DRIVE = REGISTRATE
            .tileEntity("custom_chain_drive", KineticTileEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.BRASS_CHAIN_DRIVE)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<GearboxTileEntity> CUSTOM_GEARBOX = REGISTRATE
            .tileEntity("custom_gearbox", GearboxTileEntity::new)
            .instance(() -> GearboxInstance::new, false)
            .validBlocks(ModBlocks.BRASS_GEARBOX)
            .renderer(() -> GearboxRenderer::new)
            .register();

    public static final BlockEntityEntry<GearshiftTileEntity> CUSTOM_GEARSHIFT = REGISTRATE
            .tileEntity("custom_gearshift", GearshiftTileEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_GEARSHIFT)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    /* temp disabled
    public static final BlockEntityEntry<ClutchTileEntity> CUSTOM_CLUTCH = REGISTRATE
            .tileEntity("custom_clutch", ClutchTileEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(ModBlocks.INVERTED_CLUTCH)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    */


    public static final BlockEntityEntry<AdjustablePulleyTileEntity> CUSTOM_ADJUSTABLE_PULLEY = REGISTRATE
            .tileEntity("custom_adjustable_pulley", AdjustablePulleyTileEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.ADJUSTABLE_BRASS_CHAIN_GEARSHIFT)
            .renderer(() -> ShaftRenderer::new)
            .register();



    //Register method - Important!
    public static void register() {}
}
