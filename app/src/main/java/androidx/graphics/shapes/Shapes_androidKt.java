package androidx.graphics.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Shapes_androidKt {
    private static final void pathFromCubics(Path path, List<? extends Cubic> list) {
        path.rewind();
        int size = list.size();
        boolean z2 = true;
        for (int i2 = 0; i2 < size; i2++) {
            Cubic cubic = list.get(i2);
            if (z2) {
                path.moveTo(cubic.getAnchor0X(), cubic.getAnchor0Y());
                z2 = false;
            }
            path.cubicTo(cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic.getAnchor1X(), cubic.getAnchor1Y());
        }
        path.close();
    }

    public static final Path toPath(RoundedPolygon roundedPolygon) {
        k.e(roundedPolygon, "<this>");
        return toPath$default(roundedPolygon, null, 1, null);
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            path = new Path();
        }
        return toPath(roundedPolygon, path);
    }

    public static final RoundedPolygon transformed(RoundedPolygon roundedPolygon, final Matrix matrix) {
        k.e(roundedPolygon, "<this>");
        k.e(matrix, "matrix");
        final float[] fArr = new float[2];
        return roundedPolygon.transformed(new PointTransformer() { // from class: androidx.graphics.shapes.Shapes_androidKt.transformed.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* JADX INFO: renamed from: transform-XgqJiTY */
            public final long mo66transformXgqJiTY(float f4, float f8) {
                float[] fArr2 = fArr;
                fArr2[0] = f4;
                fArr2[1] = f8;
                matrix.mapPoints(fArr2);
                float[] fArr3 = fArr;
                return FloatFloatPair.m9constructorimpl(fArr3[0], fArr3[1]);
            }
        });
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path) {
        k.e(roundedPolygon, "<this>");
        k.e(path, "path");
        pathFromCubics(path, roundedPolygon.getCubics());
        return path;
    }

    public static /* synthetic */ Path toPath$default(Morph morph, float f4, Path path, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            path = new Path();
        }
        return toPath(morph, f4, path);
    }

    public static final Path toPath(Morph morph, float f4, Path path) {
        k.e(morph, "<this>");
        k.e(path, "path");
        pathFromCubics(path, morph.asCubics(f4));
        return path;
    }
}
