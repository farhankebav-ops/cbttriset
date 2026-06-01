package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return MeteringRepeatingSession.lambda$getProperPreviewSize$1((Size) obj, (Size) obj2);
    }
}
