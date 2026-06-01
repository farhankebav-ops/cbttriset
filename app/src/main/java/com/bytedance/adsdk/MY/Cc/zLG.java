package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class zLG {
    public static com.bytedance.adsdk.MY.EO.MY.zPa IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.MY.EO.MY.EO eoIlO = lEW.IlO(jsonReader, bc);
                        if (eoIlO != null) {
                            arrayList.add(eoIlO);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.zPa(strNextString, arrayList, zNextBoolean);
    }
}
