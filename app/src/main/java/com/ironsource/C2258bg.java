package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.bg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2258bg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NetworkSettings f8085b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f8084a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f8086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8087d = true;

    public void a(NetworkSettings networkSettings) {
        this.f8085b = networkSettings;
    }

    public JSONObject b() {
        return this.f8086c;
    }

    public NetworkSettings c() {
        return this.f8085b;
    }

    public ArrayList<String> d() {
        return this.f8084a;
    }

    public boolean e() {
        return this.f8087d;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8084a.add(str);
    }

    public void a(JSONObject jSONObject) {
        this.f8086c = jSONObject;
    }

    public void a(boolean z2) {
        this.f8087d = z2;
    }

    public static C2258bg a() {
        return new C2258bg();
    }
}
