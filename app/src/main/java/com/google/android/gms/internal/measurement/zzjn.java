package com.google.android.gms.internal.measurement;

import android.content.Context;
import e2.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjn extends zzkh {
    private final Context zza;
    private final n zzb;

    public zzjn(Context context, n nVar) {
        this.zza = context;
        this.zzb = nVar;
    }

    public final boolean equals(Object obj) {
        n nVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkh) {
            zzkh zzkhVar = (zzkh) obj;
            if (this.zza.equals(zzkhVar.zza()) && ((nVar = this.zzb) != null ? nVar.equals(zzkhVar.zzb()) : zzkhVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        n nVar = this.zzb;
        return (iHashCode * 1000003) ^ (nVar == null ? 0 : nVar.hashCode());
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf.length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "FlagsContext{context=", string, ", hermeticFileOverrides=", strValueOf);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzkh
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkh
    public final n zzb() {
        return this.zzb;
    }
}
