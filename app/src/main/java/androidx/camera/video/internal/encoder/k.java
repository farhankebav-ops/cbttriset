package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3849d;
    public final /* synthetic */ Object e;

    public /* synthetic */ k(EncoderImpl.MediaCodecCallback mediaCodecCallback, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i2) {
        this.f3846a = 0;
        this.f3848c = mediaCodecCallback;
        this.f3849d = bufferInfo;
        this.e = mediaCodec;
        this.f3847b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3846a) {
            case 0:
                ((EncoderImpl.MediaCodecCallback) this.f3848c).lambda$onOutputBufferAvailable$1((MediaCodec.BufferInfo) this.f3849d, (MediaCodec) this.e, this.f3847b);
                break;
            case 1:
                EncoderImpl.lambda$notifyError$11((EncoderCallback) this.f3848c, this.f3847b, (String) this.f3849d, (Throwable) this.e);
                break;
            default:
                ((EncoderImpl) this.f3848c).lambda$handleEncodeError$10(this.f3847b, (String) this.f3849d, (Throwable) this.e);
                break;
        }
    }

    public /* synthetic */ k(Object obj, int i2, String str, Throwable th, int i8) {
        this.f3846a = i8;
        this.f3848c = obj;
        this.f3847b = i2;
        this.f3849d = str;
        this.e = th;
    }
}
