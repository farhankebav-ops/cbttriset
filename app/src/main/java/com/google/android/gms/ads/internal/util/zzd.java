package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzcby;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzd {
    public static void zza(Context context) {
        int i2 = com.google.android.gms.ads.internal.util.client.zzl.zza;
        if (((Boolean) zzbgq.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 0 || com.google.android.gms.ads.internal.util.client.zzl.zzi()) {
                    return;
                }
                q qVarZzb = new zzc(context).zzb();
                int i8 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Updating ad debug logging enablement.");
                zzcby.zza(qVarZzb, "AdDebugLogUpdater.updateEnablement");
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to determine debug setting.", e);
            }
        }
    }
}
