package com.onesignal.debug.internal;

import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.ILogListener;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DebugManager implements IDebugManager {
    public DebugManager() {
        setLogLevel(LogLevel.WARN);
        setAlertLevel(LogLevel.NONE);
    }

    @Override // com.onesignal.debug.IDebugManager
    public void addLogListener(ILogListener listener) {
        k.e(listener, "listener");
        Logging.INSTANCE.addListener(listener);
    }

    @Override // com.onesignal.debug.IDebugManager
    public LogLevel getAlertLevel() {
        return Logging.getVisualLogLevel();
    }

    @Override // com.onesignal.debug.IDebugManager
    public LogLevel getLogLevel() {
        return Logging.getLogLevel();
    }

    @Override // com.onesignal.debug.IDebugManager
    public void removeLogListener(ILogListener listener) {
        k.e(listener, "listener");
        Logging.INSTANCE.removeListener(listener);
    }

    @Override // com.onesignal.debug.IDebugManager
    public void setAlertLevel(LogLevel value) {
        k.e(value, "value");
        Logging.setVisualLogLevel(value);
    }

    @Override // com.onesignal.debug.IDebugManager
    public void setLogLevel(LogLevel value) {
        k.e(value, "value");
        Logging.setLogLevel(value);
    }
}
