package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzglm {
    public static String zza(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (zzd(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c7 = charArray[i2];
                    if (zzd(c7)) {
                        charArray[i2] = (char) (c7 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static String zzb(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (zzc(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c7 = charArray[i2];
                    if (zzc(c7)) {
                        charArray[i2] = (char) (c7 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static boolean zzc(char c7) {
        return c7 >= 'a' && c7 <= 'z';
    }

    public static boolean zzd(char c7) {
        return c7 >= 'A' && c7 <= 'Z';
    }

    public static boolean zze(CharSequence charSequence, CharSequence charSequence2) {
        int iZzf;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            char cCharAt2 = charSequence2.charAt(i2);
            if (cCharAt != cCharAt2 && ((iZzf = zzf(cCharAt)) >= 26 || iZzf != zzf(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int zzf(char c7) {
        return (char) ((c7 | ' ') - 97);
    }
}
