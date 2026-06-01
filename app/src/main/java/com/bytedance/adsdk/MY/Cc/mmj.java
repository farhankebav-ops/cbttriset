package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class mmj implements HSR<com.bytedance.adsdk.MY.EO.MY.bWL> {
    public static final mmj IlO = new mmj();

    private mmj() {
    }

    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.MY.EO.MY.bWL MY(JsonReader jsonReader, float f4) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listIlO = null;
        List<PointF> listIlO2 = null;
        List<PointF> listIlO3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listIlO == null || listIlO2 == null || listIlO3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listIlO.isEmpty()) {
                    return new com.bytedance.adsdk.MY.EO.MY.bWL(new PointF(), false, Collections.EMPTY_LIST);
                }
                int size = listIlO.size();
                PointF pointF = listIlO.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 1; i2 < size; i2++) {
                    PointF pointF2 = listIlO.get(i2);
                    int i8 = i2 - 1;
                    arrayList.add(new com.bytedance.adsdk.MY.EO.IlO(com.bytedance.adsdk.MY.vCE.Cc.IlO(listIlO.get(i8), listIlO3.get(i8)), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointF2, listIlO2.get(i2)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listIlO.get(0);
                    int i9 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.MY.EO.IlO(com.bytedance.adsdk.MY.vCE.Cc.IlO(listIlO.get(i9), listIlO3.get(i9)), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointF3, listIlO2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.MY.EO.MY.bWL(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listIlO2 = xF.IlO(jsonReader, f4);
                    break;
                case "o":
                    listIlO3 = xF.IlO(jsonReader, f4);
                    break;
                case "v":
                    listIlO = xF.IlO(jsonReader, f4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }
}
