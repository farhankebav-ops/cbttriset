package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i2, int i8, boolean z2, int i9) {
        if (i2 > 99 || (z2 && i9 >= 3)) {
            return i8 + 3;
        }
        if (i2 > 9 || (z2 && i9 >= 2)) {
            return i8 + 2;
        }
        if (z2 || i2 > 0) {
            return i8 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    private static int formatDurationLocked(long j, int i2) {
        char c7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j3 = j;
        if (sFormatStr.length < i2) {
            sFormatStr = new char[i2];
        }
        char[] cArr = sFormatStr;
        if (j3 == 0) {
            int i12 = i2 - 1;
            while (i12 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j3 > 0) {
            c7 = '+';
        } else {
            j3 = -j3;
            c7 = '-';
        }
        int i13 = (int) (j3 % 1000);
        int iFloor = (int) Math.floor(j3 / 1000);
        if (iFloor > SECONDS_PER_DAY) {
            i8 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i8;
        } else {
            i8 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i9 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i9 * SECONDS_PER_HOUR;
        } else {
            i9 = 0;
        }
        if (iFloor > 60) {
            int i14 = iFloor / 60;
            iFloor -= i14 * 60;
            i10 = i14;
        } else {
            i10 = 0;
        }
        if (i2 != 0) {
            int iAccumField = accumField(i8, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i9, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i10, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(iFloor, 1, iAccumField3 > 0, 2);
            i11 = 0;
            for (int iAccumField5 = accumField(i13, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i2; iAccumField5++) {
                cArr[i11] = ' ';
                i11++;
            }
        } else {
            i11 = 0;
        }
        cArr[i11] = c7;
        int i15 = i11 + 1;
        boolean z2 = i2 != 0;
        int iPrintField = printField(cArr, i8, 'd', i15, false, 0);
        int iPrintField2 = printField(cArr, i9, 'h', iPrintField, iPrintField != i15, z2 ? 2 : 0);
        int iPrintField3 = printField(cArr, i10, 'm', iPrintField2, iPrintField2 != i15, z2 ? 2 : 0);
        int iPrintField4 = printField(cArr, iFloor, 's', iPrintField3, iPrintField3 != i15, z2 ? 2 : 0);
        int iPrintField5 = printField(cArr, i13, 'm', iPrintField4, true, (!z2 || iPrintField4 == i15) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i2, char c7, int i8, boolean z2, int i9) {
        int i10;
        if (!z2 && i2 <= 0) {
            return i8;
        }
        if ((!z2 || i9 < 3) && i2 <= 99) {
            i10 = i8;
        } else {
            int i11 = i2 / 100;
            cArr[i8] = (char) (i11 + 48);
            i10 = i8 + 1;
            i2 -= i11 * 100;
        }
        if ((z2 && i9 >= 2) || i2 > 9 || i8 != i10) {
            int i12 = i2 / 10;
            cArr[i10] = (char) (i12 + 48);
            i10++;
            i2 -= i12 * 10;
        }
        cArr[i10] = (char) (i2 + 48);
        cArr[i10 + 1] = c7;
        return i10 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter, int i2) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i2)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j, long j3, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j3, printWriter, 0);
        }
    }
}
