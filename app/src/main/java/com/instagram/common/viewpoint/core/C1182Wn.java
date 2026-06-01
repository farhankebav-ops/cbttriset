package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1182Wn implements InvocationHandler {
    public static byte[] A03;
    public final /* synthetic */ int A00;
    public final /* synthetic */ SQ A01;
    public final /* synthetic */ LinkedBlockingQueue A02;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{40, 42, 33, 42, 61, 38, 44, 43, 41, 56, 31, 60, 32, 37, 56, 2, 45, 33, 41, 43, 41, 56, 24, 53, 60, 41, 73, 75, 90, 120, 79, 66, 91, 75, 29, 28, 49, 26, 23, 17, 25, 1, 7, 31, 1, 32, 23, 19, 22, 11};
    }

    public C1182Wn(int i2, LinkedBlockingQueue linkedBlockingQueue, SQ sq) {
        this.A00 = i2;
        this.A02 = linkedBlockingQueue;
        this.A01 = sq;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if (method.getName().equals(A00(34, 16, 70)) && objArr.length == 1 && (objArr[0] instanceof List)) {
                for (Object c7 : (List) objArr[0]) {
                    String str = (String) c7.getClass().getMethod(A00(7, 12, 120), new Class[0]).invoke(c7, new Object[0]);
                    int iIntValue = ((Integer) c7.getClass().getMethod(A00(19, 7, 120), new Class[0]).invoke(c7, new Object[0])).intValue();
                    if (str == null && iIntValue == this.A00) {
                        byte[] value = (byte[]) c7.getClass().getMethod(A00(26, 8, 26), new Class[0]).invoke(c7, new Object[0]);
                        this.A02.put(value);
                        return null;
                    }
                }
                this.A02.put(null);
            }
        } catch (Throwable t3) {
            this.A01.A08().AAy(A00(0, 7, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), AbstractC1090Sv.A1G, new C1091Sw(t3));
        }
        return null;
    }
}
