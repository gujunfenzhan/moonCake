package com.taotie.mooncake.client.gui;

import com.taotie.mooncake.MoonCakeMod;
import com.taotie.mooncake.inventory.ContainerGrinder;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerGrinder extends GuiContainer {
	private static final String TEXTURE_PATH = MoonCakeMod.MODID + ":" + "textures/gui/gui_grinder.png";
	private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
	private ContainerGrinder containerGrinder;
	private int totalProcessTime;

	public GuiContainerGrinder(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		containerGrinder = (ContainerGrinder) inventorySlotsIn;
		totalProcessTime = containerGrinder.getTotalProcessTime();
		xSize = 176;
		ySize = 166;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(TEXTURE);
		int offsetX = (width - xSize) / 2, offsetY = (height - ySize) / 2;

		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);
		int textureWidth = 1 + (int) (24.0 * containerGrinder.getProcessTime() / totalProcessTime);
		drawTexturedModalRect(offsetX + 80, offsetY + 35, 176, 0, textureWidth, 17);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tile = I18n.format("grinder.1.desc");
		fontRenderer.drawString(tile, (this.xSize - this.fontRenderer.getStringWidth(tile)) / 2, 6, 0x404040);
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}

}
