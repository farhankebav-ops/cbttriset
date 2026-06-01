package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.button.MaterialButton;
import k1.c;
import q1.l;
import s1.a;
import t1.b;
import z1.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    public final AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    public final AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    public final AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    public final AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        int i2 = R.attr.radioButtonStyle;
        a aVar = new a(b2.a.a(context, attributeSet, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet, i2);
        Context context2 = aVar.getContext();
        TypedArray typedArrayD = l.d(context2, attributeSet, b1.a.f4138u, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayD.hasValue(0)) {
            CompoundButtonCompat.setButtonTintList(aVar, t1.c.a(context2, typedArrayD, 0));
        }
        aVar.f13677b = typedArrayD.getBoolean(1, false);
        typedArrayD.recycle();
        return aVar;
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    public final AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        a2.a aVar = new a2.a(b2.a.a(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (b.b(context2, com.cbt.exam.browser.R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = b1.a.y;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iA = a2.a.a(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iA == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, b1.a.f4141x);
                    int iA2 = a2.a.a(aVar.getContext(), typedArrayObtainStyledAttributes3, 2, 4);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iA2 >= 0) {
                        aVar.setLineHeight(iA2);
                    }
                }
            }
        }
        return aVar;
    }
}
