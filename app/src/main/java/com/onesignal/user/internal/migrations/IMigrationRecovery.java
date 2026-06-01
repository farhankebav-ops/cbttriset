package com.onesignal.user.internal.migrations;

import com.onesignal.core.internal.startup.IStartableService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IMigrationRecovery extends IStartableService {
    boolean isInBadState();

    void recover();

    String recoveryMessage();
}
