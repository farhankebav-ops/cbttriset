package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbu extends zzca {
    private final String zzc;
    private final int zzd;
    private final int zze;

    public /* synthetic */ zzbu(String str, boolean z2, int i2, zzbr zzbrVar, zzbs zzbsVar, int i8, byte[] bArr) {
        this.zzc = str;
        this.zzd = i2;
        this.zze = i8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzca) {
            zzca zzcaVar = (zzca) obj;
            if (this.zzc.equals(zzcaVar.zza())) {
                zzcaVar.zzb();
                int i2 = this.zzd;
                int iZze = zzcaVar.zze();
                if (i2 == 0) {
                    throw null;
                }
                if (i2 == iZze) {
                    zzcaVar.zzc();
                    zzcaVar.zzd();
                    int i8 = this.zze;
                    int iZzf = zzcaVar.zzf();
                    if (i8 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzc.hashCode() ^ 1000003;
        int i2 = this.zzd;
        if (i2 == 0) {
            throw null;
        }
        int i8 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i2;
        if (this.zze != 0) {
            return (i8 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i2 = this.zzd;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.zze == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.zzc;
        StringBuilder sb = new StringBuilder(str2.length() + androidx.camera.core.processing.util.a.D(String.valueOf(str3).length() + 73, 91, str) + 1);
        androidx.camera.core.processing.util.a.A(sb, "FileComplianceOptions{fileOwner=", str3, ", hasDifferentDmaOwner=false, fileChecks=", str);
        return a1.a.s(sb, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str2, "}");
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final String zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbr zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbs zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zzf() {
        return this.zze;
    }
}
