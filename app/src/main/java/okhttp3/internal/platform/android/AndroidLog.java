package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import n6.m;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = OkHttpClient.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = x.n0(linkedHashMap);
    }

    private AndroidLog() {
    }

    public static /* synthetic */ void androidLog$okhttp$default(AndroidLog androidLog, String str, int i2, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i2, str2, th);
    }

    private final void enableLogging(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? m.S0(23, str) : str2;
    }

    public final void androidLog$okhttp(String loggerName, int i2, String message, Throwable th) {
        int iMin;
        k.e(loggerName, "loggerName");
        k.e(message, "message");
        String strLoggerTag = loggerTag(loggerName);
        if (Log.isLoggable(strLoggerTag, i2)) {
            if (th != null) {
                message = message + '\n' + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i8 = 0;
            while (i8 < length) {
                int iX0 = m.x0(message, '\n', i8, 4);
                if (iX0 == -1) {
                    iX0 = length;
                }
                while (true) {
                    iMin = Math.min(iX0, i8 + 4000);
                    String strSubstring = message.substring(i8, iMin);
                    k.d(strSubstring, "substring(...)");
                    Log.println(i2, strLoggerTag, strSubstring);
                    if (iMin >= iX0) {
                        break;
                    } else {
                        i8 = iMin;
                    }
                }
                i8 = iMin + 1;
            }
        }
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                enableLogging(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
