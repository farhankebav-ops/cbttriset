package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmf implements Serializable, zzgme {
    private final List zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzgmf) {
            return this.zza.equals(((zzgmf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z2 = true;
        for (Object obj : this.zza) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(obj);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgme
    public final boolean zza(Object obj) {
        int i2 = 0;
        while (true) {
            List list = this.zza;
            if (i2 >= list.size()) {
                return true;
            }
            if (!((zzgme) list.get(i2)).zza(obj)) {
                return false;
            }
            i2++;
        }
    }
}
