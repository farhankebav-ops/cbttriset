package androidx.camera.video.internal.audio;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3818c;

    public /* synthetic */ h(Object obj, int i2, int i8) {
        this.f3816a = i8;
        this.f3818c = obj;
        this.f3817b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3816a) {
            case 0:
                ((BufferedAudioStream) this.f3818c).lambda$updateCollectionBufferSizeAsync$4(this.f3817b);
                break;
            case 1:
                ((ResourcesCompat.FontCallback) this.f3818c).lambda$callbackFailAsync$1(this.f3817b);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f3818c;
                View view = (View) sideSheetBehavior.p.get();
                if (view != null) {
                    sideSheetBehavior.c(view, this.f3817b, false);
                }
                break;
        }
    }
}
