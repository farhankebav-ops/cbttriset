package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgzf extends zzgxb {
    private final String zza;
    private final zzgze zzb;

    private zzgzf(String str, zzgze zzgzeVar) {
        this.zza = str;
        this.zzb = zzgzeVar;
    }

    public static zzgzf zzb(String str, zzgze zzgzeVar) {
        return new zzgzf(str, zzgzeVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgzf)) {
            return false;
        }
        zzgzf zzgzfVar = (zzgzf) obj;
        return zzgzfVar.zza.equals(this.zza) && zzgzfVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzgzf.class, this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + string.length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "LegacyKmsAead Parameters (keyUri: ", str, ", variant: ", string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzgze.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    public final zzgze zzd() {
        return this.zzb;
    }
}
