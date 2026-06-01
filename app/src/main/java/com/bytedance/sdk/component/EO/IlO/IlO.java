package com.bytedance.sdk.component.EO.IlO;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    long Bc;
    long Cc;
    long EO;
    long IlO = SystemClock.elapsedRealtime();
    long MY;
    long lEW;
    long tV;
    long vCE;

    public long Bc() {
        return this.EO;
    }

    public void Cc() {
        this.vCE = SystemClock.elapsedRealtime();
    }

    public long DmF() {
        return this.Cc;
    }

    public void EO() {
        this.Cc = SystemClock.elapsedRealtime();
    }

    public void EV() {
        this.Bc = SystemClock.elapsedRealtime();
    }

    public void IlO() {
        this.EO = SystemClock.elapsedRealtime();
    }

    public void MY() {
        this.tV = SystemClock.elapsedRealtime();
    }

    public long NV() {
        return this.Bc;
    }

    public long bWL() {
        return this.MY;
    }

    public void ea() {
        this.MY = SystemClock.elapsedRealtime();
    }

    public void hp() {
        this.lEW = SystemClock.elapsedRealtime();
    }

    public long lEW() {
        return this.tV;
    }

    public long rp() {
        return this.lEW;
    }

    public long tV() {
        return this.IlO;
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.IlO + ", asyncCallExecTs=" + this.MY + ", requestStartExecTs=" + this.EO + ", requestConnectStartTs=" + this.tV + ", requestConnectFinishTs=" + this.Cc + ", reqCallServerStartTs=" + this.Bc + ", reqCallServerFinishTs=" + this.lEW + '}';
    }

    public long vCE() {
        return this.vCE;
    }
}
