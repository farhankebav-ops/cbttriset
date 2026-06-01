package com.onesignal.session.internal.outcomes;

import com.onesignal.session.internal.influence.InfluenceType;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOutcomeEvent {
    String getName();

    JSONArray getNotificationIds();

    InfluenceType getSession();

    long getSessionTime();

    long getTimestamp();

    float getWeight();
}
