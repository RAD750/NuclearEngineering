package nukeeng.main;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Localization {
    public static void addLocalization(final String name, String desc) {
        LanguageRegistry.instance().addStringLocalization(name, desc);   
    }
    
    public static void initLocalization() {
    	addLocalization("potion.radiationSickness", "Radiation Sickness");
    	addLocalization("death.radiationSickness", "%s died from acute radiation sickness");
    }
}
