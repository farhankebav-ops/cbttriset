package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.np, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2093np implements InterfaceC04613v {
    public static final List<C2094nq> A01 = new ArrayList(50);
    public final Handler A00;

    public C2093np(Handler handler) {
        this.A00 = handler;
    }

    public static C2094nq A00() {
        C2094nq c2094nq;
        synchronized (A01) {
            c2094nq = A01.isEmpty() ? new C2094nq() : A01.remove(A01.size() - 1);
        }
        return c2094nq;
    }

    public static void A01(C2094nq c2094nq) {
        synchronized (A01) {
            if (A01.size() < 50) {
                A01.add(c2094nq);
            }
        }
    }

    public final boolean A03(Runnable runnable) {
        return this.A00.post(runnable);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final Looper A8J() {
        return this.A00.getLooper();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final boolean A9f(int i2) {
        return this.A00.hasMessages(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final C2094nq AC7(int i2) {
        return A00().A01(this.A00.obtainMessage(i2), this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final C2094nq AC8(int i2, int i8, int i9) {
        return A00().A01(this.A00.obtainMessage(i2, i8, i9), this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final C2094nq AC9(int i2, int i8, int i9, Object obj) {
        return A00().A01(this.A00.obtainMessage(i2, i8, i9, obj), this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final C2094nq ACA(int i2, Object obj) {
        return A00().A01(this.A00.obtainMessage(i2, obj), this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final void AHj(int i2) {
        this.A00.removeMessages(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final boolean AIQ(int i2) {
        return this.A00.sendEmptyMessage(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final boolean AIR(int i2, long j) {
        return this.A00.sendEmptyMessageAtTime(i2, j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04613v
    public final boolean AIT(InterfaceC04603u interfaceC04603u) {
        return ((C2094nq) interfaceC04603u).A03(this.A00);
    }
}
