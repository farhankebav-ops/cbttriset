package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CardMessage extends InAppMessage {

    @NonNull
    private final String backgroundHexColor;

    @Nullable
    private final Text body;

    @Nullable
    private final ImageData landscapeImageData;

    @Nullable
    private final ImageData portraitImageData;

    @NonNull
    private final Action primaryAction;

    @Nullable
    private final Action secondaryAction;

    @NonNull
    private final Text title;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        @Nullable
        String backgroundHexColor;

        @Nullable
        Text body;

        @Nullable
        ImageData landscapeImageData;

        @Nullable
        ImageData portraitImageData;

        @Nullable
        Action primaryAction;

        @Nullable
        Action secondaryAction;

        @Nullable
        Text title;

        public CardMessage build(CampaignMetadata campaignMetadata, @Nullable Map<String, String> map) {
            Action action = this.primaryAction;
            if (action == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            }
            if (action.getButton() == null) {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
            Action action2 = this.secondaryAction;
            if (action2 != null && action2.getButton() == null) {
                throw new IllegalArgumentException("Card model secondary action must be null or have a button");
            }
            if (this.title == null) {
                throw new IllegalArgumentException("Card model must have a title");
            }
            if (this.portraitImageData == null && this.landscapeImageData == null) {
                throw new IllegalArgumentException("Card model must have at least one image");
            }
            if (TextUtils.isEmpty(this.backgroundHexColor)) {
                throw new IllegalArgumentException("Card model must have a background color");
            }
            return new CardMessage(campaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction, map);
        }

        public Builder setBackgroundHexColor(@Nullable String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public Builder setBody(@Nullable Text text) {
            this.body = text;
            return this;
        }

        public Builder setLandscapeImageData(@Nullable ImageData imageData) {
            this.landscapeImageData = imageData;
            return this;
        }

        public Builder setPortraitImageData(@Nullable ImageData imageData) {
            this.portraitImageData = imageData;
            return this;
        }

        public Builder setPrimaryAction(@Nullable Action action) {
            this.primaryAction = action;
            return this;
        }

        public Builder setSecondaryAction(@Nullable Action action) {
            this.secondaryAction = action;
            return this;
        }

        public Builder setTitle(@Nullable Text text) {
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
        if (!(obj instanceof CardMessage)) {
            return false;
        }
        CardMessage cardMessage = (CardMessage) obj;
        if (hashCode() != cardMessage.hashCode()) {
            return false;
        }
        Text text = this.body;
        if ((text == null && cardMessage.body != null) || (text != null && !text.equals(cardMessage.body))) {
            return false;
        }
        Action action = this.secondaryAction;
        if ((action == null && cardMessage.secondaryAction != null) || (action != null && !action.equals(cardMessage.secondaryAction))) {
            return false;
        }
        ImageData imageData = this.portraitImageData;
        if ((imageData == null && cardMessage.portraitImageData != null) || (imageData != null && !imageData.equals(cardMessage.portraitImageData))) {
            return false;
        }
        ImageData imageData2 = this.landscapeImageData;
        return (imageData2 != null || cardMessage.landscapeImageData == null) && (imageData2 == null || imageData2.equals(cardMessage.landscapeImageData)) && this.title.equals(cardMessage.title) && this.primaryAction.equals(cardMessage.primaryAction) && this.backgroundHexColor.equals(cardMessage.backgroundHexColor);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    @Deprecated
    public Action getAction() {
        return this.primaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public Text getBody() {
        return this.body;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    @Deprecated
    public ImageData getImageData() {
        return this.portraitImageData;
    }

    @Nullable
    public ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    @Nullable
    public ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    @NonNull
    public Action getPrimaryAction() {
        return this.primaryAction;
    }

    @Nullable
    public Action getSecondaryAction() {
        return this.secondaryAction;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        Text text = this.body;
        int iHashCode = text != null ? text.hashCode() : 0;
        Action action = this.secondaryAction;
        int iHashCode2 = action != null ? action.hashCode() : 0;
        ImageData imageData = this.portraitImageData;
        int iHashCode3 = imageData != null ? imageData.hashCode() : 0;
        ImageData imageData2 = this.landscapeImageData;
        return this.primaryAction.hashCode() + this.backgroundHexColor.hashCode() + this.title.hashCode() + iHashCode + iHashCode2 + iHashCode3 + (imageData2 != null ? imageData2.hashCode() : 0);
    }

    private CardMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull Text text, @Nullable Text text2, @Nullable ImageData imageData, @Nullable ImageData imageData2, @NonNull String str, @NonNull Action action, @Nullable Action action2, @Nullable Map<String, String> map) {
        super(campaignMetadata, MessageType.CARD, map);
        this.title = text;
        this.body = text2;
        this.portraitImageData = imageData;
        this.landscapeImageData = imageData2;
        this.backgroundHexColor = str;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }
}
