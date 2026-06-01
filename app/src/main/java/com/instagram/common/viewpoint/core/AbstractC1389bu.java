package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1389bu {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1388bt>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1388bt>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1388bt A01(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, int i2, InterfaceC1386br interfaceC1386br) {
        C1388bt c1388bt = new C1388bt(c1477dL, abstractC1752hy, c1477dL.A02().A0A(), i2);
        c1388bt.A0b(interfaceC1386br);
        c1388bt.A0X();
        A01.put(abstractC1752hy.A17(), new WeakReference<>(c1388bt));
        return c1388bt;
    }

    public static C1388bt A02(String str) {
        WeakReference<C1388bt> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1752hy abstractC1752hy, C1388bt c1388bt) {
        A01.put(abstractC1752hy.A17(), new WeakReference<>(c1388bt));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
