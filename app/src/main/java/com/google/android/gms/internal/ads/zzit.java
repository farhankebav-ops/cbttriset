package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzit implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabs, zzqa, zzwy, zzts, zzhl, zzlz {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzju zza;

    public /* synthetic */ zzit(zzju zzjuVar, byte[] bArr) {
        Objects.requireNonNull(zzjuVar);
        this.zza = zzjuVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i8) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzQ(surfaceTexture);
        zzjuVar.zzS(i2, i8);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzR(null);
        zzjuVar.zzS(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i8) {
        this.zza.zzS(i2, i8);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i8, int i9) {
        this.zza.zzS(i8, i9);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzS(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zza(zzhs zzhsVar) {
        this.zza.zzU().zzN(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzb(String str, long j, long j3) {
        this.zza.zzU().zzO(str, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzc(zzv zzvVar, @Nullable zzht zzhtVar) {
        this.zza.zzU().zzP(zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzd(int i2, long j) {
        this.zza.zzU().zzQ(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zze(final zzbv zzbvVar) {
        zzdn zzdnVar = new zzdn() { // from class: com.google.android.gms.internal.ads.zzir
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                ((zzaz) obj).zzt(zzbvVar);
            }
        };
        zzds zzdsVarZzT = this.zza.zzT();
        zzdsVarZzT.zzd(25, zzdnVar);
        zzdsVarZzT.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzf(Object obj, long j) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzU().zzT(obj, j);
        if (zzjuVar.zzW() == obj) {
            zzds zzdsVarZzT = zzjuVar.zzT();
            zzdsVarZzT.zzd(26, zzis.zza);
            zzdsVarZzT.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzg(String str) {
        this.zza.zzU().zzR(str);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzh(zzhs zzhsVar) {
        this.zza.zzU().zzS(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzi(long j, int i2) {
        this.zza.zzU().zzU(j, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzj(Exception exc) {
        this.zza.zzU().zzV(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzk(zzhs zzhsVar) {
        this.zza.zzU().zzC(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzl(String str, long j, long j3) {
        this.zza.zzU().zzD(str, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzm(zzv zzvVar, @Nullable zzht zzhtVar) {
        this.zza.zzU().zzE(zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzn(long j) {
        this.zza.zzU().zzF(j);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzo(int i2, long j, long j3) {
        this.zza.zzU().zzG(i2, j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzp(String str) {
        this.zza.zzU().zzH(str);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzq(zzhs zzhsVar) {
        this.zza.zzU().zzI(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzr(final boolean z2) {
        zzju zzjuVar = this.zza;
        if (zzjuVar.zzX() == z2) {
            return;
        }
        zzjuVar.zzY(z2);
        zzds zzdsVarZzT = zzjuVar.zzT();
        zzdsVarZzT.zzd(23, new zzdn() { // from class: com.google.android.gms.internal.ads.zzio
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                ((zzaz) obj).zzs(z2);
            }
        });
        zzdsVarZzT.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzs(Exception exc) {
        this.zza.zzU().zzJ(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzt(Exception exc) {
        this.zza.zzU().zzK(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzu(zzqb zzqbVar) {
        this.zza.zzU().zzL(zzqbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzv(zzqb zzqbVar) {
        this.zza.zzU().zzM(zzqbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzw(final int i2) {
        this.zza.zzV().zza(new zzglu() { // from class: com.google.android.gms.internal.ads.zzip
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return Integer.valueOf(i2);
            }
        }, new zzglu() { // from class: com.google.android.gms.internal.ads.zziq
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return Integer.valueOf(i2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzx(zzmf zzmfVar) {
        this.zza.zzP(zzib.zzc(zzmfVar, 1003));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }
}
