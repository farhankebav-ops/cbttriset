package com.bytedance.sdk.openadsdk.EO;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.EO.NV;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends ViewGroup implements NV.EO {
    private final NV IlO;

    public lEW(Context context, NV nv) {
        super(context);
        this.IlO = nv;
        nv.IlO(this);
    }

    private View MY(FilterWord filterWord) {
        TextView textView = new TextView(getContext());
        textView.setTag(filterWord);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        int iMY = BS.MY(getContext(), 8.0f);
        marginLayoutParams.leftMargin = iMY;
        marginLayoutParams.bottomMargin = iMY;
        textView.setTextColor(IlO());
        textView.setText(filterWord.getName());
        textView.setPadding(iMY, iMY, iMY, iMY);
        textView.setBackground(MY());
        textView.setSelected(false);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.lEW.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (lEW.this.IlO != null) {
                    if (view.isSelected()) {
                        lEW.this.IlO.IlO(NV.IlO);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof FilterWord) {
                        lEW.this.IlO.IlO((FilterWord) tag);
                    }
                }
            }
        });
        textView.setSelected(false);
        textView.setLayoutParams(marginLayoutParams);
        return textView;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        int childCount = getChildCount();
        int i12 = i9 - i2;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i16 = i13 != 0 ? marginLayoutParams.leftMargin : 0;
            if (measuredWidth + i16 + i14 < i12) {
                i11 = i14 + i16;
            } else {
                i15 += marginLayoutParams.bottomMargin + measuredHeight;
                i11 = 0;
            }
            childAt.layout(i11, marginLayoutParams.topMargin + i15, i11 + measuredWidth, measuredHeight + i15);
            i14 = i11 + measuredWidth + marginLayoutParams.rightMargin;
            i13++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i8);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < getChildCount()) {
            View childAt = getChildAt(i9);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            measureChild(childAt, i2, i8);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i12 = i9 != 0 ? marginLayoutParams.leftMargin : 0;
            int i13 = (measuredWidth + i12) + i11 < size ? i11 + i12 : 0;
            if (i13 == 0) {
                i10 += measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            i11 = i13 + measuredWidth + marginLayoutParams.rightMargin;
            i9++;
        }
        setMeasuredDimension(size, i10);
    }

    public void IlO(List<FilterWord> list) {
        if (list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            FilterWord filterWord = list.get(i2);
            if (filterWord != null) {
                addView(MY(filterWord));
            }
        }
    }

    private ColorStateList IlO() {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{Color.rgb(255, 44, 85), ViewCompat.MEASURED_STATE_MASK});
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.EO
    public void IlO(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (NV.IlO.equals(filterWord)) {
                    childAt.setSelected(false);
                } else {
                    childAt.setSelected(filterWord.equals(childAt.getTag()));
                }
            }
        }
    }

    private Drawable MY() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float fMY = BS.MY(getContext(), 5.0f);
        gradientDrawable.setCornerRadius(fMY);
        gradientDrawable.setColor(Color.parseColor("#0D000000"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(BS.MY(getContext(), 1.0f), Color.parseColor("#FE2C55"));
        gradientDrawable2.setCornerRadius(fMY);
        gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }
}
