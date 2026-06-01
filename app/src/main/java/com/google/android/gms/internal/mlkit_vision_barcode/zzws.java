package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.ironsource.G5;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzws implements zzwe {
    private final zzrd zza;
    private zzvb zzb = new zzvb();
    private final int zzc;

    private zzws(zzrd zzrdVar, int i2) {
        this.zza = zzrdVar;
        zzxb.zza();
        this.zzc = i2;
    }

    public static zzwe zzf(zzrd zzrdVar) {
        return new zzws(zzrdVar, 0);
    }

    public static zzwe zzg(zzrd zzrdVar, int i2) {
        return new zzws(zzrdVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwe
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwe
    public final zzwe zzb(zzrc zzrcVar) {
        this.zza.zzf(zzrcVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwe
    public final zzwe zzc(zzvb zzvbVar) {
        this.zzb = zzvbVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwe
    public final String zzd() {
        zzvd zzvdVarZzg = this.zza.zzk().zzg();
        return (zzvdVarZzg == null || zzba.zzc(zzvdVarZzg.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzvdVarZzg.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwe
    public final byte[] zze(int i2, boolean z2) {
        this.zzb.zzf(Boolean.valueOf(1 == (i2 ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzxb.zza();
            if (i2 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzox.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes(G5.N);
            }
            zzrf zzrfVarZzk = this.zza.zzk();
            zzfi zzfiVar = new zzfi();
            zzox.zza.configure(zzfiVar);
            return zzfiVar.zza().zza(zzrfVarZzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
