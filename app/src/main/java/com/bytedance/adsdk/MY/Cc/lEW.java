package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class lEW {
    public static com.bytedance.adsdk.MY.EO.MY.EO IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        com.bytedance.adsdk.MY.EO.MY.EO eoIlO;
        String strNextString;
        jsonReader.beginObject();
        int iNextInt = 2;
        while (true) {
            eoIlO = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (!strNextName.equals("d")) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString) {
            case "el":
                eoIlO = vCE.IlO(jsonReader, bc, iNextInt);
                break;
            case "fl":
                eoIlO = DM.IlO(jsonReader, bc);
                break;
            case "gf":
                eoIlO = zPa.IlO(jsonReader, bc);
                break;
            case "gr":
                eoIlO = zLG.IlO(jsonReader, bc);
                break;
            case "gs":
                eoIlO = cl.IlO(jsonReader, bc);
                break;
            case "mm":
                eoIlO = tl.IlO(jsonReader);
                bc.IlO("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case "rc":
                eoIlO = dY.IlO(jsonReader, bc);
                break;
            case "rd":
                eoIlO = nvX.IlO(jsonReader, bc);
                break;
            case "rp":
                eoIlO = lMM.IlO(jsonReader, bc);
                break;
            case "sh":
                eoIlO = BS.IlO(jsonReader, bc);
                break;
            case "sr":
                eoIlO = vSq.IlO(jsonReader, bc, iNextInt);
                break;
            case "st":
                eoIlO = ssS.IlO(jsonReader, bc);
                break;
            case "tm":
                eoIlO = gQ.IlO(jsonReader, bc);
                break;
            case "tr":
                eoIlO = EO.IlO(jsonReader, bc);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return eoIlO;
    }
}
