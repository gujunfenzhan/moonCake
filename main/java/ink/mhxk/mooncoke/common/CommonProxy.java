package ink.mhxk.mooncoke.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * Creative by GoldMain on 2019/9/13
 */
public class CommonProxy {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){

    }
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event){

    }
    public void registerItemBlock(RegistryEvent.Register<Item> event,Block block){
        event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
