package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class FiamRelativeLayout extends RelativeLayout implements BackButtonLayout {
    private BackButtonHandler mBackHandler;

    public FiamRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean boolDispatchKeyEvent = this.mBackHandler.dispatchKeyEvent(keyEvent);
        return boolDispatchKeyEvent != null ? boolDispatchKeyEvent.booleanValue() : super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BackButtonLayout
    public void setDismissListener(View.OnClickListener onClickListener) {
        this.mBackHandler = new BackButtonHandler(this, onClickListener);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(21)
    public FiamRelativeLayout(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
    }
}
