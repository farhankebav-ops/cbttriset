package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static com.bytedance.adsdk.MY.EO.IlO.Cc IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(OOq.IlO(jsonReader, bc));
            }
            jsonReader.endArray();
            oeT.IlO(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.MY.Bc.IlO(xF.MY(jsonReader, com.bytedance.adsdk.MY.vCE.vCE.IlO())));
        }
        return new com.bytedance.adsdk.MY.EO.IlO.Cc(arrayList);
    }

    public static com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> MY(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.MY.EO.IlO.Cc ccIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO2 = null;
        boolean z2 = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "k":
                    ccIlO = IlO(jsonReader, bc);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        myIlO = tV.IlO(jsonReader, bc);
                        break;
                    } else {
                        z2 = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        myIlO2 = tV.IlO(jsonReader, bc);
                        break;
                    } else {
                        z2 = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z2) {
            bc.IlO("Lottie doesn't support expressions.");
        }
        return ccIlO != null ? ccIlO : new com.bytedance.adsdk.MY.EO.IlO.DmF(myIlO, myIlO2);
    }
}
