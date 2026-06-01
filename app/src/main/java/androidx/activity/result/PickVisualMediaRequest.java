package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import com.vungle.ads.internal.Constants;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequest {
    private long accentColor;
    private boolean isCustomAccentColorApplied;
    private boolean isOrderedSelection;
    private ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilitiesForTranscoding;
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
    private int maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
    private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private long accentColor;
        private boolean isCustomAccentColorApplied;
        private boolean isOrderedSelection;
        private ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilitiesForTranscoding;
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        private int maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            pickVisualMediaRequest.setMaxItems$activity_release(this.maxItems);
            pickVisualMediaRequest.setOrderedSelection$activity_release(this.isOrderedSelection);
            pickVisualMediaRequest.setDefaultTab$activity_release(this.defaultTab);
            pickVisualMediaRequest.setCustomAccentColorApplied$activity_release(this.isCustomAccentColorApplied);
            pickVisualMediaRequest.setAccentColor$activity_release(this.accentColor);
            pickVisualMediaRequest.setMediaCapabilitiesForTranscoding$activity_release(this.mediaCapabilitiesForTranscoding);
            return pickVisualMediaRequest;
        }

        public final Builder setAccentColor(long j) {
            this.accentColor = j;
            this.isCustomAccentColorApplied = true;
            return this;
        }

        public final Builder setDefaultTab(ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
            k.e(defaultTab, "defaultTab");
            this.defaultTab = defaultTab;
            return this;
        }

        public final Builder setMaxItems(@IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2) {
            this.maxItems = i2;
            return this;
        }

        @RequiresApi(33)
        public final Builder setMediaCapabilitiesForTranscoding(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities) {
            this.mediaCapabilitiesForTranscoding = mediaCapabilities;
            return this;
        }

        public final Builder setMediaType(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
            k.e(mediaType, "mediaType");
            this.mediaType = mediaType;
            return this;
        }

        public final Builder setOrderedSelection(boolean z2) {
            this.isOrderedSelection = z2;
            return this;
        }
    }

    public final long getAccentColor() {
        return this.accentColor;
    }

    public final ActivityResultContracts.PickVisualMedia.DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final ActivityResultContracts.PickVisualMedia.MediaCapabilities getMediaCapabilitiesForTranscoding() {
        return this.mediaCapabilitiesForTranscoding;
    }

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final boolean isCustomAccentColorApplied() {
        return this.isCustomAccentColorApplied;
    }

    public final boolean isOrderedSelection() {
        return this.isOrderedSelection;
    }

    public final void setAccentColor$activity_release(long j) {
        this.accentColor = j;
    }

    public final void setCustomAccentColorApplied$activity_release(boolean z2) {
        this.isCustomAccentColorApplied = z2;
    }

    public final void setDefaultTab$activity_release(ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.e(defaultTab, "<set-?>");
        this.defaultTab = defaultTab;
    }

    public final void setMaxItems$activity_release(int i2) {
        this.maxItems = i2;
    }

    public final void setMediaCapabilitiesForTranscoding$activity_release(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities) {
        this.mediaCapabilitiesForTranscoding = mediaCapabilities;
    }

    public final void setMediaType$activity_release(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        k.e(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }

    public final void setOrderedSelection$activity_release(boolean z2) {
        this.isOrderedSelection = z2;
    }
}
