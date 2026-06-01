package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface G7 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<C5> f6822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Exception f6825d;

        public a(ArrayList<C5> arrayList) {
            this.f6823b = false;
            this.f6824c = -1;
            this.f6822a = arrayList;
        }

        public a a(Exception exc) {
            return new a(this.f6822a, this.f6824c, this.f6823b, exc);
        }

        public ArrayList<C5> b() {
            return this.f6822a;
        }

        public boolean c() {
            return this.f6823b;
        }

        public String toString() {
            return "EventSendResult{success=" + this.f6823b + ", responseCode=" + this.f6824c + ", exception=" + this.f6825d + '}';
        }

        public a a(boolean z2) {
            return new a(this.f6822a, this.f6824c, z2, this.f6825d);
        }

        public a a(int i2) {
            return new a(this.f6822a, i2, this.f6823b, this.f6825d);
        }

        public String a() {
            if (this.f6823b) {
                return "";
            }
            return "rc=" + this.f6824c + ", ex=" + this.f6825d;
        }

        public a(ArrayList<C5> arrayList, int i2, boolean z2, Exception exc) {
            this.f6822a = arrayList;
            this.f6823b = z2;
            this.f6825d = exc;
            this.f6824c = i2;
        }
    }

    void a(a aVar);
}
