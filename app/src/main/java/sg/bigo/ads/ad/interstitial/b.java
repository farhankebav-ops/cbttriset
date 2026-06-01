package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f14274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f14275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f14276d;
    public static final b e;
    private static final /* synthetic */ b[] p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColorInt
    public final int f14277f;

    @ColorInt
    public final int g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final sg.bigo.ads.common.ab.b f14278i;
    private final int j;
    private final int k;

    @ColorInt
    private final int l = -1;

    @ColorInt
    private final int m = 134217728;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f14279n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f14280o = 8;

    static {
        b bVar = new b("WHITE", 0, null, d.f14442b, -10525849, 2, 1, 1);
        f14273a = bVar;
        sg.bigo.ads.common.ab.b bVarA = sg.bigo.ads.common.ab.b.a(1, 1, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i2 = d.f14441a;
        b bVar2 = new b("DKGRAY_TRANSLUCENT", 1, bVarA, i2, i2, 0, 2, 2);
        f14274b = bVar2;
        sg.bigo.ads.common.ab.b bVarA2 = sg.bigo.ads.common.ab.b.a(1, 1, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i8 = d.f14441a;
        b bVar3 = new b("MAIN_COLOR_TRANSLUCENT", 2, bVarA2, i8, i8, 0, 2, 2);
        f14275c = bVar3;
        sg.bigo.ads.common.ab.b bVarA3 = sg.bigo.ads.common.ab.b.a(4, 2, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i9 = d.f14441a;
        b bVar4 = new b("LTGRAY_BLUR", 3, bVarA3, i9, i9, 0, 2, 2);
        f14276d = bVar4;
        sg.bigo.ads.common.ab.b bVarA4 = sg.bigo.ads.common.ab.b.a(4, 2, sg.bigo.ads.common.w.b.a(ViewCompat.MEASURED_STATE_MASK, 0.3f));
        int i10 = d.f14441a;
        b bVar5 = new b("MAIN_COLOR_BLUR", 4, bVarA4, i10, i10, 0, 2, 2);
        e = bVar5;
        p = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    /* JADX WARN: Incorrect types in method signature: (Lsg/bigo/ads/common/ab/b;IIIIIII)V */
    private b(String str, int i2, @Nullable sg.bigo.ads.common.ab.b bVar, int i8, int i9, int i10, int i11, int i12) {
        this.f14278i = bVar;
        this.f14277f = i8;
        this.g = i9;
        this.h = i10;
        this.j = i11;
        this.k = i12;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) p.clone();
    }

    public final void a(View view) {
        if (view != null) {
            sg.bigo.ads.common.e.a.a(view, sg.bigo.ads.common.utils.e.a(view.getContext(), this.j));
        }
    }

    public final void b(View view) {
        if (view != null) {
            sg.bigo.ads.common.e.a.a(view, sg.bigo.ads.common.utils.e.a(view.getContext(), this.h));
        }
    }

    public final void a(TextView textView, TextView textView2) {
        Context context;
        if (textView == null && textView2 == null) {
            return;
        }
        if (textView != null) {
            context = textView.getContext();
            textView.setTextColor(this.f14277f);
        } else {
            context = null;
        }
        if (textView2 != null) {
            if (context == null) {
                context = textView2.getContext();
            }
            textView2.setTextColor(this.g);
        }
        sg.bigo.ads.common.ab.b bVar = this.f14278i;
        if (bVar == null) {
            if (textView != null) {
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (textView2 != null) {
                textView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                return;
            }
            return;
        }
        int iA = sg.bigo.ads.common.utils.e.a(context, bVar.f15574a);
        int iA2 = sg.bigo.ads.common.utils.e.a(context, bVar.f15575b);
        int iA3 = sg.bigo.ads.common.utils.e.a(context, bVar.f15576c);
        if (textView != null) {
            textView.setShadowLayer(iA, iA2, iA3, bVar.f15577d);
        }
        if (textView2 != null) {
            textView2.setShadowLayer(iA, iA2, iA3, bVar.f15577d);
        }
    }

    public final void a(RoundedImageView roundedImageView) {
        if (roundedImageView == null) {
            return;
        }
        roundedImageView.setCornerRadius(sg.bigo.ads.common.utils.e.a(roundedImageView.getContext(), this.f14280o));
    }
}
