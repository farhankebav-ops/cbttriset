package com.instagram.common.viewpoint.core;

import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1678gf implements O8 {
    public final SharedPreferences A00;

    public C1678gf(SharedPreferences sharedPreferences) {
        this.A00 = sharedPreferences;
    }

    @Override // com.instagram.common.viewpoint.core.O8
    public final C1679gg A6A() {
        return new C1679gg(this.A00.edit());
    }

    @Override // com.instagram.common.viewpoint.core.O8
    public final long A8I(String str, long j) {
        return this.A00.getLong(str, j);
    }

    @Override // com.instagram.common.viewpoint.core.O8
    public final String A96(String str, String str2) {
        return this.A00.getString(str, str2);
    }
}
