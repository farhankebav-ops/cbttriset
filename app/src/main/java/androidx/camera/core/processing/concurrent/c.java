package androidx.camera.core.processing.concurrent;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceEdge;
import com.ironsource.E3;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.q;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3698d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3699f;
    public final /* synthetic */ Object g;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i2) {
        this.f3695a = i2;
        this.f3696b = obj;
        this.f3697c = obj2;
        this.f3698d = obj3;
        this.e = obj4;
        this.f3699f = obj5;
        this.g = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3695a) {
            case 0:
                ((DualSurfaceProcessorNode) this.f3696b).lambda$sendSurfaceOutputs$0((CameraInternal) this.f3697c, (CameraInternal) this.f3698d, (SurfaceEdge) this.e, (SurfaceEdge) this.f3699f, (Map.Entry) this.g);
                break;
            default:
                l.a((q) this.f3696b, (View) this.f3697c, (ISBannerSize) this.f3698d, (Context) this.e, (FrameLayout.LayoutParams) this.f3699f, (E3) this.g);
                break;
        }
    }
}
