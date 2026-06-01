package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class YA implements HSR<com.bytedance.adsdk.MY.Bc.EO> {
    public static final YA IlO = new YA();

    private YA() {
    }

    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.MY.Bc.EO MY(JsonReader jsonReader, float f4) throws IOException {
        boolean z2 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z2) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z2) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.MY.Bc.EO((fNextDouble / 100.0f) * f4, (fNextDouble2 / 100.0f) * f4);
    }
}
