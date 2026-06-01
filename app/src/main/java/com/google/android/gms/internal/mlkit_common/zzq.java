package com.google.android.gms.internal.mlkit_common;

import com.ironsource.G5;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq {
    private final String zza;
    private final zzo zzb;
    private zzo zzc;

    public /* synthetic */ zzq(String str, zzp zzpVar) {
        zzo zzoVar = new zzo();
        this.zzb = zzoVar;
        this.zzc = zzoVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzo zzoVar = this.zzb.zzc;
        String str = "";
        while (zzoVar != null) {
            Object obj = zzoVar.zzb;
            sb.append(str);
            String str2 = zzoVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append(G5.T);
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzoVar = zzoVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzq zza(String str, Object obj) {
        zzo zzoVar = new zzo();
        this.zzc.zzc = zzoVar;
        this.zzc = zzoVar;
        zzoVar.zzb = obj;
        zzoVar.zza = str;
        return this;
    }

    public final zzq zzb(String str, boolean z2) {
        String strValueOf = String.valueOf(z2);
        zzn zznVar = new zzn(null);
        this.zzc.zzc = zznVar;
        this.zzc = zznVar;
        zznVar.zzb = strValueOf;
        zznVar.zza = "isManifestFile";
        return this;
    }
}
