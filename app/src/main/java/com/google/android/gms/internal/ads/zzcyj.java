package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcyj {
    @Nullable
    public static final zzbzt zza(Context context, VersionInfoParcel versionInfoParcel, zzffu zzffuVar, zzbzp zzbzpVar) {
        zzbzq zzbzqVar = zzffuVar.zzA;
        if (zzbzqVar == null) {
            return null;
        }
        zzffz zzffzVar = zzffuVar.zzs;
        return new zzbzo(context, versionInfoParcel, zzbzqVar, zzffzVar != null ? zzffzVar.zzb : null, zzbzpVar);
    }
}
