package com.vungle.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vungle.ads.internal.ui.VungleWebClient;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RingerModeReceiver extends BroadcastReceiver {
    private VungleWebClient webClient;

    public final VungleWebClient getWebClient() {
        return this.webClient;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        VungleWebClient vungleWebClient;
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (Exception e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage != null) {
                    Logger.Companion.e("RingerModeReceiver", localizedMessage);
                    return;
                }
                return;
            }
        } else {
            action = null;
        }
        if (k.a(action, "android.media.RINGER_MODE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
            Logger.Companion.d("RingerModeReceiver", "receive ringermode: " + intExtra);
            if (intExtra == 0) {
                VungleWebClient vungleWebClient2 = this.webClient;
                if (vungleWebClient2 != null) {
                    vungleWebClient2.notifySilentModeChange(true);
                    return;
                }
                return;
            }
            if (intExtra != 1) {
                if (intExtra == 2 && (vungleWebClient = this.webClient) != null) {
                    vungleWebClient.notifySilentModeChange(false);
                    return;
                }
                return;
            }
            VungleWebClient vungleWebClient3 = this.webClient;
            if (vungleWebClient3 != null) {
                vungleWebClient3.notifySilentModeChange(true);
            }
        }
    }

    public final void setWebClient(VungleWebClient vungleWebClient) {
        this.webClient = vungleWebClient;
    }
}
