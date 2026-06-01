package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface G9 extends Lb<Integer, Integer> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6839a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6840b = 2201;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6841c = 2203;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6842d = 2005;
        public static final int e = 2210;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6843f = 2006;
        public static final int g = 2204;
        public static final int h = 2507;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6844i = 2211;
        public static final int j = 2212;

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6845a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6846b = 2002;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6847c = 2003;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6848d = 2200;
        public static final int e = 2503;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6849f = 2504;
        public static final int g = 2300;

        private b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements G9 {
        @Override // com.ironsource.Lb
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }

        public Integer a(int i2) throws IllegalArgumentException {
            int i8;
            if (i2 == 206) {
                i8 = b.e;
            } else if (i2 == 207) {
                i8 = b.f6849f;
            } else if (i2 == 401) {
                i8 = a.f6840b;
            } else if (i2 == 410) {
                i8 = a.f6844i;
            } else if (i2 != 411) {
                switch (i2) {
                    case 101:
                        i8 = d.f6851b;
                        break;
                    case 102:
                        i8 = d.f6852c;
                        break;
                    case 103:
                        i8 = d.h;
                        break;
                    case 104:
                        i8 = d.f6853d;
                        break;
                    case 105:
                        i8 = d.e;
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
                                i8 = d.f6855i;
                                break;
                            case 112:
                                i8 = d.j;
                                break;
                            default:
                                switch (i2) {
                                    case 201:
                                        i8 = 2002;
                                        break;
                                    case 202:
                                        i8 = 2003;
                                        break;
                                    case 203:
                                        i8 = b.f6848d;
                                        break;
                                    case 204:
                                        i8 = b.g;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 403:
                                                i8 = a.f6841c;
                                                break;
                                            case 404:
                                                i8 = 2005;
                                                break;
                                            case 405:
                                                i8 = a.e;
                                                break;
                                            case 406:
                                                i8 = 2006;
                                                break;
                                            case 407:
                                                i8 = a.g;
                                                break;
                                            case 408:
                                                i8 = a.h;
                                                break;
                                            default:
                                                throw new IllegalArgumentException(a1.a.g(i2, "Unknown event code: "));
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                i8 = a.j;
            }
            return Integer.valueOf(i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6850a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6851b = 82500;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6852c = 82510;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6853d = 82300;
        public static final int e = 82002;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6854f = 83004;
        public static final int g = 88002;
        public static final int h = 82301;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6855i = 82302;
        public static final int j = 82076;

        private d() {
        }
    }
}
