package com.onesignal.core.internal.permissions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IRequestPermissionService {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PermissionCallback {
        void onAccept();

        void onReject(boolean z2);
    }

    void registerAsCallback(String str, PermissionCallback permissionCallback);

    void startPrompt(boolean z2, String str, String str2, Class<?> cls);
}
