package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgn {
    protected static final AtomicReference zza = new AtomicReference();
    protected static final AtomicReference zzb = new AtomicReference();
    protected static final AtomicReference zzc = new AtomicReference();
    private final zzgm zzd;

    public zzgn(zzgm zzgmVar) {
        this.zzd = zzgmVar;
    }

    private static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (Objects.equals(str, strArr[i2])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i2];
                        if (str2 == null) {
                            str2 = strArr2[i2] + "(" + strArr[i2] + ")";
                            strArr3[i2] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.zza() ? str : zzg(str, zzjm.zzc, zzjm.zza, zza);
    }

    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.zza() ? str : zzg(str, zzjn.zzb, zzjn.zza, zzb);
    }

    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.zza() ? str : str.startsWith("_exp_") ? a1.a.m("experiment_id(", str, ")") : zzg(str, zzjo.zzb, zzjo.zza, zzc);
    }

    public final String zzd(zzbg zzbgVar) {
        zzgm zzgmVar = this.zzd;
        if (!zzgmVar.zza()) {
            return zzbgVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzbgVar.zzc);
        sb.append(",name=");
        sb.append(zza(zzbgVar.zza));
        sb.append(",params=");
        zzbe zzbeVar = zzbgVar.zzb;
        sb.append(zzbeVar == null ? null : !zzgmVar.zza() ? zzbeVar.toString() : zze(zzbeVar.zzf()));
        return sb.toString();
    }

    public final String zze(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbR.length() != 8) {
                sbR.append(", ");
            }
            sbR.append(zzb(str));
            sbR.append(C2300e4.i.f8399b);
            Object obj = bundle.get(str);
            sbR.append(obj instanceof Bundle ? zzf(new Object[]{obj}) : obj instanceof Object[] ? zzf((Object[]) obj) : obj instanceof ArrayList ? zzf(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbR.append("}]");
        return sbR.toString();
    }

    public final String zzf(Object[] objArr) {
        if (objArr == null) {
            return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(C2300e4.i.f8403d);
        for (Object obj : objArr) {
            String strZze = obj instanceof Bundle ? zze((Bundle) obj) : String.valueOf(obj);
            if (strZze != null) {
                if (sbR.length() != 1) {
                    sbR.append(", ");
                }
                sbR.append(strZze);
            }
        }
        sbR.append(C2300e4.i.e);
        return sbR.toString();
    }
}
