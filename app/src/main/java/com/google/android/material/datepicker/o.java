package com.google.android.material.datepicker;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5372d;
    public final /* synthetic */ int e;

    public o(View view, int i2, int i8, int i9, int i10) {
        this.f5369a = i2;
        this.f5370b = view;
        this.f5371c = i8;
        this.f5372d = i9;
        this.e = i10;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        View view2 = this.f5370b;
        int i2 = this.f5369a;
        if (i2 >= 0) {
            view2.getLayoutParams().height = i2 + insets.top;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.f5371c + insets.left, this.f5372d + insets.top, this.e + insets.right, view2.getPaddingBottom());
        return windowInsetsCompat;
    }
}
