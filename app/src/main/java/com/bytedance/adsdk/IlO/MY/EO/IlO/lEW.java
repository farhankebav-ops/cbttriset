package com.bytedance.adsdk.IlO.MY.EO.IlO;

import a1.a;
import com.bytedance.adsdk.IlO.MY.MY.IlO.zPa;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends vCE {
    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        if (!com.bytedance.adsdk.IlO.MY.Cc.IlO.tV(IlO(i2, str))) {
            return ilO.IlO(str, i2, deque);
        }
        int i8 = i2 + 1;
        String str2 = new String(new char[]{IlO(i2, str), IlO(i8, str)});
        if (com.bytedance.adsdk.IlO.MY.tV.EO.IlO(str2) != null) {
            deque.push(new zPa(com.bytedance.adsdk.IlO.MY.tV.EO.IlO(str2)));
            return i2 + 2;
        }
        String strValueOf = String.valueOf(IlO(i2, str));
        if (com.bytedance.adsdk.IlO.MY.tV.EO.IlO(strValueOf) != null) {
            deque.push(new zPa(com.bytedance.adsdk.IlO.MY.tV.EO.IlO(strValueOf)));
            return i8;
        }
        StringBuilder sbY = a.y("Unrecognized:", strValueOf, "examine:");
        sbY.append(str.substring(0, i2));
        throw new IllegalArgumentException(sbY.toString());
    }
}
