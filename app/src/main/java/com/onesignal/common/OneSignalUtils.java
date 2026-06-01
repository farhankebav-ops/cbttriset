package com.onesignal.common;

import java.util.regex.Pattern;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalUtils {
    public static final OneSignalUtils INSTANCE = new OneSignalUtils();
    public static final String SDK_VERSION = "050137";

    private OneSignalUtils() {
    }

    public final boolean isValidEmail(String email) {
        k.e(email, "email");
        if (email.length() == 0) {
            return false;
        }
        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        k.d(patternCompile, "compile(emRegex)");
        return patternCompile.matcher(email).matches();
    }

    public final boolean isValidPhoneNumber(String number) {
        k.e(number, "number");
        if (number.length() == 0) {
            return false;
        }
        Pattern patternCompile = Pattern.compile("^\\+?[1-9]\\d{1,14}$");
        k.d(patternCompile, "compile(emRegex)");
        return patternCompile.matcher(number).matches();
    }
}
