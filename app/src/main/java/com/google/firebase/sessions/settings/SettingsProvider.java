package com.google.firebase.sessions.settings;

import o6.a;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface SettingsProvider {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static boolean isSettingsStale(SettingsProvider settingsProvider) {
            return false;
        }

        public static Object updateSettings(SettingsProvider settingsProvider, c<? super x> cVar) {
            return x.f13520a;
        }
    }

    Double getSamplingRate();

    Boolean getSessionEnabled();

    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    a mo217getSessionRestartTimeoutFghU774();

    boolean isSettingsStale();

    Object updateSettings(c<? super x> cVar);
}
