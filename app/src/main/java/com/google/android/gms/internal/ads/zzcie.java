package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcie extends com.google.android.gms.ads.internal.client.zzec {
    private final zzcdr zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzeg zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbjq zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcie(zzcdr zzcdrVar, float f4, boolean z2, boolean z7) {
        this.zza = zzcdrVar;
        this.zzi = f4;
        this.zzc = z2;
        this.zzd = z7;
    }

    private final void zzw(String str, @Nullable Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzt(map2);
            }
        });
    }

    private final void zzx(final int i2, final int i8, final boolean z2, final boolean z7) {
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcic
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(i2, i8, z2, z7);
            }
        });
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        Object obj = this.zzb;
        boolean z2 = zzgaVar.zzb;
        boolean z7 = zzgaVar.zzc;
        synchronized (obj) {
            this.zzl = z2;
            this.zzm = z7;
        }
        boolean z8 = zzgaVar.zza;
        zzw("initialState", CollectionUtils.mapOf("muteStart", true != z8 ? "0" : "1", "customControlsRequested", true != z2 ? "0" : "1", "clickToExpandRequested", true != z7 ? "0" : "1"));
    }

    public final void zzd(float f4) {
        synchronized (this.zzb) {
            this.zzj = f4;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() {
        zzw("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() {
        zzw("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzg(boolean z2) {
        zzw(true != z2 ? "unmute" : "mute", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzh() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = this.zzh;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzi() {
        int i2;
        synchronized (this.zzb) {
            i2 = this.zze;
        }
        return i2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzi;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzj;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl(@Nullable com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.zzb) {
            this.zzf = zzegVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzk;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzn() {
        boolean z2;
        synchronized (this.zzb) {
            try {
                z2 = false;
                if (this.zzc && this.zzl) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzeg zzo() throws RemoteException {
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        synchronized (this.zzb) {
            zzegVar = this.zzf;
        }
        return zzegVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() {
        boolean z2;
        Object obj = this.zzb;
        boolean zZzn = zzn();
        synchronized (obj) {
            z2 = false;
            if (!zZzn) {
                try {
                    if (this.zzm && this.zzd) {
                        z2 = true;
                    }
                } finally {
                }
            }
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzq() {
        zzw("stop", null);
    }

    public final void zzr() {
        boolean z2;
        int i2;
        synchronized (this.zzb) {
            z2 = this.zzh;
            i2 = this.zze;
            this.zze = 3;
        }
        zzx(i2, 3, z2, z2);
    }

    public final void zzs(float f4, float f8, int i2, boolean z2, float f9) {
        boolean z7;
        boolean z8;
        int i8;
        synchronized (this.zzb) {
            try {
                z7 = true;
                if (f8 == this.zzi && f9 == this.zzk) {
                    z7 = false;
                }
                this.zzi = f8;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznO)).booleanValue()) {
                    this.zzj = f4;
                }
                z8 = this.zzh;
                this.zzh = z2;
                i8 = this.zze;
                this.zze = i2;
                float f10 = this.zzk;
                this.zzk = f9;
                if (Math.abs(f9 - f10) > 1.0E-4f) {
                    this.zza.zzE().invalidate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            try {
                zzbjq zzbjqVar = this.zzn;
                if (zzbjqVar != null) {
                    zzbjqVar.zze();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        zzx(i8, i2, z8, z2);
    }

    public final /* synthetic */ void zzt(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    public final /* synthetic */ void zzu(int i2, int i8, boolean z2, boolean z7) {
        int i9;
        boolean z8;
        boolean z9;
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        com.google.android.gms.ads.internal.client.zzeg zzegVar2;
        com.google.android.gms.ads.internal.client.zzeg zzegVar3;
        synchronized (this.zzb) {
            try {
                boolean z10 = this.zzg;
                if (z10 || i8 != 1) {
                    i9 = i8;
                    z8 = false;
                } else {
                    i8 = 1;
                    i9 = 1;
                    z8 = true;
                }
                boolean z11 = i2 != i8;
                if (z11 && i9 == 1) {
                    z9 = true;
                    i9 = 1;
                } else {
                    z9 = false;
                }
                boolean z12 = z11 && i9 == 2;
                boolean z13 = z11 && i9 == 3;
                this.zzg = z10 || z8;
                if (z8) {
                    try {
                        com.google.android.gms.ads.internal.client.zzeg zzegVar4 = this.zzf;
                        if (zzegVar4 != null) {
                            zzegVar4.zze();
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (z9 && (zzegVar3 = this.zzf) != null) {
                    zzegVar3.zzf();
                }
                if (z12 && (zzegVar2 = this.zzf) != null) {
                    zzegVar2.zzg();
                }
                if (z13) {
                    com.google.android.gms.ads.internal.client.zzeg zzegVar5 = this.zzf;
                    if (zzegVar5 != null) {
                        zzegVar5.zzh();
                    }
                    this.zza.zzz();
                }
                if (z2 != z7 && (zzegVar = this.zzf) != null) {
                    zzegVar.zzi(z7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzv(zzbjq zzbjqVar) {
        synchronized (this.zzb) {
            this.zzn = zzbjqVar;
        }
    }
}
