package com.bytedance.adsdk.IlO.MY.EO.IlO;

import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends vCE {
    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        char cIlO;
        int i8 = i2;
        while (true) {
            cIlO = IlO(i8, str);
            if (!com.bytedance.adsdk.IlO.MY.Cc.IlO.MY(cIlO) && !com.bytedance.adsdk.IlO.MY.Cc.IlO.EO(cIlO)) {
                break;
            }
            i8++;
        }
        if (cIlO != '(') {
            return ilO.IlO(str, i2, deque);
        }
        deque.push(new com.bytedance.adsdk.IlO.MY.MY.IlO.NV(str.substring(i2, i8)));
        return i8 + 1;
    }
}
