package com.taotie.mooncake.client;

import com.taotie.mooncake.block.BlockLoader;
import com.taotie.mooncake.item.ItemLoader;

public class ItemRenderLoader {
	public ItemRenderLoader() {
		ItemLoader.registerRenders();
		BlockLoader.registerRenders();
	}
}
