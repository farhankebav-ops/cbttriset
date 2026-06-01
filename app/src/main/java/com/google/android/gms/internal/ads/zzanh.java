package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzanh {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zzanh(int i2, int i8) {
        this.zzc = i2;
        byte[] bArr = new byte[Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE];
        this.zza = bArr;
        bArr[2] = 1;
    }

    public final void zza() {
        this.zzd = false;
        this.zze = false;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final void zzc(int i2) {
        zzgmd.zzh(!this.zzd);
        boolean z2 = i2 == this.zzc;
        this.zzd = z2;
        if (z2) {
            this.zzb = 3;
            this.zze = false;
        }
    }

    public final void zzd(byte[] bArr, int i2, int i8) {
        if (this.zzd) {
            int i9 = i8 - i2;
            byte[] bArr2 = this.zza;
            int length = bArr2.length;
            int i10 = this.zzb + i9;
            if (length < i10) {
                this.zza = Arrays.copyOf(bArr2, i10 + i10);
            }
            System.arraycopy(bArr, i2, this.zza, this.zzb, i9);
            this.zzb += i9;
        }
    }

    public final boolean zze(int i2) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= i2;
        this.zzd = false;
        this.zze = true;
        return true;
    }
}
