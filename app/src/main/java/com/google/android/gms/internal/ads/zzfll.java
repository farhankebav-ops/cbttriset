package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfll {
    public static boolean zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjH), str);
    }

    public static void zzb(j2.q qVar, zzflc zzflcVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(qVar), new zzflh(zzflcVar), zzcbv.zzg);
        }
    }

    public static zzfjx zzc(final zzflc zzflcVar) {
        return new zzfjx() { // from class: com.google.android.gms.internal.ads.zzflk
            @Override // com.google.android.gms.internal.ads.zzfjx
            public final /* synthetic */ Object zza(Object obj) {
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflcVar.zza();
                }
                return obj;
            }
        };
    }

    public static void zzd(j2.q qVar, zzflm zzflmVar, zzflc zzflcVar) {
        zzh(qVar, zzflmVar, zzflcVar, false);
    }

    public static void zze(j2.q qVar, zzflm zzflmVar, zzflc zzflcVar) {
        zzh(qVar, zzflmVar, zzflcVar, true);
    }

    public static void zzf(j2.q qVar, zzflm zzflmVar, zzflc zzflcVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(qVar), new zzflj(zzflmVar, zzflcVar), zzcbv.zzg);
        }
    }

    public static int zzg(zzfgn zzfgnVar) {
        int iZzg = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzg(zzfgnVar) - 1;
        return (iZzg == 0 || iZzg == 1) ? 7 : 23;
    }

    private static void zzh(j2.q qVar, zzflm zzflmVar, zzflc zzflcVar, boolean z2) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzgui.zzr(zzgua.zzw(qVar), new zzfli(zzflmVar, zzflcVar, z2), zzcbv.zzg);
        }
    }
}
