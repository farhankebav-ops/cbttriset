package com.google.gson.internal;

import androidx.work.WorkRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class NumberLimits {
    private static final int MAX_NUMBER_STRING_LENGTH = 10000;

    private NumberLimits() {
    }

    private static void checkNumberStringLength(String str) {
        if (str.length() <= 10000) {
            return;
        }
        throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        checkNumberStringLength(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < WorkRequest.MIN_BACKOFF_MILLIS) {
            return bigDecimal;
        }
        throw new NumberFormatException(a1.a.l("Number has unsupported scale: ", str));
    }

    public static BigInteger parseBigInteger(String str) throws NumberFormatException {
        checkNumberStringLength(str);
        return new BigInteger(str);
    }
}
