package androidx.camera.camera2.interop;

import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.Config;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CaptureRequestConfiguratorKt {
    private static final Config.Option<Camera2CaptureRequestConfigurator> OPTION_CAPTURE_REQUEST_CONFIGURATOR;

    static {
        Config.Option<Camera2CaptureRequestConfigurator> optionCreate = Config.Option.create("camerax.core.appConfig.captureRequestConfigurator", Camera2CaptureRequestConfigurator.class);
        k.d(optionCreate, "create(...)");
        OPTION_CAPTURE_REQUEST_CONFIGURATOR = optionCreate;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Camera2CaptureRequestConfigurator getCamera2CaptureRequestConfigurator(CameraXConfig cameraXConfig) {
        k.e(cameraXConfig, "<this>");
        return (Camera2CaptureRequestConfigurator) cameraXConfig.getConfig().retrieveOption(OPTION_CAPTURE_REQUEST_CONFIGURATOR, null);
    }

    public static final Config.Option<Camera2CaptureRequestConfigurator> getOPTION_CAPTURE_REQUEST_CONFIGURATOR() {
        return OPTION_CAPTURE_REQUEST_CONFIGURATOR;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final CameraXConfig.Builder setCamera2CaptureRequestConfigurator(CameraXConfig.Builder builder, Camera2CaptureRequestConfigurator captureRequestConfigurator) {
        k.e(builder, "<this>");
        k.e(captureRequestConfigurator, "captureRequestConfigurator");
        builder.getMutableConfig().insertOption(OPTION_CAPTURE_REQUEST_CONFIGURATOR, captureRequestConfigurator);
        return builder;
    }
}
