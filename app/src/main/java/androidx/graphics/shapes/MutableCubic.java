package androidx.graphics.shapes;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i2) {
        int i8 = i2 + 1;
        long jMo66transformXgqJiTY = pointTransformer.mo66transformXgqJiTY(getPoints$graphics_shapes_release()[i2], getPoints$graphics_shapes_release()[i8]);
        getPoints$graphics_shapes_release()[i2] = Float.intBitsToFloat((int) (jMo66transformXgqJiTY >> 32));
        getPoints$graphics_shapes_release()[i8] = Float.intBitsToFloat((int) (jMo66transformXgqJiTY & 4294967295L));
    }

    public final void interpolate(Cubic c12, Cubic c22, float f4) {
        k.e(c12, "c1");
        k.e(c22, "c2");
        for (int i2 = 0; i2 < 8; i2++) {
            getPoints$graphics_shapes_release()[i2] = Utils.interpolate(c12.getPoints$graphics_shapes_release()[i2], c22.getPoints$graphics_shapes_release()[i2], f4);
        }
    }

    public final void transform(PointTransformer f4) {
        k.e(f4, "f");
        transformOnePoint(f4, 0);
        transformOnePoint(f4, 2);
        transformOnePoint(f4, 4);
        transformOnePoint(f4, 6);
    }
}
