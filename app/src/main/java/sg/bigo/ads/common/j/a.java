package sg.bigo.ads.common.j;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import sg.bigo.ads.common.utils.o;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15796a = "a";

    public static long a(String str, long j) {
        if (!TextUtils.isEmpty(str) && j != 0) {
            try {
                long jLongValue = Long.valueOf(str).longValue();
                int iHashCode = String.valueOf(j).hashCode();
                return ((j ^ jLongValue) ^ ((long) Math.abs(iHashCode))) >> 20;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    @Nullable
    public static byte[] b(@NonNull String str, @NonNull String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            str3 = f15796a;
            str4 = "cip error with empty.";
        } else if (TextUtils.isEmpty(str2)) {
            str3 = f15796a;
            str4 = "string error with empty.";
        } else {
            byte[] bArrB = o.b(str, str2, null);
            if (bArrB != null) {
                return bArrB;
            }
            str3 = f15796a;
            str4 = "cip error with empty content.";
        }
        sg.bigo.ads.common.t.a.a(0, str3, str4);
        return null;
    }

    @Nullable
    public static String a(@Nullable String str, @NonNull String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            str3 = f15796a;
            str4 = "data error with empty.";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                String strA = o.a(str, str2);
                a0.g(0, 3, strA, f15796a, a1.a.z("data=", str, ", hexStringSecKey=", str2, ", cryptStr="));
                return strA;
            }
            str3 = f15796a;
            str4 = "cip error with empty.";
        }
        sg.bigo.ads.common.t.a.a(0, str3, str4);
        return null;
    }

    @Nullable
    public static String a(@NonNull String str, @NonNull String str2, ValueCallback<Exception> valueCallback) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            str3 = f15796a;
            str4 = "cip error with empty.";
        } else if (TextUtils.isEmpty(str2)) {
            str3 = f15796a;
            str4 = "string error with empty.";
        } else {
            String strA = o.a(str, str2, valueCallback);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            str3 = f15796a;
            str4 = "cip error with empty content.";
        }
        sg.bigo.ads.common.t.a.a(0, str3, str4);
        return null;
    }
}
