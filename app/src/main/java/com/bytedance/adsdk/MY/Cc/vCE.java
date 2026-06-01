package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class vCE {
    public static com.bytedance.adsdk.MY.EO.MY.MY IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, int i2) throws IOException {
        boolean z2 = i2 == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVarMY = null;
        com.bytedance.adsdk.MY.EO.IlO.vCE vceEO = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                    break;
                case "p":
                    hpVarMY = IlO.MY(jsonReader, bc);
                    break;
                case "s":
                    vceEO = tV.EO(jsonReader, bc);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.MY(strNextString, hpVarMY, vceEO, z2, zNextBoolean);
    }
}
