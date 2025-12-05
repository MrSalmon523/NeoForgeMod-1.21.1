package com.mrsalmon.salmonthings.item;

import com.mrsalmon.salmonthings.SalmonThings;
import com.mrsalmon.salmonthings.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SalmonThings.MOD_ID);

    public static final Supplier<CreativeModeTab> SALMON_THINGS_TAB = CREATIVE_MODE_TAB.register("salmon_things_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SALMON_INGOT.get()))
                    .title(Component.translatable("creativetab.salmonthings.salmon_things_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SALMON_INGOT);
                        output.accept(ModItems.RAW_SALMON_CHUNK);
                    }).build());

    public static final Supplier<CreativeModeTab> SALMON_BLOCKS_TAB = CREATIVE_MODE_TAB.register("salmon_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SALMON_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SalmonThings.MOD_ID, "salmon_things_tab"))
                    .title(Component.translatable("creativetab.salmonthings.salmon_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SALMON_BLOCK);
                        output.accept(ModBlocks.SALMON_ORE);
                    }).build());

    public static void register (IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
