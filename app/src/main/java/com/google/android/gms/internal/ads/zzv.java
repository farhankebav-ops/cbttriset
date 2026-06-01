package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv {
    public static final /* synthetic */ int zzO = 0;
    public final int zzA;
    public final float zzB;

    @Nullable
    public final byte[] zzC;
    public final int zzD;

    @Nullable
    public final zzi zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    private int zzP;

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final List zzc;

    @Nullable
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;

    @Nullable
    public final String zzk;

    @Nullable
    public final zzap zzl;

    @Nullable
    public final Object zzm;

    @Nullable
    public final String zzn;

    @Nullable
    public final String zzo;
    public final int zzp;
    public final int zzq;
    public final List zzr;

    @Nullable
    public final zzq zzs;
    public final long zzt;
    public final boolean zzu;
    public final int zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final float zzz;

    static {
        new zzv(new zzt());
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
    }

    public /* synthetic */ zzv(zzt zztVar, byte[] bArr) {
        this(zztVar);
    }

    public static String zze(@Nullable zzv zzvVar) {
        String str;
        int i2;
        int i8;
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("id=");
        sbR.append(zzvVar.zza);
        sbR.append(", mimeType=");
        sbR.append(zzvVar.zzo);
        String str2 = zzvVar.zzn;
        if (str2 != null) {
            sbR.append(", container=");
            sbR.append(str2);
        }
        int i9 = zzvVar.zzj;
        if (i9 != -1) {
            sbR.append(", bitrate=");
            sbR.append(i9);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            sbR.append(", codecs=");
            sbR.append(str3);
        }
        zzq zzqVar = zzvVar.zzs;
        if (zzqVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i10 = 0; i10 < zzqVar.zzb; i10++) {
                UUID uuid = zzqVar.zza(i10).zza;
                if (uuid.equals(zzg.zzb)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(zzg.zzc)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zzg.zze)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zzg.zzd)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zzg.zza)) {
                    linkedHashSet.add(GatewayException.GATEWAY_RESPONSE_DEPTH_UNIVERSAL);
                } else {
                    String string = uuid.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 10);
                    sb.append("unknown (");
                    sb.append(string);
                    sb.append(")");
                    linkedHashSet.add(sb.toString());
                }
            }
            sbR.append(", drm=[");
            zzglx.zzb(sbR, linkedHashSet, ",");
            sbR.append(']');
        }
        int i11 = zzvVar.zzv;
        if (i11 != -1 && (i8 = zzvVar.zzw) != -1) {
            com.google.android.gms.ads.internal.client.a.k(i11, i8, ", res=", "x", sbR);
        }
        int i12 = zzvVar.zzx;
        if (i12 != -1 && (i2 = zzvVar.zzy) != -1) {
            com.google.android.gms.ads.internal.client.a.k(i12, i2, ", decRes=", "x", sbR);
        }
        float f4 = zzvVar.zzB;
        int i13 = zzgsj.zza;
        double d8 = f4;
        if (Math.copySign((-1.0d) + d8, 1.0d) > 0.001d && d8 != 1.0d && (!Double.isNaN(d8) || !Double.isNaN(1.0d))) {
            sbR.append(", par=");
            Object[] objArr = {Float.valueOf(f4)};
            String str4 = zzep.zza;
            sbR.append(String.format(Locale.US, "%.3f", objArr));
        }
        zzi zziVar = zzvVar.zzE;
        if (zziVar != null && (zziVar.zze() || zziVar.zzf())) {
            sbR.append(", color=");
            sbR.append(zziVar.zzg());
        }
        float f8 = zzvVar.zzz;
        if (f8 != -1.0f) {
            sbR.append(", fps=");
            sbR.append(f8);
        }
        int i14 = zzvVar.zzF;
        if (i14 != -1) {
            sbR.append(", maxSubLayers=");
            sbR.append(i14);
        }
        int i15 = zzvVar.zzG;
        if (i15 != -1) {
            sbR.append(", channels=");
            sbR.append(i15);
        }
        int i16 = zzvVar.zzH;
        if (i16 != -1) {
            sbR.append(", sample_rate=");
            sbR.append(i16);
        }
        String str5 = zzvVar.zzd;
        if (str5 != null) {
            sbR.append(", language=");
            sbR.append(str5);
        }
        List list = zzvVar.zzc;
        if (!list.isEmpty()) {
            sbR.append(", labels=[");
            zzglx.zzb(sbR, zzgqe.zzc(list, zzu.zza), ",");
            sbR.append(C2300e4.i.e);
        }
        int i17 = zzvVar.zze;
        if (i17 != 0) {
            sbR.append(", selectionFlags=[");
            String str6 = zzep.zza;
            ArrayList arrayList = new ArrayList();
            if ((i17 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i17 & 2) != 0) {
                arrayList.add("forced");
            }
            zzglx.zzb(sbR, arrayList, ",");
            sbR.append(C2300e4.i.e);
        }
        int i18 = zzvVar.zzf;
        if (i18 != 0) {
            sbR.append(", roleFlags=[");
            int i19 = i18 & 32768;
            String str7 = zzep.zza;
            ArrayList arrayList2 = new ArrayList();
            if ((i18 & 1) != 0) {
                arrayList2.add(C2300e4.h.Z);
            }
            if ((i18 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i18 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i18 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i18 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i18 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i18 & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((i18 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i18 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i18 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i18 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i18 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i18 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i18 & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i18 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if (i19 != 0) {
                arrayList2.add("auxiliary");
            }
            zzglx.zzb(sbR, arrayList2, ",");
            sbR.append(C2300e4.i.e);
        }
        if ((i18 & 32768) != 0) {
            sbR.append(", auxiliaryTrackType=");
            int i20 = zzvVar.zzg;
            String str8 = zzep.zza;
            if (i20 == 0) {
                str = AdError.UNDEFINED_DOMAIN;
            } else if (i20 == 1) {
                str = "original";
            } else if (i20 == 2) {
                str = "depth-linear";
            } else if (i20 == 3) {
                str = "depth-inverse";
            } else {
                if (i20 != 4) {
                    throw new IllegalStateException("Unsupported auxiliary track type");
                }
                str = "depth metadata";
            }
            sbR.append(str);
        }
        return sbR.toString();
    }

    public final boolean equals(@Nullable Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzv.class == obj.getClass()) {
            zzv zzvVar = (zzv) obj;
            int i8 = this.zzP;
            if ((i8 == 0 || (i2 = zzvVar.zzP) == 0 || i8 == i2) && this.zze == zzvVar.zze && this.zzf == zzvVar.zzf && this.zzg == zzvVar.zzg && this.zzh == zzvVar.zzh && this.zzi == zzvVar.zzi && this.zzp == zzvVar.zzp && this.zzt == zzvVar.zzt && this.zzv == zzvVar.zzv && this.zzw == zzvVar.zzw && this.zzx == zzvVar.zzx && this.zzy == zzvVar.zzy && this.zzA == zzvVar.zzA && this.zzD == zzvVar.zzD && this.zzF == zzvVar.zzF && this.zzG == zzvVar.zzG && this.zzH == zzvVar.zzH && this.zzI == zzvVar.zzI && this.zzJ == zzvVar.zzJ && this.zzK == zzvVar.zzK && this.zzL == zzvVar.zzL && this.zzN == zzvVar.zzN && Float.compare(this.zzz, zzvVar.zzz) == 0 && Float.compare(this.zzB, zzvVar.zzB) == 0 && Objects.equals(this.zza, zzvVar.zza) && Objects.equals(this.zzb, zzvVar.zzb) && this.zzc.equals(zzvVar.zzc) && Objects.equals(this.zzk, zzvVar.zzk) && Objects.equals(this.zzn, zzvVar.zzn) && Objects.equals(this.zzo, zzvVar.zzo) && Objects.equals(this.zzd, zzvVar.zzd) && Arrays.equals(this.zzC, zzvVar.zzC) && Objects.equals(this.zzl, zzvVar.zzl) && Objects.equals(this.zzE, zzvVar.zzE) && Objects.equals(this.zzs, zzvVar.zzs) && zzd(zzvVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzP;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = this.zzc.hashCode() + ((((iHashCode + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31);
        String str3 = this.zzd;
        int iHashCode3 = ((((((((((((iHashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzap zzapVar = this.zzl;
        int iHashCode5 = iHashCode4 + (zzapVar == null ? 0 : zzapVar.hashCode());
        String str5 = this.zzn;
        int iHashCode6 = ((iHashCode5 * 961) + (str5 == null ? 0 : str5.hashCode())) * 31;
        int iFloatToIntBits = ((((((((((((((((((((((Float.floatToIntBits(this.zzB) + ((((Float.floatToIntBits(this.zzz) + ((((((((((((((iHashCode6 + (this.zzo != null ? r0.hashCode() : 0)) * 31) + this.zzp) * 31) + ((int) this.zzt)) * 31) + this.zzv) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31)) * 31) + this.zzA) * 31)) * 31) + this.zzD) * 31) + this.zzF) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) - 1) * 31) - 1) * 31) + this.zzN;
        this.zzP = iFloatToIntBits;
        return iFloatToIntBits;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzE);
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzn;
        int length3 = String.valueOf(str3).length();
        String str4 = this.zzo;
        int length4 = String.valueOf(str4).length();
        String str5 = this.zzk;
        int length5 = String.valueOf(str5).length();
        int i2 = this.zzj;
        int length6 = String.valueOf(i2).length();
        String str6 = this.zzd;
        int length7 = String.valueOf(str6).length();
        int i8 = this.zzv;
        int length8 = String.valueOf(i8).length();
        int i9 = this.zzw;
        int length9 = String.valueOf(i9).length();
        float f4 = this.zzz;
        int length10 = String.valueOf(f4).length();
        int length11 = strValueOf.length();
        int i10 = this.zzG;
        int length12 = String.valueOf(i10).length();
        int i11 = this.zzH;
        StringBuilder sb = new StringBuilder(length + 9 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2 + length6 + 2 + length7 + 3 + length8 + 2 + length9 + 2 + length10 + 2 + length11 + 4 + length12 + 2 + String.valueOf(i11).length() + 2);
        androidx.camera.core.processing.util.a.A(sb, "Format(", str, ", ", str2);
        androidx.camera.core.processing.util.a.A(sb, ", ", str3, ", ", str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i8);
        sb.append(", ");
        sb.append(i9);
        sb.append(", ");
        sb.append(f4);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append("], [");
        sb.append(i10);
        return com.google.android.gms.ads.internal.client.a.j(sb, ", ", i11, "])");
    }

    public final zzt zza() {
        return new zzt(this, null);
    }

    public final zzv zzb(int i2) {
        zzt zztVar = new zzt(this, null);
        zztVar.zzL(i2);
        return new zzv(zztVar);
    }

    public final int zzc() {
        int i2;
        int i8 = this.zzv;
        if (i8 == -1 || (i2 = this.zzw) == -1) {
            return -1;
        }
        return i8 * i2;
    }

    public final boolean zzd(zzv zzvVar) {
        List list = this.zzr;
        int size = list.size();
        List list2 = zzvVar.zzr;
        if (size != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private zzv(zzt zztVar) {
        boolean z2;
        String str;
        this.zza = zztVar.zzN();
        String strZzh = zzep.zzh(zztVar.zzQ());
        this.zzd = strZzh;
        if (zztVar.zzP().isEmpty() && zztVar.zzO() != null) {
            this.zzc = zzgpe.zzj(new zzx(strZzh, zztVar.zzO()));
            this.zzb = zztVar.zzO();
        } else if (!zztVar.zzP().isEmpty() && zztVar.zzO() == null) {
            this.zzc = zztVar.zzP();
            List listZzP = zztVar.zzP();
            Iterator it = listZzP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzx) listZzP.get(0)).zzb;
                    break;
                }
                zzx zzxVar = (zzx) it.next();
                if (TextUtils.equals(zzxVar.zza, strZzh)) {
                    str = zzxVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        } else if (zztVar.zzP().isEmpty() && zztVar.zzO() == null) {
            z2 = true;
            zzgmd.zzh(z2);
            this.zzc = zztVar.zzP();
            this.zzb = zztVar.zzO();
        } else {
            for (int i2 = 0; i2 < zztVar.zzP().size(); i2++) {
                if (((zzx) zztVar.zzP().get(i2)).zzb.equals(zztVar.zzO())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            zzgmd.zzh(z2);
            this.zzc = zztVar.zzP();
            this.zzb = zztVar.zzO();
        }
        this.zze = zztVar.zzR();
        zzgmd.zzi(zztVar.zzT() == 0 || (zztVar.zzS() & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zztVar.zzS();
        this.zzg = zztVar.zzT();
        int iZzU = zztVar.zzU();
        this.zzh = iZzU;
        int iZzV = zztVar.zzV();
        this.zzi = iZzV;
        this.zzj = iZzV != -1 ? iZzV : iZzU;
        this.zzk = zztVar.zzW();
        this.zzl = zztVar.zzX();
        this.zzm = null;
        this.zzn = zztVar.zzY();
        this.zzo = zztVar.zzZ();
        this.zzp = zztVar.zzaa();
        this.zzq = zztVar.zzab();
        this.zzr = zztVar.zzac() == null ? Collections.EMPTY_LIST : zztVar.zzac();
        zzq zzqVarZzad = zztVar.zzad();
        this.zzs = zzqVarZzad;
        this.zzt = zztVar.zzae();
        this.zzu = zztVar.zzaf();
        this.zzv = zztVar.zzag();
        this.zzw = zztVar.zzah();
        this.zzx = zztVar.zzai();
        this.zzy = zztVar.zzaj();
        this.zzz = zztVar.zzak();
        this.zzA = zztVar.zzal() == -1 ? 0 : zztVar.zzal();
        this.zzB = zztVar.zzam() == -1.0f ? 1.0f : zztVar.zzam();
        this.zzC = zztVar.zzan();
        this.zzD = zztVar.zzao();
        this.zzE = zztVar.zzap();
        this.zzF = zztVar.zzaq();
        this.zzG = zztVar.zzar();
        this.zzH = zztVar.zzas();
        this.zzI = zztVar.zzat();
        this.zzJ = zztVar.zzau() == -1 ? 0 : zztVar.zzau();
        this.zzK = zztVar.zzav() != -1 ? zztVar.zzav() : 0;
        this.zzL = zztVar.zzaw();
        this.zzM = zztVar.zzax();
        if (zztVar.zzay() != 0 || zzqVarZzad == null) {
            this.zzN = zztVar.zzay();
        } else {
            this.zzN = 1;
        }
    }
}
