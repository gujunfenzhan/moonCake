package com.taotie.mooncake.item;

import com.taotie.mooncake.creativetab.CreativeTabsLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemFlour extends BaseItem {
    public ItemFlour() {
        u("Flour");
        r("flour");
        c(CreativeTabsLoader.moonCake);
        o("flour");
        d(128);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("flour.inf") + getMaxDamage(new ItemStack(this)));
    }
}