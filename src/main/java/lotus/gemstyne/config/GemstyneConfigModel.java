package lotus.gemstyne.config;

import io.wispforest.owo.config.annotation.*;

@Modmenu(modId = "gemstyne")
@Config(name = "gemstyne_config", wrapperName = "GemstyneConfig")
public class GemstyneConfigModel {
    @SectionHeader("oreConfiguration")
    public int oreAmounts = 20;
    public boolean debugEnabled = false;
    public GenPreset genPreset = GenPreset.Normal;

    @Nest
    public MochiteSettings mochiteSettings = new MochiteSettings();

    public enum GenPreset {
        Minimized,
        Normal,
        Amped
    }

    public static class MochiteSettings {
        @RestartRequired
        public boolean mochiteEnabled = true;
        @RestartRequired
        public int mochiteRarity = 0;
    }
}
