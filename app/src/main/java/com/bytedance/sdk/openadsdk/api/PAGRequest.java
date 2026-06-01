package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGRequest {
    private Bundle EO = null;
    private String IlO;
    private Map<String, Object> MY;

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.EO == null) {
            this.EO = new Bundle();
        }
        this.EO.putBundle(cls.getName(), bundle);
    }

    public String getAdString() {
        return this.IlO;
    }

    public Map<String, Object> getExtraInfo() {
        return this.MY;
    }

    public Bundle getNetworkExtrasBundle() {
        return this.EO;
    }

    public void setAdString(String str) {
        this.IlO = str;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.MY = map;
    }
}
