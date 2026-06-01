package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.ironsource.G5;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsk implements zzry {
    private final zzmw zza;
    private zzqt zzb = new zzqt();

    private zzsk(zzmw zzmwVar, int i2) {
        this.zza = zzmwVar;
        zzsv.zza();
    }

    public static zzry zzf(zzmw zzmwVar) {
        return new zzsk(zzmwVar, 0);
    }

    public static zzry zzg() {
        return new zzsk(new zzmw(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzry
    public final zzry zza(zzmv zzmvVar) {
        this.zza.zzf(zzmvVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzry
    public final zzry zzb(zznc zzncVar) {
        this.zza.zzi(zzncVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzry
    public final zzry zzc(zzqt zzqtVar) {
        this.zzb = zzqtVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzry
    public final String zzd() {
        String strZzk;
        zzqv zzqvVarZzf = this.zza.zzk().zzf();
        return (zzqvVarZzf == null || (strZzk = zzqvVarZzf.zzk()) == null || strZzk.isEmpty()) ? "NA" : (String) Preconditions.checkNotNull(zzqvVarZzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzry
    public final byte[] zze(int i2, boolean z2) {
        this.zzb.zzf(Boolean.valueOf(1 == (i2 ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzsv.zza();
            if (i2 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzkr.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes(G5.N);
            }
            zzmy zzmyVarZzk = this.zza.zzk();
            zzbg zzbgVar = new zzbg();
            zzkr.zza.configure(zzbgVar);
            return zzbgVar.zza().zza(zzmyVarZzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
