package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfyx implements zzfyr {
    private final int zza;
    private final byte[] zzb;

    public zzfyx(int i2, byte[] bArr) {
        this.zza = i2;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfyr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyr
    public final String zzb() throws IOException {
        return new String(this.zzb);
    }
}
