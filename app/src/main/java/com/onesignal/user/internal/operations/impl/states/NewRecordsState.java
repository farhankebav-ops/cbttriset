package com.onesignal.user.internal.operations.impl.states;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NewRecordsState {
    private final ConfigModelStore _configModelStore;
    private final ITime _time;
    private final Map<String, Long> records;

    public NewRecordsState(ITime _time, ConfigModelStore _configModelStore) {
        k.e(_time, "_time");
        k.e(_configModelStore, "_configModelStore");
        this._time = _time;
        this._configModelStore = _configModelStore;
        this.records = new LinkedHashMap();
    }

    public final void add(String key) {
        k.e(key, "key");
        this.records.put(key, Long.valueOf(this._time.getCurrentTimeMillis()));
    }

    public final boolean canAccess(String key) {
        k.e(key, "key");
        Long l = this.records.get(key);
        if (l != null) {
            return this._time.getCurrentTimeMillis() - l.longValue() >= this._configModelStore.getModel().getOpRepoPostCreateDelay();
        }
        return true;
    }

    public final boolean isInMissingRetryWindow(String key) {
        k.e(key, "key");
        Long l = this.records.get(key);
        if (l != null) {
            if (this._time.getCurrentTimeMillis() - l.longValue() <= this._configModelStore.getModel().getOpRepoPostCreateRetryUpTo()) {
                return true;
            }
        }
        return false;
    }
}
