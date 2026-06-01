package l4;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12792d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12793f;
    public char[] g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f12789a = name;
        this.f12790b = name.length();
    }

    public final int a(int i2) {
        int i8;
        int i9;
        int i10 = i2 + 1;
        int i11 = this.f12790b;
        String str = this.f12789a;
        if (i10 >= i11) {
            throw new IllegalStateException("Malformed DN: " + str);
        }
        char[] cArr = this.g;
        char c7 = cArr[i2];
        if (c7 >= '0' && c7 <= '9') {
            i8 = c7 - '0';
        } else if (c7 >= 'a' && c7 <= 'f') {
            i8 = c7 - 'W';
        } else {
            if (c7 < 'A' || c7 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i8 = c7 - '7';
        }
        char c8 = cArr[i10];
        if (c8 >= '0' && c8 <= '9') {
            i9 = c8 - '0';
        } else if (c8 >= 'a' && c8 <= 'f') {
            i9 = c8 - 'W';
        } else {
            if (c8 < 'A' || c8 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i9 = c8 - '7';
        }
        return (i8 << 4) + i9;
    }

    public final char b() {
        int i2;
        int i8;
        int i9 = this.f12791c + 1;
        this.f12791c = i9;
        int i10 = this.f12790b;
        if (i9 == i10) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f12789a);
        }
        char c7 = this.g[i9];
        if (c7 != ' ' && c7 != '%' && c7 != '\\' && c7 != '_' && c7 != '\"' && c7 != '#') {
            switch (c7) {
                default:
                    switch (c7) {
                        case AD_START_TO_BACKGROUND_DURATION_MS_VALUE:
                        case '<':
                        case APP_BACKGROUND_DURING_AD_LOAD_VALUE:
                        case '>':
                            break;
                        default:
                            int iA = a(i9);
                            this.f12791c++;
                            if (iA < 128) {
                                return (char) iA;
                            }
                            if (iA < 192 || iA > 247) {
                                return '?';
                            }
                            if (iA <= 223) {
                                i2 = iA & 31;
                                i8 = 1;
                            } else if (iA <= 239) {
                                i2 = iA & 15;
                                i8 = 2;
                            } else {
                                i2 = iA & 7;
                                i8 = 3;
                            }
                            for (int i11 = 0; i11 < i8; i11++) {
                                int i12 = this.f12791c;
                                int i13 = i12 + 1;
                                this.f12791c = i13;
                                if (i13 == i10 || this.g[i13] != '\\') {
                                    return '?';
                                }
                                int i14 = i12 + 2;
                                this.f12791c = i14;
                                int iA2 = a(i14);
                                this.f12791c++;
                                if ((iA2 & 192) != 128) {
                                    return '?';
                                }
                                i2 = (i2 << 6) + (iA2 & 63);
                            }
                            return (char) i2;
                    }
                case '*':
                case '+':
                case ',':
                    return c7;
            }
        }
        return c7;
    }

    public final String c() {
        int i2;
        int i8;
        int i9;
        char c7;
        int i10;
        char c8;
        char c9;
        while (true) {
            i2 = this.f12791c;
            i8 = this.f12790b;
            if (i2 >= i8 || this.g[i2] != ' ') {
                break;
            }
            this.f12791c = i2 + 1;
        }
        if (i2 == i8) {
            return null;
        }
        this.f12792d = i2;
        this.f12791c = i2 + 1;
        while (true) {
            i9 = this.f12791c;
            if (i9 >= i8 || (c9 = this.g[i9]) == '=' || c9 == ' ') {
                break;
            }
            this.f12791c = i9 + 1;
        }
        String str = this.f12789a;
        if (i9 >= i8) {
            throw new IllegalStateException("Unexpected end of DN: " + str);
        }
        this.e = i9;
        if (this.g[i9] == ' ') {
            while (true) {
                i10 = this.f12791c;
                if (i10 >= i8 || (c8 = this.g[i10]) == '=' || c8 != ' ') {
                    break;
                }
                this.f12791c = i10 + 1;
            }
            if (this.g[i10] != '=' || i10 == i8) {
                throw new IllegalStateException("Unexpected end of DN: " + str);
            }
        }
        this.f12791c++;
        while (true) {
            int i11 = this.f12791c;
            if (i11 >= i8 || this.g[i11] != ' ') {
                break;
            }
            this.f12791c = i11 + 1;
        }
        int i12 = this.e;
        int i13 = this.f12792d;
        if (i12 - i13 > 4) {
            char[] cArr = this.g;
            if (cArr[i13 + 3] == '.' && (((c7 = cArr[i13]) == 'O' || c7 == 'o') && ((cArr[i13 + 1] == 'I' || cArr[i13 + 1] == 'i') && (cArr[i13 + 2] == 'D' || cArr[i13 + 2] == 'd')))) {
                this.f12792d = i13 + 4;
            }
        }
        char[] cArr2 = this.g;
        int i14 = this.f12792d;
        return new String(cArr2, i14, i12 - i14);
    }
}
