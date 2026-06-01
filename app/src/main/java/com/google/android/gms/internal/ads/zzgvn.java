package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgvn implements zzgwf {
    private final InputStream zza;

    private zzgvn(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgwf zza(byte[] bArr) {
        return new zzgvn(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.ads.zzgwf
    public final zzhlg zzb() throws IOException {
        try {
            return zzhlg.zzg(this.zza, zzhvy.zza());
        } finally {
            this.zza.close();
        }
    }
}
