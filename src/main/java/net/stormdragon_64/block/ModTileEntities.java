package net.stormdragon_64.block;

import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.relays.encased.ShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.ShaftRenderer;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxInstance;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxRenderer;
import com.simibubi.create.content.contraptions.relays.gearbox.GearboxTileEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;




public class ModTileEntities {
    public static final BlockEntityEntry<KineticTileEntity> CUSTOM_CHAIN_DRIVE = Create.REGISTRATE
            .tileEntity("custom_chain_drive", KineticTileEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(ModBlocks.BRASS_CHAIN_DRIVE)
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<GearboxTileEntity> CUSTOM_GEARBOX = Create.REGISTRATE
            .tileEntity("custom_gearbox", GearboxTileEntity::new)
            .instance(() -> GearboxInstance::new, false)
            .validBlocks(ModBlocks.BRASS_GEARBOX)
            .renderer(() -> GearboxRenderer::new)
            .register();
    public static void register() {}
}
