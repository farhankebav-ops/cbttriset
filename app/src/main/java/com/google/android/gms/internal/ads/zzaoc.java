package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaoc {
    public final int zza;

    @Nullable
    public final String zzb;
    public final int zzc;
    public final List zzd;
    public final byte[] zze;

    public zzaoc(int i2, @Nullable String str, int i8, @Nullable List list, byte[] bArr) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = i8;
        this.zzd = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
        this.zze = bArr;
    }

    public final int zza() {
        int i2 = this.zzc;
        if (i2 != 2) {
            return i2 != 3 ? 0 : 512;
        }
        return 2048;
    }
}
