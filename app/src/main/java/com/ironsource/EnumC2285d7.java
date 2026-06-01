package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.d7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum EnumC2285d7 {
    SendEvent(0),
    NativeController(1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8205b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8208a;

    /* JADX INFO: renamed from: com.ironsource.d7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final EnumC2285d7 a(int i2) {
            EnumC2285d7 enumC2285d7;
            EnumC2285d7[] enumC2285d7ArrValues = EnumC2285d7.values();
            int length = enumC2285d7ArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    enumC2285d7 = null;
                    break;
                }
                enumC2285d7 = enumC2285d7ArrValues[i8];
                if (enumC2285d7.b() == i2) {
                    break;
                }
                i8++;
            }
            return enumC2285d7 == null ? EnumC2285d7.SendEvent : enumC2285d7;
        }

        private a() {
        }
    }

    EnumC2285d7(int i2) {
        this.f8208a = i2;
    }

    public final int b() {
        return this.f8208a;
    }
}
