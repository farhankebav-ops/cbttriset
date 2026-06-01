package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: renamed from: com.ironsource.b9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2251b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f8061a;

    public C2251b9(D0 d0) {
        this.f8061a = d0;
    }

    public void a(String str, String str2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str + "|" + str2);
        this.f8061a.a(A0.INIT_STARTED, map);
    }

    public void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f8061a.a(A0.INIT_ENDED, map);
    }

    public void a() {
        this.f8061a.a(A0.INIT_SUCCESS, null);
    }

    public void a(int i2, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", str);
        this.f8061a.a(A0.INIT_FAILED, map);
    }
}
