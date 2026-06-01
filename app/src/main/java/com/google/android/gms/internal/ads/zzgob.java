package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgob extends zzgqy implements Serializable {
    final zzglu zza;
    final zzgqy zzb;

    public zzgob(zzglu zzgluVar, zzgqy zzgqyVar) {
        this.zza = zzgluVar;
        this.zzb = zzgqyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqy, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzglu zzgluVar = this.zza;
        return this.zzb.compare(zzgluVar.apply(obj), zzgluVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgob) {
            zzgob zzgobVar = (zzgob) obj;
            if (this.zza.equals(zzgobVar.zza) && this.zzb.equals(zzgobVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        int length = string.length();
        String string2 = this.zza.toString();
        return androidx.camera.core.processing.util.a.n(new StringBuilder(length + 12 + string2.length() + 1), string, ".onResultOf(", string2, ")");
    }
}
