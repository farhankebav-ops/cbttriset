package com.onesignal.user.internal.backend;

import com.onesignal.common.consistency.RywData;
import java.util.List;
import java.util.Map;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IUserBackendService {
    Object createUser(String str, Map<String, String> map, List<SubscriptionObject> list, Map<String, String> map2, c<? super CreateUserResponse> cVar);

    Object getUser(String str, String str2, String str3, c<? super CreateUserResponse> cVar);

    Object updateUser(String str, String str2, String str3, PropertiesObject propertiesObject, boolean z2, PropertiesDeltasObject propertiesDeltasObject, c<? super RywData> cVar);
}
