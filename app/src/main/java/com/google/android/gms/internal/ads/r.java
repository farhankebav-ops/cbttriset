package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class r {
    public static zzflc a(Context context, int i2) {
        boolean zBooleanValue;
        if (zzflp.zza()) {
            int i8 = i2 - 2;
            if (i8 == 20 || i8 == 21) {
                zBooleanValue = ((Boolean) zzbgn.zze.zze()).booleanValue();
            } else if (i8 != 110) {
                switch (i8) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbgn.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbgn.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbgn.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjP)).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfle(context, i2);
            }
        }
        return new zzfmd();
    }

    public static zzflc b(Context context, int i2, int i8, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        zzflc zzflcVarA = a(context, i2);
        if (zzflcVarA instanceof zzfle) {
            zzflcVarA.zza();
            zzflcVarA.zzp(i8);
            zzflcVarA.zzf(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzd(zzmVar.zzm));
            String str = zzmVar.zzp;
            if (zzfll.zza(str)) {
                zzflcVarA.zze(str);
            }
        }
        return zzflcVarA;
    }
}
