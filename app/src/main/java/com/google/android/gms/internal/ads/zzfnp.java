package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfnp extends zzfom {
    public zzfnp(ClientApi clientApi, Context context, int i2, zzfhj zzfhjVar, com.google.android.gms.ads.internal.client.zzft zzftVar, @Nullable com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfnq zzfnqVar, Clock clock) {
        super(clientApi, context, i2, zzfhjVar, zzftVar, zzceVar, scheduledExecutorService, zzfnqVar, clock);
    }

    @Override // com.google.android.gms.internal.ads.zzfom
    public final j2.q zza(Context context) {
        zzbrj zzbrjVarZzd = this.zzd.zzd();
        if (zzbrjVarZzd == null) {
            return zzgui.zzc(new zzfni(1, "Failed to create an app open ad manager."));
        }
        com.google.android.gms.ads.internal.client.zzbx zzbxVarZzm = this.zza.zzm(ObjectWrapper.wrap(context), com.google.android.gms.ads.internal.client.zzr.zzd(), this.zze.zza, zzbrjVarZzd, this.zzc);
        if (zzbxVarZzm == null) {
            return zzgui.zzc(new zzfni(1, "Failed to create an app open ad manager."));
        }
        zzgvb zzgvbVarZze = zzgvb.zze();
        try {
            zzs(this.zze.zzc);
            zzbxVarZzm.zzJ(new zzfno(this, zzgvbVarZze, this.zze));
            zzbxVarZzm.zze(this.zze.zzc);
            return zzgvbVarZze;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load app open ad.", e);
            return zzgui.zzc(new zzfni(1, "remote exception"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfom
    @Nullable
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea zzb(Object obj) {
        try {
            return ((zzbcn) obj).zzg();
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Failed to get response info for the app open ad.", e);
            return null;
        }
    }

    public zzfnp(String str, ClientApi clientApi, Context context, int i2, zzfhj zzfhjVar, com.google.android.gms.ads.internal.client.zzft zzftVar, @Nullable com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfnq zzfnqVar, Clock clock) {
        super(str, clientApi, context, i2, zzfhjVar, zzftVar, zzchVar, scheduledExecutorService, zzfnqVar, clock);
    }
}
