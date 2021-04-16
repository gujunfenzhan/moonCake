package ink.mhxk.mooncake;

import ink.mhxk.mooncake.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Creative by GoldMain on 2019/9/13
 */
@Mod(modid = MoonCakeMain.MODID, version = MoonCakeMain.VERSION, name = MoonCakeMain.MODNAME)
public class MoonCakeMain {
	@SidedProxy(serverSide = "ink.mhxk.mooncake.common.CommonProxy", clientSide = "ink.mhxk.mooncoke.client.ClientProxy")
	public static CommonProxy PROXXY;
	public static final String MODID = "mooncake";
	public static final String MODNAME = "MoonCake";
	public static final String VERSION = "1.0.0";
	@Instance(MoonCakeMain.MODID)
	public static MoonCakeMain INSTANCE;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PROXXY.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		PROXXY.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		PROXXY.postInit();
	}
}
