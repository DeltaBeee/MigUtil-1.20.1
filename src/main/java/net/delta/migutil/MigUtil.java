package net.delta.migutil;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MigUtil.MOD_ID)
public class MigUtil {
    public static final String MOD_ID = "migutil";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MigUtil() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Adds everything to Search Tab, since I'm too lazy to /give during debug.
        /*if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            List<Item> items = ItemInit.ITEMS.getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .toList();
            for (Item item : items) {
                event.accept(item);
            }
        }*/
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // When you boot up a server, the mod will send the following message in the log.
        LOGGER.info("Nice JVM you got here...");
    }
}
