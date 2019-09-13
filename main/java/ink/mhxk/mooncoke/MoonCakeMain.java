package ink.mhxk.mooncoke;


import ink.mhxk.mooncoke.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MoonCakeMain.MODID,version = MoonCakeMain.VERSION,name = MoonCakeMain.MODNAME)
public class MoonCakeMain {
    @SidedProxy(serverSide = "ink.mhxk.mooncake.common.CommonProxy",clientSide = "ink.mhxk.mooncoke.client.ClientProxy")
    public static CommonProxy PROXXY;
    public  static final String MODID = "mooncake";
    public static  final String MODNAME = "MoonCake";
    public static final String VERSION = "1.0.0";
    @Mod.Instance
    public static MoonCakeMain INSTANCE;
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        INSTANCE = this;
        MinecraftForge.EVENT_BUS.register(PROXXY);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){

    }
}
