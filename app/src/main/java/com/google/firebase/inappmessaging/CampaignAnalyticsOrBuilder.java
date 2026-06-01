package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface CampaignAnalyticsOrBuilder extends MessageLiteOrBuilder {
    String getCampaignId();

    ByteString getCampaignIdBytes();

    ClientAppInfo getClientApp();

    long getClientTimestampMillis();

    DismissType getDismissType();

    int getEngagementMetricsDeliveryRetryCount();

    CampaignAnalytics.EventCase getEventCase();

    EventType getEventType();

    FetchErrorReason getFetchErrorReason();

    String getFiamSdkVersion();

    ByteString getFiamSdkVersionBytes();

    String getProjectNumber();

    ByteString getProjectNumberBytes();

    RenderErrorReason getRenderErrorReason();

    boolean hasCampaignId();

    boolean hasClientApp();

    boolean hasClientTimestampMillis();

    boolean hasDismissType();

    boolean hasEngagementMetricsDeliveryRetryCount();

    boolean hasEventType();

    boolean hasFetchErrorReason();

    boolean hasFiamSdkVersion();

    boolean hasProjectNumber();

    boolean hasRenderErrorReason();
}
