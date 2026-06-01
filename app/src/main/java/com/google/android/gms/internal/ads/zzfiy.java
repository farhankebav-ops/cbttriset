package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfiy {
    private final zzfic zza;
    private final zzfiv zzb;
    private final zzfhy zzc;
    private zzfje zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfiy(zzfic zzficVar, zzfhy zzfhyVar, zzfiv zzfivVar) {
        this.zza = zzficVar;
        this.zzc = zzfhyVar;
        this.zzb = zzfivVar;
        zzfhyVar.zza(new zzfhx() { // from class: com.google.android.gms.internal.ads.zzfix
            @Override // com.google.android.gms.internal.ads.zzfhx
            public final /* synthetic */ void zza() {
                this.zza.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzd() {
        zzfiw zzfiwVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgO)).booleanValue() && !com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzi()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (arrayDeque.isEmpty()) {
                    break;
                }
                zzfiwVar = (zzfiw) arrayDeque.pollFirst();
                if (zzfiwVar == null || (zzfiwVar.zzb() != null && this.zza.zzc(zzfiwVar.zzb()))) {
                    break;
                }
            }
            zzfje zzfjeVar = new zzfje(this.zza, this.zzb, zzfiwVar);
            this.zze = zzfjeVar;
            zzfjeVar.zza(new zzfit(this, zzfiwVar));
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfiw zzfiwVar) {
        this.zzd.add(zzfiwVar);
    }

    @Nullable
    public final synchronized j2.q zzb(zzfiw zzfiwVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfiwVar);
    }

    public final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzd();
        }
    }

    public final /* synthetic */ ArrayDeque zze() {
        return this.zzd;
    }

    public final /* synthetic */ void zzf(zzfje zzfjeVar) {
        this.zze = null;
    }

    public final /* synthetic */ int zzg() {
        return this.zzf;
    }
}
