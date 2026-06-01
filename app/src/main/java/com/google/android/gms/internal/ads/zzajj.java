package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzajj implements zzaeh {
    public final int zza;
    public final zzgsr zzb;

    public zzajj(int i2, @Nullable int[] iArr) {
        this.zza = i2;
        this.zzb = iArr != null ? zzgsr.zzb(iArr) : zzgsr.zza();
    }

    public final String toString() {
        zzgsr zzgsrVar = this.zzb;
        ArrayList arrayList = new ArrayList(zzgsrVar.zzc());
        for (int i2 = 0; i2 < zzgsrVar.zzc(); i2++) {
            arrayList.add(zzep.zzx(zzgsrVar.zzd(i2)));
        }
        String strZzx = zzep.zzx(this.zza);
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder(androidx.camera.core.processing.util.a.D(strZzx.length() + 37, 1, string));
        sb.append("UnsupportedBrands{major=");
        sb.append(strZzx);
        sb.append(", compatible=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
