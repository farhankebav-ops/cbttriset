package com.vungle.ads.fpd;

import k6.d;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum AgeRange {
    AGE_18_20(1, new d(18, 20, 1)),
    AGE_21_30(2, new d(21, 30, 1)),
    AGE_31_40(3, new d(31, 40, 1)),
    AGE_41_50(4, new d(41, 50, 1)),
    AGE_51_60(5, new d(51, 60, 1)),
    AGE_61_70(6, new d(61, 70, 1)),
    AGE_71_75(7, new d(71, 75, 1)),
    OTHERS(0, new d(Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

    public static final Companion Companion = new Companion(null);
    private final int id;
    private final d range;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AgeRange fromAge$vungle_ads_release(int i2) {
            AgeRange ageRange;
            AgeRange[] ageRangeArrValues = AgeRange.values();
            int length = ageRangeArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    ageRange = null;
                    break;
                }
                ageRange = ageRangeArrValues[i8];
                d range = ageRange.getRange();
                int i9 = range.f12709a;
                if (i2 <= range.f12710b && i9 <= i2) {
                    break;
                }
                i8++;
            }
            return ageRange == null ? AgeRange.OTHERS : ageRange;
        }

        private Companion() {
        }
    }

    AgeRange(int i2, d dVar) {
        this.id = i2;
        this.range = dVar;
    }

    public final int getId() {
        return this.id;
    }

    public final d getRange() {
        return this.range;
    }
}
