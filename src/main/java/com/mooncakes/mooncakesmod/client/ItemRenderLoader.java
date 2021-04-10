package com.mooncakes.mooncakesmod.client;

import com.mooncakes.mooncakesmod.block.BlockLoader;
import com.mooncakes.mooncakesmod.item.ItemLoader;

/**
 * Creative by TaoTie on 2019/9/14
 */
public class ItemRenderLoader {
	public ItemRenderLoader() {
		ItemLoader.registerRenders();
		BlockLoader.registerRenders();
	}
}
