package ink.mhxk.mooncoke.warpper;

import ink.mhxk.mooncoke.utils.MojangPotionEffects;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Creative by GoldMain on 2019/9/14
 * 对月饼类包装
 */
public class MoonCakeWarpper {
    public String unNmae;
    public List<PotionEffect> effects = new ArrayList<>();
    public MoonCakeWarpper(String unNmae){
        this.unNmae = unNmae;
    }
    public MoonCakeWarpper(String unNmae,PotionEffect... effects){
        this.unNmae = unNmae;
        for (PotionEffect potionEffect : effects) {
            this.effects.add(potionEffect);
        }
    }

    public String getUnNmae() {
        return unNmae;
    }

    public static List<MoonCakeWarpper> MOON_CAKE_WARPPER = new ArrayList<MoonCakeWarpper>(){
        {
            /*
            需要添加药水可在后面添加

             */
            this.add(new MoonCakeWarpper("mooncakeWuRen",new PotionEffect(MojangPotionEffects.SHU_DU,20*20,1)));
            this.add(new MoonCakeWarpper("mooncakeDouSha"));
            this.add(new MoonCakeWarpper("mooncakeTangJiangPiYan"));
            this.add(new MoonCakeWarpper("mooncakeYuMiRouSong"));
            this.add(new MoonCakeWarpper("mooncakeTaiShiFengMi"));
            this.add(new MoonCakeWarpper("mooncakeYuMiHeiZhiMa"));
            this.add(new MoonCakeWarpper("mooncakeLvCha"));
            this.add(new MoonCakeWarpper("mooncakeTouMingPi"));
            this.add(new MoonCakeWarpper("mooncakeJingShiTiJiang"));
            this.add(new MoonCakeWarpper("mooncakeTangSu"));
            this.add(new MoonCakeWarpper("mooncakeFengLi"));
            this.add(new MoonCakeWarpper("mooncakeJingShiHong"));
            this.add(new MoonCakeWarpper("mooncakeFengHuang"));
            this.add(new MoonCakeWarpper("mooncakeQingShi"));
            this.add(new MoonCakeWarpper("mooncakeShuangSu"));

        }
    };
}
