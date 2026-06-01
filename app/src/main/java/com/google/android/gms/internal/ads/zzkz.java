package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkz implements zzvf, zzrv {
    final /* synthetic */ zzle zza;
    private final zzlb zzb;

    public zzkz(zzle zzleVar, zzlb zzlbVar) {
        Objects.requireNonNull(zzleVar);
        this.zza = zzleVar;
        this.zzb = zzlbVar;
    }

    @Nullable
    private final Pair zzf(int i2, @Nullable zzuu zzuuVar) {
        zzuu zzuuVarZza;
        zzuu zzuuVar2 = null;
        if (zzuuVar != null) {
            zzlb zzlbVar = this.zzb;
            int i8 = 0;
            while (true) {
                List list = zzlbVar.zzc;
                if (i8 >= list.size()) {
                    zzuuVarZza = null;
                    break;
                }
                if (((zzuu) list.get(i8)).zzd == zzuuVar.zzd) {
                    Object obj = zzuuVar.zza;
                    Object obj2 = zzlbVar.zzb;
                    int i9 = zzll.zzb;
                    zzuuVarZza = zzuuVar.zza(Pair.create(obj2, obj));
                    break;
                }
                i8++;
            }
            if (zzuuVarZza == null) {
                return null;
            }
            zzuuVar2 = zzuuVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzuuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcT(int i2, @Nullable zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar, final int i8) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzky
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcT(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar, i8);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcU(int i2, @Nullable zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzku
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcU(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcV(int i2, @Nullable zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcV(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcW(int i2, @Nullable zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar, final IOException iOException, final boolean z2) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcW(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar, iOException, z2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcX(int i2, @Nullable zzuu zzuuVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcX(((Integer) pair.first).intValue(), (zzuu) pair.second, zzuqVar);
                }
            });
        }
    }
}
