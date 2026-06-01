package com.onesignal.core.internal.preferences.impl;

import a1.a;
import android.content.SharedPreferences;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f0;
import q6.m0;
import q6.z0;
import v5.c;
import x5.e;
import x5.i;
import x6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PreferencesService implements IPreferencesService, IStartableService {
    public static final Companion Companion = new Companion(null);
    private static final int WRITE_CALL_DELAY_TO_BUFFER_MS = 200;
    private final IApplicationService _applicationService;
    private final ITime _time;
    private final Map<String, Map<String, Object>> prefsToApply;
    private f0 queueJob;
    private final Waiter waiter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1", f = "PreferencesService.kt", l = {Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_LOAD_FAIL_PLACEMENT_ID_MISMATCH_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        long J$0;
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return PreferencesService.this.new AnonymousClass1(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00f7, code lost:
        
            if (q6.c0.k(r4, r11) == r0) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00fd, code lost:
        
            r4 = r6;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x010c -> B:17:0x0031). Please report as a decompilation issue!!! */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 280
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.preferences.impl.PreferencesService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public PreferencesService(IApplicationService _applicationService, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._time = _time;
        this.prefsToApply = r5.x.f0(new q5.i(PreferenceStores.ONESIGNAL, new LinkedHashMap()), new q5.i(PreferenceStores.PLAYER_PURCHASES, new LinkedHashMap()));
        this.waiter = new Waiter();
    }

    private final f0 doWorkAsync() {
        x6.e eVar = m0.f13566a;
        return c0.g(z0.f13606a, d.f17810a, new AnonymousClass1(null), 2);
    }

    private final Object get(String str, String str2, Class<?> cls, Object obj) throws Exception {
        if (!this.prefsToApply.containsKey(str)) {
            throw new Exception(a.l("Store not found: ", str));
        }
        Map<String, Object> map = this.prefsToApply.get(str);
        k.b(map);
        Map<String, Object> map2 = map;
        synchronized (map2) {
            Object obj2 = map2.get(str2);
            if (obj2 == null) {
                if (!map2.containsKey(str2)) {
                    SharedPreferences sharedPrefsByName = getSharedPrefsByName(str);
                    if (sharedPrefsByName != null) {
                        try {
                            if (k.a(cls, String.class)) {
                                return sharedPrefsByName.getString(str2, (String) obj);
                            }
                            if (k.a(cls, Boolean.TYPE)) {
                                Boolean bool = (Boolean) obj;
                                return Boolean.valueOf(sharedPrefsByName.getBoolean(str2, bool != null ? bool.booleanValue() : false));
                            }
                            if (k.a(cls, Integer.TYPE)) {
                                Integer num = (Integer) obj;
                                return Integer.valueOf(sharedPrefsByName.getInt(str2, num != null ? num.intValue() : 0));
                            }
                            if (k.a(cls, Long.TYPE)) {
                                Long l = (Long) obj;
                                return Long.valueOf(sharedPrefsByName.getLong(str2, l != null ? l.longValue() : 0L));
                            }
                            if (k.a(cls, Set.class)) {
                                return sharedPrefsByName.getStringSet(str2, (Set) obj);
                            }
                            return null;
                        } catch (Exception unused) {
                        }
                    }
                    if (k.a(cls, String.class)) {
                        return (String) obj;
                    }
                    if (k.a(cls, Boolean.TYPE)) {
                        Boolean bool2 = (Boolean) obj;
                        return Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
                    }
                    if (k.a(cls, Integer.TYPE)) {
                        Integer num2 = (Integer) obj;
                        return Integer.valueOf(num2 != null ? num2.intValue() : 0);
                    }
                    if (k.a(cls, Long.TYPE)) {
                        Long l8 = (Long) obj;
                        return Long.valueOf(l8 != null ? l8.longValue() : 0L);
                    }
                    if (k.a(cls, Set.class)) {
                        return (Set) obj;
                    }
                    return null;
                }
            }
            return obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized SharedPreferences getSharedPrefsByName(String str) {
        return this._applicationService.getAppContext().getSharedPreferences(str, 0);
    }

    private final void save(String str, String str2, Object obj) throws Exception {
        if (!this.prefsToApply.containsKey(str)) {
            throw new Exception(a.l("Store not found: ", str));
        }
        Map<String, Object> map = this.prefsToApply.get(str);
        k.b(map);
        Map<String, Object> map2 = map;
        synchronized (map2) {
            map2.put(str2, obj);
        }
        this.waiter.wake();
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public Boolean getBool(String store, String key, Boolean bool) {
        k.e(store, "store");
        k.e(key, "key");
        return (Boolean) get(store, key, Boolean.TYPE, bool);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public Integer getInt(String store, String key, Integer num) {
        k.e(store, "store");
        k.e(key, "key");
        return (Integer) get(store, key, Integer.TYPE, num);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public Long getLong(String store, String key, Long l) {
        k.e(store, "store");
        k.e(key, "key");
        return (Long) get(store, key, Long.TYPE, l);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public String getString(String store, String key, String str) {
        k.e(store, "store");
        k.e(key, "key");
        return (String) get(store, key, String.class, str);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public Set<String> getStringSet(String store, String key, Set<String> set) {
        k.e(store, "store");
        k.e(key, "key");
        return (Set) get(store, key, Set.class, set);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveBool(String store, String key, Boolean bool) throws Exception {
        k.e(store, "store");
        k.e(key, "key");
        save(store, key, bool);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveInt(String store, String key, Integer num) throws Exception {
        k.e(store, "store");
        k.e(key, "key");
        save(store, key, num);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveLong(String store, String key, Long l) throws Exception {
        k.e(store, "store");
        k.e(key, "key");
        save(store, key, l);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveString(String store, String key, String str) throws Exception {
        k.e(store, "store");
        k.e(key, "key");
        save(store, key, str);
    }

    @Override // com.onesignal.core.internal.preferences.IPreferencesService
    public void saveStringSet(String store, String key, Set<String> set) throws Exception {
        k.e(store, "store");
        k.e(key, "key");
        save(store, key, set);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.queueJob = doWorkAsync();
    }
}
