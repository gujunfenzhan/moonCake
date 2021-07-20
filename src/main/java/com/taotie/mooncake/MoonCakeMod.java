package com.taotie.mooncake;

import com.taotie.mooncake.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoonCakeMod.MODID, name = MoonCakeMod.NAME, version = MoonCakeMod.VERSION, acceptedMinecraftVersions = "1.12.2")
public class MoonCakeMod {
	public static final String MODID = "mooncake";
	public static final String NAME = "Moon Cake";
	public static final String VERSION = "1.0.0";

	@Instance(MoonCakeMod.MODID)
	public static MoonCakeMod instance;

	@SidedProxy(clientSide = "com.taotie.mooncake.client.ClientProxy", serverSide = "com.taotie.mooncake.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
