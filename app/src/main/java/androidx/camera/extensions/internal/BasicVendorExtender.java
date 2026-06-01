package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.impl.AutoImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.AutoPreviewExtenderImpl;
import androidx.camera.extensions.impl.BeautyImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.BeautyPreviewExtenderImpl;
import androidx.camera.extensions.impl.BokehImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.BokehPreviewExtenderImpl;
import androidx.camera.extensions.impl.HdrImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.HdrPreviewExtenderImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.NightImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.NightPreviewExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import androidx.camera.extensions.internal.compat.workaround.AvailableKeysRetriever;
import androidx.camera.extensions.internal.compat.workaround.ExtensionDisabledValidator;
import androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class BasicVendorExtender implements VendorExtender {
    private static final String TAG = "BasicVendorExtender";
    static final List<CaptureRequest.Key<?>> sBaseSupportedKeys;
    private AvailableKeysRetriever mAvailableKeysRetriever;
    private CameraCharacteristics mCameraCharacteristics;
    private String mCameraId;
    private CameraInfoInternal mCameraInfo;
    private final ExtensionDisabledValidator mExtensionDisabledValidator;
    private ImageCaptureExtenderImpl mImageCaptureExtenderImpl;
    private final int mMode;
    private PreviewExtenderImpl mPreviewExtenderImpl;

    static {
        ArrayList arrayList = new ArrayList(Arrays.asList(CaptureRequest.SCALER_CROP_REGION, CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_TRIGGER, CaptureRequest.CONTROL_AF_REGIONS, CaptureRequest.CONTROL_AE_REGIONS, CaptureRequest.CONTROL_AWB_REGIONS, CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, CaptureRequest.FLASH_MODE, CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION));
        sBaseSupportedKeys = arrayList;
        if (Build.VERSION.SDK_INT >= 30) {
            arrayList.add(CaptureRequest.CONTROL_ZOOM_RATIO);
        }
    }

    public BasicVendorExtender(int i2) {
        this.mExtensionDisabledValidator = new ExtensionDisabledValidator();
        this.mPreviewExtenderImpl = null;
        this.mImageCaptureExtenderImpl = null;
        this.mAvailableKeysRetriever = new AvailableKeysRetriever();
        this.mMode = i2;
        try {
            if (i2 == 1) {
                this.mPreviewExtenderImpl = new BokehPreviewExtenderImpl();
                this.mImageCaptureExtenderImpl = new BokehImageCaptureExtenderImpl();
                return;
            }
            if (i2 == 2) {
                this.mPreviewExtenderImpl = new HdrPreviewExtenderImpl();
                this.mImageCaptureExtenderImpl = new HdrImageCaptureExtenderImpl();
                return;
            }
            if (i2 == 3) {
                this.mPreviewExtenderImpl = new NightPreviewExtenderImpl();
                this.mImageCaptureExtenderImpl = new NightImageCaptureExtenderImpl();
            } else if (i2 == 4) {
                this.mPreviewExtenderImpl = new BeautyPreviewExtenderImpl();
                this.mImageCaptureExtenderImpl = new BeautyImageCaptureExtenderImpl();
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException("Should not activate ExtensionMode.NONE");
                }
                this.mPreviewExtenderImpl = new AutoPreviewExtenderImpl();
                this.mImageCaptureExtenderImpl = new AutoImageCaptureExtenderImpl();
            }
        } catch (NoClassDefFoundError unused) {
            Logger.e(TAG, "OEM implementation for extension mode " + i2 + "does not exist!");
        }
    }

    private int getCaptureInputImageFormat() {
        ImageCaptureExtenderImpl imageCaptureExtenderImpl = this.mImageCaptureExtenderImpl;
        return (imageCaptureExtenderImpl == null || imageCaptureExtenderImpl.getCaptureProcessor() == null) ? 256 : 35;
    }

    private Size[] getOutputSizes(int i2) {
        return ((StreamConfigurationMap) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(i2);
    }

    private int getPreviewInputImageFormat() {
        PreviewExtenderImpl previewExtenderImpl = this.mPreviewExtenderImpl;
        return (previewExtenderImpl == null || previewExtenderImpl.getProcessorType() != PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_IMAGE_PROCESSOR) ? 34 : 35;
    }

    private List<CaptureRequest.Key<?>> getSupportedParameterKeys(Context context) {
        if (!ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3)) {
            return Collections.unmodifiableList(sBaseSupportedKeys);
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<CaptureRequest.Key> it = this.mAvailableKeysRetriever.getAvailableCaptureRequestKeys(this.mImageCaptureExtenderImpl, this.mCameraId, this.mCameraCharacteristics, context).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            Logger.e(TAG, "ImageCaptureExtenderImpl.getAvailableCaptureRequestKeys throws exceptions", e);
            return Collections.EMPTY_LIST;
        }
    }

    private List<Pair<Integer, Size[]>> getSupportedResolutionsOfFormat(List<Pair<Integer, Size[]>> list, int i2, int i8) {
        ArrayList arrayList = new ArrayList();
        for (Pair<Integer, Size[]> pair : list) {
            if (((Integer) pair.first).intValue() == i2) {
                arrayList.add(new Pair(Integer.valueOf(i2), (Size[]) pair.second));
                return arrayList;
            }
        }
        for (Pair<Integer, Size[]> pair2 : list) {
            if (((Integer) pair2.first).intValue() == i8) {
                arrayList.add(new Pair(Integer.valueOf(i2), (Size[]) pair2.second));
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException(a1.a.h(i2, "Supported resolution should contain ", " format."));
        }
        return arrayList;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public SessionProcessor createSessionProcessor(Context context) {
        Preconditions.checkNotNull(this.mCameraInfo, "VendorExtender#init() must be called first");
        return new BasicExtenderSessionProcessor(this.mPreviewExtenderImpl, this.mImageCaptureExtenderImpl, getSupportedParameterKeys(context), this, context, this.mMode);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public final /* synthetic */ List getAvailableCharacteristicsKeyValues() {
        return a.b(this);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Range<Long> getEstimatedCaptureLatencyRange(Size size) {
        Preconditions.checkNotNull(this.mCameraInfo, "VendorExtender#init() must be called first");
        if (this.mImageCaptureExtenderImpl == null || ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_2) < 0) {
            return null;
        }
        try {
            return this.mImageCaptureExtenderImpl.getEstimatedCaptureLatencyRange(size);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions() {
        Preconditions.checkNotNull(this.mCameraInfo, "VendorExtender#init() must be called first");
        if (this.mImageCaptureExtenderImpl != null && ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_1) >= 0) {
            try {
                List<Pair<Integer, Size[]>> supportedResolutions = this.mImageCaptureExtenderImpl.getSupportedResolutions();
                if (supportedResolutions != null) {
                    return this.mImageCaptureExtenderImpl.getCaptureProcessor() != null ? getSupportedResolutionsOfFormat(supportedResolutions, 35, 256) : supportedResolutions;
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        int captureInputImageFormat = getCaptureInputImageFormat();
        return Arrays.asList(new Pair(Integer.valueOf(captureInputImageFormat), getOutputSizes(captureInputImageFormat)));
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<CaptureResult.Key> getSupportedCaptureResultKeys() {
        if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3)) {
            try {
                List availableCaptureResultKeys = this.mImageCaptureExtenderImpl.getAvailableCaptureResultKeys();
                if (availableCaptureResultKeys != null) {
                    return Collections.unmodifiableList(availableCaptureResultKeys);
                }
            } catch (Exception e) {
                Logger.e(TAG, "ImageCaptureExtenderImpl.getAvailableCaptureResultKeys throws exceptions", e);
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Map<Integer, List<Size>> getSupportedPostviewResolutions(Size size) {
        Version version = Version.VERSION_1_4;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return Collections.EMPTY_MAP;
        }
        List<Pair> supportedPostviewResolutions = this.mImageCaptureExtenderImpl.getSupportedPostviewResolutions(size);
        HashMap map = new HashMap();
        for (Pair pair : supportedPostviewResolutions) {
            Integer num = (Integer) pair.first;
            num.intValue();
            map.put(num, Arrays.asList((Size[]) pair.second));
        }
        return Collections.unmodifiableMap(map);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions() {
        Preconditions.checkNotNull(this.mCameraInfo, "VendorExtender#init() must be called first");
        if (this.mPreviewExtenderImpl != null && ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_1) >= 0) {
            try {
                List<Pair<Integer, Size[]>> supportedResolutions = this.mPreviewExtenderImpl.getSupportedResolutions();
                if (supportedResolutions != null) {
                    return getSupportedResolutionsOfFormat(supportedResolutions, 34, 35);
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        return Arrays.asList(new Pair(34, getOutputSizes(getPreviewInputImageFormat())));
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Size[] getSupportedYuvAnalysisResolutions() {
        Preconditions.checkNotNull(this.mCameraInfo, "VendorExtender#init() must be called first");
        return new Size[0];
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public void init(CameraInfo cameraInfo) {
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        this.mCameraInfo = cameraInfoInternal;
        if (this.mPreviewExtenderImpl == null || this.mImageCaptureExtenderImpl == null) {
            return;
        }
        this.mCameraId = cameraInfoInternal.getCameraId();
        CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) this.mCameraInfo.getCameraCharacteristics();
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mPreviewExtenderImpl.init(this.mCameraId, cameraCharacteristics);
        this.mImageCaptureExtenderImpl.init(this.mCameraId, this.mCameraCharacteristics);
        Logger.d(TAG, "PreviewExtender processorType= " + this.mPreviewExtenderImpl.getProcessorType());
        Logger.d(TAG, "ImageCaptureExtender processor= " + this.mImageCaptureExtenderImpl.getCaptureProcessor());
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isCaptureProcessProgressAvailable() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return this.mImageCaptureExtenderImpl.isCaptureProcessProgressAvailable();
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public final /* synthetic */ boolean isCurrentExtensionModeAvailable() {
        return a.k(this);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionAvailable(String str, Map<String, CameraCharacteristics> map) {
        if (!this.mExtensionDisabledValidator.shouldDisableExtension(str) && this.mPreviewExtenderImpl != null && this.mImageCaptureExtenderImpl != null) {
            CameraCharacteristics cameraCharacteristics = map.get(str);
            if (this.mPreviewExtenderImpl.isExtensionAvailable(str, cameraCharacteristics) && this.mImageCaptureExtenderImpl.isExtensionAvailable(str, cameraCharacteristics)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionStrengthAvailable() {
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isPostviewAvailable() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return this.mImageCaptureExtenderImpl.isPostviewAvailable();
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public final /* synthetic */ boolean willReceiveOnCaptureCompleted() {
        return a.o(this);
    }

    @VisibleForTesting
    public BasicVendorExtender(ImageCaptureExtenderImpl imageCaptureExtenderImpl, PreviewExtenderImpl previewExtenderImpl) {
        this.mExtensionDisabledValidator = new ExtensionDisabledValidator();
        this.mPreviewExtenderImpl = null;
        this.mImageCaptureExtenderImpl = null;
        this.mAvailableKeysRetriever = new AvailableKeysRetriever();
        this.mPreviewExtenderImpl = previewExtenderImpl;
        this.mImageCaptureExtenderImpl = imageCaptureExtenderImpl;
        this.mMode = 0;
    }
}
