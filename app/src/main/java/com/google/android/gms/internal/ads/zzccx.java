package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzccx extends TextureView implements zzcdu {
    protected final zzcdl zza;
    protected final zzcdv zzb;

    public zzccx(Context context) {
        super(context);
        this.zza = new zzcdl();
        this.zzb = new zzcdv(context, this);
    }

    public abstract String zza();

    public abstract void zzb(zzccw zzccwVar);

    public abstract void zzc(@Nullable String str);

    public abstract void zzd();

    public abstract void zze();

    public abstract void zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract void zzi(int i2);

    public abstract void zzj(float f4, float f8);

    public abstract int zzk();

    public abstract int zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract int zzp();

    public abstract void zzq();

    @Nullable
    public Integer zzw() {
        return null;
    }

    public void zzx(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        zzc(str);
    }

    public void zzA(int i2) {
    }

    public void zzB(int i2) {
    }

    public void zzC(int i2) {
    }

    public void zzy(int i2) {
    }

    public void zzz(int i2) {
    }
}
