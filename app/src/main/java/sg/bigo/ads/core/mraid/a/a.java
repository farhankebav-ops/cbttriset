package sg.bigo.ads.core.mraid.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Drawable f17137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private b f17139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private EnumC0320a f17140d;
    private final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17141f;
    private final int g;
    private boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Rect f17142i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private c f17143n;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.a.a$a, reason: collision with other inner class name */
    public enum EnumC0320a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        final int h;

        EnumC0320a(int i2) {
            this.h = i2;
        }
    }

    public interface b {
        void a();
    }

    public final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.setClosePressed(false);
        }

        public /* synthetic */ c(a aVar, byte b8) {
            this();
        }
    }

    public a(@NonNull Context context) {
        this(context, (byte) 0);
    }

    private static void a(EnumC0320a enumC0320a, int i2, Rect rect, Rect rect2) {
        Gravity.apply(enumC0320a.h, i2, i2, rect, rect2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z2) {
        if (z2 == a()) {
            return;
        }
        this.f17137a.setState(z2 ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.j);
    }

    @Override // android.view.View
    public final void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.h) {
            this.h = false;
            this.f17142i.set(0, 0, getWidth(), getHeight());
            a(this.f17140d, this.f17142i, this.j);
            this.l.set(this.j);
            Rect rect = this.l;
            int i2 = this.g;
            rect.inset(i2, i2);
            a(this.f17140d, this.f17141f, this.l, this.k);
            this.f17137a.setBounds(this.k);
        }
        if (this.f17137a.isVisible()) {
            this.f17137a.draw(canvas);
        }
    }

    @VisibleForTesting
    public final Rect getCloseBounds() {
        return this.j;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.h = true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        byte b8 = 0;
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.f17138b) || (!this.m && !this.f17137a.isVisible())) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (a()) {
            if (this.f17143n == null) {
                this.f17143n = new c(this, b8);
            }
            postDelayed(this.f17143n, ViewConfiguration.getPressedStateDuration());
            playSoundEffect(0);
            b bVar = this.f17139c;
            if (bVar != null) {
                bVar.a();
            }
        }
        return true;
    }

    public final void setCloseAlwaysInteractable(boolean z2) {
        this.m = z2;
    }

    @VisibleForTesting
    public final void setCloseBoundChanged(boolean z2) {
        this.h = z2;
    }

    @VisibleForTesting
    public final void setCloseBounds(Rect rect) {
        this.j.set(rect);
    }

    public final void setClosePosition(@NonNull EnumC0320a enumC0320a) {
        this.f17140d = enumC0320a;
        this.h = true;
        invalidate();
    }

    public final void setCloseVisible(boolean z2) {
        if (this.f17137a.setVisible(z2, false)) {
            invalidate(this.j);
        }
    }

    public final void setOnCloseListener(@Nullable b bVar) {
        this.f17139c = bVar;
    }

    private a(@NonNull Context context, byte b8) {
        super(context, null, 0);
        this.f17142i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        Drawable drawableA = sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_ic_close);
        this.f17137a = drawableA;
        this.f17140d = EnumC0320a.TOP_RIGHT;
        drawableA.setState(FrameLayout.EMPTY_STATE_SET);
        drawableA.setCallback(this);
        this.f17138b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = e.a(context, 50);
        this.f17141f = e.a(context, 30);
        this.g = e.a(context, 8);
        setWillNotDraw(false);
        this.m = true;
    }

    public final void a(EnumC0320a enumC0320a, Rect rect, Rect rect2) {
        a(enumC0320a, this.e, rect, rect2);
    }

    @VisibleForTesting
    private boolean a() {
        return this.f17137a.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    @VisibleForTesting
    private boolean a(int i2, int i8, int i9) {
        Rect rect = this.j;
        return i2 >= rect.left - i9 && i8 >= rect.top - i9 && i2 < rect.right + i9 && i8 < rect.bottom + i9;
    }
}
