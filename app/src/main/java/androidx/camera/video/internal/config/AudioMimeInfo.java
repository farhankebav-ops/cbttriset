package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AutoValue_AudioMimeInfo;
import androidx.camera.video.internal.config.MimeInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AudioMimeInfo extends MimeInfo {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public abstract AudioMimeInfo build();

        public abstract Builder setCompatibleAudioProfile(EncoderProfilesProxy.AudioProfileProxy audioProfileProxy);
    }

    public static Builder builder(String str) {
        return new AutoValue_AudioMimeInfo.Builder().setMimeType(str).setProfile(-1);
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile();
}
