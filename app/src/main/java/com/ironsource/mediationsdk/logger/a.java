package com.ironsource.mediationsdk.logger;

import android.os.Looper;
import android.util.Log;
import com.ironsource.C2300e4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a extends IronSourceLogger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9223c = "console";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9224d = "LevelPlaySDK: ";

    private a() {
        super("console");
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        String strU = a1.a.u(new StringBuilder("UIThread: "), Looper.getMainLooper() == Looper.myLooper(), " ");
        StringBuilder sb = new StringBuilder("Activity: ");
        sb.append(ContextProvider.getInstance().getCurrentActiveActivity() != null ? Integer.valueOf(ContextProvider.getInstance().getCurrentActiveActivity().hashCode()) : Boolean.FALSE);
        sb.append(" ");
        String string = sb.toString();
        if (i2 == 0) {
            Log.v(f9224d + ironSourceTag, strU + string + str);
            return;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                Log.w(f9224d + ironSourceTag, str);
                return;
            } else if (i2 == 3) {
                Log.e(f9224d + ironSourceTag, str);
                return;
            } else if (i2 != 4) {
                return;
            }
        }
        Log.i(f9224d + ironSourceTag, str);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        StringBuilder sbX = a1.a.x(str, ":stacktrace[");
        sbX.append(Log.getStackTraceString(th));
        sbX.append(C2300e4.i.e);
        log(ironSourceTag, sbX.toString(), 3);
    }

    public a(int i2) {
        super("console", i2);
    }
}
