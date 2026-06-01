package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.a.c;
import sg.bigo.ads.common.view.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class RealtimeBlurLinearLayout extends LinearLayout implements c<RealtimeBlurLinearLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<RealtimeBlurLinearLayout> f16110a;

    public RealtimeBlurLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public Drawable getBackground() {
        Drawable background = super.getBackground();
        return background instanceof sg.bigo.ads.common.view.a.a ? ((sg.bigo.ads.common.view.a.a) background).f15794a : background;
    }

    @Nullable
    public sg.bigo.ads.common.view.a.b getBlurStyle() {
        return this.f16110a.f16181d.f16173b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d<RealtimeBlurLinearLayout> dVar = this.f16110a;
        View viewA = u.a(dVar.f16180c, dVar.f16179b);
        dVar.f16182f = viewA;
        if (viewA == null) {
            dVar.g = false;
            return;
        }
        viewA.getViewTreeObserver().addOnPreDrawListener(dVar.h);
        dVar.a();
        boolean z2 = dVar.f16182f.getRootView() != dVar.f16179b.getRootView();
        dVar.g = z2;
        if (z2) {
            dVar.f16182f.postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d<RealtimeBlurLinearLayout> dVar = this.f16110a;
        View view = dVar.f16182f;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(dVar.h);
        }
        dVar.b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        d<RealtimeBlurLinearLayout> dVar = this.f16110a;
        sg.bigo.ads.common.view.a.a aVar = dVar.f16181d;
        if (drawable != aVar) {
            aVar.a(drawable);
            dVar.b();
        }
        super.setBackground(dVar.f16181d);
    }

    @Override // sg.bigo.ads.common.view.a.c
    public void setBlurStyle(@Nullable sg.bigo.ads.common.view.a.b bVar) {
        this.f16110a.setBlurStyle(bVar);
    }

    public RealtimeBlurLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RealtimeBlurLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d<RealtimeBlurLinearLayout> dVar = new d<>(this);
        this.f16110a = dVar;
        setBackground(dVar.f16181d);
    }
}
