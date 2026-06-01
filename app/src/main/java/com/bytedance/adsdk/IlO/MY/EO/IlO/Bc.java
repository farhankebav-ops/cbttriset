package com.bytedance.adsdk.IlO.MY.EO.IlO;

import com.bytedance.adsdk.IlO.MY.MY.IlO.ea;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends vCE {
    private boolean IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque) {
        if ('-' != IlO(i2, str)) {
            return com.bytedance.adsdk.IlO.MY.Cc.IlO.EO(IlO(i2, str));
        }
        if (deque.peek() != null && !com.bytedance.adsdk.IlO.MY.tV.EO.IlO(deque.peek().IlO())) {
            return false;
        }
        if (com.bytedance.adsdk.IlO.MY.Cc.IlO.EO(IlO(i2 + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i2));
    }

    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        char cIlO;
        if (!IlO(str, i2, deque)) {
            return ilO.IlO(str, i2, deque);
        }
        int i8 = IlO(i2, str) == '-' ? i2 + 1 : i2;
        boolean z2 = false;
        while (true) {
            cIlO = IlO(i8, str);
            if (!com.bytedance.adsdk.IlO.MY.Cc.IlO.EO(cIlO) && (z2 || cIlO != '.')) {
                break;
            }
            i8++;
            if (cIlO == '.') {
                z2 = true;
            }
        }
        if (cIlO != '.') {
            deque.push(new ea(str.substring(i2, i8)));
            return i8;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i2, i8));
    }
}
