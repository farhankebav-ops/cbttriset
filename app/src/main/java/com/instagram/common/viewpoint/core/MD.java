package com.instagram.common.viewpoint.core;

import android.os.ConditionVariable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MD extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ C1801ir A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MD(C1801ir c1801ir, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = c1801ir;
        this.A00 = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            synchronized (this.A01) {
                try {
                    this.A00.open();
                    this.A01.A05();
                } finally {
                    th = th;
                    while (true) {
                        try {
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC1156Vl.A00(th2, this);
        }
    }
}
