package com.ironsource.mediationsdk.adquality;

import com.ironsource.C2341g9;
import com.ironsource.EnumC2558se;
import com.ironsource.Q6;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8995a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static EnumC0190a f8996b = EnumC0190a.DONT_INITIALIZE;

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.adquality.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum EnumC0190a {
        DONT_INITIALIZE(0),
        LEVELPLAY_ONLY(1),
        ALL_MEDIATIONS(2),
        OTHER_ONLY(3);


        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0191a f8997b = new C0191a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9001a;

        /* JADX INFO: renamed from: com.ironsource.mediationsdk.adquality.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0191a {
            public /* synthetic */ C0191a(f fVar) {
                this();
            }

            public final EnumC0190a a(int i2) {
                EnumC0190a enumC0190a;
                EnumC0190a[] enumC0190aArrValues = EnumC0190a.values();
                int length = enumC0190aArrValues.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        enumC0190a = null;
                        break;
                    }
                    enumC0190a = enumC0190aArrValues[i8];
                    if (enumC0190a.b() == i2) {
                        break;
                    }
                    i8++;
                }
                return enumC0190a == null ? EnumC0190a.DONT_INITIALIZE : enumC0190a;
            }

            private C0191a() {
            }
        }

        EnumC0190a(int i2) {
            this.f9001a = i2;
        }

        public final int b() {
            return this.f9001a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {
        public /* synthetic */ b(f fVar) {
            this();
        }

        public final EnumC0190a a() {
            return a.f8996b;
        }

        private b() {
        }

        public final void a(EnumC0190a enumC0190a) {
            k.e(enumC0190a, "<set-?>");
            a.f8996b = enumC0190a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9002a;

        static {
            int[] iArr = new int[EnumC0190a.values().length];
            try {
                iArr[EnumC0190a.LEVELPLAY_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0190a.ALL_MEDIATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0190a.OTHER_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9002a = iArr;
        }
    }

    public final boolean b() throws JSONException {
        EnumC2558se enumC2558se;
        JSONArray jSONArrayOptJSONArray = new C2341g9().a().optJSONArray(Q6.g0);
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i8 = jSONArrayOptJSONArray.getInt(i2);
            EnumC2558se[] enumC2558seArrValues = EnumC2558se.values();
            int length2 = enumC2558seArrValues.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length2) {
                    enumC2558se = null;
                    break;
                }
                enumC2558se = enumC2558seArrValues[i9];
                if (enumC2558se.b() == i8) {
                    break;
                }
                i9++;
            }
            if (enumC2558se != null) {
                linkedHashSet.add(enumC2558se);
            }
        }
        int i10 = c.f9002a[f8996b.ordinal()];
        if (i10 == 1) {
            return linkedHashSet.contains(EnumC2558se.LEVEL_PLAY_INIT);
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return linkedHashSet.contains(EnumC2558se.EXTERNAL_MEDIATION_INIT);
            }
        } else if (linkedHashSet.contains(EnumC2558se.LEVEL_PLAY_INIT) || linkedHashSet.contains(EnumC2558se.EXTERNAL_MEDIATION_INIT)) {
            return true;
        }
        return false;
    }

    public final void a(int i2) {
        f8996b = EnumC0190a.f8997b.a(i2);
    }
}
