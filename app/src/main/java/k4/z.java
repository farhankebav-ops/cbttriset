package k4;

import j4.f5;
import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class z {
    static {
        Logger.getLogger(z.class.getName());
    }

    public static byte[][] a(ArrayList arrayList) {
        int size = arrayList.size() * 2;
        byte[][] bArr = new byte[size][];
        int size2 = arrayList.size();
        int i2 = 0;
        int i8 = 0;
        while (i8 < size2) {
            Object obj = arrayList.get(i8);
            i8++;
            m4.b bVar = (m4.b) obj;
            int i9 = i2 + 1;
            bArr[i2] = bVar.f12934a.s();
            i2 += 2;
            bArr[i9] = bVar.f12935b.s();
        }
        byte[] bArr2 = f5.f12197b;
        int i10 = 0;
        while (i10 < size) {
            byte[] bArr3 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr4 = bArr[i11];
            if (f5.a(bArr3, bArr2)) {
                for (byte b8 : bArr4) {
                    if (b8 == 44) {
                        ArrayList arrayList2 = new ArrayList(size + 10);
                        for (int i12 = 0; i12 < i10; i12++) {
                            arrayList2.add(bArr[i12]);
                        }
                        while (i10 < size) {
                            byte[] bArr5 = bArr[i10];
                            byte[] bArr6 = bArr[i10 + 1];
                            if (f5.a(bArr5, bArr2)) {
                                int i13 = 0;
                                for (int i14 = 0; i14 <= bArr6.length; i14++) {
                                    if (i14 == bArr6.length || bArr6[i14] == 44) {
                                        byte[] bArrA = g2.e.f11586d.a(new String(bArr6, i13, i14 - i13, e2.d.f11227a));
                                        arrayList2.add(bArr5);
                                        arrayList2.add(bArrA);
                                        i13 = i14 + 1;
                                    }
                                }
                            } else {
                                arrayList2.add(bArr5);
                                arrayList2.add(bArr6);
                            }
                            i10 += 2;
                        }
                        return (byte[][]) arrayList2.toArray(new byte[0][]);
                    }
                }
                bArr[i11] = g2.e.f11586d.a(new String(bArr4, e2.d.f11227a));
            }
            i10 += 2;
        }
        return bArr;
    }
}
