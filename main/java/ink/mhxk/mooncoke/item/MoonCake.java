package ink.mhxk.mooncoke.item;

import ink.mhxk.mooncoke.init.ModCreativeTabLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.List;
/**
 * Creative by GoldMain on 2019/9/14
 */
public class MoonCake
extends ItemFood {
    public static List<String> MOONCAKE_NAME = new ArrayList<String>(){
        {
            this.add("mooncakeWuRen");
            this.add("mooncakeDouSha");
            this.add("mooncakeTangJiangPiYan");
            this.add("mooncakeTangJiangPiYan");
            this.add("mooncakeYuMiRouSong");
            this.add("mooncakeTaiShiFengMi");
            this.add("mooncakeYuMiHeiZhiMa");
            this.add("mooncakeLvCha");
            this.add("mooncakeTouMingPi");
            this.add("mooncakeJingShiTiJiang");
            this.add("mooncakeTangSu");
            this.add("mooncakeFengLi");
            this.add("mooncakeJingShiHong");
            this.add("mooncakeFengHuang");
            this.add("mooncakeQingShi");
            this.add("mooncakeShuangSu");
        }
    };
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
            for (String s : MOONCAKE_NAME) {
                items.add(new ItemStack(this,1,index));
                index++;
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getMetadata();
        return "item."+MOONCAKE_NAME.get(meta);
    }

}
