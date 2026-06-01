package com.unity3d.ads.adplayer;

import android.view.View;
import kotlin.jvm.internal.k;
import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ View $this_doOnDetach;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    public AndroidEmbeddableWebViewAdPlayer$show$lambda$4$$inlined$doOnDetach$1(View view, AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer) {
        this.$this_doOnDetach = view;
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        k.e(view, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        k.e(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        c0.u(this.this$0.webViewAdPlayer.getScope(), null, new AndroidEmbeddableWebViewAdPlayer$show$3$2$1(this.this$0, null), 3);
    }
}
