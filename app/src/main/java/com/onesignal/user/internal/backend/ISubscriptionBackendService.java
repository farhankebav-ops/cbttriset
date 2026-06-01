package com.onesignal.user.internal.backend;

import com.onesignal.common.consistency.RywData;
import java.util.Map;
import q5.i;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ISubscriptionBackendService {
    Object createSubscription(String str, String str2, String str3, SubscriptionObject subscriptionObject, c<? super i> cVar);

    Object deleteSubscription(String str, String str2, c<? super x> cVar);

    Object getIdentityFromSubscription(String str, String str2, c<? super Map<String, String>> cVar);

    Object transferSubscription(String str, String str2, String str3, String str4, c<? super x> cVar);

    Object updateSubscription(String str, String str2, SubscriptionObject subscriptionObject, c<? super RywData> cVar);
}
