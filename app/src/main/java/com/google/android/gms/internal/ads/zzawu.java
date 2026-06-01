package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawu {

    @VisibleForTesting
    protected volatile Boolean zzb;
    private final zzayd zzc;
    private static final ConditionVariable zzd = new ConditionVariable();

    @VisibleForTesting
    protected static volatile zzfto zza = null;
    private static volatile Random zze = null;

    public zzawu(zzayd zzaydVar) {
        this.zzc = zzaydVar;
        zzaydVar.zzd().execute(new zzawt(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zze == null) {
                synchronized (zzawu.class) {
                    try {
                        if (zze == null) {
                            zze = new Random();
                        }
                    } finally {
                    }
                }
            }
            return zze.nextInt();
        }
    }

    public final void zza(int i2, int i8, long j, String str, Exception exc) {
        try {
            zzd.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzati zzatiVarZza = zzatm.zza();
            zzatiVarZza.zza(this.zzc.zza.getPackageName());
            zzatiVarZza.zzb(j);
            if (str != null) {
                zzatiVarZza.zze(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzatiVarZza.zzc(stringWriter.toString());
                zzatiVarZza.zzd(exc.getClass().getName());
            }
            zzftn zzftnVarZza = zza.zza(((zzatm) zzatiVarZza.zzbu()).zzaN());
            zzftnVarZza.zzc(i2);
            if (i8 != -1) {
                zzftnVarZza.zzb(i8);
            }
            zzftnVarZza.zza();
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ zzayd zzb() {
        return this.zzc;
    }
}
