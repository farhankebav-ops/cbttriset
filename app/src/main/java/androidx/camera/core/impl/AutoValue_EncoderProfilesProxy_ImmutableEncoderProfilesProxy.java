package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy extends EncoderProfilesProxy.ImmutableEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final int defaultDurationSeconds;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(int i2, int i8, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        this.defaultDurationSeconds = i2;
        this.recommendedFileFormat = i8;
        if (list == null) {
            throw new NullPointerException("Null audioProfiles");
        }
        this.audioProfiles = list;
        if (list2 == null) {
            throw new NullPointerException("Null videoProfiles");
        }
        this.videoProfiles = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncoderProfilesProxy.ImmutableEncoderProfilesProxy) {
            EncoderProfilesProxy.ImmutableEncoderProfilesProxy immutableEncoderProfilesProxy = (EncoderProfilesProxy.ImmutableEncoderProfilesProxy) obj;
            if (this.defaultDurationSeconds == immutableEncoderProfilesProxy.getDefaultDurationSeconds() && this.recommendedFileFormat == immutableEncoderProfilesProxy.getRecommendedFileFormat() && this.audioProfiles.equals(immutableEncoderProfilesProxy.getAudioProfiles()) && this.videoProfiles.equals(immutableEncoderProfilesProxy.getVideoProfiles())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getRecommendedFileFormat() {
        return this.recommendedFileFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.videoProfiles;
    }

    public int hashCode() {
        return ((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode();
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + "}";
    }
}
