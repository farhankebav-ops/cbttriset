package com.bytedance.sdk.component.Cc.MY;

import com.bytedance.sdk.component.Cc.Cc;
import com.bytedance.sdk.component.Cc.bWL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements Cc {
    private boolean EO;
    private String IlO;
    private boolean MY;
    private bWL tV;

    public MY(String str, boolean z2, boolean z7, bWL bwl) {
        this.IlO = str;
        this.MY = z2;
        this.EO = z7;
        this.tV = bwl;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc
    public boolean EO() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc
    public String IlO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc
    public boolean MY() {
        return this.MY;
    }
}
