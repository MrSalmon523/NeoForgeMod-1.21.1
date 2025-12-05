package com.mrsalmon.salmonthings.item;

import com.mrsalmon.salmonthings.SalmonThings;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SalmonThings.MOD_ID);

    public static final DeferredItem<Item> RAW_SALMON_CHUNK = ITEMS.register("raw_salmon_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SALMON_INGOT = ITEMS.register("salmon_ingot",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
