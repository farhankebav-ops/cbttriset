package com.onesignal.inAppMessages.internal.display.impl;

import android.view.View;
import android.widget.PopupWindow;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OSPopupWindow extends PopupWindow {
    private final PopupWindowListener listener;
    private Boolean wasDismissedManually;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PopupWindowListener {
        void onDismiss(Boolean bool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OSPopupWindow(View view, int i2, int i8, boolean z2, PopupWindowListener listener) {
        super(view, i2, i8, z2);
        k.e(listener, "listener");
        this.listener = listener;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        this.listener.onDismiss(this.wasDismissedManually);
    }

    public final Boolean getWasDismissedManually() {
        return this.wasDismissedManually;
    }

    public final void setWasDismissedManually(Boolean bool) {
        this.wasDismissedManually = bool;
    }
}
