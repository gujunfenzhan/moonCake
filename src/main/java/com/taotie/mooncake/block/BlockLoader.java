package com.taotie.mooncake.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;

public class BlockLoader {

	public BlockLoader() {
		try {
			ModBlocks modBlocks = new ModBlocks();
			for (Field field : ModBlocks.class.getFields()) {
				register((Block) field.get(modBlocks));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		try {
			ModBlocks modBlocks = new ModBlocks();
			for (Field field : ModBlocks.class.getFields()) {
				registerRender((Block) field.get(modBlocks));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void register(Block block) {
		ForgeRegistries.ITEMS.register((new ItemBlock(block)).setRegistryName(block.getRegistryName()));
		ForgeRegistries.BLOCKS.register(block);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Block block) {
		ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}
}
