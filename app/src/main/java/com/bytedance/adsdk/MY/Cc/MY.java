package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static com.bytedance.adsdk.MY.EO.IlO.EV IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.MY.EO.IlO.EV evMY = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("a")) {
                evMY = MY(jsonReader, bc);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return evMY == null ? new com.bytedance.adsdk.MY.EO.IlO.EV(null, null, null, null) : evMY;
    }

    private static com.bytedance.adsdk.MY.EO.IlO.EV MY(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.MY.EO.IlO.IlO ilOBc = null;
        com.bytedance.adsdk.MY.EO.IlO.IlO ilOBc2 = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "t":
                    myIlO2 = tV.IlO(jsonReader, bc);
                    break;
                case "fc":
                    ilOBc = tV.Bc(jsonReader, bc);
                    break;
                case "sc":
                    ilOBc2 = tV.Bc(jsonReader, bc);
                    break;
                case "sw":
                    myIlO = tV.IlO(jsonReader, bc);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.MY.EO.IlO.EV(ilOBc, ilOBc2, myIlO, myIlO2);
    }
}
