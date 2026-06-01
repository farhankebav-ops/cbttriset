package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhrl {
    private static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);

    public static byte[] zza(String str, int i2) {
        byte[] bytes = str.getBytes(zza);
        int length = bytes.length;
        zzhrk zzhrkVar = new zzhrk(2, new byte[(length * 3) / 4]);
        if (!zzhrkVar.zza(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i8 = zzhrkVar.zzb;
        byte[] bArr = zzhrkVar.zza;
        if (i8 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        return bArr2;
    }
}
