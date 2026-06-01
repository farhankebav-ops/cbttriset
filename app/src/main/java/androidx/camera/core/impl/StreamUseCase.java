package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamUseCase {
    private static final /* synthetic */ y5.a $ENTRIES;
    private static final /* synthetic */ StreamUseCase[] $VALUES;
    private final long value;
    public static final StreamUseCase DEFAULT = new StreamUseCase("DEFAULT", 0, 0);
    public static final StreamUseCase PREVIEW = new StreamUseCase("PREVIEW", 1, 1);
    public static final StreamUseCase VIDEO_RECORD = new StreamUseCase("VIDEO_RECORD", 2, 3);
    public static final StreamUseCase STILL_CAPTURE = new StreamUseCase("STILL_CAPTURE", 3, 2);
    public static final StreamUseCase VIDEO_CALL = new StreamUseCase("VIDEO_CALL", 4, 5);
    public static final StreamUseCase PREVIEW_VIDEO_STILL = new StreamUseCase("PREVIEW_VIDEO_STILL", 5, 4);
    public static final StreamUseCase CROPPED_RAW = new StreamUseCase("CROPPED_RAW", 6, 6);

    private static final /* synthetic */ StreamUseCase[] $values() {
        return new StreamUseCase[]{DEFAULT, PREVIEW, VIDEO_RECORD, STILL_CAPTURE, VIDEO_CALL, PREVIEW_VIDEO_STILL, CROPPED_RAW};
    }

    static {
        StreamUseCase[] streamUseCaseArr$values = $values();
        $VALUES = streamUseCaseArr$values;
        $ENTRIES = n7.b.n(streamUseCaseArr$values);
    }

    private StreamUseCase(String str, int i2, int i8) {
        this.value = i8;
    }

    public static y5.a getEntries() {
        return $ENTRIES;
    }

    public static StreamUseCase valueOf(String str) {
        return (StreamUseCase) Enum.valueOf(StreamUseCase.class, str);
    }

    public static StreamUseCase[] values() {
        return (StreamUseCase[]) $VALUES.clone();
    }

    public final long getValue() {
        return this.value;
    }
}
