package com.bytedance.sdk.component.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp {
    public byte[] Cc;
    public DmF EO;
    public String tV;
    public IlO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public hp() {
    }

    public static hp IlO(DmF dmF, String str) {
        return new hp(dmF, str, IlO.STRING_TYPE);
    }

    public hp(DmF dmF, String str, IlO ilO) {
        this.EO = dmF;
        this.tV = str;
        this.vCE = ilO;
    }

    public static hp IlO(DmF dmF, byte[] bArr) {
        return new hp(dmF, bArr, IlO.BYTE_ARRAY_TYPE);
    }

    public hp(DmF dmF, byte[] bArr, IlO ilO) {
        this.EO = dmF;
        this.Cc = bArr;
        this.vCE = ilO;
    }
}
