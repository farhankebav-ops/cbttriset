package com.onesignal.session.internal.influence.impl;

import com.onesignal.session.internal.influence.InfluenceType;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInfluenceDataRepository {
    void cacheIAMInfluenceType(InfluenceType influenceType);

    void cacheNotificationInfluenceType(InfluenceType influenceType);

    void cacheNotificationOpenId(String str);

    String getCachedNotificationOpenId();

    InfluenceType getIamCachedInfluenceType();

    int getIamIndirectAttributionWindow();

    int getIamLimit();

    JSONArray getLastIAMsReceivedData() throws JSONException;

    JSONArray getLastNotificationsReceivedData() throws JSONException;

    InfluenceType getNotificationCachedInfluenceType();

    int getNotificationIndirectAttributionWindow();

    int getNotificationLimit();

    boolean isDirectInfluenceEnabled();

    boolean isIndirectInfluenceEnabled();

    boolean isUnattributedInfluenceEnabled();

    void saveIAMs(JSONArray jSONArray);

    void saveNotifications(JSONArray jSONArray);
}
