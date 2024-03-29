package ink.mhxk.mooncake.client;
import ink.mhxk.mooncake.common.CommonProxy;
import ink.mhxk.mooncake.init.ModItemLoader;
import ink.mhxk.mooncake.warpper.MoonCakeWarpper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * Creative by GoldMain on 2019/9/13
 */
public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event){
        registerItemModel(ModItemLoader.MOONCAKE_NORMAL,0);

		for (int i = 0; i < MoonCakeWarpper.MOON_CAKE_WARPPER.size(); i++) {
			registerItemModel(ModItemLoader.MOONCAKE,i);
		}
		registerItemModel(ModItemLoader.PEACH,0);
    }
    public void registerBlockModel(Block block){
        registerItemModel(Item.getItemFromBlock(block),0);
    }
    public void registerItemModel(Item item,int meta){
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
}
