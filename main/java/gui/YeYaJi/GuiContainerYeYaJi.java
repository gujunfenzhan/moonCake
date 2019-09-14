package gui.YeYaJi;

import ink.mhxk.mooncoke.MoonCakeMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiContainerYeYaJi extends GuiContainer {
	public static final ResourceLocation TEXTURES = new ResourceLocation(MoonCakeMain.MODID,
			"textures/gui/gui_yeyaji.png");

	public GuiContainerYeYaJi(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		this.xSize = 176;
		this.ySize = 181;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		int offSetX = (this.width - this.xSize) / 2;
		int offSetY = (this.height - this.ySize) / 2;
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(offSetX, offSetY, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = I18n.format("r");
		this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	}
}
