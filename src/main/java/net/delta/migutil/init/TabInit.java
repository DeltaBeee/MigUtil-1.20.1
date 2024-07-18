package net.delta.migutil.init;

import net.delta.migutil.MigUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MigUtil.MOD_ID);
    /** Ignore how MONSTROUS this may seem. <br>
     * If you want to make another Creative Mode Tab, just copy this and change the name fields.
     * <br>
     * <br>
     * You can add .withTabsAfter() or .withTabsBefore() to order them. **/
    public static final RegistryObject<CreativeModeTab> GENERAL_TAB = TABS.register("general_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.FIRE_CHARGE))
                    .title(Component.translatable("tab.migutil.general_tab"))
                    .displayItems((display, output) -> {
                        output.accept(Items.DIRT);
                        output.accept(Items.EGG);
                    })
                    .build());

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
