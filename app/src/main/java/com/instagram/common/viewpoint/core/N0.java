package com.instagram.common.viewpoint.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N0 implements Serializable {
    public static final long serialVersionUID = -2102939945352398575L;
    public long A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final List<String> A05;

    public N0(List<String> screenshots, long j, long j3, boolean z2, boolean z7, boolean z8) {
        this.A05 = screenshots;
        this.A00 = j;
        this.A01 = j3;
        this.A04 = z2;
        this.A02 = z7;
        this.A03 = z8;
    }

    public final long A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A01;
    }

    public final List<String> A02() {
        return Collections.unmodifiableList(this.A05);
    }

    public final boolean A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }

    public final boolean A05() {
        return this.A04;
    }
}
