package com.unity3d.ads.core.extensions;

import a1.a;
import com.unity3d.services.SDKErrorHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.k;
import m6.c;
import m6.d;
import m6.e;
import m6.h;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ExceptionExtensionsKt {
    public static final String getShortenedStackTrace(Throwable th, int i2) {
        k.e(th, "<this>");
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                PrintWriter printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    String string = stringWriter.toString();
                    k.d(string, "stringWriter.toString()");
                    String string2 = m.T0(string).toString();
                    k.e(string2, "<this>");
                    h mVar = new c6.m(string2, 3);
                    if (i2 < 0) {
                        throw new IllegalArgumentException(a.h(i2, "Requested element count ", " is less than zero.").toString());
                    }
                    String strI0 = m6.k.I0(i2 == 0 ? e.f12977a : mVar instanceof d ? ((d) mVar).b(i2) : new c(mVar, i2, 1), "\n");
                    printWriter.close();
                    stringWriter.close();
                    return strI0;
                } finally {
                }
            } finally {
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public static /* synthetic */ String getShortenedStackTrace$default(Throwable th, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = 15;
        }
        return getShortenedStackTrace(th, i2);
    }

    public static final String retrieveUnityCrashValue(Throwable th) {
        StackTraceElement stackTraceElement;
        String className;
        k.e(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        k.d(stackTrace, "this.stackTrace");
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i2];
            if ((stackTraceElement == null || (className = stackTraceElement.getClassName()) == null) ? false : m.q0(className, SDKErrorHandler.UNITY_PACKAGE, false)) {
                break;
            }
            i2++;
        }
        if (stackTraceElement != null) {
            String fileName = stackTraceElement.getFileName();
            if (fileName == null) {
                fileName = "unknown";
            }
            String str = fileName + '_' + stackTraceElement.getLineNumber();
            if (str != null) {
                return str;
            }
        }
        return "unknown";
    }
}
