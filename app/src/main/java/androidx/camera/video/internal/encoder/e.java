package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3831c;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f3829a = i2;
        this.f3830b = obj;
        this.f3831c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3829a) {
            case 0:
                EncoderImpl.lambda$addSignalEosTimeoutIfNeeded$9((Executor) this.f3830b, (EncoderImpl.MediaCodecCallback) this.f3831c);
                break;
            case 1:
                ((EncoderImpl) this.f3830b).lambda$matchAcquisitionsAndFreeBufferIndexes$15((EncoderImpl.AnonymousClass2) this.f3831c);
                break;
            case 2:
                EncoderImpl.ByteBufferInput.lambda$setActive$9((Map.Entry) this.f3830b, (BufferProvider.State) this.f3831c);
                break;
            case 3:
                ((Observable.Observer) this.f3830b).onNewData((BufferProvider.State) this.f3831c);
                break;
            case 4:
                ((EncoderImpl.ByteBufferInput) this.f3830b).lambda$removeObserver$8((Observable.Observer) this.f3831c);
                break;
            case 5:
                ((EncoderImpl.MediaCodecCallback) this.f3831c).lambda$onOutputFormatChanged$7((MediaFormat) this.f3830b);
                break;
            case 6:
                ((EncoderCallback) this.f3830b).onEncodedData((EncodedDataImpl) this.f3831c);
                break;
            case 7:
                EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$6((EncoderCallback) this.f3830b, (MediaFormat) this.f3831c);
                break;
            case 8:
                ((EncoderImpl.MediaCodecCallback) this.f3831c).lambda$onError$4((MediaCodec.CodecException) this.f3830b);
                break;
            case 9:
                ((Encoder.SurfaceInput.OnSurfaceUpdateListener) this.f3830b).onSurfaceUpdate((Surface) this.f3831c);
                break;
            default:
                ((EncoderImpl) this.f3830b).lambda$acquireInputBuffer$14((CallbackToFutureAdapter.Completer) this.f3831c);
                break;
        }
    }

    public /* synthetic */ e(EncoderImpl.MediaCodecCallback mediaCodecCallback, Object obj, int i2) {
        this.f3829a = i2;
        this.f3831c = mediaCodecCallback;
        this.f3830b = obj;
    }
}
