package com.taotie.mooncake.inventory;

import com.taotie.mooncake.MoonCakeMod;
import com.taotie.mooncake.client.gui.GuiContainerGrinder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiElementLoader implements IGuiHandler {
	public static final int GUI_Grinder = 1;

	public GuiElementLoader() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MoonCakeMod.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_Grinder:
			return new ContainerGrinder(player, world.getTileEntity(new BlockPos(x, y, z)));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_Grinder:
			return new GuiContainerGrinder(new ContainerGrinder(player, world.getTileEntity(new BlockPos(x, y, z))));
		default:
			return null;
		}
	}

}
