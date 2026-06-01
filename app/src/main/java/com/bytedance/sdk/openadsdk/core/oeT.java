package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.component.embedapplog.IDefaultEncrypt;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT implements IDefaultEncrypt {
    private final PangleEncryptConstant.CryptDataScene IlO;

    public oeT(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        this.IlO = cryptDataScene;
    }

    @Override // com.bytedance.sdk.component.embedapplog.IDefaultEncrypt
    public JSONObject encrypt(JSONObject jSONObject, int i2) {
        vAh.IlO(1, this.IlO, i2);
        return com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
    }
}
