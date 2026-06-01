package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3W, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3W {
    public boolean A00;
    public final C3T A01;

    public C3W() {
        this(C3T.A00);
    }

    public C3W(C3T c3t) {
        this.A01 = c3t;
    }

    public final synchronized void A00() throws InterruptedException {
        while (!this.A00) {
            wait();
        }
    }

    public final synchronized void A01() {
        boolean z2 = false;
        while (true) {
            boolean wasInterrupted = this.A00;
            if (wasInterrupted) {
                break;
            }
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean A02() {
        boolean z2;
        z2 = this.A00;
        this.A00 = false;
        return z2;
    }

    public final synchronized boolean A03() {
        return this.A00;
    }

    public final synchronized boolean A04() {
        if (this.A00) {
            return false;
        }
        this.A00 = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean A05(long j) throws InterruptedException {
        if (j <= 0) {
            return this.A00;
        }
        long nowMs = this.A01.A6B();
        long j3 = nowMs + j;
        if (j3 < nowMs) {
            A00();
        } else {
            while (!this.A00 && nowMs < j3) {
                long endMs = j3 - nowMs;
                wait(endMs);
                nowMs = this.A01.A6B();
            }
        }
        return this.A00;
    }
}
