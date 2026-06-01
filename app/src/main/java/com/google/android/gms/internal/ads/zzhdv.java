package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhdv {
    public static boolean zza(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char cCharAt = str.charAt(i2);
            int i8 = i2 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i2 = i8;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i8 == length || !Character.isLowSurrogate(str.charAt(i8))) {
                    return false;
                }
                i2 += 2;
            }
        }
        return true;
    }

    public static zzhtg zzb(String str) throws IOException {
        try {
            zzhul zzhulVar = new zzhul(new StringReader(str));
            zzhulVar.zza(zzhtl.LEGACY_STRICT);
            return zzhdt.zzb(zzhulVar);
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    public static long zzc(Number number) {
        if (number instanceof zzhdu) {
            return Long.parseLong(number.toString());
        }
        throw new IllegalArgumentException("does not contain a parsed number.");
    }
}
