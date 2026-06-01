package androidx.camera.core.featuregroup.impl.feature;

import a1.a;
import androidx.camera.core.featuregroup.GroupableFeature;
import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageFormatFeature extends GroupableFeature {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_IMAGE_CAPTURE_OUTPUT_FORMAT = 0;
    private final FeatureTypeInternal featureTypeInternal = FeatureTypeInternal.IMAGE_FORMAT;
    private final int imageCaptureOutputFormat;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public ImageFormatFeature(int i2) {
        this.imageCaptureOutputFormat = i2;
    }

    private final String getOutputFormatLabel() {
        int i2 = this.imageCaptureOutputFormat;
        return i2 != 0 ? i2 != 1 ? a0.c(new StringBuilder("UNDEFINED("), this.imageCaptureOutputFormat, ')') : "JPEG_R" : "JPEG";
    }

    @Override // androidx.camera.core.featuregroup.GroupableFeature
    public FeatureTypeInternal getFeatureTypeInternal$camera_core_release() {
        return this.featureTypeInternal;
    }

    public final int getImageCaptureOutputFormat() {
        return this.imageCaptureOutputFormat;
    }

    public String toString() {
        return a.e(')', getOutputFormatLabel(), new StringBuilder("ImageFormatFeature(imageCaptureOutputFormat="));
    }
}
