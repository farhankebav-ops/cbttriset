package androidx.camera.camera2.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Size;
import android.view.SurfaceHolder;
import androidx.activity.j;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.c;
import androidx.appcompat.app.d;
import androidx.camera.camera2.internal.CameraUnavailableExceptionHelper;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompat;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import com.ironsource.C2300e4;
import com.vungle.ads.internal.protos.Sdk;
import d7.i;
import e6.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import q5.f;
import r5.m;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(35)
public final class FeatureCombinationQueryImpl implements FeatureCombinationQuery {
    private static final String FCQ_PLAY_SERVICES_IMPL_KEY = "androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY";
    private static final String TAG = "FeatureCombinationQueryImpl";
    private final f cameraCharacteristics$delegate;
    private final f cameraDeviceSetup$delegate;
    private final f cameraDeviceSetupCompat$delegate;
    private final String cameraId;
    private final CameraManagerCompat cameraManagerCompat;
    private final Context context;
    private final f dynamicRangeProfiles$delegate;
    private final f isDeferredSurfaceSupported$delegate;
    public static final Companion Companion = new Companion(null);
    private static final FeatureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1 NO_OP_CALLBACK = new CameraCaptureSession.StateCallback() { // from class: androidx.camera.camera2.impl.FeatureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession p02) {
            k.e(p02, "p0");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession p02) {
            k.e(p02, "p0");
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public FeatureCombinationQueryImpl(Context context, String cameraId, CameraManagerCompat cameraManagerCompat) {
        k.e(context, "context");
        k.e(cameraId, "cameraId");
        k.e(cameraManagerCompat, "cameraManagerCompat");
        this.context = context;
        this.cameraId = cameraId;
        this.cameraManagerCompat = cameraManagerCompat;
        final int i2 = 0;
        this.cameraDeviceSetupCompat$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.impl.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FeatureCombinationQueryImpl f3360b;

            {
                this.f3360b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return FeatureCombinationQueryImpl.cameraDeviceSetupCompat_delegate$lambda$0(this.f3360b);
                    case 1:
                        return FeatureCombinationQueryImpl.cameraDeviceSetup_delegate$lambda$1(this.f3360b);
                    case 2:
                        return FeatureCombinationQueryImpl.cameraCharacteristics_delegate$lambda$2(this.f3360b);
                    case 3:
                        return FeatureCombinationQueryImpl.dynamicRangeProfiles_delegate$lambda$3(this.f3360b);
                    default:
                        return Boolean.valueOf(FeatureCombinationQueryImpl.isDeferredSurfaceSupported_delegate$lambda$4(this.f3360b));
                }
            }
        });
        final int i8 = 1;
        this.cameraDeviceSetup$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.impl.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FeatureCombinationQueryImpl f3360b;

            {
                this.f3360b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i8) {
                    case 0:
                        return FeatureCombinationQueryImpl.cameraDeviceSetupCompat_delegate$lambda$0(this.f3360b);
                    case 1:
                        return FeatureCombinationQueryImpl.cameraDeviceSetup_delegate$lambda$1(this.f3360b);
                    case 2:
                        return FeatureCombinationQueryImpl.cameraCharacteristics_delegate$lambda$2(this.f3360b);
                    case 3:
                        return FeatureCombinationQueryImpl.dynamicRangeProfiles_delegate$lambda$3(this.f3360b);
                    default:
                        return Boolean.valueOf(FeatureCombinationQueryImpl.isDeferredSurfaceSupported_delegate$lambda$4(this.f3360b));
                }
            }
        });
        final int i9 = 2;
        this.cameraCharacteristics$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.impl.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FeatureCombinationQueryImpl f3360b;

            {
                this.f3360b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i9) {
                    case 0:
                        return FeatureCombinationQueryImpl.cameraDeviceSetupCompat_delegate$lambda$0(this.f3360b);
                    case 1:
                        return FeatureCombinationQueryImpl.cameraDeviceSetup_delegate$lambda$1(this.f3360b);
                    case 2:
                        return FeatureCombinationQueryImpl.cameraCharacteristics_delegate$lambda$2(this.f3360b);
                    case 3:
                        return FeatureCombinationQueryImpl.dynamicRangeProfiles_delegate$lambda$3(this.f3360b);
                    default:
                        return Boolean.valueOf(FeatureCombinationQueryImpl.isDeferredSurfaceSupported_delegate$lambda$4(this.f3360b));
                }
            }
        });
        final int i10 = 3;
        this.dynamicRangeProfiles$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.impl.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FeatureCombinationQueryImpl f3360b;

            {
                this.f3360b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i10) {
                    case 0:
                        return FeatureCombinationQueryImpl.cameraDeviceSetupCompat_delegate$lambda$0(this.f3360b);
                    case 1:
                        return FeatureCombinationQueryImpl.cameraDeviceSetup_delegate$lambda$1(this.f3360b);
                    case 2:
                        return FeatureCombinationQueryImpl.cameraCharacteristics_delegate$lambda$2(this.f3360b);
                    case 3:
                        return FeatureCombinationQueryImpl.dynamicRangeProfiles_delegate$lambda$3(this.f3360b);
                    default:
                        return Boolean.valueOf(FeatureCombinationQueryImpl.isDeferredSurfaceSupported_delegate$lambda$4(this.f3360b));
                }
            }
        });
        final int i11 = 4;
        this.isDeferredSurfaceSupported$delegate = n7.b.C(new e6.a(this) { // from class: androidx.camera.camera2.impl.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FeatureCombinationQueryImpl f3360b;

            {
                this.f3360b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i11) {
                    case 0:
                        return FeatureCombinationQueryImpl.cameraDeviceSetupCompat_delegate$lambda$0(this.f3360b);
                    case 1:
                        return FeatureCombinationQueryImpl.cameraDeviceSetup_delegate$lambda$1(this.f3360b);
                    case 2:
                        return FeatureCombinationQueryImpl.cameraCharacteristics_delegate$lambda$2(this.f3360b);
                    case 3:
                        return FeatureCombinationQueryImpl.dynamicRangeProfiles_delegate$lambda$3(this.f3360b);
                    default:
                        return Boolean.valueOf(FeatureCombinationQueryImpl.isDeferredSurfaceSupported_delegate$lambda$4(this.f3360b));
                }
            }
        });
    }

    private final void applyDynamicRange(OutputConfiguration outputConfiguration, SessionConfig.OutputConfig outputConfig) {
        DynamicRangeProfiles dynamicRangeProfiles = getDynamicRangeProfiles();
        if (dynamicRangeProfiles == null) {
            return;
        }
        Long lDynamicRangeToFirstSupportedProfile = DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(outputConfig.getDynamicRange(), dynamicRangeProfiles);
        if (lDynamicRangeToFirstSupportedProfile == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        outputConfiguration.setDynamicRangeProfile(lDynamicRangeToFirstSupportedProfile.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraCharacteristicsCompat cameraCharacteristics_delegate$lambda$2(FeatureCombinationQueryImpl featureCombinationQueryImpl) throws CameraUnavailableException {
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = featureCombinationQueryImpl.cameraManagerCompat.getCameraCharacteristicsCompat(featureCombinationQueryImpl.cameraId);
            k.b(cameraCharacteristicsCompat);
            return cameraCharacteristicsCompat;
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraDeviceSetupCompat cameraDeviceSetupCompat_delegate$lambda$0(FeatureCombinationQueryImpl featureCombinationQueryImpl) {
        return new CameraDeviceSetupCompatFactory(featureCombinationQueryImpl.context).getCameraDeviceSetupCompat(featureCombinationQueryImpl.cameraId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraDevice.CameraDeviceSetup cameraDeviceSetup_delegate$lambda$1(FeatureCombinationQueryImpl featureCombinationQueryImpl) {
        if (featureCombinationQueryImpl.cameraManagerCompat.unwrap().isCameraDeviceSetupSupported(featureCombinationQueryImpl.cameraId)) {
            return featureCombinationQueryImpl.cameraManagerCompat.unwrap().getCameraDeviceSetup(featureCombinationQueryImpl.cameraId);
        }
        return null;
    }

    private final List<CloseableOutputConfiguration> createOutputConfigurations(SessionConfig sessionConfig) {
        CloseableOutputConfiguration concreteOutputConfiguration;
        List<SessionConfig.OutputConfig> outputConfigs = sessionConfig.getOutputConfigs();
        k.d(outputConfigs, "getOutputConfigs(...)");
        ArrayList arrayList = new ArrayList(n.L0(outputConfigs, 10));
        for (SessionConfig.OutputConfig outputConfig : outputConfigs) {
            if (isDeferredSurfaceSupported()) {
                k.b(outputConfig);
                concreteOutputConfiguration = toDeferredOutputConfiguration(outputConfig);
            } else {
                k.b(outputConfig);
                concreteOutputConfiguration = toConcreteOutputConfiguration(outputConfig);
            }
            if (outputConfig.getSurface().getContainerClass() != null) {
                applyDynamicRange(concreteOutputConfiguration.getValue(), outputConfig);
            }
            arrayList.add(concreteOutputConfiguration);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DynamicRangeProfiles dynamicRangeProfiles_delegate$lambda$3(FeatureCombinationQueryImpl featureCombinationQueryImpl) {
        return DynamicRangesCompat.fromCameraCharacteristics(featureCombinationQueryImpl.getCameraCharacteristics()).toDynamicRangeProfiles();
    }

    private final SessionConfiguration getCamera2SessionConfiguration(List<OutputConfiguration> list, SessionConfig sessionConfig) {
        androidx.activity.k.t();
        SessionConfiguration sessionConfigurationK = androidx.activity.k.k(list, CameraXExecutors.directExecutor(), NO_OP_CALLBACK);
        CameraDevice.CameraDeviceSetup cameraDeviceSetup = getCameraDeviceSetup();
        if (cameraDeviceSetup == null) {
            return null;
        }
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDeviceSetup.createCaptureRequest(sessionConfig.getTemplateType());
        builderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, sessionConfig.getExpectedFrameRateRange());
        if (sessionConfig.getRepeatingCaptureConfig().getPreviewStabilizationMode() == 2) {
            builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        }
        sessionConfigurationK.setSessionParameters(builderCreateCaptureRequest.build());
        return sessionConfigurationK;
    }

    private final CameraCharacteristicsCompat getCameraCharacteristics() {
        return (CameraCharacteristicsCompat) this.cameraCharacteristics$delegate.getValue();
    }

    private final CameraDevice.CameraDeviceSetup getCameraDeviceSetup() {
        return a.m(this.cameraDeviceSetup$delegate.getValue());
    }

    private final CameraDeviceSetupCompat getCameraDeviceSetupCompat() {
        return (CameraDeviceSetupCompat) this.cameraDeviceSetupCompat$delegate.getValue();
    }

    private final DynamicRangeProfiles getDynamicRangeProfiles() {
        return j.f(this.dynamicRangeProfiles$delegate.getValue());
    }

    private final Boolean hasPlayServicesDependency() {
        try {
            ServiceInfo[] serviceInfoArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE).services;
            if (serviceInfoArr == null) {
                return Boolean.FALSE;
            }
            i iVarG = d0.g(serviceInfoArr);
            while (iVarG.hasNext()) {
                Bundle bundle = ((ServiceInfo) iVarG.next()).metaData;
                if (bundle != null && bundle.getString(FCQ_PLAY_SERVICES_IMPL_KEY) != null) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final boolean isDeferredSurfaceSupported() {
        return ((Boolean) this.isDeferredSurfaceSupported$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDeferredSurfaceSupported_delegate$lambda$4(FeatureCombinationQueryImpl featureCombinationQueryImpl) {
        return k.a(featureCombinationQueryImpl.hasPlayServicesDependency(), Boolean.FALSE);
    }

    private final CloseableOutputConfiguration toConcreteOutputConfiguration(SessionConfig.OutputConfig outputConfig) {
        Class<?> containerClass = outputConfig.getSurface().getContainerClass();
        long j = k.a(containerClass, MediaCodec.class) ? 65536L : k.a(containerClass, SurfaceHolder.class) ? 2048L : k.a(containerClass, SurfaceTexture.class) ? 256L : 0L;
        Logger.d(TAG, "toConcreteOutputConfiguration: surface containerClass = " + outputConfig.getSurface().getContainerClass() + ", usageFlag = " + j);
        ImageReader imageReaderNewInstance = ImageReader.newInstance(outputConfig.getSurface().getPrescribedSize().getWidth(), outputConfig.getSurface().getPrescribedSize().getHeight(), outputConfig.getSurface().getPrescribedStreamFormat(), 1, j);
        k.d(imageReaderNewInstance, "newInstance(...)");
        c.q();
        return new CloseableOutputConfiguration(c.i(imageReaderNewInstance.getSurface()), imageReaderNewInstance);
    }

    private final CloseableOutputConfiguration toDeferredOutputConfiguration(SessionConfig.OutputConfig outputConfig) {
        OutputConfiguration outputConfigurationQ;
        Class<?> containerClass = outputConfig.getSurface().getContainerClass();
        Logger.d(TAG, "toDeferredOutputConfiguration: surface containerClass = " + outputConfig.getSurface().getContainerClass());
        if (containerClass != null) {
            c.q();
            Size prescribedSize = outputConfig.getSurface().getPrescribedSize();
            if (prescribedSize == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            outputConfigurationQ = d.s(prescribedSize, containerClass);
        } else {
            c.q();
            outputConfigurationQ = a.q(outputConfig.getSurface().getPrescribedStreamFormat(), outputConfig.getSurface().getPrescribedSize());
        }
        return new CloseableOutputConfiguration(outputConfigurationQ, null, 2, 0 == true ? 1 : 0);
    }

    private final String toLogString(SessionConfig sessionConfig) {
        StringBuilder sb = new StringBuilder("sessionParameters=[");
        sb.append("fpsRange=" + sessionConfig.getExpectedFrameRateRange());
        sb.append(", previewStabilizationMode=" + sessionConfig.getRepeatingCaptureConfig().getPreviewStabilizationMode());
        sb.append("], outputConfigurations=[");
        List<SessionConfig.OutputConfig> outputConfigs = sessionConfig.getOutputConfigs();
        k.d(outputConfigs, "getOutputConfigs(...)");
        int i2 = 0;
        for (Object obj : outputConfigs) {
            int i8 = i2 + 1;
            if (i2 < 0) {
                m.K0();
                throw null;
            }
            SessionConfig.OutputConfig outputConfig = (SessionConfig.OutputConfig) obj;
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append("{format=" + outputConfig.getSurface().getPrescribedStreamFormat() + ", size=" + outputConfig.getSurface().getPrescribedSize() + ", dynamicRange=" + outputConfig.getDynamicRange() + ", class=" + outputConfig.getSurface().getContainerClass() + '}');
            i2 = i8;
        }
        sb.append(C2300e4.i.e);
        String string = sb.toString();
        k.d(string, "toString(...)");
        return string;
    }

    private final <T extends AutoCloseable, R> R use(List<? extends T> list, l lVar) throws Exception {
        R r7 = (R) lVar.invoke(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AutoCloseable autoCloseable = (AutoCloseable) it.next();
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
            } else if (autoCloseable instanceof ExecutorService) {
                c.v((ExecutorService) autoCloseable);
            } else if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
        return r7;
    }

    @Override // androidx.camera.core.featuregroup.impl.FeatureCombinationQuery
    public boolean isSupported(SessionConfig sessionConfig) throws Exception {
        k.e(sessionConfig, "sessionConfig");
        List<CloseableOutputConfiguration> listCreateOutputConfigurations = createOutputConfigurations(sessionConfig);
        ArrayList arrayList = new ArrayList(n.L0(listCreateOutputConfigurations, 10));
        Iterator<T> it = listCreateOutputConfigurations.iterator();
        while (it.hasNext()) {
            arrayList.add(((CloseableOutputConfiguration) it.next()).getValue());
        }
        SessionConfiguration camera2SessionConfiguration = getCamera2SessionConfiguration(arrayList, sessionConfig);
        if (camera2SessionConfiguration == null) {
            return false;
        }
        int supported = getCameraDeviceSetupCompat().isSessionConfigurationSupported(camera2SessionConfiguration).getSupported();
        StringBuilder sbV = a1.a.v(supported, "isSupported: supported = ", " for session config with ");
        sbV.append(toLogString(sessionConfig));
        Logger.d(TAG, sbV.toString());
        boolean z2 = supported == 1;
        for (AutoCloseable autoCloseable : listCreateOutputConfigurations) {
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
            } else if (autoCloseable instanceof ExecutorService) {
                c.v((ExecutorService) autoCloseable);
            } else if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
        return z2;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CloseableOutputConfiguration implements AutoCloseable {
        private final ImageReader backingImageReader;
        private final OutputConfiguration value;

        public CloseableOutputConfiguration(OutputConfiguration value, ImageReader imageReader) {
            k.e(value, "value");
            this.value = value;
            this.backingImageReader = imageReader;
        }

        private final ImageReader component2() {
            return this.backingImageReader;
        }

        public static /* synthetic */ CloseableOutputConfiguration copy$default(CloseableOutputConfiguration closeableOutputConfiguration, OutputConfiguration outputConfiguration, ImageReader imageReader, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                outputConfiguration = closeableOutputConfiguration.value;
            }
            if ((i2 & 2) != 0) {
                imageReader = closeableOutputConfiguration.backingImageReader;
            }
            return closeableOutputConfiguration.copy(outputConfiguration, imageReader);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            ImageReader imageReader = this.backingImageReader;
            if (imageReader != null) {
                imageReader.close();
            }
        }

        public final OutputConfiguration component1() {
            return this.value;
        }

        public final CloseableOutputConfiguration copy(OutputConfiguration value, ImageReader imageReader) {
            k.e(value, "value");
            return new CloseableOutputConfiguration(value, imageReader);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloseableOutputConfiguration)) {
                return false;
            }
            CloseableOutputConfiguration closeableOutputConfiguration = (CloseableOutputConfiguration) obj;
            return k.a(this.value, closeableOutputConfiguration.value) && k.a(this.backingImageReader, closeableOutputConfiguration.backingImageReader);
        }

        public final OutputConfiguration getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = this.value.hashCode() * 31;
            ImageReader imageReader = this.backingImageReader;
            return iHashCode + (imageReader == null ? 0 : imageReader.hashCode());
        }

        public String toString() {
            return "CloseableOutputConfiguration(value=" + this.value + ", backingImageReader=" + this.backingImageReader + ')';
        }

        public /* synthetic */ CloseableOutputConfiguration(OutputConfiguration outputConfiguration, ImageReader imageReader, int i2, kotlin.jvm.internal.f fVar) {
            this(outputConfiguration, (i2 & 2) != 0 ? null : imageReader);
        }
    }
}
