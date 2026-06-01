package com.google.firebase.logger;

import a1.a;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import e2.s;
import e6.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n7.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Logger {
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, Logger> loggers = new ConcurrentHashMap<>();
    private boolean enabled;
    private Level minLevel;
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AndroidLogger extends Logger {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Level.values().length];
                try {
                    iArr[Level.VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Level.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Level.INFO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Level.WARN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Level.ERROR.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AndroidLogger(String tag, boolean z2, Level minLevel) {
            super(tag, z2, minLevel, null);
            k.e(tag, "tag");
            k.e(minLevel, "minLevel");
        }

        @Override // com.google.firebase.logger.Logger
        public int log(Level level, String format, Object[] args, Throwable th) {
            k.e(level, "level");
            k.e(format, "format");
            k.e(args, "args");
            if (args.length != 0) {
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                format = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                String tag = getTag();
                return th != null ? Log.v(tag, format, th) : Log.v(tag, format);
            }
            if (i2 == 2) {
                String tag2 = getTag();
                return th != null ? Log.d(tag2, format, th) : Log.d(tag2, format);
            }
            if (i2 == 3) {
                String tag3 = getTag();
                return th != null ? Log.i(tag3, format, th) : Log.i(tag3, format);
            }
            if (i2 == 4) {
                String tag4 = getTag();
                return th != null ? Log.w(tag4, format, th) : Log.w(tag4, format);
            }
            if (i2 != 5) {
                throw new s(3);
            }
            String tag5 = getTag();
            return th != null ? Log.e(tag5, format, th) : Log.e(tag5, format);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ Logger getLogger$default(Companion companion, String str, boolean z2, Level level, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            if ((i2 & 4) != 0) {
                level = Level.INFO;
            }
            return companion.getLogger(str, z2, level);
        }

        public static /* synthetic */ FakeLogger setupFakeLogger$default(Companion companion, String str, boolean z2, Level level, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            if ((i2 & 4) != 0) {
                level = Level.DEBUG;
            }
            return companion.setupFakeLogger(str, z2, level);
        }

        public final Logger getLogger(String tag, boolean z2, Level minLevel) {
            Object objPutIfAbsent;
            k.e(tag, "tag");
            k.e(minLevel, "minLevel");
            ConcurrentHashMap concurrentHashMap = Logger.loggers;
            Object androidLogger = concurrentHashMap.get(tag);
            if (androidLogger == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(tag, (androidLogger = new AndroidLogger(tag, z2, minLevel)))) != null) {
                androidLogger = objPutIfAbsent;
            }
            return (Logger) androidLogger;
        }

        @VisibleForTesting
        public final FakeLogger setupFakeLogger(String tag, boolean z2, Level minLevel) {
            k.e(tag, "tag");
            k.e(minLevel, "minLevel");
            FakeLogger fakeLogger = new FakeLogger(tag, z2, minLevel);
            Logger.loggers.put(tag, fakeLogger);
            return fakeLogger;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public static final class FakeLogger extends Logger {
        private final List<String> record;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeLogger(String tag, boolean z2, Level minLevel) {
            super(tag, z2, minLevel, null);
            k.e(tag, "tag");
            k.e(minLevel, "minLevel");
            this.record = new ArrayList();
        }

        private final String toLogMessage(Level level, String str, Object[] objArr, Throwable th) {
            if (objArr.length != 0) {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            }
            if (th != null) {
                String str2 = level + ' ' + str + ' ' + Log.getStackTraceString(th);
                if (str2 != null) {
                    return str2;
                }
            }
            return level + ' ' + str;
        }

        @VisibleForTesting
        public final void clearLogMessages() {
            this.record.clear();
        }

        @VisibleForTesting
        public final boolean hasLogMessage(String message) {
            k.e(message, "message");
            List<String> list = this.record;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (m.q0((String) it.next(), message, false)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @VisibleForTesting
        public final boolean hasLogMessageThat(l predicate) {
            k.e(predicate, "predicate");
            List<String> list = this.record;
            if (list != null && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.firebase.logger.Logger
        public int log(Level level, String format, Object[] args, Throwable th) {
            k.e(level, "level");
            k.e(format, "format");
            k.e(args, "args");
            String logMessage = toLogMessage(level, format, args, th);
            System.out.println((Object) a.l("Log: ", logMessage));
            this.record.add(logMessage);
            return logMessage.length();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Level {
        private static final /* synthetic */ y5.a $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        private final int priority;
        public static final Level VERBOSE = new Level("VERBOSE", 0, 2);
        public static final Level DEBUG = new Level("DEBUG", 1, 3);
        public static final Level INFO = new Level("INFO", 2, 4);
        public static final Level WARN = new Level("WARN", 3, 5);
        public static final Level ERROR = new Level("ERROR", 4, 6);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{VERBOSE, DEBUG, INFO, WARN, ERROR};
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = b.n(levelArr$values);
        }

        private Level(String str, int i2, int i8) {
            this.priority = i8;
        }

        public static y5.a getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        public final int getPriority$com_google_firebase_firebase_common() {
            return this.priority;
        }
    }

    public /* synthetic */ Logger(String str, boolean z2, Level level, f fVar) {
        this(str, z2, level);
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return logger.debug(str, objArr, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return logger.error(str, objArr, th);
    }

    public static final Logger getLogger(String str, boolean z2, Level level) {
        return Companion.getLogger(str, z2, level);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return logger.info(str, objArr, th);
    }

    private final int logIfAble(Level level, String str, Object[] objArr, Throwable th) {
        if (!this.enabled) {
            return 0;
        }
        if (this.minLevel.getPriority$com_google_firebase_firebase_common() <= level.getPriority$com_google_firebase_firebase_common() || Log.isLoggable(this.tag, level.getPriority$com_google_firebase_firebase_common())) {
            return log(level, str, objArr, th);
        }
        return 0;
    }

    public static /* synthetic */ int logIfAble$default(Logger logger, Level level, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logIfAble");
        }
        if ((i2 & 4) != 0) {
            objArr = new Object[0];
        }
        return logger.logIfAble(level, str, objArr, th);
    }

    @VisibleForTesting
    public static final FakeLogger setupFakeLogger(String str, boolean z2, Level level) {
        return Companion.setupFakeLogger(str, z2, level);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return logger.verbose(str, objArr, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return logger.warn(str, objArr, th);
    }

    public final int debug(String msg) {
        k.e(msg, "msg");
        return debug$default(this, msg, null, 2, null);
    }

    public final int error(String msg) {
        k.e(msg, "msg");
        return error$default(this, msg, null, 2, null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Level getMinLevel() {
        return this.minLevel;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int info(String msg) {
        k.e(msg, "msg");
        return info$default(this, msg, null, 2, null);
    }

    public abstract int log(Level level, String str, Object[] objArr, Throwable th);

    public final void setEnabled(boolean z2) {
        this.enabled = z2;
    }

    public final void setMinLevel(Level level) {
        k.e(level, "<set-?>");
        this.minLevel = level;
    }

    public final int verbose(String msg) {
        k.e(msg, "msg");
        return verbose$default(this, msg, null, 2, null);
    }

    public final int warn(String msg) {
        k.e(msg, "msg");
        return warn$default(this, msg, null, 2, null);
    }

    private Logger(String str, boolean z2, Level level) {
        this.tag = str;
        this.enabled = z2;
        this.minLevel = level;
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i2 & 2) != 0) {
            th = null;
        }
        return logger.debug(str, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i2 & 2) != 0) {
            th = null;
        }
        return logger.error(str, th);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i2 & 2) != 0) {
            th = null;
        }
        return logger.info(str, th);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i2 & 2) != 0) {
            th = null;
        }
        return logger.verbose(str, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i2 & 2) != 0) {
            th = null;
        }
        return logger.warn(str, th);
    }

    public final int debug(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        return debug$default(this, format, args, null, 4, null);
    }

    public final int error(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        return error$default(this, format, args, null, 4, null);
    }

    public final int info(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        return info$default(this, format, args, null, 4, null);
    }

    public final int verbose(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        return verbose$default(this, format, args, null, 4, null);
    }

    public final int warn(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        return warn$default(this, format, args, null, 4, null);
    }

    public final int debug(String format, Object[] args, Throwable th) {
        k.e(format, "format");
        k.e(args, "args");
        return logIfAble(Level.DEBUG, format, args, th);
    }

    public final int error(String format, Object[] args, Throwable th) {
        k.e(format, "format");
        k.e(args, "args");
        return logIfAble(Level.ERROR, format, args, th);
    }

    public final int info(String format, Object[] args, Throwable th) {
        k.e(format, "format");
        k.e(args, "args");
        return logIfAble(Level.INFO, format, args, th);
    }

    public final int verbose(String format, Object[] args, Throwable th) {
        k.e(format, "format");
        k.e(args, "args");
        return logIfAble(Level.VERBOSE, format, args, th);
    }

    public final int warn(String format, Object[] args, Throwable th) {
        k.e(format, "format");
        k.e(args, "args");
        return logIfAble(Level.WARN, format, args, th);
    }

    public final int debug(String msg, Throwable th) {
        k.e(msg, "msg");
        return logIfAble$default(this, Level.DEBUG, msg, null, th, 4, null);
    }

    public final int error(String msg, Throwable th) {
        k.e(msg, "msg");
        return logIfAble$default(this, Level.ERROR, msg, null, th, 4, null);
    }

    public final int info(String msg, Throwable th) {
        k.e(msg, "msg");
        return logIfAble$default(this, Level.INFO, msg, null, th, 4, null);
    }

    public final int verbose(String msg, Throwable th) {
        k.e(msg, "msg");
        return logIfAble$default(this, Level.VERBOSE, msg, null, th, 4, null);
    }

    public final int warn(String msg, Throwable th) {
        k.e(msg, "msg");
        return logIfAble$default(this, Level.WARN, msg, null, th, 4, null);
    }
}
