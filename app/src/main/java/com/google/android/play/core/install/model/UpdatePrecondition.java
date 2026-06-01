package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface UpdatePrecondition {
    public static final int APP_VERSION_FRESH = 5;
    public static final int CANNOT_DISPLAY = 1;
    public static final int DEVICE_STATUS = 4;
    public static final int INSUFFICIENT_STORAGE = 3;
    public static final int NEED_STORE_TO_PROCEED = 2;
    public static final int UNKNOWN = 0;
}
