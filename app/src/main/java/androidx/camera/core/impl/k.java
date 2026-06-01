package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUseCaseAdapterProvider;
import androidx.camera.core.Logger;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.impl.utils.RangeUtil;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k {
    public static Set a(CameraInfoInternal cameraInfoInternal) {
        return Collections.EMPTY_SET;
    }

    public static CameraIdentifier b(CameraInfoInternal cameraInfoInternal) {
        return CameraIdentifier.create(cameraInfoInternal.getCameraId());
    }

    public static CameraSelector c(CameraInfoInternal cameraInfoInternal) {
        return new CameraSelector.Builder().addCameraFilter(new j(cameraInfoInternal, 0)).addCameraFilter(new LensFacingCameraFilter(cameraInfoInternal.getLensFacing())).build();
    }

    public static Set e(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig) {
        try {
            int maxSupportedFrameRate = UseCaseAdditionSimulator.simulateAddUseCases(cameraInfoInternal, sessionConfig, true).getPrimaryStreamSpecResult().getMaxSupportedFrameRate();
            Set<Range<Integer>> setFilterFixedRanges = sessionConfig.getSessionType() == 1 ? RangeUtil.filterFixedRanges(cameraInfoInternal.getSupportedHighSpeedFrameRateRanges()) : cameraInfoInternal.getSupportedFrameRateRanges();
            if (setFilterFixedRanges.isEmpty()) {
                return Collections.EMPTY_SET;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Range<Integer> range : setFilterFixedRanges) {
                if (((Integer) range.getUpper()).intValue() <= maxSupportedFrameRate) {
                    linkedHashSet.add(range);
                }
            }
            return linkedHashSet;
        } catch (Throwable th) {
            Logger.w("CameraInfoInternal", "Failed to get max supported frameRate by SessionConfig: " + sessionConfig, th);
            return Collections.EMPTY_SET;
        }
    }

    public static boolean f(CameraInfoInternal cameraInfoInternal) {
        return false;
    }

    public static boolean g(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig) {
        try {
            UseCaseAdditionSimulator.simulateAddUseCases(cameraInfoInternal, sessionConfig, false);
            return true;
        } catch (CameraUseCaseAdapter.CameraException | IllegalArgumentException e) {
            Logger.d("CameraInfoInternal", "CameraInfoInternal.isResolvedFeatureGroupSupported failed", e);
            return false;
        }
    }

    public static boolean h(CameraInfoInternal cameraInfoInternal) {
        return false;
    }

    public static boolean i(CameraInfoInternal cameraInfoInternal, ResolvedFeatureGroup resolvedFeatureGroup, androidx.camera.core.SessionConfig sessionConfig) {
        for (GroupableFeature groupableFeature : resolvedFeatureGroup.getFeatures()) {
            if (!groupableFeature.isSupportedIndividually(cameraInfoInternal, sessionConfig)) {
                Logger.d("CameraInfoInternal", groupableFeature + " is not supported.");
                return false;
            }
        }
        try {
            UseCaseAdditionSimulator.simulateAddUseCases(cameraInfoInternal, sessionConfig, false, resolvedFeatureGroup);
            return true;
        } catch (CameraUseCaseAdapter.CameraException | IllegalArgumentException e) {
            Logger.d("CameraInfoInternal", "CameraInfoInternal.isResolvedFeatureGroupSupported failed", e);
            return false;
        }
    }

    public static boolean j(CameraInfoInternal cameraInfoInternal, List list) {
        return cameraInfoInternal.isUseCaseCombinationSupported(list, 0);
    }

    public static boolean k(CameraInfoInternal cameraInfoInternal, List list, int i2) {
        return cameraInfoInternal.isUseCaseCombinationSupported(list, i2, false);
    }

    public static boolean l(CameraInfoInternal cameraInfoInternal, List list, int i2, boolean z2) {
        return cameraInfoInternal.isUseCaseCombinationSupported(list, i2, z2, CameraConfigs.defaultConfig());
    }

    public static boolean m(CameraInfoInternal cameraInfoInternal, List list, int i2, boolean z2, CameraConfig cameraConfig) {
        return false;
    }

    public static void n(CameraInfoInternal cameraInfoInternal, CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider) {
        UseCaseAdditionSimulator.setCameraUseCaseAdapterProvider(cameraUseCaseAdapterProvider);
    }

    public static /* synthetic */ List o(CameraInfoInternal cameraInfoInternal, List list) {
        String cameraId = cameraInfoInternal.getCameraId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it.next();
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal);
            if (((CameraInfoInternal) cameraInfo).getCameraId().equals(cameraId)) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalStateException(a1.a.m("Unable to find camera with id ", cameraId, " from list of available cameras."));
    }

    public static CameraInfoInternal d(CameraInfoInternal cameraInfoInternal) {
        return cameraInfoInternal;
    }
}
