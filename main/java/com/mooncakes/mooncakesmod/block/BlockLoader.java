package com.mooncakes.mooncakesmod.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * Creative by TaoTie on 2019/9/14
 */
public class BlockLoader {
	public static enum block {
		;
		private Block block;

		private block(Block block) {
			this.block = block;
		}

		public Block getBlock() {
			return block;
		}
	}

	public BlockLoader(FMLPreInitializationEvent event) {
		for (block block : block.values()) {
			register(block.getBlock());
		}
	}

	public static void registerRenders() {
		for (block block : block.values()) {
			registerRender(block.getBlock());
		}
	}

	private static void register(Block block) {
		ForgeRegistries.ITEMS.register((new ItemBlock(block)).setRegistryName(block.getRegistryName()));
		ForgeRegistries.BLOCKS.register(block);
	}

	private static void registerRender(Block block) {
		ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}
}
