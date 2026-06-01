package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.C2300e4;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InterstitialActivity extends ControllerActivity {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f9853r = "InterstitialActivity";

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(f9853r, "onCreate");
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Logger.i(f9853r, C2300e4.h.t0);
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.i(f9853r, C2300e4.h.f8387u0);
    }
}
