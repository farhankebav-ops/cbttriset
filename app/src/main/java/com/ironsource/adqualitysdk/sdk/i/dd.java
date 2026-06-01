package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dd extends da {
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static boolean m1918(List<Object> list) {
        return ke.m2930((View) da.m1896(list, 0, View.class));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static WebView m1919(List<Object> list) {
        int iIntValue;
        Activity activity = (Activity) da.m1896(list, 0, Activity.class);
        List arrayList = new ArrayList();
        String str = null;
        if (list.size() > 1) {
            iIntValue = ((Integer) da.m1896(list, 1, Integer.class)).intValue();
            if (list.size() > 2) {
                str = (String) da.m1896(list, 2, String.class);
                if (list.size() > 3) {
                    arrayList = (List) da.m1896(list, 3, List.class);
                }
            }
        } else {
            iIntValue = -1;
        }
        return (WebView) ke.m2931(activity, WebView.class, iIntValue, arrayList, str);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <E extends View> E m1920(List<Object> list) {
        return (E) ke.m2932((View) da.m1896(list, 0, View.class), (Class) da.m1896(list, 1, Class.class), ((Boolean) da.m1896(list, 2, Boolean.class)).booleanValue());
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static View m1921(List<Object> list) {
        return ke.m2924((Activity) da.m1896(list, 0, Activity.class));
    }
}
