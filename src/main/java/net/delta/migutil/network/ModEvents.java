package net.delta.migutil.network;

import com.mojang.logging.LogUtils;
import net.delta.migutil.MigUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = MigUtil.MOD_ID)
public class ModEvents {
    // MAKE SURE TO CHECK THE CLASS OF THE EVENT YOU WISH TO MODIFY FOR THE FOLLOWING INFO:
    // Bus Type ("This event is fired on [INSERT BUS]") -- Mod Event Bus, Forge Event Bus.
    // Cancellability ("This event is cancellable") -- Yes or No.
    // Result ("This event does not have a result type") -- Yes or No.
    // Optional: Client (Check package of event class) -- Let's not clog the server with clientside events.
    private static final Logger LOGGER = LogUtils.getLogger();

    @Mod.EventBusSubscriber(modid = MigUtil.MOD_ID)
    public static class ForgeBusEvents {
        /** Events related to actions in the world. Handles things like when an entity is hurt or when a player joins the world. **/
        /* Add Forge Events below this line please */



        /* Add Forge Events above this line please */
    }

    @Mod.EventBusSubscriber(modid = MigUtil.MOD_ID, value = Dist.CLIENT)
    public static class ForgeClientEvents {
        /** Events related to client-specific actions in a game. Handles things like when the user presses a key. **/
        /* Add Client-Side Forge Events below this line please */



        /* Add Client-Side Forge Events above this line please */
    }

    @Mod.EventBusSubscriber(modid = MigUtil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {
        /** Events related to the mod-loading process. Handles things like entity spawns and their attributes. **/
        /* Add Mod-loading Events below this line please */



        /* Add Mod-loading Events above this line please */
    }

    @Mod.EventBusSubscriber(modid = MigUtil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        /** Events related to the mod-loading process on the clients. Handles things like renderers. **/
        /* Add Client-Side Mod-loader Events below this line please */

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // this sends a message in the log containing the user's Minecraft name
            LOGGER.info("Oh hey, how are you {}", Minecraft.getInstance().getUser().getName());
        }

        /* Add Client-Side Mod-loader Events above this line please */
    }
}