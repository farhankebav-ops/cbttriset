package s;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageDigest f13653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f13654b;

    static {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        f13653a = messageDigest;
        f13654b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = f13653a;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
        synchronized (a.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        if (bArrDigest == null || bArrDigest.length == 0) {
            return null;
        }
        char[] cArr = new char[bArrDigest.length << 1];
        int i2 = 0;
        for (byte b8 : bArrDigest) {
            int i8 = i2 + 1;
            char[] cArr2 = f13654b;
            cArr[i2] = cArr2[(b8 & 240) >> 4];
            i2 += 2;
            cArr[i8] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }
}
