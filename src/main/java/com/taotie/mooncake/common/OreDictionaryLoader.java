package com.taotie.mooncake.common;

import java.lang.reflect.Field;

import com.taotie.mooncake.item.BaseItem;
import com.taotie.mooncake.item.ModItems;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryLoader {
	public OreDictionaryLoader() {
		try {
			ModItems modItems = new ModItems();
			for (Field field : ModItems.class.getFields()) {
				Object item = field.get(modItems);
				if (item instanceof BaseItem) {
					if (((BaseItem) item).go() == null)
						continue;
					OreDictionary.registerOre(((BaseItem) item).go(), (BaseItem) item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
