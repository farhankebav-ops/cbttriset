package androidx.camera.core;

import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraXConfig implements TargetConfig<CameraX> {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int CAMERAX_CONFIG_IMPL_TYPE_CAMERA_CAMERA2 = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int CAMERAX_CONFIG_IMPL_TYPE_PIPE = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int CAMERAX_CONFIG_IMPL_TYPE_UNKNOWN = -1;
    static final long DEFAULT_OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = -1;
    static final Config.Option<CameraSelector> OPTION_AVAILABLE_CAMERAS_LIMITER;
    static final Config.Option<Long> OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING;

    @OptIn(markerClass = {ExperimentalRetryPolicy.class})
    static final Config.Option<RetryPolicy> OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY;
    static final Config.Option<Integer> OPTION_CONFIG_IMPL_TYPE;
    static final Config.Option<Integer> OPTION_MIN_LOGGING_LEVEL;
    static final Config.Option<QuirkSettings> OPTION_QUIRK_SETTINGS;
    static final Config.Option<Boolean> OPTION_REPEATING_STREAM_FORCED;
    private final OptionsBundle mConfig;
    static final Config.Option<CameraFactory.Provider> OPTION_CAMERA_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
    static final Config.Option<CameraDeviceSurfaceManager.Provider> OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config.Option.create("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
    static final Config.Option<UseCaseConfigFactory.Provider> OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
    static final Config.Option<Executor> OPTION_CAMERA_EXECUTOR = Config.Option.create("camerax.core.appConfig.cameraExecutor", Executor.class);
    static final Config.Option<Handler> OPTION_SCHEDULER_HANDLER = Config.Option.create("camerax.core.appConfig.schedulerHandler", Handler.class);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder implements TargetConfig.Builder<CameraX, Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder() {
            this(MutableOptionsBundle.create());
        }

        public static Builder fromConfig(CameraXConfig cameraXConfig) {
            return new Builder(MutableOptionsBundle.from((Config) cameraXConfig));
        }

        public CameraXConfig build() {
            return new CameraXConfig(OptionsBundle.from(this.mMutableConfig));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public Builder setAvailableCamerasLimiter(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_AVAILABLE_CAMERAS_LIMITER, cameraSelector);
            return this;
        }

        public Builder setCameraExecutor(Executor executor) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_EXECUTOR, executor);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCameraFactoryProvider(CameraFactory.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER, provider);
            return this;
        }

        public Builder setCameraOpenRetryMaxTimeoutInMillisWhileResuming(long j) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, Long.valueOf(j));
            return this;
        }

        @ExperimentalRetryPolicy
        public Builder setCameraProviderInitRetryPolicy(RetryPolicy retryPolicy) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, retryPolicy);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setConfigImplType(int i2) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CONFIG_IMPL_TYPE, Integer.valueOf(i2));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, provider);
            return this;
        }

        public Builder setMinimumLoggingLevel(@IntRange(from = 3, to = 6) int i2) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, Integer.valueOf(i2));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setQuirkSettings(QuirkSettings quirkSettings) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_QUIRK_SETTINGS, quirkSettings);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setRepeatingStreamForced(boolean z2) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_REPEATING_STREAM_FORCED, Boolean.valueOf(z2));
            return this;
        }

        public Builder setSchedulerHandler(Handler handler) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_SCHEDULER_HANDLER, handler);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, provider);
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(CameraX.class)) {
                setTargetClass(CameraX.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(Class<CameraX> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImplType {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Provider {
        CameraXConfig getCameraXConfig();
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_MIN_LOGGING_LEVEL = Config.Option.create("camerax.core.appConfig.minimumLoggingLevel", cls);
        OPTION_AVAILABLE_CAMERAS_LIMITER = Config.Option.create("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
        OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = Config.Option.create("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);
        OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = Config.Option.create("camerax.core.appConfig.cameraProviderInitRetryPolicy", RetryPolicy.class);
        OPTION_QUIRK_SETTINGS = Config.Option.create("camerax.core.appConfig.quirksSettings", QuirkSettings.class);
        OPTION_CONFIG_IMPL_TYPE = Config.Option.create("camerax.core.appConfig.configImplType", cls);
        OPTION_REPEATING_STREAM_FORCED = Config.Option.create("camerax.core.appConfig.repeatingStreamForced", Boolean.TYPE);
    }

    public CameraXConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option option) {
        return androidx.camera.core.impl.w.a(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        androidx.camera.core.impl.w.b(this, str, optionMatcher);
    }

    public CameraSelector getAvailableCamerasLimiter(CameraSelector cameraSelector) {
        return (CameraSelector) this.mConfig.retrieveOption(OPTION_AVAILABLE_CAMERAS_LIMITER, cameraSelector);
    }

    public Executor getCameraExecutor(Executor executor) {
        return (Executor) this.mConfig.retrieveOption(OPTION_CAMERA_EXECUTOR, executor);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraFactory.Provider getCameraFactoryProvider(CameraFactory.Provider provider) {
        return (CameraFactory.Provider) this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER, provider);
    }

    public long getCameraOpenRetryMaxTimeoutInMillisWhileResuming() {
        return ((Long) this.mConfig.retrieveOption(OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, -1L)).longValue();
    }

    @ExperimentalRetryPolicy
    public RetryPolicy getCameraProviderInitRetryPolicy() {
        RetryPolicy retryPolicy = (RetryPolicy) this.mConfig.retrieveOption(OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, RetryPolicy.DEFAULT);
        Objects.requireNonNull(retryPolicy);
        return retryPolicy;
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Config getConfig() {
        return this.mConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getConfigImplType() {
        return ((Integer) this.mConfig.retrieveOption(OPTION_CONFIG_IMPL_TYPE, -1)).intValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraDeviceSurfaceManager.Provider getDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider provider) {
        return (CameraDeviceSurfaceManager.Provider) this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, provider);
    }

    public int getMinimumLoggingLevel() {
        return ((Integer) this.mConfig.retrieveOption(OPTION_MIN_LOGGING_LEVEL, 3)).intValue();
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return androidx.camera.core.impl.w.c(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option option) {
        return androidx.camera.core.impl.w.d(this, option);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public QuirkSettings getQuirkSettings() {
        return (QuirkSettings) this.mConfig.retrieveOption(OPTION_QUIRK_SETTINGS, null);
    }

    public Handler getSchedulerHandler(Handler handler) {
        return (Handler) this.mConfig.retrieveOption(OPTION_SCHEDULER_HANDLER, handler);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass() {
        return androidx.camera.core.internal.f.a(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return androidx.camera.core.internal.f.c(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfigFactory.Provider getUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider provider) {
        return (UseCaseConfigFactory.Provider) this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER, provider);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRepeatingStreamForced() {
        return ((Boolean) this.mConfig.retrieveOption(OPTION_REPEATING_STREAM_FORCED, Boolean.TRUE)).booleanValue();
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return androidx.camera.core.impl.w.e(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option option) {
        return androidx.camera.core.impl.w.f(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
        return androidx.camera.core.impl.w.h(this, option, optionPriority);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass(Class<CameraX> cls) {
        return androidx.camera.core.internal.f.b(this, cls);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String str) {
        return androidx.camera.core.internal.f.d(this, str);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return androidx.camera.core.impl.w.g(this, option, obj);
    }
}
