package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Feature {
    private final List<Cubic> cubics;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j, long j3, boolean z2, f fVar) {
            this(list, j, j3, z2);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* JADX INFO: renamed from: getRoundedCenter-1ufDz9w, reason: not valid java name */
        public final long m46getRoundedCenter1ufDz9w() {
            return this.roundedCenter;
        }

        /* JADX INFO: renamed from: getVertex-1ufDz9w, reason: not valid java name */
        public final long m47getVertex1ufDz9w() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + ((Object) FloatFloatPair.m16toStringimpl(this.vertex)) + ", center=" + ((Object) FloatFloatPair.m16toStringimpl(this.roundedCenter)) + ", convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed$graphics_shapes_release(PointTransformer f4) {
            k.e(f4, "f");
            c cVarN = q.N();
            int size = getCubics().size();
            for (int i2 = 0; i2 < size; i2++) {
                cVarN.add(getCubics().get(i2).transformed(f4));
            }
            return new Corner(q.o(cVarN), PointKt.m64transformedso9K2fw(this.vertex, f4), PointKt.m64transformedso9K2fw(this.roundedCenter, f4), this.convex, null);
        }

        public /* synthetic */ Corner(List list, long j, long j3, boolean z2, int i2, f fVar) {
            this(list, j, j3, (i2 & 8) != 0 ? true : z2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> cubics, long j, long j3, boolean z2) {
            super(cubics);
            k.e(cubics, "cubics");
            this.vertex = j;
            this.roundedCenter = j3;
            this.convex = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Edge extends Feature {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> cubics) {
            super(cubics);
            k.e(cubics, "cubics");
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed$graphics_shapes_release(PointTransformer f4) {
            k.e(f4, "f");
            c cVarN = q.N();
            int size = getCubics().size();
            for (int i2 = 0; i2 < size; i2++) {
                cVarN.add(getCubics().get(i2).transformed(f4));
            }
            return new Edge(q.o(cVarN));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> cubics) {
        k.e(cubics, "cubics");
        this.cubics = cubics;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer pointTransformer);
}
