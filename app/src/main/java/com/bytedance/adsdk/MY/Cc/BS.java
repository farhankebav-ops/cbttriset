package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class BS {
    public static com.bytedance.adsdk.MY.EO.MY.cl IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.lEW lewCc = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    lewCc = tV.Cc(jsonReader, bc);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.cl(strNextString, iNextInt, lewCc, zNextBoolean);
    }
}
