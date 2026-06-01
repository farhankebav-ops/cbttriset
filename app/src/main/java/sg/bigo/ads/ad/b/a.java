package sg.bigo.ads.ad.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAdView;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.adview.h;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13845a = 1662622472;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f13846b = 5;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0230a {
        boolean a();
    }

    @NonNull
    public static List<View> b(@Nullable List<View> list) {
        int iIntValue;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (View view : list) {
                if (view != null) {
                    Object tag = view.getTag();
                    if ((tag instanceof Integer) && ((iIntValue = ((Integer) tag).intValue()) == 7 || iIntValue == 2 || iIntValue == 6 || iIntValue == 10 || iIntValue == 26 || iIntValue == 8 || iIntValue == 5 || iIntValue == 9)) {
                        arrayList.add(view);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void b(final View view, final View view2, final int i2, final h hVar, @Nullable final InterfaceC0230a interfaceC0230a) {
        final int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        final int[] iArr = {0, 0};
        final boolean[] zArr = {true};
        a(view, view2, new View.OnTouchListener() { // from class: sg.bigo.ads.ad.b.a.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean z2;
                int x2 = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    int[] iArr2 = iArr;
                    iArr2[0] = x2;
                    iArr2[1] = y;
                    zArr[0] = true;
                    if (view3 instanceof MediaView) {
                        ((MediaView) view3).a(x2, y);
                        int unused = a.f13846b = ((Integer) view3.getTag()).intValue();
                    }
                } else if (actionMasked == 2) {
                    if (!a.a(view2, x2, y, scaledTouchSlop)) {
                        zArr[0] = false;
                    }
                } else if (actionMasked == 1) {
                    if (zArr[0]) {
                        if (Math.abs(x2 - iArr[0]) >= scaledTouchSlop || Math.abs(y - iArr[1]) >= scaledTouchSlop) {
                            InterfaceC0230a interfaceC0230a2 = interfaceC0230a;
                            z2 = interfaceC0230a2 != null && interfaceC0230a2.a();
                            if (z2) {
                            }
                        } else {
                            z2 = false;
                        }
                        if (a.a(view3, x2, y)) {
                            return false;
                        }
                        if (view3 instanceof MediaView) {
                            view3.setTag(Integer.valueOf(a.f13846b));
                        }
                        Object tag = (!z2 || interfaceC0230a == null) ? view2.getTag() : 30;
                        sg.bigo.ads.common.t.a.a(0, 4, "NativeAdHelper", "target.getTag: ".concat(String.valueOf(tag)));
                        View view4 = view;
                        View view5 = view2;
                        int[] iArr3 = iArr;
                        a.b(view4, view3, view5, x2, y, iArr3[0], iArr3[1], i2, hVar, tag);
                    }
                } else if (actionMasked == 3) {
                    zArr[0] = false;
                }
                return true;
            }
        });
    }

    public static List<sg.bigo.ads.core.c.a> a(List<c.InterfaceC0279c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (c.InterfaceC0279c interfaceC0279c : list) {
                if (interfaceC0279c != null) {
                    sg.bigo.ads.core.c.a aVar = new sg.bigo.ads.core.c.a();
                    aVar.f16843b = interfaceC0279c.b();
                    aVar.f16842a = interfaceC0279c.a();
                    aVar.f16844c = interfaceC0279c.c();
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, View view2, View view3, int i2, int i8, int i9, int i10, int i11, h hVar, Object obj) {
        while ((view2.getParent() instanceof ViewGroup) && view2 != view && !(view2 instanceof NativeAdView)) {
            i2 += view2.getLeft();
            i9 += view2.getLeft();
            i8 += view2.getTop();
            i10 += view2.getTop();
            view2 = (View) view2.getParent();
        }
        if (obj == null || !(obj instanceof Integer)) {
            obj = view3.getTag();
        }
        hVar.a(i2, i8, i9, i10, i11, obj instanceof Integer ? ((Integer) obj).intValue() : 0);
    }

    @Nullable
    public static c a(@NonNull sg.bigo.ads.api.core.g gVar) {
        m mVarE;
        int iP = gVar.f15496a.P();
        int iW = gVar.f15496a.w();
        int iX = gVar.f15496a.x();
        if (iP == 1 && ((iX == 3 || iX == 4) && iW == 2 && (mVarE = gVar.f15496a.e()) != null && mVarE.a("multi_ads.multi_ads_type") == 1)) {
            return new b(gVar);
        }
        if (iX != 1) {
            if (iX == 2) {
                if (iW == 1) {
                    return new sg.bigo.ads.ad.b.a.a(gVar);
                }
                if (iW == 2) {
                    return new sg.bigo.ads.ad.b.a.b(gVar);
                }
                return null;
            }
            if (iX != 3 && iX != 4 && iX != 12 && iX != 20) {
                switch (iX) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        if (iW == 5) {
                            return new sg.bigo.ads.ad.b.a.c(gVar);
                        }
                        return null;
                    default:
                        if (iW == 1) {
                            return new c(gVar);
                        }
                        if (iW == 2) {
                            return new d(gVar);
                        }
                        if (iW != 5) {
                            return null;
                        }
                        return new sg.bigo.ads.ad.b.a.c(gVar);
                }
            }
        }
        if (iW == 1) {
            return new sg.bigo.ads.ad.b.a.d(gVar);
        }
        if (iW == 2) {
            return new sg.bigo.ads.ad.b.a.e(gVar);
        }
        return null;
    }

    @NonNull
    public static p a(c cVar) {
        p pVar;
        String str;
        n nVarAV = ((sg.bigo.ads.core.a.a) cVar.f()).aV();
        if (nVarAV != null) {
            p pVar2 = new p(nVarAV.f15520a, nVarAV.f15521b);
            if (pVar2.a()) {
                sg.bigo.ads.common.t.a.a(0, 3, "nativeRation", "real size");
                return pVar2;
            }
        }
        if (!(cVar instanceof d)) {
            o.a[] aVarArrAx = ((sg.bigo.ads.core.a.a) cVar.f()).ax();
            if (!k.a(aVarArrAx)) {
                pVar = new p(aVarArrAx[0].a(), aVarArrAx[0].b());
                str = "image first size";
                sg.bigo.ads.common.t.a.a(0, 3, "nativeRation", str);
                return pVar;
            }
            return new p(-1, -1);
        }
        sg.bigo.ads.core.f.a.p pVar3 = ((d) cVar).K;
        if (pVar3 != null) {
            pVar = new p(pVar3.f17065x, pVar3.f17064w);
            if (pVar.a()) {
                str = "video vast size";
                sg.bigo.ads.common.t.a.a(0, 3, "nativeRation", str);
                return pVar;
            }
        }
        return new p(-1, -1);
    }

    public static void a(@NonNull final View view, @NonNull final View view2, final int i2, @Nullable final h hVar, int i8) {
        if (hVar == null) {
            view2.setOnTouchListener(null);
            return;
        }
        if (i8 == 2) {
            final int[] iArr = {0, 0};
            a(view, view2, new View.OnTouchListener() { // from class: sg.bigo.ads.ad.b.a.3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    int x2 = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        if (view3 instanceof MediaView) {
                            ((MediaView) view3).a(x2, y);
                            int unused = a.f13846b = ((Integer) view3.getTag()).intValue();
                        }
                        int[] iArr2 = iArr;
                        iArr2[0] = x2;
                        iArr2[1] = y;
                    }
                    if (actionMasked == 1) {
                        if (a.a(view3, x2, y)) {
                            return false;
                        }
                        if (view3 instanceof MediaView) {
                            view3.setTag(Integer.valueOf(a.f13846b));
                        }
                        sg.bigo.ads.common.t.a.a(0, 4, "NativeAdHelper", "target.getTag: " + view2.getTag());
                        View view4 = view;
                        View view5 = view2;
                        int[] iArr3 = iArr;
                        a.b(view4, view3, view5, x2, y, iArr3[0], iArr3[1], i2, hVar, null);
                    }
                    return true;
                }
            });
        } else if (i8 == 3) {
            b(view, view2, i2, hVar, null);
        } else {
            final int[] iArr2 = {0, 0};
            a(view, view2, new View.OnTouchListener() { // from class: sg.bigo.ads.ad.b.a.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    int x2 = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        if (view3 instanceof MediaView) {
                            ((MediaView) view3).a(x2, y);
                            int unused = a.f13846b = ((Integer) view3.getTag()).intValue();
                        }
                        int[] iArr3 = iArr2;
                        iArr3[0] = x2;
                        iArr3[1] = y;
                    }
                    if (actionMasked == 1) {
                        if (view3 instanceof sg.bigo.ads.api.a) {
                            if (!((sg.bigo.ads.api.a) view3).a(x2, y)) {
                                return false;
                            }
                        } else if (view3 == view || view3.getTag() == 1) {
                            if (!u.a(view3, x2, y)) {
                                return false;
                            }
                        } else if ("internal_ad_component_view".equals(view3.getTag(a.f13845a)) && !u.a(view3, x2, y)) {
                            return false;
                        }
                        if (view3 instanceof MediaView) {
                            view3.setTag(Integer.valueOf(a.f13846b));
                        }
                        sg.bigo.ads.common.t.a.a(0, 4, "NativeAdHelper", "target.getTag: " + view2.getTag());
                        View view4 = view;
                        View view5 = view2;
                        int[] iArr4 = iArr2;
                        a.b(view4, view3, view5, x2, y, iArr4[0], iArr4[1], i2, hVar, null);
                    }
                    return true;
                }
            });
        }
    }

    public static void a(@NonNull View view, @NonNull View view2, int i2, @Nullable h hVar, InterfaceC0230a interfaceC0230a) {
        b(view, view2, i2, hVar, interfaceC0230a);
    }

    private static void a(final View view, final View view2, final View.OnTouchListener onTouchListener) {
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.b.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (motionEvent.getActionMasked() == 0 && view != null) {
                    Object parent = view2.getParent();
                    if ((parent instanceof View) && u.b(((View) parent).findViewWithTag(4), rawX, rawY)) {
                        return false;
                    }
                }
                return onTouchListener.onTouch(view3, motionEvent);
            }
        });
    }

    public static void a(View view, Object obj) {
        if (view != null) {
            view.setTag(obj);
            view.setTag(f13845a, "internal_ad_component_view");
        }
    }

    public static /* synthetic */ boolean a(View view, int i2, int i8) {
        return view instanceof MediaView ? !((MediaView) view).a(i2, i8) : !u.a(view, i2, i8);
    }

    public static /* synthetic */ boolean a(View view, int i2, int i8, int i9) {
        int i10 = -i9;
        return i2 >= i10 && i8 >= i10 && i2 < (view.getRight() - view.getLeft()) + i9 && i8 < (view.getBottom() - view.getTop()) + i9;
    }
}
