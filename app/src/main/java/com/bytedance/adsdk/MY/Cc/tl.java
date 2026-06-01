package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY.DmF;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class tl {
    public static com.bytedance.adsdk.MY.EO.MY.DmF IlO(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        DmF.IlO IlO = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    IlO = DmF.IlO.IlO(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.DmF(strNextString, IlO, zNextBoolean);
    }
}
