package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7849b;

    public Y7(int i2, int i8) {
        this.f7848a = i2;
        this.f7849b = i8;
    }

    public final int a() {
        return this.f7848a;
    }

    public final int b() {
        return this.f7849b;
    }

    public final int c() {
        return this.f7849b;
    }

    public final int d() {
        return this.f7848a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y7)) {
            return false;
        }
        Y7 y7 = (Y7) obj;
        return this.f7848a == y7.f7848a && this.f7849b == y7.f7849b;
    }

    public int hashCode() {
        return (this.f7848a * 31) + this.f7849b;
    }

    public String toString() {
        return "ISContainerParams(width=" + this.f7848a + ", height=" + this.f7849b + ")";
    }

    public final Y7 a(int i2, int i8) {
        return new Y7(i2, i8);
    }

    public static /* synthetic */ Y7 a(Y7 y7, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = y7.f7848a;
        }
        if ((i9 & 2) != 0) {
            i8 = y7.f7849b;
        }
        return y7.a(i2, i8);
    }
}
