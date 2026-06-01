package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.Cc.MY;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private static final Set<String> IlO = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", MRAIDPresenter.CLOSE, "close-fill", "webview-close")));
    private static String MY;

    /* JADX WARN: Removed duplicated region for block: B:227:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x045b A[Catch: Exception -> 0x046c, TryCatch #0 {Exception -> 0x046c, blocks: (B:228:0x044f, B:230:0x045b, B:235:0x0465), top: B:279:0x044f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.Cc.MY.EO IlO(java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, boolean r29, int r30, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW r31, double r32, int r34, double r35, java.lang.String r37, com.bytedance.sdk.component.adexpress.MY.hp r38) {
        /*
            Method dump skipped, instruction units count: 1305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.IlO(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.MY.hp):com.bytedance.sdk.component.adexpress.dynamic.Cc.MY$EO");
    }

    public static double MY(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] MY(String str, float f4, boolean z2) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.tV.IlO());
            textView.setTextSize(f4);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z2) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean MY() {
        return !TextUtils.isEmpty(MY);
    }

    public static String IlO(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static MY.EO IlO(MY.EO eo, String str, String str2, String str3) {
        if (str.contains("union")) {
            eo.IlO = 0.0f;
            eo.MY = 0.0f;
            return eo;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = IlO(str);
        }
        if (TextUtils.isEmpty(str3)) {
            eo.IlO = 0.0f;
            eo.MY = 0.0f;
            return eo;
        }
        return IlO(str3, str2);
    }

    public static MY.EO IlO(String str, String str2) {
        return IlO(str, str2, false);
    }

    public static MY.EO IlO(String str, String str2, boolean z2) {
        MY.EO eo = new MY.EO();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrIlO = IlO(str, (float) MY(str2), z2);
            eo.IlO = iArrIlO[0];
            eo.MY = iArrIlO[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                eo.MY = 0.0f;
            }
        } catch (Exception unused) {
        }
        return eo;
    }

    public static int[] IlO(String str, float f4, boolean z2) {
        int[] iArrMY = MY(str, f4, z2);
        return new int[]{com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), iArrMY[0]), com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), iArrMY[1])};
    }

    public static String IlO() {
        return MY;
    }
}
