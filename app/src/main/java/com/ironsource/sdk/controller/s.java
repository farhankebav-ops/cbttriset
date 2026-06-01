package com.ironsource.sdk.controller;

import com.ironsource.C2531r4;
import com.ironsource.Jb;
import com.ironsource.mediationsdk.logger.IronLog;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10067b = "MD5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10068a;

    public s(String str) {
        this.f10068a = str;
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    private String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(f10067b);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    private String a(String str) {
        try {
            return Jb.a(str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return b(str);
        }
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArr) {
            String hexString = Integer.toHexString(b8 & 255);
            if (hexString.length() < 2) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public String b() {
        return this.f10068a;
    }

    public boolean a(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(a(str + str2 + this.f10068a));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }
}
