package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfgn {

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzga zza;

    @Nullable
    public final zzboi zzb;

    @Nullable
    public final zzeot zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final Bundle zze;
    public final com.google.android.gms.ads.internal.client.zzr zzf;
    public final String zzg;
    public final ArrayList zzh;
    public final ArrayList zzi;

    @Nullable
    public final zzbhx zzj;
    public final com.google.android.gms.ads.internal.client.zzx zzk;
    public final int zzl;
    public final AdManagerAdViewOptions zzm;
    public final PublisherAdViewOptions zzn;

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzco zzo;
    public final zzfgb zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final boolean zzs;
    public final Bundle zzt;
    public final AtomicLong zzu;

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzcs zzv;

    public /* synthetic */ zzfgn(zzfgm zzfgmVar, byte[] bArr) {
        this.zzf = zzfgmVar.zzD();
        this.zzg = zzfgmVar.zzE();
        this.zzv = zzfgmVar.zzY();
        this.zze = zzfgmVar.zzC().zzB;
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC2 = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC3 = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC4 = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC5 = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC6 = zzfgmVar.zzC();
        com.google.android.gms.ads.internal.client.zzm zzmVarZzC7 = zzfgmVar.zzC();
        int i2 = zzfgmVar.zzC().zza;
        long j = zzmVarZzC7.zzb;
        Bundle bundle = zzmVarZzC6.zzc;
        int i8 = zzmVarZzC5.zzd;
        List list = zzmVarZzC4.zze;
        boolean z2 = zzmVarZzC3.zzf;
        int i9 = zzmVarZzC2.zzg;
        boolean z7 = true;
        if (!zzmVarZzC.zzh && !zzfgmVar.zzG()) {
            z7 = false;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm(i2, j, bundle, i8, list, z2, i9, z7, zzfgmVar.zzC().zzi, zzfgmVar.zzC().zzj, zzfgmVar.zzC().zzk, zzfgmVar.zzC().zzl, zzfgmVar.zzC().zzm, zzfgmVar.zzC().zzn, zzfgmVar.zzC().zzo, zzfgmVar.zzC().zzp, zzfgmVar.zzC().zzq, zzfgmVar.zzC().zzr, zzfgmVar.zzC().zzs, zzfgmVar.zzC().zzt, zzfgmVar.zzC().zzu, zzfgmVar.zzC().zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzfgmVar.zzC().zzw), zzfgmVar.zzC().zzx, zzfgmVar.zzC().zzy, zzfgmVar.zzC().zzz, zzfgmVar.zzC().zzA);
        this.zzd = zzmVar;
        this.zza = zzfgmVar.zzF() != null ? zzfgmVar.zzF() : zzfgmVar.zzJ() != null ? zzfgmVar.zzJ().zzf : null;
        this.zzh = zzfgmVar.zzH();
        this.zzi = zzfgmVar.zzI();
        this.zzj = zzfgmVar.zzH() == null ? null : zzfgmVar.zzJ() == null ? new zzbhx(new NativeAdOptions.Builder().build()) : zzfgmVar.zzJ();
        this.zzk = zzfgmVar.zzK();
        this.zzl = zzfgmVar.zzO();
        this.zzm = zzfgmVar.zzL();
        this.zzn = zzfgmVar.zzM();
        this.zzo = zzfgmVar.zzN();
        this.zzb = zzfgmVar.zzP();
        this.zzp = new zzfgb(zzfgmVar.zzQ(), null);
        this.zzq = zzfgmVar.zzR();
        this.zzr = zzfgmVar.zzS();
        this.zzc = zzfgmVar.zzT();
        this.zzs = zzfgmVar.zzU();
        this.zzt = zzfgmVar.zzV();
        this.zzu = zzmVar.zzA != 0 ? new AtomicLong(zzmVar.zzA) : zzfgmVar.zzW();
    }

    public final boolean zza() {
        return this.zzg.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdJ));
    }
}
