package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class nvX {
    public static com.bytedance.adsdk.MY.EO.MY.hp IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "r":
                    myIlO = tV.IlO(jsonReader, bc, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.bytedance.adsdk.MY.EO.MY.hp(strNextString, myIlO);
    }
}
