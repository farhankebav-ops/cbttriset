package com.bytedance.sdk.component.IlO;

import a1.a;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    public final String Bc;
    public final String Cc;
    public final String EO;
    public final int IlO;
    public final String MY;
    public final String lEW;
    public final String tV;
    public final String vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        private String Bc;
        private String Cc;
        private String EO;
        private String IlO;
        private String MY;
        private String tV;
        private String vCE;

        private IlO() {
        }

        public IlO Bc(String str) {
            this.Bc = str;
            return this;
        }

        public IlO Cc(String str) {
            this.Cc = str;
            return this;
        }

        public IlO EO(String str) {
            this.EO = str;
            return this;
        }

        public IlO IlO(String str) {
            this.IlO = str;
            return this;
        }

        public IlO MY(String str) {
            this.MY = str;
            return this;
        }

        public IlO tV(String str) {
            this.tV = str;
            return this;
        }

        public IlO vCE(String str) {
            this.vCE = str;
            return this;
        }

        public zPa IlO() {
            return new zPa(this);
        }
    }

    public static IlO IlO() {
        return new IlO();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("methodName: ");
        sb.append(this.tV);
        sb.append(", params: ");
        sb.append(this.Cc);
        sb.append(", callbackId: ");
        sb.append(this.vCE);
        sb.append(", type: ");
        sb.append(this.EO);
        sb.append(", version: ");
        return a.r(sb, this.MY, ", ");
    }

    private zPa(String str, int i2) {
        this.MY = null;
        this.EO = null;
        this.tV = null;
        this.Cc = null;
        this.vCE = str;
        this.Bc = null;
        this.IlO = i2;
        this.lEW = null;
    }

    public static zPa IlO(String str, int i2) {
        return new zPa(str, i2);
    }

    public static boolean IlO(zPa zpa) {
        return zpa == null || zpa.IlO != 1 || TextUtils.isEmpty(zpa.tV) || TextUtils.isEmpty(zpa.Cc);
    }

    private zPa(IlO ilO) {
        this.MY = ilO.IlO;
        this.EO = ilO.MY;
        this.tV = ilO.EO;
        this.Cc = ilO.tV;
        this.vCE = ilO.Cc;
        this.Bc = ilO.vCE;
        this.IlO = 1;
        this.lEW = ilO.Bc;
    }
}
