package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3835d;

    public /* synthetic */ f(EncoderImpl.MediaCodecCallback mediaCodecCallback, Executor executor, EncoderCallback encoderCallback) {
        this.f3832a = 1;
        this.f3834c = mediaCodecCallback;
        this.f3833b = executor;
        this.f3835d = encoderCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3832a) {
            case 0:
                ((EncoderImpl.ByteBufferInput) this.f3834c).lambda$addObserver$7((Observable.Observer) this.f3835d, (Executor) this.f3833b);
                break;
            case 1:
                ((EncoderImpl.MediaCodecCallback) this.f3834c).lambda$reachEndData$2((Executor) this.f3833b, (EncoderCallback) this.f3835d);
                break;
            default:
                ((EncoderImpl) this.f3834c).lambda$stopMediaCodec$12((ArrayList) this.f3835d, (Runnable) this.f3833b);
                break;
        }
    }

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, int i2) {
        this.f3832a = i2;
        this.f3834c = obj;
        this.f3835d = obj2;
        this.f3833b = obj3;
    }
}
