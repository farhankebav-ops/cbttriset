package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzfou {
    public static zzfou zze(zzfov zzfovVar, zzfow zzfowVar) {
        zzfqs.zza();
        return new zzfoy(zzfovVar, zzfowVar, UUID.randomUUID().toString());
    }

    public abstract void zza();

    public abstract void zzb(@Nullable View view);

    public abstract void zzc();

    public abstract void zzd(View view, zzfpb zzfpbVar, @Nullable String str);
}
