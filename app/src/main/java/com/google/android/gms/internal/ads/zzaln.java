package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaln implements zzaki {
    private final zzeg zza = new zzeg();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaln(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = "sans-serif";
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzep.zzj(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
        int i2 = bArr[25] * 20;
        this.zzg = i2;
        boolean z2 = (bArr[0] & 32) != 0;
        this.zzb = z2;
        if (z2) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i2, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i2, int i8, int i9, int i10, int i11) {
        if (i2 != i8) {
            int i12 = i11 | 33;
            int i13 = i2 & 1;
            int i14 = i2 & 2;
            boolean z2 = true;
            if (i13 != 0) {
                if (i14 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i9, i10, i12);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i9, i10, i12);
                    z2 = false;
                }
            } else if (i14 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i9, i10, i12);
            } else {
                z2 = false;
            }
            if ((i2 & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i9, i10, i12);
            } else {
                if (i13 != 0 || z2) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i9, i10, i12);
            }
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i2, int i8, int i9, int i10, int i11) {
        if (i2 != i8) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i9, i10, i11 | 33);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i2, int i8, zzakh zzakhVar, zzdg zzdgVar) {
        String strZzK;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        SpannableStringBuilder spannableStringBuilder;
        int i14;
        int i15;
        int i16;
        int i17;
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i2 + i8);
        zzegVar.zzh(i2);
        int i18 = 1;
        int i19 = 0;
        int i20 = 2;
        zzgmd.zza(zzegVar.zzd() >= 2);
        int iZzt = zzegVar.zzt();
        if (iZzt == 0) {
            strZzK = "";
        } else {
            int iZzg = zzegVar.zzg();
            Charset charsetZzR = zzegVar.zzR();
            int iZzg2 = zzegVar.zzg() - iZzg;
            if (charsetZzR == null) {
                charsetZzR = StandardCharsets.UTF_8;
            }
            strZzK = zzegVar.zzK(iZzt - iZzg2, charsetZzR);
        }
        if (strZzK.isEmpty()) {
            zzdgVar.zza(new zzaka(zzgpe.zzi(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strZzK);
        int i21 = this.zzc;
        zzb(spannableStringBuilder2, i21, 0, 0, spannableStringBuilder2.length(), 16711680);
        int i22 = i21;
        int i23 = this.zzd;
        zzc(spannableStringBuilder2, i23, -1, 0, spannableStringBuilder2.length(), 16711680);
        int i24 = i23;
        String str = this.zze;
        int length = spannableStringBuilder2.length();
        if (str != "sans-serif") {
            spannableStringBuilder2.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fMax = this.zzf;
        while (zzegVar.zzd() >= 8) {
            int iZzg3 = zzegVar.zzg();
            int iZzB = zzegVar.zzB();
            int iZzB2 = zzegVar.zzB();
            if (iZzB2 == 1937013100) {
                zzgmd.zza(zzegVar.zzd() >= i20 ? i18 : i19);
                int iZzt2 = zzegVar.zzt();
                int i25 = i19;
                while (i25 < iZzt2) {
                    zzgmd.zza(zzegVar.zzd() >= 12 ? i18 : i19);
                    int iZzt3 = zzegVar.zzt();
                    int iZzt4 = zzegVar.zzt();
                    zzegVar.zzk(i20);
                    int i26 = iZzt2;
                    int iZzs = zzegVar.zzs();
                    zzegVar.zzk(i18);
                    int iZzB3 = zzegVar.zzB();
                    if (iZzt4 > spannableStringBuilder2.length()) {
                        int length2 = spannableStringBuilder2.length();
                        i12 = i22;
                        i13 = i24;
                        spannableStringBuilder = spannableStringBuilder2;
                        StringBuilder sb = new StringBuilder(androidx.camera.core.processing.util.a.D(String.valueOf(iZzt4).length() + 44, 2, String.valueOf(length2)));
                        sb.append("Truncating styl end (");
                        sb.append(iZzt4);
                        sb.append(") to cueText.length() (");
                        sb.append(length2);
                        sb.append(").");
                        zzdt.zzc("Tx3gParser", sb.toString());
                        iZzt4 = spannableStringBuilder.length();
                    } else {
                        i12 = i22;
                        i13 = i24;
                        spannableStringBuilder = spannableStringBuilder2;
                    }
                    if (iZzt3 >= iZzt4) {
                        StringBuilder sb2 = new StringBuilder(androidx.camera.core.processing.util.a.D(String.valueOf(iZzt3).length() + 36, 2, String.valueOf(iZzt4)));
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iZzt3);
                        sb2.append(") >= end (");
                        sb2.append(iZzt4);
                        sb2.append(").");
                        zzdt.zzc("Tx3gParser", sb2.toString());
                        i16 = i12;
                        i15 = i25;
                        i14 = i26;
                        spannableStringBuilder2 = spannableStringBuilder;
                        i17 = i13;
                    } else {
                        i14 = i26;
                        i15 = i25;
                        spannableStringBuilder2 = spannableStringBuilder;
                        int i27 = i12;
                        zzb(spannableStringBuilder2, iZzs, i27, iZzt3, iZzt4, 0);
                        i16 = i27;
                        i17 = i13;
                        zzc(spannableStringBuilder2, iZzB3, i17, iZzt3, iZzt4, 0);
                    }
                    iZzt2 = i14;
                    i22 = i16;
                    i24 = i17;
                    i18 = 1;
                    i20 = 2;
                    i25 = i15 + 1;
                    i19 = 0;
                }
                i9 = i22;
                i10 = i24;
                i11 = i20;
            } else {
                i9 = i22;
                i10 = i24;
                if (iZzB2 == 1952608120 && this.zzb) {
                    i11 = 2;
                    zzgmd.zza(zzegVar.zzd() >= 2);
                    float fZzt = zzegVar.zzt();
                    int i28 = this.zzg;
                    String str2 = zzep.zza;
                    fMax = Math.max(0.0f, Math.min(fZzt / i28, 0.95f));
                } else {
                    i11 = 2;
                }
            }
            zzegVar.zzh(iZzg3 + iZzB);
            i22 = i9;
            i20 = i11;
            i24 = i10;
            i18 = 1;
            i19 = 0;
        }
        zzcl zzclVar = new zzcl();
        zzclVar.zza(spannableStringBuilder2);
        zzclVar.zzf(fMax, 0);
        zzclVar.zzg(0);
        zzdgVar.zza(new zzaka(zzgpe.zzj(zzclVar.zzr()), -9223372036854775807L, -9223372036854775807L));
    }
}
