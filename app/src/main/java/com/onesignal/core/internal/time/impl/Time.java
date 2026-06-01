package com.onesignal.core.internal.time.impl;

import com.onesignal.core.internal.time.ITime;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Time implements ITime {
    @Override // com.onesignal.core.internal.time.ITime
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
