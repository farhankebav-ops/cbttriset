package com.vungle.ads.fpd;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.g0;
import f7.m1;
import f7.q1;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class FirstPartyData {
    public static final Companion Companion = new Companion(null);
    private Map<String, String> _customData;
    private volatile Demographic _demographic;
    private volatile Location _location;
    private volatile Revenue _revenue;
    private volatile SessionContext _sessionContext;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return FirstPartyData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public FirstPartyData() {
    }

    public static final void write$Self(FirstPartyData self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self._sessionContext != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, SessionContext$$serializer.INSTANCE, self._sessionContext);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self._demographic != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, Demographic$$serializer.INSTANCE, self._demographic);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self._location != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Location$$serializer.INSTANCE, self._location);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self._revenue != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Revenue$$serializer.INSTANCE, self._revenue);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self._customData == null) {
            return;
        }
        q1 q1Var = q1.f11501a;
        output.encodeNullableSerializableElement(serialDesc, 4, new g0(q1Var, q1Var, 1), self._customData);
    }

    public final synchronized void clearAll() {
        try {
            this._sessionContext = null;
            this._demographic = null;
            this._location = null;
            this._revenue = null;
            Map<String, String> map = this._customData;
            if (map != null) {
                map.clear();
            }
            this._customData = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Map<String, String> getCustomData() {
        Map<String, String> concurrentHashMap;
        concurrentHashMap = this._customData;
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this._customData = concurrentHashMap;
        }
        return concurrentHashMap;
    }

    public final synchronized Demographic getDemographic() {
        Demographic demographic;
        demographic = this._demographic;
        if (demographic == null) {
            demographic = new Demographic();
            this._demographic = demographic;
        }
        return demographic;
    }

    public final synchronized Location getLocation() {
        Location location;
        location = this._location;
        if (location == null) {
            location = new Location();
            this._location = location;
        }
        return location;
    }

    public final synchronized Revenue getRevenue() {
        Revenue revenue;
        revenue = this._revenue;
        if (revenue == null) {
            revenue = new Revenue();
            this._revenue = revenue;
        }
        return revenue;
    }

    public final synchronized SessionContext getSessionContext() {
        SessionContext sessionContext;
        sessionContext = this._sessionContext;
        if (sessionContext == null) {
            sessionContext = new SessionContext();
            this._sessionContext = sessionContext;
        }
        return sessionContext;
    }

    public /* synthetic */ FirstPartyData(int i2, SessionContext sessionContext, Demographic demographic, Location location, Revenue revenue, Map map, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this._sessionContext = null;
        } else {
            this._sessionContext = sessionContext;
        }
        if ((i2 & 2) == 0) {
            this._demographic = null;
        } else {
            this._demographic = demographic;
        }
        if ((i2 & 4) == 0) {
            this._location = null;
        } else {
            this._location = location;
        }
        if ((i2 & 8) == 0) {
            this._revenue = null;
        } else {
            this._revenue = revenue;
        }
        if ((i2 & 16) == 0) {
            this._customData = null;
        } else {
            this._customData = map;
        }
    }

    private static /* synthetic */ void get_customData$annotations() {
    }

    private static /* synthetic */ void get_demographic$annotations() {
    }

    private static /* synthetic */ void get_location$annotations() {
    }

    private static /* synthetic */ void get_revenue$annotations() {
    }

    private static /* synthetic */ void get_sessionContext$annotations() {
    }
}
