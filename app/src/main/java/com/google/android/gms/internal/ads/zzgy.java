package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgy implements zzgb {
    private final zzgb zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.EMPTY_MAP;

    public zzgy(zzgb zzgbVar) {
        this.zza = zzgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws IOException {
        int iZza = this.zza.zza(bArr, i2, i8);
        if (iZza != -1) {
            this.zzb += (long) iZza;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        this.zzc = zzgfVar.zza;
        this.zzd = Collections.EMPTY_MAP;
        try {
            long jZzb = this.zza.zzb(zzgfVar);
            Uri uriZzc = zzc();
            if (uriZzc != null) {
                this.zzc = uriZzc;
            }
            this.zzd = zzj();
            return jZzb;
        } catch (Throwable th) {
            Uri uriZzc2 = zzc();
            if (uriZzc2 != null) {
                this.zzc = uriZzc2;
            }
            this.zzd = zzj();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
        zzgzVar.getClass();
        this.zza.zze(zzgzVar);
    }

    public final long zzf() {
        return this.zzb;
    }

    public final Uri zzg() {
        return this.zzc;
    }

    public final Map zzh() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        return this.zza.zzj();
    }
}
