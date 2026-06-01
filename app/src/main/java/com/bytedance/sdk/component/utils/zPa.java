package com.bytedance.sdk.component.utils;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private static final char[] IlO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String IlO(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes(Key.STRING_CHARSET_NAME));
                    return IlO(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String IlO(byte[] bArr) {
        if (bArr != null) {
            return IlO(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String IlO(byte[] bArr, int i2, int i8) {
        if (bArr != null) {
            if (i2 >= 0 && i2 + i8 <= bArr.length) {
                int i9 = i8 * 2;
                char[] cArr = new char[i9];
                int i10 = 0;
                for (int i11 = 0; i11 < i8; i11++) {
                    byte b8 = bArr[i11 + i2];
                    int i12 = i10 + 1;
                    char[] cArr2 = IlO;
                    cArr[i10] = cArr2[(b8 & 255) >> 4];
                    i10 += 2;
                    cArr[i12] = cArr2[b8 & 15];
                }
                return new String(cArr, 0, i9);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }
}
