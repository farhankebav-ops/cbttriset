package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3854b;

    public /* synthetic */ n(AtomicReference atomicReference, int i2) {
        this.f3853a = i2;
        this.f3854b = atomicReference;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3853a) {
            case 0:
                return InputBufferImpl.lambda$new$0(this.f3854b, completer);
            case 1:
                return BufferCopiedEncodedData.lambda$new$0(this.f3854b, completer);
            case 2:
                return EncodedDataImpl.lambda$new$0(this.f3854b, completer);
            case 3:
                return EncoderImpl.lambda$acquireInputBuffer$13(this.f3854b, completer);
            default:
                return EncoderImpl.lambda$new$0(this.f3854b, completer);
        }
    }
}
