package net.delta.migutil.datagen;

import net.delta.migutil.MigUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateGenerator extends BlockStateProvider {
    public ModBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MigUtil.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
