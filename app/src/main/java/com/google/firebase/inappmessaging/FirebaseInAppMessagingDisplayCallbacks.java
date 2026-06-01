package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.model.Action;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface FirebaseInAppMessagingDisplayCallbacks {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InAppMessagingDismissType {
        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InAppMessagingErrorReason {
        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT
    }

    @NonNull
    Task<Void> displayErrorEncountered(@NonNull InAppMessagingErrorReason inAppMessagingErrorReason);

    @NonNull
    Task<Void> impressionDetected();

    @NonNull
    Task<Void> messageClicked(@NonNull Action action);

    @NonNull
    Task<Void> messageDismissed(@NonNull InAppMessagingDismissType inAppMessagingDismissType);
}
