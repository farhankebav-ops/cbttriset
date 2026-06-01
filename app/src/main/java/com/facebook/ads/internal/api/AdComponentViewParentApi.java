package com.facebook.ads.internal.api;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@UiThread
public interface AdComponentViewParentApi extends AdComponentView {
    void bringChildToFront(View view);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onMeasure(int i2, int i8);

    void onVisibilityChanged(View view, int i2);

    void setMeasuredDimension(int i2, int i8);
}
