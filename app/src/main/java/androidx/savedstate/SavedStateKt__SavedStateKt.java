package androidx.savedstate;

import android.os.Bundle;
import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(Bundle bundle, l block) {
        k.e(bundle, "<this>");
        k.e(block, "block");
        return (T) block.invoke(SavedStateReader.m82boximpl(SavedStateReader.m83constructorimpl(bundle)));
    }

    public static final <T> T write(Bundle bundle, l block) {
        k.e(bundle, "<this>");
        k.e(block, "block");
        return (T) block.invoke(SavedStateWriter.m167boximpl(SavedStateWriter.m169constructorimpl(bundle)));
    }
}
