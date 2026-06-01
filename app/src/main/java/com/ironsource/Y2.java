package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Y2 extends Lb<Integer, Integer> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7809a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7810b = 3009;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f7811c = 3008;

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7812a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7813b = 3002;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f7814c = 3005;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7815d = 3300;
        public static final int e = 3503;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7816f = 3504;

        private b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements Y2 {
        @Override // com.ironsource.Lb
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }

        public Integer a(int i2) throws IllegalArgumentException {
            int i8;
            if (i2 == 206) {
                i8 = b.e;
            } else if (i2 == 207) {
                i8 = b.f7816f;
            } else if (i2 == 405) {
                i8 = 3009;
            } else if (i2 != 406) {
                switch (i2) {
                    case 101:
                        i8 = 83500;
                        break;
                    case 102:
                        i8 = 83510;
                        break;
                    case 103:
                        i8 = d.h;
                        break;
                    case 104:
                        i8 = 83300;
                        break;
                    default:
                        switch (i2) {
                            case 109:
                                i8 = 88002;
                                break;
                            case 110:
                                i8 = 83004;
                                break;
                            case 111:
                                break;
                            case 112:
                                i8 = 3305;
                                break;
                            default:
                                switch (i2) {
                                    case 201:
                                        i8 = 3002;
                                        break;
                                    case 202:
                                        i8 = 3005;
                                        break;
                                    case 203:
                                        i8 = 3300;
                                        break;
                                    default:
                                        throw new IllegalArgumentException(a1.a.g(i2, "Unknown event code: "));
                                }
                                break;
                        }
                    case 105:
                        i8 = 83302;
                        break;
                }
            } else {
                i8 = 3008;
            }
            return Integer.valueOf(i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7817a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7818b = 83500;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f7819c = 83510;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7820d = 83300;
        public static final int e = 83302;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7821f = 83004;
        public static final int g = 88002;
        public static final int h = 83301;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7822i = 83302;
        public static final int j = 3305;

        private d() {
        }
    }
}
