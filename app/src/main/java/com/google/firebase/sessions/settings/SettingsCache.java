package com.google.firebase.sessions.settings;

import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface SettingsCache {
    boolean hasCacheExpired();

    Integer sessionRestartTimeout();

    Double sessionSamplingRate();

    Boolean sessionsEnabled();

    Object updateConfigs(SessionConfigs sessionConfigs, c<? super x> cVar);
}
