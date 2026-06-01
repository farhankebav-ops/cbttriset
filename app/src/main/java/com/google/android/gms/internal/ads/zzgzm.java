package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgzm {
    private zzgzo zza;
    private String zzb;
    private zzgzn zzc;
    private zzgxb zzd;

    private zzgzm() {
        throw null;
    }

    public final zzgzm zza(zzgzo zzgzoVar) {
        this.zza = zzgzoVar;
        return this;
    }

    public final zzgzm zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzgzm zzc(zzgzn zzgznVar) {
        this.zzc = zzgznVar;
        return this;
    }

    public final zzgzm zzd(zzgxb zzgxbVar) {
        this.zzd = zzgxbVar;
        return this;
    }

    public final zzgzp zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgzo.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzgzn zzgznVar = this.zzc;
        if (zzgznVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzgxb zzgxbVar = this.zzd;
        if (zzgxbVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzgxbVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzgznVar.equals(zzgzn.zza) && (zzgxbVar instanceof zzgyg)) || ((zzgznVar.equals(zzgzn.zzc) && (zzgxbVar instanceof zzgyv)) || ((zzgznVar.equals(zzgzn.zzb) && (zzgxbVar instanceof zzhar)) || ((zzgznVar.equals(zzgzn.zzd) && (zzgxbVar instanceof zzgxp)) || ((zzgznVar.equals(zzgzn.zze) && (zzgxbVar instanceof zzgxx)) || (zzgznVar.equals(zzgzn.zzf) && (zzgxbVar instanceof zzgyp))))))) {
            return new zzgzp(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        String string = this.zzc.toString();
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(strValueOf.length() + string.length() + 67 + 1);
        androidx.camera.core.processing.util.a.A(sb, "Cannot use parsing strategy ", string, " when new keys are picked according to ", strValueOf);
        sb.append(".");
        throw new GeneralSecurityException(sb.toString());
    }

    public /* synthetic */ zzgzm(byte[] bArr) {
    }
}
