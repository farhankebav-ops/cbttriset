package com.ironsource;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f7871a;

    public Yf(D0 d0) {
        this.f7871a = d0;
    }

    public void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f7871a.a(A0.COLLECT_TOKENS_COMPLETED, map);
    }

    public void b(Map<String, Object> map, long j) {
        HashMap map2 = new HashMap();
        map2.put("duration", Long.valueOf(j));
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f7871a.a(A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT, map2);
    }

    public void a(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f7871a.a(A0.COLLECT_TOKENS_FAILED, map);
    }

    public void a() {
        this.f7871a.a(A0.COLLECT_TOKEN, new HashMap());
    }

    public void a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f7871a.a(A0.INSTANCE_COLLECT_TOKEN, map2);
    }

    public void a(Map<String, Object> map, long j) {
        HashMap map2 = new HashMap();
        map2.put("duration", Long.valueOf(j));
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f7871a.a(A0.INSTANCE_COLLECT_TOKEN_SUCCESS, map2);
    }

    public void a(Map<String, Object> map, long j, String str) {
        HashMap map2 = new HashMap();
        map2.put("duration", Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            map2.put("reason", str);
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f7871a.a(A0.INSTANCE_COLLECT_TOKEN_FAILED, map2);
    }
}
