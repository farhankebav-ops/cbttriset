package com.ironsource.adqualitysdk.sdk.i;

import android.util.Pair;
import android.widget.LinearLayout;
import android.widget.Space;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.ironsource.sdk.utils.Logger;
import com.onesignal.common.services.ServiceBuilder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import l7.g0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class a0 {
    public static FieldDescriptor a(int i2, FieldDescriptor.Builder builder) {
        return builder.withProperty(AtProtobuf.builder().tag(i2).build()).build();
    }

    public static String b(String str, Number number) {
        return number.getClass().getName().concat(str);
    }

    public static String c(StringBuilder sb, int i2, char c7) {
        sb.append(i2);
        sb.append(c7);
        return sb.toString();
    }

    public static String d(StringBuilder sb, String str, String str2) {
        sb.append(str.intern());
        sb.append(str2);
        return sb.toString();
    }

    public static String e(g0 g0Var, String str) {
        return str + g0Var;
    }

    public static void f(int i2, int i8, float f4, sg.bigo.ads.ad.interstitial.e.b.a aVar, Space space) {
        aVar.addView(space, new LinearLayout.LayoutParams(i2, i8, f4));
    }

    public static void g(int i2, int i8, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sg.bigo.ads.common.t.a.a(i2, i8, str2, sb.toString());
    }

    public static /* synthetic */ void h(int i2, String str) {
        if (i2 == 0) {
            throw new NullPointerException(str);
        }
    }

    public static void i(int i2, String str, String str2, int i8, String str3) {
        sg.bigo.ads.common.t.a.a(i2, i8, str3, str2.concat(String.valueOf(str)));
    }

    public static void j(int i2, HashMap map, String str, int i8, String str2) {
        map.put(str, Integer.valueOf(i2));
        map.put(str2, Integer.valueOf(i8));
    }

    public static void k(ServiceBuilder serviceBuilder, Class cls, Class cls2, Class cls3, Class cls4) {
        serviceBuilder.register(cls).provides(cls2);
        serviceBuilder.register(cls3).provides(cls4);
    }

    public static /* synthetic */ void l(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void m(String str, String str2, String str3, String str4) {
        Logger.i(str4, str + str2 + str3);
    }

    public static void n(String str, String str2, ArrayList arrayList) {
        arrayList.add(new Pair(str, str2));
    }

    public static void o(String str, String str2, char[] cArr, int i2, int i8) {
        ByteBuffer.wrap(str.getBytes(str2)).asCharBuffer().get(cArr, i2, i8);
    }

    public static /* synthetic */ boolean p(Object obj) {
        return obj != null;
    }

    public static /* synthetic */ String q(int i2) {
        return i2 != 1 ? i2 != 2 ? "null" : "PLAINTEXT" : "TLS";
    }

    public static /* synthetic */ String r(int i2) {
        return i2 != 1 ? i2 != 2 ? "null" : "OUTBOUND" : "INBOUND";
    }
}
