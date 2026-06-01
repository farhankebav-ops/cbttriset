package com.bytedance.sdk.component.vCE.IlO.MY.MY;

import a1.a;
import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.IlO.IlO.Bc;
import com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static ContentResolver EO() {
        try {
            if (lEW.Bc().vCE() != null) {
                return lEW.Bc().vCE().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void IlO() {
        if (lEW.Bc().vCE() == null) {
            return;
        }
        try {
            ContentResolver contentResolverEO = EO();
            if (contentResolverEO != null) {
                contentResolverEO.getType(Uri.parse(tV() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void MY() {
        if (lEW.Bc().vCE() == null) {
            return;
        }
        try {
            ContentResolver contentResolverEO = EO();
            if (contentResolverEO != null) {
                contentResolverEO.getType(Uri.parse(tV() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    private static String tV() {
        return a.r(new StringBuilder(), Bc.MY, "/ad_log_event/");
    }

    public static void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        if (ilO == null) {
            return;
        }
        try {
            ContentResolver contentResolverEO = EO();
            if (contentResolverEO != null) {
                contentResolverEO.getType(Uri.parse(tV() + "adLogDispatch?event=" + vCE.IlO(ilO.vCE())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void IlO(String str, List<String> list, boolean z2) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(vCE.IlO(it.next()));
                sb.append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(vCE.IlO(sb.toString())) + "&replace=" + String.valueOf(z2);
            ContentResolver contentResolverEO = EO();
            if (contentResolverEO != null) {
                contentResolverEO.getType(Uri.parse(tV() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverEO = EO();
            if (contentResolverEO != null) {
                contentResolverEO.getType(Uri.parse(tV() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
