package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfz extends zzft {

    @Nullable
    private zzgf zza;

    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfz() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) {
        if (i8 == 0) {
            return 0;
        }
        int i9 = this.zzd;
        if (i9 == 0) {
            return -1;
        }
        int iMin = Math.min(i8, i9);
        byte[] bArr2 = this.zzb;
        String str = zzep.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i2, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzh(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        zzf(zzgfVar);
        this.zza = zzgfVar;
        Uri uriNormalizeScheme = zzgfVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzgmd.zzf("data".equals(scheme), "Unsupported scheme: %s", scheme);
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        String str = zzep.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzat.zza("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str2, 0);
            } catch (IllegalArgumentException e) {
                throw zzat.zza("Error while parsing Base64 encoded string: ".concat(String.valueOf(str2)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j = zzgfVar.zze;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzgc(2008);
        }
        int i2 = (int) j;
        this.zzc = i2;
        int i8 = length - i2;
        this.zzd = i8;
        long j3 = zzgfVar.zzf;
        if (j3 != -1) {
            this.zzd = (int) Math.min(i8, j3);
        }
        zzg(zzgfVar);
        return j3 != -1 ? j3 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        zzgf zzgfVar = this.zza;
        if (zzgfVar != null) {
            return zzgfVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzi();
        }
        this.zza = null;
    }
}
