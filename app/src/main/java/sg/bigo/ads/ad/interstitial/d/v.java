package sg.bigo.ads.ad.interstitial.d;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes6.dex */
public final class v extends t {
    public v(@NonNull sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.t
    public final boolean B() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.t
    public final int[] z() {
        int i2;
        int i8;
        if (x() == 1) {
            i2 = ViewCompat.MEASURED_SIZE_MASK;
            i8 = -1;
        } else {
            i2 = 2105636;
            i8 = ViewCompat.MEASURED_STATE_MASK;
        }
        return new int[]{i2, i8};
    }
}
