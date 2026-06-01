package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<IlO> IlO;

    public void IlO(IlO ilO) {
        this.IlO = new WeakReference<>(ilO);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<IlO> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().onThemeChanged(intExtra);
    }
}
