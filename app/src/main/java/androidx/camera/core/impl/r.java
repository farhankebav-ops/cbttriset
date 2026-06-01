package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class r {
    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE;
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE;
        }
    }

    public static int b(int i2) {
        if (i2 == 3) {
            return 2;
        }
        if (i2 != 4) {
            return i2 != 5 ? -1 : 39;
        }
        return 5;
    }

    public static String c(int i2) {
        switch (i2) {
            case 1:
                return "video/3gpp";
            case 2:
                return "video/avc";
            case 3:
                return "video/mp4v-es";
            case 4:
                return "video/x-vnd.on2.vp8";
            case 5:
                return MimeTypes.VIDEO_H265;
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/dolby-vision";
            case 8:
                return MimeTypes.VIDEO_AV1;
            default:
                return EncoderProfilesProxy.VideoProfileProxy.MEDIA_TYPE_NONE;
        }
    }
}
