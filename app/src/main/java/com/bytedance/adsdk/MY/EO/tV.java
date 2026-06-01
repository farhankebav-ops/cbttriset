package com.bytedance.adsdk.MY.EO;

import androidx.camera.core.processing.util.a;
import com.bytedance.adsdk.MY.EO.MY.zPa;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private final String Cc;
    private final double EO;
    private final List<zPa> IlO;
    private final char MY;
    private final double tV;
    private final String vCE;

    public tV(List<zPa> list, char c7, double d8, double d9, String str, String str2) {
        this.IlO = list;
        this.MY = c7;
        this.EO = d8;
        this.tV = d9;
        this.Cc = str;
        this.vCE = str2;
    }

    public static int IlO(char c7, String str, String str2) {
        return str2.hashCode() + a.b(c7 * 31, 31, str);
    }

    public double MY() {
        return this.tV;
    }

    public int hashCode() {
        return IlO(this.MY, this.vCE, this.Cc);
    }

    public List<zPa> IlO() {
        return this.IlO;
    }
}
