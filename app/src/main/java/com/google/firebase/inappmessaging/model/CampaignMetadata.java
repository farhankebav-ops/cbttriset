package com.google.firebase.inappmessaging.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CampaignMetadata {
    private final String campaignId;
    private final String campaignName;
    private final boolean isTestMessage;

    public CampaignMetadata(String str, String str2, boolean z2) {
        this.campaignId = str;
        this.campaignName = str2;
        this.isTestMessage = z2;
    }

    @NonNull
    public String getCampaignId() {
        return this.campaignId;
    }

    @NonNull
    public String getCampaignName() {
        return this.campaignName;
    }

    public boolean getIsTestMessage() {
        return this.isTestMessage;
    }
}
