package com.iab.omid.library.bytedance2.adsession;

import com.ironsource.Y1;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER(Y1.f7807d);

    private final String deviceCategory;

    DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.deviceCategory;
    }
}
