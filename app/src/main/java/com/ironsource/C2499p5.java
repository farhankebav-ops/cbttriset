package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Random;
import org.json.JSONException;

/* JADX INFO: renamed from: com.ironsource.p5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2499p5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9621d = 1;
    public static final int e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9622f = "C38FB23A402222A0C17D34A92F971D1F";
    public static final String g = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaUZaiASqhU4+s3JiQaIzVYtC+rZiPX2K+ZRg4C21kBZDNQM5+SEkp5GT5a9W/IR2oz6Q/ucifXcc7QEo5Xl5GX1BAhFI+8KaxPmn5Km5zFdH0aCvrrpDYQpH239Q+2uuUC79G5MpfSIw0zixU4VkF0WbVdHDpgQDds39cPl6cTwIDAQAB";
    public static final String h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9623i = 32;
    private static final C2499p5 j = new C2499p5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9624a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9625b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9626c = "";

    private String a(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    public static C2499p5 b() {
        return j;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f9624a)) {
            this.f9624a = f9622f;
        }
        return this.f9624a;
    }

    public synchronized String d() {
        try {
            if (TextUtils.isEmpty(this.f9625b)) {
                this.f9625b = a(h, 32);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9625b;
    }

    public String a() throws JSONException {
        if (TextUtils.isEmpty(this.f9626c)) {
            try {
                this.f9626c = C2252ba.a(d(), g);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                String str = "Session key encryption exception: " + e4.getLocalizedMessage();
                IronLog.INTERNAL.error(str);
                throw new JSONException(str);
            }
        }
        return this.f9626c;
    }
}
