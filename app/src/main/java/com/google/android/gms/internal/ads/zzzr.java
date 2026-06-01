package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzr {
    private static final Comparator zza = zzzq.zza;
    private static final Comparator zzb = zzzp.zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzo[] zzd = new zzzo[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzr(int i2) {
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int i2, float f4) {
        zzzo zzzoVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i8 = this.zzh;
        if (i8 > 0) {
            zzzo[] zzzoVarArr = this.zzd;
            int i9 = i8 - 1;
            this.zzh = i9;
            zzzoVar = zzzoVarArr[i9];
        } else {
            zzzoVar = new zzzo(null);
        }
        int i10 = this.zzf;
        this.zzf = i10 + 1;
        zzzoVar.zza = i10;
        zzzoVar.zzb = i2;
        zzzoVar.zzc = f4;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzzoVar);
        this.zzg += i2;
        while (true) {
            int i11 = this.zzg;
            if (i11 <= 2000) {
                return;
            }
            int i12 = i11 - 2000;
            zzzo zzzoVar2 = (zzzo) arrayList.get(0);
            int i13 = zzzoVar2.zzb;
            if (i13 <= i12) {
                this.zzg -= i13;
                arrayList.remove(0);
                int i14 = this.zzh;
                if (i14 < 5) {
                    zzzo[] zzzoVarArr2 = this.zzd;
                    this.zzh = i14 + 1;
                    zzzoVarArr2[i14] = zzzoVar2;
                }
            } else {
                zzzoVar2.zzb = i13 - i12;
                this.zzg -= i12;
            }
        }
    }

    public final float zzc(float f4) {
        int i2 = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f8 = this.zzg;
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i2 >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzzo) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f9 = 0.5f * f8;
            zzzo zzzoVar = (zzzo) arrayList.get(i2);
            i8 += zzzoVar.zzb;
            if (i8 >= f9) {
                return zzzoVar.zzc;
            }
            i2++;
        }
    }
}
