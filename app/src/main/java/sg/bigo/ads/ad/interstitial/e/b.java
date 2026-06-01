package sg.bigo.ads.ad.interstitial.e;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.interstitial.e.a.b;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends sg.bigo.ads.common.view.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f14641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f14642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected final Drawable f14643c;

    public b(float f4, float f8, float f9, float f10, @Nullable Rect rect, float f11, @Nullable boolean[] zArr, @NonNull b.a aVar) {
        super(f4, f8, f9, f10, rect, aVar.f14635b, aVar.f14636c, f11, zArr);
        int i2 = aVar.f14635b;
        this.f14641a = i2;
        boolean z2 = aVar.f14634a;
        this.f14642b = z2;
        if (z2) {
            this.f14643c = null;
        } else {
            Drawable drawableA = sg.bigo.ads.common.utils.d.a(f4, f8, f9, f10, rect, i2);
            this.f14643c = this.f16177n != null ? new LayerDrawable(new Drawable[]{drawableA, this.f16177n}) : drawableA;
        }
    }

    @Nullable
    public final Drawable a() {
        return this.f14643c;
    }

    public b(float f4, float f8, @NonNull b.a aVar) {
        this(f4, f4, f4, f4, null, f8, null, aVar);
    }
}
