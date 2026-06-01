package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdd {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    public static String zza(int i2, int i8, int i9) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9));
    }

    public static String zzb(int i2, boolean z2, int i8, int i9, int[] iArr, int i10) {
        Object[] objArr = {zzc[i2], Integer.valueOf(i8), Integer.valueOf(i9), Character.valueOf(true != z2 ? 'L' : 'H'), Integer.valueOf(i10)};
        String str = zzep.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i11 = 6;
        while (i11 > 0) {
            int i12 = i11 - 1;
            if (iArr[i12] != 0) {
                break;
            }
            i11 = i12;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i13])));
        }
        return sb.toString();
    }

    public static String zzc(byte[] bArr) {
        int length = bArr.length;
        zzgmd.zzd(length >= 17, "Invalid APV CSD length: %s", length);
        byte b8 = bArr[0];
        zzgmd.zzd(b8 == 1, "Invalid APV CSD version: %s", b8);
        byte b9 = bArr[5];
        byte b10 = bArr[6];
        byte b11 = bArr[7];
        String str = zzep.zza;
        Locale locale = Locale.US;
        StringBuilder sbW = a1.a.w(b9, "apv1.apvf", ".apvl", b10, ".apvb");
        sbW.append((int) b11);
        return sbW.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x03fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair zzd(com.google.android.gms.internal.ads.zzv r26) {
        /*
            Method dump skipped, instruction units count: 2060
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zzd(com.google.android.gms.internal.ads.zzv):android.util.Pair");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Pair zze(String str, String[] strArr, @Nullable zzi zziVar) {
        int i2;
        Integer num;
        if (strArr.length < 4) {
            com.google.android.gms.ads.internal.client.a.q(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            com.google.android.gms.ads.internal.client.a.q(str, "Ignoring malformed HEVC codec string: ", "CodecSpecificDataUtil");
            return null;
        }
        String strGroup = matcher.group(1);
        if ("1".equals(strGroup)) {
            i2 = 1;
        } else {
            i2 = 6;
            if ("2".equals(strGroup)) {
                i2 = (zziVar == null || zziVar.zzd != 6) ? 2 : 4096;
            } else if (!"6".equals(strGroup)) {
                com.google.android.gms.ads.internal.client.a.q(strGroup, "Unknown HEVC profile string: ", "CodecSpecificDataUtil");
                return null;
            }
        }
        String str2 = strArr[3];
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 70821:
                    num = !str2.equals("H30") ? null : 2;
                    break;
                case 70914:
                    num = !str2.equals("H60") ? null : 8;
                    break;
                case 70917:
                    num = !str2.equals("H63") ? null : 32;
                    break;
                case 71007:
                    num = !str2.equals("H90") ? null : 128;
                    break;
                case 71010:
                    num = !str2.equals("H93") ? null : 512;
                    break;
                case 74665:
                    num = !str2.equals("L30") ? null : 1;
                    break;
                case 74758:
                    num = !str2.equals("L60") ? null : 4;
                    break;
                case 74761:
                    num = !str2.equals("L63") ? null : 16;
                    break;
                case 74851:
                    num = !str2.equals("L90") ? null : 64;
                    break;
                case 74854:
                    num = !str2.equals("L93") ? null : 256;
                    break;
                case 2193639:
                    num = !str2.equals("H120") ? null : 2048;
                    break;
                case 2193642:
                    num = !str2.equals("H123") ? null : 8192;
                    break;
                case 2193732:
                    num = !str2.equals("H150") ? null : 32768;
                    break;
                case 2193735:
                    num = !str2.equals("H153") ? null : 131072;
                    break;
                case 2193738:
                    num = !str2.equals("H156") ? null : 524288;
                    break;
                case 2193825:
                    num = !str2.equals("H180") ? null : 2097152;
                    break;
                case 2193828:
                    num = !str2.equals("H183") ? null : 8388608;
                    break;
                case 2193831:
                    num = !str2.equals("H186") ? null : 33554432;
                    break;
                case 2312803:
                    num = !str2.equals("L120") ? null : 1024;
                    break;
                case 2312806:
                    num = !str2.equals("L123") ? null : 4096;
                    break;
                case 2312896:
                    num = !str2.equals("L150") ? null : 16384;
                    break;
                case 2312899:
                    num = !str2.equals("L153") ? null : 65536;
                    break;
                case 2312902:
                    num = !str2.equals("L156") ? null : 262144;
                    break;
                case 2312989:
                    num = !str2.equals("L180") ? null : 1048576;
                    break;
                case 2312992:
                    num = !str2.equals("L183") ? null : 4194304;
                    break;
                case 2312995:
                    num = !str2.equals("L186") ? null : 16777216;
                    break;
                default:
                    num = null;
                    break;
            }
        } else {
            num = null;
        }
        if (num != null) {
            return new Pair(Integer.valueOf(i2), num);
        }
        com.google.android.gms.ads.internal.client.a.q(str2, "Unknown HEVC level string: ", "CodecSpecificDataUtil");
        return null;
    }

    public static byte[] zzf(byte[] bArr, int i2, int i8) {
        byte[] bArr2 = new byte[i8 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i2, bArr2, 4, i8);
        return bArr2;
    }
}
