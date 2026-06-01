package com.bytedance.sdk.component.lEW;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.ea;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class MY implements Comparable, Runnable {
    private long EO;
    private lEW IlO;
    private IlO MY;
    private Thread tV = null;

    public MY(lEW lew, IlO ilO) {
        this.EO = 0L;
        this.IlO = lew;
        this.MY = ilO;
        this.EO = SystemClock.uptimeMillis();
    }

    private void IlO(String str, String str2, long j) {
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof MY) {
            return this.IlO.compareTo(((MY) obj).IlO());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        lEW lew;
        return (obj instanceof MY) && (lew = this.IlO) != null && lew.equals(((MY) obj).IlO());
    }

    public int hashCode() {
        return this.IlO.hashCode();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.tV = Thread.currentThread();
        lEW lew = this.IlO;
        if (lew != null) {
            lew.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.MY != null) {
            tV.IlO();
        }
        if (ea.IlO()) {
            IlO ilO = this.MY;
            if (ilO != null) {
                ilO.IlO();
            }
            lEW lew2 = this.IlO;
            if (lew2 != null) {
                lew2.getName();
            }
            String strIlO = this.MY.IlO();
            strIlO.getClass();
            byte b8 = -1;
            switch (strIlO.hashCode()) {
                case 3107:
                    if (strIlO.equals("ad")) {
                        b8 = 0;
                    }
                    break;
                case 3366:
                    if (strIlO.equals("io")) {
                        b8 = 1;
                    }
                    break;
                case 107332:
                    if (strIlO.equals("log")) {
                        b8 = 2;
                    }
                    break;
                case 3237136:
                    if (strIlO.equals(C2300e4.a.f8295f)) {
                        b8 = 3;
                    }
                    break;
                case 212371911:
                    if (strIlO.equals("computation")) {
                        b8 = 4;
                    }
                    break;
            }
            switch (b8) {
                case 0:
                case 3:
                    if (jUptimeMillis2 > 2000) {
                        IlO ilO2 = this.MY;
                        String strIlO2 = ilO2 != null ? ilO2.IlO() : "null";
                        lEW lew3 = this.IlO;
                        IlO(strIlO2, lew3 != null ? lew3.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 1:
                    if (jUptimeMillis2 > 5000) {
                        IlO ilO3 = this.MY;
                        String strIlO3 = ilO3 != null ? ilO3.IlO() : "null";
                        lEW lew4 = this.IlO;
                        IlO(strIlO3, lew4 != null ? lew4.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 2:
                    if (jUptimeMillis2 > 3000) {
                        IlO ilO4 = this.MY;
                        String strIlO4 = ilO4 != null ? ilO4.IlO() : "null";
                        lEW lew5 = this.IlO;
                        IlO(strIlO4, lew5 != null ? lew5.getName() : "null", jUptimeMillis2);
                    }
                    break;
                case 4:
                    if (jUptimeMillis2 > 1000) {
                        IlO ilO5 = this.MY;
                        String strIlO5 = ilO5 != null ? ilO5.IlO() : "null";
                        lEW lew6 = this.IlO;
                        IlO(strIlO5, lew6 != null ? lew6.getName() : "null", jUptimeMillis2);
                    }
                    break;
            }
        }
    }

    public lEW IlO() {
        return this.IlO;
    }
}
