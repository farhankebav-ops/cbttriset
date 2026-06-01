package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalCamera2Interop.class})
public final class Camera2ImplConfig extends CaptureRequestOptions {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Integer> TEMPLATE_TYPE_OPTION = Config.Option.create("camera2.captureRequest.templateType", Integer.TYPE);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Long> STREAM_USE_CASE_OPTION = Config.Option.create("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraDevice.StateCallback> DEVICE_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.StateCallback> SESSION_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.CaptureCallback> SESSION_CAPTURE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Object> CAPTURE_REQUEST_TAG_OPTION = Config.Option.create("camera2.captureRequest.tag", Object.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<String> SESSION_PHYSICAL_CAMERA_ID_OPTION = Config.Option.create("camera2.cameraCaptureSession.physicalCameraId", String.class);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {
        private final MutableOptionsBundle mMutableOptionsBundle = MutableOptionsBundle.create();

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        public Builder insertAllOptions(Config config) {
            insertAllOptions(config, Config.OptionPriority.OPTIONAL);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> key, ValueT valuet) {
            this.mMutableOptionsBundle.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), valuet);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOptionWithPriority(CaptureRequest.Key<ValueT> key, ValueT valuet, Config.OptionPriority optionPriority) {
            this.mMutableOptionsBundle.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), optionPriority, valuet);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public Camera2ImplConfig build() {
            return new Camera2ImplConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }

        public Builder insertAllOptions(Config config, Config.OptionPriority optionPriority) {
            for (Config.Option<?> option : config.listOptions()) {
                this.mMutableOptionsBundle.insertOption(option, optionPriority, config.retrieveOption(option));
            }
            return this;
        }
    }

    public Camera2ImplConfig(Config config) {
        super(config);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Config.Option<Object> createCaptureRequestOption(CaptureRequest.Key<?> key) {
        return Config.Option.create(CAPTURE_REQUEST_ID_STEM + key.getName(), Object.class, key);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CaptureRequestOptions getCaptureRequestOptions() {
        return CaptureRequestOptions.Builder.from(getConfig()).build();
    }

    public Object getCaptureRequestTag(Object obj) {
        return getConfig().retrieveOption(CAPTURE_REQUEST_TAG_OPTION, obj);
    }

    public int getCaptureRequestTemplate(int i2) {
        return ((Integer) getConfig().retrieveOption(TEMPLATE_TYPE_OPTION, Integer.valueOf(i2))).intValue();
    }

    public CameraDevice.StateCallback getDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) getConfig().retrieveOption(DEVICE_STATE_CALLBACK_OPTION, stateCallback);
    }

    public String getPhysicalCameraId(String str) {
        return (String) getConfig().retrieveOption(SESSION_PHYSICAL_CAMERA_ID_OPTION, str);
    }

    public CameraCaptureSession.CaptureCallback getSessionCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) getConfig().retrieveOption(SESSION_CAPTURE_CALLBACK_OPTION, captureCallback);
    }

    public CameraCaptureSession.StateCallback getSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) getConfig().retrieveOption(SESSION_STATE_CALLBACK_OPTION, stateCallback);
    }

    public long getStreamUseCase(long j) {
        return ((Long) getConfig().retrieveOption(STREAM_USE_CASE_OPTION, Long.valueOf(j))).longValue();
    }
}
