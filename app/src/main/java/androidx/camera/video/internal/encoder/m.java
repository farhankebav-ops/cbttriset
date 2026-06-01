package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.arch.core.util.Function;
import androidx.camera.video.internal.encoder.EncoderImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements OutputConfig, Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3852a;

    public /* synthetic */ m(Object obj) {
        this.f3852a = obj;
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        return Long.valueOf(((EncoderImpl) this.f3852a).toPresentationTimeUsByCaptureEncodeRatio(((Long) obj).longValue()));
    }

    @Override // androidx.camera.video.internal.encoder.OutputConfig
    public MediaFormat getMediaFormat() {
        return EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$5((MediaFormat) this.f3852a);
    }
}
