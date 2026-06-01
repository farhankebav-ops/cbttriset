package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adselection.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension(extension = 1000000, version = 4)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AppSetIdManagerApi33Ext4Impl extends AppSetIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public AppSetIdManagerApi33Ext4Impl(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService((Class<Object>) a.w());
        k.d(systemService, "context.getSystemService…SetIdManager::class.java)");
        super(a.f(systemService));
    }
}
