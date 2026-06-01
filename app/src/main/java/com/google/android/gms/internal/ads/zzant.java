package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzant {
    private final List zza;
    private final zzaem[] zzc;
    private final String zzb = "video/mp2t";
    private final zzfq zzd = new zzfq(new zzfp() { // from class: com.google.android.gms.internal.ads.zzans
        @Override // com.google.android.gms.internal.ads.zzfp
        public final /* synthetic */ void zza(long j, zzeg zzegVar) {
            this.zza.zzf(j, zzegVar);
        }
    });

    public zzant(List list, String str) {
        this.zza = list;
        this.zzc = new zzaem[list.size()];
    }

    public final void zza(zzadd zzaddVar, zzaoe zzaoeVar) {
        int i2 = 0;
        while (true) {
            zzaem[] zzaemVarArr = this.zzc;
            if (i2 >= zzaemVarArr.length) {
                return;
            }
            zzaoeVar.zza();
            zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 3);
            zzv zzvVar = (zzv) this.zza.get(i2);
            String str = zzvVar.zzo;
            boolean z2 = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z2 = false;
            }
            zzgmd.zzf(z2, "Invalid closed caption MIME type provided: %s", str);
            String strZzc = zzvVar.zza;
            if (strZzc == null) {
                strZzc = zzaoeVar.zzc();
            }
            zzt zztVar = new zzt();
            zztVar.zza(strZzc);
            zztVar.zzl(this.zzb);
            zztVar.zzm(str);
            zztVar.zzf(zzvVar.zze);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzJ(zzvVar.zzL);
            zztVar.zzp(zzvVar.zzr);
            zzaemVarZzu.zzu(zztVar.zzM());
            zzaemVarArr[i2] = zzaemVarZzu;
            i2++;
        }
    }

    public final void zzb(int i2) {
        this.zzd.zza(i2);
    }

    public final void zzc(long j, zzeg zzegVar) {
        this.zzd.zzc(j, zzegVar);
    }

    public final void zzd() {
        this.zzd.zze();
    }

    public final void zze() {
        this.zzd.zze();
    }

    public final /* synthetic */ void zzf(long j, zzeg zzegVar) {
        zzacn.zza(j, zzegVar, this.zzc);
    }
}
