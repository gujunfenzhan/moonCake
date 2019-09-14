package com.mooncakes.mooncakesmod.client;

import com.mooncakes.mooncakesmod.block.BlockLoader;
import com.mooncakes.mooncakesmod.item.ItemLoader;

public class ItemRenderLoader {
	public ItemRenderLoader() {
		ItemLoader.registerRenders();
		BlockLoader.registerRenders();
	}
}
