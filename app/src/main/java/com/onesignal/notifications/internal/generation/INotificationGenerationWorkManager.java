package com.onesignal.notifications.internal.generation;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationGenerationWorkManager {
    boolean beginEnqueueingWork(Context context, String str, int i2, JSONObject jSONObject, long j, boolean z2, boolean z7);
}
