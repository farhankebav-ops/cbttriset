package g1;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f11578d;

    public i(View view) {
        super(0);
        this.f11578d = new int[2];
        this.f11575a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f11575a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        View view = this.f11575a;
        int[] iArr = this.f11578d;
        view.getLocationOnScreen(iArr);
        this.f11576b = iArr[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimationCompat) it.next()).getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f11575a.setTranslationY(c1.a.c(this.f11577c, 0, r0.getInterpolatedFraction()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        View view = this.f11575a;
        int[] iArr = this.f11578d;
        view.getLocationOnScreen(iArr);
        int i2 = this.f11576b - iArr[1];
        this.f11577c = i2;
        view.setTranslationY(i2);
        return boundsCompat;
    }
}
