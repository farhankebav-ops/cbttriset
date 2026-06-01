package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(@NonNull String str, @Nullable Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void i(@NonNull String str) {
        Log.i(TAG, str);
    }

    public static void w(@NonNull String str) {
        Log.w(TAG, str);
    }
}
