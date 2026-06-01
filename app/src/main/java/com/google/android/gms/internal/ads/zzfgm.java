package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfgm {
    private com.google.android.gms.ads.internal.client.zzm zza;
    private com.google.android.gms.ads.internal.client.zzr zzb;
    private String zzc;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzga zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;

    @Nullable
    private zzbhx zzh;
    private com.google.android.gms.ads.internal.client.zzx zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzco zzl;

    @Nullable
    private zzboi zzn;

    @Nullable
    private zzeot zzr;
    private Bundle zzt;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzcs zzv;
    private int zzm = 1;
    private final zzfga zzo = new zzfga();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;
    private final AtomicLong zzu = new AtomicLong();

    public final boolean zzA() {
        return this.zzp;
    }

    public final boolean zzB() {
        return this.zzq;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzm zzC() {
        return this.zza;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzr zzD() {
        return this.zzb;
    }

    public final /* synthetic */ String zzE() {
        return this.zzc;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzga zzF() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzG() {
        return this.zze;
    }

    public final /* synthetic */ ArrayList zzH() {
        return this.zzf;
    }

    public final /* synthetic */ ArrayList zzI() {
        return this.zzg;
    }

    public final /* synthetic */ zzbhx zzJ() {
        return this.zzh;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzx zzK() {
        return this.zzi;
    }

    public final /* synthetic */ AdManagerAdViewOptions zzL() {
        return this.zzj;
    }

    public final /* synthetic */ PublisherAdViewOptions zzM() {
        return this.zzk;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzco zzN() {
        return this.zzl;
    }

    public final /* synthetic */ int zzO() {
        return this.zzm;
    }

    public final /* synthetic */ zzboi zzP() {
        return this.zzn;
    }

    public final /* synthetic */ zzfga zzQ() {
        return this.zzo;
    }

    public final /* synthetic */ boolean zzR() {
        return this.zzp;
    }

    public final /* synthetic */ boolean zzS() {
        return this.zzq;
    }

    public final /* synthetic */ zzeot zzT() {
        return this.zzr;
    }

    public final /* synthetic */ boolean zzU() {
        return this.zzs;
    }

    public final /* synthetic */ Bundle zzV() {
        return this.zzt;
    }

    public final /* synthetic */ AtomicLong zzW() {
        return this.zzu;
    }

    public final zzfgm zzX(@Nullable com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzv = zzcsVar;
        return this;
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzcs zzY() {
        return this.zzv;
    }

    public final zzfgm zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza = zzmVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzm zzb() {
        return this.zza;
    }

    public final zzfgm zzc(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb = zzrVar;
        return this;
    }

    public final zzfgm zzd(boolean z2) {
        this.zzp = z2;
        return this;
    }

    public final zzfgm zze(boolean z2) {
        this.zzq = z2;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzr zzf() {
        return this.zzb;
    }

    public final zzfgm zzg(String str) {
        this.zzc = str;
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final zzfgm zzi(@Nullable com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        this.zzd = zzgaVar;
        return this;
    }

    public final zzfga zzj() {
        return this.zzo;
    }

    public final zzfgm zzk(boolean z2) {
        this.zze = z2;
        return this;
    }

    public final zzfgm zzl(int i2) {
        this.zzm = i2;
        return this;
    }

    public final zzfgm zzm(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfgm zzn(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfgm zzo(@Nullable zzbhx zzbhxVar) {
        this.zzh = zzbhxVar;
        return this;
    }

    public final zzfgm zzp(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi = zzxVar;
        return this;
    }

    public final zzfgm zzq(@Nullable zzboi zzboiVar) {
        this.zzn = zzboiVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzga(false, true, false);
        return this;
    }

    public final zzfgm zzr(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza();
            this.zzl = publisherAdViewOptions.zzb();
        }
        return this;
    }

    public final zzfgm zzs(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfgm zzt(@Nullable zzeot zzeotVar) {
        this.zzr = zzeotVar;
        return this;
    }

    public final zzfgm zzu(boolean z2) {
        this.zzs = true;
        return this;
    }

    public final zzfgm zzv(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final long zzw() {
        return this.zzu.get();
    }

    public final zzfgm zzx(long j) {
        this.zzu.set(j);
        return this;
    }

    public final zzfgm zzy(zzfgn zzfgnVar) {
        this.zzo.zza(zzfgnVar.zzp.zza);
        this.zza = zzfgnVar.zzd;
        this.zzb = zzfgnVar.zzf;
        this.zzv = zzfgnVar.zzv;
        this.zzc = zzfgnVar.zzg;
        this.zzd = zzfgnVar.zza;
        this.zzf = zzfgnVar.zzh;
        this.zzg = zzfgnVar.zzi;
        this.zzh = zzfgnVar.zzj;
        this.zzi = zzfgnVar.zzk;
        zzs(zzfgnVar.zzm);
        zzr(zzfgnVar.zzn);
        this.zzp = zzfgnVar.zzq;
        this.zzq = zzfgnVar.zzr;
        this.zzr = zzfgnVar.zzc;
        this.zzs = zzfgnVar.zzs;
        this.zzt = zzfgnVar.zzt;
        this.zzu.set(zzfgnVar.zzu.get());
        return this;
    }

    public final zzfgn zzz() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfgn(this, null);
    }
}
