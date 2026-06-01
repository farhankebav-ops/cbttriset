package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class MaxWidthMediaView extends MediaView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15440a;

    public MaxWidthMediaView(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        int size = View.MeasureSpec.getSize(i2);
        int i9 = this.f15440a;
        if (i9 > 0 && size > i9) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f15440a, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i2, i8);
    }

    public void setMaxWidth(int i2) {
        this.f15440a = i2;
    }

    public MaxWidthMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxWidthMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
