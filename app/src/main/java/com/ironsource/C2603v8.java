package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

/* JADX INFO: renamed from: com.ironsource.v8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2603v8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f10438a = new HashMap<>();

    public HashMap<String, Object> a() {
        return this.f10438a;
    }

    public C2603v8 a(String str, Object obj) {
        if (obj != null) {
            this.f10438a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }
}
