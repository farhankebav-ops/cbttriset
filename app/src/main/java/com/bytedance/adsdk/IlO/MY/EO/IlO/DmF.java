package com.bytedance.adsdk.IlO.MY.EO.IlO;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends vCE {
    @Override // com.bytedance.adsdk.IlO.MY.EO.IlO.vCE
    public int IlO(String str, int i2, Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque, com.bytedance.adsdk.IlO.MY.EO.IlO ilO) {
        com.bytedance.adsdk.IlO.MY.MY.IlO ilOPollFirst;
        if (')' != IlO(i2, str)) {
            return ilO.IlO(str, i2, deque);
        }
        LinkedList<com.bytedance.adsdk.IlO.MY.MY.IlO> linkedList = new LinkedList();
        while (true) {
            ilOPollFirst = deque.pollFirst();
            if (ilOPollFirst == null || ilOPollFirst.IlO() == com.bytedance.adsdk.IlO.MY.tV.MY.METHOD || ilOPollFirst.IlO() == com.bytedance.adsdk.IlO.MY.tV.tV.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(ilOPollFirst);
        }
        if (ilOPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i2));
        }
        if (ilOPollFirst.IlO() != com.bytedance.adsdk.IlO.MY.tV.MY.METHOD) {
            deque.push(com.bytedance.adsdk.IlO.MY.Cc.MY.IlO(linkedList, str, i2));
            return i2 + 1;
        }
        com.bytedance.adsdk.IlO.MY.MY.IlO.NV nv = (com.bytedance.adsdk.IlO.MY.MY.IlO.NV) ilOPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.IlO.MY.MY.IlO ilO2 : linkedList) {
            if (ilO2.IlO() == com.bytedance.adsdk.IlO.MY.tV.tV.COMMA) {
                linkedList2.add(com.bytedance.adsdk.IlO.MY.Cc.MY.IlO(linkedList3, str, i2));
                linkedList3.clear();
            } else {
                linkedList3.addLast(ilO2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.IlO.MY.Cc.MY.IlO(linkedList3, str, i2));
        }
        nv.IlO((com.bytedance.adsdk.IlO.MY.MY.IlO[]) linkedList2.toArray(new com.bytedance.adsdk.IlO.MY.MY.IlO[linkedList2.size()]));
        int i8 = i2 + 1;
        deque.push(nv);
        return i8;
    }
}
