package com.taotie.mooncake.common;

import com.taotie.mooncake.block.BlockLoader;
import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import com.taotie.mooncake.inventory.GuiElementLoader;
import com.taotie.mooncake.item.ItemLoader;
import com.taotie.mooncake.item.ModItems;
import com.taotie.mooncake.tileentity.TileEntityLoader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader();
		new ItemLoader();
		new BlockLoader();
		new GuiElementLoader();
		new OreDictionaryLoader();
		new TileEntityLoader();
		// TODO
		GameRegistry.addShapedRecipe(new ResourceLocation("dough"),new ResourceLocation("mooncalke"),new ItemStack(ModItems.Dough), new Object[]
				{
						"#&", "  ", '#', ModItems.ItemFlour,'&', Items.WATER_BUCKET
				});
		GameRegistry.addSmelting(ModItems.Dough, new ItemStack(ModItems.MoonCake), 0.5F);
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
