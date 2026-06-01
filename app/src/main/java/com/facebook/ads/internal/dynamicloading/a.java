package com.facebook.ads.internal.dynamicloading;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;
import dalvik.system.InMemoryDexClassLoader;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ NotificationChannel d(int i2) {
        return new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", i2);
    }

    public static /* synthetic */ NotificationChannel f(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ AudioFocusRequest.Builder h() {
        return new AudioFocusRequest.Builder(1);
    }

    public static /* bridge */ /* synthetic */ AudioFocusRequest m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ InMemoryDexClassLoader o(ByteBuffer byteBuffer, ClassLoader classLoader) {
        return new InMemoryDexClassLoader(byteBuffer, classLoader);
    }

    public static /* synthetic */ void s() {
    }
}
