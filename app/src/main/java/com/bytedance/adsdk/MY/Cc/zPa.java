package com.bytedance.adsdk.MY.Cc;

import android.graphics.Path;
import android.util.JsonReader;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class zPa {
    public static com.bytedance.adsdk.MY.EO.MY.Cc IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        int iNextInt;
        com.bytedance.adsdk.MY.EO.IlO.tV tVVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.MY.Bc bc2 = null;
        com.bytedance.adsdk.MY.EO.IlO.EO eoIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.vCE vceEO = null;
        com.bytedance.adsdk.MY.EO.IlO.vCE vceEO2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            iNextInt = -1;
            switch (strNextName) {
                case "e":
                    vceEO2 = tV.EO(jsonReader, bc);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals("k")) {
                            eoIlO = tV.IlO(jsonReader, bc, iNextInt);
                        } else if (strNextName2.equals(NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    tVVar = tV.MY(jsonReader, bc);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    vceEO = tV.EO(jsonReader, bc);
                    break;
                case "t":
                    bc2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.MY.EO.MY.Bc.LINEAR : com.bytedance.adsdk.MY.EO.MY.Bc.RADIAL;
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
        if (tVVar == null) {
            tVVar = new com.bytedance.adsdk.MY.EO.IlO.tV(Collections.singletonList(new com.bytedance.adsdk.MY.Bc.IlO(100)));
        }
        return new com.bytedance.adsdk.MY.EO.MY.Cc(strNextString, bc2, fillType, eoIlO, tVVar, vceEO, vceEO2, null, null, zNextBoolean);
    }
}
