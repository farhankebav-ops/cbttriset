package sg.bigo.ads.common.utils;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class m {
    public static String a(String str) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(random.nextInt(99999999));
        sb.append(random.nextInt(99999999));
        while (sb.length() < 16) {
            sb.append('0');
        }
        if (sb.length() > 16) {
            sb.delete(16, sb.length());
        }
        String strB = b(str + ((Object) sb));
        if (q.a((CharSequence) strB)) {
            sg.bigo.ads.common.t.a.a(0, "MD5", "md5WithSalt is empty!");
            return strB;
        }
        char[] cArr = new char[48];
        for (int i2 = 0; i2 < 48; i2++) {
            int i8 = i2 / 3;
            int i9 = i2 % 3;
            if (i9 == 0) {
                cArr[i2] = strB.charAt(i8 * 2);
            } else if (i9 != 1) {
                cArr[i2] = strB.charAt((i8 * 2) + 1);
            } else {
                cArr[i2] = sb.charAt(i8);
            }
        }
        String str2 = new String(cArr);
        StringBuilder sb2 = new StringBuilder("getMD5MixSalt, val=");
        sb2.append(str);
        sb2.append(", salt=");
        sb2.append((Object) sb);
        sb2.append(", md5WithSalt=");
        sg.bigo.ads.common.t.a.a(0, 3, "MD5", a1.a.s(sb2, strB, ", md5MixSalt=", str2));
        return str2;
    }

    private static String b(String str) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(Key.STRING_CHARSET_NAME));
            bArrDigest = messageDigest.digest();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        if (bArrDigest == null || bArrDigest.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArrDigest) {
            int i2 = b8 & 255;
            if (i2 <= 15) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString().toLowerCase();
    }
}
