package com.bytedance.adsdk.IlO.MY.EO.IlO;

import com.bytedance.adsdk.IlO.MY.MY.IlO.vAh;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends vCE {
    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        char cIlO = IlO(i2, str);
        return (com.bytedance.adsdk.IlO.MY.Cc.IlO.MY(cIlO) || cIlO == '$') ? IlO(str, i2, deque) : ilO.IlO(str, i2, deque);
    }

    private int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque) {
        int i8;
        int i9 = 0;
        while (true) {
            i8 = i9 + i2;
            char cIlO = IlO(i8, str);
            if (!com.bytedance.adsdk.IlO.MY.Cc.IlO.MY(cIlO) && !com.bytedance.adsdk.IlO.MY.Cc.IlO.EO(cIlO) && '.' != cIlO && '[' != cIlO && ']' != cIlO && '_' != cIlO && '-' != cIlO && '$' != cIlO) {
                break;
            }
            i9++;
        }
        String strSubstring = str.substring(i2, i8);
        if (com.bytedance.adsdk.IlO.MY.tV.IlO.IlO(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.IlO.MY.MY.IlO.Bc(strSubstring));
            return i8;
        }
        deque.push(new vAh(strSubstring));
        return i8;
    }
}
