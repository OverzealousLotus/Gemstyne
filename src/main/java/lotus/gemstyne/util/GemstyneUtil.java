package lotus.gemstyne.util;

import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import java.util.List;

public final class GemstyneUtil {
    private GemstyneUtil() {}

    /**
     * Contains constants for all the colors used for various text and particles
     */
    public static final class Colors {
        private Colors() {}

        public static final Vector3f TORRIUM = Vec3d.unpackRgb(0xFFFF00).toVector3f(); // Yellow
        public static final Vector3f RADIOACTIVE_GREEN = Vec3d.unpackRgb(0x01FF01).toVector3f(); // Bright Green
        public static final Vector3f MUTALIUM_WHITE = Vec3d.unpackRgb(0xFFC9C9).toVector3f();
        public static final Vector3f MUTALIUM_PALE_RED = Vec3d.unpackRgb(0xff6969).toVector3f();
        public static final Vector3f MUTALIUM_RED = Vec3d.unpackRgb(0xff3c3c).toVector3f();
        public static final List<Vector3f> MUTALIUM_PALETTE = List.of(MUTALIUM_WHITE, MUTALIUM_PALE_RED, MUTALIUM_RED);
        public static final Style RENDFIRE_STYLE = Style.EMPTY.withColor(Formatting.DARK_RED);
        public static final Style ALDUS_STYLE = Style.EMPTY.withColor(Formatting.DARK_GRAY);
    }
}
