package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ef, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum EnumC2311ef {
    LoadSuccess(0),
    ShowSuccess(1),
    ShowFailed(2),
    Destroyed(3),
    LoadRequest(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8465a;

    EnumC2311ef(int i2) {
        this.f8465a = i2;
    }

    public final int b() {
        return this.f8465a;
    }
}
