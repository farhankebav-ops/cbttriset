package androidx.appcompat.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static /* bridge */ /* synthetic */ NotificationChannel g(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel h(String str, String str2) {
        return new NotificationChannel(str, str2, 3);
    }

    public static /* bridge */ /* synthetic */ NotificationChannelGroup i(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* synthetic */ JobWorkItem k(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ OutputConfiguration s(Size size, Class cls) {
        return new OutputConfiguration(size, cls);
    }
}
