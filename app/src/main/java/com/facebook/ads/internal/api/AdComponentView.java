package com.facebook.ads.internal.api;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@UiThread
public interface AdComponentView {
    void addView(View view);

    void addView(View view, int i2);

    void addView(View view, int i2, int i8);

    void addView(View view, int i2, ViewGroup.LayoutParams layoutParams);

    void addView(View view, ViewGroup.LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z2);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);
}
