package com.ironsource.mediationsdk.logger;

import com.ironsource.C2379ib;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum IronLog {
    API(IronSourceLogger.IronSourceTag.API),
    CALLBACK(IronSourceLogger.IronSourceTag.CALLBACK),
    ADAPTER_API(IronSourceLogger.IronSourceTag.ADAPTER_API),
    ADAPTER_CALLBACK(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK),
    NETWORK(IronSourceLogger.IronSourceTag.NETWORK),
    INTERNAL(IronSourceLogger.IronSourceTag.INTERNAL),
    NATIVE(IronSourceLogger.IronSourceTag.NATIVE),
    EVENT(IronSourceLogger.IronSourceTag.EVENT);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IronSourceLogger.IronSourceTag f9214a;

    IronLog(IronSourceLogger.IronSourceTag ironSourceTag) {
        this.f9214a = ironSourceTag;
    }

    public void error(String str, Throwable th) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 3), th);
    }

    public void general(String str) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 4));
    }

    public void info(String str) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 1));
    }

    public void verbose(String str) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 0));
    }

    public void warning(String str) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 2));
    }

    public void error(String str) {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib(str, 3));
    }

    public void general() {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib("", 4));
    }

    public void info() {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib("", 1));
    }

    public void verbose() {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib("", 0));
    }

    public void warning() {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib("", 2));
    }

    public void error() {
        IronSourceLoggerManager.getLogger().a(this.f9214a, new C2379ib("", 3));
    }
}
