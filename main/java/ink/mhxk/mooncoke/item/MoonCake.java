package ink.mhxk.mooncoke.item;

import ink.mhxk.mooncoke.init.ModCreativeTabLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
/**
 * Creative by GoldMain on 2019/9/14
 */
public class MoonCake
extends ItemFood {
    public MoonCake() {
        super(4,false);
        this.setCreativeTab(ModCreativeTabLoader.MOONCAKE);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)){
            items.add(new ItemStack(this,1,0));
            items.add(new ItemStack(this,1,1));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getMetadata();
        switch (meta){
            case 0:
                return "mooncakeWuRen";
            case 1:
                return "mooncakeDouSha";
        }
        return super.getUnlocalizedName(stack);
    }
}
