package com.onesignal.user;

import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.subscriptions.IPushSubscription;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IUserManager {
    void addAlias(String str, String str2);

    void addAliases(Map<String, String> map);

    void addEmail(String str);

    void addObserver(IUserStateObserver iUserStateObserver);

    void addSms(String str);

    void addTag(String str, String str2);

    void addTags(Map<String, String> map);

    String getExternalId();

    String getOnesignalId();

    IPushSubscription getPushSubscription();

    Map<String, String> getTags();

    void removeAlias(String str);

    void removeAliases(Collection<String> collection);

    void removeEmail(String str);

    void removeObserver(IUserStateObserver iUserStateObserver);

    void removeSms(String str);

    void removeTag(String str);

    void removeTags(Collection<String> collection);

    void setLanguage(String str);
}
