package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgta extends zzgtz implements Runnable {
    public static final /* synthetic */ int zzd = 0;
    j2.q zza;
    Class zzb;
    Object zzc;

    public zzgta(j2.q qVar, Class cls, Object obj) {
        qVar.getClass();
        this.zza = qVar;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        j2.q qVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((qVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = qVar instanceof zzgvk ? ((zzgvk) qVar).zzl() : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(qVar.getClass());
                String strValueOf2 = String.valueOf(e.getClass());
                StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 19 + 16);
                androidx.camera.core.processing.util.a.A(sb, "Future type ", strValueOf, " threw ", strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objZzs = th == null ? zzgui.zzs(qVar) : null;
        if (th == null) {
            zza(objZzs);
            return;
        }
        if (!cls.isInstance(th)) {
            zzk(qVar);
            return;
        }
        try {
            Object objZzf = zzf(obj, th);
            this.zzb = null;
            this.zzc = null;
            zze(objZzf);
        } catch (Throwable th2) {
            try {
                zzgva.zza(th2);
                zzb(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzc() {
        zzm(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        String strS;
        j2.q qVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZzd = super.zzd();
        if (qVar != null) {
            String string = qVar.toString();
            strS = a1.a.s(new StringBuilder(string.length() + 16), "inputFuture=[", string, "], ");
        } else {
            strS = "";
        }
        if (cls == null || obj == null) {
            if (strZzd != null) {
                return strS.concat(strZzd);
            }
            return null;
        }
        int length = strS.length();
        String string2 = cls.toString();
        int length2 = string2.length();
        String string3 = obj.toString();
        StringBuilder sb = new StringBuilder(string3.length() + length + 15 + length2 + 13 + 1);
        androidx.camera.core.processing.util.a.A(sb, strS, "exceptionType=[", string2, "], fallback=[");
        return a1.a.r(sb, string3, C2300e4.i.e);
    }

    public abstract void zze(Object obj);

    public abstract Object zzf(Object obj, Throwable th) throws Exception;
}
