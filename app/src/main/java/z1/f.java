package z1;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends w1.h {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f17904r;

    public f(w1.o oVar, RectF rectF) {
        super(oVar);
        this.f17904r = rectF;
    }

    @Override // w1.h, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.H = this;
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super(fVar);
        this.f17904r = fVar.f17904r;
    }
}
