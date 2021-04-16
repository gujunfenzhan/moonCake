package ink.mhxk.mooncake.item;

import ink.mhxk.mooncake.init.ModCreativeTabLoader;
import ink.mhxk.mooncake.utils.MojangPotionEffectsUtils;
import ink.mhxk.mooncake.warpper.MoonCakeWarpper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
/**
 * Creative by GoldMain on 2019/9/14
 */
public class MoonCake
extends ItemFood {

    public MoonCake() {
        super(4,true);
        this.setCreativeTab(ModCreativeTabLoader.MOONCAKE);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)){
            int index  =0;
            for (MoonCakeWarpper moonCakeWarpper : MoonCakeWarpper.MOON_CAKE_WARPPER) {
                items.add(new ItemStack(this,1,index));
                index++;
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getMetadata();
        return "item."+MoonCakeWarpper.MOON_CAKE_WARPPER.get(meta).getUnNmae();
    }
    /*
        添加buffer
     */
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote){
            int meta = stack.getMetadata();
            for (PotionEffect effect : MoonCakeWarpper.MOON_CAKE_WARPPER.get(meta).effects) {
                player.addPotionEffect(MojangPotionEffectsUtils.copyPotionEffect(effect));
            }
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
