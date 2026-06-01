package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0866Kb {
    public final int A00;
    public final String A01;
    public final List<C0865Ka> A02;
    public final byte[] A03;

    public C0866Kb(int i2, String str, List<C0865Ka> list, byte[] bArr) {
        List<C0865Ka> listUnmodifiableList;
        this.A00 = i2;
        this.A01 = str;
        if (list == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list);
        }
        this.A02 = listUnmodifiableList;
        this.A03 = bArr;
    }
}
