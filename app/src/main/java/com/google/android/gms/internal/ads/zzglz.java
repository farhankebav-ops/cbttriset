package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzglz {
    private final String zza;
    private final zzgly zzb;
    private zzgly zzc;

    public /* synthetic */ zzglz(String str, byte[] bArr) {
        zzgly zzglyVar = new zzgly();
        this.zzb = zzglyVar;
        this.zzc = zzglyVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzgly zzglyVar = this.zzb.zzb;
        String str = "";
        while (zzglyVar != null) {
            Object obj = zzglyVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzglyVar = zzglyVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzglz zza(Object obj) {
        zzgly zzglyVar = new zzgly();
        this.zzc.zzb = zzglyVar;
        this.zzc = zzglyVar;
        zzglyVar.zza = obj;
        return this;
    }
}
