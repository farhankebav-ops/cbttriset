package q;

import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import cn.pedant.SweetAlert.SuccessTickView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f13348b;

    public /* synthetic */ d(KeyEvent.Callback callback, int i2) {
        this.f13347a = i2;
        this.f13348b = callback;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        switch (this.f13347a) {
            case 0:
                SuccessTickView successTickView = (SuccessTickView) this.f13348b;
                super.applyTransformation(f4, transformation);
                double d8 = f4;
                if (0.54d < d8 && 0.7d >= d8) {
                    successTickView.l = true;
                    successTickView.j = ((f4 - 0.54f) / 0.16f) * successTickView.f4246i;
                    if (0.65d < d8) {
                        successTickView.k = ((f4 - 0.65f) / 0.19f) * successTickView.h;
                    }
                    successTickView.invalidate();
                    break;
                } else if (0.7d < d8 && 0.84d >= d8) {
                    successTickView.l = false;
                    float f8 = (1.0f - ((f4 - 0.7f) / 0.14f)) * successTickView.f4246i;
                    successTickView.j = f8;
                    float f9 = successTickView.g;
                    if (f8 < f9) {
                        f8 = f9;
                    }
                    successTickView.j = f8;
                    successTickView.k = ((f4 - 0.65f) / 0.19f) * successTickView.h;
                    successTickView.invalidate();
                    break;
                } else if (0.84d < d8 && 1.0f >= f4) {
                    successTickView.l = false;
                    float f10 = successTickView.g;
                    float f11 = (f4 - 0.84f) / 0.16f;
                    successTickView.j = ((successTickView.e - f10) * f11) + f10;
                    float f12 = successTickView.f4245f;
                    successTickView.k = a1.a.a(1.0f, f11, successTickView.h - f12, f12);
                    successTickView.invalidate();
                    break;
                }
                break;
            default:
                g gVar = (g) this.f13348b;
                WindowManager.LayoutParams attributes = gVar.getWindow().getAttributes();
                attributes.alpha = 1.0f - f4;
                gVar.getWindow().setAttributes(attributes);
                break;
        }
    }
}
