package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    static {
        Config.Option<UseCaseConfigFactory> option = CameraConfig.OPTION_USECASE_CONFIG_FACTORY;
    }

    public static CameraConfig.PostviewFormatSelector a(CameraConfig cameraConfig) {
        return (CameraConfig.PostviewFormatSelector) cameraConfig.retrieveOption(CameraConfig.OPTION_POSTVIEW_FORMAT_SELECTOR, CameraConfig.DEFAULT_POSTVIEW_FORMAT_SELECTOR);
    }

    public static SessionProcessor b(CameraConfig cameraConfig) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR);
    }

    public static SessionProcessor c(CameraConfig cameraConfig, SessionProcessor sessionProcessor) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
    }

    public static int d(CameraConfig cameraConfig) {
        return ((Integer) cameraConfig.retrieveOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue();
    }

    public static UseCaseConfigFactory e(CameraConfig cameraConfig) {
        return (UseCaseConfigFactory) cameraConfig.retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
    }

    public static boolean f(CameraConfig cameraConfig) {
        return ((Boolean) cameraConfig.retrieveOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, Boolean.FALSE)).booleanValue();
    }

    public static boolean g(CameraConfig cameraConfig) {
        return ((Boolean) cameraConfig.retrieveOption(CameraConfig.OPTION_POSTVIEW_SUPPORTED, Boolean.FALSE)).booleanValue();
    }

    public static /* synthetic */ int h(int i2, List list) {
        if (list.contains(35)) {
            return 35;
        }
        if (list.contains(256)) {
            return 256;
        }
        return list.contains(4101) ? 4101 : 0;
    }
}
