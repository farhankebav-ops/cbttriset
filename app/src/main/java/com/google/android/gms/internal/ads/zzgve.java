package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgve extends zzgtz {
    private j2.q zza;
    private ScheduledFuture zzb;

    private zzgve(j2.q qVar) {
        qVar.getClass();
        this.zza = qVar;
    }

    public static j2.q zze(j2.q qVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgve zzgveVar = new zzgve(qVar);
        zzgvc zzgvcVar = new zzgvc(zzgveVar);
        zzgveVar.zzb = scheduledExecutorService.schedule(zzgvcVar, j, timeUnit);
        qVar.addListener(zzgvcVar, zzgtx.INSTANCE);
        return zzgveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzc() {
        zzm(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        j2.q qVar = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (qVar == null) {
            return null;
        }
        String string = qVar.toString();
        String strS = a1.a.s(new StringBuilder(string.length() + 14), "inputFuture=[", string, C2300e4.i.e);
        if (scheduledFuture == null) {
            return strS;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strS;
        }
        int length = strS.length();
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + length + 19 + 4);
        sb.append(strS);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public final /* synthetic */ j2.q zzf() {
        return this.zza;
    }

    public final /* synthetic */ ScheduledFuture zzx() {
        return this.zzb;
    }

    public final /* synthetic */ void zzy(ScheduledFuture scheduledFuture) {
        this.zzb = null;
    }
}
