package androidx.camera.video.internal.compat;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
public final class Api31Impl {
    private Api31Impl() {
    }

    public static Range<Integer>[] getInputChannelCountRanges(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getInputChannelCountRanges();
    }

    public static int getMinInputChannelCount(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getMinInputChannelCount();
    }

    public static void setContext(AudioRecord.Builder builder, Context context) {
        builder.setContext(context);
    }
}
