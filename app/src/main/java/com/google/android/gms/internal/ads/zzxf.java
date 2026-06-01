package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxf extends zzya implements Comparable {
    private final int zze;
    private final boolean zzf;

    @Nullable
    private final String zzg;
    private final zzxt zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    public zzxf(int i2, zzbg zzbgVar, int i8, zzxt zzxtVar, int i9, boolean z2, zzgme zzgmeVar, int i10) {
        int i11;
        int iZzj;
        int iHashCode;
        int iZzj2;
        boolean z7;
        super(i2, zzbgVar, i8);
        this.zzh = zzxtVar;
        int i12 = 1;
        int i13 = true != zzxtVar.zzT ? 16 : 24;
        this.zzg = zzyi.zzi(this.zzd.zzd);
        this.zzi = h0.c(i9, false);
        int i14 = 0;
        while (true) {
            i11 = Integer.MAX_VALUE;
            if (i14 >= zzxtVar.zzq.size()) {
                iZzj = 0;
                i14 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzyi.zzj(this.zzd, (String) zzxtVar.zzq.get(i14), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        this.zzk = i14;
        this.zzj = iZzj;
        this.zzl = zzyi.zzm(this.zzd.zzf, 0);
        this.zzm = zzyi.zzn(this.zzd, zzxtVar.zzr);
        zzv zzvVar = this.zzd;
        int i15 = zzvVar.zzf;
        this.zzn = i15 == 0 || (i15 & 1) != 0;
        this.zzq = 1 == (zzvVar.zze & 1);
        String str = zzvVar.zzo;
        this.zzx = str != null && ((iHashCode = str.hashCode()) == -2123537834 ? str.equals("audio/eac3-joc") : !(iHashCode == 187078297 ? !str.equals("audio/ac4") : !(iHashCode == 1504698186 && str.equals("audio/iamf"))));
        int i16 = zzvVar.zzG;
        this.zzr = i16;
        this.zzs = zzvVar.zzH;
        int i17 = zzvVar.zzj;
        this.zzt = i17;
        this.zzf = (i17 == -1 || i17 <= zzxtVar.zzu) && (i16 == -1 || i16 <= zzxtVar.zzt) && zzgmeVar.zza(zzvVar);
        String str2 = zzep.zza;
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i18 = 0; i18 < strArrSplit.length; i18++) {
            strArrSplit[i18] = zzep.zzh(strArrSplit[i18]);
        }
        int i19 = 0;
        while (true) {
            if (i19 >= strArrSplit.length) {
                iZzj2 = 0;
                i19 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj2 = zzyi.zzj(this.zzd, strArrSplit[i19], false);
                if (iZzj2 > 0) {
                    break;
                } else {
                    i19++;
                }
            }
        }
        this.zzo = i19;
        this.zzp = iZzj2;
        int i20 = 0;
        while (true) {
            if (i20 >= zzxtVar.zzv.size()) {
                break;
            }
            String str3 = this.zzd.zzo;
            if (str3 != null && str3.equals(zzxtVar.zzv.get(i20))) {
                i11 = i20;
                break;
            }
            i20++;
        }
        this.zzu = i11;
        this.zzv = (i9 & 384) == 128;
        this.zzw = (i9 & 64) == 64;
        zzxt zzxtVar2 = this.zzh;
        if (h0.c(i9, zzxtVar2.zzV) && ((z7 = this.zzf) || zzxtVar2.zzO)) {
            int i21 = zzxtVar2.zzw.zzb;
            if (h0.c(i9, false) && z7 && this.zzd.zzj != -1 && ((zzxtVar2.zzX || !z2) && (i13 & i9) != 0)) {
                i12 = 2;
            }
        } else {
            i12 = 0;
        }
        this.zze = i12;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxf zzxfVar) {
        boolean z2 = this.zzf;
        zzgqy zzgqyVarZza = (z2 && this.zzi) ? zzyi.zzc : zzyi.zzc.zza();
        zzgot zzgotVarZza = zzgot.zzg().zzd(this.zzi, zzxfVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzxfVar.zzk), zzgqy.zzb().zza()).zzb(this.zzj, zzxfVar.zzj).zzb(this.zzl, zzxfVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzxfVar.zzm), zzgqy.zzb().zza()).zzd(this.zzq, zzxfVar.zzq).zzd(this.zzn, zzxfVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzxfVar.zzo), zzgqy.zzb().zza()).zzb(this.zzp, zzxfVar.zzp).zzd(z2, zzxfVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzxfVar.zzu), zzgqy.zzb().zza());
        boolean z7 = this.zzh.zzF;
        zzgot zzgotVarZza2 = zzgotVarZza.zzd(this.zzv, zzxfVar.zzv).zzd(this.zzw, zzxfVar.zzw).zzd(this.zzx, zzxfVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzxfVar.zzr), zzgqyVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzxfVar.zzs), zzgqyVarZza);
        if (Objects.equals(this.zzg, zzxfVar.zzg)) {
            zzgotVarZza2 = zzgotVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzxfVar.zzt), zzgqyVarZza);
        }
        return zzgotVarZza2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        String str;
        int i2;
        zzxf zzxfVar = (zzxf) zzyaVar;
        boolean z2 = this.zzh.zzR;
        zzv zzvVar = this.zzd;
        int i8 = zzvVar.zzG;
        if (i8 == -1) {
            return false;
        }
        zzv zzvVar2 = zzxfVar.zzd;
        return i8 == zzvVar2.zzG && (str = zzvVar.zzo) != null && TextUtils.equals(str, zzvVar2.zzo) && (i2 = zzvVar.zzH) != -1 && i2 == zzvVar2.zzH && this.zzv == zzxfVar.zzv && this.zzw == zzxfVar.zzw;
    }
}
