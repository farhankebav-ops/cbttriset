package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension(extension = 31, version = 9)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AppSetIdManagerApi31Ext9Impl extends AppSetIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public AppSetIdManagerApi31Ext9Impl(Context context) {
        k.e(context, "context");
        android.adservices.appsetid.AppSetIdManager appSetIdManager = android.adservices.appsetid.AppSetIdManager.get(context);
        k.d(appSetIdManager, "get(context)");
        super(appSetIdManager);
    }
}
