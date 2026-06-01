package com.bytedance.sdk.openadsdk.activity;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTBaseLandingPageActivity extends TTBaseActivity {
    private long IlO;
    private long MY;

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        long j = this.IlO;
        if (j > 0) {
            com.bytedance.sdk.openadsdk.utils.Cc.IlO(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.MY > 0) {
            this.IlO = (SystemClock.elapsedRealtime() - this.MY) + this.IlO;
            this.MY = 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.bytedance.sdk.openadsdk.utils.Cc.EO()) {
            this.MY = SystemClock.elapsedRealtime();
        }
    }
}
