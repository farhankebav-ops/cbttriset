package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static com.bytedance.adsdk.MY.EO.IlO.IlO Bc(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.IlO(IlO(jsonReader, bc, Bc.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.lEW Cc(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.lEW(IlO(jsonReader, com.bytedance.adsdk.MY.vCE.vCE.IlO(), bc, mmj.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.vCE EO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.vCE(oeT.IlO(jsonReader, bc, com.bytedance.adsdk.MY.vCE.vCE.IlO(), oc.IlO, true));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.MY IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return IlO(jsonReader, bc, true);
    }

    public static com.bytedance.adsdk.MY.EO.IlO.tV MY(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.tV(IlO(jsonReader, bc, es.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.Bc tV(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.Bc(IlO(jsonReader, bc, YA.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.NV vCE(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.NV(IlO(jsonReader, com.bytedance.adsdk.MY.vCE.vCE.IlO(), bc, DmF.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.MY IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, boolean z2) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.MY(IlO(jsonReader, z2 ? com.bytedance.adsdk.MY.vCE.vCE.IlO() : 1.0f, bc, rp.IlO));
    }

    public static com.bytedance.adsdk.MY.EO.IlO.EO IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, int i2) throws IOException {
        return new com.bytedance.adsdk.MY.EO.IlO.EO(IlO(jsonReader, bc, new ea(i2)));
    }

    private static <T> List<com.bytedance.adsdk.MY.Bc.IlO<T>> IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, HSR<T> hsr) throws IOException {
        return oeT.IlO(jsonReader, bc, 1.0f, hsr, false);
    }

    private static <T> List<com.bytedance.adsdk.MY.Bc.IlO<T>> IlO(JsonReader jsonReader, float f4, com.bytedance.adsdk.MY.Bc bc, HSR<T> hsr) throws IOException {
        return oeT.IlO(jsonReader, bc, f4, hsr, false);
    }
}
