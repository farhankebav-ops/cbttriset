package androidx.work;

import a.a;
import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class OneTimeWorkRequestKt {
    public static final <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        k.k();
        throw null;
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull c inputMerger) {
        k.e(builder, "<this>");
        k.e(inputMerger, "inputMerger");
        return builder.setInputMerger(a.B(inputMerger));
    }
}
