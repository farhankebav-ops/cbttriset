package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbf {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze;

    public /* synthetic */ zzbf(zzbe zzbeVar, byte[] bArr) {
        int size = zzbeVar.zzd().size();
        this.zza = (String[]) zzbeVar.zzc().toArray(new String[size]);
        this.zzb = zzc(zzbeVar.zzd());
        this.zzc = zzc(zzbeVar.zze());
        this.zzd = new int[size];
        this.zze = 0;
    }

    private static final double[] zzc(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = ((Double) list.get(i2)).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d8) {
        this.zze++;
        int i2 = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i2 >= dArr.length) {
                return;
            }
            double d9 = dArr[i2];
            if (d9 <= d8 && d8 < this.zzb[i2]) {
                int[] iArr = this.zzd;
                iArr[i2] = iArr[i2] + 1;
            }
            if (d8 < d9) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final List zzb() {
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            double[] dArr = this.zzc;
            double[] dArr2 = this.zzb;
            int[] iArr = this.zzd;
            double d8 = dArr[i2];
            double d9 = dArr2[i2];
            int i8 = iArr[i2];
            arrayList.add(new zzbd(str, d8, d9, ((double) i8) / ((double) this.zze), i8));
        }
        return arrayList;
    }
}
