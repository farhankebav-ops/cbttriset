package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzfmx;
import com.google.android.gms.internal.ads.zzfmy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbt extends zzb {
    private final com.google.android.gms.ads.internal.util.client.zzu zza;
    private final String zzb;

    @Nullable
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;

    public zzbt(Context context, String str, String str2, @Nullable zzfmy zzfmyVar, @Nullable com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = new com.google.android.gms.ads.internal.util.client.zzu(context, com.google.android.gms.ads.internal.zzt.zzc().zze(context, str));
        this.zzb = str2;
        this.zzc = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        if (zzvVar == null) {
            this.zza.zzc(this.zzb, null);
        } else {
            new zzfmx(zzvVar.zza(), this.zza, zzcbv.zze, null, null).zza(this.zzb);
        }
    }
}
