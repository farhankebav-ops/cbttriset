package com.vungle.ads.fpd;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.l0;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class Demographic {
    public static final Companion Companion = new Companion(null);
    private Integer ageRange;
    private Integer lengthOfResidence;
    private Integer medianHomeValueUSD;
    private Integer monthlyHousingPaymentUSD;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return Demographic$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Demographic() {
    }

    public static final void write$Self(Demographic self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ageRange != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, l0.f11478a, self.ageRange);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.lengthOfResidence != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, l0.f11478a, self.lengthOfResidence);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.medianHomeValueUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, l0.f11478a, self.medianHomeValueUSD);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.monthlyHousingPaymentUSD == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, l0.f11478a, self.monthlyHousingPaymentUSD);
    }

    public final Demographic setAgeRange(int i2) {
        this.ageRange = Integer.valueOf(AgeRange.Companion.fromAge$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setLengthOfResidence(int i2) {
        this.lengthOfResidence = Integer.valueOf(LengthOfResidence.Companion.fromYears$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setMedianHomeValueUSD(int i2) {
        this.medianHomeValueUSD = Integer.valueOf(MedianHomeValueUSD.Companion.fromPrice$vungle_ads_release(i2).getId());
        return this;
    }

    public final Demographic setMonthlyHousingCosts(int i2) {
        this.monthlyHousingPaymentUSD = Integer.valueOf(MonthlyHousingCosts.Companion.fromCost$vungle_ads_release(i2).getId());
        return this;
    }

    public /* synthetic */ Demographic(int i2, Integer num, Integer num2, Integer num3, Integer num4, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.ageRange = null;
        } else {
            this.ageRange = num;
        }
        if ((i2 & 2) == 0) {
            this.lengthOfResidence = null;
        } else {
            this.lengthOfResidence = num2;
        }
        if ((i2 & 4) == 0) {
            this.medianHomeValueUSD = null;
        } else {
            this.medianHomeValueUSD = num3;
        }
        if ((i2 & 8) == 0) {
            this.monthlyHousingPaymentUSD = null;
        } else {
            this.monthlyHousingPaymentUSD = num4;
        }
    }

    private static /* synthetic */ void getAgeRange$annotations() {
    }

    private static /* synthetic */ void getLengthOfResidence$annotations() {
    }

    private static /* synthetic */ void getMedianHomeValueUSD$annotations() {
    }

    private static /* synthetic */ void getMonthlyHousingPaymentUSD$annotations() {
    }
}
