package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahh implements Comparable {
    public final long zza;
    public final long zzb;

    public zzahh(long j, long j3) {
        this.zza = j;
        this.zzb = j3;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.zza, ((zzahh) obj).zza);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzahh)) {
            return false;
        }
        zzahh zzahhVar = (zzahh) obj;
        return this.zza == zzahhVar.zza && this.zzb == zzahhVar.zzb;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }
}
