package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1169Vy {
    public static String[] A01 = {"0TBfSTrFZZIPTbjcv3YvZ5KQe5wh6M4Z", "Y", "skEIHJjGP8F0E9LHs3c03M6jOmkdnZrb", "lNiM6G1VkMzjPhI0VWbHd", "xoZoqEy9j11lJxTnOEXOmkmQN9dBXrj3", "0lNV7cA9G3CxYQK", "ZSiJ5Be21P36sCEypxWEkyax05PjjigP", "3dFveWP5h629GmfNhsyVO5v38YfKmNKK"};
    public static final ThreadLocal<C1169Vy> A02 = new ThreadLocal<>();
    public final C1152Vh A00 = new C1152Vh();

    public static C1152Vh A00() {
        return A02().A00;
    }

    public static C1152Vh A01(C1168Vx c1168Vx) {
        C1152Vh currentStackTraces = new C1152Vh(A00());
        currentStackTraces.add(c1168Vx);
        return currentStackTraces;
    }

    public static C1169Vy A02() {
        C1169Vy c1169Vy = A02.get();
        if (c1169Vy == null) {
            C1169Vy c1169Vy2 = new C1169Vy();
            A02.set(c1169Vy2);
            return c1169Vy2;
        }
        return c1169Vy;
    }

    public static void A03(AbstractRunnableC1164Vt abstractRunnableC1164Vt) {
        C1152Vh c1152VhA06 = abstractRunnableC1164Vt.A06();
        if (c1152VhA06 != null) {
            C1152Vh createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(c1152VhA06);
        }
    }

    public static void A04(AbstractRunnableC1164Vt abstractRunnableC1164Vt) {
        C1152Vh c1152VhA06 = abstractRunnableC1164Vt.A06();
        if (c1152VhA06 != null) {
            C1152Vh c1152Vh = A02().A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[0] = "6tfOksRsBjIBNQljvPHCCYkD1Hr87lb7";
            c1152Vh.removeAll(c1152VhA06);
        }
    }
}
