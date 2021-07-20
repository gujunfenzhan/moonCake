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
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
		int textureWidth = 1 + (int) Math.ceil(22.0 * containerGrinder.getProcessTime() / this.totalProcessTime);
		this.drawTexturedModalRect(offsetX + 79, offsetY + 30, 0, 156, textureWidth, 17);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tile = I18n.format("grinder.1.desc");
		this.fontRenderer.drawString(tile, (this.xSize - this.fontRenderer.getStringWidth(tile)) / 2, 6, 0x404040);
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}

}
