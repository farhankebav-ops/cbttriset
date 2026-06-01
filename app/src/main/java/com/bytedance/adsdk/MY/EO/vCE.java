package com.bytedance.adsdk.MY.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private final String EO;
    public final float IlO;
    public final float MY;

    public vCE(String str, float f4, float f8) {
        this.EO = str;
        this.MY = f8;
        this.IlO = f4;
    }

    public boolean IlO(String str) {
        if (this.EO.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.EO.endsWith("\r")) {
            String str2 = this.EO;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
