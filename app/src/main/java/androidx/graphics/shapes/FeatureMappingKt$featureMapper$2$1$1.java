package androidx.graphics.shapes;

import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FeatureMappingKt$featureMapper$2$1$1 extends l implements e6.l {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureMappingKt$featureMapper$2$1$1(DoubleMapper doubleMapper, int i2) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i2;
    }

    public final CharSequence invoke(int i2) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.map(i2 / this.$N));
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
