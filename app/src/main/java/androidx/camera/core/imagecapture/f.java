package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProcessingNode f3595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProcessingNode.InputPacket f3596c;

    public /* synthetic */ f(ProcessingNode processingNode, ProcessingNode.InputPacket inputPacket, int i2) {
        this.f3594a = i2;
        this.f3595b = processingNode;
        this.f3596c = inputPacket;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3594a) {
            case 0:
                this.f3595b.lambda$transform$2(this.f3596c);
                break;
            default:
                this.f3595b.lambda$transform$0(this.f3596c);
                break;
        }
    }
}
