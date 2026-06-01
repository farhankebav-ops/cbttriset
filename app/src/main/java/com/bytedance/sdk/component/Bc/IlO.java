package com.bytedance.sdk.component.Bc;

import a1.a;
import android.os.Bundle;
import com.bytedance.sdk.component.Bc.EO.EO;
import com.bytedance.sdk.component.Bc.MY.tV;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.IlO.IlO.Cc;
import com.bytedance.sdk.component.MY.IlO.lEW;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static Cc IlO;
    private EV MY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Bc.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C0041IlO {
        private Set<String> Cc;
        private Bundle vCE;
        final List<lEW> tV = new ArrayList();
        int IlO = 10000;
        int MY = 10000;
        int EO = 10000;

        public C0041IlO EO(long j, TimeUnit timeUnit) {
            this.EO = IlO("timeout", j, timeUnit);
            return this;
        }

        public C0041IlO IlO(boolean z2) {
            return this;
        }

        public C0041IlO MY(long j, TimeUnit timeUnit) {
            this.MY = IlO("timeout", j, timeUnit);
            return this;
        }

        public C0041IlO IlO(long j, TimeUnit timeUnit) {
            this.IlO = IlO("timeout", j, timeUnit);
            return this;
        }

        public C0041IlO IlO(lEW lew) {
            this.tV.add(lew);
            return this;
        }

        private static int IlO(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(a.C(str, " < 0"));
            }
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(a.C(str, " too large."));
                }
                if (millis != 0 || j <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(a.C(str, " too small."));
            }
            throw new NullPointerException("unit == null");
        }

        public IlO IlO() {
            return new IlO(this);
        }
    }

    public static boolean Cc() {
        Cc cc = IlO;
        if (cc == null) {
            return false;
        }
        return cc.IlO();
    }

    public static void IlO() {
        EO.IlO(EO.IlO.DEBUG);
    }

    public com.bytedance.sdk.component.Bc.MY.MY EO() {
        return new com.bytedance.sdk.component.Bc.MY.MY(this.MY);
    }

    public tV MY() {
        return new tV(this.MY);
    }

    public com.bytedance.sdk.component.Bc.MY.IlO tV() {
        return new com.bytedance.sdk.component.Bc.MY.IlO(this.MY);
    }

    public EV vCE() {
        return this.MY;
    }

    private IlO(C0041IlO c0041IlO) {
        EV.IlO ilO = new EV.IlO();
        long j = c0041IlO.IlO;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        EV.IlO ilOMY = ilO.IlO(j, timeUnit).EO(c0041IlO.EO, timeUnit).MY(c0041IlO.MY, timeUnit);
        List<lEW> list = c0041IlO.tV;
        if (list != null && list.size() > 0) {
            Iterator<lEW> it = c0041IlO.tV.iterator();
            while (it.hasNext()) {
                ilOMY.IlO(it.next());
            }
        }
        if (c0041IlO.vCE != null) {
            Bundle unused = c0041IlO.vCE;
        }
        Set unused2 = c0041IlO.Cc;
        this.MY = ilOMY.IlO();
    }

    public static void IlO(Cc cc) {
        IlO = cc;
    }
}
