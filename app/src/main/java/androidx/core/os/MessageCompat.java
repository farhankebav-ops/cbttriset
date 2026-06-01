package androidx.core.os;

import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        public static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        @DoNotInline
        public static void setAsynchronous(Message message, boolean z2) {
            message.setAsynchronous(z2);
        }
    }

    private MessageCompat() {
    }

    public static boolean isAsynchronous(@NonNull Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    public static void setAsynchronous(@NonNull Message message, boolean z2) {
        Api22Impl.setAsynchronous(message, z2);
    }
}
