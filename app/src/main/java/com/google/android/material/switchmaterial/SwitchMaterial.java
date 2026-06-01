package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import p1.a;
import q1.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int[][] e = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f5444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f5445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5446d;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2 = androidx.appcompat.R.attr.switchStyle;
        super(b2.a.a(context, attributeSet, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_Switch), attributeSet, i2);
        Context context2 = getContext();
        this.f5443a = new a(context2);
        l.a(context2, attributeSet, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        int[] iArr = b1.a.G;
        l.b(context2, attributeSet, iArr, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_Switch, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        this.f5446d = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f5444b == null) {
            int iB = m1.a.b(this, com.cbt.exam.browser.R.attr.colorSurface);
            int iB2 = m1.a.b(this, androidx.appcompat.R.attr.colorControlActivated);
            float dimension = getResources().getDimension(com.cbt.exam.browser.R.dimen.mtrl_switch_thumb_elevation);
            a aVar = this.f5443a;
            if (aVar.f13321a) {
                float elevation = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    elevation += ((View) parent).getElevation();
                }
                dimension += elevation;
            }
            int iA = aVar.a(iB, dimension);
            this.f5444b = new ColorStateList(e, new int[]{m1.a.c(iB, iB2, 1.0f), iA, m1.a.c(iB, iB2, 0.38f), iA});
        }
        return this.f5444b;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f5445c == null) {
            int iB = m1.a.b(this, com.cbt.exam.browser.R.attr.colorSurface);
            int iB2 = m1.a.b(this, androidx.appcompat.R.attr.colorControlActivated);
            int iB3 = m1.a.b(this, com.cbt.exam.browser.R.attr.colorOnSurface);
            this.f5445c = new ColorStateList(e, new int[]{m1.a.c(iB, iB2, 0.54f), m1.a.c(iB, iB3, 0.32f), m1.a.c(iB, iB2, 0.12f), m1.a.c(iB, iB3, 0.12f)});
        }
        return this.f5445c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5446d && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f5446d && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f5446d = z2;
        if (z2) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
