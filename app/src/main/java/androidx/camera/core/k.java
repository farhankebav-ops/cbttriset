package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3667a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraX f3668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f3669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Executor f3670d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3671f;
    public final /* synthetic */ long g;

    public /* synthetic */ k(CameraX cameraX, Context context, Executor executor, int i2, CallbackToFutureAdapter.Completer completer, long j) {
        this.f3668b = cameraX;
        this.f3669c = context;
        this.f3670d = executor;
        this.e = i2;
        this.f3671f = completer;
        this.g = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3667a) {
            case 0:
                Context context = this.f3669c;
                CallbackToFutureAdapter.Completer completer = this.f3671f;
                this.f3668b.lambda$initAndRetryRecursively$1(this.f3670d, this.g, this.e, context, completer);
                break;
            default:
                this.f3668b.lambda$initAndRetryRecursively$2(this.f3669c, this.f3670d, this.e, this.f3671f, this.g);
                break;
        }
    }

    public /* synthetic */ k(CameraX cameraX, Executor executor, long j, int i2, Context context, CallbackToFutureAdapter.Completer completer) {
        this.f3668b = cameraX;
        this.f3670d = executor;
        this.g = j;
        this.e = i2;
        this.f3669c = context;
        this.f3671f = completer;
    }
}
