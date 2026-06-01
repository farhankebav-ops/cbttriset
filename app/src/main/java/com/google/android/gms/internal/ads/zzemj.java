package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzemj implements zzczx {
    boolean zza;
    final /* synthetic */ zzehn zzb;
    final /* synthetic */ zzcca zzc;

    public zzemj(zzemm zzemmVar, zzehn zzehnVar, zzcca zzccaVar) {
        this.zzb = zzehnVar;
        this.zzc = zzccaVar;
        Objects.requireNonNull(zzemmVar);
        this.zza = false;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i2 = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzge)).booleanValue()) {
            i2 = 3;
        }
        this.zzc.zzd(new zzeho(i2, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final synchronized void zza() {
        this.zzc.zzc(null);
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final synchronized void zzb(int i2) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i2, zzemm.zze(this.zzb.zza, i2), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final synchronized void zzc(int i2, @Nullable String str) {
        try {
            if (this.zza) {
                return;
            }
            this.zza = true;
            if (str == null) {
                str = zzemm.zze(this.zzb.zza, i2);
            }
            zze(new com.google.android.gms.ads.internal.client.zze(i2, str, AdError.UNDEFINED_DOMAIN, null, null));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczx
    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }
}
