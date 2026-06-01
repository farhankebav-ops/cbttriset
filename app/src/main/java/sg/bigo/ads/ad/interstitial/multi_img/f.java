package sg.bigo.ads.ad.interstitial.multi_img;

import android.view.View;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements ViewFlow.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final d f14871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Indicator f14872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final a f14873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ValueCallback<Integer> f14874d;
    private boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14875f;

    public f(@NonNull d dVar, @Nullable Indicator indicator, @Nullable a aVar) {
        this.f14871a = dVar;
        this.f14872b = indicator;
        this.f14873c = aVar;
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(int i2) {
        Indicator indicator = this.f14872b;
        if (indicator == null || i2 <= 1) {
            return;
        }
        if (indicator.getType() != 1) {
            this.f14872b.setNum(i2);
        } else {
            Indicator indicator2 = this.f14872b;
            indicator2.setLineLength(Indicator.a(i2, indicator2.getDistance(), this.f14872b.getRadius(), this.f14872b.getLengthSelected()));
        }
        this.f14872b.setVisibility(0);
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(int i2, int i8) {
        Indicator indicator = this.f14872b;
        if (indicator == null || indicator.getType() != 1) {
            return;
        }
        float fMin = Math.min(1.0f, Math.max(0.0f, (i2 * 1.0f) / i8));
        Indicator indicator2 = this.f14872b;
        if (indicator2.f16076a != fMin) {
            indicator2.f16076a = Math.max(0.0f, Math.min(1.0f, fMin));
            indicator2.invalidate();
        }
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(@NonNull View view, int i2) {
        Indicator indicator = this.f14872b;
        if (indicator != null && indicator.getType() != 1) {
            this.f14872b.a(i2);
        }
        this.f14875f = i2;
        a aVar = this.f14873c;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    @Override // sg.bigo.ads.common.view.ViewFlow.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull android.view.View r11, int r12, float r13) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.multi_img.f.a(android.view.View, int, float):void");
    }

    public static void a(ViewFlow viewFlow, ValueCallback<Integer> valueCallback) {
        if (viewFlow == null || valueCallback == null) {
            return;
        }
        ViewFlow.c onItemChangeListener = viewFlow.getOnItemChangeListener();
        if (onItemChangeListener instanceof f) {
            ((f) onItemChangeListener).f14874d = valueCallback;
        }
    }

    public static boolean a(ViewFlow viewFlow) {
        ViewFlow.c onItemChangeListener = viewFlow != null ? viewFlow.getOnItemChangeListener() : null;
        if (onItemChangeListener == null || !(onItemChangeListener instanceof f)) {
            return false;
        }
        return ((f) onItemChangeListener).e;
    }
}
