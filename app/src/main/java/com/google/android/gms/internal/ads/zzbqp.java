package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqp {

    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbc zza = new zzbqn();

    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbc zzb = new zzbqo();
    private final zzbqb zzc;

    public zzbqp(Context context, VersionInfoParcel versionInfoParcel, String str, zzflp zzflpVar) {
        this.zzc = new zzbqb(context, versionInfoParcel, str, zza, zzb, zzflpVar);
    }

    public final zzbqf zza(String str, zzbqi zzbqiVar, zzbqh zzbqhVar) {
        return new zzbqt(this.zzc, str, zzbqiVar, zzbqhVar);
    }

    public final zzbqy zzb() {
        return new zzbqy(this.zzc);
    }
}
