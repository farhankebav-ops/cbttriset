package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgvc implements Runnable {
    zzgve zza;

    public zzgvc(zzgve zzgveVar) {
        this.zza = zzgveVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j2.q qVarZzf;
        zzgve zzgveVar = this.zza;
        if (zzgveVar == null || (qVarZzf = zzgveVar.zzf()) == null) {
            return;
        }
        this.zza = null;
        if (qVarZzf.isDone()) {
            zzgveVar.zzk(qVarZzf);
            return;
        }
        try {
            ScheduledFuture scheduledFutureZzx = zzgveVar.zzx();
            zzgveVar.zzy(null);
            String string = "Timed out";
            if (scheduledFutureZzx != null) {
                try {
                    long jAbs = Math.abs(scheduledFutureZzx.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        StringBuilder sb = new StringBuilder(String.valueOf(jAbs).length() + 55);
                        sb.append("Timed out (timeout delayed by ");
                        sb.append(jAbs);
                        sb.append(" ms after scheduled time)");
                        string = sb.toString();
                    }
                } catch (Throwable th) {
                    zzgveVar.zzb(new zzgvd(string, null));
                    throw th;
                }
            }
            String string2 = qVarZzf.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 2 + string2.length());
            sb2.append(string);
            sb2.append(": ");
            sb2.append(string2);
            zzgveVar.zzb(new zzgvd(sb2.toString(), null));
        } finally {
            qVarZzf.cancel(true);
        }
    }
}
