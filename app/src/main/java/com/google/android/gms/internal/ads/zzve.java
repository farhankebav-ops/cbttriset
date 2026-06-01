package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzve {
    public final int zza;

    @Nullable
    public final zzuu zzb;
    private final CopyOnWriteArrayList zzc;

    private zzve(CopyOnWriteArrayList copyOnWriteArrayList, int i2, @Nullable zzuu zzuuVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuuVar;
    }

    @CheckResult
    public final zzve zza(int i2, @Nullable zzuu zzuuVar) {
        return new zzve(this.zzc, 0, zzuuVar);
    }

    public final void zzb(Handler handler, zzvf zzvfVar) {
        this.zzc.add(new zzux(handler, zzvfVar));
    }

    public final void zzc(zzvf zzvfVar) {
        CopyOnWriteArrayList<zzux> copyOnWriteArrayList = this.zzc;
        for (zzux zzuxVar : copyOnWriteArrayList) {
            if (zzuxVar.zzb == zzvfVar) {
                copyOnWriteArrayList.remove(zzuxVar);
            }
        }
    }

    public final void zzd(final zzul zzulVar, final zzuq zzuqVar, final int i2) {
        zzi(new zzdg() { // from class: com.google.android.gms.internal.ads.zzvd
            @Override // com.google.android.gms.internal.ads.zzdg
            public final /* synthetic */ void zza(Object obj) {
                ((zzvf) obj).zzcT(0, this.zza.zzb, zzulVar, zzuqVar, i2);
            }
        });
    }

    public final void zze(final zzul zzulVar, final zzuq zzuqVar) {
        zzi(new zzdg() { // from class: com.google.android.gms.internal.ads.zzuy
            @Override // com.google.android.gms.internal.ads.zzdg
            public final /* synthetic */ void zza(Object obj) {
                ((zzvf) obj).zzcU(0, this.zza.zzb, zzulVar, zzuqVar);
            }
        });
    }

    public final void zzf(final zzul zzulVar, final zzuq zzuqVar) {
        zzi(new zzdg() { // from class: com.google.android.gms.internal.ads.zzuz
            @Override // com.google.android.gms.internal.ads.zzdg
            public final /* synthetic */ void zza(Object obj) {
                ((zzvf) obj).zzcV(0, this.zza.zzb, zzulVar, zzuqVar);
            }
        });
    }

    public final void zzg(final zzul zzulVar, final zzuq zzuqVar, final IOException iOException, final boolean z2) {
        zzi(new zzdg() { // from class: com.google.android.gms.internal.ads.zzva
            @Override // com.google.android.gms.internal.ads.zzdg
            public final /* synthetic */ void zza(Object obj) {
                ((zzvf) obj).zzcW(0, this.zza.zzb, zzulVar, zzuqVar, iOException, z2);
            }
        });
    }

    public final void zzh(final zzuq zzuqVar) {
        zzi(new zzdg() { // from class: com.google.android.gms.internal.ads.zzvb
            @Override // com.google.android.gms.internal.ads.zzdg
            public final /* synthetic */ void zza(Object obj) {
                ((zzvf) obj).zzcX(0, this.zza.zzb, zzuqVar);
            }
        });
    }

    public final void zzi(final zzdg zzdgVar) {
        for (zzux zzuxVar : this.zzc) {
            final zzvf zzvfVar = zzuxVar.zzb;
            zzep.zzd(zzuxVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzvc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdgVar.zza(zzvfVar);
                }
            });
        }
    }

    public zzve() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
