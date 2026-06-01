package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.impl.advanced.AdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.AutoAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.BeautyAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.BokehAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.HdrAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.NightAdvancedExtenderImpl;
import androidx.camera.extensions.internal.compat.workaround.ExtensionDisabledValidator;
import androidx.camera.extensions.internal.sessionprocessor.AdvancedSessionProcessor;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AdvancedVendorExtender implements VendorExtender {
    private static final String TAG = "AdvancedVendorExtender";
    private final AdvancedExtenderImpl mAdvancedExtenderImpl;
    private String mCameraId;
    private final ExtensionDisabledValidator mExtensionDisabledValidator;
    private final int mMode;

    public AdvancedVendorExtender(int i2) {
        this.mExtensionDisabledValidator = new ExtensionDisabledValidator();
        try {
            if (i2 == 1) {
                this.mAdvancedExtenderImpl = new BokehAdvancedExtenderImpl();
            } else if (i2 == 2) {
                this.mAdvancedExtenderImpl = new HdrAdvancedExtenderImpl();
            } else if (i2 == 3) {
                this.mAdvancedExtenderImpl = new NightAdvancedExtenderImpl();
            } else if (i2 == 4) {
                this.mAdvancedExtenderImpl = new BeautyAdvancedExtenderImpl();
            } else {
                if (i2 != 5) {
                    throw new IllegalArgumentException("Should not active ExtensionMode.NONE");
                }
                this.mAdvancedExtenderImpl = new AutoAdvancedExtenderImpl();
            }
            this.mMode = i2;
        } catch (NoClassDefFoundError unused) {
            throw new IllegalArgumentException("AdvancedExtenderImpl does not exist");
        }
    }

    private List<Pair<Integer, Size[]>> convertResolutionMapToList(Map<Integer, List<Size>> map) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : map.keySet()) {
            arrayList.add(new Pair(num, (Size[]) map.get(num).toArray(new Size[0])));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private List<CaptureRequest.Key<?>> getSupportedParameterKeys() {
        ArrayList arrayList = new ArrayList();
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_3) >= 0) {
            try {
                Iterator it = this.mAdvancedExtenderImpl.getAvailableCaptureRequestKeys().iterator();
                while (it.hasNext()) {
                    arrayList.add((CaptureRequest.Key) it.next());
                }
            } catch (Throwable th) {
                Logger.e(TAG, "Failed to retrieve available characteristics key-values!", th);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public SessionProcessor createSessionProcessor(Context context) {
        Preconditions.checkNotNull(this.mCameraId, "VendorExtender#init() must be called first");
        return new AdvancedSessionProcessor(this.mAdvancedExtenderImpl.createSessionProcessor(), getSupportedParameterKeys(), this, context, this.mMode);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<CameraCharacteristics.Key, Object>> getAvailableCharacteristicsKeyValues() {
        List<Pair<CameraCharacteristics.Key, Object>> availableCharacteristicsKeyValues;
        Version version = Version.VERSION_1_5;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return Collections.EMPTY_LIST;
        }
        try {
            availableCharacteristicsKeyValues = this.mAdvancedExtenderImpl.getAvailableCharacteristicsKeyValues();
        } catch (Throwable th) {
            Logger.e(TAG, "Failed to retrieve available characteristics key-values!", th);
            availableCharacteristicsKeyValues = null;
        }
        return availableCharacteristicsKeyValues == null ? Collections.EMPTY_LIST : availableCharacteristicsKeyValues;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Range<Long> getEstimatedCaptureLatencyRange(Size size) {
        Preconditions.checkNotNull(this.mCameraId, "VendorExtender#init() must be called first");
        try {
            return this.mAdvancedExtenderImpl.getEstimatedCaptureLatencyRange(this.mCameraId, size, 256);
        } catch (Throwable th) {
            Logger.e(TAG, "AdvancedExtenderImpl.getEstimatedCaptureLatencyRange throws exceptions", th);
            return null;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions() {
        Preconditions.checkNotNull(this.mCameraId, "VendorExtender#init() must be called first");
        try {
            return convertResolutionMapToList(this.mAdvancedExtenderImpl.getSupportedCaptureOutputResolutions(this.mCameraId));
        } catch (Throwable th) {
            Logger.e(TAG, "AdvancedExtenderImpl.getSupportedCaptureOutputResolutions throws exceptions", th);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<CaptureResult.Key> getSupportedCaptureResultKeys() {
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_3) >= 0) {
            try {
                return Collections.unmodifiableList(this.mAdvancedExtenderImpl.getAvailableCaptureResultKeys());
            } catch (Throwable th) {
                Logger.e(TAG, "AdvancedExtenderImpl.getAvailableCaptureResultKeys throws exceptions", th);
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Map<Integer, List<Size>> getSupportedPostviewResolutions(Size size) {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            try {
                return Collections.unmodifiableMap(this.mAdvancedExtenderImpl.getSupportedPostviewResolutions(size));
            } catch (Throwable th) {
                Logger.e(TAG, "AdvancedExtenderImpl.getSupportedPostviewResolutions throws exceptions", th);
            }
        }
        return Collections.EMPTY_MAP;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions() {
        Preconditions.checkNotNull(this.mCameraId, "VendorExtender#init() must be called first");
        try {
            return convertResolutionMapToList(this.mAdvancedExtenderImpl.getSupportedPreviewOutputResolutions(this.mCameraId));
        } catch (Throwable th) {
            Logger.e(TAG, "AdvancedExtenderImpl.getSupportedPreviewOutputResolutions throws exceptions", th);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Size[] getSupportedYuvAnalysisResolutions() {
        Preconditions.checkNotNull(this.mCameraId, "VendorExtender#init() must be called first");
        return new Size[0];
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public void init(CameraInfo cameraInfo) {
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        this.mCameraId = cameraInfoInternal.getCameraId();
        this.mAdvancedExtenderImpl.init(this.mCameraId, ExtensionsUtils.getCameraCharacteristicsMap(cameraInfoInternal));
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isCaptureProcessProgressAvailable() {
        Version version = Version.VERSION_1_4;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return false;
        }
        try {
            return this.mAdvancedExtenderImpl.isCaptureProcessProgressAvailable();
        } catch (Throwable th) {
            Logger.e(TAG, "AdvancedExtenderImpl.isCaptureProcessProgressAvailable throws exceptions", th);
            return false;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isCurrentExtensionModeAvailable() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version) && Build.VERSION.SDK_INT >= 34) {
            return getSupportedCaptureResultKeys().contains(CaptureResult.EXTENSION_CURRENT_TYPE);
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionAvailable(String str, Map<String, CameraCharacteristics> map) {
        if (this.mExtensionDisabledValidator.shouldDisableExtension(str)) {
            return false;
        }
        return this.mAdvancedExtenderImpl.isExtensionAvailable(str, map);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionStrengthAvailable() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version) && Build.VERSION.SDK_INT >= 34) {
            return getSupportedParameterKeys().contains(CaptureRequest.EXTENSION_STRENGTH);
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isPostviewAvailable() {
        Version version = Version.VERSION_1_4;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return false;
        }
        try {
            return this.mAdvancedExtenderImpl.isPostviewAvailable();
        } catch (Throwable th) {
            Logger.e(TAG, "AdvancedExtenderImpl.isPostviewAvailable throws exceptions", th);
            return false;
        }
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public final /* synthetic */ boolean willReceiveOnCaptureCompleted() {
        return a.o(this);
    }

    @VisibleForTesting
    public AdvancedVendorExtender(AdvancedExtenderImpl advancedExtenderImpl) {
        this.mExtensionDisabledValidator = new ExtensionDisabledValidator();
        this.mAdvancedExtenderImpl = advancedExtenderImpl;
        this.mMode = 0;
    }
}
