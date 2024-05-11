package net.august.enchantingmod;

import net.august.enchantingmod.block.ModBlocks;
import net.august.enchantingmod.entity.ModBlockEntities;
import net.august.enchantingmod.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EnchantingMod implements ModInitializer
{
    public static final String modId = "enchantingmod";

    public static final Logger logger = LoggerFactory.getLogger(modId);

    @Override
    public void onInitialize()
    {
        ModScreenHandlers.registerScreenHandlers();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
    }
}
