package net.august.enchantingmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.august.enchantingmod.EnchantingMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Map;

public class NewEnchantmentScreen extends HandledScreen<NewEnchantmentScreenHandler>
{
    private static final Identifier texture = new Identifier(EnchantingMod.modId, "textures/gui/new_enchanting_gui.png");

    public TexturedButtonWidget enchantButton;
    public NewEnchantmentScreen(NewEnchantmentScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
        this.backgroundWidth = 276;
    }

    @Override
    protected void init()
    {
        super.init();
        this.titleX = 125;
        this.playerInventoryTitleY = 1000;

    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, texture);

        context.drawTexture(texture, x, y, 0, 0, 276, 166, 276, 276);

        drawScrollbar(context);
        enchantButton = new TexturedButtonWidget(x + 202, y + 36, 52, 18, 100, 166, 18, texture, 276, 276, onPress -> {
            this.handler.addEnchantment();
        });
        addDrawableChild(enchantButton);
        if (this.handler.inventory.getStack(0).isOf(Items.ENCHANTED_BOOK))
        {
            context.drawTexture(texture, x + 5, y + 18, 0,  166, 88, 19, 276, 276);
            context.drawTexture(texture, x + 7, y + 24, 90,  195, 7, 7, 276, 276);
            //context.drawText(textRenderer, EnchantmentHelper.get(this.handler.inventory.getStack(0).isOf(Items.ENCHANTED_BOOK)), x + 7, y + 24,  3000 * 14, true);
        }
        for(Map<Enchantment, Integer> nbtEnchantment : this.handler.blockEntity.enchantments)
        {
            context.drawTexture(texture, x + 5, y + 18, 0,  166, 88, 19, 276, 276);
        }
    }

    private void drawScrollbar(DrawContext context)
    {
        context.drawTexture(texture, x + 94, y + 18, 94,  166, 6, 27, 276, 276);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
