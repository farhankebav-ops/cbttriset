package com.onesignal.user.internal.backend.impl;

import com.ironsource.Q6;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONConverter$convertToCreateUserResponse$respSubscriptions$1 extends l implements e6.l {
    public static final JSONConverter$convertToCreateUserResponse$respSubscriptions$1 INSTANCE = new JSONConverter$convertToCreateUserResponse$respSubscriptions$1();

    public JSONConverter$convertToCreateUserResponse$respSubscriptions$1() {
        super(1);
    }

    @Override // e6.l
    public final SubscriptionObject invoke(JSONObject it) throws JSONException {
        k.e(it, "it");
        SubscriptionObjectType.Companion companion = SubscriptionObjectType.Companion;
        String string = it.getString("type");
        k.d(string, "it.getString(\"type\")");
        SubscriptionObjectType subscriptionObjectTypeFromString = companion.fromString(string);
        if (subscriptionObjectTypeFromString != null) {
            return new SubscriptionObject(it.getString("id"), subscriptionObjectTypeFromString, JSONObjectExtensionsKt.safeString(it, "token"), JSONObjectExtensionsKt.safeBool(it, "enabled"), JSONObjectExtensionsKt.safeInt(it, "notification_types"), JSONObjectExtensionsKt.safeString(it, "sdk"), JSONObjectExtensionsKt.safeString(it, "device_model"), JSONObjectExtensionsKt.safeString(it, "device_os"), JSONObjectExtensionsKt.safeBool(it, "rooted"), JSONObjectExtensionsKt.safeInt(it, "net_type"), JSONObjectExtensionsKt.safeString(it, Q6.P0), JSONObjectExtensionsKt.safeString(it, "app_version"));
        }
        return null;
    }
}
