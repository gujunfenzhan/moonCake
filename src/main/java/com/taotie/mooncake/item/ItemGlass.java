package com.taotie.mooncake.item;

import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

public class ItemGlass extends  BaseItem implements IItemColor {
    public ItemGlass() {
        u("Glass");
        r("glass");
        c(CreativeTabsLoader.moonCake);
        setHasSubtypes(true);
        d(0);
        setNoRepair();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)){
            int index  =0;
            for(String i:GLASS_WARPPER)
            {
                ItemStack itemStack= new ItemStack(this,1,index);
                NBTTagCompound nbtTagCompound=new NBTTagCompound();
                nbtTagCompound.setInteger("use",16);
                itemStack.setTagCompound(nbtTagCompound);
                items.add(itemStack);
                index++;
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getMetadata();
        return "item."+ GLASS_WARPPER[meta];
    }

    //@Override
    //public String getItemStackDisplayName(ItemStack stack)
    //{
    //    return net.minecraft.util.text.translation.I18n.translateToLocal(PotionUtils.getPotionFromItem(stack).getNamePrefixed("potion.effect."));
    //}

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.getMetadata() != 0)
            tooltip.add(I18n.format("glass.inf") + (getNBTShareTag(stack) == null ? 0 : getNBTShareTag(stack).getInteger("use")));
    }

    public static String[] GLASS_WARPPER=new String[]{
            "Glass",
            "glassWater"
    };

    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return 0;
    }
}