package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlu {
    public static final zzlu zza = new zzlu(new zzlt());
    public final zzgpo zzb;

    @Nullable
    @FloatRange(from = 0.0d, to = 1.0d)
    public final Double zzc = null;

    @Nullable
    @FloatRange(from = 0.0d, to = 1.0d)
    public final Double zzd = null;
    public final boolean zze = true;
    public final boolean zzf = true;
    public final boolean zzi = true;
    public final boolean zzg = true;
    public final boolean zzh = true;

    private zzlu(zzlt zzltVar) {
        this.zzb = zzltVar.zza();
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof zzlu) && this.zzb.equals(((zzlu) obj).zzb);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.zzb, null, null, bool, bool, bool, bool, bool);
    }
}
