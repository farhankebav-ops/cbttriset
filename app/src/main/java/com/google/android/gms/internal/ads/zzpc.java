package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpc {
    public static final zzpc zza;
    public final String zzb;

    @Nullable
    private final zzpb zzc;

    @Nullable
    private final Object zzd;

    static {
        new zzpc("");
        zza = new zzpc("preload");
    }

    public zzpc(String str) {
        this.zzb = str;
        this.zzc = Build.VERSION.SDK_INT >= 31 ? new zzpb() : null;
        this.zzd = new Object();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpc)) {
            return false;
        }
        zzpc zzpcVar = (zzpc) obj;
        return Objects.equals(this.zzb, zzpcVar.zzb) && Objects.equals(this.zzc, zzpcVar.zzc) && Objects.equals(this.zzd, zzpcVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, this.zzc, this.zzd);
    }

    @RequiresApi(31)
    public final synchronized LogSessionId zza() {
        zzpb zzpbVar;
        zzpbVar = this.zzc;
        if (zzpbVar == null) {
            throw null;
        }
        return zzpbVar.zza;
    }

    @RequiresApi(31)
    public final synchronized void zzb(LogSessionId logSessionId) {
        zzpb zzpbVar = this.zzc;
        if (zzpbVar == null) {
            throw null;
        }
        LogSessionId logSessionId2 = zzpbVar.zza;
        LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
        zzgmd.zzh(logSessionId2.equals(LogSessionId.LOG_SESSION_ID_NONE));
        zzpbVar.zza = logSessionId;
    }
}
