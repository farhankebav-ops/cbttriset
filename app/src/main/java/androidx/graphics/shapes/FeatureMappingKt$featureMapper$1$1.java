package androidx.graphics.shapes;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FeatureMappingKt$featureMapper$1$1 extends l implements e6.l {
    public static final FeatureMappingKt$featureMapper$1$1 INSTANCE = new FeatureMappingKt$featureMapper$1$1();

    public FeatureMappingKt$featureMapper$1$1() {
        super(1);
    }

    @Override // e6.l
    public final CharSequence invoke(i it) {
        k.e(it, "it");
        return ((Number) it.f13498a).floatValue() + " -> " + ((Number) it.f13499b).floatValue();
    }
}
