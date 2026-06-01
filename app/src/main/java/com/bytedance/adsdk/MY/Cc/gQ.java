package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY.xF;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class gQ {
    public static com.bytedance.adsdk.MY.EO.MY.xF IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        String strNextString = null;
        xF.IlO IlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO2 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "e":
                    myIlO2 = tV.IlO(jsonReader, bc, false);
                    break;
                case "m":
                    IlO = xF.IlO.IlO(jsonReader.nextInt());
                    break;
                case "o":
                    myIlO3 = tV.IlO(jsonReader, bc, false);
                    break;
                case "s":
                    myIlO = tV.IlO(jsonReader, bc, false);
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
        return new com.bytedance.adsdk.MY.EO.MY.xF(strNextString, IlO, myIlO, myIlO2, myIlO3, zNextBoolean);
    }
}
