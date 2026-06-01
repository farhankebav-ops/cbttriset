package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1545eS {
    void A9V();

    boolean A9i();

    boolean A9j();

    boolean AAT();

    void AG7(boolean z2, int i2);

    void AJH(int i2);

    void AJM(EnumC1493db enumC1493db, int i2);

    void AJU(int i2);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    EnumC1493db getStartReason();

    EnumC1547eU getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i2);

    void setBackgroundPlaybackEnabled(boolean z2);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z2);

    void setRequestedVolume(float f4);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(InterfaceC1548eV interfaceC1548eV);

    void setup(Uri uri);
}
