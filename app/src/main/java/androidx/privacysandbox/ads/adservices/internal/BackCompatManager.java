package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import android.util.Log;
import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BackCompatManager {
    public static final BackCompatManager INSTANCE = new BackCompatManager();

    private BackCompatManager() {
    }

    public final <T> T getManager(Context context, String tag, l manager) {
        k.e(context, "context");
        k.e(tag, "tag");
        k.e(manager, "manager");
        try {
            return (T) manager.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(tag, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + AdServicesInfo.INSTANCE.extServicesVersionS());
            return null;
        }
    }
}
