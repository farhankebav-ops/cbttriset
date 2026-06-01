package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzcin;
import com.google.android.gms.internal.ads.zzegj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzv extends zzu {
    @Override // com.google.android.gms.ads.internal.util.zzt, com.google.android.gms.ads.internal.util.zzz
    public final zzchj zzb(zzcgy zzcgyVar, zzbdt zzbdtVar, boolean z2, @Nullable zzegj zzegjVar) {
        return new zzcin(zzcgyVar, zzbdtVar, z2, zzegjVar);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final zzbdz.zzq zzf(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzt.zzc();
        return zzs.zzE(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzbdz.zzq.ENUM_TRUE : zzbdz.zzq.ENUM_FALSE : zzbdz.zzq.ENUM_FALSE;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final void zzg(Context context, String str, String str2) {
        com.facebook.ads.internal.dynamicloading.a.D();
        NotificationChannel notificationChannelD = com.facebook.ads.internal.dynamicloading.a.d(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjr)).intValue());
        notificationChannelD.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelD);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final boolean zzh(Context context, String str) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    @Nullable
    public final Intent zzi(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }
}
