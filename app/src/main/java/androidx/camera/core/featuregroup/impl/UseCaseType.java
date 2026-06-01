package androidx.camera.core.featuregroup.impl;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.view.SurfaceHolder;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.streamsharing.StreamSharing;
import e2.s;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseType {
    private static final /* synthetic */ y5.a $ENTRIES;
    private static final /* synthetic */ UseCaseType[] $VALUES;
    public static final Companion Companion;
    private final int defaultImageFormat;
    private final Class<?> surfaceClass;
    public static final UseCaseType PREVIEW = new UseCaseType("PREVIEW", 0, SurfaceHolder.class, 34);
    public static final UseCaseType IMAGE_CAPTURE = new UseCaseType("IMAGE_CAPTURE", 1, null, 256);
    public static final UseCaseType VIDEO_CAPTURE = new UseCaseType("VIDEO_CAPTURE", 2, MediaCodec.class, 34);
    public static final UseCaseType STREAM_SHARING = new UseCaseType("STREAM_SHARING", 3, SurfaceTexture.class, 34);
    public static final UseCaseType UNDEFINED = new UseCaseType("UNDEFINED", 4, null, 34);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
                try {
                    iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[FeatureTypeInternal.values().length];
                try {
                    iArr2[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final boolean isConfiguredToUseCaseByApp(FeatureTypeInternal featureTypeInternal, UseCase useCase) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[featureTypeInternal.ordinal()];
            if (i2 == 1) {
                return isDynamicRangeConfiguredByApp(useCase);
            }
            if (i2 == 2) {
                return isFpsRangeConfiguredByApp(useCase);
            }
            if (i2 == 3) {
                return isStabilizationModeConfiguredByApp(useCase);
            }
            if (i2 == 4) {
                return isImageFormatConfiguredByApp(useCase);
            }
            throw new s(3);
        }

        private final boolean isDynamicRangeConfiguredByApp(UseCase useCase) {
            return useCase.getAppConfig().hasDynamicRange();
        }

        private final boolean isFpsRangeConfiguredByApp(UseCase useCase) {
            return useCase.getAppConfig().hasTargetFrameRate();
        }

        private final boolean isImageFormatConfiguredByApp(UseCase useCase) {
            return useCase.getAppConfig().containsOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT);
        }

        private final boolean isStabilizationModeConfiguredByApp(UseCase useCase) {
            return useCase.getAppConfig().containsOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE) || useCase.getAppConfig().containsOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE);
        }

        public final FeatureTypeInternal getAppConfiguredGroupableFeatureType$camera_core_release(UseCase useCase) {
            Object next;
            k.e(useCase, "<this>");
            Iterator<E> it = FeatureTypeInternal.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (UseCaseType.Companion.isConfiguredToUseCaseByApp((FeatureTypeInternal) next, useCase)) {
                    break;
                }
            }
            return (FeatureTypeInternal) next;
        }

        public final UseCaseType getFeatureGroupUseCaseType(UseCase useCase) {
            k.e(useCase, "<this>");
            return useCase instanceof Preview ? UseCaseType.PREVIEW : useCase instanceof ImageCapture ? UseCaseType.IMAGE_CAPTURE : CameraUseCaseAdapter.isVideoCapture(useCase) ? UseCaseType.VIDEO_CAPTURE : useCase instanceof StreamSharing ? UseCaseType.STREAM_SHARING : UseCaseType.UNDEFINED;
        }

        private Companion() {
        }

        public final UseCaseType getFeatureGroupUseCaseType(UseCaseConfig<?> useCaseConfig) {
            k.e(useCaseConfig, "<this>");
            int i2 = WhenMappings.$EnumSwitchMapping$0[useCaseConfig.getCaptureType().ordinal()];
            if (i2 == 1) {
                return UseCaseType.IMAGE_CAPTURE;
            }
            if (i2 == 2) {
                return UseCaseType.PREVIEW;
            }
            if (i2 == 3) {
                return UseCaseType.VIDEO_CAPTURE;
            }
            if (i2 != 4) {
                return UseCaseType.UNDEFINED;
            }
            return UseCaseType.STREAM_SHARING;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UseCaseType.values().length];
            try {
                iArr[UseCaseType.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseCaseType.IMAGE_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseCaseType.VIDEO_CAPTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseCaseType.STREAM_SHARING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseCaseType.UNDEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ UseCaseType[] $values() {
        return new UseCaseType[]{PREVIEW, IMAGE_CAPTURE, VIDEO_CAPTURE, STREAM_SHARING, UNDEFINED};
    }

    static {
        UseCaseType[] useCaseTypeArr$values = $values();
        $VALUES = useCaseTypeArr$values;
        $ENTRIES = b.n(useCaseTypeArr$values);
        Companion = new Companion(null);
    }

    private UseCaseType(String str, int i2, Class cls, int i8) {
        this.surfaceClass = cls;
        this.defaultImageFormat = i8;
    }

    public static y5.a getEntries() {
        return $ENTRIES;
    }

    public static final UseCaseType getFeatureGroupUseCaseType(UseCase useCase) {
        return Companion.getFeatureGroupUseCaseType(useCase);
    }

    public static /* synthetic */ int getImageFormat$default(UseCaseType useCaseType, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getImageFormat");
        }
        if ((i2 & 1) != 0) {
            num = null;
        }
        return useCaseType.getImageFormat(num);
    }

    public static UseCaseType valueOf(String str) {
        return (UseCaseType) Enum.valueOf(UseCaseType.class, str);
    }

    public static UseCaseType[] values() {
        return (UseCaseType[]) $VALUES.clone();
    }

    public final int getDefaultImageFormat() {
        return this.defaultImageFormat;
    }

    public final int getImageFormat(Integer num) {
        return (this != IMAGE_CAPTURE || num == null) ? this.defaultImageFormat : num.intValue();
    }

    public final Class<?> getSurfaceClass() {
        return this.surfaceClass;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            return "Preview";
        }
        if (i2 == 2) {
            return "ImageCapture";
        }
        if (i2 == 3) {
            return "VideoCapture";
        }
        if (i2 == 4) {
            return "StreamSharing";
        }
        if (i2 == 5) {
            return "Undefined";
        }
        throw new s(3);
    }

    public static final UseCaseType getFeatureGroupUseCaseType(UseCaseConfig<?> useCaseConfig) {
        return Companion.getFeatureGroupUseCaseType(useCaseConfig);
    }
}
