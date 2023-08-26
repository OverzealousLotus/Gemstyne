package lotus.gemstyne.util;

import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
public class GemstyneColorUtil {

        /**
         * Contains constants for all the colors used for various text and particles
         */
        public static class Colors {
            public static final Vector3f TORRIUM = Vec3d.unpackRgb(0xFFFF00).toVector3f(); // Yellow
            public static final Vector3f RADIOACTIVE_GREEN = Vec3d.unpackRgb(0x01FF01).toVector3f(); // Bright Green
        }
}
