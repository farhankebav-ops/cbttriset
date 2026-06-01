package com.google.firebase.inappmessaging.model;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageOnlyMessage extends InAppMessage {
    private Action action;

    @NonNull
    private ImageData imageData;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        Action action;
        ImageData imageData;

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            ImageData imageData = this.imageData;
            if (imageData != null) {
                return new ImageOnlyMessage(campaignMetadata, imageData, this.action, map);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public Builder setAction(Action action) {
            this.action = action;
            return this;
        }

        public Builder setImageData(ImageData imageData) {
            this.imageData = imageData;
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
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        Action action = this.action;
        return (action != null || imageOnlyMessage.action == null) && (action == null || action.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData);
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Action getAction() {
        return this.action;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @NonNull
    public ImageData getImageData() {
        return this.imageData;
    }

    public int hashCode() {
        Action action = this.action;
        return this.imageData.hashCode() + (action != null ? action.hashCode() : 0);
    }

    private ImageOnlyMessage(@NonNull CampaignMetadata campaignMetadata, @NonNull ImageData imageData, Action action, Map<String, String> map) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map);
        this.imageData = imageData;
        this.action = action;
    }
}
