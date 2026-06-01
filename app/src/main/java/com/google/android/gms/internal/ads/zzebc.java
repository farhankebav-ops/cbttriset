package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzebc implements zzeci {
    private static final Pattern zzh = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzead zza;
    private final zzgus zzb;
    private final zzfgn zzc;
    private final ScheduledExecutorService zzd;
    private final zzeev zze;
    private final zzflm zzf;
    private final Context zzg;

    public zzebc(Context context, zzfgn zzfgnVar, zzead zzeadVar, zzgus zzgusVar, ScheduledExecutorService scheduledExecutorService, zzeev zzeevVar, zzflm zzflmVar) {
        this.zzg = context;
        this.zzc = zzfgnVar;
        this.zza = zzeadVar;
        this.zzb = zzgusVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeevVar;
        this.zzf = zzflmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final j2.q zza(zzbxj zzbxjVar) {
        Context context = this.zzg;
        j2.q qVarZza = this.zza.zza(zzbxjVar);
        zzflc zzflcVarA = r.a(context, 11);
        zzfll.zzb(qVarZza, zzflcVarA);
        j2.q qVarZzj = zzgui.zzj(qVarZza, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebb
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzb((zzeck) obj);
            }
        }, this.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgh)).booleanValue()) {
            qVarZzj = zzgui.zzh(zzgui.zzi(qVarZzj, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgi)).intValue(), TimeUnit.SECONDS, this.zzd), TimeoutException.class, zzeba.zza, zzcbv.zzg);
        }
        zzfll.zzd(qVarZzj, this.zzf, zzflcVarA);
        zzgui.zzr(qVarZzj, new zzeaz(this), zzcbv.zzg);
        return qVarZzj;
    }

    public final /* synthetic */ j2.q zzb(zzeck zzeckVar) {
        return zzgui.zza(new zzfgf(new zzfgc(this.zzc), zzfge.zza(new InputStreamReader(zzeckVar.zza()), zzeckVar.zzb().zzm)));
    }

    public final /* synthetic */ zzeev zzc() {
        return this.zze;
    }
}
