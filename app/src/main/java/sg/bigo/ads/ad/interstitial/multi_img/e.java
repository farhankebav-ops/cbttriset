package sg.bigo.ads.ad.interstitial.multi_img;

import android.view.View;
import android.widget.TextView;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static int a(int i2) {
        return i2;
    }

    public static void a(final View view, TextView textView, int i2, final boolean[] zArr, final boolean z2, final long j) {
        if (k.a(zArr) || zArr.length < 2) {
            return;
        }
        sg.bigo.ads.ad.interstitial.d.a(textView, i2, new b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.e.1
            @Override // sg.bigo.ads.common.w.b.a
            public final long a() {
                return j;
            }

            @Override // sg.bigo.ads.common.w.b.a
            public final void b(int i8) {
                boolean[] zArr2 = zArr;
                zArr2[1] = true;
                e.a(view, zArr2[0], true, z2);
            }
        });
    }

    public static void a(View view, boolean z2, boolean z7, boolean z8) {
        if (z8 && z2 && z7 && view != null) {
            sg.bigo.ads.ad.interstitial.c.e(view);
        }
    }
}
