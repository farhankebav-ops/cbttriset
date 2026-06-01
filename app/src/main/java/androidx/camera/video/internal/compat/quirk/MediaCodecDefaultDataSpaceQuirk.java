package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecDefaultDataSpaceQuirk implements Quirk {
    public static boolean load() {
        return true;
    }

    public VideoEncoderDataSpace getSuggestedDataSpace() {
        return VideoEncoderDataSpace.ENCODER_DATA_SPACE_SRGB;
    }
}
