package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.AXM;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface xF<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(int i2, String str);

        void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO(int i2, String str);

        void IlO(AXM.MY my);
    }

    com.bytedance.sdk.component.adexpress.IlO.EO.IlO IlO();

    com.bytedance.sdk.openadsdk.tV.Cc IlO(JSONObject jSONObject, String str, boolean z2);

    JSONObject IlO(JSONObject jSONObject);

    void IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pP pPVar, int i2, IlO ilO);

    void IlO(String str);

    void IlO(String str, List<FilterWord> list, String str2, String str3, String str4);

    void IlO(JSONObject jSONObject, MY my);

    void IlO(JSONObject jSONObject, String str);

    com.bytedance.sdk.openadsdk.tV.Cc MY(JSONObject jSONObject);
}
