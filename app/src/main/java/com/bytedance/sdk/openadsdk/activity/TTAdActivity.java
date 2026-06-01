package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.pP;
import com.bytedance.sdk.openadsdk.utils.ea;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTAdActivity extends TTBaseActivity {
    private MY IlO;

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MY my = this.IlO;
        if (my != null) {
            my.IlO((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        MY my = this.IlO;
        if (my == null) {
            super.onBackPressed();
        } else {
            my.vCE();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilOEO = pP.IlO().EO();
        com.bytedance.sdk.openadsdk.IlO.EO.MY myTV = pP.IlO().tV();
        oeT oetIlO = com.bytedance.sdk.openadsdk.component.reward.IlO.MY.IlO(getIntent(), bundle, (com.bytedance.sdk.openadsdk.core.rp.tV.MY) null);
        if (oetIlO == null) {
            finish();
            return;
        }
        MY my = new MY(this, oetIlO);
        this.IlO = my;
        my.IlO(this, bundle, ilOEO, myTV);
        com.bytedance.sdk.openadsdk.utils.MY.IlO(oetIlO);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MY my = this.IlO;
        if (my != null) {
            my.Cc(this);
        }
        pP.IlO().IlO((com.bytedance.sdk.openadsdk.IlO.Cc.IlO) null);
        pP.IlO().IlO((com.bytedance.sdk.openadsdk.IlO.EO.MY) null);
        ea.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MY my = this.IlO;
        if (my != null) {
            my.EO(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MY my = this.IlO;
        if (my != null) {
            my.MY(this);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MY my = this.IlO;
        if (my != null) {
            my.IlO(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        MY my = this.IlO;
        if (my != null) {
            my.IlO(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        MY my = this.IlO;
        if (my != null) {
            my.tV(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        MY my = this.IlO;
        if (my != null) {
            my.IlO(z2);
        }
    }
}
