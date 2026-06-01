package androidx.camera.video.internal.workaround;

import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultEncoderProfilesProvider implements EncoderProfilesProvider {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_AUDIO_BITRATE = 96000;
    public static final int DEFAULT_AUDIO_CHANNELS = 1;
    public static final int DEFAULT_AUDIO_CODEC = 3;
    public static final String DEFAULT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static final int DEFAULT_AUDIO_PROFILE = 2;
    public static final int DEFAULT_AUDIO_SAMPLE_RATE = 44100;
    public static final int DEFAULT_DURATION_SECONDS = 60;
    public static final int DEFAULT_OUTPUT_FORMAT = 2;
    public static final int DEFAULT_VIDEO_BITRATE_FHD = 10000000;
    public static final int DEFAULT_VIDEO_BITRATE_HD = 4000000;
    public static final int DEFAULT_VIDEO_BITRATE_SD = 2000000;
    public static final int DEFAULT_VIDEO_BITRATE_UHD = 40000000;
    public static final int DEFAULT_VIDEO_BIT_DEPTH = 8;
    public static final int DEFAULT_VIDEO_CHROMA_SUBSAMPLING = 0;
    public static final int DEFAULT_VIDEO_CODEC = 2;
    public static final int DEFAULT_VIDEO_FRAME_RATE = 30;
    public static final int DEFAULT_VIDEO_HDR_FORMAT = 0;
    public static final String DEFAULT_VIDEO_MIME_TYPE = "video/avc";
    public static final int DEFAULT_VIDEO_PROFILE = -1;
    private final CameraInfoInternal cameraInfo;
    private final Map<Integer, EncoderProfilesProxy> encoderProfilesMap;
    private final f supportedSizes$delegate;
    private final List<Quality> targetQualities;
    private final VideoEncoderInfo.Finder videoEncoderInfoFinder;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultEncoderProfilesProvider(CameraInfoInternal cameraInfo, List<? extends Quality> targetQualities, VideoEncoderInfo.Finder videoEncoderInfoFinder) {
        k.e(cameraInfo, "cameraInfo");
        k.e(targetQualities, "targetQualities");
        k.e(videoEncoderInfoFinder, "videoEncoderInfoFinder");
        this.cameraInfo = cameraInfo;
        this.targetQualities = targetQualities;
        this.videoEncoderInfoFinder = videoEncoderInfoFinder;
        this.supportedSizes$delegate = b.C(new androidx.activity.result.b(this, 2));
        this.encoderProfilesMap = new LinkedHashMap();
    }

    private final EncoderProfilesProxy.AudioProfileProxy createDefaultAudioProfile(int i2, String str, int i8, int i9, int i10, int i11) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxyCreate = EncoderProfilesProxy.AudioProfileProxy.create(i2, str, i8, i9, i10, i11);
        k.d(audioProfileProxyCreate, "create(...)");
        return audioProfileProxyCreate;
    }

    public static /* synthetic */ EncoderProfilesProxy.AudioProfileProxy createDefaultAudioProfile$default(DefaultEncoderProfilesProvider defaultEncoderProfilesProvider, int i2, String str, int i8, int i9, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i2 = 3;
        }
        if ((i12 & 2) != 0) {
            str = DEFAULT_AUDIO_MIME_TYPE;
        }
        if ((i12 & 4) != 0) {
            i8 = DEFAULT_AUDIO_BITRATE;
        }
        if ((i12 & 8) != 0) {
            i9 = DEFAULT_AUDIO_SAMPLE_RATE;
        }
        if ((i12 & 16) != 0) {
            i10 = 1;
        }
        if ((i12 & 32) != 0) {
            i11 = 2;
        }
        int i13 = i10;
        int i14 = i11;
        return defaultEncoderProfilesProvider.createDefaultAudioProfile(i2, str, i8, i9, i13, i14);
    }

    private final EncoderProfilesProxy createDefaultEncoderProfiles(int i2, int i8, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy immutableEncoderProfilesProxyCreate = EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(i2, i8, q.j0(audioProfileProxy), q.j0(videoProfileProxy));
        k.d(immutableEncoderProfilesProxyCreate, "create(...)");
        return immutableEncoderProfilesProxyCreate;
    }

    public static /* synthetic */ EncoderProfilesProxy createDefaultEncoderProfiles$default(DefaultEncoderProfilesProvider defaultEncoderProfilesProvider, int i2, int i8, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = 60;
        }
        if ((i9 & 2) != 0) {
            i8 = 2;
        }
        return defaultEncoderProfilesProvider.createDefaultEncoderProfiles(i2, i8, videoProfileProxy, audioProfileProxy);
    }

    private final EncoderProfilesProxy.VideoProfileProxy createDefaultVideoProfile(int i2, String str, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyCreate = EncoderProfilesProxy.VideoProfileProxy.create(i2, str, i10, i11, i8, i9, i12, i13, i14, i15);
        k.d(videoProfileProxyCreate, "create(...)");
        return videoProfileProxyCreate;
    }

    public static /* synthetic */ EncoderProfilesProxy.VideoProfileProxy createDefaultVideoProfile$default(DefaultEncoderProfilesProvider defaultEncoderProfilesProvider, int i2, String str, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        String str2;
        DefaultEncoderProfilesProvider defaultEncoderProfilesProvider2;
        if ((i16 & 1) != 0) {
            i2 = 2;
        }
        if ((i16 & 2) != 0) {
            str = "video/avc";
        }
        if ((i16 & 32) != 0) {
            i11 = 30;
        }
        if ((i16 & 64) != 0) {
            i12 = -1;
        }
        if ((i16 & 128) != 0) {
            i13 = 8;
        }
        if ((i16 & 256) != 0) {
            i14 = 0;
        }
        if ((i16 & 512) != 0) {
            i17 = 0;
            i20 = i13;
            i18 = i14;
            i22 = i11;
            i19 = i12;
            i24 = i9;
            i21 = i10;
            str2 = str;
            i23 = i8;
            defaultEncoderProfilesProvider2 = defaultEncoderProfilesProvider;
            i25 = i2;
        } else {
            i17 = i15;
            i18 = i14;
            i19 = i12;
            i20 = i13;
            i21 = i10;
            i22 = i11;
            i23 = i8;
            i24 = i9;
            i25 = i2;
            str2 = str;
            defaultEncoderProfilesProvider2 = defaultEncoderProfilesProvider;
        }
        return defaultEncoderProfilesProvider2.createDefaultVideoProfile(i25, str2, i23, i24, i21, i22, i19, i20, i18, i17);
    }

    private final Quality.ConstantQuality find(List<? extends Quality> list, int i2) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Quality quality = (Quality) next;
            k.c(quality, "null cannot be cast to non-null type androidx.camera.video.Quality.ConstantQuality");
            if (((Quality.ConstantQuality) quality).getQualityValue(1) == i2) {
                break;
            }
        }
        if (next instanceof Quality.ConstantQuality) {
            return (Quality.ConstantQuality) next;
        }
        return null;
    }

    private final EncoderProfilesProxy generateEncoderProfiles(int i2) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyGenerateVideoProfiles = generateVideoProfiles(i2);
        if (videoProfileProxyGenerateVideoProfiles == null) {
            return null;
        }
        return createDefaultEncoderProfiles$default(this, 0, 0, videoProfileProxyGenerateVideoProfiles, createDefaultAudioProfile$default(this, 0, null, 0, 0, 0, 0, 63, null), 3, null);
    }

    private final EncoderProfilesProxy.VideoProfileProxy generateVideoProfiles(int i2) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyResolveVideoProfile;
        Quality.ConstantQuality constantQualityFind = find(this.targetQualities, i2);
        if (constantQualityFind == null) {
            return null;
        }
        for (Size size : constantQualityFind.getTypicalSizes()) {
            if (getSupportedSizes().contains(size) && (videoProfileProxyResolveVideoProfile = resolveVideoProfile(size.getWidth(), size.getHeight(), getTypicalBitrate(constantQualityFind))) != null) {
                return videoProfileProxyResolveVideoProfile;
            }
        }
        return null;
    }

    private final EncoderProfilesProxy getProfileInternal(int i2) {
        if (this.encoderProfilesMap.containsKey(Integer.valueOf(i2))) {
            return this.encoderProfilesMap.get(Integer.valueOf(i2));
        }
        EncoderProfilesProxy encoderProfilesProxyGenerateEncoderProfiles = generateEncoderProfiles(i2);
        this.encoderProfilesMap.put(Integer.valueOf(i2), encoderProfilesProxyGenerateEncoderProfiles);
        return encoderProfilesProxyGenerateEncoderProfiles;
    }

    private final List<Size> getSupportedSizes() {
        return (List) this.supportedSizes$delegate.getValue();
    }

    private final int getTypicalBitrate(Quality quality) {
        if (k.a(quality, Quality.UHD)) {
            return DEFAULT_VIDEO_BITRATE_UHD;
        }
        if (k.a(quality, Quality.FHD)) {
            return DEFAULT_VIDEO_BITRATE_FHD;
        }
        if (k.a(quality, Quality.HD)) {
            return DEFAULT_VIDEO_BITRATE_HD;
        }
        if (k.a(quality, Quality.SD)) {
            return DEFAULT_VIDEO_BITRATE_SD;
        }
        throw new IllegalArgumentException("Undefined bitrate for quality: " + quality);
    }

    private final EncoderProfilesProxy.VideoProfileProxy resolveVideoProfile(int i2, int i8, int i9) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyCreateDefaultVideoProfile$default = createDefaultVideoProfile$default(this, 0, null, i2, i8, i9, 0, 0, 0, 0, 0, 995, null);
        VideoEncoderInfo videoEncoderInfoFind = this.videoEncoderInfoFinder.find(videoProfileProxyCreateDefaultVideoProfile$default.getMediaType());
        if (videoEncoderInfoFind == null || !videoEncoderInfoFind.isSizeSupportedAllowSwapping(i2, i8)) {
            return null;
        }
        Integer num = (Integer) videoEncoderInfoFind.getSupportedBitrateRange().clamp(Integer.valueOf(i9));
        if (num != null && num.intValue() == i9) {
            return videoProfileProxyCreateDefaultVideoProfile$default;
        }
        k.b(num);
        return createDefaultVideoProfile$default(this, 0, null, i2, i8, num.intValue(), 0, 0, 0, 0, 0, 995, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List supportedSizes_delegate$lambda$0(DefaultEncoderProfilesProvider defaultEncoderProfilesProvider) {
        return defaultEncoderProfilesProvider.cameraInfo.getSupportedResolutions(34);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int i2) {
        return getProfileInternal(i2);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i2) {
        return getProfileInternal(i2) != null;
    }
}
