package net.delta.migutil.datagen;

import net.delta.migutil.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //this.dropSelf(DBlocks.EXAMPLE_BLOCK.get());  <-- Makes EXAMPLE_BLOCK drop itself when mined.
        //this.add(DBlocks.EXAMPLE_ORE.get(), block -> createOreDrop(DBlocks.EXAMPLE_ORE.get(), DItems.EXAMPLE_ITEM.get())); <-- Makes EXAMPLE_ORE drop EXAMPLE_ITEM, or itself with silk touch.

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
