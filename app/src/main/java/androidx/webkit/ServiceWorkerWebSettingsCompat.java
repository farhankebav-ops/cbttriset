package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@AnyThread
public abstract class ServiceWorkerWebSettingsCompat {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CacheMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ServiceWorkerWebSettingsCompat() {
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getBlockNetworkLoads();

    public abstract int getCacheMode();

    @NonNull
    public abstract Set<String> getRequestedWithHeaderOriginAllowList();

    public abstract void setAllowContentAccess(boolean z2);

    public abstract void setAllowFileAccess(boolean z2);

    public abstract void setBlockNetworkLoads(boolean z2);

    public abstract void setCacheMode(int i2);

    public abstract void setRequestedWithHeaderOriginAllowList(@NonNull Set<String> set);
}
