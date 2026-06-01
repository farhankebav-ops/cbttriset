package com.google.firebase.util;

import a1.a;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import k6.c;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import r5.n;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    public static final String nextAlphanumericString(d dVar, int i2) {
        k.e(dVar, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a.g(i2, "invalid length: ").toString());
        }
        k6.d dVarD0 = q.D0(0, i2);
        ArrayList arrayList = new ArrayList(n.L0(dVarD0, 10));
        Iterator it = dVarD0.iterator();
        while (((c) it).f12714c) {
            ((v) it).nextInt();
            arrayList.add(Character.valueOf(ALPHANUMERIC_ALPHABET.charAt(dVar.c(30))));
        }
        return l.c1(arrayList, "", null, null, null, 62);
    }

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }
}
