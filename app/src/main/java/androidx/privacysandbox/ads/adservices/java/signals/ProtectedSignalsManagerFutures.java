package androidx.privacysandbox.ads.adservices.java.signals;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import j2.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.c0;
import q6.m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProtectedSignalsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final ProtectedSignalsManagerFutures from(Context context) {
            k.e(context, "context");
            ProtectedSignalsManager protectedSignalsManagerObtain = ProtectedSignalsManager.Companion.obtain(context);
            if (protectedSignalsManagerObtain != null) {
                return new JavaImpl(protectedSignalsManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class JavaImpl extends ProtectedSignalsManagerFutures {
        private final ProtectedSignalsManager mProtectedSignalsManager;

        public JavaImpl(ProtectedSignalsManager protectedSignalsManager) {
            this.mProtectedSignalsManager = protectedSignalsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
        @DoNotInline
        public q updateSignalsAsync(UpdateSignalsRequest request) {
            k.e(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(m0.f13566a), null, new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this, request, null), 3), null, 1, null);
        }
    }

    public static final ProtectedSignalsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    public abstract q updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest);
}
