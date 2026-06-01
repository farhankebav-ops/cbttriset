package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public class n extends m {
    private LinearLayout G;
    private RoundedFrameLayout H;
    private TextView I;
    private IconListView J;
    private RoundedFrameLayout K;
    private Button L;
    private sg.bigo.ads.common.utils.n M;
    private ImageView N;
    private boolean O;
    private boolean P;
    private int Q;

    public n(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.O = false;
        this.P = false;
    }

    public static /* synthetic */ void g(n nVar) {
        nVar.P = false;
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        TransitionManager.beginDelayedTransition(nVar.f14451r, transitionSet);
        nVar.G.getMeasuredWidth();
        nVar.c(nVar.G.getMeasuredHeight());
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final boolean C() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final int D() {
        return Integer.MIN_VALUE;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final sg.bigo.ads.ad.interstitial.multi_img.c F() {
        return sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void I() {
        if (this.P) {
            super.I();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void J() {
        super.J();
        if (this.f14452s.h) {
            sg.bigo.ads.ad.b.a.a(this.H, 18);
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.H, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.H, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
        }
        IconListView iconListView = this.J;
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
        sg.bigo.ads.ad.interstitial.x xVar = this.f14452s;
        if (xVar == null || !xVar.g) {
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.E.j, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
        } else {
            sg.bigo.ads.ad.b.a.a(this.E.j, 9);
            sg.bigo.ads.ad.b.a.a(this.f14450q, this.E.j, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14452s.f15199i);
        }
    }

    public int L() {
        return 0;
    }

    public int M() {
        return 0;
    }

    public int N() {
        return 0;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    public final void a(double d8) {
    }

    @Override // sg.bigo.ads.ad.interstitial.e
    public final void c() {
        super.c();
        sg.bigo.ads.common.utils.n nVar = this.M;
        if (nVar == null || nVar.e()) {
            return;
        }
        this.M.d();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    public final void t() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar;
        super.t();
        this.f14455v.setTextColor(sg.bigo.ads.ad.interstitial.d.f14442b);
        ((m) this).f14514x.removeView(this.f14515z);
        this.f14515z.setCornerRadius(0.0f);
        int i2 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.G.addView(this.f14515z, 0, layoutParams);
        sg.bigo.ads.common.utils.u.a(this.G, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.n.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (n.this.O) {
                    return;
                }
                n nVar = n.this;
                nVar.G.getMeasuredWidth();
                nVar.c(n.this.G.getMeasuredHeight());
            }
        });
        this.J.a(this.f14454u);
        if (sg.bigo.ads.common.utils.k.a((Collection) this.J.getItems())) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar = this.B;
        if (cVar != null) {
            cVar.a(false);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.a(false);
        }
        sg.bigo.ads.ad.interstitial.multi_img.a aVar = this.D;
        if (aVar != null) {
            aVar.f14840f = false;
        }
        int iW = w();
        if (iW != 1) {
            if (iW == 2) {
                bVar = this.E;
                i2 = ViewCompat.MEASURED_STATE_MASK;
            }
            K();
            a((b.a) null, false);
        }
        bVar = this.E;
        bVar.b(sg.bigo.ads.common.w.b.b(i2));
        K();
        a((b.a) null, false);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final int x() {
        return 2;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final boolean z() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (this.E == null) {
            return;
        }
        int iN = N();
        int iM = M();
        Context context = this.f14515z.getContext();
        this.E.k.setCornerRadius(L());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.k.getLayoutParams();
        marginLayoutParams.leftMargin = iM;
        boolean z2 = this.P;
        marginLayoutParams.topMargin = z2 ? this.Q + iN : iN;
        marginLayoutParams.rightMargin = iM;
        if (z2) {
            iN += this.Q;
        }
        marginLayoutParams.bottomMargin = iN;
        this.E.k.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14515z.getLayoutParams();
        int i8 = this.Q;
        marginLayoutParams2.topMargin = -i8;
        marginLayoutParams2.height = (i8 * 2) + i2;
        this.f14515z.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.E.f14892a.getLayoutParams();
        marginLayoutParams3.bottomMargin = sg.bigo.ads.common.utils.e.a(context, 12) + this.Q;
        this.E.f14892a.setLayoutParams(marginLayoutParams3);
        RoundedFrameLayout roundedFrameLayout = this.H;
        int i9 = this.Q;
        roundedFrameLayout.a(i9, i9, 0.0f, 0.0f);
        this.H.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        layoutParams.topMargin = -this.Q;
        this.H.setLayoutParams(layoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void a(int i2, boolean z2, int i8, boolean z7) {
        super.a(i2, z2, i2, false);
    }

    @Override // sg.bigo.ads.ad.interstitial.e
    public final void b() {
        super.b();
        sg.bigo.ads.common.utils.n nVar = this.M;
        if (nVar == null || !nVar.e()) {
            return;
        }
        this.M.c();
    }

    public static /* synthetic */ void c(n nVar) {
        nVar.O = true;
        nVar.P = true;
        nVar.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.3
            @Override // java.lang.Runnable
            public final void run() {
                n nVar2 = n.this;
                nVar2.G.getMeasuredWidth();
                nVar2.c(n.this.G.getMeasuredHeight());
                n.this.N.setVisibility(4);
            }
        });
        final float fA = sg.bigo.ads.common.utils.e.a(nVar.f14450q.getContext(), 252);
        final float measuredWidth = nVar.f14515z.getMeasuredWidth();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(((sg.bigo.ads.ad.interstitial.u) nVar).f15138c);
        if (pVarA.a()) {
            float f4 = measuredWidth / fA;
            int i2 = pVarA.f15849b;
            int i8 = pVarA.f15850c;
            if (f4 < (i2 * 1.0f) / i8) {
                fA = ((i8 * measuredWidth) * 1.0f) / i2;
            }
        }
        nVar.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.4
            @Override // java.lang.Runnable
            public final void run() {
                n.b(n.this, (int) fA);
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void b(int i2) {
        super.b(i2);
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) Math.max(1, i2)) * 1000) { // from class: sg.bigo.ads.ad.interstitial.d.n.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                n.this.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.c(n.this);
                    }
                });
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.M = nVar;
        nVar.c();
    }

    public static /* synthetic */ void b(n nVar, int i2) {
        long jA;
        sg.bigo.ads.common.utils.r rVar;
        final boolean zV = nVar.v();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.n.7
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                if (zV) {
                    sg.bigo.ads.ad.interstitial.c.e(n.this.K);
                }
                n.this.I();
            }
        });
        TransitionManager.beginDelayedTransition(nVar.f14451r, transitionSet);
        nVar.a(new b.a(), true);
        nVar.c(i2);
        sg.bigo.ads.ad.interstitial.f fVar = nVar.f14454u;
        if (fVar != null) {
            int i8 = fVar.f14697b;
            int i9 = 3;
            if (i8 == 1) {
                rVar = sg.bigo.ads.common.utils.r.f16034a;
            } else if (i8 != 2) {
                if (i8 == 3) {
                    rVar = sg.bigo.ads.common.utils.r.f16034a;
                    i9 = 10;
                }
                jA = 0;
            } else {
                rVar = sg.bigo.ads.common.utils.r.f16034a;
                i9 = 5;
            }
            jA = rVar.a(i9);
        } else {
            jA = 0;
        }
        long jMax = Math.max(0L, jA);
        if (jMax == 0) {
            nVar.N.setVisibility(0);
        } else {
            nVar.N.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) ((sg.bigo.ads.ad.interstitial.u) n.this).f15138c)) {
                        return;
                    }
                    TransitionSet transitionSet2 = new TransitionSet();
                    transitionSet2.addTransition(new Fade());
                    TransitionManager.beginDelayedTransition(n.this.H, transitionSet2);
                    n.this.N.setVisibility(0);
                }
            }, jMax);
        }
        nVar.N.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.d.n.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.g(n.this);
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final void a(sg.bigo.ads.ad.interstitial.r rVar) {
        super.a(rVar);
        this.G = (LinearLayout) this.f14450q.findViewById(R.id.inter_media_container);
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.f14450q.findViewById(R.id.inter_media_gp_container);
        this.H = roundedFrameLayout;
        this.I = (TextView) roundedFrameLayout.findViewById(R.id.inter_company);
        this.J = (IconListView) this.H.findViewById(R.id.inter_download_msg);
        RoundedFrameLayout roundedFrameLayout2 = (RoundedFrameLayout) this.H.findViewById(R.id.inter_btn_cta_layout);
        this.K = roundedFrameLayout2;
        this.L = (Button) roundedFrameLayout2.findViewById(R.id.inter_btn_cta);
        this.N = (ImageView) this.H.findViewById(R.id.inter_gp_btn_close);
        this.Q = sg.bigo.ads.common.utils.e.a(this.f14450q.getContext(), 12);
    }

    private void a(b.a aVar, boolean z2) {
        a.C0259a c0259aU = u();
        Button button = this.L;
        if (button != null) {
            sg.bigo.ads.ad.interstitial.d.a(button, c0259aU.f14479a, aVar);
        }
        TextView textView = this.I;
        if (textView != null) {
            textView.setTextColor(c0259aU.f14479a);
        }
        if (z2 && c0259aU.f14480b) {
            a(this.L, new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.n.8
                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i2) {
                    super.b(i2);
                    if (n.this.I != null) {
                        n.this.I.setTextColor(i2);
                    }
                }
            });
        }
    }
}
