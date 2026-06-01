package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.d0;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.extensions.internal.compat.workaround.ExtensionCharacteristicsAccessGuard;
import androidx.camera.extensions.internal.sessionprocessor.Camera2ExtensionsSessionProcessor;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.k;
import r5.l;
import r5.r;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
public final class Camera2ExtensionsVendorExtender implements VendorExtender {
    private final int camera2ExtensionMode;
    private final Camera2ExtensionsInfo camera2ExtensionsInfo;
    private CameraExtensionCharacteristics cameraExtensionCharacteristics;
    private String cameraId;
    private final ExtensionCharacteristicsAccessGuard extensionCharacteristicsAccessGuard;
    private boolean isCurrentExtensionModeSupported;
    private boolean isExtensionStrengthSupported;
    private final Object lock;
    private final int mode;

    public Camera2ExtensionsVendorExtender(int i2, Camera2ExtensionsInfo camera2ExtensionsInfo) {
        k.e(camera2ExtensionsInfo, "camera2ExtensionsInfo");
        this.mode = i2;
        this.camera2ExtensionsInfo = camera2ExtensionsInfo;
        this.extensionCharacteristicsAccessGuard = new ExtensionCharacteristicsAccessGuard();
        this.camera2ExtensionMode = Camera2ExtensionsUtil.INSTANCE.convertCameraXModeToCamera2Mode(i2);
        this.lock = new Object();
    }

    private final void checkInitialized() {
        Preconditions.checkState(this.cameraId != null, "VendorExtender#init() must be called first");
    }

    private final List<CaptureRequest.Key<?>> getAvailableCaptureRequestKeys() {
        ArrayList arrayList = new ArrayList();
        boolean zIsCamera2ExtensionAvailable = isCamera2ExtensionAvailable();
        r rVar = r.f13638a;
        if (!zIsCamera2ExtensionAvailable) {
            return rVar;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
                if (cameraExtensionCharacteristics == null) {
                    k.l("cameraExtensionCharacteristics");
                    throw null;
                }
                Set<CaptureRequest.Key> availableCaptureRequestKeys = cameraExtensionCharacteristics.getAvailableCaptureRequestKeys(this.camera2ExtensionMode);
                k.d(availableCaptureRequestKeys, "getAvailableCaptureRequestKeys(...)");
                for (CaptureRequest.Key key : availableCaptureRequestKeys) {
                    k.b(key);
                    arrayList.add(key);
                }
            } catch (IllegalArgumentException e) {
                Log.e("Camera2ExtExtender", "Failed to retrieve available capture request keys", e);
                return rVar;
            }
        }
        return arrayList;
    }

    private final Size getCamera2ExtensionsMaximumSupportedSize() {
        Camera2ExtensionsInfo camera2ExtensionsInfo = this.camera2ExtensionsInfo;
        String str = this.cameraId;
        if (str == null) {
            k.l("cameraId");
            throw null;
        }
        List<Size> supportedOutputSizes = camera2ExtensionsInfo.getSupportedOutputSizes(str, this.camera2ExtensionMode, 256);
        if (supportedOutputSizes.isEmpty()) {
            Size size = SizeUtil.RESOLUTION_ZERO;
            k.b(size);
            return size;
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea(true);
        Iterator<T> it = supportedOutputSizes.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compareSizesByArea.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return (Size) next;
    }

    private final List<Pair<Integer, Size[]>> getExtensionSupportedSizes(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            try {
                Camera2ExtensionsInfo camera2ExtensionsInfo = this.camera2ExtensionsInfo;
                String str = this.cameraId;
                if (str == null) {
                    k.l("cameraId");
                    throw null;
                }
                Size[] sizeArr = (Size[]) camera2ExtensionsInfo.getSupportedOutputSizes(str, this.camera2ExtensionMode, i2).toArray(new Size[0]);
                if (!(sizeArr.length == 0)) {
                    Pair pairCreate = Pair.create(Integer.valueOf(i2), sizeArr);
                    k.d(pairCreate, "create(...)");
                    arrayList.add(pairCreate);
                }
            } catch (IllegalArgumentException e) {
                Log.e("Camera2ExtExtender", "Failed to retrieve supported output sizes of format " + i2, e);
            }
        }
        return arrayList;
    }

    private final boolean isCamera2ExtensionAvailable() {
        Camera2ExtensionsInfo camera2ExtensionsInfo = this.camera2ExtensionsInfo;
        String str = this.cameraId;
        if (str != null) {
            return camera2ExtensionsInfo.isExtensionAvailable(str, this.camera2ExtensionMode);
        }
        k.l("cameraId");
        throw null;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public SessionProcessor createSessionProcessor(Context context) {
        k.e(context, "context");
        checkInitialized();
        return new Camera2ExtensionsSessionProcessor(getAvailableCaptureRequestKeys(), this.mode, this);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<CameraCharacteristics.Key<?>, Object>> getAvailableCharacteristicsKeyValues() {
        checkInitialized();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 35) {
            CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
            if (cameraExtensionCharacteristics == null) {
                k.l("cameraExtensionCharacteristics");
                throw null;
            }
            Set<CameraCharacteristics.Key> keys = cameraExtensionCharacteristics.getKeys(this.camera2ExtensionMode);
            k.d(keys, "getKeys(...)");
            for (CameraCharacteristics.Key key : keys) {
                CameraExtensionCharacteristics cameraExtensionCharacteristics2 = this.cameraExtensionCharacteristics;
                if (cameraExtensionCharacteristics2 == null) {
                    k.l("cameraExtensionCharacteristics");
                    throw null;
                }
                Object obj = cameraExtensionCharacteristics2.get(this.camera2ExtensionMode, key);
                if (obj != null) {
                    Pair pairCreate = Pair.create(key, obj);
                    k.d(pairCreate, "create(...)");
                    arrayList.add(pairCreate);
                }
            }
        }
        return arrayList;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Range<Long> getEstimatedCaptureLatencyRange(Size size) {
        checkInitialized();
        if (!isCamera2ExtensionAvailable()) {
            return null;
        }
        CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
        if (cameraExtensionCharacteristics == null) {
            k.l("cameraExtensionCharacteristics");
            throw null;
        }
        int i2 = this.camera2ExtensionMode;
        if (size == null) {
            size = getCamera2ExtensionsMaximumSupportedSize();
        }
        return cameraExtensionCharacteristics.getEstimatedCaptureLatencyRangeMillis(i2, size, 256);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions() {
        checkInitialized();
        return isCamera2ExtensionAvailable() ? getExtensionSupportedSizes(new int[]{256, 35, 4101}) : r.f13638a;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<CaptureResult.Key<?>> getSupportedCaptureResultKeys() {
        checkInitialized();
        if (!isCamera2ExtensionAvailable() || Build.VERSION.SDK_INT < 33) {
            return r.f13638a;
        }
        CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
        if (cameraExtensionCharacteristics == null) {
            k.l("cameraExtensionCharacteristics");
            throw null;
        }
        Set availableCaptureResultKeys = cameraExtensionCharacteristics.getAvailableCaptureResultKeys(this.camera2ExtensionMode);
        k.d(availableCaptureResultKeys, "getAvailableCaptureResultKeys(...)");
        return l.n1(availableCaptureResultKeys);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Map<Integer, List<Size>> getSupportedPostviewResolutions(Size captureSize) {
        k.e(captureSize, "captureSize");
        checkInitialized();
        if (!isCamera2ExtensionAvailable()) {
            return s.f13639a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Build.VERSION.SDK_INT >= 34) {
            int[] iArr = {256, 35, 4101};
            for (int i2 = 0; i2 < 3; i2++) {
                int i8 = iArr[i2];
                try {
                    CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
                    if (cameraExtensionCharacteristics == null) {
                        k.l("cameraExtensionCharacteristics");
                        throw null;
                    }
                    List postviewSupportedSizes = cameraExtensionCharacteristics.getPostviewSupportedSizes(this.camera2ExtensionMode, captureSize, i8);
                    k.b(postviewSupportedSizes);
                    if (!postviewSupportedSizes.isEmpty()) {
                        linkedHashMap.put(Integer.valueOf(i8), postviewSupportedSizes);
                    }
                } catch (IllegalArgumentException e) {
                    Log.e("Camera2ExtExtender", "Failed to retrieve postview supported output sizes of format " + i8, e);
                }
            }
        }
        return linkedHashMap;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions() {
        checkInitialized();
        return isCamera2ExtensionAvailable() ? getExtensionSupportedSizes(new int[]{34, 35}) : r.f13638a;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public Size[] getSupportedYuvAnalysisResolutions() {
        checkInitialized();
        Size[] sizeArrH = a.h(this);
        k.d(sizeArrH, "getSupportedYuvAnalysisResolutions(...)");
        return sizeArrH;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public void init(CameraInfo cameraInfo) {
        boolean zContains;
        k.e(cameraInfo, "cameraInfo");
        String cameraId = ((CameraInfoInternal) cameraInfo).getCameraId();
        this.cameraId = cameraId;
        Camera2ExtensionsInfo camera2ExtensionsInfo = this.camera2ExtensionsInfo;
        if (cameraId == null) {
            k.l("cameraId");
            throw null;
        }
        this.cameraExtensionCharacteristics = d0.e(Preconditions.checkNotNull(camera2ExtensionsInfo.getExtensionCharacteristics(cameraId)));
        boolean zContains2 = false;
        if (!isCamera2ExtensionAvailable() || Build.VERSION.SDK_INT < 34) {
            zContains = false;
        } else {
            CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
            if (cameraExtensionCharacteristics == null) {
                k.l("cameraExtensionCharacteristics");
                throw null;
            }
            zContains = cameraExtensionCharacteristics.getAvailableCaptureRequestKeys(this.camera2ExtensionMode).contains(CaptureRequest.EXTENSION_STRENGTH);
        }
        this.isExtensionStrengthSupported = zContains;
        if (isCamera2ExtensionAvailable() && Build.VERSION.SDK_INT >= 34) {
            CameraExtensionCharacteristics cameraExtensionCharacteristics2 = this.cameraExtensionCharacteristics;
            if (cameraExtensionCharacteristics2 == null) {
                k.l("cameraExtensionCharacteristics");
                throw null;
            }
            zContains2 = cameraExtensionCharacteristics2.getAvailableCaptureResultKeys(this.camera2ExtensionMode).contains(CaptureResult.EXTENSION_CURRENT_TYPE);
        }
        this.isCurrentExtensionModeSupported = zContains2;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isCaptureProcessProgressAvailable() {
        checkInitialized();
        if (isCamera2ExtensionAvailable() && Build.VERSION.SDK_INT >= 34 && this.extensionCharacteristicsAccessGuard.allowCaptureProcessProgressAvailabilityCheck()) {
            try {
                CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
                if (cameraExtensionCharacteristics != null) {
                    return cameraExtensionCharacteristics.isCaptureProcessProgressAvailable(this.camera2ExtensionMode);
                }
                k.l("cameraExtensionCharacteristics");
                throw null;
            } catch (IllegalArgumentException e) {
                Log.e("Camera2ExtExtender", "Failed to retrieve capture process progress availability", e);
            }
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isCurrentExtensionModeAvailable() {
        checkInitialized();
        return this.isCurrentExtensionModeSupported;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionAvailable(String cameraId, Map<String, CameraCharacteristics> characteristicsMap) {
        k.e(cameraId, "cameraId");
        k.e(characteristicsMap, "characteristicsMap");
        return this.camera2ExtensionsInfo.isExtensionAvailable(cameraId, this.camera2ExtensionMode);
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isExtensionStrengthAvailable() {
        checkInitialized();
        return this.isExtensionStrengthSupported;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean isPostviewAvailable() {
        checkInitialized();
        if (isCamera2ExtensionAvailable() && Build.VERSION.SDK_INT >= 34 && this.extensionCharacteristicsAccessGuard.allowPostviewAvailabilityCheck()) {
            try {
                CameraExtensionCharacteristics cameraExtensionCharacteristics = this.cameraExtensionCharacteristics;
                if (cameraExtensionCharacteristics != null) {
                    return cameraExtensionCharacteristics.isPostviewAvailable(this.camera2ExtensionMode);
                }
                k.l("cameraExtensionCharacteristics");
                throw null;
            } catch (NoSuchMethodError e) {
                Log.e("Camera2ExtExtender", "Failed to retrieve postview availability", e);
            }
        }
        return false;
    }

    @Override // androidx.camera.extensions.internal.VendorExtender
    public boolean willReceiveOnCaptureCompleted() {
        return a.o(this);
    }
}
