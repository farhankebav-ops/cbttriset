package com.ironsource;

import com.ironsource.O8;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Re implements O8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7569b;

    public Re(String str, int i2) {
        this.f7568a = str;
        this.f7569b = i2;
    }

    @Override // com.ironsource.O8.b
    public int b() {
        return this.f7569b;
    }

    @Override // com.ironsource.O8.b
    public String c() {
        return this.f7568a;
    }
}
