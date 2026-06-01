package com.bytedance.sdk.component.lEW.EO.IlO;

import android.text.TextUtils;
import com.bytedance.sdk.component.lEW.EO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private long Cc;
    private long EO;
    private String IlO;
    private int MY = 0;
    private long tV;
    private long vCE;

    public long Cc() {
        return this.Cc;
    }

    public long EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public long tV() {
        return this.tV;
    }

    public String toString() {
        return this.IlO + " times=" + this.MY + ",waitMaxTime=" + this.Cc + ",runMaxTime=" + this.vCE + ",runTotalTime=" + this.tV + ",waitTotalTime=" + this.EO;
    }

    public long vCE() {
        return this.vCE;
    }

    public void IlO(MY my) {
        synchronized (this) {
            try {
                if (TextUtils.isEmpty(this.IlO)) {
                    this.IlO = my.MY();
                }
                this.EO += my.vCE();
                this.tV += my.Bc();
                this.Cc = Math.max(this.Cc, my.vCE());
                this.vCE = Math.max(this.vCE, my.Bc());
                this.MY++;
            } catch (Throwable th) {
                throw th;
            }
        }
        my.vCE();
        my.Bc();
        toString();
    }
}
