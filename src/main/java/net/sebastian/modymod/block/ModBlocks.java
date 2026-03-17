package net.sebastian.modymod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.sebastian.modymod.ModyMod;
import net.minecraft.block.Block;

public class ModBlocks {

    //Custom blocks, starting with raw limestone block
    public static final Block RAW_LIMESTONE_BLOCK = registerBlock("raw_limestone_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.CALCITE)));

    //limestone ore block for natural generation
    public static final Block LIMESTONE_ORE = registerBlock("limestone_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                AbstractBlock.Settings.create().strength(3f).requiresTool()));
    //deepslate variation
    public static final Block LIMESTONE_DEEPSLATE_ORE = registerBlock("limestone_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    //Credit to Modding by Kaupenjoe for these helper methods to register the blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ModyMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ModyMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ModyMod.LOGGER.info("Registering Mod Blocks for " + ModyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RAW_LIMESTONE_BLOCK);
            entries.add(ModBlocks.LIMESTONE_ORE);
            entries.add(ModBlocks.LIMESTONE_DEEPSLATE_ORE);
        });
    }
}
