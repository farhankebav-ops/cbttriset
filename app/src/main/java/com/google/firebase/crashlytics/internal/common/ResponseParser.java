package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ResponseParser {
    public static final int ResponseActionDiscard = 0;
    public static final int ResponseActionRetry = 1;

    public static int parse(int i2) {
        if (i2 < 200 || i2 > 299) {
            return ((i2 < 300 || i2 > 399) && i2 >= 400 && i2 <= 499) ? 0 : 1;
        }
        return 0;
    }
}
