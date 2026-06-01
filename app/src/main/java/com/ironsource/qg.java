package com.ironsource;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class qg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9721b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9722c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f9720a = new a();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends HashMap<String, Boolean> {
        public a() {
            put(C2393j8.k, Boolean.valueOf(qg.this.f9721b == 0));
            put(C2393j8.l, Boolean.valueOf(qg.this.f9722c == 0));
            Boolean bool = Boolean.FALSE;
            put(C2393j8.m, bool);
            put(C2393j8.f8781n, bool);
        }
    }

    public void a(String str, int i2, boolean z2) {
        boolean z7 = false;
        if (this.f9720a.containsKey(str)) {
            this.f9720a.put(str, Boolean.valueOf(i2 == 0));
        }
        this.f9720a.put(C2393j8.m, Boolean.valueOf(z2));
        if ((this.f9720a.get(C2393j8.l).booleanValue() || this.f9720a.get(C2393j8.k).booleanValue()) && this.f9720a.get(C2393j8.m).booleanValue()) {
            z7 = true;
        }
        this.f9720a.put(C2393j8.f8781n, Boolean.valueOf(z7));
    }

    public JSONObject a() {
        return new JSONObject(this.f9720a);
    }
}
