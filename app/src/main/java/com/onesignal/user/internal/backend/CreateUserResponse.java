package com.onesignal.user.internal.backend;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CreateUserResponse {
    private final Map<String, String> identities;
    private final PropertiesObject properties;
    private final List<SubscriptionObject> subscriptions;

    public CreateUserResponse(Map<String, String> identities, PropertiesObject properties, List<SubscriptionObject> subscriptions) {
        k.e(identities, "identities");
        k.e(properties, "properties");
        k.e(subscriptions, "subscriptions");
        this.identities = identities;
        this.properties = properties;
        this.subscriptions = subscriptions;
    }

    public final Map<String, String> getIdentities() {
        return this.identities;
    }

    public final PropertiesObject getProperties() {
        return this.properties;
    }

    public final List<SubscriptionObject> getSubscriptions() {
        return this.subscriptions;
    }
}
