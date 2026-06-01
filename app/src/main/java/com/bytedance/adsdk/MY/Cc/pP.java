package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY.lEW;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class pP {
    public static com.bytedance.adsdk.MY.EO.MY.lEW IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        lEW.IlO ilO = null;
        com.bytedance.adsdk.MY.EO.IlO.lEW lewCc = null;
        com.bytedance.adsdk.MY.EO.IlO.tV tVVarMY = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "o":
                    tVVarMY = tV.MY(jsonReader, bc);
                    break;
                case "pt":
                    lewCc = tV.Cc(jsonReader, bc);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.getClass();
                    switch (strNextString) {
                        case "a":
                            ilO = lEW.IlO.MASK_MODE_ADD;
                            break;
                        case "i":
                            bc.IlO("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            ilO = lEW.IlO.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            ilO = lEW.IlO.MASK_MODE_NONE;
                            break;
                        case "s":
                            ilO = lEW.IlO.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            ilO = lEW.IlO.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.MY.EO.MY.lEW(ilO, lewCc, tVVarMY, zNextBoolean);
    }
}
