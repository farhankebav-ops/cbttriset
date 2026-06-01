package com.ironsource;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum W7 {
    UnknownProvider(0),
    DeliverySonic(1),
    MarketPlaceISX(3);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7771b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7775a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final W7 a(Integer num) {
            W7 w7;
            W7[] w7ArrValues = W7.values();
            int length = w7ArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    w7 = null;
                    break;
                }
                w7 = w7ArrValues[i2];
                int iB = w7.b();
                if (num != null && iB == num.intValue()) {
                    break;
                }
                i2++;
            }
            return w7 == null ? W7.UnknownProvider : w7;
        }

        private a() {
        }

        public final W7 a(String dynamicDemandSourceId) {
            kotlin.jvm.internal.k.e(dynamicDemandSourceId, "dynamicDemandSourceId");
            List listK0 = n6.m.K0(dynamicDemandSourceId, new String[]{"_"}, 6);
            return listK0.size() < 2 ? W7.UnknownProvider : a(n6.t.o0((String) listK0.get(1)));
        }
    }

    W7(int i2) {
        this.f7775a = i2;
    }

    public final int b() {
        return this.f7775a;
    }
}
