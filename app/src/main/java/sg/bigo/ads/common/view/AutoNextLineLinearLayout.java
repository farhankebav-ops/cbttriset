package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes6.dex */
public class AutoNextLineLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f16062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f16063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f16064d;
    Hashtable e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16068d;

        private a() {
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    public AutoNextLineLinearLayout(Context context) {
        super(context);
        this.e = new Hashtable();
    }

    private int a(int i2, int i8) {
        if (i2 <= 0) {
            return getPaddingLeft();
        }
        int i9 = i8 - 1;
        return getChildAt(i9).getMeasuredWidth() + a(i2 - 1, i9) + 30;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            a aVar = (a) this.e.get(childAt);
            if (aVar != null) {
                childAt.layout(aVar.f16065a, aVar.f16066b, aVar.f16067c, aVar.f16068d);
            } else {
                Log.i("MyLayout", "error");
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        int size = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        byte b8 = 0;
        this.f16061a = 0;
        this.f16062b = 0;
        this.f16063c = 5;
        this.f16064d = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight();
            i9 += measuredWidth;
            a aVar = new a(b8);
            int iA = a(i12 - i10, i12);
            this.f16061a = iA;
            this.f16062b = childAt.getMeasuredWidth() + iA;
            if (i9 >= size) {
                this.f16061a = 0;
                this.f16062b = childAt.getMeasuredWidth();
                this.f16063c = i11 + measuredHeight + layoutParams.topMargin;
                i10 = i12;
                i9 = measuredWidth;
            }
            int measuredHeight2 = childAt.getMeasuredHeight() + this.f16063c + layoutParams.bottomMargin;
            this.f16064d = measuredHeight2;
            i11 = this.f16063c;
            aVar.f16065a = this.f16061a;
            aVar.f16066b = i11 + 3;
            aVar.f16067c = this.f16062b;
            aVar.f16068d = measuredHeight2;
            this.e.put(childAt, aVar);
        }
        setMeasuredDimension(size, this.f16064d);
    }

    public AutoNextLineLinearLayout(Context context, int i2, int i8) {
        super(context);
        this.e = new Hashtable();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(0, 0);
    }

    public AutoNextLineLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Hashtable();
    }
}
