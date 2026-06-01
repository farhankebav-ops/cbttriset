package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class g extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected View f14364o;
    protected RoundedImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected TextView f14365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected TextView f14366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected Button f14367s;

    public g(@NonNull sg.bigo.ads.ad.b.c cVar, int i2, @NonNull sg.bigo.ads.api.a.m mVar, @Nullable sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i2, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void a(double d8) {
        TextView textView;
        int i2;
        if (d8 <= 3.0d) {
            textView = this.l;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14442b;
            }
        } else {
            textView = this.l;
            if (textView == null) {
                return;
            } else {
                i2 = sg.bigo.ads.ad.interstitial.d.f14441a;
            }
        }
        textView.setTextColor(sg.bigo.ads.common.w.b.a(i2, 0.6f));
    }

    public final void b(Runnable runnable) {
        super.a(runnable);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void d(sg.bigo.ads.ad.interstitial.r rVar) {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return;
        }
        this.f14364o = viewGroup.findViewById(R.id.inter_end_page);
        l();
        this.f14365q = (TextView) this.k.findViewById(R.id.inter_title);
        this.f14366r = (TextView) this.k.findViewById(R.id.inter_description);
        this.p = (RoundedImageView) this.k.findViewById(R.id.inter_icon);
        sg.bigo.ads.ad.interstitial.b bVar = sg.bigo.ads.ad.interstitial.b.f14273a;
        bVar.a(this.f14365q, this.f14366r);
        bVar.a(this.p);
        a(f(rVar));
    }

    @Override // sg.bigo.ads.ad.interstitial.v
    public final boolean f() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_14_15;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public final void i() {
        String strI = ((sg.bigo.ads.core.a.a) this.f15176f.f()).i();
        TextView textView = (TextView) this.k.findViewById(R.id.inter_advertiser);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else {
            textView.setText(strI);
        }
    }

    public void l() {
        if (this.f14364o != null) {
            float fA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
            this.f14364o.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, -1));
            sg.bigo.ads.ad.interstitial.b.f14273a.b(this.f14364o);
        }
    }

    public void m() {
        if (this.f14367s == null || !j()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.c.e(this.f14367s);
    }

    public void a(int i2) {
        Button button = (Button) this.k.findViewById(R.id.inter_btn_cta);
        this.f14367s = button;
        if (button != null) {
            float fA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 8);
            this.f14367s.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, i2));
            sg.bigo.ads.ad.interstitial.d.a(this.f14367s, sg.bigo.ads.common.w.b.a(i2));
            sg.bigo.ads.ad.interstitial.b.f14273a.a(this.f14367s);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void a(int i2, boolean z2, boolean z7) {
        sg.bigo.ads.ad.b.a.a(this.f14364o, 5);
        if (z2) {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14364o, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.f14364o, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        sg.bigo.ads.ad.b.a.a(this.k, 9);
        if (z7) {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, this.f15176f, i2);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    public void a(final Runnable runnable) {
        final Runnable runnable2 = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.g.1
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable3 = runnable;
                if (runnable3 != null) {
                    runnable3.run();
                }
                g.this.m();
            }
        };
        if (this.k == null) {
            runnable2.run();
        } else {
            sg.bigo.ads.common.utils.u.c(this.f14364o, 0, 0);
            this.k.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new b.a() { // from class: sg.bigo.ads.ad.interstitial.c.g.2.1
                        @Override // sg.bigo.ads.common.utils.b.a
                        public final void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
                            if (transitionValues.view == g.this.f14364o) {
                                Rect rect = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
                                transitionValues.values.put("android:changeBounds:bounds", new Rect(rect.centerX(), rect.centerY(), rect.centerX(), rect.centerY()));
                            }
                        }
                    });
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(g.this.k, transitionSet);
                    sg.bigo.ads.ad.interstitial.c.a(g.this.k, 0.1f, 1.0f, new b.c() { // from class: sg.bigo.ads.ad.interstitial.c.g.2.2
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation) {
                            super.onAnimationEnd(animation);
                            runnable2.run();
                        }
                    });
                    sg.bigo.ads.common.utils.u.c(g.this.f14364o, -1, -2);
                }
            });
        }
    }
}
