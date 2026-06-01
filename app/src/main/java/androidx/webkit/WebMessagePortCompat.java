package androidx.webkit;

import android.os.Handler;
import android.webkit.WebMessagePort;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@AnyThread
public abstract class WebMessagePortCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public WebMessagePortCompat() {
    }

    public abstract void close();

    @NonNull
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract WebMessagePort getFrameworkPort();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract InvocationHandler getInvocationHandler();

    public abstract void postMessage(@NonNull WebMessageCompat webMessageCompat);

    public abstract void setWebMessageCallback(@Nullable Handler handler, @NonNull WebMessageCallbackCompat webMessageCallbackCompat);

    public abstract void setWebMessageCallback(@NonNull WebMessageCallbackCompat webMessageCallbackCompat);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class WebMessageCallbackCompat {
        public void onMessage(@NonNull WebMessagePortCompat webMessagePortCompat, @Nullable WebMessageCompat webMessageCompat) {
        }
    }
}
