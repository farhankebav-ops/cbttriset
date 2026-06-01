package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzftw extends zzfuc {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    public /* synthetic */ zzftw(String str, boolean z2, int i2, zzftt zzfttVar, zzftu zzftuVar, int i8, byte[] bArr) {
        this.zzb = str;
        this.zzc = i2;
        this.zzd = i8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfuc) {
            zzfuc zzfucVar = (zzfuc) obj;
            if (this.zzb.equals(zzfucVar.zza())) {
                zzfucVar.zzb();
                int i2 = this.zzc;
                int iZze = zzfucVar.zze();
                if (i2 == 0) {
                    throw null;
                }
                if (i2 == iZze) {
                    zzfucVar.zzc();
                    zzfucVar.zzd();
                    int i8 = this.zzd;
                    int iZzf = zzfucVar.zzf();
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
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        int i2 = this.zzc;
        if (i2 == 0) {
            throw null;
        }
        int i8 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i2;
        if (this.zzd != 0) {
            return (i8 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i2 = this.zzc;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.zzd == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(str2.length() + androidx.camera.core.processing.util.a.D(String.valueOf(str3).length() + 73, 91, str) + 1);
        androidx.camera.core.processing.util.a.A(sb, "FileComplianceOptions{fileOwner=", str3, ", hasDifferentDmaOwner=false, fileChecks=", str);
        return a1.a.s(sb, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str2, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzftt zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzftu zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final int zzf() {
        return this.zzd;
    }
}
