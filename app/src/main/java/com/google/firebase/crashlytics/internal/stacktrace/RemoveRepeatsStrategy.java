package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i2, int i8) {
        int i9 = i8 - i2;
        if (i8 + i9 > stackTraceElementArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!stackTraceElementArr[i2 + i10].equals(stackTraceElementArr[i8 + i10])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i2) {
        int i8;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        while (i9 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i9];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i9)) {
                stackTraceElementArr2[i10] = stackTraceElementArr[i9];
                i10++;
                i11 = 1;
                i8 = i9;
            } else {
                int iIntValue = i9 - num.intValue();
                if (i11 < i2) {
                    System.arraycopy(stackTraceElementArr, i9, stackTraceElementArr2, i10, iIntValue);
                    i10 += iIntValue;
                    i11++;
                }
                i8 = (iIntValue - 1) + i9;
            }
            map.put(stackTraceElement, Integer.valueOf(i9));
            i9 = i8 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i10];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i10);
        return stackTraceElementArr3;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrTrimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return stackTraceElementArrTrimRepeats.length < stackTraceElementArr.length ? stackTraceElementArrTrimRepeats : stackTraceElementArr;
    }

    public RemoveRepeatsStrategy(int i2) {
        this.maxRepetitions = i2;
    }
}
