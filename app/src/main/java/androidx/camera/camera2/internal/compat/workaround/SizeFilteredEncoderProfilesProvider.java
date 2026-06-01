package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SizeFilteredEncoderProfilesProvider implements EncoderProfilesProvider {
    private final Map<Integer, EncoderProfilesProxy> encoderProfilesCache;
    private final EncoderProfilesProvider provider;
    private final List<Size> supportedSizes;

    public SizeFilteredEncoderProfilesProvider(EncoderProfilesProvider provider, List<Size> supportedSizes) {
        k.e(provider, "provider");
        k.e(supportedSizes, "supportedSizes");
        this.provider = provider;
        this.supportedSizes = supportedSizes;
        this.encoderProfilesCache = new LinkedHashMap();
    }

    private final EncoderProfilesProxy findFirstAvailableProfile(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            EncoderProfilesProxy all = getAll(it.next().intValue());
            if (all != null) {
                return all;
            }
        }
        return null;
    }

    private final boolean isResolutionSupported(EncoderProfilesProxy encoderProfilesProxy) {
        if (this.supportedSizes.isEmpty() || encoderProfilesProxy.getVideoProfiles().isEmpty()) {
            return false;
        }
        return this.supportedSizes.contains(encoderProfilesProxy.getVideoProfiles().get(0).getResolution());
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        EncoderProfilesProxy encoderProfilesProxyFindFirstAvailableProfile = null;
        if (!this.provider.hasProfile(i2)) {
            return null;
        }
        if (this.encoderProfilesCache.containsKey(Integer.valueOf(i2))) {
            return this.encoderProfilesCache.get(Integer.valueOf(i2));
        }
        EncoderProfilesProxy all = this.provider.getAll(i2);
        if (all != null && !isResolutionSupported(all)) {
            if (i2 == 0) {
                List<Integer> QUALITY_HIGH_TO_LOW = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW;
                k.d(QUALITY_HIGH_TO_LOW, "QUALITY_HIGH_TO_LOW");
                encoderProfilesProxyFindFirstAvailableProfile = findFirstAvailableProfile(l.i1(QUALITY_HIGH_TO_LOW));
            } else if (i2 == 1) {
                List<Integer> QUALITY_HIGH_TO_LOW2 = EncoderProfilesProvider.QUALITY_HIGH_TO_LOW;
                k.d(QUALITY_HIGH_TO_LOW2, "QUALITY_HIGH_TO_LOW");
                encoderProfilesProxyFindFirstAvailableProfile = findFirstAvailableProfile(QUALITY_HIGH_TO_LOW2);
            }
            all = encoderProfilesProxyFindFirstAvailableProfile;
        }
        this.encoderProfilesCache.put(Integer.valueOf(i2), all);
        return all;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return getAll(i2) != null;
    }
}
