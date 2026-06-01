package com.unity3d.ads.core.data.datasource;

import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidAnalyticsDataSource implements AnalyticsDataSource {
    @Override // com.unity3d.ads.core.data.datasource.AnalyticsDataSource
    public String getUserId() {
        return AndroidPreferences.getString(ClientProperties.getAppName() + ".v2.playerprefs", "unity.cloud_userid");
    }
}
