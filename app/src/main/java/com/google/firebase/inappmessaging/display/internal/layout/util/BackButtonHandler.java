package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class BackButtonHandler {
    private View.OnClickListener listener;
    private ViewGroup viewGroup;

    public BackButtonHandler(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.viewGroup = viewGroup;
        this.listener = onClickListener;
    }

    @Nullable
    public Boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        View.OnClickListener onClickListener = this.listener;
        if (onClickListener == null) {
            return Boolean.FALSE;
        }
        onClickListener.onClick(this.viewGroup);
        return Boolean.TRUE;
    }
}
