package com.bytedance.adsdk.MY.Cc;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class DM {
    public static com.bytedance.adsdk.MY.EO.MY.ea IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        com.bytedance.adsdk.MY.EO.IlO.tV tVVar = null;
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.IlO ilOBc = null;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    ilOBc = tV.Bc(jsonReader, bc);
                    break;
                case "o":
                    tVVar = tV.MY(jsonReader, bc);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
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
        return new com.bytedance.adsdk.MY.EO.MY.ea(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, ilOBc, tVVar, zNextBoolean2);
    }
}
