package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements HSR<Integer> {
    public static final es IlO = new es();

    private es() {
    }

    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public Integer MY(JsonReader jsonReader, float f4) throws IOException {
        return Integer.valueOf(Math.round(xF.MY(jsonReader) * f4));
    }
}
