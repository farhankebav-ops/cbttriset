package com.instagram.common.viewpoint.core;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1798io implements MK {
    public final /* synthetic */ C1477dL A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C1798io(JSONObject jSONObject, C1477dL c1477dL, String str) {
        this.A02 = jSONObject;
        this.A00 = c1477dL;
        this.A01 = str;
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final String A7G() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final Collection<String> A7h() {
        return ML.A03(this.A00, this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.MK
    public final MJ A8C() {
        return ML.A00(this.A02);
    }
}
