package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdma {
    public static final zzdma zza = new zzdma(new zzdlz());

    @Nullable
    private final zzbjj zzb;

    @Nullable
    private final zzbjg zzc;

    @Nullable
    private final zzbjw zzd;

    @Nullable
    private final zzbjt zze;

    @Nullable
    private final zzbor zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    public /* synthetic */ zzdma(zzdlz zzdlzVar, byte[] bArr) {
        this(zzdlzVar);
    }

    @Nullable
    public final zzbjj zza() {
        return this.zzb;
    }

    @Nullable
    public final zzbjg zzb() {
        return this.zzc;
    }

    @Nullable
    public final zzbjw zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzbjt zzd() {
        return this.zze;
    }

    @Nullable
    public final zzbor zze() {
        return this.zzf;
    }

    @Nullable
    public final zzbjp zzf(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return (zzbjp) this.zzg.get(str);
    }

    @Nullable
    public final zzbjm zzg(String str) {
        return (zzbjm) this.zzh.get(str);
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        SimpleArrayMap simpleArrayMap = this.zzg;
        ArrayList arrayList = new ArrayList(simpleArrayMap.size());
        for (int i2 = 0; i2 < simpleArrayMap.size(); i2++) {
            arrayList.add((String) simpleArrayMap.keyAt(i2));
        }
        return arrayList;
    }

    private zzdma(zzdlz zzdlzVar) {
        this.zzb = zzdlzVar.zza;
        this.zzc = zzdlzVar.zzb;
        this.zzd = zzdlzVar.zzc;
        this.zzg = new SimpleArrayMap(zzdlzVar.zzf);
        this.zzh = new SimpleArrayMap(zzdlzVar.zzg);
        this.zze = zzdlzVar.zzd;
        this.zzf = zzdlzVar.zze;
    }
}
