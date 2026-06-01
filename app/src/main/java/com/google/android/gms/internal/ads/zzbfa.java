package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzbfa {
    public static final void zza(zzbez zzbezVar, @Nullable zzbex zzbexVar) {
        if (zzbexVar.zzb() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbexVar.zzc())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzbezVar.zza(zzbexVar.zzb(), zzbexVar.zzc(), zzbexVar.zza(), zzbexVar.zzd());
    }
}
