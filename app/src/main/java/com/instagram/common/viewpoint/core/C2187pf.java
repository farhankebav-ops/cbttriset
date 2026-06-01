package com.instagram.common.viewpoint.core;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2187pf {
    public final InterfaceC2192pk A00;
    public final String A01;
    public final Collection<C2201pu> A02;
    public final Collection<C2201pu> A03;
    public final List<Rect> A04;

    public C2187pf(String str, InterfaceC2192pk interfaceC2192pk, List<Rect> rects, Collection<C2201pu> collection, Collection<C2201pu> collection2) {
        this.A01 = str;
        this.A00 = interfaceC2192pk;
        this.A04 = new ArrayList(rects);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
