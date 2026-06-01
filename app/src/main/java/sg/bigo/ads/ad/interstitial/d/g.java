package sg.bigo.ads.ad.interstitial.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
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
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;

/* JADX INFO: loaded from: classes6.dex */
public class g extends b {
    protected LinearLayout M;

    @Nullable
    private ImageView N;
    private ImageView O;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.g$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14500a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.b.values().length];
            f14500a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.b.f14273a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public g(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void D() {
        int iA;
        super.D();
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = ((b) this).y;
        if (realtimeBlurLinearLayout == null || ((b) this).y.getMeasuredWidth() <= (iA = sg.bigo.ads.common.utils.e.a(realtimeBlurLinearLayout.getContext(), 288))) {
            return;
        }
        c(iA);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void E() {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = ((b) this).y;
        if (realtimeBlurLinearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = realtimeBlurLinearLayout.getLayoutParams();
        boolean zL = L();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int measuredWidth = ((b) this).y.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (zL) {
                marginLayoutParams.rightMargin = -(measuredWidth + marginLayoutParams.rightMargin);
            } else {
                marginLayoutParams.leftMargin = -(measuredWidth + marginLayoutParams.leftMargin);
            }
            ((b) this).y.requestLayout();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void F() {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = ((b) this).y;
        if (realtimeBlurLinearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = realtimeBlurLinearLayout.getLayoutParams();
        boolean zL = L();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int measuredWidth = ((b) this).y.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (zL) {
                marginLayoutParams.rightMargin = -(marginLayoutParams.rightMargin + measuredWidth);
            } else {
                marginLayoutParams.leftMargin = -(marginLayoutParams.leftMargin + measuredWidth);
            }
            ((b) this).y.requestLayout();
        }
    }

    public boolean L() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(@NonNull ViewGroup viewGroup, @NonNull View view, u.a aVar, int i2, int i8, int i9, @Nullable View... viewArr) {
        super.a(viewGroup, view, new u.a() { // from class: sg.bigo.ads.ad.interstitial.d.g.1
            @Override // sg.bigo.ads.ad.interstitial.u.a
            public final Pair<String, String> a(@NonNull TextView textView, @Nullable String str, @Nullable String str2) {
                if (textView != null && textView.getTag() == 6 && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    textView.setVisibility(8);
                }
                return Pair.create(str, str2);
            }
        }, i2, i8, i9, viewArr);
    }

    public void b(int i2) {
        TextView textView;
        if (i2 <= 1 || (textView = this.F) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void c(int i2) {
        ((b) this).y.getLayoutParams().width = i2;
        ImageView imageView = this.O;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(1);
            LinearLayout linearLayout = this.M;
            if (linearLayout != null) {
                ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).addRule(0, this.O.getId());
            }
        }
        ((b) this).y.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b, sg.bigo.ads.ad.interstitial.d.a
    public final void t() {
        super.t();
        if (this.B != null) {
            boolean zL = L();
            ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (zL) {
                    layoutParams2.addRule(18, R.id.inter_media_layout);
                    layoutParams2.addRule(19, 0);
                    return;
                } else {
                    layoutParams2.addRule(18, 0);
                    layoutParams2.addRule(19, R.id.inter_media_layout);
                    return;
                }
            }
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = zL ? 3 : 5;
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = zL ? 3 : 5;
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public int z() {
        return R.id.inter_component_24;
    }

    private void a(sg.bigo.ads.ad.interstitial.g gVar) {
        ImageView imageView;
        if (((b) this).y == null || (imageView = this.N) == null) {
            return;
        }
        Bitmap bitmapA = sg.bigo.ads.ad.interstitial.s.a(imageView.getContext(), ((sg.bigo.ads.ad.interstitial.u) this).f15138c, this.f14454u, gVar, gVar == sg.bigo.ads.ad.interstitial.g.WHITE);
        if (bitmapA != null) {
            this.N.setVisibility(0);
            this.N.setImageBitmap(bitmapA);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public final void b(@NonNull sg.bigo.ads.ad.interstitial.b bVar) {
        Button button = (Button) ((b) this).y.findViewById(R.id.inter_btn_cta);
        this.G = button;
        if (button != null) {
            float fA = sg.bigo.ads.common.utils.e.a(button.getContext(), 8);
            this.G.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, -1));
            bVar.a(this.G);
        }
    }

    private void b(sg.bigo.ads.ad.interstitial.g gVar) {
        ImageView imageView;
        if (((b) this).y == null || (imageView = this.O) == null || gVar == null) {
            return;
        }
        imageView.setImageResource(gVar.f14752c);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    public boolean a(@NonNull sg.bigo.ads.ad.interstitial.b bVar) {
        ViewGroup.LayoutParams layoutParams;
        if (!super.a(bVar) || ((b) this).y == null) {
            return false;
        }
        boolean zL = L();
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = ((b) this).y;
        if (realtimeBlurLinearLayout == null) {
            layoutParams = null;
        } else {
            ViewGroup.LayoutParams layoutParams2 = realtimeBlurLinearLayout.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                if (zL) {
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(9, 0);
                } else {
                    layoutParams3.addRule(11, 0);
                    layoutParams3.addRule(9);
                }
            } else {
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams2).gravity = zL ? 5 : 3;
                } else if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams2).gravity = zL ? 5 : 3;
                }
            }
            layoutParams = layoutParams2;
        }
        layoutParams.width = -2;
        ((b) this).y.requestLayout();
        this.M = (LinearLayout) ((b) this).y.findViewById(R.id.inter_text_layout);
        this.N = (ImageView) ((b) this).y.findViewById(R.id.inter_star);
        this.O = (ImageView) ((b) this).y.findViewById(R.id.inter_more);
        sg.bigo.ads.ad.interstitial.g gVar = AnonymousClass3.f14500a[bVar.ordinal()] != 1 ? sg.bigo.ads.ad.interstitial.g.WHITE : sg.bigo.ads.ad.interstitial.g.BLACK;
        a(gVar);
        b(gVar);
        TextView textView = this.E;
        if (textView != null) {
            sg.bigo.ads.common.utils.u.a(textView, new u.a() { // from class: sg.bigo.ads.ad.interstitial.d.g.2
                @Override // sg.bigo.ads.common.utils.u.a
                public final void a(@NonNull Rect rect) {
                    g gVar2 = g.this;
                    gVar2.b(gVar2.E.getLineCount());
                }
            });
        }
        return true;
    }
}
