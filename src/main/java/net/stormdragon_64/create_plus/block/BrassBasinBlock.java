package net.stormdragon_64.create_plus.block;

import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.stormdragon_64.create_plus.block_entity.ModBlockEntities;

public class BrassBasinBlock extends BasinBlock {
    public BrassBasinBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public BlockEntityType<? extends BasinBlockEntity> getBlockEntityType() {
        return ModBlockEntities.BRASS_BASIN.get();
    }

}
