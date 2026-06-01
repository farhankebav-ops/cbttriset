package com.bykv.vk.openvk.preload.a.b;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4811a;

    public f(String str) {
        this.f4811a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f4811a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f4811a;
        String str2 = ((f) obj).f4811a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f4811a);
    }

    public final int hashCode() {
        return this.f4811a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f4811a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f4811a).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f4811a);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f4811a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f4811a).longValue();
        }
    }

    public final String toString() {
        return this.f4811a;
    }
}
