package com.vungle.ads.fpd;

import k6.d;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum LengthOfResidence {
    LESS_THAN_ONE_YEAR(0, new d(Integer.MIN_VALUE, 0, 1)),
    ONE_TO_FIVE_YEARS(1, new d(1, 5, 1)),
    SIX_TO_TEN_YEARS(2, new d(6, 10, 1)),
    ELEVEN_TO_TWENTY_YEARS(3, new d(11, 20, 1)),
    TWENTY_ONE_TO_THIRTY_YEARS(4, new d(21, 30, 1)),
    THIRTY_ONE_TO_FORTY_YEARS(5, new d(31, 40, 1)),
    FORTY_ONE_TO_FIFTY_YEARS(6, new d(41, 50, 1)),
    FIFTY_ONE_TO_SIXTY_YEARS(7, new d(51, 60, 1)),
    SIXTY_ONE_TO_SEVENTY_YEARS(8, new d(61, 70, 1)),
    OVER_SEVENTY_ONE_YEARS(9, new d(71, Integer.MAX_VALUE, 1));

    public static final Companion Companion = new Companion(null);
    private final int id;
    private final d range;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final LengthOfResidence fromYears$vungle_ads_release(int i2) {
            LengthOfResidence lengthOfResidence;
            LengthOfResidence[] lengthOfResidenceArrValues = LengthOfResidence.values();
            int length = lengthOfResidenceArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    lengthOfResidence = null;
                    break;
                }
                lengthOfResidence = lengthOfResidenceArrValues[i8];
                d range = lengthOfResidence.getRange();
                int i9 = range.f12709a;
                if (i2 <= range.f12710b && i9 <= i2) {
                    break;
                }
                i8++;
            }
            return lengthOfResidence == null ? LengthOfResidence.LESS_THAN_ONE_YEAR : lengthOfResidence;
        }

        private Companion() {
        }
    }

    LengthOfResidence(int i2, d dVar) {
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
