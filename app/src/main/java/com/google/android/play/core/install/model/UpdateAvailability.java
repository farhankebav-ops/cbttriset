package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.CLASS)
public @interface UpdateAvailability {
    public static final int DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS = 3;
    public static final int UNKNOWN = 0;
    public static final int UPDATE_AVAILABLE = 2;
    public static final int UPDATE_NOT_AVAILABLE = 1;
}
