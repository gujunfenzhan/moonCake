package ink.mhxk.mooncoke.client;

import ink.mhxk.mooncoke.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event){

    }
    public void registerBlockModel(Block block){
        registerItemModel(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
    public void registerItemModel(Item item){
        ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
}
