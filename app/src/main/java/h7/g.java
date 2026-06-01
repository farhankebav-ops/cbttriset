package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.a f11758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11759b = true;

    public g(com.unity3d.scar.adapter.common.a aVar) {
        this.f11758a = aVar;
    }

    public void a() {
        this.f11759b = false;
    }

    public void b(byte b8) {
        this.f11758a.j(String.valueOf(b8));
    }

    public final void c(char c7) {
        com.unity3d.scar.adapter.common.a aVar = this.f11758a;
        aVar.b(aVar.f10958b, 1);
        char[] cArr = (char[]) aVar.f10959c;
        int i2 = aVar.f10958b;
        aVar.f10958b = i2 + 1;
        cArr[i2] = c7;
    }

    public void d(int i2) {
        this.f11758a.j(String.valueOf(i2));
    }

    public void e(long j) {
        this.f11758a.j(String.valueOf(j));
    }

    public final void f(String v2) {
        kotlin.jvm.internal.k.e(v2, "v");
        this.f11758a.j(v2);
    }

    public void g(short s7) {
        this.f11758a.j(String.valueOf(s7));
    }

    public void h(String value) {
        byte b8;
        kotlin.jvm.internal.k.e(value, "value");
        int length = value.length() + 2;
        com.unity3d.scar.adapter.common.a aVar = this.f11758a;
        aVar.b(aVar.f10958b, length);
        char[] cArr = (char[]) aVar.f10959c;
        int i2 = aVar.f10958b;
        int i8 = i2 + 1;
        cArr[i2] = '\"';
        int length2 = value.length();
        value.getChars(0, length2, cArr, i8);
        int i9 = length2 + i8;
        int i10 = i8;
        while (i10 < i9) {
            char c7 = cArr[i10];
            byte[] bArr = c0.f11747b;
            if (c7 < bArr.length && bArr[c7] != 0) {
                int length3 = value.length();
                for (int i11 = i10 - i8; i11 < length3; i11++) {
                    aVar.b(i10, 2);
                    char cCharAt = value.charAt(i11);
                    byte[] bArr2 = c0.f11747b;
                    if (cCharAt >= bArr2.length || (b8 = bArr2[cCharAt]) == 0) {
                        int i12 = i10 + 1;
                        ((char[]) aVar.f10959c)[i10] = cCharAt;
                        i10 = i12;
                    } else {
                        if (b8 == 1) {
                            String str = c0.f11746a[cCharAt];
                            kotlin.jvm.internal.k.b(str);
                            aVar.b(i10, str.length());
                            str.getChars(0, str.length(), (char[]) aVar.f10959c, i10);
                            int length4 = str.length() + i10;
                            aVar.f10958b = length4;
                            i10 = length4;
                        } else {
                            char[] cArr2 = (char[]) aVar.f10959c;
                            cArr2[i10] = '\\';
                            cArr2[i10 + 1] = (char) b8;
                            i10 += 2;
                            aVar.f10958b = i10;
                        }
                    }
                }
                aVar.b(i10, 1);
                ((char[]) aVar.f10959c)[i10] = '\"';
                aVar.f10958b = i10 + 1;
                return;
            }
            i10++;
        }
        cArr[i9] = '\"';
        aVar.f10958b = i9 + 1;
    }

    public void i() {
    }

    public void j() {
    }
}
