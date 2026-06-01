package com.vungle.ads.fpd;

import com.unity3d.services.UnityAdsConstants;
import k6.d;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum MonthlyHousingCosts {
    UNDER_500(0, new d(Integer.MIN_VALUE, 500, 1)),
    FROM_500_TO_1000(1, new d(501, 1000, 1)),
    FROM_1000_TO_1500(2, new d(1001, 1500, 1)),
    FROM_1500_TO_2000(3, new d(1501, 2000, 1)),
    FROM_2000_TO_2500(4, new d(2001, UnityAdsConstants.RequestPolicy.RETRY_MAX_INTERVAL, 1)),
    FROM_2500_TO_3000(5, new d(2501, 3000, 1)),
    FROM_3000_TO_3500(6, new d(3001, 3500, 1)),
    FROM_3500_TO_4000(7, new d(3501, 4000, 1)),
    FROM_4000_TO_4500(8, new d(4001, 4500, 1)),
    OVER_4500(9, new d(4501, Integer.MAX_VALUE, 1));

    public static final Companion Companion = new Companion(null);
    private final int id;
    private final d range;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final MonthlyHousingCosts fromCost$vungle_ads_release(int i2) {
            MonthlyHousingCosts monthlyHousingCosts;
            MonthlyHousingCosts[] monthlyHousingCostsArrValues = MonthlyHousingCosts.values();
            int length = monthlyHousingCostsArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    monthlyHousingCosts = null;
                    break;
                }
                monthlyHousingCosts = monthlyHousingCostsArrValues[i8];
                d range = monthlyHousingCosts.getRange();
                int i9 = range.f12709a;
                if (i2 <= range.f12710b && i9 <= i2) {
                    break;
                }
                i8++;
            }
            return monthlyHousingCosts == null ? MonthlyHousingCosts.UNDER_500 : monthlyHousingCosts;
        }

        private Companion() {
        }
    }

    MonthlyHousingCosts(int i2, d dVar) {
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
