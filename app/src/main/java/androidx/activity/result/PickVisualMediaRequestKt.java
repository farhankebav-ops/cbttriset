package androidx.activity.result;

import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import com.vungle.ads.internal.Constants;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequestKt {
    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
        k.e(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType);
    }

    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2) {
        k.e(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i2).build();
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.e(mediaType, "mediaType");
        k.e(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i2).setOrderedSelection(z2).setDefaultTab(defaultTab).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i8 & 2) != 0) {
            i2 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        return PickVisualMediaRequest(visualMediaType, i2);
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i8 & 2) != 0) {
            i2 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        if ((i8 & 4) != 0) {
            z2 = false;
        }
        if ((i8 & 8) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType, i2, z2, defaultTab);
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(long j, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.e(mediaType, "mediaType");
        k.e(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i2).setOrderedSelection(z2).setDefaultTab(defaultTab).setAccentColor(j).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(long j, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType2 = visualMediaType;
        if ((i8 & 4) != 0) {
            i2 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        int i9 = i2;
        if ((i8 & 8) != 0) {
            z2 = false;
        }
        boolean z7 = z2;
        if ((i8 & 16) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(j, visualMediaType2, i9, z7, defaultTab);
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i8 & 4) != 0) {
            i2 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        if ((i8 & 8) != 0) {
            z2 = false;
        }
        if ((i8 & 16) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(mediaCapabilities, visualMediaType, i2, z2, defaultTab);
    }

    @RequiresApi(33)
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.e(mediaType, "mediaType");
        k.e(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i2).setOrderedSelection(z2).setDefaultTab(defaultTab).setMediaCapabilitiesForTranscoding(mediaCapabilities).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, long j, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType2 = visualMediaType;
        if ((i8 & 8) != 0) {
            i2 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        int i9 = i2;
        if ((i8 & 16) != 0) {
            z2 = false;
        }
        boolean z7 = z2;
        if ((i8 & 32) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(mediaCapabilities, j, visualMediaType2, i9, z7, defaultTab);
    }

    @RequiresApi(33)
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, long j, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = Constants.AD_VISIBILITY_VISIBLE) int i2, boolean z2, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.e(mediaType, "mediaType");
        k.e(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i2).setOrderedSelection(z2).setDefaultTab(defaultTab).setAccentColor(j).setMediaCapabilitiesForTranscoding(mediaCapabilities).build();
    }
}
