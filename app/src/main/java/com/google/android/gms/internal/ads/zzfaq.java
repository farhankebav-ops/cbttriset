package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfaq implements zzeya {
    private final zzcbj zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzgus zzd;
    private final int zze;
    private final int zzf;

    public zzfaq(zzcbj zzcbjVar, boolean z2, zzcaz zzcazVar, zzgus zzgusVar, String str, ScheduledExecutorService scheduledExecutorService, int i2, int i8) {
        this.zza = zzcbjVar;
        this.zzb = z2;
        this.zzd = zzgusVar;
        this.zzc = scheduledExecutorService;
        this.zze = i2;
        this.zzf = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhA)).booleanValue() && this.zzb) {
            return zzgui.zza(new zzfar(null));
        }
        if (this.zzf == 2) {
            return zzgui.zza(new zzfar(null));
        }
        if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhC)).split(",")).contains(String.valueOf(this.zze))) {
            return zzgui.zza(new zzfar(null));
        }
        j2.q qVarZza = zzgui.zza(null);
        zzgus zzgusVar = this.zzd;
        return zzgui.zzg(zzgui.zzi(zzgui.zzk(qVarZza, zzfap.zza, zzgusVar), ((Long) zzbhj.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzfao
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((Exception) obj);
            }
        }, zzgusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 50;
    }

    public final /* synthetic */ zzfar zzc(Exception exc) {
        this.zza.zzg(exc, "TrustlessTokenSignal");
        return new zzfar(null);
    }
}
