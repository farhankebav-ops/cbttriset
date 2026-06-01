package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AdapterNetworkData {
    JSONObject allData();

    <T> T dataByKeyIgnoreCase(String str, Class<T> cls);

    JSONObject networkDataByAdUnit(IronSource.a aVar);
}
