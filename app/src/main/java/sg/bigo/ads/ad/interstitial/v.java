package sg.bigo.ads.ad.interstitial;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.WeakHashMap;
import sg.bigo.ads.ad.interstitial.d;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public abstract class v extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f15174c = 15;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f15175d = 300;
    public static int e = 255;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.ad.b.c f15176f;

    @NonNull
    protected final sg.bigo.ads.api.a.m g;
    private long h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakHashMap<Object, ValueCallback<Bitmap>> f15177i = new WeakHashMap<>();

    public interface a {
        void a(View view);
    }

    public v(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull sg.bigo.ads.api.a.m mVar) {
        this.f15176f = cVar;
        this.g = mVar;
    }

    @CallSuper
    public final void c(@NonNull r rVar) {
        if (this.f15177i.isEmpty()) {
            return;
        }
        a(rVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.v.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    synchronized (v.this.f15177i) {
                        try {
                            Iterator it = v.this.f15177i.values().iterator();
                            while (it.hasNext()) {
                                ((ValueCallback) it.next()).onReceiveValue(bitmap2);
                            }
                            v.this.f15177i.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        });
    }

    public boolean d() {
        return false;
    }

    public abstract int e();

    public boolean f() {
        return false;
    }

    public static u a(@NonNull r rVar) {
        if (rVar != null) {
            return rVar.Z();
        }
        return null;
    }

    public final sg.bigo.ads.common.p b(r rVar) {
        if (d()) {
            sg.bigo.ads.common.p pVarH = a(rVar).h();
            if (pVarH.a()) {
                return pVarH;
            }
        }
        return s.a(this.f15176f);
    }

    private static void a(View view, int i2) {
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    private void b(r rVar, final View view) {
        int i2;
        if (rVar == null || view == null) {
            return;
        }
        if (d() && (i2 = a(rVar).f15141i) != 0) {
            a(view, i2);
            return;
        }
        Integer numA = s.a((NativeAd) this.f15176f);
        if (numA != null) {
            a(view, numA.intValue());
        } else {
            a(rVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.v.2

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ d.a f15180b = null;

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null) {
                        v.this.a(view, this);
                        return;
                    }
                    Integer numA2 = sg.bigo.ads.common.w.b.a(bitmap2);
                    if (numA2 != null) {
                        d.a aVar = this.f15180b;
                        final int iA = aVar != null ? aVar.a() : numA2.intValue();
                        view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.v.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                final long j = v.a(v.this) ? v.f15175d : 0L;
                                sg.bigo.ads.common.w.b.a(view, iA, new b.a() { // from class: sg.bigo.ads.ad.interstitial.v.2.1.1
                                    @Override // sg.bigo.ads.common.w.b.a
                                    public final long a() {
                                        return j;
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }

    public final void a(View view, ValueCallback<Bitmap> valueCallback) {
        if (view != null) {
            synchronized (this.f15177i) {
                this.f15177i.put(view, valueCallback);
            }
        }
    }

    public void a(@NonNull r rVar, final View view) {
        int i2;
        Bitmap bitmapG;
        if (rVar == null || view == null) {
            return;
        }
        int iE = e();
        if (iE == 2) {
            i2 = ViewCompat.MEASURED_STATE_MASK;
        } else {
            if (iE == 3) {
                b(rVar, view);
                return;
            }
            if (iE == 4) {
                ValueCallback<Bitmap> valueCallback = new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.v.3

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ d.a f15187b = null;

                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        final Bitmap bitmap2 = bitmap;
                        v vVar = v.this;
                        if (bitmap2 == null) {
                            vVar.a(view, this);
                            return;
                        }
                        final long j = v.a(vVar) ? v.f15175d : 0L;
                        final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(view.getContext(), bitmap2);
                        view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.v.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.common.w.b.a(view, new BitmapDrawable(view.getResources(), bitmapB), j);
                                if (AnonymousClass3.this.f15187b != null) {
                                    sg.bigo.ads.common.w.b.a(bitmap2);
                                }
                            }
                        });
                    }
                };
                if (!d() || (bitmapG = a(rVar).g()) == null) {
                    a(rVar, valueCallback);
                    return;
                } else {
                    valueCallback.onReceiveValue(bitmapG);
                    return;
                }
            }
            i2 = -1;
        }
        a(view, i2);
    }

    public static void a(@NonNull r rVar, ValueCallback<Bitmap> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        u uVarA = a(rVar);
        if (uVarA == null) {
            valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(1, 1, Bitmap.Config.ARGB_8888));
        } else {
            uVarA.a(valueCallback);
        }
    }

    public boolean a(@NonNull r rVar, @NonNull ViewGroup viewGroup, @NonNull View view, u.a aVar, int i2, int i8, int i9, @Nullable View... viewArr) {
        u uVarA = a(rVar);
        if (uVarA == null) {
            return false;
        }
        uVarA.a(viewGroup, view, aVar, i2, i8, i9, viewArr);
        sg.bigo.ads.common.utils.u.a(view, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.v.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                v.this.h = SystemClock.elapsedRealtime();
            }
        });
        if (!f()) {
            return true;
        }
        u.a(view);
        return true;
    }

    public static /* synthetic */ boolean a(v vVar) {
        return (vVar.h != 0 ? SystemClock.elapsedRealtime() - vVar.h : 0L) > f15174c;
    }
}
