package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacf {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final float zzk;

    @Nullable
    public final String zzl;

    private zzacf(List list, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, float f4, @Nullable String str) {
        this.zza = list;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = i9;
        this.zze = i10;
        this.zzf = i11;
        this.zzg = i12;
        this.zzh = i13;
        this.zzi = i14;
        this.zzj = i15;
        this.zzk = f4;
        this.zzl = str;
    }

    public static zzacf zza(zzeg zzegVar) throws zzat {
        String strZza;
        int i2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f4;
        int i13;
        int i14;
        try {
            zzegVar.zzk(4);
            int iZzs = (zzegVar.zzs() & 3) + 1;
            if (iZzs == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzs2 = zzegVar.zzs() & 31;
            for (int i15 = 0; i15 < iZzs2; i15++) {
                arrayList.add(zzb(zzegVar));
            }
            int iZzs3 = zzegVar.zzs();
            for (int i16 = 0; i16 < iZzs3; i16++) {
                arrayList.add(zzb(zzegVar));
            }
            if (iZzs2 > 0) {
                zzfl zzflVarZzd = zzfm.zzd((byte[]) arrayList.get(0), 5, ((byte[]) arrayList.get(0)).length);
                int i17 = zzflVarZzd.zze;
                int i18 = zzflVarZzd.zzf;
                int i19 = zzflVarZzd.zzh + 8;
                int i20 = zzflVarZzd.zzi + 8;
                int i21 = zzflVarZzd.zzj;
                int i22 = zzflVarZzd.zzk;
                int i23 = zzflVarZzd.zzl;
                int i24 = zzflVarZzd.zzm;
                float f8 = zzflVarZzd.zzg;
                strZza = zzdd.zza(zzflVarZzd.zza, zzflVarZzd.zzb, zzflVarZzd.zzc);
                i11 = i23;
                i12 = i24;
                f4 = f8;
                i10 = i20;
                i13 = i21;
                i14 = i22;
                i2 = i17;
                i8 = i18;
                i9 = i19;
            } else {
                strZza = null;
                i2 = -1;
                i8 = -1;
                i9 = -1;
                i10 = -1;
                i11 = -1;
                i12 = 16;
                f4 = 1.0f;
                i13 = -1;
                i14 = -1;
            }
            return new zzacf(arrayList, iZzs, i2, i8, i9, i10, i13, i14, i11, i12, f4, strZza);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzat.zzb("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzeg zzegVar) {
        int iZzt = zzegVar.zzt();
        int iZzg = zzegVar.zzg();
        zzegVar.zzk(iZzt);
        return zzdd.zzf(zzegVar.zzi(), iZzg, iZzt);
    }
}
