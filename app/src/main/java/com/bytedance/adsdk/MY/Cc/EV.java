package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private com.bytedance.adsdk.MY.EO.IlO.MY Cc;
    private com.bytedance.adsdk.MY.EO.IlO.MY EO;
    private com.bytedance.adsdk.MY.EO.IlO.IlO IlO;
    private com.bytedance.adsdk.MY.EO.IlO.MY MY;
    private com.bytedance.adsdk.MY.EO.IlO.MY tV;

    private void MY(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("v")) {
                strNextString.getClass();
                switch (strNextString) {
                    case "Distance":
                        this.tV = tV.IlO(jsonReader, bc);
                        break;
                    case "Opacity":
                        this.MY = tV.IlO(jsonReader, bc, false);
                        break;
                    case "Direction":
                        this.EO = tV.IlO(jsonReader, bc, false);
                        break;
                    case "Shadow Color":
                        this.IlO = tV.Bc(jsonReader, bc);
                        break;
                    case "Softness":
                        this.Cc = tV.IlO(jsonReader, bc);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    public NV IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        com.bytedance.adsdk.MY.EO.IlO.MY my;
        com.bytedance.adsdk.MY.EO.IlO.MY my2;
        com.bytedance.adsdk.MY.EO.IlO.MY my3;
        com.bytedance.adsdk.MY.EO.IlO.MY my4;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    MY(jsonReader, bc);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.bytedance.adsdk.MY.EO.IlO.IlO ilO = this.IlO;
        if (ilO == null || (my = this.MY) == null || (my2 = this.EO) == null || (my3 = this.tV) == null || (my4 = this.Cc) == null) {
            return null;
        }
        return new NV(ilO, my, my2, my3, my4);
    }
}
