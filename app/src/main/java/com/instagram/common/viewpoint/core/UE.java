package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UE {
    public final View A00;
    public final C1451cu A01;
    public final US A02;
    public final String A03;
    public final HashMap<String, String> A04 = new HashMap<>();
    public final boolean A05;
    public final boolean A06;

    public UE(C1451cu c1451cu, View view, String str, boolean z2, boolean z7) {
        this.A03 = str;
        this.A01 = c1451cu;
        this.A02 = c1451cu.A0A();
        this.A00 = view;
        this.A05 = z7;
        this.A06 = z2;
    }

    public final View A00() {
        return this.A00;
    }

    public final C1451cu A01() {
        return this.A01;
    }

    public final US A02() {
        return this.A02;
    }

    public final String A03() {
        return this.A03;
    }

    public final Map<String, String> A04() {
        return Collections.unmodifiableMap(this.A04);
    }

    public final boolean A05() {
        return this.A05;
    }

    public final boolean A06() {
        return this.A06;
    }
}
