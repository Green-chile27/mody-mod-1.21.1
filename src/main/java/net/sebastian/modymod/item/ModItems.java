package net.sebastian.modymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sebastian.modymod.ModyMod;

//This is where all the custom mod items are stored. This code is written by me
public class ModItems {

    //These two items are just examples items from tutorial (Delete later)
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    //My actual custom items:
    public static final Item PORK_SANDWICH = registerItem("pork_sandwich", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ModyMod.LOGGER.info("Registering ModItems for" + ModyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(PORK_SANDWICH);
        });
    }
}
