package com.ironsource;

import com.ironsource.InterfaceC2565t4;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C5 {
    static final String e = "euid";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f6401f = "esat";
    static final String g = "esfr";
    static final int h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f6405d;

    public C5(D5 d52, JSONObject jSONObject) {
        this(d52.b(), jSONObject);
    }

    public String a() {
        return this.f6405d.toString();
    }

    public JSONObject b() {
        return this.f6405d;
    }

    public int c() {
        return this.f6402a;
    }

    public long d() {
        return this.f6403b;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5 c52 = (C5) obj;
        return this.f6402a == c52.f6402a && this.f6403b == c52.f6403b && this.f6404c == c52.f6404c && C2588ua.a(this.f6405d, c52.f6405d);
    }

    public int hashCode() {
        int i2 = this.f6402a * 31;
        long j = this.f6403b;
        return ((this.f6405d.toString().hashCode() + ((i2 + ((int) (j ^ (j >>> 32)))) * 31)) * 31) + this.f6404c;
    }

    public String toString() {
        return ("{\"eventId\":" + c() + ",\"timestamp\":" + d() + "," + a().substring(1) + "}").replace(",", "\n");
    }

    public C5(int i2, JSONObject jSONObject) {
        this(i2, new InterfaceC2565t4.a().a(), jSONObject);
    }

    public void a(int i2) {
        this.f6402a = i2;
    }

    public C5(int i2, long j, String str) throws JSONException {
        this(i2, j, new JSONObject(str));
    }

    public void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            this.f6405d.put(str, obj);
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    public C5(D5 d52, long j, JSONObject jSONObject) {
        this(d52.b(), j, jSONObject);
    }

    public C5(int i2, long j, JSONObject jSONObject) {
        this.f6404c = 1;
        this.f6402a = i2;
        this.f6403b = j;
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        this.f6405d = jSONObject;
        if (!jSONObject.has(e)) {
            a(e, UUID.randomUUID().toString());
        }
        if (!jSONObject.has(f6401f)) {
            a(f6401f, Integer.valueOf(this.f6404c));
        } else {
            this.f6404c = jSONObject.optInt(f6401f, 1);
        }
    }

    public void a(String str) {
        a(g, str);
        int i2 = this.f6404c + 1;
        this.f6404c = i2;
        a(f6401f, Integer.valueOf(i2));
    }
}
