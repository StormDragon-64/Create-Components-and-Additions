package net.sshmoob.create_ca.content.variants;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.sshmoob.create_ca.ModBlockEntities;

public class BrassBasinBlock extends BasinBlock implements IBE<BasinBlockEntity>, IWrenchable {

    public BrassBasinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntityType<? extends BasinBlockEntity> getBlockEntityType() {
        return ModBlockEntities.BRASS_BASIN.get();
    }
}
