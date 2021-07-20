package com.taotie.mooncake.common;

import com.taotie.mooncake.block.BlockLoader;
import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import com.taotie.mooncake.inventory.GuiElementLoader;
import com.taotie.mooncake.item.ItemLoader;
import com.taotie.mooncake.tileentity.TileEntityLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader();
		new ItemLoader();
		new BlockLoader();
		new GuiElementLoader();
		new OreDictionaryLoader();
		new TileEntityLoader();
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
