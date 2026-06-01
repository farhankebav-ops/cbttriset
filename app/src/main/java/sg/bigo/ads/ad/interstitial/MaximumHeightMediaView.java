package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.MediaView;

/* JADX INFO: loaded from: classes6.dex */
public class MaximumHeightMediaView extends MediaView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14178a;

    public MaximumHeightMediaView(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        int size = View.MeasureSpec.getSize(i8);
        int i9 = this.f14178a;
        if (i9 > 0 && size > i9) {
            i8 = View.MeasureSpec.makeMeasureSpec(this.f14178a, View.MeasureSpec.getMode(i8));
        }
        super.onMeasure(i2, i8);
    }

    public void setMaxHeight(int i2) {
        this.f14178a = i2;
    }

    public MaximumHeightMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaximumHeightMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
