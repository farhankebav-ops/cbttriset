package com.bytedance.sdk.openadsdk.core.model;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF {
    private long IlO = WorkRequest.MIN_BACKOFF_MILLIS;
    private long MY = WorkRequest.MIN_BACKOFF_MILLIS;
    private long EO = 10;
    private long tV = 20;
    private String Cc = "";

    public String Cc() {
        return this.Cc;
    }

    public long EO() {
        return this.EO;
    }

    public long IlO() {
        return this.IlO;
    }

    public long MY() {
        return this.MY;
    }

    public long tV() {
        return this.tV;
    }

    public void EO(long j) {
        if (j <= 0) {
            this.EO = 10L;
        } else {
            this.EO = j;
        }
    }

    public void IlO(long j) {
        if (j <= 0) {
            this.IlO = 10L;
        } else {
            this.IlO = j;
        }
    }

    public void MY(long j) {
        if (j < 0) {
            this.MY = 20L;
        } else {
            this.MY = j;
        }
    }

    public void tV(long j) {
        if (j < 0) {
            this.tV = 20L;
        } else {
            this.tV = j;
        }
    }

    public void IlO(String str) {
        this.Cc = str;
    }
}
