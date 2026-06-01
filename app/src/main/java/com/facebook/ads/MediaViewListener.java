package com.facebook.ads;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public interface MediaViewListener {
    void onComplete(MediaView mediaView);

    void onEnterFullscreen(MediaView mediaView);

    void onExitFullscreen(MediaView mediaView);

    void onFullscreenBackground(MediaView mediaView);

    void onFullscreenForeground(MediaView mediaView);

    void onPause(MediaView mediaView);

    void onPlay(MediaView mediaView);

    void onVolumeChange(MediaView mediaView, float f4);
}
