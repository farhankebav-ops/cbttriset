package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class StreamConfigurationMapCompat {
    private static final String TAG = "StreamConfigurationMapCompat";
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes = new HashMap();
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes = new HashMap();
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int i2);

        Range<Integer>[] getHighSpeedVideoFpsRanges();

        Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) throws IllegalArgumentException;

        Size[] getHighSpeedVideoSizes();

        Size[] getHighSpeedVideoSizesFor(Range<Integer> range) throws IllegalArgumentException;

        int[] getOutputFormats();

        long getOutputMinFrameDuration(int i2, Size size);

        Size[] getOutputSizes(int i2);

        <T> Size[] getOutputSizes(Class<T> cls);

        StreamConfigurationMap unwrap();
    }

    private StreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
        this.mOutputSizesCorrector = outputSizesCorrector;
    }

    public static StreamConfigurationMapCompat toStreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }

    public Size[] getHighResolutionOutputSizes(int i2) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(i2))) {
            if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i2)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i2)).clone();
        }
        Size[] highResolutionOutputSizes = this.mImpl.getHighResolutionOutputSizes(i2);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
            highResolutionOutputSizes = this.mOutputSizesCorrector.applyQuirks(highResolutionOutputSizes, i2);
        }
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(i2), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    public Range<Integer>[] getHighSpeedVideoFpsRanges() {
        return this.mImpl.getHighSpeedVideoFpsRanges();
    }

    public Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) throws IllegalArgumentException {
        return this.mImpl.getHighSpeedVideoFpsRangesFor(size);
    }

    public Size[] getHighSpeedVideoSizes() {
        return this.mImpl.getHighSpeedVideoSizes();
    }

    public Size[] getHighSpeedVideoSizesFor(Range<Integer> range) throws IllegalArgumentException {
        return this.mImpl.getHighSpeedVideoSizesFor(range);
    }

    public int[] getOutputFormats() {
        int[] outputFormats = this.mImpl.getOutputFormats();
        if (outputFormats == null) {
            return null;
        }
        return (int[]) outputFormats.clone();
    }

    public long getOutputMinFrameDuration(int i2, Size size) {
        try {
            return this.mImpl.getOutputMinFrameDuration(i2, size);
        } catch (RuntimeException e) {
            Logger.w(TAG, "Failed to get min frame duration for format = " + i2 + " and size = " + size, e);
            return 0L;
        }
    }

    public Size[] getOutputSizes(int i2) {
        Size[] outputSizes = null;
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(i2))) {
            if (this.mCachedFormatOutputSizes.get(Integer.valueOf(i2)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i2)).clone();
        }
        try {
            outputSizes = this.mImpl.getOutputSizes(i2);
        } catch (Throwable th) {
            Logger.w(TAG, "Failed to get output sizes for " + i2, th);
        }
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, i2);
            this.mCachedFormatOutputSizes.put(Integer.valueOf(i2), sizeArrApplyQuirks);
            return (Size[]) sizeArrApplyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for format " + i2);
        return outputSizes;
    }

    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }

    public <T> Size[] getOutputSizes(Class<T> cls) {
        Size[] outputSizes = null;
        if (this.mCachedClassOutputSizes.containsKey(cls)) {
            if (this.mCachedClassOutputSizes.get(cls) == null) {
                return null;
            }
            return (Size[]) this.mCachedClassOutputSizes.get(cls).clone();
        }
        try {
            outputSizes = this.mImpl.getOutputSizes(cls);
        } catch (Throwable th) {
            Logger.w(TAG, "Fail to get output sizes for " + cls, th);
        }
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, cls);
            this.mCachedClassOutputSizes.put(cls, sizeArrApplyQuirks);
            return (Size[]) sizeArrApplyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for class " + cls);
        return outputSizes;
    }
}
