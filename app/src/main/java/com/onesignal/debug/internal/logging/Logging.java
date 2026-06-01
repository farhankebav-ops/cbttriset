package com.onesignal.debug.internal.logging;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import com.ironsource.C2300e4;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.ILogListener;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.OneSignalLogEvent;
import e6.l;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.k;
import n6.n;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Logging {
    private static final String TAG = "OneSignal";
    private static IApplicationService applicationService;
    public static final Logging INSTANCE = new Logging();
    private static final CopyOnWriteArraySet<ILogListener> logListeners = new CopyOnWriteArraySet<>();
    private static LogLevel logLevel = LogLevel.WARN;
    private static LogLevel visualLogLevel = LogLevel.NONE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            iArr[LogLevel.VERBOSE.ordinal()] = 1;
            iArr[LogLevel.DEBUG.ordinal()] = 2;
            iArr[LogLevel.INFO.ordinal()] = 3;
            iArr[LogLevel.WARN.ordinal()] = 4;
            iArr[LogLevel.ERROR.ordinal()] = 5;
            iArr[LogLevel.FATAL.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.debug.internal.logging.Logging$showVisualLogging$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.debug.internal.logging.Logging$showVisualLogging$1", f = "Logging.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ String $finalFullMessage;
        final /* synthetic */ LogLevel $level;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LogLevel logLevel, String str, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$level = logLevel;
            this.$finalFullMessage = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$level, this.$finalFullMessage, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            IApplicationService applicationService = Logging.INSTANCE.getApplicationService();
            Activity current = applicationService != null ? applicationService.getCurrent() : null;
            if (current != null) {
                new AlertDialog.Builder(current).setTitle(this.$level.toString()).setMessage(this.$finalFullMessage).show();
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    private Logging() {
    }

    public static final boolean atLogLevel(LogLevel level) {
        k.e(level, "level");
        return level.compareTo(visualLogLevel) < 1 || level.compareTo(logLevel) < 1;
    }

    private final void callLogListeners(LogLevel logLevel2, String str, Throwable th) {
        CopyOnWriteArraySet<ILogListener> copyOnWriteArraySet = logListeners;
        if (copyOnWriteArraySet.isEmpty()) {
            return;
        }
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Iterator<ILogListener> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            it.next().onLogEvent(new OneSignalLogEvent(logLevel2, str));
        }
    }

    public static final void debug(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.DEBUG, message, th);
    }

    public static /* synthetic */ void debug$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        debug(str, th);
    }

    public static final void error(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.ERROR, message, th);
    }

    public static /* synthetic */ void error$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        error(str, th);
    }

    public static final void fatal(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.FATAL, message, th);
    }

    public static /* synthetic */ void fatal$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        fatal(str, th);
    }

    public static final LogLevel getLogLevel() {
        return logLevel;
    }

    public static final LogLevel getVisualLogLevel() {
        return visualLogLevel;
    }

    public static final void info(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.INFO, message, th);
    }

    public static /* synthetic */ void info$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        info(str, th);
    }

    public static final void log(LogLevel level, String message) {
        k.e(level, "level");
        k.e(message, "message");
        log(level, message, null);
    }

    private final void logToLogcat(LogLevel logLevel2, String str, Throwable th) {
        if (logLevel2.compareTo(logLevel) >= 1) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[logLevel2.ordinal()]) {
            case 1:
                Log.v("OneSignal", str, th);
                break;
            case 2:
                Log.d("OneSignal", str, th);
                break;
            case 3:
                Log.i("OneSignal", str, th);
                break;
            case 4:
                Log.w("OneSignal", str, th);
                break;
            case 5:
            case 6:
                Log.e("OneSignal", str, th);
                break;
        }
    }

    public static final void setLogLevel(LogLevel logLevel2) {
        k.e(logLevel2, "<set-?>");
        logLevel = logLevel2;
    }

    public static final void setVisualLogLevel(LogLevel logLevel2) {
        k.e(logLevel2, "<set-?>");
        visualLogLevel = logLevel2;
    }

    private final void showVisualLogging(LogLevel logLevel2, String str, Throwable th) {
        if (logLevel2.compareTo(visualLogLevel) >= 1) {
            return;
        }
        try {
            String strB0 = n.b0(str + '\n');
            if (th != null) {
                String str2 = strB0 + th.getMessage();
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                strB0 = str2 + stringWriter;
            }
            ThreadUtilsKt.suspendifyOnMain(new AnonymousClass1(logLevel2, strB0, null));
        } catch (Throwable th2) {
            Log.e("OneSignal", "Error showing logging message.", th2);
        }
    }

    public static final void verbose(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.VERBOSE, message, th);
    }

    public static /* synthetic */ void verbose$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        verbose(str, th);
    }

    public static final void warn(String message, Throwable th) {
        k.e(message, "message");
        log(LogLevel.WARN, message, th);
    }

    public static /* synthetic */ void warn$default(String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        warn(str, th);
    }

    public final void addListener(ILogListener listener) {
        k.e(listener, "listener");
        logListeners.add(listener);
    }

    public final IApplicationService getApplicationService() {
        return applicationService;
    }

    public final void removeListener(ILogListener listener) {
        k.e(listener, "listener");
        logListeners.remove(listener);
    }

    public final void setApplicationService(IApplicationService iApplicationService) {
        applicationService = iApplicationService;
    }

    public static final void log(LogLevel level, String message, Throwable th) {
        k.e(level, "level");
        k.e(message, "message");
        String str = C2300e4.i.f8403d + Thread.currentThread().getName() + "] " + message;
        Logging logging = INSTANCE;
        logging.logToLogcat(level, str, th);
        logging.showVisualLogging(level, str, th);
        logging.callLogListeners(level, str, th);
    }

    public static /* synthetic */ void getLogLevel$annotations() {
    }

    public static /* synthetic */ void getVisualLogLevel$annotations() {
    }
}
