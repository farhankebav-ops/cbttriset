package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.camera.camera2.interop.d;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import j2.q;
import kotlin.jvm.internal.k;
import q6.f0;
import q6.n1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineAdapterKt {
    public static final <T> q asListenableFuture(f0 f0Var, Object obj) {
        k.e(f0Var, "<this>");
        q future = CallbackToFutureAdapter.getFuture(new d(2, f0Var, obj));
        k.d(future, "getFuture { completer ->…      }\n        tag\n    }");
        return future;
    }

    public static /* synthetic */ q asListenableFuture$default(f0 f0Var, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(f0Var, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object asListenableFuture$lambda$0(f0 this_asListenableFuture, Object obj, CallbackToFutureAdapter.Completer completer) {
        k.e(this_asListenableFuture, "$this_asListenableFuture");
        k.e(completer, "completer");
        ((n1) this_asListenableFuture).n(new CoroutineAdapterKt$asListenableFuture$1$1(completer, this_asListenableFuture));
        return obj;
    }
}
