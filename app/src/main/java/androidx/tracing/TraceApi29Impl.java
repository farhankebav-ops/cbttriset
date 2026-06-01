package androidx.tracing;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i2) {
        android.os.Trace.beginAsyncSection(str, i2);
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        android.os.Trace.endAsyncSection(str, i2);
    }

    @DoNotInline
    public static boolean isEnabled() {
        return android.os.Trace.isEnabled();
    }

    public static void setCounter(@NonNull String str, int i2) {
        android.os.Trace.setCounter(str, i2);
    }
}
