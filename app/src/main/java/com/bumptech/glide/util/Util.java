package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import com.bumptech.glide.request.BaseRequestOptions;
import com.ironsource.C2300e4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];

    @Nullable
    private static volatile Handler mainThreadHandler;

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Util() {
    }

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothBaseRequestOptionsNullEquivalentOrEquals(@Nullable BaseRequestOptions<?> baseRequestOptions, @Nullable BaseRequestOptions<?> baseRequestOptions2) {
        return baseRequestOptions == null ? baseRequestOptions2 == null : baseRequestOptions.isEquivalentTo(baseRequestOptions2);
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof Model ? ((Model) obj).isEquivalentTo(obj2) : obj.equals(obj2);
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    private static String bytesToHex(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b8 = bArr[i2];
            int i8 = i2 * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i8] = cArr2[(b8 & 255) >>> 4];
            cArr[i8 + 1] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i2) {
        return new ArrayDeque(i2);
    }

    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + C2300e4.i.f8403d + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int getBytesPerPixel(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        int i8 = 1;
        if (i2 != 1) {
            i8 = 2;
            if (i2 != 2 && i2 != 3) {
                return i2 != 4 ? 4 : 8;
            }
        }
        return i8;
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t3 : collection) {
            if (t3 != null) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    private static Handler getUiThreadHandler() {
        if (mainThreadHandler == null) {
            synchronized (Util.class) {
                try {
                    if (mainThreadHandler == null) {
                        mainThreadHandler = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return mainThreadHandler;
    }

    public static int hashCode(int i2, int i8) {
        return (i8 * 31) + i2;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isValidDimension(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean isValidDimensions(int i2, int i8) {
        return isValidDimension(i2) && isValidDimension(i8);
    }

    public static void postAtFrontOfQueueOnUiThread(Runnable runnable) {
        getUiThreadHandler().postAtFrontOfQueue(runnable);
    }

    public static void postOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static void removeCallbacksOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String strBytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            strBytesToHex = bytesToHex(bArr, cArr);
        }
        return strBytesToHex;
    }

    public static int hashCode(int i2) {
        return hashCode(i2, 17);
    }

    public static int hashCode(float f4) {
        return hashCode(f4, 17);
    }

    public static int hashCode(float f4, int i2) {
        return hashCode(Float.floatToIntBits(f4), i2);
    }

    public static int hashCode(@Nullable Object obj, int i2) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int hashCode(boolean z2, int i2) {
        return hashCode(z2 ? 1 : 0, i2);
    }

    public static int hashCode(boolean z2) {
        return hashCode(z2, 17);
    }

    public static int getBitmapByteSize(int i2, int i8, @Nullable Bitmap.Config config) {
        return getBytesPerPixel(config) * i2 * i8;
    }
}
