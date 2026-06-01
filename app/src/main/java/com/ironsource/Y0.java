package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Y0 extends C2346ge {
    private static String h = "type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f7799i = "numOfAdUnits";
    private static String j = "firstCampaignCredits";
    private static String k = "totalNumberCredits";
    private static String l = "productType";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7802d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7803f;
    private boolean g;

    public Y0(String str) {
        super(str);
        if (a(h)) {
            k(d(h));
        }
        if (a(f7799i)) {
            h(d(f7799i));
            a(true);
        } else {
            a(false);
        }
        if (a(j)) {
            g(d(j));
        }
        if (a(k)) {
            j(d(k));
        }
        if (a(l)) {
            i(d(l));
        }
    }

    private void a(boolean z2) {
        this.g = z2;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f7802d;
    }

    public String d() {
        return this.f7801c;
    }

    public String e() {
        return this.f7803f;
    }

    public String f() {
        return this.f7800b;
    }

    public void g(String str) {
        this.e = str;
    }

    public void h(String str) {
        this.f7802d = str;
    }

    public void i(String str) {
        this.f7801c = str;
    }

    public void j(String str) {
        this.f7803f = str;
    }

    public void k(String str) {
        this.f7800b = str;
    }

    public boolean g() {
        return this.g;
    }
}
