package com.bytedance.sdk.component.MY.IlO;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Cc extends hp {
    List<String> IlO;
    List<String> MY;

    public Cc(List<String> list, List<String> list2) {
        this.IlO = list;
        this.MY = list2;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        private final List<String> IlO = new ArrayList();
        private final List<String> MY = new ArrayList();

        public IlO IlO(String str, String str2) {
            this.IlO.add(str);
            this.MY.add(str2);
            return this;
        }

        public Cc IlO() {
            return new Cc(this.IlO, this.MY);
        }
    }
}
