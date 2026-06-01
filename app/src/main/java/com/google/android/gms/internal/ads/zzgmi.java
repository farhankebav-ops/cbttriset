package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmi extends zzgmb {
    private final Object zza;

    public zzgmi(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgmi) {
            return this.zza.equals(((zzgmi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.zza.toString();
        return a1.a.s(new StringBuilder(string.length() + 13), "Optional.of(", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgmb
    public final Object zza(Object obj) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgmb
    public final zzgmb zzb(zzglu zzgluVar) {
        Object objApply = zzgluVar.apply(this.zza);
        zzgmd.zzk(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzgmi(objApply);
    }
}
