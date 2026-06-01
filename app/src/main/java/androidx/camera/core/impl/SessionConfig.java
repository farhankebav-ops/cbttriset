package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.HighSpeedFpsModifier;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionConfig {
    public static final int DEFAULT_SESSION_TYPE = 0;
    public static final int SESSION_TYPE_HIGH_SPEED = 1;
    public static final int SESSION_TYPE_REGULAR = 0;
    private static final List<Integer> SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(1, 5, 3);
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final ErrorListener mErrorListener;
    private InputConfiguration mInputConfiguration;
    private final List<OutputConfig> mOutputConfigs;
    private final OutputConfig mPostviewOutputConfig;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final int mSessionType;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class BaseBuilder {
        ErrorListener mErrorListener;
        InputConfiguration mInputConfiguration;
        OutputConfig mPostviewOutputConfig;
        final Set<OutputConfig> mOutputConfigs = new LinkedHashSet();
        final CaptureConfig.Builder mCaptureConfigBuilder = new CaptureConfig.Builder();
        final List<CameraDevice.StateCallback> mDeviceStateCallbacks = new ArrayList();
        final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks = new ArrayList();
        final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks = new ArrayList();
        int mSessionType = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder extends BaseBuilder {
        public static Builder createFrom(UseCaseConfig<?> useCaseConfig, Size size) {
            OptionUnpacker sessionOptionUnpacker = useCaseConfig.getSessionOptionUnpacker(null);
            if (sessionOptionUnpacker != null) {
                Builder builder = new Builder();
                sessionOptionUnpacker.unpack(size, useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        public Builder addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback cameraCaptureCallback : collection) {
                this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
                if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                    this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
                }
            }
            return this;
        }

        public Builder addAllDeviceStateCallbacks(Collection<CameraDevice.StateCallback> collection) {
            Iterator<CameraDevice.StateCallback> it = collection.iterator();
            while (it.hasNext()) {
                addDeviceStateCallback(it.next());
            }
            return this;
        }

        public Builder addAllRepeatingCameraCaptureCallbacks(Collection<CameraCaptureCallback> collection) {
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
            return this;
        }

        public Builder addAllSessionStateCallbacks(List<CameraCaptureSession.StateCallback> list) {
            Iterator<CameraCaptureSession.StateCallback> it = list.iterator();
            while (it.hasNext()) {
                addSessionStateCallback(it.next());
            }
            return this;
        }

        public Builder addCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
            }
            return this;
        }

        public Builder addDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
            if (this.mDeviceStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mDeviceStateCallbacks.add(stateCallback);
            return this;
        }

        public Builder addImplementationOptions(Config config) {
            this.mCaptureConfigBuilder.addImplementationOptions(config);
            return this;
        }

        public Builder addNonRepeatingSurface(DeferrableSurface deferrableSurface) {
            return addNonRepeatingSurface(deferrableSurface, DynamicRange.SDR);
        }

        public Builder addOutputConfig(OutputConfig outputConfig) {
            this.mOutputConfigs.add(outputConfig);
            this.mCaptureConfigBuilder.addSurface(outputConfig.getSurface());
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                this.mCaptureConfigBuilder.addSurface(it.next());
            }
            return this;
        }

        public Builder addRepeatingCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            return this;
        }

        public Builder addSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
            if (this.mSessionStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mSessionStateCallbacks.add(stateCallback);
            return this;
        }

        public Builder addSurface(DeferrableSurface deferrableSurface) {
            return addSurface(deferrableSurface, DynamicRange.SDR);
        }

        public Builder addTag(String str, Object obj) {
            this.mCaptureConfigBuilder.addTag(str, obj);
            return this;
        }

        public SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mOutputConfigs), new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), this.mErrorListener, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
        }

        public Builder clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
            return this;
        }

        public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
            return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
        }

        public boolean removeCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            return this.mCaptureConfigBuilder.removeCameraCaptureCallback(cameraCaptureCallback) || this.mSingleCameraCaptureCallbacks.remove(cameraCaptureCallback);
        }

        public Builder removeSurface(DeferrableSurface deferrableSurface) {
            OutputConfig next;
            Iterator<OutputConfig> it = this.mOutputConfigs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getSurface().equals(deferrableSurface)) {
                    break;
                }
            }
            if (next != null) {
                this.mOutputConfigs.remove(next);
            }
            this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
            return this;
        }

        public Builder setErrorListener(ErrorListener errorListener) {
            this.mErrorListener = errorListener;
            return this;
        }

        public Builder setExpectedFrameRateRange(Range<Integer> range) {
            this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
            return this;
        }

        public Builder setImplementationOptions(Config config) {
            this.mCaptureConfigBuilder.setImplementationOptions(config);
            return this;
        }

        public Builder setInputConfiguration(InputConfiguration inputConfiguration) {
            this.mInputConfiguration = inputConfiguration;
            return this;
        }

        public Builder setPostviewSurface(DeferrableSurface deferrableSurface) {
            this.mPostviewOutputConfig = OutputConfig.builder(deferrableSurface).build();
            return this;
        }

        public Builder setPreviewStabilization(int i2) {
            if (i2 != 0) {
                this.mCaptureConfigBuilder.setPreviewStabilization(i2);
            }
            return this;
        }

        public Builder setSessionType(int i2) {
            this.mSessionType = i2;
            return this;
        }

        public Builder setTemplateType(int i2) {
            this.mCaptureConfigBuilder.setTemplateType(i2);
            return this;
        }

        public Builder setVideoStabilization(int i2) {
            if (i2 != 0) {
                this.mCaptureConfigBuilder.setVideoStabilization(i2);
            }
            return this;
        }

        public Builder addNonRepeatingSurface(DeferrableSurface deferrableSurface, DynamicRange dynamicRange) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setDynamicRange(dynamicRange).build());
            return this;
        }

        public Builder addSurface(DeferrableSurface deferrableSurface, DynamicRange dynamicRange) {
            return addSurface(deferrableSurface, dynamicRange, null, -1);
        }

        public Builder addSurface(DeferrableSurface deferrableSurface, DynamicRange dynamicRange, String str, int i2) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setPhysicalCameraId(str).setDynamicRange(dynamicRange).setMirrorMode(i2).build());
            this.mCaptureConfigBuilder.addSurface(deferrableSurface);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CloseableErrorListener implements ErrorListener {
        private final ErrorListener mErrorListener;
        private final AtomicBoolean mIsClosed = new AtomicBoolean(false);

        public CloseableErrorListener(ErrorListener errorListener) {
            this.mErrorListener = errorListener;
        }

        public void close() {
            this.mIsClosed.set(true);
        }

        @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
        public void onError(SessionConfig sessionConfig, SessionError sessionError) {
            if (this.mIsClosed.get()) {
                return;
            }
            this.mErrorListener.onError(sessionConfig, sessionError);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ErrorListener {
        void onError(SessionConfig sessionConfig, SessionError sessionError);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OptionUnpacker {
        void unpack(Size size, UseCaseConfig<?> useCaseConfig, Builder builder);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class OutputConfig {
        public static final int SURFACE_GROUP_ID_NONE = -1;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static abstract class Builder {
            public abstract OutputConfig build();

            public abstract Builder setDynamicRange(DynamicRange dynamicRange);

            public abstract Builder setMirrorMode(int i2);

            public abstract Builder setPhysicalCameraId(String str);

            public abstract Builder setSharedSurfaces(List<DeferrableSurface> list);

            public abstract Builder setSurface(DeferrableSurface deferrableSurface);

            public abstract Builder setSurfaceGroupId(int i2);
        }

        public static Builder builder(DeferrableSurface deferrableSurface) {
            return new AutoValue_SessionConfig_OutputConfig.Builder().setSurface(deferrableSurface).setSharedSurfaces(Collections.EMPTY_LIST).setPhysicalCameraId(null).setMirrorMode(-1).setSurfaceGroupId(-1).setDynamicRange(DynamicRange.SDR);
        }

        public abstract DynamicRange getDynamicRange();

        public abstract int getMirrorMode();

        public abstract String getPhysicalCameraId();

        public abstract List<DeferrableSurface> getSharedSurfaces();

        public abstract DeferrableSurface getSurface();

        public abstract int getSurfaceGroupId();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ValidatingBuilder extends BaseBuilder {
        private static final String TAG = "ValidatingBuilder";
        private final SurfaceSorter mSurfaceSorter = new SurfaceSorter();
        private boolean mValid = true;
        private StringBuilder mInvalidReason = new StringBuilder();
        private boolean mTemplateSet = false;
        private List<ErrorListener> mErrorListeners = new ArrayList();

        private List<DeferrableSurface> getSurfaces() {
            ArrayList arrayList = new ArrayList();
            for (OutputConfig outputConfig : this.mOutputConfigs) {
                arrayList.add(outputConfig.getSurface());
                Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$build$0(SessionConfig sessionConfig, SessionError sessionError) {
            Iterator<ErrorListener> it = this.mErrorListeners.iterator();
            while (it.hasNext()) {
                it.next().onError(sessionConfig, sessionError);
            }
        }

        private void setOrVerifyExpectFrameRateRange(Range<Integer> range) {
            Range<Integer> range2 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            if (range.equals(range2)) {
                return;
            }
            if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range2)) {
                this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
                return;
            }
            if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range)) {
                return;
            }
            this.mValid = false;
            String str = "Different ExpectedFrameRateRange values; current = " + this.mCaptureConfigBuilder.getExpectedFrameRateRange() + ", new = " + range;
            Logger.e(TAG, str);
            this.mInvalidReason.append(str);
        }

        private void setPreviewStabilizationMode(int i2) {
            if (i2 != 0) {
                this.mCaptureConfigBuilder.setPreviewStabilization(i2);
            }
        }

        private void setVideoStabilizationMode(int i2) {
            if (i2 != 0) {
                this.mCaptureConfigBuilder.setVideoStabilization(i2);
            }
        }

        public void add(SessionConfig sessionConfig) {
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getTemplateType() != -1) {
                this.mTemplateSet = true;
                this.mCaptureConfigBuilder.setTemplateType(SessionConfig.getHigherPriorityTemplateType(repeatingCaptureConfig.getTemplateType(), this.mCaptureConfigBuilder.getTemplateType()));
            }
            setOrVerifyExpectFrameRateRange(repeatingCaptureConfig.getExpectedFrameRateRange());
            setPreviewStabilizationMode(repeatingCaptureConfig.getPreviewStabilizationMode());
            setVideoStabilizationMode(repeatingCaptureConfig.getVideoStabilizationMode());
            this.mCaptureConfigBuilder.addAllTags(sessionConfig.getRepeatingCaptureConfig().getTagBundle());
            this.mDeviceStateCallbacks.addAll(sessionConfig.getDeviceStateCallbacks());
            this.mSessionStateCallbacks.addAll(sessionConfig.getSessionStateCallbacks());
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(sessionConfig.getRepeatingCameraCaptureCallbacks());
            this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.getSingleCameraCaptureCallbacks());
            if (sessionConfig.getErrorListener() != null) {
                this.mErrorListeners.add(sessionConfig.getErrorListener());
            }
            if (sessionConfig.getInputConfiguration() != null) {
                this.mInputConfiguration = sessionConfig.getInputConfiguration();
            }
            this.mOutputConfigs.addAll(sessionConfig.getOutputConfigs());
            this.mCaptureConfigBuilder.getSurfaces().addAll(repeatingCaptureConfig.getSurfaces());
            if (!getSurfaces().containsAll(this.mCaptureConfigBuilder.getSurfaces())) {
                Logger.d(TAG, "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.mValid = false;
                this.mInvalidReason.append("Invalid configuration due to capture request surfaces are not a subset of surfaces");
            }
            if (sessionConfig.getSessionType() != this.mSessionType && sessionConfig.getSessionType() != 0 && this.mSessionType != 0) {
                Logger.d(TAG, "Invalid configuration due to that two non-default session types are set");
                this.mValid = false;
                this.mInvalidReason.append("Invalid configuration due to that two non-default session types are set");
            } else if (sessionConfig.getSessionType() != 0) {
                this.mSessionType = sessionConfig.getSessionType();
            }
            if (sessionConfig.mPostviewOutputConfig != null) {
                if (this.mPostviewOutputConfig == sessionConfig.mPostviewOutputConfig || this.mPostviewOutputConfig == null) {
                    this.mPostviewOutputConfig = sessionConfig.mPostviewOutputConfig;
                } else {
                    Logger.d(TAG, "Invalid configuration due to that two different postview output configs are set");
                    this.mValid = false;
                    this.mInvalidReason.append("Invalid configuration due to that two different postview output configs are set");
                }
            }
            this.mCaptureConfigBuilder.addImplementationOptions(repeatingCaptureConfig.getImplementationOptions());
        }

        public <T> void addImplementationOption(Config.Option<T> option, T t3) {
            this.mCaptureConfigBuilder.addImplementationOption(option, t3);
        }

        public SessionConfig build() {
            if (!this.mValid) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.mOutputConfigs);
            this.mSurfaceSorter.sort(arrayList);
            if (this.mSessionType == 1) {
                new HighSpeedFpsModifier().modifyFpsForPreviewOnlyRepeating(arrayList, this.mCaptureConfigBuilder);
            }
            return new SessionConfig(arrayList, new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), !this.mErrorListeners.isEmpty() ? new ErrorListener() { // from class: androidx.camera.core.impl.y
                @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
                public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                    this.f3655a.lambda$build$0(sessionConfig, sessionError);
                }
            } : null, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
        }

        public void clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        public String getInvalidReason() {
            return !this.mTemplateSet ? "Template is not set" : this.mInvalidReason.toString();
        }

        public boolean isValid() {
            return this.mTemplateSet && this.mValid;
        }
    }

    public SessionConfig(List<OutputConfig> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, CaptureConfig captureConfig, ErrorListener errorListener, InputConfiguration inputConfiguration, int i2, OutputConfig outputConfig) {
        this.mOutputConfigs = list;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(list4);
        this.mErrorListener = errorListener;
        this.mRepeatingCaptureConfig = captureConfig;
        this.mInputConfiguration = inputConfiguration;
        this.mSessionType = i2;
        this.mPostviewOutputConfig = outputConfig;
    }

    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().build(), null, null, 0, null);
    }

    public static int getHigherPriorityTemplateType(int i2, int i8) {
        List<Integer> list = SUPPORTED_TEMPLATE_PRIORITY;
        return list.indexOf(Integer.valueOf(i2)) >= list.indexOf(Integer.valueOf(i8)) ? i2 : i8;
    }

    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    public ErrorListener getErrorListener() {
        return this.mErrorListener;
    }

    public Range<Integer> getExpectedFrameRateRange() {
        return this.mRepeatingCaptureConfig.getExpectedFrameRateRange();
    }

    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    public InputConfiguration getInputConfiguration() {
        return this.mInputConfiguration;
    }

    public List<OutputConfig> getOutputConfigs() {
        return this.mOutputConfigs;
    }

    public OutputConfig getPostviewOutputConfig() {
        return this.mPostviewOutputConfig;
    }

    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    public int getSessionType() {
        return this.mSessionType;
    }

    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    public List<DeferrableSurface> getSurfaces() {
        ArrayList arrayList = new ArrayList();
        for (OutputConfig outputConfig : this.mOutputConfigs) {
            arrayList.add(outputConfig.getSurface());
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}
