package com.bytedance.adsdk.IlO.MY.EO.IlO;

import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vCE {
    public char IlO(int i2, String str) {
        if (i2 >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i2);
    }

    public abstract int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO);

    public int MY(int i2, String str) {
        while (com.bytedance.adsdk.IlO.MY.Cc.IlO.IlO(IlO(i2, str))) {
            i2++;
        }
        return i2;
    }
}
