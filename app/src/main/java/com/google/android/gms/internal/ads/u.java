package com.google.android.gms.internal.ads;

import android.app.NotificationChannel;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.view.autofill.AutofillId;
import com.google.firebase.messaging.CommonNotificationBuilder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class u {
    public static /* synthetic */ NotificationChannel d(String str) {
        return new NotificationChannel(CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL, str, 3);
    }

    public static /* bridge */ /* synthetic */ AutofillId f(Object obj) {
        return (AutofillId) obj;
    }

    public static /* bridge */ /* synthetic */ boolean z(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }
}
