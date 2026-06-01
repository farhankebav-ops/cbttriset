package com.google.android.gms.internal.measurement;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmp {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName(Key.STRING_CHARSET_NAME);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new zzli(bArr, 0, 0, false, null).zza(0);
        } catch (zzmr e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int zzc(int i2, byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            i2 = (i2 * 31) + bArr[i10];
        }
        return i2;
    }

    public static boolean zzd(zznm zznmVar) {
        if (zznmVar instanceof zzkt) {
            throw null;
        }
        return false;
    }
}
