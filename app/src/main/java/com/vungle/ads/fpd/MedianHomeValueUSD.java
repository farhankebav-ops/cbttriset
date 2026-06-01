package com.vungle.ads.fpd;

import k6.d;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum MedianHomeValueUSD {
    UNDER_100K(0, new d(Integer.MIN_VALUE, 100000, 1)),
    FROM_100K_TO_300K(1, new d(100001, 300000, 1)),
    FROM_300K_TO_500K(2, new d(300001, 500000, 1)),
    FROM_500K_TO_700K(3, new d(500001, 700000, 1)),
    FROM_700K_TO_900K(4, new d(700001, 900000, 1)),
    FROM_900K_TO_1M1(5, new d(900001, 1100000, 1)),
    FROM_1M1_TO_1M3(6, new d(1100001, 1300000, 1)),
    FROM_1M3_TO_1M5(7, new d(1300001, 1500000, 1)),
    FROM_1M5_TO_1M7(8, new d(1500001, 1700000, 1)),
    OVER_1M7(9, new d(1700001, Integer.MAX_VALUE, 1));

    public static final Companion Companion = new Companion(null);
    private final int id;
    private final d range;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final MedianHomeValueUSD fromPrice$vungle_ads_release(int i2) {
            MedianHomeValueUSD medianHomeValueUSD;
            MedianHomeValueUSD[] medianHomeValueUSDArrValues = MedianHomeValueUSD.values();
            int length = medianHomeValueUSDArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    medianHomeValueUSD = null;
                    break;
                }
                medianHomeValueUSD = medianHomeValueUSDArrValues[i8];
                d range = medianHomeValueUSD.getRange();
                int i9 = range.f12709a;
                if (i2 <= range.f12710b && i9 <= i2) {
                    break;
                }
                i8++;
            }
            return medianHomeValueUSD == null ? MedianHomeValueUSD.UNDER_100K : medianHomeValueUSD;
        }

        private Companion() {
        }
    }

    MedianHomeValueUSD(int i2, d dVar) {
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
