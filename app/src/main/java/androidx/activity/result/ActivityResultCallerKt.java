package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import e6.l;
import kotlin.jvm.internal.k;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<x> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> contract, I i2, ActivityResultRegistry registry, l callback) {
        k.e(activityResultCaller, "<this>");
        k.e(contract, "contract");
        k.e(registry, "registry");
        k.e(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, registry, new a(0, callback)), contract, i2);
    }

    public static final <I, O> ActivityResultLauncher<x> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> contract, I i2, l callback) {
        k.e(activityResultCaller, "<this>");
        k.e(contract, "contract");
        k.e(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, new a(1, callback)), contract, i2);
    }
}
