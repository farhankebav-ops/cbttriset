package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class OOq {
    public static com.bytedance.adsdk.MY.IlO.MY.DmF IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        return new com.bytedance.adsdk.MY.IlO.MY.DmF(bc, AXM.IlO(jsonReader, bc, com.bytedance.adsdk.MY.vCE.vCE.IlO(), wPn.IlO, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
