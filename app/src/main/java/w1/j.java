package w1;

import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends FloatPropertyCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17714a;

    public j(int i2) {
        super(a1.a.g(i2, "cornerSizeAtIndex"));
        this.f17714a = i2;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final float getValue(Object obj) {
        float[] fArr = ((k) obj).C;
        if (fArr != null) {
            return fArr[this.f17714a];
        }
        return 0.0f;
    }

    @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
    public final void setValue(Object obj, float f4) {
        k kVar = (k) obj;
        float[] fArr = kVar.C;
        if (fArr != null) {
            int i2 = this.f17714a;
            if (fArr[i2] != f4) {
                fArr[i2] = f4;
                i iVar = kVar.E;
                if (iVar != null) {
                    float fH = kVar.h();
                    MaterialButton materialButton = (MaterialButton) ((androidx.camera.core.impl.b) iVar).f3611b;
                    int i8 = (int) (fH * 0.11f);
                    if (materialButton.f5304u != i8) {
                        materialButton.f5304u = i8;
                        materialButton.j();
                        materialButton.invalidate();
                    }
                }
                kVar.invalidateSelf();
            }
        }
    }
}
