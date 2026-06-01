package sg.bigo.ads.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15836a = "";

    public static String a(Context context) {
        String strR;
        if (sg.bigo.ads.common.n.d.b() && !q.a((CharSequence) f15836a)) {
            return f15836a;
        }
        if (q.a((CharSequence) f15836a)) {
            if (context == null) {
                strR = "";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                strR = a1.a.r(sb, File.separator, "sg_bigo_ad");
            }
            f15836a = strR;
        }
        File file = new File(f15836a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return f15836a;
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(i(context));
        return a1.a.r(sb, File.separator, "files");
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(i(context));
        return a1.a.r(sb, File.separator, "vpaid");
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(i(context));
        return a1.a.r(sb, File.separator, "thumb");
    }

    public static String e(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        return a1.a.r(sb, File.separator, "image");
    }

    public static String f(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        return a1.a.r(sb, File.separator, C2300e4.h.H0);
    }

    public static String g(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        return a1.a.r(sb, File.separator, "omsdk");
    }

    public static String h(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        return a1.a.r(sb, File.separator, "bannerjs");
    }

    private static String i(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(context));
        return a1.a.r(sb, File.separator, MimeTypes.BASE_TYPE_VIDEO);
    }

    @Nullable
    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
        sb.append(d(context));
        return a1.a.r(sb, File.separator, str);
    }

    public static boolean a(Context context, String str) {
        return str != null && str.equals(b(context));
    }
}
