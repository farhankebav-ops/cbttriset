package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C04222i extends IOException {
    public int A00;
    public boolean A01;

    @Deprecated
    public C04222i() {
    }

    @Deprecated
    public C04222i(String str) {
        super(str);
    }

    public C04222i(String str, Throwable th, boolean z2, int i2) {
        super(str, th);
        this.A01 = z2;
        this.A00 = i2;
    }

    public static C04222i A00(String str) {
        return new C04222i(str, null, false, 1);
    }

    public static C04222i A01(String str, Throwable th) {
        return new C04222i(str, th, true, 1);
    }

    public static C04222i A02(String str, Throwable th) {
        return new C04222i(str, th, true, 0);
    }
}
