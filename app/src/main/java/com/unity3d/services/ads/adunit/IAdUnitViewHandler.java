package com.unity3d.services.ads.adunit;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IAdUnitViewHandler {
    boolean create(IAdUnitActivity iAdUnitActivity);

    boolean destroy();

    View getView();

    void onCreate(IAdUnitActivity iAdUnitActivity, Bundle bundle);

    void onDestroy(IAdUnitActivity iAdUnitActivity);

    void onPause(IAdUnitActivity iAdUnitActivity);

    void onResume(IAdUnitActivity iAdUnitActivity);

    void onStart(IAdUnitActivity iAdUnitActivity);

    void onStop(IAdUnitActivity iAdUnitActivity);
}
