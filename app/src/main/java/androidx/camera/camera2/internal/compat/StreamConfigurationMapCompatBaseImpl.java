package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.core.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    private static final String TAG = "StreamConfigurationMapCompatBaseImpl";
    final StreamConfigurationMap mStreamConfigurationMap;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i2) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i2);
        }
    }

    public StreamConfigurationMapCompatBaseImpl(StreamConfigurationMap streamConfigurationMap) {
        this.mStreamConfigurationMap = streamConfigurationMap;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighResolutionOutputSizes(int i2) {
        return Api23Impl.getHighResolutionOutputSizes(this.mStreamConfigurationMap, i2);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Range<Integer>[] getHighSpeedVideoFpsRanges() {
        return this.mStreamConfigurationMap.getHighSpeedVideoFpsRanges();
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) throws IllegalArgumentException {
        return this.mStreamConfigurationMap.getHighSpeedVideoFpsRangesFor(size);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighSpeedVideoSizes() {
        return this.mStreamConfigurationMap.getHighSpeedVideoSizes();
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighSpeedVideoSizesFor(Range<Integer> range) throws IllegalArgumentException {
        return this.mStreamConfigurationMap.getHighSpeedVideoSizesFor(range);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public int[] getOutputFormats() {
        try {
            return this.mStreamConfigurationMap.getOutputFormats();
        } catch (IllegalArgumentException | NullPointerException e) {
            Logger.w(TAG, "Failed to get output formats from StreamConfigurationMap", e);
            return null;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public long getOutputMinFrameDuration(int i2, Size size) {
        return i2 == 34 ? this.mStreamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, size) : this.mStreamConfigurationMap.getOutputMinFrameDuration(i2, size);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getOutputSizes(int i2) {
        return i2 == 34 ? this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class) : this.mStreamConfigurationMap.getOutputSizes(i2);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public StreamConfigurationMap unwrap() {
        return this.mStreamConfigurationMap;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public <T> Size[] getOutputSizes(Class<T> cls) {
        return this.mStreamConfigurationMap.getOutputSizes(cls);
    }
}
