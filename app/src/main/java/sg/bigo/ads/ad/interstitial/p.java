package sg.bigo.ads.ad.interstitial;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class p<T extends k<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final p<T>.c f14934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final i<T> f14935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.ad.b.b f14936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    final sg.bigo.ads.api.a.m f14937d;

    @NonNull
    final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    FrameLayout f14938f;

    @Nullable
    TextView g;

    @Nullable
    RoundedFrameLayout h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    RoundedFrameLayout f14939i;

    @Nullable
    p<T>.e j;

    @Nullable
    d k;

    @NonNull
    final a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    final a f14940n;

    @Nullable
    l p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    View f14942q;
    boolean l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    final List<Object> f14941o = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f14943r = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f14990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long[] f14991d;
        boolean e;

        private a() {
            this.f14988a = 0;
            this.f14989b = 3;
            this.f14990c = -1L;
            this.f14991d = new long[5];
            this.e = false;
        }

        public final void a(int i2, int i8, boolean z2) {
            if (i2 >= 0) {
                long[] jArr = this.f14991d;
                if (i2 >= jArr.length) {
                    return;
                }
                boolean z7 = this.e;
                if (!z7) {
                    this.f14988a = i2;
                    this.f14989b = i8;
                }
                if (i8 == 1) {
                    jArr[i2] = SystemClock.elapsedRealtime();
                    return;
                }
                if (!z7) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long[] jArr2 = this.f14991d;
                    long j = jElapsedRealtime - jArr2[i2];
                    this.f14990c = j;
                    jArr2[i2] = j;
                } else if (this.f14990c == -1 || (z2 && i8 == 2)) {
                    this.f14988a = i2;
                    this.f14989b = i8;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long[] jArr22 = this.f14991d;
                    long j3 = jElapsedRealtime2 - jArr22[i2];
                    this.f14990c = j3;
                    jArr22[i2] = j3;
                }
                this.e = i8 == 2;
            }
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    public interface b {
        void a(@Nullable sg.bigo.ads.ad.b.d dVar);
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f14992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f14993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f14994c;

        private c() {
        }

        public static void a(@NonNull String str) {
            sg.bigo.ads.core.d.b.a(1006, 10205, str);
        }

        public /* synthetic */ c(p pVar, byte b8) {
            this();
        }

        public static void a(sg.bigo.ads.ad.b.d dVar, int i2) {
            sg.bigo.ads.core.d.b.a(dVar == null ? null : (sg.bigo.ads.core.a.a) dVar.f(), false, 0, i2, false, -1L, -1, -1, -1L, -1, -1, -1L);
        }

        public final void a(sg.bigo.ads.ad.b.d dVar, int i2, boolean z2) {
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.f14992a) - this.f14994c;
            sg.bigo.ads.core.a.a aVar = dVar == null ? null : (sg.bigo.ads.core.a.a) dVar.f();
            p pVar = p.this;
            a aVar2 = pVar.m;
            int i8 = aVar2.f14988a;
            int i9 = aVar2.f14989b;
            long j = aVar2.f14990c;
            a aVar3 = pVar.f14940n;
            sg.bigo.ads.core.d.b.a(aVar, false, 2, i2, z2, jElapsedRealtime, i8, i9, j, aVar3.f14988a, aVar3.f14989b, aVar3.f14990c);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArgbEvaluator f14996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        GradientDrawable f14997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Integer f14998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Integer f14999d;

        private d() {
            this.f14996a = new ArgbEvaluator();
        }

        public /* synthetic */ d(byte b8) {
            this();
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final sg.bigo.ads.common.utils.n f15000a;

        public e(int i2) {
            final long j = ((long) i2) * 1000;
            this.f15000a = new sg.bigo.ads.common.utils.n(j) { // from class: sg.bigo.ads.ad.interstitial.p.e.1
                @Override // sg.bigo.ads.common.utils.n
                public final void a() {
                    sg.bigo.ads.ad.b.b bVar = p.this.f14936c;
                    List<sg.bigo.ads.ad.b.d> listX = bVar.x();
                    sg.bigo.ads.ad.b.d dVar = (listX == null || !listX.contains(bVar.f13877x)) ? null : bVar.f13877x;
                    if (dVar != null) {
                        p pVar = p.this;
                        pVar.a(true, pVar.h, dVar, 1, false, false);
                        return;
                    }
                    sg.bigo.ads.ad.b.b bVar2 = p.this.f14936c;
                    List<sg.bigo.ads.ad.b.d> listX2 = bVar2.x();
                    sg.bigo.ads.ad.b.d dVar2 = (listX2 == null || !listX2.contains(bVar2.y)) ? null : bVar2.y;
                    if (dVar2 != null) {
                        p pVar2 = p.this;
                        pVar2.a(true, pVar2.f14939i, dVar2, 2, false, false);
                    } else {
                        p.this.e.a(null);
                        c.a("Error finish");
                    }
                }

                @Override // sg.bigo.ads.common.utils.n
                public final void a(final long j3) {
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.e.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TextView textView = p.this.g;
                            if (textView != null) {
                                textView.setText(textView.getContext().getString(R.string.bigo_ad_double_video_count_down, Long.valueOf((j3 + 900) / 1000)));
                            }
                            d dVar = p.this.k;
                            if (dVar == null || dVar.f14997b == null) {
                                return;
                            }
                            float f4 = (j3 * 1.0f) / j;
                            dVar.f14997b.setColors(new int[]{((Integer) dVar.f14996a.evaluate(f4, dVar.f14998c, dVar.f14999d)).intValue(), ((Integer) dVar.f14996a.evaluate(f4, dVar.f14999d, dVar.f14998c)).intValue()});
                        }
                    });
                }
            };
        }
    }

    public p(@NonNull sg.bigo.ads.ad.b.b bVar, @NonNull i<T> iVar, @NonNull b bVar2) {
        byte b8 = 0;
        this.f14934a = new c(this, b8);
        this.m = new a(b8);
        this.f14940n = new a(b8);
        this.f14935b = iVar;
        this.f14936c = bVar;
        this.e = bVar2;
        sg.bigo.ads.ad.b.d dVar = bVar.f13877x;
        this.f14937d = dVar == null ? null : ((sg.bigo.ads.core.a.a) dVar.f()).e();
    }

    private void b() {
        this.l = true;
        this.f14941o.clear();
    }

    public final void a() {
        sg.bigo.ads.common.utils.u.b(this.f14938f);
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    public final void a(Context context, final RoundedFrameLayout roundedFrameLayout, final sg.bigo.ads.ad.b.d dVar, String str, @NonNull final a aVar) {
        int i2;
        p<T> pVar;
        sg.bigo.ads.core.a.a aVar2;
        final String str2;
        ?? r15;
        int i8;
        int i9;
        ImageView imageView;
        final int i10;
        final Context context2 = context;
        final sg.bigo.ads.core.a.a aVar3 = (sg.bigo.ads.core.a.a) dVar.f();
        o.a aVarAv = aVar3.av();
        String strC = aVarAv == null ? null : aVarAv.c();
        FrameLayout frameLayout = new FrameLayout(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 32);
        roundedFrameLayout.addView(frameLayout, layoutParams);
        final ImageView imageView2 = new ImageView(context2);
        frameLayout.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        final AdImageView adImageView = new AdImageView(context2);
        frameLayout.addView(adImageView, new FrameLayout.LayoutParams(-1, -1));
        adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
        adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context2, R.drawable.bigo_ad_icon_default_only_icon));
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            i2 = 0;
            boolean z2 = true;
            pVar = this;
            final boolean[] zArr = {false};
            String strAT = aVar3.aT();
            final String strAz = aVar3.az();
            sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.7
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i11, @NonNull String str3, String str4) {
                    aVar.a(1, 0, true);
                    if (TextUtils.isEmpty(strAz) || !URLUtil.isNetworkUrl(strAz)) {
                        return;
                    }
                    sg.bigo.ads.common.p.g gVar2 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.7.1
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i12, @NonNull String str5, String str6) {
                            aVar.a(3, 0, true);
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                            aVar.a(3, 2, true);
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            zArr[0] = true;
                            p.a(p.this, context2, adImageView, imageView2, bitmap);
                        }
                    };
                    p.this.f14941o.add(gVar2);
                    aVar.a(3, 1, true);
                    sg.bigo.ads.common.p.e.a(context2, strAz, aVar3.al(), gVar2);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                    aVar.a(1, 2, true);
                    zArr[0] = true;
                    p.a(p.this, context2, adImageView, imageView2, bitmap);
                }
            };
            aVar2 = aVar3;
            aVar.a(1, 1, true);
            if (TextUtils.isEmpty(strAT) || !URLUtil.isNetworkUrl(strAT)) {
                gVar.a(0, "", "");
            } else {
                pVar.f14941o.add(gVar);
                sg.bigo.ads.common.p.e.a(context2, strAT, aVar2.al(), gVar);
            }
            final String strB = (TextUtils.isEmpty(strC) || !URLUtil.isNetworkUrl(strC)) ? sg.bigo.ads.common.o.b(context2, aVar2.aN()) : strC;
            str2 = strC;
            sg.bigo.ads.common.p.g gVar2 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.8
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i11, @NonNull String str3, String str4) {
                    aVar.a(TextUtils.equals(strB, str2) ? 2 : 4, 0, false);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                    aVar.a(TextUtils.equals(strB, str2) ? 2 : 4, 2, false);
                    if (zArr[0]) {
                        return;
                    }
                    p.a(p.this, context2, adImageView, imageView2, bitmap);
                }
            };
            context2 = context2;
            r15 = z2;
            if (!TextUtils.isEmpty(strB)) {
                r15 = z2;
                if (URLUtil.isNetworkUrl(strB)) {
                    aVar.a(TextUtils.equals(strB, str2) ? 2 : 4, 1, false);
                    pVar.f14941o.add(gVar2);
                    sg.bigo.ads.common.p.e.a(context2, strB, aVar2.al(), gVar2);
                    r15 = z2;
                }
            }
        } else {
            if (TextUtils.equals(str, aVar3.aT())) {
                imageView = imageView2;
                i10 = 1;
            } else if (TextUtils.equals(str, aVar3.az())) {
                imageView = imageView2;
                i10 = 3;
            } else {
                imageView = imageView2;
                i10 = 0;
            }
            aVar.a(i10, 1, true);
            final ImageView imageView3 = imageView;
            i2 = 0;
            r15 = 1;
            pVar = this;
            sg.bigo.ads.common.p.g gVar3 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.6
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i11, @NonNull String str3, String str4) {
                    aVar.a(i10, 0, true);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                    p.a(p.this, context2, adImageView, imageView3, bitmap);
                    aVar.a(i10, 2, true);
                }
            };
            pVar.f14941o.add(gVar3);
            sg.bigo.ads.common.p.e.a(context2, str, aVar3.al(), gVar3);
            aVar2 = aVar3;
            str2 = strC;
        }
        RoundedFrameLayout roundedFrameLayout2 = new RoundedFrameLayout(context2);
        roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 6));
        roundedFrameLayout.addView(roundedFrameLayout2, new FrameLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, 44), 80));
        View view = new View(context2);
        view.setBackgroundColor(-1);
        roundedFrameLayout2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        final ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2) && URLUtil.isNetworkUrl(str2)) {
            arrayList.add(str2);
        }
        String strAT2 = aVar2.aT();
        if (!TextUtils.isEmpty(strAT2) && URLUtil.isNetworkUrl(strAT2)) {
            arrayList.add(strAT2);
        }
        String strAz2 = aVar2.az();
        if (!TextUtils.isEmpty(strAz2) && URLUtil.isNetworkUrl(strAz2)) {
            arrayList.add(strAz2);
        }
        String strB2 = sg.bigo.ads.common.o.b(context2, aVar2.aN());
        if (!TextUtils.isEmpty(strB2)) {
            arrayList.add(strB2);
        }
        if (arrayList.size() > 0) {
            String str3 = (String) arrayList.remove(i2);
            final RoundedFrameLayout roundedFrameLayout3 = new RoundedFrameLayout(context2);
            roundedFrameLayout3.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 4));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 44), sg.bigo.ads.common.utils.e.a(context2, 44), 83);
            layoutParams2.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
            layoutParams2.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
            roundedFrameLayout.addView(roundedFrameLayout3, layoutParams2);
            final AdImageView adImageView2 = new AdImageView(context2);
            adImageView2.setIconTag(r15);
            roundedFrameLayout3.addView(adImageView2, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 44), sg.bigo.ads.common.utils.e.a(context2, 44), 17));
            i8 = 17;
            i9 = 10;
            final Context context3 = context2;
            final sg.bigo.ads.core.a.a aVar4 = aVar2;
            sg.bigo.ads.common.p.g gVar4 = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.p.9
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i11, @NonNull String str4, String str5) {
                    if (p.this.l) {
                        return;
                    }
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            if (p.this.l || arrayList.size() <= 0) {
                                return;
                            }
                            String str6 = (String) arrayList.remove(0);
                            AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                            adImageView2.a(str6, aVar4.al());
                        }
                    });
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                    if (p.this.l) {
                        return;
                    }
                    roundedFrameLayout3.setShadowColor(sg.bigo.ads.common.utils.q.b("#50000000", -1));
                    roundedFrameLayout3.setShadowRadius(sg.bigo.ads.common.utils.e.a(context3, 4));
                }
            };
            context2 = context3;
            pVar.f14941o.add(gVar4);
            adImageView2.a(gVar4);
            adImageView2.a(str3, aVar2.al());
        } else {
            i8 = 17;
            i9 = 10;
        }
        TextView textView = new TextView(context2);
        textView.setTextColor(sg.bigo.ads.common.utils.q.b("#333333", ViewCompat.MEASURED_STATE_MASK));
        textView.setTextSize(16.0f);
        textView.setSingleLine(r15);
        textView.setGravity(16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(context2, 44), 83);
        layoutParams3.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 65);
        layoutParams3.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 52);
        roundedFrameLayout.addView(textView, layoutParams3);
        String title = dVar.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = dVar.getDescription();
        }
        textView.setText(title);
        RoundedFrameLayout roundedFrameLayout4 = new RoundedFrameLayout(context2);
        roundedFrameLayout4.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 14));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 28), sg.bigo.ads.common.utils.e.a(context2, 28), 85);
        layoutParams4.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
        layoutParams4.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 8);
        roundedFrameLayout.addView(roundedFrameLayout4, layoutParams4);
        View view2 = new View(context2);
        roundedFrameLayout4.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        Integer numF = dVar.F();
        if (numF == null) {
            numF = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#01B5FF", -16776961));
        }
        view2.setBackgroundColor(numF.intValue());
        ImageView imageView4 = new ImageView(context2);
        roundedFrameLayout4.addView(imageView4, new FrameLayout.LayoutParams(-1, -1));
        imageView4.setImageDrawable(sg.bigo.ads.common.utils.a.a(context2, R.drawable.bigo_ad_double_video_small_play));
        FrameLayout frameLayout2 = pVar.f14938f;
        sg.bigo.ads.api.a.m mVar = pVar.f14937d;
        if (frameLayout2 != null) {
            sg.bigo.ads.ad.b.a.a(frameLayout2, roundedFrameLayout, 8, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.p.10
                @Override // sg.bigo.ads.core.adview.h
                public final void a(int i11, int i12, int i13, int i14, int i15, int i16) {
                    sg.bigo.ads.ad.b.d dVar2 = dVar;
                    p pVar2 = p.this;
                    sg.bigo.ads.ad.b.b bVar = pVar2.f14936c;
                    pVar2.a(true, roundedFrameLayout, dVar2, dVar2 == bVar.f13877x ? 1 : dVar2 == bVar.y ? 2 : 0, true, false);
                }
            }, mVar == null ? 0 : mVar.a("multi_ads.click_type"));
        }
        ImageView imageView5 = new ImageView(context2);
        frameLayout.addView(imageView5, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 60), sg.bigo.ads.common.utils.e.a(context2, 60), i8));
        imageView5.setImageDrawable(sg.bigo.ads.common.utils.a.a(context2, R.drawable.bigo_ad_double_video_play));
        FrameLayout frameLayout3 = new FrameLayout(context2);
        frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 160), sg.bigo.ads.common.utils.e.a(context2, 160), i8));
        final ImageView imageView6 = new ImageView(context2);
        frameLayout3.addView(imageView6, new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, 100), sg.bigo.ads.common.utils.e.a(context2, 100), 85));
        imageView6.setImageDrawable(sg.bigo.ads.common.utils.a.a(context2, R.drawable.bigo_ad_click_guide));
        final ImageView imageView7 = new ImageView(context2);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(context2, i9), sg.bigo.ads.common.utils.e.a(context2, i9), 85);
        layoutParams5.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 64);
        layoutParams5.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 64);
        frameLayout3.addView(imageView7, layoutParams5);
        imageView7.setImageDrawable(sg.bigo.ads.common.utils.a.a(context2, R.drawable.bigo_ad_click_ripple));
        int iA = mVar.a("multi_ads.guided_click_gesture_show_time");
        int i11 = (iA == 2 || iA == 3) ? ((iA * 2) - r15) * 1000 : 0;
        imageView6.setVisibility(8);
        imageView7.setVisibility(8);
        frameLayout3.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.11
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.l) {
                    return;
                }
                imageView6.setVisibility(0);
                imageView7.setVisibility(0);
                sg.bigo.ads.ad.interstitial.c.a(imageView6, 0.0f, 1.0f, new b.c() { // from class: sg.bigo.ads.ad.interstitial.p.11.1
                    @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                    public final void onAnimationEnd(Animation animation) {
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        sg.bigo.ads.ad.interstitial.c.a(imageView6, imageView7, 0);
                    }
                });
            }
        }, i11);
    }

    private void a(View view, final sg.bigo.ads.ad.b.d dVar) {
        if (view == null) {
            a(dVar, true);
            return;
        }
        sg.bigo.ads.ad.interstitial.c.d(view, new b.c() { // from class: sg.bigo.ads.ad.interstitial.p.3
            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                p.this.a(dVar, false);
                FrameLayout frameLayout = p.this.f14938f;
                if (frameLayout != null) {
                    sg.bigo.ads.ad.interstitial.c.a(frameLayout, 1.0f, 0.0f, new b.c() { // from class: sg.bigo.ads.ad.interstitial.p.3.1
                        @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation2) {
                            p.this.a();
                        }
                    });
                }
            }
        });
        RoundedFrameLayout roundedFrameLayout = this.h;
        if (view == roundedFrameLayout) {
            roundedFrameLayout = this.f14939i;
        }
        if (roundedFrameLayout != null) {
            sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout, 1.0f, 0.0f, null);
        }
    }

    public final void a(sg.bigo.ads.ad.b.d dVar, boolean z2) {
        if (z2) {
            a();
        }
        this.e.a(dVar);
    }

    public static /* synthetic */ void a(p pVar, Context context, final AdImageView adImageView, final ImageView imageView, final Bitmap bitmap) {
        sg.bigo.ads.common.utils.d.a(context, bitmap, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.p.2
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap2) {
                Bitmap bitmap3 = bitmap2;
                if (bitmap3 != null) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setImageBitmap(bitmap3);
                }
                adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                adImageView.setBackground(null);
                adImageView.setImageBitmap(bitmap);
            }
        });
    }

    public final void a(boolean z2, View view, sg.bigo.ads.ad.b.d dVar, int i2, boolean z7, boolean z8) {
        if (this.f14943r) {
            return;
        }
        this.f14943r = true;
        if (z8) {
            c.a(dVar, i2);
        } else {
            this.f14934a.a(dVar, i2, z7);
        }
        if (z2) {
            a(view, dVar);
        } else {
            a(dVar, true);
        }
    }
}
