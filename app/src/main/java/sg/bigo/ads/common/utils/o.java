package sg.bigo.ads.common.utils;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f16025a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f16026b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 17, 18, 19, 20, 21, 22};

    @Nullable
    public static String a(@NonNull String str, @NonNull String str2) {
        return b(str, str2);
    }

    @Nullable
    private static String b(@NonNull String str, @NonNull String str2) {
        try {
            return q.a(a(str.getBytes(Key.STRING_CHARSET_NAME), q.c(str2)));
        } catch (UnsupportedEncodingException e) {
            a((ValueCallback<Exception>) null, e);
            return null;
        }
    }

    public static String a(@NonNull String str, @NonNull String str2, @Nullable ValueCallback<Exception> valueCallback) {
        try {
            byte[] bArrB = b(str, str2, valueCallback);
            if (bArrB != null) {
                return new String(bArrB, Key.STRING_CHARSET_NAME);
            }
            return null;
        } catch (Exception e) {
            a(valueCallback, e);
            sg.bigo.ads.common.t.a.a(0, "SDKCipher", "Failed to decrypt data: ".concat(String.valueOf(str)));
            return null;
        }
    }

    @Nullable
    public static byte[] b(@NonNull String str, @NonNull String str2, @Nullable ValueCallback<Exception> valueCallback) {
        try {
            return a(q.c(str), q.c(str2), valueCallback);
        } catch (Exception e) {
            a(valueCallback, e);
            sg.bigo.ads.common.t.a.a(0, "SDKCipher", "Failed to decrypt data: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static void a(ValueCallback<Exception> valueCallback, Exception exc) {
        if (valueCallback != null) {
            valueCallback.onReceiveValue(exc);
        }
    }

    @Nullable
    public static byte[] b(byte[] bArr) {
        return a(bArr, f16026b, (ValueCallback<Exception>) null);
    }

    @Nullable
    public static byte[] a(byte[] bArr) {
        return a(bArr, f16026b);
    }

    @Nullable
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f16025a);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                a((ValueCallback<Exception>) null, e);
                if (e instanceof NoSuchAlgorithmException) {
                    sg.bigo.ads.common.t.a.a(0, "SDKCipher", "sdk cipher.encrypt failed, no such algorithm");
                    return bArr;
                }
                sg.bigo.ads.common.t.a.a(0, "SDKCipher", "sdk cipher.encrypt failed");
            }
        }
        return null;
    }

    @Nullable
    private static byte[] a(byte[] bArr, byte[] bArr2, ValueCallback<Exception> valueCallback) {
        if (bArr != null && bArr2 != null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f16025a);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                a(valueCallback, e);
                sg.bigo.ads.common.t.a.a(0, "SDKCipher", "sdk cipher.decrypt new key failed,input len:" + bArr.length + ",input data:" + Arrays.toString(bArr));
                if (e instanceof NoSuchAlgorithmException) {
                    return bArr;
                }
            }
        }
        return null;
    }
}
