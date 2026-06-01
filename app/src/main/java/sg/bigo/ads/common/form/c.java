package sg.bigo.ads.common.form;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.a.f;
import sg.bigo.ads.common.form.render.a.d;
import sg.bigo.ads.common.form.render.b;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.HeightScrollView;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.PrivacyCheckBox;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.common.form.render.b f15647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f15648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewFlow f15649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Indicator f15650d;

    @NonNull
    public final LinearLayout e;

    private c(@NonNull RelativeLayout relativeLayout, @NonNull sg.bigo.ads.common.form.render.b bVar) {
        this.f15648b = relativeLayout;
        this.f15647a = bVar;
        this.f15649c = (ViewFlow) relativeLayout.findViewById(R.id.inter_image_view_flow);
        this.f15650d = (Indicator) relativeLayout.findViewById(R.id.inter_image_indicator);
        this.e = (LinearLayout) relativeLayout.findViewById(R.id.inter_form_content);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static c a(Context context, @NonNull e eVar, @Nullable Map<String, Object> map, boolean z2, int i2, int i8, b.a aVar) {
        ViewGroup.LayoutParams layoutParams;
        final int iA;
        RelativeLayout relativeLayout;
        final sg.bigo.ads.common.form.render.b bVar = new sg.bigo.ads.common.form.render.b(context, eVar, map, i2, i8, aVar);
        sg.bigo.ads.common.form.render.a.a bVar2 = null;
        View view = null;
        RelativeLayout relativeLayout2 = (RelativeLayout) sg.bigo.ads.common.utils.a.a(bVar.f15671a, sg.bigo.ads.common.form.render.a.a(3), null, false);
        bVar.e = relativeLayout2;
        if (relativeLayout2 == null) {
            relativeLayout = null;
        } else {
            if (z2) {
                sg.bigo.ads.common.form.render.c.a(relativeLayout2, bVar.f15671a, bVar.f15672b, bVar, 5);
            } else {
                sg.bigo.ads.common.form.render.b.a((TextView) relativeLayout2.findViewById(R.id.inter_form_content_title), bVar.f15672b.a());
                sg.bigo.ads.common.form.render.b.a((TextView) bVar.e.findViewById(R.id.inter_form_content_description), bVar.f15672b.b());
                RelativeLayout relativeLayout3 = bVar.e;
                e eVar2 = bVar.f15672b;
                int i9 = 1;
                if (eVar2.k() == null || !q.b((CharSequence) eVar2.k().c())) {
                    ViewGroup viewGroup = (ViewGroup) relativeLayout3.findViewById(R.id.inter_form_icon_layout);
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) relativeLayout3.findViewById(R.id.inter_form_content_layout);
                    if (viewGroup2 != null) {
                        viewGroup2.setPadding(0, 0, 0, 0);
                    }
                } else {
                    ImageView imageView = (ImageView) relativeLayout3.findViewById(R.id.inter_form_content_icon);
                    if (imageView != null) {
                        new sg.bigo.ads.common.p.b(imageView, (byte) 0).a(null, eVar2.k().c(), true);
                    }
                }
                RelativeLayout relativeLayout4 = bVar.e;
                Context context2 = bVar.f15671a;
                e eVar3 = bVar.f15672b;
                View viewFindViewById = relativeLayout4.findViewById(R.id.inter_blank_viewholder);
                if (viewFindViewById != null && eVar3.j() != null) {
                    int iA2 = sg.bigo.ads.common.form.render.c.a(context2, eVar3);
                    ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                    layoutParams2.height = iA2 - sg.bigo.ads.common.utils.e.a(context2, 8);
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
                final FrameLayout frameLayout = (FrameLayout) relativeLayout4.findViewById(R.id.inter_form_icon_layout);
                if (frameLayout != null) {
                    if (eVar3.j() == null) {
                        iA = 0;
                    } else {
                        iA = sg.bigo.ads.common.form.render.c.a(context2, eVar3) - sg.bigo.ads.common.utils.e.a(context2, 33);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams3.topMargin = iA;
                        frameLayout.setLayoutParams(layoutParams3);
                    }
                    HeightScrollView heightScrollView = (HeightScrollView) relativeLayout4.findViewById(R.id.inter_form_scroll);
                    if (heightScrollView != null) {
                        heightScrollView.setBlankView(viewFindViewById);
                        heightScrollView.setOnScrollListener(new HeightScrollView.a() { // from class: sg.bigo.ads.common.form.render.c.6
                            @Override // sg.bigo.ads.common.view.HeightScrollView.a
                            public final void a(int i10) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
                                marginLayoutParams.topMargin = iA - i10;
                                frameLayout.setLayoutParams(marginLayoutParams);
                            }
                        });
                    }
                }
                Button button = (Button) bVar.e.findViewById(R.id.inter_form_submit);
                bVar.f15674d = button;
                if (button != null) {
                    button.setText(a.a(bVar.f15671a, R.string.bigo_ad_form_submit));
                    bVar.f15674d.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.b.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            View viewC;
                            GradientDrawable gradientDrawable;
                            b bVar3 = b.this;
                            bVar3.a(3, bVar3.g, System.currentTimeMillis() - b.this.f15675f);
                            sg.bigo.ads.common.form.render.a.c cVar = b.this.f15673c;
                            if (cVar == null) {
                                viewC = null;
                            } else {
                                List<sg.bigo.ads.common.form.render.a.a> list = cVar.g;
                                int size = list == null ? 0 : list.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    sg.bigo.ads.common.form.render.a.a aVar2 = cVar.g.get(i10);
                                    if (aVar2 != null && aVar2.a()) {
                                        viewC = aVar2.c();
                                        break;
                                    }
                                }
                                viewC = null;
                            }
                            if (viewC != null) {
                                RelativeLayout relativeLayout5 = b.this.e;
                                HeightScrollView heightScrollView2 = (HeightScrollView) relativeLayout5.findViewById(R.id.inter_form_scroll);
                                View viewFindViewById2 = relativeLayout5.findViewById(R.id.inter_blank_viewholder);
                                int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : 0;
                                if (heightScrollView2 != null) {
                                    heightScrollView2.scrollTo(0, viewC.getTop() + height);
                                    return;
                                }
                                return;
                            }
                            if (b.this.f15673c.b()) {
                                b bVar4 = b.this;
                                c.a(bVar4.e, bVar4.f15671a, bVar4.f15672b, bVar4, 1);
                                return;
                            }
                            final b bVar5 = b.this;
                            final RelativeLayout relativeLayout6 = bVar5.e;
                            final Context context3 = bVar5.f15671a;
                            final e eVar4 = bVar5.f15672b;
                            ViewGroup viewGroup3 = (ViewGroup) relativeLayout6.findViewById(R.id.inter_privacy_notice_container);
                            final View viewA = sg.bigo.ads.common.utils.a.a(context3, sg.bigo.ads.common.form.render.a.a(4), null, false);
                            if (viewA != null && viewGroup3 != null) {
                                u.a(viewA, viewGroup3, null, -1);
                                TextView textView = (TextView) viewA.findViewById(R.id.bigo_ad_form_btn_cancel);
                                if (textView != null) {
                                    if (context3 == null) {
                                        gradientDrawable = null;
                                    } else {
                                        boolean z7 = sg.bigo.ads.common.form.render.a.f15652a;
                                        int i11 = z7 ? -14931661 : -1;
                                        int i12 = z7 ? -10456960 : -4009768;
                                        gradientDrawable = new GradientDrawable();
                                        gradientDrawable.setShape(0);
                                        gradientDrawable.setStroke(sg.bigo.ads.common.utils.e.a(context3, 1), i12);
                                        gradientDrawable.setColor(i11);
                                        gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(context3, 8));
                                    }
                                    textView.setBackground(gradientDrawable);
                                    textView.setText(sg.bigo.ads.common.form.a.a(context3, R.string.bigo_ad_form_cancel));
                                    textView.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.c.1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view3) {
                                            u.b(viewA);
                                            a aVar3 = bVar5;
                                            if (aVar3 != null) {
                                                aVar3.b();
                                            }
                                        }
                                    });
                                }
                                final TextView textView2 = (TextView) viewA.findViewById(R.id.bigo_ad_form_btn_agree);
                                if (textView2 != null) {
                                    textView2.setText(sg.bigo.ads.common.form.a.a(context3, R.string.bigo_ad_form_agree));
                                    textView2.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.form.render.c.2
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view3) {
                                            u.b(viewA);
                                            c.a(relativeLayout6, context3, eVar4, bVar5, 2);
                                            a aVar3 = bVar5;
                                            if (aVar3 != null) {
                                                aVar3.c();
                                            }
                                        }
                                    });
                                }
                                PrivacyCheckBox privacyCheckBox = (PrivacyCheckBox) viewA.findViewById(R.id.inter_form_check_box);
                                if (privacyCheckBox != null && textView2 != null) {
                                    privacyCheckBox.setOnCheckChangeListener(new PrivacyCheckBox.d() { // from class: sg.bigo.ads.common.form.render.c.3
                                        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.d
                                        public final void a(boolean z8) {
                                            textView2.setBackgroundResource(z8 ? R.drawable.bigo_ad_btn_background : sg.bigo.ads.common.form.render.a.f15652a ? R.drawable.bigo_ad_btn_background_white_dark : R.drawable.bigo_ad_btn_background_white);
                                            textView2.setClickable(z8);
                                        }
                                    });
                                }
                                c.a(viewA, eVar4, null, bVar5);
                            }
                            b bVar6 = b.this;
                            bVar6.a(4, bVar6.g, System.currentTimeMillis() - b.this.f15675f);
                        }
                    });
                }
                ViewGroup viewGroup3 = (ViewGroup) bVar.e.findViewById(R.id.inter_form_content);
                if (viewGroup3 != null) {
                    sg.bigo.ads.common.form.render.a.c cVar = bVar.f15673c;
                    View viewA = sg.bigo.ads.common.utils.a.a(cVar.f15662a, sg.bigo.ads.common.form.render.a.a(5), null, false);
                    cVar.e = viewA;
                    if (viewA == null) {
                        layoutParams = null;
                    } else {
                        ViewGroup viewGroup4 = (ViewGroup) viewA.findViewById(R.id.bigo_ad_id_form_question);
                        e.c[] cVarArr = cVar.f15665d;
                        if (cVarArr != null && viewGroup4 != null) {
                            int length = cVarArr.length;
                            int i10 = 0;
                            while (i10 < length) {
                                e.c cVar2 = cVarArr[i10];
                                Map<String, Object> map2 = cVar.f15663b;
                                Context context3 = cVar.f15662a;
                                if (cVar2 != null) {
                                    int i11 = cVar2.f15454b;
                                    bVar2 = i11 != i9 ? (i11 == 2 || i11 == 3) ? new sg.bigo.ads.common.form.render.a.b(cVar2, map2, context3, cVar) : null : new d(cVar2, map2, context3, cVar);
                                }
                                if (bVar2 != null) {
                                    cVar.g.add(bVar2);
                                    View viewB = bVar2.b();
                                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                                    layoutParams4.bottomMargin = sg.bigo.ads.common.utils.e.a(cVar.f15662a, 27);
                                    u.a(viewB, viewGroup4, layoutParams4, -1);
                                }
                                i10++;
                                bVar2 = null;
                                i9 = 1;
                            }
                        }
                        TextView textView = (TextView) cVar.e.findViewById(R.id.inter_form_question_purpose);
                        if (textView != null) {
                            textView.setText(cVar.f15664c.h());
                        }
                        cVar.f15666f = sg.bigo.ads.common.form.render.c.a(cVar.e, cVar.f15664c, cVar.f15663b, cVar.h);
                        view = cVar.e;
                        layoutParams = null;
                    }
                    u.a(view, viewGroup3, layoutParams, -1);
                }
            }
            u.a(bVar.e, new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.common.form.render.b.2
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view2) {
                    sg.bigo.ads.common.n.d.a(2, b.this.h);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view2) {
                    b bVar3 = b.this;
                    bVar3.a(12, bVar3.g, System.currentTimeMillis() - b.this.f15675f);
                }
            });
            relativeLayout = bVar.e;
        }
        c cVar3 = new c(relativeLayout, bVar);
        cVar3.f15650d.setType(0);
        cVar3.f15650d.setRadius(sg.bigo.ads.common.utils.e.a(context, 3));
        cVar3.f15650d.setPadding(sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 3));
        cVar3.f15649c.setViewStyle(3);
        cVar3.f15649c.setFlipInterval(5000);
        cVar3.f15649c.setOnItemChangeListener(new ViewFlow.c() { // from class: sg.bigo.ads.common.form.c.1
            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(int i12) {
                Indicator indicator;
                int i13;
                c.this.f15650d.setNum(i12);
                if (i12 > 1) {
                    indicator = c.this.f15650d;
                    i13 = 0;
                } else {
                    indicator = c.this.f15650d;
                    i13 = 4;
                }
                indicator.setVisibility(i13);
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(int i12, int i13) {
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(@NonNull View view2, int i12) {
                c.this.f15650d.a(i12);
            }

            @Override // sg.bigo.ads.common.view.ViewFlow.c
            public final void a(@NonNull View view2, int i12, float f4) {
                c.this.f15650d.a(f4, i12);
            }
        });
        cVar3.f15649c.getLayoutParams().height = sg.bigo.ads.common.form.render.c.a(context, eVar);
        f[] fVarArrI = eVar.i();
        if (!k.a(fVarArrI)) {
            for (f fVar : fVarArrI) {
                ImageView imageView2 = new ImageView(context);
                new sg.bigo.ads.common.p.b(imageView2).a(null, fVar.c(), false);
                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ViewFlow.b bVar3 = new ViewFlow.b();
                ((ViewGroup.LayoutParams) bVar3).width = -1;
                ((ViewGroup.LayoutParams) bVar3).height = -2;
                bVar3.e = 48;
                bVar3.f16161d = 3;
                cVar3.f15649c.addView(imageView2, bVar3);
                if (eVar.f() == 0) {
                    break;
                }
            }
        }
        return cVar3;
    }
}
