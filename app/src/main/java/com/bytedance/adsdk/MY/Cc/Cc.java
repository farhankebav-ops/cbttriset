package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class Cc {
    public static com.bytedance.adsdk.MY.EO.MY.IlO IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        com.bytedance.adsdk.MY.EO.MY.IlO ilO = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.MY.EO.MY.IlO ilOMY = MY(jsonReader, bc);
                    if (ilOMY != null) {
                        ilO = ilOMY;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return ilO;
    }

    private static com.bytedance.adsdk.MY.EO.MY.IlO MY(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.MY.EO.MY.IlO ilO = null;
        while (true) {
            boolean z2 = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("v")) {
                    if (z2) {
                        ilO = new com.bytedance.adsdk.MY.EO.MY.IlO(tV.IlO(jsonReader, bc));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!strNextName.equals("ty")) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z2 = true;
                }
            }
            jsonReader.endObject();
            return ilO;
        }
    }
}
