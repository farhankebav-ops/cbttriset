package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.camera2.internal.Camera2EncoderProfilesProvider;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.utils.SizeUtil;
import e6.p;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class EncoderProfilesProviderFallback {
    private final p providerFactory;

    public EncoderProfilesProviderFallback() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Camera2EncoderProfilesProvider _init_$lambda$0(String cameraId, Quirks quirks) {
        k.e(cameraId, "cameraId");
        k.e(quirks, "quirks");
        return new Camera2EncoderProfilesProvider(cameraId, quirks);
    }

    private final EncoderProfilesProvider findProviderWithLargestSize(CameraManagerCompat cameraManagerCompat) throws CameraAccessExceptionCompat {
        Object objM;
        List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        try {
            objM = cameraManagerCompat.getCameraIdList();
        } catch (Throwable th) {
            objM = q.M(th);
        }
        EncoderProfilesProvider encoderProfilesProvider = null;
        if (objM instanceof j) {
            objM = null;
        }
        String[] strArr = (String[]) objM;
        if (strArr == null) {
            return null;
        }
        int i2 = 0;
        for (String str : strArr) {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
            k.d(cameraCharacteristicsCompat, "getCameraCharacteristicsCompat(...)");
            Quirks quirks = CameraQuirks.get(str, cameraCharacteristicsCompat);
            k.d(quirks, "get(...)");
            p pVar = this.providerFactory;
            k.b(str);
            EncoderProfilesProvider encoderProfilesProvider2 = (EncoderProfilesProvider) pVar.invoke(str, quirks);
            EncoderProfilesProxy all = encoderProfilesProvider2.getAll(1);
            int area = (all == null || (videoProfiles = all.getVideoProfiles()) == null || (videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) l.Y0(videoProfiles)) == null) ? 0 : SizeUtil.getArea(videoProfileProxy.getWidth(), videoProfileProxy.getHeight());
            if (area > i2) {
                encoderProfilesProvider = encoderProfilesProvider2;
                i2 = area;
            }
        }
        return encoderProfilesProvider;
    }

    private final List<Size> getPrivateFormatSizes(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Size[] outputSizes = cameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(34);
        return outputSizes != null ? r5.j.s0(outputSizes) : r.f13638a;
    }

    private final boolean isExternalCamera(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        return num != null && num.intValue() == 2;
    }

    private final boolean needFallback(CameraCharacteristicsCompat cameraCharacteristicsCompat, EncoderProfilesProvider encoderProfilesProvider) {
        return isExternalCamera(cameraCharacteristicsCompat) && !encoderProfilesProvider.hasProfile(1);
    }

    public final EncoderProfilesProvider resolveProvider(String cameraId, Quirks quirks, CameraManagerCompat cameraManager) throws CameraAccessExceptionCompat {
        EncoderProfilesProvider encoderProfilesProviderFindProviderWithLargestSize;
        k.e(cameraId, "cameraId");
        k.e(quirks, "quirks");
        k.e(cameraManager, "cameraManager");
        CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManager.getCameraCharacteristicsCompat(cameraId);
        k.d(cameraCharacteristicsCompat, "getCameraCharacteristicsCompat(...)");
        EncoderProfilesProvider encoderProfilesProvider = (EncoderProfilesProvider) this.providerFactory.invoke(cameraId, quirks);
        if (needFallback(cameraCharacteristicsCompat, encoderProfilesProvider)) {
            encoderProfilesProviderFindProviderWithLargestSize = findProviderWithLargestSize(cameraManager);
            if (encoderProfilesProviderFindProviderWithLargestSize != null) {
                encoderProfilesProviderFindProviderWithLargestSize = new SizeFilteredEncoderProfilesProvider(encoderProfilesProviderFindProviderWithLargestSize, getPrivateFormatSizes(cameraCharacteristicsCompat));
            }
        } else {
            encoderProfilesProviderFindProviderWithLargestSize = null;
        }
        return encoderProfilesProviderFindProviderWithLargestSize == null ? encoderProfilesProvider : encoderProfilesProviderFindProviderWithLargestSize;
    }

    public EncoderProfilesProviderFallback(p providerFactory) {
        k.e(providerFactory, "providerFactory");
        this.providerFactory = providerFactory;
    }

    public /* synthetic */ EncoderProfilesProviderFallback(p pVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? new a(0) : pVar);
    }
}
