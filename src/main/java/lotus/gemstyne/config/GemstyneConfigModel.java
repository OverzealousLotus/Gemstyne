package lotus.gemstyne.config;

import io.wispforest.owo.config.annotation.*;
import lotus.gemstyne.Gemstyne;

@Modmenu(modId = Gemstyne.MOD_ID)
@Config(name = Gemstyne.MOD_ID + "_config", wrapperName = "GemstyneConfig")
@SuppressWarnings("unused")
public class GemstyneConfigModel {
    @Nest
    public OreConfiguration oreConfiguration = new OreConfiguration();

    @SectionHeader("geode_configuration")
    @RestartRequired
    public boolean ikariteEnabled = true;
    @RestartRequired
    public boolean garnetEnabled = true;
    @RestartRequired
    public boolean lapisEnabled = true;

    @RestartRequired
    public int mochiteRichness = 5;

    public static class OreConfiguration {
        @SectionHeader("overworld")
        @RestartRequired
        public boolean bubblegemEnabled = true;
        @RestartRequired
        public boolean mochiteEnabled = true;
        @RestartRequired
        public boolean morkiteEnabled = true;
        @RestartRequired
        public boolean tinEnabled = true;
        @RestartRequired
        public boolean uraniumEnabled = true;


        @SectionHeader("nether")
        @RestartRequired
        public boolean aldusEnabled = true;
        @RestartRequired
        public boolean blaziteEnabled = true;
        @RestartRequired
        public boolean crimoniteEnabled = true;


        @SectionHeader("multi_dimensional")
        @RestartRequired
        public boolean enderPearlEnabled = true;
        @RestartRequired
        public boolean mutaliumEnabled = true;
        @RestartRequired
        public boolean torriumEnabled = true;
        @RestartRequired
        public boolean mineralsEnabled = true;
    }
}
