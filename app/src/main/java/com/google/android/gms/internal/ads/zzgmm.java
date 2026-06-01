package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmm implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzgms zzb;

    public zzgmm(zzgms zzgmsVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzgmsVar);
        this.zzb = zzgmsVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzglx.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
