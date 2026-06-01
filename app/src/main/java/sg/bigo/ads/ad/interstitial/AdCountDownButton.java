package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class AdCountDownButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f14164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    sg.bigo.ads.common.utils.n f14165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f14167d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f14168f;
    public View g;
    public TextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14169i;
    private boolean j;

    public interface a {
        void a();

        void a(Rect rect);
    }

    public interface b {
        void a();
    }

    public AdCountDownButton(@NonNull Context context) {
        this(context, null);
    }

    private void f() {
        this.f14168f.setVisibility(0);
        this.f14168f.setClickable(true);
        this.f14168f.setAlpha(1.0f);
    }

    public final void a(@LayoutRes int i2) {
        removeAllViews();
        sg.bigo.ads.common.utils.a.a(this.f14164a, i2, this, true);
        this.f14168f = findViewById(R.id.bigo_ad_btn_close);
        this.g = findViewById(R.id.inter_view_stroke);
        this.h = (TextView) findViewById(R.id.inter_text_countdown);
    }

    public final void b() {
        sg.bigo.ads.common.utils.n nVar = this.f14165b;
        if (nVar != null) {
            nVar.d();
        }
    }

    public final void c() {
        sg.bigo.ads.common.utils.n nVar = this.f14165b;
        if (nVar == null || !nVar.e()) {
            return;
        }
        this.f14165b.c();
    }

    public final void d() {
        sg.bigo.ads.common.utils.n nVar = this.f14165b;
        if (nVar != null) {
            nVar.b();
        }
        this.f14166c = true;
        a(false);
    }

    public final void e() {
        this.f14168f.setVisibility(0);
        this.f14168f.setAlpha(0.2f);
        this.f14168f.setClickable(false);
    }

    public View getCloseView() {
        return this.f14168f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14166c) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBtnClickArea(int i2) {
        CustomTouchImageView customTouchImageView;
        float f4;
        View view = this.f14168f;
        if (view instanceof CustomTouchImageView) {
            if (i2 == 1) {
                customTouchImageView = (CustomTouchImageView) view;
                f4 = 0.5f;
            } else {
                if (i2 != 2) {
                    return;
                }
                customTouchImageView = (CustomTouchImageView) view;
                f4 = 0.25f;
            }
            customTouchImageView.setRegionScale(f4);
        }
    }

    public void setCloseImageResource(@DrawableRes int i2) {
        View view = this.f14168f;
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(i2);
        }
    }

    public void setOnCloseListener(@Nullable final a aVar) {
        View view = this.f14168f;
        if (view == null) {
            return;
        }
        if (aVar == null) {
            view.setOnTouchListener(null);
        } else if (view instanceof CustomTouchImageView) {
            ((CustomTouchImageView) view).setCloseListener(aVar);
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.AdCountDownButton.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    aVar.a();
                }
            });
        }
    }

    public void setShowCloseButtonInCountdown(boolean z2) {
        this.f14169i = z2;
        TextView textView = this.h;
        if (textView == null) {
            return;
        }
        if (z2) {
            textView.setPadding(sg.bigo.ads.common.utils.e.a(getContext(), 2), 0, 0, 0);
        } else {
            textView.setPadding(0, 0, 0, 0);
        }
    }

    public void setTakeoverTickEvent(boolean z2) {
        this.f14167d = z2;
    }

    public void setWithUnit(boolean z2) {
        this.j = z2;
    }

    public AdCountDownButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        if (!this.e) {
            this.h.setText(sg.bigo.ads.common.utils.q.a("%d".concat(this.j ? "s" : ""), Integer.valueOf(Math.round(j / 1000.0f))));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sg.bigo.ads.common.utils.a.a(this.f14164a, R.string.bigo_ad_splash_skip_after, new Object[0]));
        sb.append(" %d");
        sb.append(this.j ? "s" : "");
        this.h.setText(sg.bigo.ads.common.utils.q.a(sb.toString(), Integer.valueOf(Math.round(j / 1000.0f))));
    }

    public final void a(int i2, @Nullable final b bVar) {
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        this.f14168f.setVisibility(8);
        if (this.f14169i) {
            this.g.setVisibility(0);
            e();
        }
        if (i2 == 0) {
            a(this.f14167d);
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        this.f14166c = false;
        if (i2 < 0) {
            return;
        }
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) i2) * 1000) { // from class: sg.bigo.ads.ad.interstitial.AdCountDownButton.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                AdCountDownButton adCountDownButton = AdCountDownButton.this;
                adCountDownButton.a(adCountDownButton.f14167d);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                AdCountDownButton.b(AdCountDownButton.this);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                if (AdCountDownButton.this.f14167d) {
                    return;
                }
                AdCountDownButton.this.b(j);
            }
        };
        this.f14165b = nVar;
        nVar.c();
    }

    public AdCountDownButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14166c = true;
        this.f14169i = false;
        this.j = false;
        this.e = false;
        this.f14164a = context;
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdCountDownButton);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AdCountDownButton_bigo_ad_customLayout, 0);
            typedArrayObtainStyledAttributes.recycle();
            sg.bigo.ads.common.utils.a.a(context, resourceId, this, true);
            this.f14168f = findViewById(R.id.bigo_ad_btn_close);
            this.g = findViewById(R.id.inter_view_stroke);
            this.h = (TextView) findViewById(R.id.inter_text_countdown);
        } catch (Throwable th) {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
            throw th;
        }
    }

    public static /* synthetic */ boolean b(AdCountDownButton adCountDownButton) {
        adCountDownButton.f14166c = true;
        return true;
    }

    public final void a(long j) {
        if (this.f14167d) {
            b(j);
        }
    }

    public final void a(boolean z2) {
        View view;
        View view2;
        f();
        int i2 = 8;
        if (this.e) {
            this.h.setVisibility(8);
            view2 = this.g;
        } else {
            this.h.setVisibility(z2 ? 0 : 8);
            view = this.g;
            if (z2) {
                i2 = 0;
                view.setVisibility(i2);
            }
            view2 = view;
        }
        view = view2;
        view.setVisibility(i2);
    }

    public final boolean a() {
        View view = this.f14168f;
        return view != null && view.performClick();
    }
}
