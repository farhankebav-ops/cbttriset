package com.ironsource.mediationsdk.logger;

import com.ironsource.C2379ib;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceLoggerManager extends IronSourceLogger {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile IronSourceLoggerManager f9221d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<IronSourceLogger> f9222c;

    private IronSourceLoggerManager(String str) {
        super(str);
        this.f9222c = new CopyOnWriteArrayList();
        c();
    }

    private void c() {
        this.f9222c.add(new a(0));
    }

    public static IronSourceLoggerManager getLogger() {
        if (f9221d == null) {
            synchronized (IronSourceLoggerManager.class) {
                try {
                    if (f9221d == null) {
                        f9221d = new IronSourceLoggerManager("IronSourceLoggerManager");
                    }
                } finally {
                }
            }
        }
        return f9221d;
    }

    public void a(IronSourceLogger.IronSourceTag ironSourceTag, C2379ib c2379ib) {
        if (a(c2379ib.a())) {
            return;
        }
        a(ironSourceTag, c2379ib.c(), c2379ib.a());
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.f9222c.add(ironSourceLogger);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    @Deprecated(forRemoval = true, since = "8.3.0")
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        if (a(i2)) {
            return;
        }
        a(ironSourceTag, str, i2);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.f9222c.iterator();
            while (it.hasNext()) {
                it.next().log(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.f9222c.iterator();
            while (it2.hasNext()) {
                it2.next().logException(ironSourceTag, str, th);
            }
        }
    }

    public void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        log(ironSourceTag, str, i2);
    }

    public void setLoggerDebugLevel(String str, int i2) {
        if (str == null) {
            return;
        }
        IronSourceLogger ironSourceLoggerA = a(str);
        if (ironSourceLoggerA == null) {
            log(IronSourceLogger.IronSourceTag.NATIVE, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i2 + ")", 0);
            return;
        }
        if (i2 < 0 || i2 > 3) {
            this.f9222c.remove(ironSourceLoggerA);
            return;
        }
        log(IronSourceLogger.IronSourceTag.NATIVE, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i2 + ")", 0);
        ironSourceLoggerA.setDebugLevel(i2);
    }

    public void a(IronSourceLogger.IronSourceTag ironSourceTag, C2379ib c2379ib, Throwable th) {
        if (a(c2379ib.a())) {
            return;
        }
        logException(ironSourceTag, c2379ib.c(), th);
    }

    private IronSourceLoggerManager(String str, int i2) {
        super(str, i2);
        this.f9222c = new CopyOnWriteArrayList();
        c();
    }

    private boolean a(int i2) {
        return i2 < this.f9217a;
    }

    public void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        for (IronSourceLogger ironSourceLogger : this.f9222c) {
            if (ironSourceLogger.a() <= i2) {
                ironSourceLogger.log(ironSourceTag, str, i2);
            }
        }
    }

    public static IronSourceLoggerManager getLogger(int i2) {
        IronSourceLoggerManager logger = getLogger();
        logger.f9217a = i2;
        return logger;
    }

    private IronSourceLogger a(String str) {
        for (IronSourceLogger ironSourceLogger : this.f9222c) {
            if (ironSourceLogger.b().equals(str)) {
                return ironSourceLogger;
            }
        }
        return null;
    }
}
