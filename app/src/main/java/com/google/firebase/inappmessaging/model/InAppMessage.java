package com.google.firebase.inappmessaging.model;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class InAppMessage {

    @Deprecated
    Button actionButton;

    @Deprecated
    String backgroundHexColor;

    @Deprecated
    Text body;

    @Deprecated
    String campaignId;
    CampaignMetadata campaignMetadata;

    @Deprecated
    String campaignName;

    @Nullable
    private Map<String, String> data;

    @Deprecated
    ImageData imageData;

    @Deprecated
    String imageUrl;

    @Deprecated
    Boolean isTestMessage;
    MessageType messageType;

    @Deprecated
    Text title;

    @Deprecated
    public InAppMessage(Text text, Text text2, String str, ImageData imageData, Button button, Action action, String str2, String str3, String str4, Boolean bool, MessageType messageType, Map<String, String> map) {
        this.title = text;
        this.body = text2;
        this.imageUrl = str;
        this.imageData = imageData;
        this.actionButton = button;
        this.backgroundHexColor = str2;
        this.campaignId = str3;
        this.campaignName = str4;
        this.isTestMessage = bool;
        this.messageType = messageType;
        this.campaignMetadata = new CampaignMetadata(str3, str4, bool.booleanValue());
        this.data = map;
    }

    @Nullable
    @Deprecated
    public abstract Action getAction();

    @Nullable
    @Deprecated
    public Button getActionButton() {
        return getAction() != null ? getAction().getButton() : this.actionButton;
    }

    @Nullable
    @Deprecated
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Nullable
    @Deprecated
    public Text getBody() {
        return this.body;
    }

    @Nullable
    @Deprecated
    public String getCampaignId() {
        return this.campaignMetadata.getCampaignId();
    }

    @Nullable
    public CampaignMetadata getCampaignMetadata() {
        return this.campaignMetadata;
    }

    @Nullable
    @Deprecated
    public String getCampaignName() {
        return this.campaignMetadata.getCampaignName();
    }

    @Nullable
    public Map<String, String> getData() {
        return this.data;
    }

    @Nullable
    @Deprecated
    public ImageData getImageData() {
        return this.imageData;
    }

    @Nullable
    @Deprecated
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    @Deprecated
    public Boolean getIsTestMessage() {
        return Boolean.valueOf(this.campaignMetadata.getIsTestMessage());
    }

    @Nullable
    public MessageType getMessageType() {
        return this.messageType;
    }

    @Nullable
    @Deprecated
    public Text getTitle() {
        return this.title;
    }

    public InAppMessage(CampaignMetadata campaignMetadata, MessageType messageType, Map<String, String> map) {
        this.campaignMetadata = campaignMetadata;
        this.messageType = messageType;
        this.data = map;
    }
}
