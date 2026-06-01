package androidx.activity.result;

import android.content.Intent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultKt {
    public static final int component1(ActivityResult activityResult) {
        k.e(activityResult, "<this>");
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        k.e(activityResult, "<this>");
        return activityResult.getData();
    }
}
