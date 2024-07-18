package net.delta.migutil.datagen.no_touch;

import net.delta.migutil.MigUtil;
import net.delta.migutil.datagen.ModBlockStateGenerator;
import net.delta.migutil.datagen.ModBlockTagGenerator;
import net.delta.migutil.datagen.ModItemModelGenerator;
import net.delta.migutil.datagen.ModRecipeGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MigUtil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), ModLootTableGenerator.create(output));
        generator.addProvider(event.includeServer(), new ModRecipeGenerator(output));
        generator.addProvider(event.includeServer(), new ModBlockTagGenerator(output, lookupProvider, helper));

        generator.addProvider(event.includeClient(), new ModItemModelGenerator(output, helper));
        generator.addProvider(event.includeClient(), new ModBlockStateGenerator(output, helper));
    }
}
