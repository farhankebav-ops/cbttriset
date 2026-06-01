package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcl {

    @Nullable
    private CharSequence zza;

    @Nullable
    private Bitmap zzb;

    @Nullable
    private Layout.Alignment zzc;

    @Nullable
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;
    private int zzp;

    public zzcl() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    public final zzcl zza(CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = null;
        return this;
    }

    @Nullable
    @Pure
    public final CharSequence zzb() {
        return this.zza;
    }

    public final zzcl zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        this.zza = null;
        return this;
    }

    public final zzcl zzd(@Nullable Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzcl zze(@Nullable Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzcl zzf(float f4, int i2) {
        this.zze = f4;
        this.zzf = i2;
        return this;
    }

    public final zzcl zzg(int i2) {
        this.zzg = i2;
        return this;
    }

    @Pure
    public final int zzh() {
        return this.zzg;
    }

    public final zzcl zzi(float f4) {
        this.zzh = f4;
        return this;
    }

    public final zzcl zzj(int i2) {
        this.zzi = i2;
        return this;
    }

    @Pure
    public final int zzk() {
        return this.zzi;
    }

    public final zzcl zzl(float f4, int i2) {
        this.zzk = f4;
        this.zzj = i2;
        return this;
    }

    public final zzcl zzm(float f4) {
        this.zzl = f4;
        return this;
    }

    public final zzcl zzn(float f4) {
        this.zzm = f4;
        return this;
    }

    public final zzcl zzo(int i2) {
        this.zzn = i2;
        return this;
    }

    public final zzcl zzp(float f4) {
        this.zzo = f4;
        return this;
    }

    public final zzcl zzq(int i2) {
        this.zzp = i2;
        return this;
    }

    public final zzcm zzr() {
        return new zzcm(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, ViewCompat.MEASURED_STATE_MASK, this.zzn, this.zzo, this.zzp, null);
    }

    public /* synthetic */ zzcl(zzcm zzcmVar, byte[] bArr) {
        this.zza = zzcmVar.zza;
        this.zzb = zzcmVar.zzd;
        this.zzc = zzcmVar.zzb;
        this.zzd = zzcmVar.zzc;
        this.zze = zzcmVar.zze;
        this.zzf = zzcmVar.zzf;
        this.zzg = zzcmVar.zzg;
        this.zzh = zzcmVar.zzh;
        this.zzi = zzcmVar.zzi;
        this.zzj = zzcmVar.zzl;
        this.zzk = zzcmVar.zzm;
        this.zzl = zzcmVar.zzj;
        this.zzm = zzcmVar.zzk;
        this.zzn = zzcmVar.zzn;
        this.zzo = zzcmVar.zzo;
        this.zzp = zzcmVar.zzp;
    }
}
