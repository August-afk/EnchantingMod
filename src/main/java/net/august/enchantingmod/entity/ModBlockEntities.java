package net.august.enchantingmod.entity;

import net.august.enchantingmod.EnchantingMod;
import net.august.enchantingmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<NewEnchantingEntity> newEnchantingEntity =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(EnchantingMod.modId, "enchantino_entity"), FabricBlockEntityTypeBuilder.create(NewEnchantingEntity::new, ModBlocks.newEnchantingBlock).build());
    public static void registerBlockEntities() {
        EnchantingMod.logger.info("Registering Block Entities for " + EnchantingMod.modId);
    }
}
