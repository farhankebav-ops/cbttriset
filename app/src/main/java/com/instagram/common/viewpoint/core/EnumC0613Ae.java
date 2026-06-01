package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A02' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EnumC0613Ae implements InterfaceC1799ip<Map.Entry<?, ?>, Object> {
    public static byte[] A00;
    public static final /* synthetic */ EnumC0613Ae[] A01;
    public static final EnumC0613Ae A02;
    public static final EnumC0613Ae A03;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-61, -67, -47, 4, -17, -6, 3, -13};
    }

    static {
        A02();
        final String strA01 = A01(0, 3, 56);
        final int i2 = 0;
        A02 = new EnumC0613Ae(strA01, i2) { // from class: com.facebook.ads.redexgen.X.1e
            {
                C0615Ag c0615Ag = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.InterfaceC1799ip
            @CheckForNull
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Object A43(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        };
        final String strA012 = A01(3, 5, 110);
        final int i8 = 1;
        A03 = new EnumC0613Ae(strA012, i8) { // from class: com.facebook.ads.redexgen.X.1d
            {
                C0615Ag c0615Ag = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.InterfaceC1799ip
            @CheckForNull
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Object A43(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };
        A01 = A03();
    }

    public EnumC0613Ae(String $enum$name, int $enum$ordinal) {
    }

    public /* synthetic */ EnumC0613Ae(String str, int i2, C0615Ag c0615Ag) {
        this(str, i2);
    }

    public static /* synthetic */ EnumC0613Ae[] A03() {
        return new EnumC0613Ae[]{A02, A03};
    }

    public static EnumC0613Ae valueOf(String name) {
        return (EnumC0613Ae) Enum.valueOf(EnumC0613Ae.class, name);
    }

    public static EnumC0613Ae[] values() {
        return (EnumC0613Ae[]) A01.clone();
    }
}
