package com.onesignal.location.internal;

import com.onesignal.core.internal.minification.KeepStub;
import com.onesignal.location.ILocationManager;
import kotlin.jvm.internal.f;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@KeepStub
public final class MisconfiguredLocationManager implements ILocationManager {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Exception getEXCEPTION() {
            return new Exception("Must include gradle module com.onesignal:Location in order to use this functionality!");
        }

        private Companion() {
        }
    }

    @Override // com.onesignal.location.ILocationManager
    public boolean isShared() throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.location.ILocationManager
    public Object requestPermission(c<?> cVar) throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.location.ILocationManager
    public void setShared(boolean z2) throws Exception {
        throw Companion.getEXCEPTION();
    }
}
