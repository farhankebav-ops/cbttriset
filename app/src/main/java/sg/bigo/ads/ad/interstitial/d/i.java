package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.ad.interstitial.d.b;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.RoundedImageView;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public class i extends g {
    private IconListView N;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.i$4, reason: invalid class name */
    public class AnonymousClass4 implements u.a {
        public AnonymousClass4() {
        }

        @Override // sg.bigo.ads.common.utils.u.a
        public final void a(@NonNull Rect rect) {
            i.this.B();
        }
    }

    public i(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    public static /* synthetic */ void a(i iVar) {
        if (((b) iVar).y == null || iVar.f14456w) {
            return;
        }
        final boolean zV = iVar.v();
        final boolean[] zArr = {false, false};
        Context context = ((b) iVar).y.getContext();
        int iA = sg.bigo.ads.common.utils.e.a(context, 12);
        int iA2 = sg.bigo.ads.common.utils.e.a(context, 8);
        int iA3 = sg.bigo.ads.common.utils.e.a(context, 48);
        final a.C0259a c0259aU = iVar.u();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new b.a());
        transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.i.3
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                boolean[] zArr2 = zArr;
                zArr2[0] = true;
                sg.bigo.ads.ad.interstitial.multi_img.e.a(i.this.G, true, zArr2[1], zV);
            }

            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionStart(final Transition transition) {
                sg.bigo.ads.common.w.b.a(((b) i.this).y, -1, new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.i.3.1
                    @Override // sg.bigo.ads.common.w.b.a
                    public final long a() {
                        return transition.getDuration();
                    }
                });
                Button button = i.this.G;
                sg.bigo.ads.ad.interstitial.multi_img.e.a(button, button, c0259aU.f14479a, zArr, zV, transition.getDuration());
            }
        });
        transitionSet.setDuration(300L);
        TransitionManager.beginDelayedTransition(iVar.f14451r, transitionSet);
        TextView textView = iVar.E;
        if (textView != null) {
            sg.bigo.ads.common.w.b.a(textView.getCurrentTextColor(), sg.bigo.ads.ad.interstitial.b.f14273a.f14277f, transitionSet.getDuration(), iVar.E);
        }
        TextView textView2 = iVar.F;
        if (textView2 != null) {
            sg.bigo.ads.common.w.b.a(textView2.getCurrentTextColor(), sg.bigo.ads.ad.interstitial.b.f14273a.g, transitionSet.getDuration(), iVar.F);
        }
        ((b) iVar).y.setOutlineProvider(new sg.bigo.ads.common.view.b.b(sg.bigo.ads.common.utils.e.a(context, 12)));
        ((b) iVar).y.setPadding(iA, iA, iA, iA);
        ((b) iVar).y.getLayoutParams().width = sg.bigo.ads.common.utils.e.a(((b) iVar).y.getContext(), 288);
        LinearLayout linearLayout = ((g) iVar).M;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(iA3);
            ((RelativeLayout.LayoutParams) ((g) iVar).M.getLayoutParams()).addRule(0, 0);
        }
        RoundedImageView roundedImageView = iVar.I;
        if (roundedImageView != null) {
            ViewGroup.LayoutParams layoutParams = roundedImageView.getLayoutParams();
            layoutParams.width = iA3;
            layoutParams.height = iA3;
        }
        TextView textView3 = iVar.E;
        if (textView3 != null) {
            textView3.setMaxLines(2);
        }
        int id = R.id.inter_text_layout;
        IconListView iconListView = iVar.N;
        if (iconListView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) iconListView.getLayoutParams();
            if (sg.bigo.ads.common.utils.k.a((Collection) iVar.N.getItems())) {
                iVar.N.setVisibility(8);
            } else {
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.topMargin = iA2;
                id = iVar.N.getId();
                iVar.N.setVisibility(0);
                sg.bigo.ads.ad.interstitial.c.a(10, 100, 300L, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.d.i.5
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Integer num) {
                        i.this.N.setAlpha((num.intValue() * 1.0f) / 100.0f);
                    }
                }, new ValueCallback<Void>() { // from class: sg.bigo.ads.ad.interstitial.d.i.6
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Void r1) {
                    }
                });
                iA = iA2;
            }
        }
        Button button = iVar.G;
        if (button != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) button.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.addRule(3, id);
            layoutParams3.addRule(1, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = iA;
        }
        sg.bigo.ads.ad.interstitial.b bVar = sg.bigo.ads.ad.interstitial.b.f14273a;
        bVar.a(iVar.E, iVar.F);
        bVar.b(((b) iVar).y);
        bVar.a(iVar.G);
        bVar.a(iVar.I);
        ((b) iVar).y.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void A() {
        if (((b) this).y == null) {
            return;
        }
        int iMax = Math.max(1, super.y());
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.1
            @Override // java.lang.Runnable
            public final void run() {
                i.a(i.this);
            }
        };
        a(iMax, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.2
            @Override // java.lang.Runnable
            public final void run() {
                ((b) i.this).y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.i.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (i.this.N != null) {
                            ((RelativeLayout.LayoutParams) i.this.N.getLayoutParams()).width = (((b) i.this).y.getMeasuredWidth() - ((b) i.this).y.getPaddingLeft()) - ((b) i.this).y.getPaddingRight();
                            i.this.N.requestLayout();
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ((b) i.this).y.post(runnable);
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void G() {
        super.G();
        IconListView iconListView = this.N;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i2 = 0; items != null && i2 < items.size(); i2++) {
                IconListView.a aVar = items.get(i2);
                sg.bigo.ads.ad.b.a.a(aVar.f14881d, 26);
                sg.bigo.ads.ad.b.a.a(this.f14450q, aVar.f14881d, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.f14450q, aVar.g, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g
    public final void c(int i2) {
        Button button = this.G;
        if (button != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(1);
            LinearLayout linearLayout = ((g) this).M;
            if (linearLayout != null) {
                ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).addRule(0, this.G.getId());
            }
        }
        super.c(i2);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final int y() {
        return Math.min(0, super.y());
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g, sg.bigo.ads.ad.interstitial.d.b
    public final int z() {
        return R.id.inter_component_26;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g, sg.bigo.ads.ad.interstitial.d.b
    public final boolean a(@NonNull sg.bigo.ads.ad.interstitial.b bVar) {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout;
        if (!super.a(bVar) || (realtimeBlurLinearLayout = ((b) this).y) == null) {
            return false;
        }
        IconListView iconListView = (IconListView) realtimeBlurLinearLayout.findViewById(R.id.inter_download_msg);
        this.N = iconListView;
        iconListView.a(this.f14454u);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.g
    public final void b(int i2) {
    }
}
