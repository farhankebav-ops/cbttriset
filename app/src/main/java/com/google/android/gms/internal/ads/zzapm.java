package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapm {
    private final String zza;
    private final String zzb;

    public zzapm(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzapm.class == obj.getClass()) {
            zzapm zzapmVar = (zzapm) obj;
            if (TextUtils.equals(this.zza, zzapmVar.zza) && TextUtils.equals(this.zzb, zzapmVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(str2).length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "Header[name=", str, ",value=", str2);
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
