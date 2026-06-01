package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzme implements Handler.Callback, zzaz {
    private final zzbb zza;
    private final zzlz zzb;
    private final zzbd zzc = new zzbd();
    private final zzdm zzd;
    private final zzma zze;
    private final zzmb zzf;
    private final zzmc zzg;
    private final zzmd zzh;

    public zzme(zzbb zzbbVar, zzlz zzlzVar, zzdc zzdcVar, int i2, int i8, int i9, int i10) {
        this.zza = zzbbVar;
        this.zzb = zzlzVar;
        this.zzd = zzdcVar.zzd(zzbbVar.zzd(), this);
        this.zze = new zzma(this, i2);
        this.zzf = new zzmb(this, i8);
        this.zzg = new zzmc(this, i9);
        this.zzh = new zzmd(this, i10);
        zzbbVar.zze(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.zze.zza();
            return true;
        }
        if (i2 == 2) {
            this.zzf.zza();
            return true;
        }
        if (i2 == 3) {
            this.zzg.zza();
            return true;
        }
        if (i2 != 4) {
            return false;
        }
        this.zzh.zza();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zza(zzbb zzbbVar, zzay zzayVar) {
        this.zze.zza();
        this.zzf.zza();
        this.zzg.zza();
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzb(zzbf zzbfVar, int i2) {
        h.b(this, zzbfVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzc(zzak zzakVar, int i2) {
        h.c(this, zzakVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzd(zzbn zzbnVar) {
        h.d(this, zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zze(zzan zzanVar) {
        h.e(this, zzanVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzf(boolean z2) {
        h.f(this, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzg(zzax zzaxVar) {
        h.g(this, zzaxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzh(boolean z2, int i2) {
        h.h(this, z2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzi(int i2) {
        h.i(this, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzj(boolean z2, int i2) {
        h.j(this, z2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzk(int i2) {
        h.k(this, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzl(boolean z2) {
        h.l(this, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzm(zzau zzauVar) {
        h.m(this, zzauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzn(zzau zzauVar) {
        h.n(this, zzauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzo(zzba zzbaVar, zzba zzbaVar2, int i2) {
        h.o(this, zzbaVar, zzbaVar2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzp(zzav zzavVar) {
        h.p(this, zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzq(int i2) {
        h.q(this, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzr(float f4) {
        h.r(this, f4);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzs(boolean z2) {
        h.s(this, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzt(zzbv zzbvVar) {
        h.t(this, zzbvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final /* synthetic */ void zzu(int i2, int i8) {
        h.u(this, i2, i8);
    }

    public final void zzv() {
        this.zzd.zzl(null);
        this.zza.zzf(this);
    }

    public final /* synthetic */ zzbb zzw() {
        return this.zza;
    }

    public final /* synthetic */ zzlz zzx() {
        return this.zzb;
    }

    public final /* synthetic */ zzbd zzy() {
        return this.zzc;
    }

    public final /* synthetic */ zzdm zzz() {
        return this.zzd;
    }
}
