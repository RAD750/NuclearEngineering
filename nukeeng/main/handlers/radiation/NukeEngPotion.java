package nukeeng.main.handlers.radiation;

import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class NukeEngPotion extends Potion
{
    public static final NukeEngPotion radiationSickness;

    public NukeEngPotion(final int id, final boolean badEffect, final int liquidColor) {
        super(id, badEffect, liquidColor);
    }
    
    @Override
    public void performEffect(final EntityLiving entity, final int amplifier) {
        if (super.id == NukeEngPotion.radiationSickness.id) {
            entity.attackEntityFrom((DamageSource)NukeEngDamageSource.radiationSickness, 10);
        }
    }
    
    @Override
    public boolean isReady(final int duration, final int amplifier) {
        return true;
    }
        
    public static void init() {
        NukeEngPotion.radiationSickness.setPotionName("potion.radiationSickness");
        NukeEngPotion.radiationSickness.setIconIndex(6, 0);
        NukeEngPotion.radiationSickness.setEffectiveness(0.25);
    }
    
    static {
        radiationSickness = new NukeEngPotion(24, true, 5149489);
    }
}
