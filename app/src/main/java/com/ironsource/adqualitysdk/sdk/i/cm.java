package com.ironsource.adqualitysdk.sdk.i;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cm {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private dq f1365;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private e f1366;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a extends e {
        public a(Class cls) {
            super(cls);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.cm.e
        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final boolean mo1640(hs hsVar) {
            return m1646().isInstance(hsVar.mo2359());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private cm f1367 = new cm();

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final b m1641(Class cls) {
            this.f1367.f1366 = new c(cls);
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final b m1642(dq dqVar) {
            this.f1367.f1365 = dqVar;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final b m1643(Class cls) {
            this.f1367.f1366 = new d(cls);
            return this;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final b m1645(Class cls) {
            this.f1367.f1366 = new a(cls);
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final cm m1644() {
            return this.f1367;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c extends e {
        public c(Class cls) {
            super(cls);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.cm.e
        /* JADX INFO: renamed from: ｋ */
        public final boolean mo1640(hs hsVar) {
            return m1646().isAssignableFrom(hsVar.mo2360().getType());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends e {
        public d(Class cls) {
            super(cls);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.cm.e
        /* JADX INFO: renamed from: ｋ */
        public final boolean mo1640(hs hsVar) {
            return m1646().equals(hsVar.mo2360().getType());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class e {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private Class f1368;

        public e(Class cls) {
            this.f1368 = cls;
        }

        /* JADX INFO: renamed from: ｋ */
        public abstract boolean mo1640(hs hsVar);

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final Class m1646() {
            return this.f1368;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final boolean m1639(hs hsVar, ds dsVar, cp cpVar, List<Object> list) {
        e eVar = this.f1366;
        if (eVar != null && !eVar.mo1640(hsVar)) {
            return false;
        }
        if (this.f1365 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, hsVar);
        return this.f1365.m2081(dsVar, cpVar, arrayList).m2150();
    }
}
