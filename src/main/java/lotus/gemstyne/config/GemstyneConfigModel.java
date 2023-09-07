package lotus.gemstyne.config;

import io.wispforest.owo.config.annotation.*;
import lotus.gemstyne.Gemstyne;

@Modmenu(modId = Gemstyne.MOD_ID)
@Config(name = Gemstyne.MOD_ID + "_config", wrapperName = "GemstyneConfig")
public class GemstyneConfigModel {
    @SectionHeader("ore_configuration")
    @RestartRequired
    public boolean mochiteEnabled = true;
    @RestartRequired
    public boolean morkiteEnabled = true;
    @RestartRequired
    public boolean tinEnabled = true;
    @RestartRequired
    public boolean uraniumEnabled = true;
    @RestartRequired
    public boolean mineralsEnabled = true;

    @SectionHeader("geode_configuration")
    @RestartRequired
    public boolean ikariteEnabled = true;
    @RestartRequired
    public boolean garnetEnabled = true;
    @RestartRequired
    public boolean lapisEnabled = true;
}
