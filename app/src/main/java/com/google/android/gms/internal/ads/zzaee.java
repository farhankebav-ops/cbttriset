package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaee {
    public static final zzaee zza = new zzaee(0, 0);
    public final long zzb;
    public final long zzc;

    public zzaee(long j, long j3) {
        this.zzb = j;
        this.zzc = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaee.class == obj.getClass()) {
            zzaee zzaeeVar = (zzaee) obj;
            if (this.zzb == zzaeeVar.zzb && this.zzc == zzaeeVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j = this.zzb;
        int length = String.valueOf(j).length();
        long j3 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(j3).length() + 1);
        androidx.camera.core.processing.util.a.y(sb, "[timeUs=", j, ", position=");
        return a1.a.p(sb, j3, C2300e4.i.e);
    }
}
