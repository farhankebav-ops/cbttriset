package sg.bigo.ads.ad.interstitial.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.b.a;
import sg.bigo.ads.ad.interstitial.multi_img.view.d;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public class m extends a {
    protected LinearLayout A;
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c B;
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c C;
    protected sg.bigo.ads.ad.interstitial.multi_img.a D;
    protected sg.bigo.ads.ad.interstitial.multi_img.view.b E;
    protected sg.bigo.ads.ad.interstitial.multi_img.b F;
    private final Set<sg.bigo.ads.ad.interstitial.multi_img.view.d> G;
    private final a.InterfaceC0230a H;
    private final AtomicBoolean I;
    private final List<Runnable> J;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected ViewFlow f14514x;
    protected Indicator y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected RoundedFrameLayout f14515z;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.m$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14540a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.multi_img.d.values().length];
            f14540a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.multi_img.d.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14540a[sg.bigo.ads.ad.interstitial.multi_img.d.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14540a[sg.bigo.ads.ad.interstitial.multi_img.d.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14540a[sg.bigo.ads.ad.interstitial.multi_img.d.TILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public m(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.G = new HashSet();
        this.H = new a.InterfaceC0230a() { // from class: sg.bigo.ads.ad.interstitial.d.m.1
            @Override // sg.bigo.ads.ad.b.a.InterfaceC0230a
            public final boolean a() {
                ViewFlow viewFlow = m.this.f14514x;
                if (viewFlow != null) {
                    return viewFlow.h;
                }
                return false;
            }
        };
        this.I = new AtomicBoolean(false);
        this.J = new ArrayList();
    }

    public final void A() {
        int iA = this.f14514x.a(this.E.j);
        if (iA < 0 || iA == this.f14514x.getCurrentItem()) {
            return;
        }
        this.f14514x.b(iA);
    }

    @Nullable
    public final sg.bigo.ads.api.a.m B() {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.F;
        if (bVar != null) {
            return bVar.f14843a;
        }
        return null;
    }

    public boolean C() {
        return E() == sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    public int D() {
        return w();
    }

    public sg.bigo.ads.ad.interstitial.multi_img.d E() {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.F;
        return bVar != null ? bVar.f14844b : sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    public sg.bigo.ads.ad.interstitial.multi_img.c F() {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.F;
        return bVar != null ? bVar.f14846d : sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF;
    }

    public final void G() {
        this.I.set(true);
    }

    public final void H() {
        this.I.set(false);
        if (sg.bigo.ads.ad.interstitial.multi_img.f.a(this.f14514x)) {
            sg.bigo.ads.ad.interstitial.multi_img.f.a(this.f14514x, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.d.m.14
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Integer num) {
                    Iterator it = m.this.J.iterator();
                    while (it.hasNext()) {
                        m.this.f14514x.post((Runnable) it.next());
                    }
                    m.this.J.clear();
                    sg.bigo.ads.ad.interstitial.multi_img.f.a(m.this.f14514x, (ValueCallback<Integer>) null);
                }
            });
            return;
        }
        Iterator<Runnable> it = this.J.iterator();
        while (it.hasNext()) {
            this.f14514x.post(it.next());
        }
        this.J.clear();
    }

    public void I() {
        if (C()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.F;
        int iA = bVar != null ? bVar.f14843a.a("video_play_page.multi_guide") : 0;
        switch (iA) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                a(iA, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.m.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.f14514x.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.m.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                m mVar = m.this;
                                if (mVar.f14514x.g) {
                                    return;
                                }
                                m.a(mVar, 3L, 0L, 300L);
                            }
                        });
                    }
                });
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.f14514x.setFlipInterval((iA - 5) * 1000);
                this.f14514x.c();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.d.m.J():void");
    }

    public final boolean K() {
        View viewA;
        ViewFlow viewFlow = this.f14514x;
        if (viewFlow == null) {
            return false;
        }
        List<View> items = viewFlow.getItems();
        if (sg.bigo.ads.common.utils.k.a((Collection) items) || items.size() != 1 || (viewA = this.f14514x.a(0)) == null) {
            return false;
        }
        Object tag = viewA.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
        if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
            sg.bigo.ads.ad.interstitial.multi_img.view.d dVar = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
            sg.bigo.ads.ad.interstitial.multi_img.c cVar = sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_PARENT;
            dVar.a(cVar);
            dVar.a(4);
            this.f14514x.setViewStyle(3);
            ((ViewFlow.b) viewA.getLayoutParams()).f16161d = cVar.f14860d;
            return true;
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a, sg.bigo.ads.ad.interstitial.u
    public final void f() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = this.E;
        if (bVar != null) {
            ((MediaView) bVar.l).c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final ViewGroup k() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = this.E;
        if (bVar != null) {
            return bVar.k;
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final MediaView l() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = this.E;
        if (bVar != null) {
            return (MediaView) bVar.l;
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final Button m() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = this.E;
        if (bVar != null) {
            return bVar.f14892a;
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void p() {
        super.p();
        synchronized (this.G) {
            try {
                if (!this.G.isEmpty()) {
                    final HashSet hashSet = new HashSet(this.G);
                    this.G.clear();
                    a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.m.11
                        @Override // android.webkit.ValueCallback
                        public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null) {
                                synchronized (m.this.G) {
                                    m.this.G.addAll(hashSet);
                                }
                                return;
                            }
                            for (sg.bigo.ads.ad.interstitial.multi_img.view.d dVar : hashSet) {
                                if (dVar instanceof sg.bigo.ads.ad.interstitial.multi_img.view.b) {
                                    ((sg.bigo.ads.ad.interstitial.multi_img.view.b) dVar).a(bitmap2);
                                } else if (dVar instanceof sg.bigo.ads.ad.interstitial.multi_img.view.a) {
                                    ((sg.bigo.ads.ad.interstitial.multi_img.view.a) dVar).a(bitmap2);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @CallSuper
    public void t() {
        m mVar = this;
        super.t();
        Context context = mVar.f14450q.getContext();
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = mVar.F;
        List<String> listA = bVar != null ? bVar.a() : null;
        sg.bigo.ads.ad.interstitial.multi_img.b bVar2 = mVar.F;
        boolean z2 = bVar2 != null && bVar2.e;
        sg.bigo.ads.ad.interstitial.multi_img.d dVarE = mVar.E();
        sg.bigo.ads.ad.interstitial.multi_img.c cVarF = mVar.F();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(((sg.bigo.ads.ad.interstitial.u) mVar).f15138c);
        mVar.f14514x = (ViewFlow) mVar.f14450q.findViewById(R.id.inter_media_ad_view_flow);
        mVar.y = (Indicator) mVar.f14450q.findViewById(R.id.inter_vf_indicator);
        int iX = mVar.x();
        if (iX == 3 || iX == 4) {
            mVar.D = new sg.bigo.ads.ad.interstitial.multi_img.a(mVar.f14450q, mVar.f14514x, mVar.f14449o, iX);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar3 = new sg.bigo.ads.ad.interstitial.multi_img.view.b(context, cVarF, mVar.z(), mVar.w(), iX);
        mVar.E = bVar3;
        mVar.f14515z = bVar3.j;
        ((MediaView) bVar3.l).setImageBlurBorder(false);
        mVar.E.a(pVarA.f15849b, pVarA.f15850c);
        if (mVar.E.b()) {
            final boolean zAR = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) mVar).f15138c.f()).aR();
            if (zAR) {
                synchronized (mVar.G) {
                    mVar.G.add(mVar.E);
                }
            }
            if (mVar.D != null) {
                mVar.E.f14908r = new d.a() { // from class: sg.bigo.ads.ad.interstitial.d.m.8
                    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                    public final void a() {
                        m mVar2 = m.this;
                        m.this.D.a(mVar2.f14514x.a(mVar2.E.j));
                    }

                    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                    public final void b() {
                        m.this.E.f14908r = null;
                        a();
                    }
                };
            }
            mVar.a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.m.9
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        if (zAR) {
                            synchronized (m.this.G) {
                                m.this.G.remove(m.this.E);
                            }
                        }
                        m.this.E.a(bitmap2);
                    }
                }
            });
        }
        mVar.A = (LinearLayout) mVar.f14450q.findViewById(R.id.inter_media_bottom_layout);
        if (sg.bigo.ads.common.utils.q.a((CharSequence) ((sg.bigo.ads.ad.interstitial.u) mVar).f15138c.getWarning())) {
            ((ViewGroup.MarginLayoutParams) mVar.A.getLayoutParams()).topMargin = sg.bigo.ads.common.utils.e.a(context, 8);
        }
        mVar.a(mVar.p);
        if (mVar.F != null) {
            mVar.f14514x.setDividerWidth(sg.bigo.ads.common.utils.e.a(context, dVarE.f14865f));
            mVar.f14514x.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context, dVarE.f14866i));
            mVar.f14514x.setViewStyle(dVarE.j);
            mVar.f14514x.setOnItemChangeListener(new sg.bigo.ads.ad.interstitial.multi_img.f(dVarE, mVar.y, mVar.D));
            int i2 = 0;
            int i8 = 0;
            while (listA != null && i8 < listA.size()) {
                String str = listA.get(i8);
                if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                    mVar.a(context, cVarF, iX, str, ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) mVar).f15138c.f()).al());
                    i2++;
                }
                i8++;
                mVar = this;
            }
            int iMax = Math.max(dVarE == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? 2 - i2 : 0, 0);
            if (z2) {
                iMax = Math.max(iMax, 1);
            }
            int i9 = 0;
            while (i9 < iMax) {
                int i10 = i2 + 1;
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVarA = a(context, cVarF, iX, (String) null, false);
                final boolean zAR2 = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) this).f15138c.f()).aR();
                if (zAR2) {
                    synchronized (this.G) {
                        this.G.add(aVarA);
                    }
                }
                a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.m.10
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            if (zAR2) {
                                synchronized (m.this.G) {
                                    m.this.G.remove(aVarA);
                                }
                            }
                            aVarA.a(bitmap2);
                        }
                    }
                });
                i9++;
                i2 = i10;
            }
            mVar = this;
            sg.bigo.ads.ad.interstitial.multi_img.d dVar = sg.bigo.ads.ad.interstitial.multi_img.d.CENTER;
            int i11 = dVarE == dVar ? i2 >> 1 : 0;
            ViewFlow.b bVar4 = new ViewFlow.b();
            bVar4.f16158a = pVarA.f15849b;
            bVar4.f16159b = pVarA.f15850c;
            bVar4.f16160c = true;
            bVar4.f16161d = cVarF.f14860d;
            mVar.f14514x.addView(mVar.f14515z, Math.max(0, i11), bVar4);
            int i12 = AnonymousClass6.f14540a[dVarE.ordinal()];
            if (i12 == 1 || i12 == 2 || i12 == 3 || i12 == 4) {
                ViewFlow.d dVar2 = new ViewFlow.d() { // from class: sg.bigo.ads.ad.interstitial.d.m.3
                    @Override // sg.bigo.ads.common.view.ViewFlow.d
                    public final void a() {
                        ((sg.bigo.ads.ad.interstitial.u) m.this).f15138c.a(8, 29);
                    }
                };
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context, true);
                mVar.B = cVar;
                mVar.f14514x.setStartView(cVar.f14895a);
                mVar.f14514x.setOnStartViewShowListener(dVar2);
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context, false);
                mVar.C = cVar2;
                mVar.f14514x.setEndView(cVar2.f14895a);
                mVar.f14514x.setOnEndViewShowListener(dVar2);
            }
            int iA = dVarE == dVar ? mVar.f14514x.a(mVar.f14515z) : 0;
            mVar.f14514x.b(iA);
            sg.bigo.ads.ad.interstitial.multi_img.a aVar = mVar.D;
            if (aVar != null) {
                aVar.b(iA);
            }
        }
        mVar.b(mVar.y());
        mVar.I();
    }

    public boolean z() {
        return false;
    }

    private sg.bigo.ads.ad.interstitial.multi_img.view.a a(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i2, String str, boolean z2) {
        final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar = new sg.bigo.ads.ad.interstitial.multi_img.view.a(context, this.F, cVar, D(), i2, str, z2, new ValueCallback<sg.bigo.ads.ad.interstitial.multi_img.view.a>() { // from class: sg.bigo.ads.ad.interstitial.d.m.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(sg.bigo.ads.ad.interstitial.multi_img.view.a aVar2) {
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar3 = aVar2;
                m.this.a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.m.4.1
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            synchronized (m.this.G) {
                                m.this.G.remove(aVar3);
                            }
                            aVar3.a(bitmap2);
                        }
                    }
                });
            }
        });
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f16158a = -1;
        bVar.f16159b = -1;
        bVar.f16160c = false;
        bVar.f16161d = cVar.f14860d;
        this.f14514x.addView(aVar.j, bVar);
        if (this.D != null) {
            aVar.f14908r = new d.a() { // from class: sg.bigo.ads.ad.interstitial.d.m.5
                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void a() {
                    m.this.D.a(m.this.f14514x.a(aVar.j));
                }

                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void b() {
                    aVar.f14908r = null;
                    a();
                }
            };
        }
        return aVar;
    }

    public void b(int i2) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public void a(double d8) {
        if (d8 <= 3.0d) {
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar = this.B;
            if (cVar != null) {
                cVar.a(false);
            }
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = this.C;
            if (cVar2 != null) {
                cVar2.a(false);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar3 = this.B;
        if (cVar3 != null) {
            cVar3.a(true);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar4 = this.C;
        if (cVar4 != null) {
            cVar4.a(true);
        }
    }

    public void a(int i2, boolean z2, int i8, boolean z7) {
        T t3;
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar = this.E;
        if (bVar == null || (t3 = bVar.l) == 0) {
            return;
        }
        if (z7) {
            sg.bigo.ads.ad.b.a.a(this.f14450q, t3, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.H);
        } else {
            sg.bigo.ads.ad.b.a.a(this.f14450q, t3, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, i8);
        }
        if (z2) {
            ((MediaView) this.E.l).setMediaAreaClickable(true);
            ((MediaView) this.E.l).b().a(false);
        } else {
            ((MediaView) this.E.l).setMediaAreaClickable(false);
            ((MediaView) this.E.l).b().a(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(@NonNull ViewGroup viewGroup, @NonNull View view, final u.a aVar, int i2, int i8, int i9, @Nullable View... viewArr) {
        super.a(viewGroup, view, new u.a() { // from class: sg.bigo.ads.ad.interstitial.d.m.7
            @Override // sg.bigo.ads.ad.interstitial.u.a
            public final Pair<String, String> a(@NonNull TextView textView, @Nullable String str, @Nullable String str2) {
                if (textView != null && textView.getTag() == 2 && sg.bigo.ads.common.utils.q.a((CharSequence) str2)) {
                    str2 = ((sg.bigo.ads.ad.interstitial.u) m.this).f15138c.getDescription();
                }
                u.a aVar2 = aVar;
                return aVar2 != null ? aVar2.a(textView, str, str2) : Pair.create(str, str2);
            }
        }, i2, i8, i9, viewArr);
        J();
    }

    public final void a(sg.bigo.ads.ad.interstitial.a aVar, @NonNull ViewGroup viewGroup, @NonNull sg.bigo.ads.ad.interstitial.x xVar, @NonNull sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.f fVar) {
        this.F = bVar;
        a(aVar, viewGroup, xVar, bVar.f14843a, fVar);
    }

    public static /* synthetic */ void a(m mVar, final long j, long j3, final long j8) {
        if (j > 0) {
            ViewFlow viewFlow = mVar.f14514x;
            if (!viewFlow.g && !viewFlow.e()) {
                mVar.f14514x.setScrollEnabled(false);
                int iA = sg.bigo.ads.common.utils.e.a(mVar.f14450q.getContext(), 40);
                final int scrollX = mVar.f14514x.getScrollX();
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iA, 0);
                valueAnimatorOfInt.setDuration(2 * j8);
                valueAnimatorOfInt.setStartDelay(j3);
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                final AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.d.m.12
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        m.a(m.this, j - 1, 300L, j8);
                    }
                };
                valueAnimatorOfInt.addListener(animatorListenerAdapter);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.d.m.13
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (atomicBoolean.get()) {
                            return;
                        }
                        if (m.this.I.get()) {
                            atomicBoolean.set(true);
                            valueAnimator.removeListener(animatorListenerAdapter);
                            valueAnimator.cancel();
                            m.this.J.add(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.m.13.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                    m.a(m.this, j, 300L, j8);
                                }
                            });
                            return;
                        }
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue instanceof Integer) {
                            m.this.f14514x.scrollTo(((Integer) animatedValue).intValue() + scrollX, m.this.f14514x.getScrollY());
                        }
                    }
                });
                valueAnimatorOfInt.start();
                return;
            }
        }
        mVar.f14514x.setScrollEnabled(true);
    }

    public void a(sg.bigo.ads.ad.interstitial.r rVar) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void r() {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void s() {
    }
}
