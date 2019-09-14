package ink.mhxk.mooncoke.common;

import com.mooncakes.mooncakesmod.item.ItemLoader;

import ink.mhxk.mooncoke.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Creative by GoldMain on 2019/9/13
 */
public class CommonProxy {
	/*
	 * 注册物品
	 */
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ModItemLoader.MOONCAKE_NORMAL);
		event.getRegistry().register(ModItemLoader.MOONCAKE);
	}

	/*
	 * 注册方块
	 */
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {

	}

	public void registerItemBlock(RegistryEvent.Register<Item> event, Block block) {
		event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	/**
	 * Creative by TaoTie on 2019/9/14
	 **/
	public void preInit(FMLPreInitializationEvent event) {
		new com.mooncakes.mooncakesmod.common.CommonProxy().preInit(event);
	}

	public void init(FMLInitializationEvent event) {
		new com.mooncakes.mooncakesmod.common.CommonProxy().init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		new com.mooncakes.mooncakesmod.common.CommonProxy().postInit(event);
	}
}
