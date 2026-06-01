package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF {
    public static void IlO(Uri uri, com.bytedance.sdk.openadsdk.core.vSq vsq) {
        if (vsq == null || !vsq.IlO(uri)) {
            return;
        }
        try {
            vsq.MY(uri);
        } catch (Exception e) {
            e.toString();
        }
    }

    public static String IlO(WebView webView, int i2) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news open_news_u_s/" + i2;
    }
}
