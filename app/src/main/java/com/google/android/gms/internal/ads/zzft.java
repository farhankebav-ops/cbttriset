package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzft implements zzgb {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;

    @Nullable
    private zzgf zzd;

    public zzft(boolean z2) {
        this.zza = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
        zzgzVar.getClass();
        ArrayList arrayList = this.zzb;
        if (arrayList.contains(zzgzVar)) {
            return;
        }
        arrayList.add(zzgzVar);
        this.zzc++;
    }

    public final void zzf(zzgf zzgfVar) {
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzgz) this.zzb.get(i2)).zza(this, zzgfVar, this.zza);
        }
    }

    public final void zzg(zzgf zzgfVar) {
        this.zzd = zzgfVar;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzgz) this.zzb.get(i2)).zzb(this, zzgfVar, this.zza);
        }
    }

    public final void zzh(int i2) {
        zzgf zzgfVar = this.zzd;
        String str = zzep.zza;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            ((zzgz) this.zzb.get(i8)).zzc(this, zzgfVar, this.zza, i2);
        }
    }

    public final void zzi() {
        zzgf zzgfVar = this.zzd;
        String str = zzep.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzgz) this.zzb.get(i2)).zzd(this, zzgfVar, this.zza);
        }
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public /* synthetic */ Map zzj() {
        return t.a(this);
    }
}
