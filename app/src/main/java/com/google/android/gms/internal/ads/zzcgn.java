package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcgn extends zzccx {
    private final zzcds zzc;

    @Nullable
    private zzcgo zzd;
    private Uri zze;
    private zzccw zzf;
    private boolean zzg;
    private int zzh;

    public zzcgn(Context context, zzcds zzcdsVar) {
        super(context);
        this.zzh = 1;
        this.zzg = false;
        this.zzc = zzcdsVar;
        zzcdsVar.zza(this);
    }

    @EnsuresNonNullIf(expression = {"immersiveAdPlayer"}, result = true)
    private final boolean zzu() {
        int i2 = this.zzh;
        return (i2 == 1 || i2 == 2 || this.zzd == null) ? false : true;
    }

    private final void zzv(int i2) {
        if (i2 == 4) {
            this.zzc.zze();
            this.zzb.zzd();
        } else if (this.zzh == 4) {
            this.zzc.zzf();
            this.zzb.zze();
        }
        this.zzh = i2;
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzcgn.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return a1.a.s(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final String zza() {
        return "ImmersivePlayer";
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzb(zzccw zzccwVar) {
        this.zzf = zzccwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzc(@Nullable String str) {
        if (str != null) {
            Uri uri = Uri.parse(str);
            this.zze = uri;
            this.zzd = new zzcgo(uri.toString());
            zzv(3);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzd() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView stop");
        zzcgo zzcgoVar = this.zzd;
        if (zzcgoVar != null) {
            zzcgoVar.zzd();
            this.zzd = null;
            zzv(1);
        }
        this.zzc.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zze() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView play");
        if (zzu()) {
            this.zzd.zzb();
            zzv(4);
            this.zza.zza();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzf() {
        com.google.android.gms.ads.internal.util.zze.zza("AdImmersivePlayerView pause");
        if (zzu() && this.zzd.zza()) {
            this.zzd.zzc();
            zzv(5);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzg() {
        return zzu() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzh() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzi(int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 27);
        sb.append("AdImmersivePlayerView seek ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzk() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzl() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzm() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzn() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzo() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzp() {
        return zzu() ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzccx, com.google.android.gms.internal.ads.zzcdu
    public final void zzq() {
        if (this.zzd != null) {
            this.zzb.zzc();
        }
    }

    public final /* synthetic */ void zzr() {
        zzccw zzccwVar = this.zzf;
        if (zzccwVar != null) {
            zzccwVar.zzb();
        }
    }

    public final /* synthetic */ void zzs() {
        zzccw zzccwVar = this.zzf;
        if (zzccwVar != null) {
            if (!this.zzg) {
                zzccwVar.zzk();
                this.zzg = true;
            }
            this.zzf.zzc();
        }
    }

    public final /* synthetic */ void zzt() {
        zzccw zzccwVar = this.zzf;
        if (zzccwVar != null) {
            zzccwVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzj(float f4, float f8) {
    }
}
