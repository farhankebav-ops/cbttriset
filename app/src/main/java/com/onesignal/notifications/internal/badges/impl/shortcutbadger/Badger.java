package com.onesignal.notifications.internal.badges.impl.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Badger {
    void executeBadge(Context context, ComponentName componentName, int i2) throws ShortcutBadgeException;

    List<String> getSupportLaunchers();
}
