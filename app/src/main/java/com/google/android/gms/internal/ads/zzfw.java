package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfw extends zzft {
    private final zzfv zza;

    @Nullable
    private Uri zzb;

    @Nullable
    private byte[] zzc;
    private int zzd;
    private int zze;
    private boolean zzf;

    public zzfw(final byte[] bArr) {
        zzfv zzfvVar = new zzfv() { // from class: com.google.android.gms.internal.ads.zzfu
            @Override // com.google.android.gms.internal.ads.zzfv
            public final /* synthetic */ byte[] zza(Uri uri) {
                return bArr;
            }
        };
        super(false);
        this.zza = zzfvVar;
        zzgmd.zza(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) {
        if (i8 == 0) {
            return 0;
        }
        int i9 = this.zze;
        if (i9 == 0) {
            return -1;
        }
        int iMin = Math.min(i8, i9);
        byte[] bArr2 = this.zzc;
        bArr2.getClass();
        System.arraycopy(bArr2, this.zzd, bArr, i2, iMin);
        this.zzd += iMin;
        this.zze -= iMin;
        zzh(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        zzf(zzgfVar);
        Uri uri = zzgfVar.zza;
        this.zzb = uri;
        byte[] bArrZza = this.zza.zza(uri);
        this.zzc = bArrZza;
        long j = zzgfVar.zze;
        int length = bArrZza.length;
        if (j > length) {
            throw new zzgc(2008);
        }
        int i2 = (int) j;
        this.zzd = i2;
        int i8 = length - i2;
        this.zze = i8;
        long j3 = zzgfVar.zzf;
        if (j3 != -1) {
            this.zze = (int) Math.min(i8, j3);
        }
        this.zzf = true;
        zzg(zzgfVar);
        return j3 != -1 ? j3 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
            zzi();
        }
        this.zzb = null;
        this.zzc = null;
    }
}
