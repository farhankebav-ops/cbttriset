package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;
import com.onesignal.core.internal.config.InfluenceConfigModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceConfig {
    private static final Map<Integer, ConfigType> CONFIG_TYPES_BY_IMAGE_FORMAT;
    public static final Companion Companion = new Companion(null);
    public static final StreamUseCase DEFAULT_STREAM_USE_CASE = StreamUseCase.DEFAULT;
    private static final ConfigSize[] FEATURE_COMBO_QUERY_SUPPORTED_SIZES = {ConfigSize.S720P_16_9, ConfigSize.S1080P_4_3, ConfigSize.S1080P_16_9, ConfigSize.S1440P_16_9, ConfigSize.UHD, ConfigSize.X_VGA};
    private static final Map<ConfigType, Integer> IMAGE_FORMATS_BY_CONFIG_TYPE;
    private final ConfigSize configSize;
    private final ConfigType configType;
    private final int imageFormat;
    private final StreamUseCase streamUseCase;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public static /* synthetic */ SurfaceConfig create$default(Companion companion, ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                streamUseCase = SurfaceConfig.DEFAULT_STREAM_USE_CASE;
            }
            return companion.create(configType, configSize, streamUseCase);
        }

        public static /* synthetic */ SurfaceConfig transformSurfaceConfig$default(Companion companion, int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8, ConfigSource configSource, StreamUseCase streamUseCase, int i9, Object obj) {
            if ((i9 & 8) != 0) {
                i8 = 0;
            }
            int i10 = i8;
            if ((i9 & 16) != 0) {
                configSource = ConfigSource.CAPTURE_SESSION_TABLES;
            }
            ConfigSource configSource2 = configSource;
            if ((i9 & 32) != 0) {
                streamUseCase = SurfaceConfig.DEFAULT_STREAM_USE_CASE;
            }
            return companion.transformSurfaceConfig(i2, size, surfaceSizeDefinition, i10, configSource2, streamUseCase);
        }

        public final SurfaceConfig create(ConfigType type, ConfigSize size) {
            kotlin.jvm.internal.k.e(type, "type");
            kotlin.jvm.internal.k.e(size, "size");
            return create$default(this, type, size, null, 4, null);
        }

        public final ConfigType getConfigType(int i2) {
            ConfigType configType = (ConfigType) SurfaceConfig.CONFIG_TYPES_BY_IMAGE_FORMAT.get(Integer.valueOf(i2));
            return configType == null ? ConfigType.PRIV : configType;
        }

        public final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition) {
            kotlin.jvm.internal.k.e(size, "size");
            kotlin.jvm.internal.k.e(surfaceSizeDefinition, "surfaceSizeDefinition");
            return transformSurfaceConfig$default(this, i2, size, surfaceSizeDefinition, 0, null, null, 56, null);
        }

        private Companion() {
        }

        public final SurfaceConfig create(ConfigType type, ConfigSize size, StreamUseCase streamUseCase) {
            kotlin.jvm.internal.k.e(type, "type");
            kotlin.jvm.internal.k.e(size, "size");
            kotlin.jvm.internal.k.e(streamUseCase, "streamUseCase");
            return new SurfaceConfig(type, size, streamUseCase);
        }

        public final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8) {
            kotlin.jvm.internal.k.e(size, "size");
            kotlin.jvm.internal.k.e(surfaceSizeDefinition, "surfaceSizeDefinition");
            return transformSurfaceConfig$default(this, i2, size, surfaceSizeDefinition, i8, null, null, 48, null);
        }

        public final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8, ConfigSource configSource) {
            kotlin.jvm.internal.k.e(size, "size");
            kotlin.jvm.internal.k.e(surfaceSizeDefinition, "surfaceSizeDefinition");
            kotlin.jvm.internal.k.e(configSource, "configSource");
            return transformSurfaceConfig$default(this, i2, size, surfaceSizeDefinition, i8, configSource, null, 32, null);
        }

        public final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8, ConfigSource configSource, StreamUseCase streamUseCase) {
            kotlin.jvm.internal.k.e(size, "size");
            kotlin.jvm.internal.k.e(surfaceSizeDefinition, "surfaceSizeDefinition");
            kotlin.jvm.internal.k.e(configSource, "configSource");
            kotlin.jvm.internal.k.e(streamUseCase, "streamUseCase");
            ConfigType configType = getConfigType(i2);
            ConfigSize configSize = ConfigSize.NOT_SUPPORT;
            int area = SizeUtil.getArea(size);
            if (i8 == 1) {
                if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS720pSize(i2))) {
                    configSize = ConfigSize.S720P_16_9;
                } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS1440pSize(i2))) {
                    configSize = ConfigSize.S1440P_4_3;
                }
            } else if (configSource == ConfigSource.FEATURE_COMBINATION_TABLE) {
                Size maximumSize = surfaceSizeDefinition.getMaximumSize(i2);
                ConfigSize[] configSizeArr = SurfaceConfig.FEATURE_COMBO_QUERY_SUPPORTED_SIZES;
                int length = configSizeArr.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    }
                    ConfigSize configSize2 = configSizeArr[i9];
                    if (size.equals(configSize2.getRelatedFixedSize())) {
                        configSize = configSize2;
                        break;
                    }
                    i9++;
                }
                if (configSize == ConfigSize.NOT_SUPPORT && size.equals(maximumSize)) {
                    configSize = ConfigSize.MAXIMUM;
                }
            } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getAnalysisSize())) {
                configSize = ConfigSize.VGA;
            } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getPreviewSize())) {
                configSize = ConfigSize.PREVIEW;
            } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getRecordSize())) {
                configSize = ConfigSize.RECORD;
            } else {
                Size maximumSize2 = surfaceSizeDefinition.getMaximumSize(i2);
                Size ultraMaximumSize = surfaceSizeDefinition.getUltraMaximumSize(i2);
                if ((maximumSize2 == null || area <= SizeUtil.getArea(maximumSize2)) && i8 != 2) {
                    configSize = ConfigSize.MAXIMUM;
                } else if (ultraMaximumSize != null && area <= SizeUtil.getArea(ultraMaximumSize)) {
                    configSize = ConfigSize.ULTRA_MAXIMUM;
                }
            }
            return create(configType, configSize, streamUseCase);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ConfigSize {
        private static final /* synthetic */ y5.a $ENTRIES;
        private static final /* synthetic */ ConfigSize[] $VALUES;
        public static final ConfigSize PREVIEW;
        public static final ConfigSize RECORD;
        private final int id;
        private final Size relatedFixedSize;
        public static final ConfigSize VGA = new ConfigSize("VGA", 0, 0, new Size(640, 480));
        public static final ConfigSize X_VGA = new ConfigSize("X_VGA", 1, 1, new Size(1024, 768));
        public static final ConfigSize S720P_16_9 = new ConfigSize("S720P_16_9", 2, 2, new Size(1280, 720));
        public static final ConfigSize S1080P_4_3 = new ConfigSize("S1080P_4_3", 4, 4, new Size(InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1080));
        public static final ConfigSize S1080P_16_9 = new ConfigSize("S1080P_16_9", 5, 5, new Size(1920, 1080));
        public static final ConfigSize S1440P_4_3 = new ConfigSize("S1440P_4_3", 6, 6, new Size(1920, InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW));
        public static final ConfigSize S1440P_16_9 = new ConfigSize("S1440P_16_9", 7, 7, new Size(2560, InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW));
        public static final ConfigSize UHD = new ConfigSize("UHD", 8, 8, new Size(3840, 2160));
        public static final ConfigSize MAXIMUM = new ConfigSize("MAXIMUM", 10, 10, null, 2, null);
        public static final ConfigSize MAXIMUM_4_3 = new ConfigSize("MAXIMUM_4_3", 11, 11, null, 2, null);
        public static final ConfigSize MAXIMUM_16_9 = new ConfigSize("MAXIMUM_16_9", 12, 12, null, 2, null);
        public static final ConfigSize ULTRA_MAXIMUM = new ConfigSize("ULTRA_MAXIMUM", 13, 13, null, 2, null);
        public static final ConfigSize NOT_SUPPORT = new ConfigSize("NOT_SUPPORT", 14, 14, null, 2, null);

        private static final /* synthetic */ ConfigSize[] $values() {
            return new ConfigSize[]{VGA, X_VGA, S720P_16_9, PREVIEW, S1080P_4_3, S1080P_16_9, S1440P_4_3, S1440P_16_9, UHD, RECORD, MAXIMUM, MAXIMUM_4_3, MAXIMUM_16_9, ULTRA_MAXIMUM, NOT_SUPPORT};
        }

        static {
            int i2 = 2;
            kotlin.jvm.internal.f fVar = null;
            Size size = null;
            PREVIEW = new ConfigSize("PREVIEW", 3, 3, size, i2, fVar);
            RECORD = new ConfigSize("RECORD", 9, 9, size, i2, fVar);
            ConfigSize[] configSizeArr$values = $values();
            $VALUES = configSizeArr$values;
            $ENTRIES = n7.b.n(configSizeArr$values);
        }

        private ConfigSize(String str, int i2, int i8, Size size) {
            this.id = i8;
            this.relatedFixedSize = size;
        }

        public static y5.a getEntries() {
            return $ENTRIES;
        }

        public static ConfigSize valueOf(String str) {
            return (ConfigSize) Enum.valueOf(ConfigSize.class, str);
        }

        public static ConfigSize[] values() {
            return (ConfigSize[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }

        public final Size getRelatedFixedSize() {
            return this.relatedFixedSize;
        }

        public /* synthetic */ ConfigSize(String str, int i2, int i8, Size size, int i9, kotlin.jvm.internal.f fVar) {
            this(str, i2, i8, (i9 & 2) != 0 ? null : size);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ConfigSource {
        private static final /* synthetic */ y5.a $ENTRIES;
        private static final /* synthetic */ ConfigSource[] $VALUES;
        public static final ConfigSource FEATURE_COMBINATION_TABLE = new ConfigSource("FEATURE_COMBINATION_TABLE", 0);
        public static final ConfigSource CAPTURE_SESSION_TABLES = new ConfigSource("CAPTURE_SESSION_TABLES", 1);

        private static final /* synthetic */ ConfigSource[] $values() {
            return new ConfigSource[]{FEATURE_COMBINATION_TABLE, CAPTURE_SESSION_TABLES};
        }

        static {
            ConfigSource[] configSourceArr$values = $values();
            $VALUES = configSourceArr$values;
            $ENTRIES = n7.b.n(configSourceArr$values);
        }

        private ConfigSource(String str, int i2) {
        }

        public static y5.a getEntries() {
            return $ENTRIES;
        }

        public static ConfigSource valueOf(String str) {
            return (ConfigSource) Enum.valueOf(ConfigSource.class, str);
        }

        public static ConfigSource[] values() {
            return (ConfigSource[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ConfigType {
        private static final /* synthetic */ y5.a $ENTRIES;
        private static final /* synthetic */ ConfigType[] $VALUES;
        public static final ConfigType PRIV = new ConfigType("PRIV", 0);
        public static final ConfigType YUV = new ConfigType("YUV", 1);
        public static final ConfigType JPEG = new ConfigType("JPEG", 2);
        public static final ConfigType JPEG_R = new ConfigType("JPEG_R", 3);
        public static final ConfigType RAW = new ConfigType("RAW", 4);

        private static final /* synthetic */ ConfigType[] $values() {
            return new ConfigType[]{PRIV, YUV, JPEG, JPEG_R, RAW};
        }

        static {
            ConfigType[] configTypeArr$values = $values();
            $VALUES = configTypeArr$values;
            $ENTRIES = n7.b.n(configTypeArr$values);
        }

        private ConfigType(String str, int i2) {
        }

        public static y5.a getEntries() {
            return $ENTRIES;
        }

        public static ConfigType valueOf(String str) {
            return (ConfigType) Enum.valueOf(ConfigType.class, str);
        }

        public static ConfigType[] values() {
            return (ConfigType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConfigSize.values().length];
            try {
                iArr[ConfigSize.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigSize.RECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfigSize.MAXIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfigSize.MAXIMUM_4_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConfigSize.MAXIMUM_16_9.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConfigSize.ULTRA_MAXIMUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConfigSize.NOT_SUPPORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Map<ConfigType, Integer> mapF0 = r5.x.f0(new q5.i(ConfigType.YUV, 35), new q5.i(ConfigType.JPEG, 256), new q5.i(ConfigType.JPEG_R, 4101), new q5.i(ConfigType.RAW, 32), new q5.i(ConfigType.PRIV, 34));
        IMAGE_FORMATS_BY_CONFIG_TYPE = mapF0;
        Set<Map.Entry<ConfigType, Integer>> setEntrySet = mapF0.entrySet();
        int iD0 = r5.x.d0(r5.n.L0(setEntrySet, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (ConfigType) entry.getKey());
        }
        CONFIG_TYPES_BY_IMAGE_FORMAT = linkedHashMap;
    }

    public SurfaceConfig(ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase) {
        kotlin.jvm.internal.k.e(configType, "configType");
        kotlin.jvm.internal.k.e(configSize, "configSize");
        kotlin.jvm.internal.k.e(streamUseCase, "streamUseCase");
        this.configType = configType;
        this.configSize = configSize;
        this.streamUseCase = streamUseCase;
        Integer num = IMAGE_FORMATS_BY_CONFIG_TYPE.get(configType);
        this.imageFormat = num != null ? num.intValue() : 0;
    }

    public static /* synthetic */ SurfaceConfig copy$default(SurfaceConfig surfaceConfig, ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            configType = surfaceConfig.configType;
        }
        if ((i2 & 2) != 0) {
            configSize = surfaceConfig.configSize;
        }
        if ((i2 & 4) != 0) {
            streamUseCase = surfaceConfig.streamUseCase;
        }
        return surfaceConfig.copy(configType, configSize, streamUseCase);
    }

    public static final SurfaceConfig create(ConfigType configType, ConfigSize configSize) {
        return Companion.create(configType, configSize);
    }

    public static final ConfigType getConfigType(int i2) {
        return Companion.getConfigType(i2);
    }

    public static final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition) {
        return Companion.transformSurfaceConfig(i2, size, surfaceSizeDefinition);
    }

    public final ConfigType component1() {
        return this.configType;
    }

    public final ConfigSize component2() {
        return this.configSize;
    }

    public final StreamUseCase component3() {
        return this.streamUseCase;
    }

    public final SurfaceConfig copy(ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase) {
        kotlin.jvm.internal.k.e(configType, "configType");
        kotlin.jvm.internal.k.e(configSize, "configSize");
        kotlin.jvm.internal.k.e(streamUseCase, "streamUseCase");
        return new SurfaceConfig(configType, configSize, streamUseCase);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        return this.configType == surfaceConfig.configType && this.configSize == surfaceConfig.configSize && this.streamUseCase == surfaceConfig.streamUseCase;
    }

    public final ConfigSize getConfigSize() {
        return this.configSize;
    }

    public final int getImageFormat() {
        return this.imageFormat;
    }

    public final Size getResolution(SurfaceSizeDefinition definition) {
        Size previewSize;
        kotlin.jvm.internal.k.e(definition, "definition");
        switch (WhenMappings.$EnumSwitchMapping$0[this.configSize.ordinal()]) {
            case 1:
                previewSize = definition.getPreviewSize();
                break;
            case 2:
                previewSize = definition.getRecordSize();
                break;
            case 3:
                previewSize = definition.getMaximumSize(this.imageFormat);
                break;
            case 4:
                previewSize = definition.getMaximum4x3Size(this.imageFormat);
                break;
            case 5:
                previewSize = definition.getMaximum16x9Size(this.imageFormat);
                break;
            case 6:
                previewSize = definition.getUltraMaximumSize(this.imageFormat);
                break;
            case 7:
                throw new IllegalStateException("Not supported config size");
            default:
                previewSize = this.configSize.getRelatedFixedSize();
                break;
        }
        kotlin.jvm.internal.k.b(previewSize);
        return previewSize;
    }

    public final StreamUseCase getStreamUseCase() {
        return this.streamUseCase;
    }

    public int hashCode() {
        return this.streamUseCase.hashCode() + ((this.configSize.hashCode() + (this.configType.hashCode() * 31)) * 31);
    }

    public final boolean isSupported(SurfaceConfig other) {
        StreamUseCase streamUseCase;
        kotlin.jvm.internal.k.e(other, "other");
        if (other.configSize.getId() > this.configSize.getId() || other.configType != this.configType) {
            return false;
        }
        StreamUseCase streamUseCase2 = this.streamUseCase;
        StreamUseCase streamUseCase3 = StreamUseCase.DEFAULT;
        return streamUseCase2 == streamUseCase3 || (streamUseCase = other.streamUseCase) == streamUseCase3 || streamUseCase == streamUseCase2;
    }

    public String toString() {
        return "SurfaceConfig(configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + ')';
    }

    public static final SurfaceConfig create(ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase) {
        return Companion.create(configType, configSize, streamUseCase);
    }

    public static final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8) {
        return Companion.transformSurfaceConfig(i2, size, surfaceSizeDefinition, i8);
    }

    public final ConfigType getConfigType() {
        return this.configType;
    }

    public static final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8, ConfigSource configSource) {
        return Companion.transformSurfaceConfig(i2, size, surfaceSizeDefinition, i8, configSource);
    }

    public static final SurfaceConfig transformSurfaceConfig(int i2, Size size, SurfaceSizeDefinition surfaceSizeDefinition, int i8, ConfigSource configSource, StreamUseCase streamUseCase) {
        return Companion.transformSurfaceConfig(i2, size, surfaceSizeDefinition, i8, configSource, streamUseCase);
    }

    public /* synthetic */ SurfaceConfig(ConfigType configType, ConfigSize configSize, StreamUseCase streamUseCase, int i2, kotlin.jvm.internal.f fVar) {
        this(configType, configSize, (i2 & 4) != 0 ? DEFAULT_STREAM_USE_CASE : streamUseCase);
    }
}
