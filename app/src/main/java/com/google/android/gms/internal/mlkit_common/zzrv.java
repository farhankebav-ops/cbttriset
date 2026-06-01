package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzrv extends zzsi {
    private zzmu zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private ModelType zze;
    private zzna zzf;
    private int zzg;
    private byte zzh;

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zza(zzna zznaVar) {
        if (zznaVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zznaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zzb(zzmu zzmuVar) {
        if (zzmuVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzmuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zzc(int i2) {
        this.zzg = i2;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zzd(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zze(boolean z2) {
        this.zzd = z2;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsi zzf(boolean z2) {
        this.zzc = z2;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzsi zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzsi
    public final zzsj zzh() {
        zzmu zzmuVar;
        String str;
        ModelType modelType;
        zzna zznaVar;
        if (this.zzh == 7 && (zzmuVar = this.zza) != null && (str = this.zzb) != null && (modelType = this.zze) != null && (zznaVar = this.zzf) != null) {
            return new zzrx(zzmuVar, str, this.zzc, this.zzd, modelType, zznaVar, this.zzg, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" errorCode");
        }
        if (this.zzb == null) {
            sb.append(" tfliteSchemaVersion");
        }
        if ((this.zzh & 1) == 0) {
            sb.append(" shouldLogRoughDownloadTime");
        }
        if ((this.zzh & 2) == 0) {
            sb.append(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            sb.append(" modelType");
        }
        if (this.zzf == null) {
            sb.append(" downloadStatus");
        }
        if ((this.zzh & 4) == 0) {
            sb.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
