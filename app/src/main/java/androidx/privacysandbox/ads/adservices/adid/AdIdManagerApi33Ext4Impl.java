package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.w0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension(extension = 1000000, version = 4)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AdIdManagerApi33Ext4Impl extends AdIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public AdIdManagerApi33Ext4Impl(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService((Class<Object>) w0.q());
        k.d(systemService, "context.getSystemService….AdIdManager::class.java)");
        super(w0.c(systemService));
    }
}
