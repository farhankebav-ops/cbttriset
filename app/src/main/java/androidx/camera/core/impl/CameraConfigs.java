package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CameraConfigs {
    private static final CameraConfig DEFAULT_CAMERA_CONFIG = new DefaultCameraConfig();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultCameraConfig implements CameraConfig {
        private final Identifier mIdentifier = Identifier.create(new Object());

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ boolean containsOption(Config.Option option) {
            return w.a(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            w.b(this, str, optionMatcher);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public Identifier getCompatibilityId() {
            return this.mIdentifier;
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return w.c(this, option);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ CameraConfig.PostviewFormatSelector getPostviewFormatSelector() {
            return e.a(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Set getPriorities(Config.Option option) {
            return w.d(this, option);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ SessionProcessor getSessionProcessor() {
            return e.b(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ int getUseCaseCombinationRequiredRule() {
            return e.d(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ UseCaseConfigFactory getUseCaseConfigFactory() {
            return e.e(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ boolean isCaptureProcessProgressSupported() {
            return e.f(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ boolean isPostviewSupported() {
            return e.g(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Set listOptions() {
            return w.e(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOption(Config.Option option) {
            return w.f(this, option);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return w.h(this, option, optionPriority);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ SessionProcessor getSessionProcessor(SessionProcessor sessionProcessor) {
            return e.c(this, sessionProcessor);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return w.g(this, option, obj);
        }
    }

    private CameraConfigs() {
    }

    public static CameraConfig defaultConfig() {
        return DEFAULT_CAMERA_CONFIG;
    }
}
