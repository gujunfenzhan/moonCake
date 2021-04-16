package com.taotie.mooncake.item;

import java.lang.reflect.Field;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
	public ItemLoader() {
		try {
			Class<ItemList> clazz = ItemList.class;
			for (Field field : clazz.getFields()) {
				Item item = (Item) field.get(null);
				register(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		try {
			Class<ItemList> clazz = ItemList.class;
			for (Field field : clazz.getFields()) {
				Item item = (Item) field.get(null);
				register(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void register(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item item) {
		ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, model);
	}
}
