package net.august.enchantingmod.client;

import net.august.enchantingmod.screen.ModScreenHandlers;
import net.august.enchantingmod.screen.NewEnchantmentScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class EnchantingModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient()
    {
        HandledScreens.register(ModScreenHandlers.newEnchantingScreenHandler, NewEnchantmentScreen::new);
    }
}
