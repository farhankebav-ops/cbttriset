package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.a;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.AutoNextLineLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public class u extends a {
    private Bitmap A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f14586x;
    protected MediaView y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f14587z;

    public u(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    public int A() {
        return -1;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final ViewGroup k() {
        return this.y;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final MediaView l() {
        return this.y;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    @Nullable
    public final Button m() {
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void o() {
        String[] strArrE;
        int i2;
        int i8;
        u uVar = this;
        int iX = uVar.x();
        if (iX == 1) {
            uVar.a(-1);
        } else {
            uVar.a(ViewCompat.MEASURED_STATE_MASK);
        }
        int i9 = 0;
        final boolean z2 = iX == 1;
        final ViewGroup viewGroup = uVar.f14450q;
        if (viewGroup != null) {
            c.d popPage = ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.getPopPage();
            if (popPage != null && popPage.e() != null && popPage.e().length > 0) {
                strArrE = popPage.e();
            } else if (((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.f()).ax() != null) {
                o.a[] aVarArrAx = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.f()).ax();
                String[] strArr = new String[aVarArrAx.length];
                for (int i10 = 0; i10 < aVarArrAx.length; i10++) {
                    strArr[i10] = aVarArrAx[i10].c();
                }
                strArrE = strArr;
            } else {
                strArrE = null;
            }
            boolean zIsEmpty = strArrE == null || strArrE.length == 0;
            if (strArrE != null && 1 == strArrE.length) {
                zIsEmpty = TextUtils.isEmpty(strArrE[0]);
            }
            if (zIsEmpty) {
                uVar.a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.u.3
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        u.this.a(viewGroup, (String[]) null, z2);
                    }
                });
            } else {
                uVar.a(viewGroup, strArrE, z2);
            }
            ViewGroup viewGroup2 = uVar.f14450q;
            IconListView iconListView = (IconListView) viewGroup2.findViewById(R.id.download_msg_list);
            if (iconListView != null && uVar.f14454u != null) {
                iconListView.setThemeWhite(!z2);
                iconListView.a(uVar.f14454u);
                sg.bigo.ads.ad.b.a.a(viewGroup2, iconListView, 8, ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c, 0);
            }
            ViewGroup viewGroup3 = uVar.f14450q;
            int i11 = z2 ? -16777216 : -1;
            int iB = z2 ? sg.bigo.ads.common.utils.q.b("#B3000000", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#B3FFFFFF", -1);
            ((TextView) viewGroup3.findViewById(R.id.inter_title)).setTextColor(i11);
            ((TextView) viewGroup3.findViewById(R.id.tv_gp_info_extra_about)).setTextColor(i11);
            ((TextView) viewGroup3.findViewById(R.id.inter_description)).setTextColor(iB);
            ((TextView) viewGroup3.findViewById(R.id.tv_desc_below)).setTextColor(iB);
            View viewFindViewById = uVar.f14450q.findViewById(R.id.bigo_ad_mask_vertical);
            GradientDrawable gradientDrawable = (GradientDrawable) viewFindViewById.getBackground();
            int[] iArr = new int[2];
            if (z2) {
                iArr[0] = 16777215;
                iArr[1] = -1;
            } else {
                iArr[0] = 2105636;
                iArr[1] = -16777216;
            }
            gradientDrawable.setColors(iArr);
            viewFindViewById.setBackground(gradientDrawable);
            RoundedImageView roundedImageView = (RoundedImageView) uVar.f14450q.findViewById(R.id.inter_icon);
            if (roundedImageView != null) {
                roundedImageView.setCornerRadius(sg.bigo.ads.common.utils.e.a(r6.getContext(), 6));
            }
            if (uVar.f14455v != null) {
                int iF = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.f()).B() == null ? 0 : ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.f()).B().f();
                if (iF > 0) {
                    float f4 = iF * 0.01f;
                    if (f4 > 0.15f) {
                        f4 = 0.15f;
                    }
                    int iRound = Math.round(sg.bigo.ads.common.utils.e.c(uVar.f14455v.getContext()) * f4);
                    ViewGroup.LayoutParams layoutParams = uVar.f14455v.getLayoutParams();
                    layoutParams.height = iRound;
                    uVar.f14455v.setLayoutParams(layoutParams);
                } else {
                    uVar.f14455v.setVisibility(8);
                }
                uVar.f14455v.setTextColor(z2 ? sg.bigo.ads.common.utils.q.b("#4D202124", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#4DFFFFFF", -1));
            }
            Button button = (Button) uVar.f14450q.findViewById(R.id.inter_btn_cta);
            ViewGroup viewGroup4 = (ViewGroup) uVar.f14450q.findViewById(R.id.inter_btn_cta_layout);
            if (button != null && viewGroup4 != null) {
                ViewGroup viewGroup5 = uVar.f14450q;
                a.C0259a c0259aU = uVar.u();
                sg.bigo.ads.ad.interstitial.d.b(button, c0259aU.f14479a);
                if (uVar.v()) {
                    sg.bigo.ads.ad.interstitial.c.e(viewGroup4);
                }
                TextView textView = (TextView) viewGroup5.findViewById(R.id.inter_company);
                if (textView != null) {
                    textView.setTextColor(c0259aU.f14479a);
                }
            }
            c.d popPage2 = ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.getPopPage();
            if (popPage2 == null || popPage2.d() == null) {
                return;
            }
            ViewGroup viewGroup6 = uVar.f14450q;
            AutoNextLineLinearLayout autoNextLineLinearLayout = (AutoNextLineLinearLayout) viewGroup6.findViewById(R.id.fbl_genre);
            String[] strArrD = popPage2.d();
            try {
                Context context = viewGroup6.getContext();
                int iA = sg.bigo.ads.common.utils.e.a(context, 1);
                int iA2 = sg.bigo.ads.common.utils.e.a(context, 5);
                int iA3 = sg.bigo.ads.common.utils.e.a(context, 12);
                int iA4 = sg.bigo.ads.common.utils.e.a(context, 14);
                int iA5 = sg.bigo.ads.common.utils.e.a(context, 28);
                int iB2 = z2 ? sg.bigo.ads.common.utils.q.b("#B3000000", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#B3FFFFFF", -1);
                int iB3 = z2 ? sg.bigo.ads.common.utils.q.b("#26202124", ViewCompat.MEASURED_STATE_MASK) : sg.bigo.ads.common.utils.q.b("#26FFFFFF", -1);
                int i12 = 0;
                while (i12 < strArrD.length) {
                    String str = strArrD[i12];
                    if (TextUtils.isEmpty(str)) {
                        i2 = iB3;
                        i8 = i9;
                    } else {
                        TextView textView2 = new TextView(context);
                        textView2.setText(str);
                        textView2.setTextColor(iB2);
                        textView2.setTextSize(13.0f);
                        textView2.setPadding(iA3, iA2, iA3, iA2);
                        textView2.setGravity(17);
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setShape(i9);
                        gradientDrawable2.setStroke(iA, iB3);
                        gradientDrawable2.setCornerRadius(iA4);
                        textView2.setBackground(gradientDrawable2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA5);
                        layoutParams2.topMargin = iA3;
                        layoutParams2.rightMargin = iA3;
                        textView2.setTag(27);
                        i2 = iB3;
                        i8 = 0;
                        sg.bigo.ads.ad.b.a.a(viewGroup6, textView2, 8, ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c, 0);
                        autoNextLineLinearLayout.addView(textView2, layoutParams2);
                    }
                    i12++;
                    uVar = this;
                    i9 = i8;
                    iB3 = i2;
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void t() {
        super.t();
        ViewGroup viewGroup = this.f14450q;
        if (viewGroup != null) {
            MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.inter_media);
            this.y = mediaView;
            mediaView.setImageBlurBorder(false);
            c(this.f14450q);
            TextView textView = (TextView) this.f14450q.findViewById(R.id.tv_desc_below);
            if (textView != null) {
                c.d popPage = ((sg.bigo.ads.ad.interstitial.u) this).f15138c.getPopPage();
                String strC = popPage != null ? popPage.c() : "";
                if (TextUtils.isEmpty(strC)) {
                    strC = ((sg.bigo.ads.ad.interstitial.u) this).f15138c.getDescription();
                }
                if (TextUtils.isEmpty(strC)) {
                    strC = sg.bigo.ads.common.utils.a.a(j(), R.string.bigo_ad_description_default, new Object[0]);
                }
                textView.setText(strC);
                textView.setTag(6);
                sg.bigo.ads.ad.b.a.a(this.f14450q, textView, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, 0);
            }
            TextView textView2 = (TextView) this.f14450q.findViewById(R.id.tv_gp_info_extra_about);
            if (textView2 != null) {
                textView2.setTag(27);
                sg.bigo.ads.ad.b.a.a(this.f14450q, textView2, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, 0);
            }
            ImageView imageView = (ImageView) this.f14450q.findViewById(R.id.iv_gp_info_extra_arrow);
            if (imageView != null) {
                imageView.setTag(27);
                sg.bigo.ads.ad.b.a.a(this.f14450q, imageView, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, 0);
            }
        }
    }

    public void c(@NonNull ViewGroup viewGroup) {
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.s.a(((sg.bigo.ads.ad.interstitial.u) this).f15138c);
        sg.bigo.ads.common.p pVarB = sg.bigo.ads.common.p.b(pVarA.getWidth(), pVarA.getHeight(), viewGroup.getContext().getResources().getDisplayMetrics().widthPixels);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.bigo_ad_material_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = pVarB.getHeight() - sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 25);
        linearLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
        layoutParams2.height = pVarB.getHeight();
        this.y.setLayoutParams(layoutParams2);
        a(viewGroup, pVarB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sg.bigo.ads.common.p b(@NonNull Bitmap bitmap, @NonNull ViewGroup viewGroup, int i2, boolean z2) {
        int iA = sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 20);
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(bitmap.getWidth(), bitmap.getHeight(), i2);
        if (z2) {
            if (pVarA.getWidth() < viewGroup.getContext().getResources().getDisplayMetrics().widthPixels - iA) {
                return sg.bigo.ads.common.p.a(bitmap.getWidth(), bitmap.getHeight(), i2 - iA);
            }
        }
        return pVarA;
    }

    private RoundedFrameLayout a(@NonNull ViewGroup viewGroup, @NonNull Context context, String str, Bitmap bitmap, int i2, boolean z2, boolean z7) {
        u uVar;
        final ViewGroup viewGroup2;
        final boolean z8;
        final RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context);
        roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context, 4));
        roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context, 1));
        roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#08000000", -7829368));
        final AdImageView adImageView = new AdImageView(context);
        final int iA = sg.bigo.ads.common.utils.e.a(context, 200);
        adImageView.setBlurBorder(false);
        if (bitmap == null) {
            adImageView.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#FFE1E1E6", -7829368));
            adImageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, iA);
            layoutParams.width = iA;
            layoutParams.height = iA;
            roundedFrameLayout.setLayoutParams(layoutParams);
            adImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, iA));
            uVar = this;
            viewGroup2 = viewGroup;
            z8 = z2;
            adImageView.a(new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.d.u.5
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i8, @NonNull String str2, String str3) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap2, @NonNull sg.bigo.ads.common.p.f fVar) {
                    if (((sg.bigo.ads.ad.interstitial.u) u.this).f15138c.h) {
                        return;
                    }
                    adImageView.setBackground(null);
                    sg.bigo.ads.common.p pVarB = u.b(bitmap2, viewGroup2, iA, z8);
                    ViewGroup.LayoutParams layoutParams2 = roundedFrameLayout.getLayoutParams();
                    layoutParams2.width = pVarB.getWidth();
                    layoutParams2.height = pVarB.getHeight();
                    roundedFrameLayout.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = adImageView.getLayoutParams();
                    layoutParams3.width = pVarB.getWidth();
                    layoutParams3.height = pVarB.getHeight();
                    adImageView.setLayoutParams(layoutParams3);
                    if (z8) {
                        u.this.a(viewGroup2, bitmap2, pVarB, iA);
                    }
                }
            });
            adImageView.a(str, ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c.f()).al());
        } else {
            uVar = this;
            viewGroup2 = viewGroup;
            z8 = z2;
            sg.bigo.ads.common.p pVarB = b(bitmap, viewGroup2, iA, z8);
            roundedFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(pVarB.getWidth(), pVarB.getHeight()));
            adImageView.setImageBitmap(bitmap);
            if (z8) {
                a(viewGroup2, bitmap, pVarB, iA);
            }
        }
        adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        roundedFrameLayout.addView(adImageView);
        if (i2 != 1 && i2 != 2) {
            sg.bigo.ads.ad.b.a.a(viewGroup2, roundedFrameLayout, 8, ((sg.bigo.ads.ad.interstitial.u) uVar).f15138c, i2);
        }
        if (z7 && !z8) {
            sg.bigo.ads.common.e.a.a((View) roundedFrameLayout, 10);
            roundedFrameLayout.setBackgroundColor(-1);
        }
        return roundedFrameLayout;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void a(double d8) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final void a(int i2) {
        ViewGroup viewGroup = this.f14450q;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i2);
        }
    }

    private void a(@NonNull final View view, final int i2, final int i8) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.d.u.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                sg.bigo.ads.ad.b.c cVar;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    u.this.f14586x = motionEvent.getX();
                    u.this.f14587z = motionEvent.getY();
                    return !view.isScrollContainer();
                }
                if (actionMasked != 1) {
                    return false;
                }
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                boolean zA = sg.bigo.ads.common.utils.u.a(view, Math.round(u.this.f14586x), Math.round(u.this.f14587z));
                boolean zA2 = sg.bigo.ads.common.utils.u.a(view, Math.round(x2), Math.round(y));
                Object tag = view.getTag();
                int iIntValue = i2;
                if (tag instanceof Integer) {
                    iIntValue = ((Integer) tag).intValue();
                }
                int i9 = iIntValue;
                int i10 = i8;
                if (2 == i10) {
                    if (zA && zA2) {
                        cVar = ((sg.bigo.ads.ad.interstitial.u) u.this).f15138c;
                    }
                    return false;
                }
                if (3 == i10 || 1 != i10 || !zA) {
                    return false;
                }
                cVar = ((sg.bigo.ads.ad.interstitial.u) u.this).f15138c;
                cVar.a(Math.round(x2), Math.round(y), Math.round(u.this.f14586x), Math.round(u.this.f14587z), 8, i9);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final ViewGroup viewGroup, final Bitmap bitmap, sg.bigo.ads.common.p pVar, final int i2) {
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.fl_multi_container);
        if (frameLayout != null) {
            int i8 = viewGroup.getContext().getResources().getDisplayMetrics().widthPixels;
            int iA = sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 20);
            final int i9 = i8 - (iA * 2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
            marginLayoutParams.leftMargin = iA;
            marginLayoutParams.rightMargin = iA;
            frameLayout.setLayoutParams(marginLayoutParams);
            if (pVar.getWidth() < i9) {
                final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.iv_blur_bg);
                final View viewFindViewById = viewGroup.findViewById(R.id.iv_blur_bg_mask);
                if (imageView == null || bitmap == null) {
                    return;
                }
                sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(viewGroup.getContext(), bitmap);
                        if (bitmapB == null || ((sg.bigo.ads.ad.interstitial.u) u.this).f15138c.h) {
                            return;
                        }
                        imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                imageView.setImageBitmap(bitmapB);
                                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                layoutParams.width = i9;
                                layoutParams.height = i2;
                                imageView.setLayoutParams(layoutParams);
                                View view = viewFindViewById;
                                if (view != null) {
                                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                    layoutParams2.width = i9;
                                    layoutParams2.height = i2;
                                    viewFindViewById.setLayoutParams(layoutParams2);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(@NonNull ViewGroup viewGroup, @NonNull View view, int i2, int i8, int i9, @Nullable View... viewArr) {
        super.a(viewGroup, view, i2, i8, i9, viewArr);
        MediaView mediaView = this.y;
        if (mediaView != null) {
            mediaView.b().a(new sg.bigo.ads.core.player.b.b() { // from class: sg.bigo.ads.ad.interstitial.d.u.1
                @Override // sg.bigo.ads.core.player.b.b
                public final void a(Bitmap bitmap) {
                    if (((sg.bigo.ads.ad.interstitial.u) u.this).f15138c.h || bitmap == null) {
                        return;
                    }
                    u uVar = u.this;
                    if (uVar.f14450q != null) {
                        uVar.A = bitmap;
                        u.this.f14450q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                u uVar2 = u.this;
                                u.a(uVar2, uVar2.f14450q);
                            }
                        });
                    }
                }
            });
        }
        sg.bigo.ads.ad.interstitial.x xVar = this.f14452s;
        boolean z2 = false;
        int i10 = xVar != null ? xVar.f15199i : 0;
        View viewFindViewById = viewGroup.findViewById(R.id.inter_media_container);
        sg.bigo.ads.ad.b.a.a(viewFindViewById, 9);
        sg.bigo.ads.ad.interstitial.x xVar2 = this.f14452s;
        if (xVar2 == null || !xVar2.g) {
            MediaView mediaView2 = this.y;
            if (mediaView2 != null) {
                mediaView2.setOtherClickAreaClick(false);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, sg.bigo.ads.ad.interstitial.r.F, 0);
            }
        } else {
            MediaView mediaView3 = this.y;
            if (mediaView3 != null) {
                mediaView3.setOtherClickAreaClick(true);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, viewFindViewById, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, i10);
            }
        }
        sg.bigo.ads.ad.interstitial.x xVar3 = this.f14452s;
        if (xVar3 != null && xVar3.f15198f) {
            z2 = true;
        }
        MediaView mediaView4 = this.y;
        if (mediaView4 != null) {
            sg.bigo.ads.ad.b.a.a(viewGroup, mediaView4, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, i10);
            this.y.setMediaAreaClickable(z2);
            this.y.b().a(!z2);
        }
    }

    public void a(@NonNull ViewGroup viewGroup, sg.bigo.ads.common.p pVar) {
        View viewFindViewById = viewGroup.findViewById(R.id.bigo_ad_mask_vertical);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = pVar.getHeight();
        viewFindViewById.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull ViewGroup viewGroup, @Nullable String[] strArr, boolean z2) {
        int i2;
        int i8;
        FrameLayout.LayoutParams layoutParams;
        sg.bigo.ads.ad.interstitial.x xVar;
        sg.bigo.ads.ad.interstitial.x xVar2;
        sg.bigo.ads.api.a.m mVar = this.f14453t;
        int i9 = 0;
        int iA = mVar == null ? 0 : mVar.a("video_play_page.click_type");
        View view = (ScrollView) viewGroup.findViewById(R.id.native_view);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) viewGroup.findViewById(R.id.bigo_ad_scroll_images);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(0);
        Context context = viewGroup.getContext();
        boolean z7 = strArr == null || strArr.length == 0 || strArr.length == 1;
        if (!z7) {
            int iA2 = sg.bigo.ads.common.utils.e.a(context, 20);
            int iA3 = sg.bigo.ads.common.utils.e.a(context, 12);
            while (true) {
                int i10 = i9;
                if (i10 >= strArr.length) {
                    break;
                }
                String str = strArr[i10];
                if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
                    i2 = iA2;
                    i8 = i10;
                } else {
                    i2 = iA2;
                    i8 = i10;
                    RoundedFrameLayout roundedFrameLayoutA = a(viewGroup, context, str, (Bitmap) null, iA, false, z2);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = i8 == 0 ? i2 : iA3;
                    if (i8 + 1 == strArr.length) {
                        layoutParams2.rightMargin = i2;
                    }
                    linearLayout.addView(roundedFrameLayoutA, layoutParams2);
                    if (iA == 2) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayoutA, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, iA);
                    }
                }
                i9 = i8 + 1;
                iA2 = i2;
            }
        } else {
            linearLayout.addView(a(viewGroup, context, (strArr == null || 1 != strArr.length) ? "" : strArr[0], this.g, iA, true, z2));
        }
        if (z7) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(viewGroup.getContext(), 202));
        }
        horizontalScrollView.addView(linearLayout, layoutParams);
        if (iA == 3) {
            if (z7 && (xVar = this.f14452s) != null && xVar.f15198f) {
                horizontalScrollView.setTag(9);
                sg.bigo.ads.ad.b.a.a(viewGroup, horizontalScrollView, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, iA);
                return;
            }
            return;
        }
        if (z7 && (xVar2 = this.f14452s) != null && xVar2.f15198f) {
            horizontalScrollView.setTag(9);
            sg.bigo.ads.ad.b.a.a(viewGroup, horizontalScrollView, 8, ((sg.bigo.ads.ad.interstitial.u) this).f15138c, iA);
        } else {
            a(horizontalScrollView, 5, iA);
        }
        if (view != null) {
            a(view, 10, iA);
        }
    }

    public static /* synthetic */ void a(u uVar, final ViewGroup viewGroup) {
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.iv_media_blur_bg);
        final View viewFindViewById = viewGroup.findViewById(R.id.iv_media_blur_bg_mask);
        if (uVar.y == null || imageView == null || uVar.A == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.2
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(viewGroup.getContext(), u.this.A);
                if (bitmapB == null || ((sg.bigo.ads.ad.interstitial.u) u.this).f15138c.h) {
                    return;
                }
                imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.u.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageView.setImageBitmap(bitmapB);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int height = u.this.y.getHeight();
                        layoutParams.height = height;
                        layoutParams.width = u.this.A();
                        imageView.setLayoutParams(layoutParams);
                        View view = viewFindViewById;
                        if (view != null) {
                            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                            layoutParams2.height = height;
                            layoutParams2.width = u.this.A();
                            viewFindViewById.setLayoutParams(layoutParams2);
                        }
                    }
                });
            }
        });
    }
}
