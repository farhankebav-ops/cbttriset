package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY.NV;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class vSq {
    public static com.bytedance.adsdk.MY.EO.MY.NV IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, int i2) throws IOException {
        boolean zNextBoolean = false;
        boolean z2 = i2 == 3;
        String strNextString = null;
        NV.IlO IlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVarMY = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO2 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO3 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO4 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO5 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO6 = null;
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
                case "r":
                    myIlO2 = tV.IlO(jsonReader, bc, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    myIlO3 = tV.IlO(jsonReader, bc);
                    break;
                case "is":
                    myIlO5 = tV.IlO(jsonReader, bc, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    myIlO4 = tV.IlO(jsonReader, bc);
                    break;
                case "os":
                    myIlO6 = tV.IlO(jsonReader, bc, false);
                    break;
                case "pt":
                    myIlO = tV.IlO(jsonReader, bc, false);
                    break;
                case "sy":
                    IlO = NV.IlO.IlO(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.NV(strNextString, IlO, myIlO, hpVarMY, myIlO2, myIlO3, myIlO4, myIlO5, myIlO6, zNextBoolean, z2);
    }
}
