package com.bytedance.adsdk.MY.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum EO {
    JSON(".json"),
    ZIP(".zip");

    public final String EO;

    EO(String str) {
        this.EO = str;
    }

    public String IlO() {
        return ".temp" + this.EO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.EO;
    }
}
