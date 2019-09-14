package com.mooncakes.mooncakesmod.common;

import com.mooncakes.mooncakesmod.block.BlockLoader;
import com.mooncakes.mooncakesmod.item.ItemLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Creative by TaoTie on 2019/9/14
 */
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new ItemLoader(event);
		new BlockLoader(event);
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}
