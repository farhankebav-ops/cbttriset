package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class BannerMessage extends InAppMessage {
    private final Action action;

    @NonNull
    private final String backgroundHexColor;
    private final Text body;
    private final ImageData imageData;

    @NonNull
    private final Text title;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        Action action;
        String backgroundHexColor;
        Text body;
        ImageData imageData;
        Text title;

        public BannerMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            if (this.title == null) {
                throw new IllegalArgumentException("Banner model must have a title");
            }
            if (TextUtils.isEmpty(this.backgroundHexColor)) {
                throw new IllegalArgumentException("Banner model must have a background color");
            }
            return new BannerMessage(campaignMetadata, this.title, this.body, this.imageData, this.action, this.backgroundHexColor, map);
        }

        public Builder setAction(Action action) {
            this.action = action;
            return this;
        }

        public Builder setBackgroundHexColor(String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public Builder setBody(Text text) {
            this.body = text;
            return this;
        }

        public Builder setImageData(ImageData imageData) {
            this.imageData = imageData;
            return this;
        }

        public Builder setTitle(Text text) {
            this.title = text;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BannerMessage)) {
            return false;
        }
        BannerMessage bannerMessage = (BannerMessage) obj;
        if (hashCode() != bannerMessage.hashCode()) {
            return false;
        }
        Text text = this.body;
        if ((text == null && bannerMessage.body != null) || (text != null && !text.equals(bannerMessage.body))) {
            return false;
        }
        ImageData imageData = this.imageData;
        if ((imageData == null && bannerMessage.imageData != null) || (imageData != null && !imageData.equals(bannerMessage.imageData))) {
            return false;
        }
        Action action = this.action;
        return (action != null || bannerMessage.action == null) && (action == null || action.equals(bannerMessage.action)) && this.title.equals(bannerMessage.title) && this.backgroundHexColor.equals(bannerMessage.backgroundHexColor);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Text getBody() {
        return this.body;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public ImageData getImageData() {
        return this.imageData;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        Text text = this.body;
        int iHashCode = text != null ? text.hashCode() : 0;
        ImageData imageData = this.imageData;
        int iHashCode2 = imageData != null ? imageData.hashCode() : 0;
        Action action = this.action;
        return this.backgroundHexColor.hashCode() + this.title.hashCode() + iHashCode + iHashCode2 + (action != null ? action.hashCode() : 0);
    }

    private BannerMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull Text text, Text text2, ImageData imageData, Action action, @NonNull String str, Map<String, String> map) {
        super(campaignMetadata, MessageType.BANNER, map);
        this.title = text;
        this.body = text2;
        this.imageData = imageData;
        this.action = action;
        this.backgroundHexColor = str;
    }
}
