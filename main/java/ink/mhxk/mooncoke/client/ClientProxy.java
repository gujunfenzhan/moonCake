﻿package ink.mhxk.mooncoke.client;

import ink.mhxk.mooncoke.common.CommonProxy;
import ink.mhxk.mooncoke.init.ModItemLoader;
import ink.mhxk.mooncoke.item.MoonCake;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * Creative by GoldMain on 2019/9/13
 */
public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event){
        registerItemModel(ModItemLoader.MOONCAKE_NORMAL,0);
        /*
        循环注册所有月饼
         */
        for (int i = 0; i < MoonCake.MOONCAKE_NAME.size(); i++) {
            registerItemModel(ModItemLoader.MOONCAKE,i);
        }

    }
    public void registerBlockModel(Block block){
        registerItemModel(Item.getItemFromBlock(block),0);
    }
    public void registerItemModel(Item item,int meta){
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		new ItemRenderLoader();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}