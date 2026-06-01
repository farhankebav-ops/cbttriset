package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f5049a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, 4096);
                        if (i2 == -1) {
                            break;
                        } else {
                            messageDigest.update(bArr, 0, i2);
                        }
                    }
                    try {
                        byte[] bArrDigest = messageDigest.digest();
                        String strA = a(bArrDigest, bArrDigest.length);
                        if (!str.equals(strA)) {
                            throw new RuntimeException(a1.a.n("md5 check failed file: local md5:", strA, " expect md5:", str));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(a1.a.j(e, new StringBuilder("md5 check failed:")), e);
                    }
                } finally {
                    CloseableUtils.close(inputStream);
                }
            } catch (Exception e4) {
                throw new RuntimeException("md5 check failed:" + e4.getMessage(), e4);
            }
        } catch (Exception e8) {
            throw new RuntimeException(a1.a.j(e8, new StringBuilder("md5 check failed:")), e8);
        }
    }

    private static String a(byte[] bArr, int i2) {
        if (bArr != null) {
            if (i2 <= bArr.length) {
                int i8 = i2 << 1;
                char[] cArr = new char[i8];
                int i9 = 0;
                for (int i10 = 0; i10 < i2; i10++) {
                    byte b8 = bArr[i10];
                    int i11 = i9 + 1;
                    char[] cArr2 = f5049a;
                    cArr[i9] = cArr2[(b8 & 255) >> 4];
                    i9 += 2;
                    cArr[i11] = cArr2[b8 & 15];
                }
                return new String(cArr, 0, i8);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }
}
