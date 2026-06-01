package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.ByteBufferInput f3837b;

    public /* synthetic */ g(EncoderImpl.ByteBufferInput byteBufferInput, int i2) {
        this.f3836a = i2;
        this.f3837b = byteBufferInput;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3836a) {
            case 0:
                return this.f3837b.lambda$fetchData$1(completer);
            default:
                return this.f3837b.lambda$acquireBuffer$5(completer);
        }
    }
}
