package net.august.enchantingmod.block;

import net.august.enchantingmod.EnchantingMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModBlocks
{
    public static final Block newEnchantingBlock = registerBlock("new_enchanting_table", new NewEnchantingBlock(FabricBlockSettings.copyOf(Blocks.ENCHANTING_TABLE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EnchantingMod.modId, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EnchantingMod.modId, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void add(FabricItemGroupEntries entries)
    {
        entries.add(newEnchantingBlock);
    }

    public static void registerBlocks()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::add);
    }
}
