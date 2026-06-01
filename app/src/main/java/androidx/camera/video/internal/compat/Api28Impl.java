package androidx.camera.video.internal.compat;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public final class Api28Impl {
    private Api28Impl() {
    }

    public static Range<Integer> getQualityRange(MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        return encoderCapabilities.getQualityRange();
    }
}
