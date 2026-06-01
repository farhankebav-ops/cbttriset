package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzht zza;

    public zzhn(zzht zzhtVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i2, String str, List list, boolean z2, boolean z7) {
        int i8 = i2 - 1;
        zzgs zzgsVarZzi = i8 != 0 ? i8 != 1 ? i8 != 3 ? i8 != 4 ? this.zza.zzu.zzaV().zzi() : z2 ? this.zza.zzu.zzaV().zzf() : !z7 ? this.zza.zzu.zzaV().zzh() : this.zza.zzu.zzaV().zze() : this.zza.zzu.zzaV().zzk() : z2 ? this.zza.zzu.zzaV().zzc() : !z7 ? this.zza.zzu.zzaV().zzd() : this.zza.zzu.zzaV().zzb() : this.zza.zzu.zzaV().zzj();
        int size = list.size();
        if (size == 1) {
            zzgsVarZzi.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgsVarZzi.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgsVarZzi.zza(str);
        } else {
            zzgsVarZzi.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
