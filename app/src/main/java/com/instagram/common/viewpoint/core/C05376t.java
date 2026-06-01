package com.instagram.common.viewpoint.core;

import java.util.Random;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C05376t {
    public static String[] A04 = {"IlrXm3tezuWbVMaXPLi828ioISQJgCfS", "NAwIzBHR00ZPv9WHAooSWGmMQnQsAYk8", "eu5lMmt7ol9PqHL84pZymZquGRu6o", "m2SAqTjU3gSqVMchVgPXeZMw5JHzzeRQ", "AbCmeSj5KlQ54JssPMwwYJBwucQ6C", "RqAiTasO9D9HsUdBZKTQCzdghtQ9E0yV", "WIBemWRSgRuyaEIJ1sL2dCgMu2IibJ9f", "z026p7uIfXqhY1JlsQjMBKUP7isQ63Up"};
    public int A00;
    public int A01;
    public int A02;
    public final /* synthetic */ C05386u A03;

    public C05376t(C05386u c05386u, int i2, int i8, int i9) {
        this.A03 = c05386u;
        this.A00 = i2;
        this.A01 = i8;
        this.A02 = i9;
    }

    public final int A00() {
        Random random = new Random();
        if (random.nextInt(this.A02) == 0) {
            if (this.A01 <= 0) {
                return this.A00;
            }
            int iNextInt = random.nextInt() % this.A01;
            int i2 = this.A00;
            String[] strArr = A04;
            String str = strArr[4];
            String str2 = strArr[2];
            int variation = str.length();
            if (variation != str2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "t99WXaELTOA6CPYhlrJz9JZjCbRHN";
            strArr2[2] = "SwFbG7SpSQOHKIZQBIcFbwrWU2Enz";
            return i2 + iNextInt;
        }
        return 0;
    }
}
