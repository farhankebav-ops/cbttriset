package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC04162a {
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final Object A04;

    public AbstractC04162a(AbstractC04162a abstractC04162a) {
        this.A04 = abstractC04162a.A04;
        this.A00 = abstractC04162a.A00;
        this.A01 = abstractC04162a.A01;
        this.A03 = abstractC04162a.A03;
        this.A02 = abstractC04162a.A02;
    }

    public AbstractC04162a(Object obj) {
        this(obj, -1L);
    }

    public AbstractC04162a(Object obj, int i2, int i8, long j) {
        this(obj, i2, i8, j, -1);
    }

    public AbstractC04162a(Object obj, int i2, int i8, long j, int i9) {
        this.A04 = obj;
        this.A00 = i2;
        this.A01 = i8;
        this.A03 = j;
        this.A02 = i9;
    }

    public AbstractC04162a(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public final boolean A00() {
        return this.A00 != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC04162a)) {
            return false;
        }
        AbstractC04162a abstractC04162a = (AbstractC04162a) obj;
        return this.A04.equals(abstractC04162a.A04) && this.A00 == abstractC04162a.A00 && this.A01 == abstractC04162a.A01 && this.A03 == abstractC04162a.A03 && this.A02 == abstractC04162a.A02;
    }

    public final int hashCode() {
        int result = this.A04.hashCode();
        int result2 = ((((17 * 31) + result) * 31) + this.A00) * 31;
        int result3 = this.A01;
        int result4 = (((result2 + result3) * 31) + ((int) this.A03)) * 31;
        int result5 = this.A02;
        return result4 + result5;
    }
}
