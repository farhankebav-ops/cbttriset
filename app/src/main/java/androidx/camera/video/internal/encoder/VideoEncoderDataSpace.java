package androidx.camera.video.internal.encoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoEncoderDataSpace {
    public static final int VIDEO_COLOR_RANGE_UNSPECIFIED = 0;
    public static final int VIDEO_COLOR_STANDARD_UNSPECIFIED = 0;
    public static final int VIDEO_COLOR_TRANSFER_UNSPECIFIED = 0;
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_UNSPECIFIED = create(0, 0, 0);
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT709 = create(1, 3, 2);
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_SRGB = create(1, 3, 1);
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT2020_HLG = create(6, 7, 1);
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT2020_PQ = create(6, 6, 1);

    public static VideoEncoderDataSpace create(int i2, int i8, int i9) {
        return new AutoValue_VideoEncoderDataSpace(i2, i8, i9);
    }

    public abstract int getRange();

    public abstract int getStandard();

    public abstract int getTransfer();
}
