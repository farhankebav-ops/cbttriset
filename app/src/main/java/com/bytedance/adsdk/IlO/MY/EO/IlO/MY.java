package com.bytedance.adsdk.IlO.MY.EO.IlO;

import com.bytedance.adsdk.IlO.MY.MY.IlO.AXM;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends vCE {
    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        if ('\'' != IlO(i2, str)) {
            return ilO.IlO(str, i2, deque);
        }
        int i8 = i2 + 1;
        int length = str.length();
        int i9 = i8;
        while (i9 < length && IlO(i9, str) != '\'') {
            i9++;
        }
        if (IlO(i9, str) != '\'') {
            throw new com.bytedance.adsdk.IlO.IlO.IlO("String expression not surrounded by '", str.substring(i2));
        }
        deque.push(new AXM(str.substring(i8, i9)));
        return i9 + 1;
    }
}
