package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfe extends zzbff {
    @Nullable
    private static final String zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i2 = 0;
        int i8 = 0;
        while (i8 < str.length() && str.charAt(i8) == ',') {
            i8++;
        }
        while (length > 0) {
            int i9 = length - 1;
            if (str.charAt(i9) != ',') {
                break;
            }
            length = i9;
        }
        if (length < i8) {
            return null;
        }
        if (i8 != 0) {
            i2 = i8;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i2, length);
    }

    @Override // com.google.android.gms.internal.ads.zzbff
    public final String zza(@Nullable String str, String str2) {
        String strZzb = zzb(str);
        String strZzb2 = zzb(str2);
        if (TextUtils.isEmpty(strZzb)) {
            return strZzb2;
        }
        if (TextUtils.isEmpty(strZzb2)) {
            return strZzb;
        }
        return a1.a.s(new StringBuilder(String.valueOf(strZzb).length() + 1 + String.valueOf(strZzb2).length()), strZzb, ",", strZzb2);
    }
}
