package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class oeT {
    public static <T> List<com.bytedance.adsdk.MY.Bc.IlO<T>> IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, float f4, HSR<T> hsr, boolean z2) throws IOException {
        JsonReader jsonReader2;
        com.bytedance.adsdk.MY.Bc bc2;
        float f8;
        HSR<T> hsr2;
        boolean z7;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            bc.IlO("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (!strNextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    JsonReader jsonReader3 = jsonReader;
                    com.bytedance.adsdk.MY.Bc bc3 = bc;
                    float f9 = f4;
                    HSR<T> hsr3 = hsr;
                    boolean z8 = z2;
                    com.bytedance.adsdk.MY.Bc.IlO IlO = AXM.IlO(jsonReader3, bc3, f9, hsr3, false, z8);
                    jsonReader2 = jsonReader3;
                    bc2 = bc3;
                    f8 = f9;
                    hsr2 = hsr3;
                    z7 = z8;
                    arrayList.add(IlO);
                } else {
                    jsonReader2 = jsonReader;
                    bc2 = bc;
                    f8 = f4;
                    hsr2 = hsr;
                    z7 = z2;
                    while (jsonReader2.hasNext()) {
                        arrayList.add(AXM.IlO(jsonReader2, bc2, f8, hsr2, true, z7));
                    }
                }
                jsonReader2.endArray();
                jsonReader = jsonReader2;
                bc = bc2;
                f4 = f8;
                hsr = hsr2;
                z2 = z7;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(AXM.IlO(jsonReader4, bc, f4, hsr, false, z2));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.endObject();
        IlO(arrayList);
        return arrayList;
    }

    public static <T> void IlO(List<? extends com.bytedance.adsdk.MY.Bc.IlO<T>> list) {
        int i2;
        T t3;
        int size = list.size();
        int i8 = 0;
        while (true) {
            i2 = size - 1;
            if (i8 >= i2) {
                break;
            }
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO = list.get(i8);
            i8++;
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO2 = list.get(i8);
            ilO.Bc = Float.valueOf(ilO2.vCE);
            if (ilO.MY == null && (t3 = ilO2.IlO) != null) {
                ilO.MY = t3;
                if (ilO instanceof com.bytedance.adsdk.MY.IlO.MY.DmF) {
                    ((com.bytedance.adsdk.MY.IlO.MY.DmF) ilO).IlO();
                }
            }
        }
        com.bytedance.adsdk.MY.Bc.IlO<T> ilO3 = list.get(i2);
        if ((ilO3.IlO == null || ilO3.MY == null) && list.size() > 1) {
            list.remove(ilO3);
        }
    }
}
