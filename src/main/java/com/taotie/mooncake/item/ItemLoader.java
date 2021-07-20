package com.taotie.mooncake.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;

public class ItemLoader {
	public ItemLoader() {
		try {
			ModItems modItems = new ModItems();
			for (Field field : ModItems.class.getFields()) {
				register((Item) field.get(modItems));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		try {
			ModItems modItems = new ModItems();
			for (Field field : ModItems.class.getFields()) {
				registerRender((Item) field.get(modItems));
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
