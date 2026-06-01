package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.n9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum EnumC2468n9 {
    NonBidder(1),
    Bidder(2),
    NotSupported(-1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9502b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9506a;

    /* JADX INFO: renamed from: com.ironsource.n9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final EnumC2468n9 a(int i2) {
            EnumC2468n9 enumC2468n9;
            EnumC2468n9[] enumC2468n9ArrValues = EnumC2468n9.values();
            int length = enumC2468n9ArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    enumC2468n9 = null;
                    break;
                }
                enumC2468n9 = enumC2468n9ArrValues[i8];
                if (enumC2468n9.f9506a == i2) {
                    break;
                }
                i8++;
            }
            return enumC2468n9 == null ? EnumC2468n9.NotSupported : enumC2468n9;
        }

        private a() {
        }
    }

    EnumC2468n9(int i2) {
        this.f9506a = i2;
    }

    public final int b() {
        return this.f9506a;
    }

    public final boolean b(EnumC2468n9 instanceType) {
        kotlin.jvm.internal.k.e(instanceType, "instanceType");
        return instanceType.b() == this.f9506a;
    }
}
