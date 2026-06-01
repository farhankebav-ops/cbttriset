package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AutoValue_VideoMimeInfo;
import androidx.camera.video.internal.config.MimeInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoMimeInfo extends MimeInfo {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public abstract VideoMimeInfo build();

        public abstract Builder setCompatibleVideoProfile(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy);
    }

    public static Builder builder(String str) {
        return new AutoValue_VideoMimeInfo.Builder().setMimeType(str).setProfile(-1);
    }

    public abstract EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile();
}
