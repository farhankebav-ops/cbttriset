package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class GlideErrorListener implements RequestListener<Drawable> {
    private final FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
    private final InAppMessage inAppMessage;

    public GlideErrorListener(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.displayCallbacks = firebaseInAppMessagingDisplayCallbacks;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z2) {
        Logging.logd("Image Downloading  Error : " + glideException.getMessage() + ":" + glideException.getCause());
        if (this.inAppMessage == null || this.displayCallbacks == null) {
            return false;
        }
        if (glideException.getLocalizedMessage().contains("Failed to decode")) {
            this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
            return false;
        }
        this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z2) {
        Logging.logd("Image Downloading  Success : " + drawable);
        return false;
    }
}
