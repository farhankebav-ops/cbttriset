package k3;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import com.google.firebase.messaging.CommonNotificationBuilder;
import java.lang.invoke.MethodHandles;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ NotificationChannel b() {
        return new NotificationChannel("restored_OS_notifications", "Restored", 2);
    }

    public static /* synthetic */ NotificationChannel c(int i2, String str, String str2) {
        return new NotificationChannel(str, str2, i2);
    }

    public static /* synthetic */ NotificationChannelGroup d(String str, String str2) {
        return new NotificationChannelGroup(str, str2);
    }

    public static /* bridge */ /* synthetic */ Class e() {
        return MethodHandles.Lookup.class;
    }

    public static /* bridge */ /* synthetic */ MethodHandles.Lookup h(Object obj) {
        return (MethodHandles.Lookup) obj;
    }

    public static /* synthetic */ NotificationChannel w() {
        return new NotificationChannel(CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL, "Miscellaneous", 3);
    }
}
