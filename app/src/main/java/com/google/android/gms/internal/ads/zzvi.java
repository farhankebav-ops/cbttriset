package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvi implements zzus, zzur {
    private final zzus[] zza;
    private final boolean[] zzb;

    @Nullable
    private zzur zzf;

    @Nullable
    private zzwv zzg;
    private final ArrayList zzd = new ArrayList();
    private final HashMap zze = new HashMap();
    private zzwm zzi = new zzue(zzgpe.zzi(), zzgpe.zzi());
    private final IdentityHashMap zzc = new IdentityHashMap();
    private zzus[] zzh = new zzus[0];

    public zzvi(zzuf zzufVar, long[] jArr, zzus... zzusVarArr) {
        this.zza = zzusVarArr;
        this.zzb = new boolean[zzusVarArr.length];
        for (int i2 = 0; i2 < zzusVarArr.length; i2++) {
            long j = jArr[i2];
            if (j != 0) {
                this.zzb[i2] = true;
                this.zza[i2] = new zzws(zzusVarArr[i2], j);
            }
        }
    }

    public final zzus zza(int i2) {
        return this.zzb[i2] ? ((zzws) this.zza[i2]).zza() : this.zza[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzf = zzurVar;
        ArrayList arrayList = this.zzd;
        zzus[] zzusVarArr = this.zza;
        Collections.addAll(arrayList, zzusVarArr);
        for (zzus zzusVar : zzusVarArr) {
            zzusVar.zzb(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        int i2 = 0;
        while (true) {
            zzus[] zzusVarArr = this.zza;
            if (i2 >= zzusVarArr.length) {
                return;
            }
            zzusVarArr[i2].zzc();
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzwv zzwvVar = this.zzg;
        zzwvVar.getClass();
        return zzwvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        int length;
        int[] iArr;
        int length2 = zzykVarArr.length;
        int[] iArr2 = new int[length2];
        int[] iArr3 = new int[length2];
        int i2 = 0;
        int i8 = 0;
        while (true) {
            length = zzykVarArr.length;
            if (i8 >= length) {
                break;
            }
            zzwk zzwkVar = zzwkVarArr[i8];
            Integer num = zzwkVar == null ? null : (Integer) this.zzc.get(zzwkVar);
            iArr2[i8] = num == null ? -1 : num.intValue();
            zzyk zzykVar = zzykVarArr[i8];
            if (zzykVar != null) {
                String str = zzykVar.zza().zzb;
                iArr3[i8] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i8] = -1;
            }
            i8++;
        }
        IdentityHashMap identityHashMap = this.zzc;
        identityHashMap.clear();
        zzus[] zzusVarArr = this.zza;
        zzwk[] zzwkVarArr2 = new zzwk[length];
        zzwk[] zzwkVarArr3 = new zzwk[length];
        zzyk[] zzykVarArr2 = new zzyk[length];
        ArrayList arrayList = new ArrayList(zzusVarArr.length);
        long j3 = j;
        int i9 = 0;
        while (i9 < zzusVarArr.length) {
            int i10 = i2;
            while (i10 < zzykVarArr.length) {
                zzwkVarArr3[i10] = iArr2[i10] == i9 ? zzwkVarArr[i10] : null;
                if (iArr3[i10] == i9) {
                    zzyk zzykVar2 = zzykVarArr[i10];
                    zzykVar2.getClass();
                    iArr = iArr3;
                    zzbg zzbgVar = (zzbg) this.zze.get(zzykVar2.zza());
                    zzbgVar.getClass();
                    zzykVarArr2[i10] = new zzvh(zzykVar2, zzbgVar);
                } else {
                    iArr = iArr3;
                    zzykVarArr2[i10] = null;
                }
                i10++;
                iArr3 = iArr;
            }
            int[] iArr4 = iArr3;
            ArrayList arrayList2 = arrayList;
            int i11 = i9;
            long jZze = zzusVarArr[i9].zze(zzykVarArr2, zArr, zzwkVarArr3, zArr2, j3);
            if (i11 == 0) {
                j3 = jZze;
            } else if (jZze != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i12 = 0; i12 < zzykVarArr.length; i12++) {
                if (iArr4[i12] == i11) {
                    zzwk zzwkVar2 = zzwkVarArr3[i12];
                    zzwkVar2.getClass();
                    zzwkVarArr2[i12] = zzwkVar2;
                    identityHashMap.put(zzwkVar2, Integer.valueOf(i11));
                    z2 = true;
                } else if (iArr2[i12] == i11) {
                    zzgmd.zzh(zzwkVarArr3[i12] == null);
                }
            }
            if (z2) {
                arrayList2.add(zzusVarArr[i11]);
            }
            i9 = i11 + 1;
            arrayList = arrayList2;
            iArr3 = iArr4;
            i2 = 0;
        }
        int i13 = i2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzwkVarArr2, i13, zzwkVarArr, i13, length);
        this.zzh = (zzus[]) arrayList3.toArray(new zzus[i13]);
        this.zzi = new zzue(arrayList3, zzgqe.zzc(arrayList3, zzvg.zza));
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z2) {
        for (zzus zzusVar : this.zzh) {
            zzusVar.zzf(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zzi.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        long j = -9223372036854775807L;
        for (zzus zzusVar : this.zzh) {
            long jZzh = zzusVar.zzh();
            if (jZzh == -9223372036854775807L) {
                if (j != -9223372036854775807L && zzusVar.zzj(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (zzus zzusVar2 : this.zzh) {
                    if (zzusVar2 == zzusVar) {
                        break;
                    }
                    if (zzusVar2.zzj(jZzh) != jZzh) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzh;
            } else if (jZzh != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        return this.zzi.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        long jZzj = this.zzh[0].zzj(j);
        int i2 = 1;
        while (true) {
            zzus[] zzusVarArr = this.zzh;
            if (i2 >= zzusVarArr.length) {
                return jZzj;
            }
            if (zzusVarArr[i2].zzj(jZzj) != jZzj) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        zzus[] zzusVarArr = this.zzh;
        return (zzusVarArr.length > 0 ? zzusVarArr[0] : this.zza[0]).zzk(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return this.zzi.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        ArrayList arrayList = this.zzd;
        if (arrayList.isEmpty()) {
            return this.zzi.zzm(zzknVar);
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzus) arrayList.get(i2)).zzm(zzknVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zzi.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        ArrayList arrayList = this.zzd;
        arrayList.remove(zzusVar);
        if (arrayList.isEmpty()) {
            zzus[] zzusVarArr = this.zza;
            int i2 = 0;
            for (zzus zzusVar2 : zzusVarArr) {
                i2 += zzusVar2.zzd().zzb;
            }
            zzbg[] zzbgVarArr = new zzbg[i2];
            int i8 = 0;
            for (int i9 = 0; i9 < zzusVarArr.length; i9++) {
                zzwv zzwvVarZzd = zzusVarArr[i9].zzd();
                int i10 = zzwvVarZzd.zzb;
                int i11 = 0;
                while (i11 < i10) {
                    zzbg zzbgVarZza = zzwvVarZzd.zza(i11);
                    int i12 = zzbgVarZza.zza;
                    zzv[] zzvVarArr = new zzv[i12];
                    int i13 = 0;
                    while (i13 < i12) {
                        zzv zzvVarZza = zzbgVarZza.zza(i13);
                        zzt zztVarZza = zzvVarZza.zza();
                        String str = zzvVarZza.zza;
                        if (str == null) {
                            str = "";
                        }
                        zzus[] zzusVarArr2 = zzusVarArr;
                        StringBuilder sb = new StringBuilder(str.length() + com.google.android.gms.ads.internal.client.a.a(i9, 1));
                        sb.append(i9);
                        sb.append(":");
                        sb.append(str);
                        zztVarZza.zza(sb.toString());
                        zzvVarArr[i13] = zztVarZza.zzM();
                        i13++;
                        zzusVarArr = zzusVarArr2;
                    }
                    zzus[] zzusVarArr3 = zzusVarArr;
                    String str2 = zzbgVarZza.zzb;
                    StringBuilder sb2 = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i9, 1) + String.valueOf(str2).length());
                    sb2.append(i9);
                    sb2.append(":");
                    sb2.append(str2);
                    zzbg zzbgVar = new zzbg(sb2.toString(), zzvVarArr);
                    this.zze.put(zzbgVar, zzbgVarZza);
                    zzbgVarArr[i8] = zzbgVar;
                    i11++;
                    i8++;
                    zzusVarArr = zzusVarArr3;
                }
            }
            this.zzg = new zzwv(zzbgVarArr);
            zzur zzurVar = this.zzf;
            zzurVar.getClass();
            zzurVar.zzp(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        zzur zzurVar = this.zzf;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }
}
