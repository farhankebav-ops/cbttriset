package com.bytedance.sdk.component.MY.IlO;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class DmF {
    private String IlO;
    private String MY;

    private DmF(String str) {
        this.IlO = str;
    }

    public static DmF IlO(String str) {
        return new DmF(str);
    }

    public String IlO() {
        return this.IlO;
    }

    public Charset IlO(Charset charset) {
        try {
            String str = this.MY;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
