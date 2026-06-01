package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzftn {
    final /* synthetic */ zzfto zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzftn(zzfto zzftoVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzftoVar);
        this.zza = zzftoVar;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzfto zzftoVar = this.zza;
            if (zzftoVar.zzb) {
                zzftr zzftrVar = zzftoVar.zza;
                zzftrVar.zzg(this.zzb);
                zzftrVar.zzh(this.zzc);
                zzftrVar.zzi(this.zzd);
                zzftrVar.zzf(null);
                zzftrVar.zze();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final zzftn zzb(int i2) {
        this.zzc = i2;
        return this;
    }

    public final zzftn zzc(int i2) {
        this.zzd = i2;
        return this;
    }
}
