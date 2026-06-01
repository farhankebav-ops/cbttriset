package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.ByteBufferInput f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3840c;

    public /* synthetic */ h(EncoderImpl.ByteBufferInput byteBufferInput, CallbackToFutureAdapter.Completer completer, int i2) {
        this.f3838a = i2;
        this.f3839b = byteBufferInput;
        this.f3840c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3838a) {
            case 0:
                this.f3839b.lambda$acquireBuffer$4(this.f3840c);
                break;
            default:
                this.f3839b.lambda$fetchData$0(this.f3840c);
                break;
        }
    }
}
