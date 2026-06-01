package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DM {
    public long IlO;
    private long MY;

    private DM(boolean z2) {
        if (z2) {
            Cc();
        }
    }

    public static DM EO() {
        return new DM(false);
    }

    public static DM MY() {
        return new DM(true);
    }

    public void Cc() {
        this.IlO = System.currentTimeMillis();
        this.MY = SystemClock.elapsedRealtime();
    }

    public long IlO() {
        return this.MY;
    }

    public long tV() {
        return SystemClock.elapsedRealtime() - this.MY;
    }

    public String toString() {
        return String.valueOf(this.IlO);
    }

    public boolean vCE() {
        return this.MY > 0;
    }

    public long IlO(DM dm) {
        return Math.abs(dm.MY - this.MY);
    }
}
