package com.onesignal.notifications;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotification {
    List<IActionButton> getActionButtons();

    JSONObject getAdditionalData();

    int getAndroidNotificationId();

    BackgroundImageLayout getBackgroundImageLayout();

    String getBigPicture();

    String getBody();

    String getCollapseId();

    String getFromProjectNumber();

    String getGroupKey();

    String getGroupMessage();

    List<INotification> getGroupedNotifications();

    String getLargeIcon();

    String getLaunchURL();

    String getLedColor();

    int getLockScreenVisibility();

    String getNotificationId();

    int getPriority();

    String getRawPayload();

    long getSentTime();

    String getSmallIcon();

    String getSmallIconAccentColor();

    String getSound();

    String getTemplateId();

    String getTemplateName();

    String getTitle();

    int getTtl();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void getBackgroundImageLayout$annotations() {
        }
    }
}
