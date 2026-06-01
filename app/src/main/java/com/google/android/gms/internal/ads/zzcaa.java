package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcaa {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzcaf zzd;

    private zzcaa() {
        throw null;
    }

    public final zzcaa zza(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzcaa zzb(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzcaa zzc(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzcaa zzd(zzcaf zzcafVar) {
        this.zzd = zzcafVar;
        return this;
    }

    public final zzcag zze() {
        zzifp.zzc(this.zza, Context.class);
        zzifp.zzc(this.zzb, Clock.class);
        zzifp.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzifp.zzc(this.zzd, zzcaf.class);
        return new zzcab(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public /* synthetic */ zzcaa(byte[] bArr) {
    }
}
