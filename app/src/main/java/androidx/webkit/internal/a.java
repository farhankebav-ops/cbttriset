package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import dalvik.system.DelegateLastClassLoader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ SafeBrowsingResponse c(Object obj) {
        return (SafeBrowsingResponse) obj;
    }

    public static /* synthetic */ DelegateLastClassLoader d(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    public static /* synthetic */ void e() {
    }
}
