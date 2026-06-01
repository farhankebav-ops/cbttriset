package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public class WrapContentViewFlow extends ViewFlow {
    public WrapContentViewFlow(Context context) {
        this(context, null);
    }

    @Override // sg.bigo.ads.common.view.ViewFlow, android.view.View
    public void onMeasure(int i2, int i8) {
        int defaultSize = View.getDefaultSize(Integer.MIN_VALUE, i2);
        int defaultSize2 = View.getDefaultSize(Integer.MIN_VALUE, i8);
        this.j = Math.min(defaultSize / 10, this.f16129i);
        ((ViewFlow) this).f16124a = Math.min(Math.max(0, ((ViewFlow) this).f16124a), ((ViewFlow) this).f16125b - 1);
        int i9 = defaultSize - (this.f16127d * 2);
        int childCount = getChildCount();
        int iMax = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.e || childAt == this.f16128f) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i8), 0));
                } else {
                    ViewFlow.b bVar = (ViewFlow.b) childAt.getLayoutParams();
                    if (bVar != null) {
                        int i11 = ((ViewGroup.LayoutParams) bVar).width;
                        childAt.measure(i11 != -2 ? i11 != -1 ? View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY) : View.MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY) : ViewGroup.getChildMeasureSpec(i2, this.f16127d * 2, i11), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i8), 0));
                        iMax = Math.max(iMax, childAt.getMeasuredHeight());
                    }
                }
            }
        }
        setMeasuredDimension(defaultSize, Math.min(iMax, defaultSize2));
    }

    public WrapContentViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
