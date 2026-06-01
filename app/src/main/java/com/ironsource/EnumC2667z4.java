package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.z4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum EnumC2667z4 {
    IADS("iads"),
    UADS("uads"),
    SHARED("shared"),
    NONE("none");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10620b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10624a;

    /* JADX INFO: renamed from: com.ironsource.z4$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final EnumC2667z4 a(String str) {
            EnumC2667z4 enumC2667z4;
            EnumC2667z4[] enumC2667z4ArrValues = EnumC2667z4.values();
            int length = enumC2667z4ArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC2667z4 = null;
                    break;
                }
                enumC2667z4 = enumC2667z4ArrValues[i2];
                if (kotlin.jvm.internal.k.a(enumC2667z4.b(), str)) {
                    break;
                }
                i2++;
            }
            return enumC2667z4 == null ? EnumC2667z4.NONE : enumC2667z4;
        }

        private a() {
        }
    }

    EnumC2667z4(String str) {
        this.f10624a = str;
    }

    public final String b() {
        return this.f10624a;
    }

    public static final EnumC2667z4 a(String str) {
        return f10620b.a(str);
    }
}
