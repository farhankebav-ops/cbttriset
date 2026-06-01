package androidx.camera.video;

import android.util.Size;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface VideoCapabilities {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final VideoCapabilities EMPTY = new VideoCapabilities() { // from class: androidx.camera.video.VideoCapabilities.1
        @Override // androidx.camera.video.VideoCapabilities
        public final /* synthetic */ VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size size, DynamicRange dynamicRange) {
            return s.a(this, size, dynamicRange);
        }

        @Override // androidx.camera.video.VideoCapabilities
        public final /* synthetic */ Quality findNearestHigherSupportedQualityFor(Size size, DynamicRange dynamicRange) {
            return s.b(this, size, dynamicRange);
        }

        @Override // androidx.camera.video.VideoCapabilities
        public final /* synthetic */ VideoValidatedEncoderProfilesProxy getProfiles(Quality quality, DynamicRange dynamicRange) {
            return s.c(this, quality, dynamicRange);
        }

        @Override // androidx.camera.video.VideoCapabilities
        public Set<DynamicRange> getSupportedDynamicRanges() {
            return new HashSet();
        }

        @Override // androidx.camera.video.VideoCapabilities
        public List<Quality> getSupportedQualities(DynamicRange dynamicRange) {
            return new ArrayList();
        }

        @Override // androidx.camera.video.VideoCapabilities
        public boolean isQualitySupported(Quality quality, DynamicRange dynamicRange) {
            return false;
        }

        @Override // androidx.camera.video.VideoCapabilities
        public final /* synthetic */ boolean isStabilizationSupported() {
            return s.d(this);
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size size, DynamicRange dynamicRange);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Quality findNearestHigherSupportedQualityFor(Size size, DynamicRange dynamicRange);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy getProfiles(Quality quality, DynamicRange dynamicRange);

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Quality> getSupportedQualities(DynamicRange dynamicRange);

    boolean isQualitySupported(Quality quality, DynamicRange dynamicRange);

    boolean isStabilizationSupported();
}
