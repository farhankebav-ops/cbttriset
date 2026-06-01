package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface DefaultMediaViewVideoRendererApi {
    public static final int MEDIA_VIEW_RENDERER_CHILD_TYPE_BACKGROUND_PLAYBACK = 1;
    public static final int MEDIA_VIEW_RENDERER_CHILD_TYPE_DEFAULT = 0;

    void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i2);

    void onPrepared();
}
