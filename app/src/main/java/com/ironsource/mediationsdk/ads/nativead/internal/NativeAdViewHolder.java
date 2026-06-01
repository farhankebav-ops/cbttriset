package com.ironsource.mediationsdk.ads.nativead.internal;

import android.view.View;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NativeAdViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f9013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f9014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f9015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f9016d;
    private LevelPlayMediaView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f9017f;

    public final View getAdvertiserView() {
        return this.f9014b;
    }

    public final View getBodyView() {
        return this.f9016d;
    }

    public final View getCallToActionView() {
        return this.f9017f;
    }

    public final View getIconView() {
        return this.f9015c;
    }

    public final LevelPlayMediaView getMediaView() {
        return this.e;
    }

    public final View getTitleView() {
        return this.f9013a;
    }

    public final void setAdvertiserView(View view) {
        this.f9014b = view;
    }

    public final void setBodyView(View view) {
        this.f9016d = view;
    }

    public final void setCallToActionView(View view) {
        this.f9017f = view;
    }

    public final void setIconView(View view) {
        this.f9015c = view;
    }

    public final void setMediaView(LevelPlayMediaView levelPlayMediaView) {
        this.e = levelPlayMediaView;
    }

    public final void setTitleView(View view) {
        this.f9013a = view;
    }
}
