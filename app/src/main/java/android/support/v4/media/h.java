package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3265b = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3266a;

    public h(Context context, ComponentName componentName, c cVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3266a = new e(context, componentName, cVar);
        } else {
            this.f3266a = new d(context, componentName, cVar);
        }
    }
}
