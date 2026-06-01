package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfzl {
    private final zzifb zza;
    private final zzifb zzb;
    private final ExecutorService zzc;
    private final zzifb zzd;
    private j2.q zze = null;

    public zzfzl(zzifb zzifbVar, zzifb zzifbVar2, ExecutorService executorService, zzifb zzifbVar3) {
        this.zza = zzifbVar;
        this.zzb = zzifbVar2;
        this.zzc = executorService;
        this.zzd = zzifbVar3;
    }

    public final synchronized j2.q zza() {
        try {
            j2.q qVar = this.zze;
            if (qVar != null) {
                return qVar;
            }
            Set set = (Set) this.zzb.zzb();
            ArrayList arrayList = new ArrayList(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzfzj) it.next()).zza());
            }
            zzgjd zzgjdVar = (zzgjd) this.zzd.zzb();
            j2.q qVarZzk = zzgui.zzk(zzgui.zzm(arrayList), zzfzk.zza, this.zzc);
            zzgjdVar.zze(2, qVarZzk);
            this.zze = qVarZzk;
            Iterator it2 = ((Set) this.zza.zzb()).iterator();
            while (it2.hasNext()) {
                ((zzfzj) it2.next()).zza();
            }
            j2.q qVar2 = this.zze;
            if (qVar2 != null) {
                return qVar2;
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized j2.q zzb() {
        j2.q qVar;
        qVar = this.zze;
        if (qVar == null) {
            throw null;
        }
        return qVar;
    }
}
