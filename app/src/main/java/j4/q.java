package j4;

import com.ironsource.C2300e4;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f12371c = Logger.getLogger(i4.f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12372a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.e0 f12373b;

    public q(i4.e0 e0Var, long j, String str) {
        r2.q.D(str, "description");
        this.f12373b = e0Var;
        String strConcat = str.concat(" created");
        r2.q.D(strConcat, "description");
        b(new i4.a0(strConcat, i4.z.f11979a, j, null));
    }

    public static void a(i4.e0 e0Var, Level level, String str) {
        Logger logger = f12371c;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, C2300e4.i.f8403d + e0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public final void b(i4.a0 a0Var) {
        int iOrdinal = a0Var.f11814b.ordinal();
        Level level = iOrdinal != 2 ? iOrdinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.f12372a) {
        }
        a(this.f12373b, level, a0Var.f11813a);
    }
}
