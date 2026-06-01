package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ImmutableImageInfo implements ImageInfo {
    public static ImageInfo create(TagBundle tagBundle, long j, int i2, Matrix matrix, int i8) {
        return new AutoValue_ImmutableImageInfo(tagBundle, j, i2, matrix, i8);
    }

    @Override // androidx.camera.core.ImageInfo
    public abstract int getFlashState();

    @Override // androidx.camera.core.ImageInfo
    public abstract int getRotationDegrees();

    @Override // androidx.camera.core.ImageInfo
    public abstract Matrix getSensorToBufferTransformMatrix();

    @Override // androidx.camera.core.ImageInfo
    public abstract TagBundle getTagBundle();

    @Override // androidx.camera.core.ImageInfo
    public abstract long getTimestamp();

    @Override // androidx.camera.core.ImageInfo
    public void populateExifData(ExifData.Builder builder) {
        builder.setOrientationDegrees(getRotationDegrees());
    }
}
