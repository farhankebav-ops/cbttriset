package q;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.pedant.SweetAlert.SuccessTickView;
import com.cbt.exam.browser.R;
import com.pnikosis.materialishprogress.ProgressWheel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends Dialog implements View.OnClickListener {
    public Button A;
    public Button B;
    public Button C;
    public final c D;
    public FrameLayout E;
    public f F;
    public f G;
    public boolean H;
    public final boolean I;
    public final float J;
    public final float K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f13350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimationSet f13351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimationSet f13352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f13353d;
    public final Animation e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnimationSet f13354f;
    public final AnimationSet g;
    public final Animation h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f13355i;
    public TextView j;
    public FrameLayout k;
    public String l;
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f13356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13357o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f13358q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f13359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f13360s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SuccessTickView f13361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImageView f13362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f13363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f13364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f13365x;
    public ImageView y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinearLayout f13366z;

    public g(Context context, int i2) {
        super(context, R.style.alert_dialog_light);
        this.I = true;
        this.K = 0.0f;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        float dimension = getContext().getResources().getDimension(R.dimen.buttons_stroke_width);
        this.J = dimension;
        this.K = dimension;
        c cVar = new c();
        cVar.f13344b = context.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1;
        cVar.f13345c = context.getResources().getColor(R.color.success_stroke_color);
        cVar.f13346d = -1.0f;
        cVar.e = context.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
        this.D = cVar;
        this.p = i2;
        this.e = b.b(getContext(), R.anim.error_frame_in);
        this.f13354f = (AnimationSet) b.b(getContext(), R.anim.error_x_in);
        this.h = b.b(getContext(), R.anim.success_bow_roate);
        this.g = (AnimationSet) b.b(getContext(), R.anim.success_mask_layout);
        this.f13351b = (AnimationSet) b.b(getContext(), R.anim.modal_in);
        AnimationSet animationSet = (AnimationSet) b.b(getContext(), R.anim.modal_out);
        this.f13352c = animationSet;
        animationSet.setAnimationListener(new e(this));
        d dVar = new d(this, 1);
        this.f13353d = dVar;
        dVar.setDuration(120L);
    }

    public final void b() {
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f13366z.getChildCount()) {
                z2 = false;
                break;
            }
            View childAt = this.f13366z.getChildAt(i2);
            if ((childAt instanceof Button) && childAt.getVisibility() == 0) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.f13366z.setVisibility(z2 ? 0 : 8);
    }

    public final void c(int i2, boolean z2) {
        this.p = i2;
        if (this.f13350a != null) {
            if (!z2) {
                this.y.setVisibility(8);
                this.f13358q.setVisibility(8);
                this.f13359r.setVisibility(8);
                this.E.setVisibility(8);
                this.f13360s.setVisibility(8);
                this.A.setVisibility(0);
                b();
                this.A.setBackgroundResource(R.drawable.green_button_background);
                this.f13358q.clearAnimation();
                this.f13362u.clearAnimation();
                this.f13361t.clearAnimation();
                this.f13363v.clearAnimation();
                this.f13364w.clearAnimation();
            }
            this.A.setVisibility(0);
            int i8 = this.p;
            if (i8 == 1) {
                this.f13358q.setVisibility(0);
            } else if (i8 == 2) {
                this.f13359r.setVisibility(0);
                View view = this.f13363v;
                AnimationSet animationSet = this.g;
                view.startAnimation(animationSet.getAnimations().get(0));
                this.f13364w.startAnimation(animationSet.getAnimations().get(1));
            } else if (i8 == 3) {
                this.E.setVisibility(0);
            } else if (i8 == 4) {
                Drawable drawable = this.f13365x;
                this.f13365x = drawable;
                ImageView imageView = this.y;
                if (imageView != null && drawable != null) {
                    imageView.setVisibility(0);
                    this.y.setImageDrawable(this.f13365x);
                }
            } else if (i8 == 5) {
                this.f13360s.setVisibility(0);
                this.A.setVisibility(8);
            }
            b();
            if (z2) {
                return;
            }
            e();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        d(true);
    }

    public final void d(boolean z2) {
        this.H = z2;
        ((ViewGroup) this.f13350a).getChildAt(0).startAnimation(this.f13353d);
        this.f13350a.startAnimation(this.f13352c);
    }

    public final void e() {
        int i2 = this.p;
        if (i2 == 1) {
            this.f13358q.startAnimation(this.e);
            this.f13362u.startAnimation(this.f13354f);
            return;
        }
        if (i2 == 2) {
            SuccessTickView successTickView = this.f13361t;
            successTickView.j = 0.0f;
            successTickView.k = 0.0f;
            successTickView.invalidate();
            d dVar = new d(successTickView, 0);
            dVar.setDuration(750L);
            dVar.setStartOffset(100L);
            successTickView.startAnimation(dVar);
            this.f13364w.startAnimation(this.h);
        }
    }

    public final void f(Button button, Integer num) {
        if (button == null || num == null) {
            return;
        }
        DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState) ((StateListDrawable) button.getBackground()).getConstantState();
        Drawable[] children = drawableContainerState != null ? drawableContainerState.getChildren() : null;
        if (children != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) children[1];
            gradientDrawable.setColor(num.intValue());
            int i2 = (int) this.K;
            float[] fArr = new float[3];
            Color.colorToHSV(num.intValue(), fArr);
            fArr[2] = fArr[2] * 0.7f;
            gradientDrawable.setStroke(i2, Color.HSVToColor(fArr));
        }
    }

    public final void g(String str) {
        this.f13356n = str;
        if (this.B == null || str == null) {
            return;
        }
        k();
        this.B.setText(this.f13356n);
    }

    public final void h(String str) {
        this.f13357o = str;
        Button button = this.A;
        if (button == null || str == null) {
            return;
        }
        button.setText(str);
    }

    public final void i(String str) {
        this.m = str;
        TextView textView = this.j;
        if (textView == null || str == null) {
            return;
        }
        textView.setVisibility(0);
        this.j.setText(Html.fromHtml(this.m));
        this.j.setVisibility(0);
        this.k.setVisibility(8);
    }

    public final void j(String str) {
        this.l = str;
        if (this.f13355i == null || str == null) {
            return;
        }
        if (str.isEmpty()) {
            this.f13355i.setVisibility(8);
        } else {
            this.f13355i.setVisibility(0);
            this.f13355i.setText(Html.fromHtml(this.l));
        }
    }

    public final void k() {
        Button button = this.B;
        if (button != null) {
            button.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.cancel_button) {
            f fVar = this.F;
            if (fVar != null) {
                fVar.a(this);
                return;
            } else {
                d(false);
                return;
            }
        }
        if (view.getId() != R.id.confirm_button) {
            if (view.getId() == R.id.neutral_button) {
                d(false);
            }
        } else {
            f fVar2 = this.G;
            if (fVar2 != null) {
                fVar2.a(this);
            } else {
                d(false);
            }
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alert_dialog);
        this.f13350a = getWindow().getDecorView().findViewById(android.R.id.content);
        this.f13355i = (TextView) findViewById(R.id.title_text);
        this.j = (TextView) findViewById(R.id.content_text);
        this.k = (FrameLayout) findViewById(R.id.custom_view_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.error_frame);
        this.f13358q = frameLayout;
        this.f13362u = (ImageView) frameLayout.findViewById(R.id.error_x);
        this.f13359r = (FrameLayout) findViewById(R.id.success_frame);
        this.f13360s = (FrameLayout) findViewById(R.id.progress_dialog);
        this.f13361t = (SuccessTickView) this.f13359r.findViewById(R.id.success_tick);
        this.f13363v = this.f13359r.findViewById(R.id.mask_left);
        this.f13364w = this.f13359r.findViewById(R.id.mask_right);
        this.y = (ImageView) findViewById(R.id.custom_image);
        this.E = (FrameLayout) findViewById(R.id.warning_frame);
        this.f13366z = (LinearLayout) findViewById(R.id.buttons_container);
        Button button = (Button) findViewById(R.id.confirm_button);
        this.A = button;
        button.setOnClickListener(this);
        Button button2 = this.A;
        a aVar = b.f13342a;
        button2.setOnTouchListener(aVar);
        Button button3 = (Button) findViewById(R.id.cancel_button);
        this.B = button3;
        button3.setOnClickListener(this);
        this.B.setOnTouchListener(aVar);
        Button button4 = (Button) findViewById(R.id.neutral_button);
        this.C = button4;
        button4.setOnClickListener(this);
        this.C.setOnTouchListener(aVar);
        ProgressWheel progressWheel = (ProgressWheel) findViewById(R.id.progressWheel);
        c cVar = this.D;
        cVar.f13343a = progressWheel;
        cVar.b();
        j(this.l);
        i(this.m);
        g(this.f13356n);
        h(this.f13357o);
        if (Float.compare(this.J, this.K) != 0) {
            Resources resources = getContext().getResources();
            f(this.A, Integer.valueOf(resources.getColor(R.color.main_green_color)));
            f(this.C, Integer.valueOf(resources.getColor(R.color.main_disabled_color)));
            f(this.B, Integer.valueOf(resources.getColor(R.color.red_btn_bg_color)));
        }
        f(this.A, null);
        f(this.B, null);
        f(this.C, null);
        c(this.p, true);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        this.f13350a.startAnimation(this.f13351b);
        e();
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        j(charSequence.toString());
    }

    @Override // android.app.Dialog
    public final void setTitle(int i2) {
        j(getContext().getResources().getString(i2));
    }
}
