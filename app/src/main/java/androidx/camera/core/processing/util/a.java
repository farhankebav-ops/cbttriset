package androidx.camera.core.processing.util;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.SavedStateReaderKt;
import com.bytedance.sdk.component.adexpress.dynamic.tV.lEW;
import com.bytedance.sdk.openadsdk.cl.MY.IlO;
import e2.s;
import e6.l;
import e6.p;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void A(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static boolean B(lEW lew, String str) {
        return TextUtils.equals(lew.NV().MY(), str);
    }

    public static int C(int i2, int i8, int i9, int i10) {
        return ((i2 + i8) - i9) % i10;
    }

    public static int D(int i2, int i8, String str) {
        return str.length() + i2 + i8;
    }

    public static int a(int i2, int i8, int i9, int i10) {
        return ((i2 * i8) / i9) + i10;
    }

    public static int b(int i2, int i8, String str) {
        return (str.hashCode() + i2) * i8;
    }

    public static Bundle c(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static IlO d(String str) {
        IlO ilO = new IlO();
        ilO.MY(str);
        return ilO;
    }

    public static s e(String str) {
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        return new s(2);
    }

    public static String f(char c7, String str, String str2) {
        return str + str2 + c7;
    }

    public static String g(char c7, String str, StringBuilder sb) {
        sb.append(c7);
        String string = sb.toString();
        k.d(string, str);
        return string;
    }

    public static String h(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String i(String str, int i2, String str2, int i8) {
        return str + i2 + str2 + i8;
    }

    public static String j(String str, long j) {
        return str + j;
    }

    public static String k(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String l(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String m(StringBuilder sb, String str, int i2) {
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static StringBuilder o(CharSequence charSequence, String str, l lVar, String str2, CharSequence charSequence2) {
        k.e(charSequence, str);
        k.e(lVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder p(CharSequence charSequence, String str, p pVar, String str2, CharSequence charSequence2) {
        k.e(charSequence, str);
        k.e(pVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder q(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        k.e(charSequence, str);
        k.e(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    public static StringBuilder r(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder s(String str, int i2, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i2);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder t(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static HashMap u(String str, String str2) {
        HashMap map = new HashMap();
        map.put(str, str2);
        return map;
    }

    public static void v(int i2, int i8, l lVar) {
        lVar.invoke(Integer.valueOf(i2 + i8));
    }

    public static void w(int i2, int i8, String str, String str2, StringBuilder sb) {
        sb.append(i2);
        sb.append(str);
        sb.append(i8);
        sb.append(str2);
    }

    public static /* synthetic */ void x(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            c.v((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
        } else if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else {
            if (!(autoCloseable instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) autoCloseable).release();
        }
    }

    public static void y(StringBuilder sb, String str, long j, String str2) {
        sb.append(str);
        sb.append(j);
        sb.append(str2);
    }

    public static void z(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }
}
