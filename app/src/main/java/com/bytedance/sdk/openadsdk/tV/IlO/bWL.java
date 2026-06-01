package com.bytedance.sdk.openadsdk.tV.IlO;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL {
    public static bWL IlO = new bWL();
    private final Map<String, IlO> EO = new HashMap();
    private IlO MY;
    private volatile boolean tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private final int IlO;
        private final int MY;

        public IlO(int i2, int i8) {
            this.IlO = (i2 < 0 || i2 > 5) ? 3 : i2;
            this.MY = i8 < 10 ? 30 : i8;
        }

        public int IlO() {
            return this.IlO;
        }

        public int MY() {
            return this.MY;
        }
    }

    private int EO() {
        IlO ilO = this.MY;
        if (ilO != null) {
            return ilO.MY();
        }
        return 30;
    }

    private int MY() {
        IlO ilO = this.MY;
        if (ilO != null) {
            return ilO.IlO();
        }
        return 3;
    }

    public void IlO(IlO ilO) {
        this.MY = ilO;
    }

    public void IlO(String str, IlO ilO) {
        if (TextUtils.isEmpty(str) || ilO == null) {
            return;
        }
        this.EO.put(str, ilO);
    }

    public int MY(String str) {
        IlO ilO = this.EO.get(str);
        if (ilO == null) {
            return EO();
        }
        return ilO.MY();
    }

    public int IlO(String str) {
        if (!IlO()) {
            return 4;
        }
        IlO ilO = this.EO.get(str);
        if (ilO == null) {
            return MY();
        }
        return ilO.IlO();
    }

    public boolean IlO() {
        return this.tV;
    }

    public void IlO(boolean z2) {
        this.tV = z2;
    }
}
