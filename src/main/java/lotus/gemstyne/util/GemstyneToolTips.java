package lotus.gemstyne.util;

import lotus.gemstyne.armor.ArmorHandler;

public class GemstyneToolTips {
    private GemstyneToolTips() {}

    public static final GemstyneToolTipFactory OMINOUS = new GemstyneToolTipFactory("ominous");
    public static final GemstyneToolTipFactory ALDUS = new GemstyneToolTipFactory("aldus");



    public static void registerToolTips() {
        OMINOUS.addArmorSet(ArmorHandler.RENDFIRE.getArmorSet(), GemstyneUtil.Colors.RENDFIRE_STYLE);
        ALDUS.addArmorSet(ArmorHandler.ALDUS.getArmorSet(), GemstyneUtil.Colors.ALDUS_STYLE);
    }
}
