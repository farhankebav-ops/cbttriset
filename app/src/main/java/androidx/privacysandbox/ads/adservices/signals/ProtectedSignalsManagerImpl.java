package androidx.privacysandbox.ads.adservices.signals;

import a.a;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.b;
import kotlin.jvm.internal.k;
import q5.x;
import q6.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension(extension = 1000000, version = 12)
@RestrictTo({RestrictTo.Scope.LIBRARY})
@ExperimentalFeatures.Ext12OptIn
public class ProtectedSignalsManagerImpl extends ProtectedSignalsManager {
    private final android.adservices.signals.ProtectedSignalsManager protectedSignalsManager;

    public ProtectedSignalsManagerImpl(android.adservices.signals.ProtectedSignalsManager protectedSignalsManager) {
        k.e(protectedSignalsManager, "protectedSignalsManager");
        this.protectedSignalsManager = protectedSignalsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.signals.UpdateSignalsRequest convertUpdateRequest(UpdateSignalsRequest updateSignalsRequest) {
        b.v();
        android.adservices.signals.UpdateSignalsRequest updateSignalsRequestBuild = b.g(updateSignalsRequest.getUpdateUri()).build();
        k.d(updateSignalsRequestBuild, "Builder(request.updateUri).build()");
        return updateSignalsRequestBuild;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public static Object updateSignals$suspendImpl(ProtectedSignalsManagerImpl protectedSignalsManagerImpl, UpdateSignalsRequest updateSignalsRequest, c<? super x> cVar) {
        l lVar = new l(1, a.I(cVar));
        lVar.r();
        protectedSignalsManagerImpl.protectedSignalsManager.updateSignals(protectedSignalsManagerImpl.convertUpdateRequest(updateSignalsRequest), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(lVar));
        Object objP = lVar.p();
        return objP == w5.a.f17774a ? objP : x.f13520a;
    }

    @Override // androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public Object updateSignals(UpdateSignalsRequest updateSignalsRequest, c<? super x> cVar) {
        return updateSignals$suspendImpl(this, updateSignalsRequest, cVar);
    }
}
