package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdx {
    final /* synthetic */ zzbdy zza;
    private final byte[] zzb;
    private int zzc;

    public /* synthetic */ zzbdx(zzbdy zzbdyVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzbdyVar);
        this.zza = zzbdyVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzc() {
        try {
            zzbdy zzbdyVar = this.zza;
            if (zzbdyVar.zzb) {
                zzbdyVar.zza.zzh(this.zzb);
                zzbdyVar.zza.zzi(0);
                zzbdyVar.zza.zzj(this.zzc);
                zzbdyVar.zza.zzg(null);
                zzbdyVar.zza.zzf();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zze("Clearcut log failed", e);
        }
    }

    public final synchronized void zza() {
        this.zza.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc();
            }
        });
    }

    public final zzbdx zzb(int i2) {
        this.zzc = i2;
        return this;
    }
}
