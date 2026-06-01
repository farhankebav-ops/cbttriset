package sg.bigo.ads.ad.splash.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Iterator;
import sg.bigo.ads.R;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends b {
    public static float l = 20.0f;
    private sg.bigo.ads.common.q.b m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f15334o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f15335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final float[] f15336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f15337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View.OnTouchListener f15339u;

    public d(sg.bigo.ads.api.core.g gVar, @NonNull m mVar, m mVar2, @NonNull sg.bigo.ads.ad.splash.b bVar) {
        super(gVar, mVar, mVar2, bVar);
        this.f15333n = true;
        this.f15334o = 0.0f;
        this.p = 0.0f;
        this.f15335q = -1.0f;
        this.f15336r = new float[]{-1.0f, -1.0f, -1.0f};
        this.f15337s = 0L;
        this.f15339u = new View.OnTouchListener() { // from class: sg.bigo.ads.ad.splash.a.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    sg.bigo.ads.common.t.a.a(0, 3, "splashSlide", "down...");
                    d.this.f15334o = motionEvent.getX();
                    d.this.p = motionEvent.getY();
                    return true;
                }
                if (action == 1) {
                    int iA = d.a(Math.round(d.this.f15334o), Math.round(d.this.p), Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
                    sg.bigo.ads.common.t.a.a(0, 3, "splashSlide", "up...".concat(String.valueOf(iA)));
                    if (iA > 30) {
                        d.c(d.this);
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public static /* synthetic */ float a(int i2) {
        if (i2 != 4) {
            return (i2 == 9 || i2 == 1) ? 4.0f : 20.0f;
        }
        return 20.0f;
    }

    private int l() {
        return sg.bigo.ads.ad.splash.a.b(this.f15301b) ? R.layout.bigo_ad_splash_style_halfscreen_interaction : R.layout.bigo_ad_splash_style_fullscreen_interaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        m mVar = this.f15302c;
        if (mVar == null) {
            return 0;
        }
        return mVar.a("video_play_page.interactive_method", 0);
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void c() {
        super.c();
        sg.bigo.ads.common.q.b bVar = this.m;
        if (bVar != null) {
            SensorManager sensorManager = bVar.f15924c;
            if (sensorManager != null) {
                sensorManager.unregisterListener(bVar.g);
                bVar.g = null;
                bVar.f15924c = null;
            }
            bVar.f15923b = null;
            this.m = null;
        }
        this.f15339u = null;
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    public final int e() {
        if (this.f15302c != null && f()) {
            return sg.bigo.ads.ad.splash.a.b(this.f15301b) ? R.layout.bigo_ad_splash_style_halfscreen_interaction : R.layout.bigo_ad_splash_style_fullscreen_interaction_immersive;
        }
        return l();
    }

    @Override // sg.bigo.ads.ad.splash.a.b
    public final boolean g() {
        return false;
    }

    public static /* synthetic */ void c(d dVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - dVar.f15337s;
        if (!dVar.f15333n || j <= 2000) {
            return;
        }
        dVar.f15337s = jElapsedRealtime;
        dVar.h.f15396x.a(8, 22);
    }

    public static /* synthetic */ int a(int i2, int i8, int i9, int i10) {
        return Math.max(Math.abs(i2 - i9), Math.abs(i8 - i10));
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2) {
        super.a(z2);
        this.f15333n = z2;
    }

    @Override // sg.bigo.ads.ad.splash.a.b, sg.bigo.ads.ad.splash.a.c
    public final void a(boolean z2, @NonNull ViewGroup viewGroup, int i2) {
        super.a(z2, viewGroup, i2);
        if (!z2 || this.f15338t) {
            return;
        }
        sg.bigo.ads.ad.splash.a.f15259a = true;
        this.f15338t = true;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.inter_fl_interaction_container);
        int i8 = R.layout.bigo_ad_item_interaction_vertical;
        if (this.h.getStyle() == SplashAd.Style.HORIZONTAL) {
            i8 = R.layout.bigo_ad_item_interaction_horizontal;
        }
        if (viewGroup2 != null) {
            View viewA = sg.bigo.ads.common.utils.a.a(viewGroup2.getContext(), i8, viewGroup2, false);
            viewGroup2.removeAllViews();
            viewGroup2.addView(viewA);
            ImageView imageView = (ImageView) viewA.findViewById(R.id.inter_iv_interaction_arrow);
            ImageView imageView2 = (ImageView) viewA.findViewById(R.id.inter_iv_interaction_phone);
            TextView textView = (TextView) viewA.findViewById(R.id.inter_tv_interaction_type);
            if (imageView != null && imageView2 != null && textView != null) {
                int iM = m();
                int i9 = R.drawable.bigo_ad_interaction_shake_arrow;
                int i10 = R.drawable.bigo_ad_interaction_shake_phone;
                String string = viewA.getContext().getString(R.string.bigo_ad_interaction_shake);
                if (iM != 1) {
                    if (iM == 2) {
                        i10 = R.drawable.bigo_ad_interaction_slide_hand;
                        i9 = R.drawable.bigo_ad_interaction_slide_line;
                        string = viewA.getContext().getString(R.string.bigo_ad_interaction_slide);
                    } else if (iM == 3) {
                        i9 = R.drawable.bigo_ad_interaction_twist_arrow;
                        string = viewA.getContext().getString(R.string.bigo_ad_interaction_twist);
                        i10 = sg.bigo.ads.ad.splash.a.b() ? R.drawable.bigo_ad_interaction_twist_landscape_phone : R.drawable.bigo_ad_interaction_twist_phone;
                    }
                } else if (sg.bigo.ads.ad.splash.a.b()) {
                    i10 = R.drawable.bigo_ad_interaction_shake_landscape_phone;
                }
                imageView.setImageResource(i9);
                imageView2.setImageResource(i10);
                textView.setText(string);
                if (iM == 1) {
                    sg.bigo.ads.ad.splash.a.b(imageView2);
                } else if (iM == 2) {
                    imageView2.setTranslationY(sg.bigo.ads.common.utils.e.a(imageView2.getContext(), 60));
                    sg.bigo.ads.ad.splash.a.a(imageView2, imageView2.getTranslationY());
                } else if (iM == 3) {
                    sg.bigo.ads.ad.splash.a.a(imageView2);
                }
            }
        }
        View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_splash_media);
        if (2 == m()) {
            if (viewFindViewById != null) {
                viewFindViewById.setOnTouchListener(this.f15339u);
            }
            if (viewGroup2 != null) {
                viewGroup2.setOnTouchListener(this.f15339u);
            }
        }
        Context context = viewGroup.getContext();
        int iM2 = m();
        int iIntValue = 4;
        if (this.m == null && context != null && (1 == iM2 || 3 == iM2)) {
            this.m = new sg.bigo.ads.common.q.b(context, Arrays.asList(4, 9, 1), new sg.bigo.ads.common.q.a() { // from class: sg.bigo.ads.ad.splash.a.d.2
                @Override // sg.bigo.ads.common.q.a
                public final void a(int i11, @NonNull float[] fArr, @NonNull float[] fArr2) {
                    char c7;
                    if (i11 == 4) {
                        c7 = 2;
                        fArr = fArr2;
                    } else {
                        c7 = 0;
                    }
                    if (fArr.length == 3) {
                        int iM3 = d.this.m();
                        if (iM3 == 1) {
                            for (int i12 = 0; i12 < fArr.length; i12++) {
                                float f4 = fArr[i12];
                                if (-1.0f == d.this.f15336r[i12]) {
                                    d.this.f15336r[i12] = f4;
                                }
                                if (Math.abs(f4 - d.this.f15336r[i12]) > d.a(i11)) {
                                    d.this.f15336r[i12] = f4;
                                }
                            }
                            return;
                        }
                        if (iM3 != 3) {
                            return;
                        }
                        float f8 = fArr[c7];
                        if (-1.0f == d.this.f15336r[c7]) {
                            d.this.f15336r[c7] = f8;
                        }
                        if (Math.abs(f8 - d.this.f15336r[c7]) <= d.a(i11)) {
                            return;
                        } else {
                            d.this.f15336r[c7] = f8;
                        }
                        d.c(d.this);
                    }
                }
            });
        }
        sg.bigo.ads.common.q.b bVar = this.m;
        if (bVar != null) {
            try {
                bVar.f15924c = (SensorManager) bVar.f15922a.get().getApplicationContext().getSystemService("sensor");
                Iterator<Integer> it = bVar.f15926f.iterator();
                Sensor defaultSensor = null;
                while (it.hasNext() && (defaultSensor = bVar.f15924c.getDefaultSensor((iIntValue = it.next().intValue()))) == null) {
                }
                bVar.f15924c.registerListener(bVar.g, defaultSensor, iIntValue);
            } catch (Throwable unused) {
            }
        }
    }
}
