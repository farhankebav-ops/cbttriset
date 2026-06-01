package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private IlO IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void MY();
    }

    public void IlO(IlO ilO) {
        this.IlO = ilO;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            Log.i("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                Log.i("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    Log.i("HomeReceiver", "homekey");
                    IlO ilO = this.IlO;
                    if (ilO != null) {
                        ilO.IlO();
                        return;
                    }
                    return;
                }
                if (!"recentapps".equals(stringExtra)) {
                    if ("assist".equals(stringExtra)) {
                        Log.i("HomeReceiver", "assist");
                    }
                } else {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    IlO ilO2 = this.IlO;
                    if (ilO2 != null) {
                        ilO2.MY();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
