package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceQaProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IronSourceQaProperties f10210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f10211b = new HashMap();

    private IronSourceQaProperties() {
    }

    public static IronSourceQaProperties getInstance() {
        if (f10210a == null) {
            f10210a = new IronSourceQaProperties();
        }
        return f10210a;
    }

    public static boolean isInitialized() {
        return f10210a != null;
    }

    public Map<String, String> getParameters() {
        return f10211b;
    }

    public void setQaParameter(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f10211b.put(str, str2);
    }
}
