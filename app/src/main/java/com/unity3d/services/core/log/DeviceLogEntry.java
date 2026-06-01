package com.unity3d.services.core.log;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class DeviceLogEntry {
    private DeviceLogLevel _logLevel;
    private String _originalMessage;
    private StackTraceElement _stackTraceElement;

    public DeviceLogEntry(DeviceLogLevel deviceLogLevel, String str, StackTraceElement stackTraceElement) {
        this._logLevel = deviceLogLevel;
        this._originalMessage = str;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        String className;
        String methodName;
        int lineNumber;
        String strConcat = this._originalMessage;
        StackTraceElement stackTraceElement = this._stackTraceElement;
        if (stackTraceElement != null) {
            className = stackTraceElement.getClassName();
            methodName = this._stackTraceElement.getMethodName();
            lineNumber = this._stackTraceElement.getLineNumber();
        } else {
            className = "UnknownClass";
            methodName = "unknownMethod";
            lineNumber = -1;
        }
        if (strConcat != null && !strConcat.isEmpty()) {
            strConcat = " :: ".concat(strConcat);
        }
        if (strConcat == null) {
            strConcat = "";
        }
        return className + "." + methodName + "()" + a.h(lineNumber, " (line:", ")") + strConcat;
    }
}
