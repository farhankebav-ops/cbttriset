package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view, final e6.l lVar) {
        if (view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnAttach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static final void doOnDetach(final View view, final e6.l lVar) {
        if (view.isAttachedToWindow()) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnDetach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnLayout(View view, final e6.l lVar) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                    view2.removeOnLayoutChangeListener(this);
                    lVar.invoke(view2);
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, final e6.l lVar) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt.doOnNextLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                view2.removeOnLayoutChangeListener(this);
                lVar.invoke(view2);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final e6.l lVar) {
        return OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt.doOnPreDraw.1
            @Override // java.lang.Runnable
            public final void run() {
                lVar.invoke(view);
            }
        });
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (!view.isLaidOut()) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final m6.h getAllViews(View view) {
        return new c6.m(new ViewKt$allViews$1(view, null));
    }

    public static final m6.h getAncestors(View view) {
        ViewParent parent = view.getParent();
        ViewKt$ancestors$1 nextFunction = ViewKt$ancestors$1.INSTANCE;
        kotlin.jvm.internal.k.e(nextFunction, "nextFunction");
        return parent == null ? m6.e.f12977a : new c6.i(new androidx.activity.result.b(parent, 8), nextFunction);
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, final e6.a aVar) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                aVar.invoke();
            }
        };
        view.postDelayed(runnable, j);
        return runnable;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j, e6.a aVar) {
        h hVar = new h(aVar, 1);
        view.postOnAnimationDelayed(hVar, j);
        return hVar;
    }

    public static final void setGone(View view, boolean z2) {
        view.setVisibility(z2 ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z2) {
        view.setVisibility(z2 ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i2) {
        view.setPadding(i2, i2, i2, i2);
    }

    public static final void setVisible(View view, boolean z2) {
        view.setVisibility(z2 ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, e6.l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        lVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, e6.l lVar) {
        view.getLayoutParams();
        kotlin.jvm.internal.k.k();
        throw null;
    }

    public static final void updatePadding(View view, @Px int i2, @Px int i8, @Px int i9, @Px int i10) {
        view.setPadding(i2, i8, i9, i10);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i11 & 2) != 0) {
            i8 = view.getPaddingTop();
        }
        if ((i11 & 4) != 0) {
            i9 = view.getPaddingRight();
        }
        if ((i11 & 8) != 0) {
            i10 = view.getPaddingBottom();
        }
        view.setPadding(i2, i8, i9, i10);
    }

    public static final void updatePaddingRelative(View view, @Px int i2, @Px int i8, @Px int i9, @Px int i10) {
        view.setPaddingRelative(i2, i8, i9, i10);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = view.getPaddingStart();
        }
        if ((i11 & 2) != 0) {
            i8 = view.getPaddingTop();
        }
        if ((i11 & 4) != 0) {
            i9 = view.getPaddingEnd();
        }
        if ((i11 & 8) != 0) {
            i10 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i2, i8, i9, i10);
    }
}
