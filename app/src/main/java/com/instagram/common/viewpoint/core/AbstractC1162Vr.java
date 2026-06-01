package com.instagram.common.viewpoint.core;

import android.widget.LinearLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1162Vr extends LinearLayout {
    public static final AtomicBoolean A00 = new AtomicBoolean();
    public static final AtomicReference<InterfaceC1154Vj> A01 = new AtomicReference<>();

    public static void A00(boolean z2, InterfaceC1154Vj interfaceC1154Vj) {
        A00.set(z2);
        A01.set(interfaceC1154Vj);
    }
}
