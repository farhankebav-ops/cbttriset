package androidx.camera.video.internal.workaround;

import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.StretchedVideoResolutionQuirk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class QualityResolutionModifiedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    public QualityResolutionModifiedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mQuirks = quirks;
    }

    private EncoderProfilesProxy createNewEncoderProfiles(EncoderProfilesProxy encoderProfilesProxy, Size size) {
        ArrayList arrayList = new ArrayList();
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfilesProxy.getVideoProfiles().iterator();
        while (it.hasNext()) {
            arrayList.add(generateVideoProfile(it.next(), size));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    private static EncoderProfilesProxy.VideoProfileProxy generateVideoProfile(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, Size size) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), videoProfileProxy.getBitrate(), videoProfileProxy.getFrameRate(), size.getWidth(), size.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    private Size getAlternativeResolution(int i2) {
        for (StretchedVideoResolutionQuirk stretchedVideoResolutionQuirk : this.mQuirks.getAll(StretchedVideoResolutionQuirk.class)) {
            if (stretchedVideoResolutionQuirk != null) {
                return stretchedVideoResolutionQuirk.getAlternativeResolution(i2);
            }
        }
        return null;
    }

    private EncoderProfilesProxy getProfilesInternal(int i2) {
        EncoderProfilesProxy encoderProfilesProxyCreateNewEncoderProfiles;
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i2))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i2));
        }
        if (this.mProvider.hasProfile(i2)) {
            EncoderProfilesProxy all = this.mProvider.getAll(i2);
            Objects.requireNonNull(all);
            encoderProfilesProxyCreateNewEncoderProfiles = all;
            Size alternativeResolution = getAlternativeResolution(i2);
            if (alternativeResolution != null) {
                encoderProfilesProxyCreateNewEncoderProfiles = createNewEncoderProfiles(encoderProfilesProxyCreateNewEncoderProfiles, alternativeResolution);
            }
        } else {
            encoderProfilesProxyCreateNewEncoderProfiles = null;
        }
        this.mEncoderProfilesCache.put(Integer.valueOf(i2), encoderProfilesProxyCreateNewEncoderProfiles);
        return encoderProfilesProxyCreateNewEncoderProfiles;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        return getProfilesInternal(i2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return this.mProvider.hasProfile(i2) && getProfilesInternal(i2) != null;
    }
}
