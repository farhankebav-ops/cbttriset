package androidx.core.app;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface OnUserLeaveHintProvider {
    void addOnUserLeaveHintListener(Runnable runnable);

    void removeOnUserLeaveHintListener(Runnable runnable);
}
