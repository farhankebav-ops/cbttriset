package androidx.camera.extensions;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.extensions.ExtensionsConfig;
import androidx.camera.extensions.internal.AdvancedVendorExtender;
import androidx.camera.extensions.internal.BasicVendorExtender;
import androidx.camera.extensions.internal.Camera2ExtensionsInfo;
import androidx.camera.extensions.internal.Camera2ExtensionsUtil;
import androidx.camera.extensions.internal.Camera2ExtensionsVendorExtender;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.ExtensionsUseCaseConfigFactory;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.compat.workaround.PostviewFormatValidator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ExtensionsInfo {
    private static final VendorExtender EMPTY_VENDOR_EXTENDER = new VendorExtender() { // from class: androidx.camera.extensions.ExtensionsInfo.1
        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ SessionProcessor createSessionProcessor(Context context) {
            return androidx.camera.extensions.internal.a.a(this, context);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ List getAvailableCharacteristicsKeyValues() {
            return androidx.camera.extensions.internal.a.b(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ Range getEstimatedCaptureLatencyRange(Size size) {
            return androidx.camera.extensions.internal.a.c(this, size);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ List getSupportedCaptureOutputResolutions() {
            return androidx.camera.extensions.internal.a.d(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ List getSupportedCaptureResultKeys() {
            return androidx.camera.extensions.internal.a.e(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ Map getSupportedPostviewResolutions(Size size) {
            return androidx.camera.extensions.internal.a.f(this, size);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ List getSupportedPreviewOutputResolutions() {
            return androidx.camera.extensions.internal.a.g(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ Size[] getSupportedYuvAnalysisResolutions() {
            return androidx.camera.extensions.internal.a.h(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ void init(CameraInfo cameraInfo) {
            androidx.camera.extensions.internal.a.i(this, cameraInfo);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean isCaptureProcessProgressAvailable() {
            return androidx.camera.extensions.internal.a.j(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean isCurrentExtensionModeAvailable() {
            return androidx.camera.extensions.internal.a.k(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean isExtensionAvailable(String str, Map map) {
            return androidx.camera.extensions.internal.a.l(this, str, map);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean isExtensionStrengthAvailable() {
            return androidx.camera.extensions.internal.a.m(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean isPostviewAvailable() {
            return androidx.camera.extensions.internal.a.n(this);
        }

        @Override // androidx.camera.extensions.internal.VendorExtender
        public final /* synthetic */ boolean willReceiveOnCaptureCompleted() {
            return androidx.camera.extensions.internal.a.o(this);
        }
    };
    private static final String EXTENDED_CAMERA_CONFIG_PROVIDER_ID_PREFIX = ":camera:camera-extensions-";
    private final Camera2ExtensionsInfo mCamera2ExtensionsInfo;
    private final CameraProvider mCameraProvider;
    private final boolean mShouldUseCamera2Extensions;
    private VendorExtenderFactory mVendorExtenderFactory;

    public ExtensionsInfo(CameraProvider cameraProvider, Context context) {
        this.mCameraProvider = cameraProvider;
        if (Build.VERSION.SDK_INT >= 31) {
            this.mCamera2ExtensionsInfo = new Camera2ExtensionsInfo((CameraManager) context.getSystemService(CameraManager.class));
        } else {
            this.mCamera2ExtensionsInfo = null;
        }
        this.mShouldUseCamera2Extensions = Camera2ExtensionsUtil.shouldUseCamera2Extensions(cameraProvider.getConfigImplType());
        this.mVendorExtenderFactory = new c(this);
    }

    private static String getExtendedCameraConfigProviderId(int i2) {
        if (i2 == 0) {
            return ":camera:camera-extensions-EXTENSION_MODE_NONE";
        }
        if (i2 == 1) {
            return ":camera:camera-extensions-EXTENSION_MODE_BOKEH";
        }
        if (i2 == 2) {
            return ":camera:camera-extensions-EXTENSION_MODE_HDR";
        }
        if (i2 == 3) {
            return ":camera:camera-extensions-EXTENSION_MODE_NIGHT";
        }
        if (i2 == 4) {
            return ":camera:camera-extensions-EXTENSION_MODE_FACE_RETOUCH";
        }
        if (i2 == 5) {
            return ":camera:camera-extensions-EXTENSION_MODE_AUTO";
        }
        throw new IllegalArgumentException("Invalid extension mode!");
    }

    private CameraFilter getFilter(int i2) {
        return new ExtensionCameraFilter(getExtendedCameraConfigProviderId(i2), this.mVendorExtenderFactory.createVendorExtender(i2, this.mShouldUseCamera2Extensions));
    }

    private void injectExtensionCameraConfig(final int i2) {
        final Identifier identifierCreate = Identifier.create(getExtendedCameraConfigProviderId(i2));
        if (ExtendedCameraConfigProviderStore.getConfigProvider(identifierCreate) == CameraConfigProvider.EMPTY) {
            ExtendedCameraConfigProviderStore.addConfig(identifierCreate, new CameraConfigProvider() { // from class: androidx.camera.extensions.d
                @Override // androidx.camera.core.impl.CameraConfigProvider
                public final CameraConfig getConfig(CameraInfo cameraInfo, Context context) {
                    return this.f3764a.lambda$injectExtensionCameraConfig$0(i2, identifierCreate, cameraInfo, context);
                }
            });
        }
    }

    private static boolean isAdvancedExtenderSupported() {
        Version version = Version.VERSION_1_1;
        if (ClientVersion.isMaximumCompatibleVersion(version) || ExtensionVersion.isMaximumCompatibleVersion(version)) {
            return false;
        }
        return ExtensionVersion.isAdvancedExtenderSupported();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CameraConfig lambda$injectExtensionCameraConfig$0(int i2, Identifier identifier, CameraInfo cameraInfo, Context context) {
        VendorExtender vendorExtenderCreateVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i2, this.mShouldUseCamera2Extensions);
        vendorExtenderCreateVendorExtender.init(cameraInfo);
        ExtensionsConfig.Builder useCaseCombinationRequiredRule = new ExtensionsConfig.Builder().setExtensionMode(i2).setUseCaseConfigFactory((UseCaseConfigFactory) new ExtensionsUseCaseConfigFactory(vendorExtenderCreateVendorExtender)).setCompatibilityId(identifier).setZslDisabled(true).setPostviewSupported(vendorExtenderCreateVendorExtender.isPostviewAvailable()).setCaptureProcessProgressSupported(vendorExtenderCreateVendorExtender.isCaptureProcessProgressAvailable()).setUseCaseCombinationRequiredRule(1);
        if (this.mShouldUseCamera2Extensions) {
            useCaseCombinationRequiredRule.setPostviewFormatSelector(new PostviewFormatValidator().getPostviewFormatSelector());
        }
        SessionProcessor sessionProcessorCreateSessionProcessor = vendorExtenderCreateVendorExtender.createSessionProcessor(context);
        if (sessionProcessorCreateSessionProcessor != null) {
            useCaseCombinationRequiredRule.setSessionProcessor(sessionProcessorCreateSessionProcessor);
        }
        return useCaseCombinationRequiredRule.build();
    }

    public Range<Long> getEstimatedCaptureLatencyRange(CameraSelector cameraSelector, int i2, Size size) {
        List<CameraInfo> listFilter = CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(getFilter(i2)).build().filter(this.mCameraProvider.getAvailableCameraInfos());
        if (listFilter.isEmpty()) {
            return null;
        }
        CameraInfo cameraInfo = listFilter.get(0);
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_2) < 0) {
            return null;
        }
        try {
            VendorExtender vendorExtenderCreateVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i2, this.mShouldUseCamera2Extensions);
            vendorExtenderCreateVendorExtender.init(cameraInfo);
            return vendorExtenderCreateVendorExtender.getEstimatedCaptureLatencyRange(size);
        } catch (NoSuchMethodError unused) {
            return null;
        }
    }

    public CameraSelector getExtensionCameraSelectorAndInjectCameraConfig(CameraSelector cameraSelector, int i2) {
        if (!isExtensionAvailable(cameraSelector, i2)) {
            throw new IllegalArgumentException("No camera can be found to support the specified extensions mode! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
        }
        Iterator<CameraFilter> it = cameraSelector.getCameraFilterSet().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ExtensionCameraFilter) {
                throw new IllegalArgumentException("An extension is already applied to the base CameraSelector.");
            }
        }
        injectExtensionCameraConfig(i2);
        CameraSelector.Builder builderFromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        builderFromSelector.addCameraFilter(getFilter(i2));
        return builderFromSelector.build();
    }

    public VendorExtender getVendorExtender(int i2, boolean z2) {
        if (!z2) {
            return isAdvancedExtenderSupported() ? new AdvancedVendorExtender(i2) : new BasicVendorExtender(i2);
        }
        if (Build.VERSION.SDK_INT < 33) {
            return EMPTY_VENDOR_EXTENDER;
        }
        Camera2ExtensionsInfo camera2ExtensionsInfo = this.mCamera2ExtensionsInfo;
        Objects.requireNonNull(camera2ExtensionsInfo);
        return new Camera2ExtensionsVendorExtender(i2, camera2ExtensionsInfo);
    }

    public boolean isExtensionAvailable(CameraSelector cameraSelector, int i2) {
        CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(getFilter(i2));
        return !r1.build().filter(this.mCameraProvider.getAvailableCameraInfos()).isEmpty();
    }

    public boolean isImageAnalysisSupported(CameraSelector cameraSelector, int i2) {
        List<CameraInfo> listFilter = CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(getFilter(i2)).build().filter(this.mCameraProvider.getAvailableCameraInfos());
        if (listFilter.isEmpty()) {
            return false;
        }
        CameraInfo cameraInfo = listFilter.get(0);
        VendorExtender vendorExtenderCreateVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i2, this.mShouldUseCamera2Extensions);
        vendorExtenderCreateVendorExtender.init(cameraInfo);
        Size[] supportedYuvAnalysisResolutions = vendorExtenderCreateVendorExtender.getSupportedYuvAnalysisResolutions();
        return supportedYuvAnalysisResolutions != null && supportedYuvAnalysisResolutions.length > 0;
    }

    @VisibleForTesting
    public void setVendorExtenderFactory(VendorExtenderFactory vendorExtenderFactory) {
        this.mVendorExtenderFactory = vendorExtenderFactory;
    }
}
