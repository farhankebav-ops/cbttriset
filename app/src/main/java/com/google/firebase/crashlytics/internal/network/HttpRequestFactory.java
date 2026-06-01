package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpRequestFactory {
    public HttpGetRequest buildHttpGetRequest(String str) {
        return buildHttpGetRequest(str, Collections.EMPTY_MAP);
    }

    public HttpGetRequest buildHttpGetRequest(String str, Map<String, String> map) {
        return new HttpGetRequest(str, map);
    }
}
