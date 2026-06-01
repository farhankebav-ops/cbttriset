package androidx.camera.extensions;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.e;
import androidx.camera.core.impl.w;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ExtensionsConfig implements CameraConfig {
    public static final Config.Option<Integer> OPTION_EXTENSION_MODE = Config.Option.create("camerax.extensions.extensionMode", Integer.TYPE);
    private final Config mConfig;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder implements CameraConfig.Builder<Builder> {
        private final MutableOptionsBundle mConfig = MutableOptionsBundle.create();

        public ExtensionsConfig build() {
            return new ExtensionsConfig(this.mConfig);
        }

        public Builder setExtensionMode(int i2) {
            this.mConfig.insertOption(ExtensionsConfig.OPTION_EXTENSION_MODE, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setCaptureProcessProgressSupported(boolean z2) {
            this.mConfig.insertOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, Boolean.valueOf(z2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setCompatibilityId(Identifier identifier) {
            this.mConfig.insertOption(CameraConfig.OPTION_COMPATIBILITY_ID, identifier);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setPostviewFormatSelector(CameraConfig.PostviewFormatSelector postviewFormatSelector) {
            this.mConfig.insertOption(CameraConfig.OPTION_POSTVIEW_FORMAT_SELECTOR, postviewFormatSelector);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setPostviewSupported(boolean z2) {
            this.mConfig.insertOption(CameraConfig.OPTION_POSTVIEW_SUPPORTED, Boolean.valueOf(z2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setSessionProcessor(SessionProcessor sessionProcessor) {
            this.mConfig.insertOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setUseCaseCombinationRequiredRule(int i2) {
            this.mConfig.insertOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setUseCaseConfigFactory(UseCaseConfigFactory useCaseConfigFactory) {
            this.mConfig.insertOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, useCaseConfigFactory);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.CameraConfig.Builder
        public Builder setZslDisabled(boolean z2) {
            this.mConfig.insertOption(CameraConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z2));
            return this;
        }
    }

    public ExtensionsConfig(Config config) {
        this.mConfig = config;
    }

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
        return (Identifier) w.f(this, CameraConfig.OPTION_COMPATIBILITY_ID);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public int getExtensionMode() {
        return ((Integer) w.f(this, OPTION_EXTENSION_MODE)).intValue();
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
