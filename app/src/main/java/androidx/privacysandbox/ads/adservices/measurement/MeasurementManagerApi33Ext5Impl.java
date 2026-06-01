package androidx.privacysandbox.ads.adservices.measurement;

import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension(extension = 1000000, version = 5)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MeasurementManagerApi33Ext5Impl extends MeasurementManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public MeasurementManagerApi33Ext5Impl(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService((Class<Object>) androidx.privacysandbox.ads.adservices.customaudience.a.v());
        k.d(systemService, "context.getSystemService…ementManager::class.java)");
        super(androidx.privacysandbox.ads.adservices.customaudience.a.u(systemService));
    }
}
