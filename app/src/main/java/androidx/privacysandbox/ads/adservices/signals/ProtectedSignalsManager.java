package androidx.privacysandbox.ads.adservices.signals;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProtectedSignalsManager {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ProtectedSignalsManager";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @ExperimentalFeatures.Ext12OptIn
        public final ProtectedSignalsManager obtain(Context context) {
            k.e(context, "context");
            if (AdServicesInfo.INSTANCE.adServicesVersion() < 12) {
                Log.d(ProtectedSignalsManager.TAG, "Adservices less than 12, returning null for ProtectedSignalsManager.obtain.");
                return null;
            }
            Log.d(ProtectedSignalsManager.TAG, "Adservices version 12 detected, obtaining ProtectedSignalsManagerImpl.");
            android.adservices.signals.ProtectedSignalsManager protectedSignalsManager = android.adservices.signals.ProtectedSignalsManager.get(context);
            k.d(protectedSignalsManager, "get(context)");
            return new ProtectedSignalsManagerImpl(protectedSignalsManager);
        }

        private Companion() {
        }
    }

    @ExperimentalFeatures.Ext12OptIn
    public static final ProtectedSignalsManager obtain(Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @ExperimentalFeatures.Ext12OptIn
    public abstract Object updateSignals(UpdateSignalsRequest updateSignalsRequest, c<? super x> cVar);
}
