package nukeeng.main.handlers.radiation;

import net.minecraft.util.DamageSource;

public class NukeEngDamageSource extends DamageSource
{
    public static NukeEngDamageSource radiationSickness;
    
    public NukeEngDamageSource(final String s) {
        super(s);
    }
    
    static {
        NukeEngDamageSource.radiationSickness = (NukeEngDamageSource)new NukeEngDamageSource("radiationSickness").setDamageBypassesArmor();
    }
}