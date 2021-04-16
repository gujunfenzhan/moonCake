package ink.mhxk.mooncake.common;

import com.taotie.mooncake.item.ItemLoader;

import ink.mhxk.mooncake.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
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
		event.getRegistry().register(ModItemLoader.PEACH);
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
	
	public void preInit() {
		new ItemLoader();
	}

	public void init() {
	}

	public void postInit() {

	}
}
