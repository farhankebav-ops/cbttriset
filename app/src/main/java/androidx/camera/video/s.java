package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class s {
    public static VideoValidatedEncoderProfilesProxy a(VideoCapabilities videoCapabilities, Size size, DynamicRange dynamicRange) {
        return null;
    }

    public static Quality b(VideoCapabilities videoCapabilities, Size size, DynamicRange dynamicRange) {
        return Quality.NONE;
    }

    public static VideoValidatedEncoderProfilesProxy c(VideoCapabilities videoCapabilities, Quality quality, DynamicRange dynamicRange) {
        return null;
    }

    public static boolean d(VideoCapabilities videoCapabilities) {
        return false;
    }
}
