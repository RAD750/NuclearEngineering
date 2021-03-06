package nukeeng.main.handlers.radiation;

import net.minecraft.util.DamageSource;

public class NukeEngDamageSource extends DamageSource
{
    public static NukeEngDamageSource radiationSickness;
    public static NukeEngDamageSource dismantledRTG;
    
    public NukeEngDamageSource(final String s) {
        super(s);
    }
    
    static {
        NukeEngDamageSource.radiationSickness = (NukeEngDamageSource)new NukeEngDamageSource("radiationSickness").setDamageBypassesArmor();
        NukeEngDamageSource.dismantledRTG = (NukeEngDamageSource)new NukeEngDamageSource("dismantledRTG").setDamageBypassesArmor();
    }
}