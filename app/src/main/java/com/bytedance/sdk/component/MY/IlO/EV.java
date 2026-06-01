package com.bytedance.sdk.component.MY.IlO;

import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EV implements Cloneable {
    public TimeUnit Bc;
    public TimeUnit Cc;
    public TimeUnit EO;
    public List<lEW> IlO;
    public long MY;
    public long tV;
    public long vCE;

    public EV(IlO ilO) {
        this.MY = ilO.MY;
        this.tV = ilO.tV;
        this.vCE = ilO.vCE;
        List<lEW> list = ilO.IlO;
        this.EO = ilO.EO;
        this.Cc = ilO.Cc;
        this.Bc = ilO.Bc;
        this.IlO = list;
    }

    public abstract MY IlO(rp rpVar);

    public abstract tV IlO();

    public IlO MY() {
        return new IlO(this);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        public TimeUnit Bc;
        public TimeUnit Cc;
        public TimeUnit EO;
        public final List<lEW> IlO;
        public long MY;
        public long tV;
        public long vCE;

        public IlO() {
            this.IlO = new ArrayList();
            this.MY = WorkRequest.MIN_BACKOFF_MILLIS;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.EO = timeUnit;
            this.tV = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Cc = timeUnit;
            this.vCE = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Bc = timeUnit;
        }

        public IlO EO(long j, TimeUnit timeUnit) {
            this.vCE = j;
            this.Bc = timeUnit;
            return this;
        }

        public IlO IlO(long j, TimeUnit timeUnit) {
            this.MY = j;
            this.EO = timeUnit;
            return this;
        }

        public IlO MY(long j, TimeUnit timeUnit) {
            this.tV = j;
            this.Cc = timeUnit;
            return this;
        }

        public IlO IlO(lEW lew) {
            this.IlO.add(lew);
            return this;
        }

        public EV IlO() {
            return com.bytedance.sdk.component.MY.IlO.IlO.IlO.IlO(this);
        }

        public IlO(String str) {
            this.IlO = new ArrayList();
            this.MY = WorkRequest.MIN_BACKOFF_MILLIS;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.EO = timeUnit;
            this.tV = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Cc = timeUnit;
            this.vCE = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Bc = timeUnit;
        }

        public IlO(EV ev) {
            this.IlO = new ArrayList();
            this.MY = WorkRequest.MIN_BACKOFF_MILLIS;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.EO = timeUnit;
            this.tV = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Cc = timeUnit;
            this.vCE = WorkRequest.MIN_BACKOFF_MILLIS;
            this.Bc = timeUnit;
            this.MY = ev.MY;
            this.EO = ev.EO;
            this.tV = ev.tV;
            this.Cc = ev.Cc;
            this.vCE = ev.vCE;
            this.Bc = ev.Bc;
        }
    }
}
