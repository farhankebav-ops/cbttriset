package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp implements HSR<Float> {
    public static final rp IlO = new rp();

    private rp() {
    }

    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public Float MY(JsonReader jsonReader, float f4) throws IOException {
        return Float.valueOf(xF.MY(jsonReader) * f4);
    }
}
