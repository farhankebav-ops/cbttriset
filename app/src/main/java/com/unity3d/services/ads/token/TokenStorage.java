package com.unity3d.services.ads.token;

import org.json.JSONArray;
import org.json.JSONException;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface TokenStorage {
    void appendTokens(JSONArray jSONArray) throws JSONException;

    void createTokens(JSONArray jSONArray) throws JSONException;

    void deleteTokens();

    x getNativeGeneratedToken();

    String getToken();

    void setInitToken(String str);
}
