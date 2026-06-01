package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgth extends zzgtz implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    j2.q zza;
    Object zzb;

    public zzgth(j2.q qVar, Object obj) {
        qVar.getClass();
        this.zza = qVar;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j2.q qVar = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (qVar == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (qVar.isCancelled()) {
            zzk(qVar);
            return;
        }
        try {
            try {
                Object objZzf = zzf(obj, zzgui.zzs(qVar));
                this.zzb = null;
                zze(objZzf);
            } catch (Throwable th) {
                try {
                    zzgva.zza(th);
                    zzb(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e) {
            zzb(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e4) {
            zzb(e4.getCause());
        } catch (Exception e8) {
            zzb(e8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzc() {
        zzm(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        String strS;
        j2.q qVar = this.zza;
        Object obj = this.zzb;
        String strZzd = super.zzd();
        if (qVar != null) {
            String string = qVar.toString();
            strS = a1.a.s(new StringBuilder(string.length() + 16), "inputFuture=[", string, "], ");
        } else {
            strS = "";
        }
        if (obj == null) {
            if (strZzd != null) {
                return strS.concat(strZzd);
            }
            return null;
        }
        int length = strS.length();
        String string2 = obj.toString();
        return androidx.camera.core.processing.util.a.n(new StringBuilder(string2.length() + length + 10 + 1), strS, "function=[", string2, C2300e4.i.e);
    }

    public abstract void zze(Object obj);

    public abstract Object zzf(Object obj, Object obj2) throws Exception;
}
