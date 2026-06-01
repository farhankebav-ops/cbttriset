package androidx.camera.video.internal.encoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o {
    public static boolean a(VideoEncoderInfo videoEncoderInfo, int i2, int i8) {
        if (videoEncoderInfo.isSizeSupported(i2, i8)) {
            return true;
        }
        return videoEncoderInfo.canSwapWidthHeight() && videoEncoderInfo.isSizeSupported(i8, i2);
    }
}
