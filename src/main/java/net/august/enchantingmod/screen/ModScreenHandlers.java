package net.august.enchantingmod.screen;

import net.august.enchantingmod.EnchantingMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers
{
    public static final ScreenHandlerType<NewEnchantmentScreenHandler> newEnchantingScreenHandler = Registry.register(Registries.SCREEN_HANDLER, new Identifier(EnchantingMod.modId, "enchantino"), new ExtendedScreenHandlerType<>(NewEnchantmentScreenHandler::new));

    public static void registerScreenHandlers()
    {
        EnchantingMod.logger.info("Registering Screen Handlers for " + EnchantingMod.modId);
    }
}
