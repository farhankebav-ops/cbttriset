package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import q1.a;
import q1.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f5414d = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5417c;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
        this.f5416b = true;
        this.f5417c = true;
        ViewCompat.setAccessibilityDelegate(this, new a(this, 0));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f5415a;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        return this.f5415a ? View.mergeDrawableStates(super.onCreateDrawableState(i2 + 1), f5414d) : super.onCreateDrawableState(i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.f13383a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f13383a = this.f5415a;
        return bVar;
    }

    public void setCheckable(boolean z2) {
        if (this.f5416b != z2) {
            this.f5416b = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.f5416b || this.f5415a == z2) {
            return;
        }
        this.f5415a = z2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z2) {
        this.f5417c = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f5417c) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f5415a);
    }
}
