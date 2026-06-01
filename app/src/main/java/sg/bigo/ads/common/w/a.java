package sg.bigo.ads.common.w;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import sg.bigo.ads.common.w.c;

/* JADX INFO: loaded from: classes6.dex */
@RequiresApi(api = 19)
final class a {
    private static final Comparator<C0301a> g = new Comparator<C0301a>() { // from class: sg.bigo.ads.common.w.a.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(C0301a c0301a, C0301a c0301a2) {
            return c0301a2.a() - c0301a.a();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f16194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int[] f16195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<c.C0303c> f16196c;
    final c.b[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f16198f = new float[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    final TimingLogger f16197d = null;

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.a$a, reason: collision with other inner class name */
    public class C0301a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16199a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f16201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f16202d;
        private int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16203f;
        private int g;
        private int h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f16204i;
        private int j;

        public C0301a(int i2, int i8) {
            this.f16201c = i2;
            this.f16199a = i8;
            c();
        }

        private int f() {
            return (this.f16199a + 1) - this.f16201c;
        }

        public final int a() {
            return ((this.j - this.f16204i) + 1) * ((this.h - this.g) + 1) * ((this.f16203f - this.e) + 1);
        }

        public final boolean b() {
            return f() > 1;
        }

        public final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f16194a;
            int[] iArr2 = aVar.f16195b;
            int i2 = Integer.MAX_VALUE;
            int i8 = Integer.MIN_VALUE;
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MIN_VALUE;
            int i11 = 0;
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MAX_VALUE;
            for (int i14 = this.f16201c; i14 <= this.f16199a; i14++) {
                int i15 = iArr[i14];
                i11 += iArr2[i15];
                int iA = a.a(i15);
                int iB = a.b(i15);
                int iC = a.c(i15);
                if (iA > i8) {
                    i8 = iA;
                }
                if (iA < i2) {
                    i2 = iA;
                }
                if (iB > i9) {
                    i9 = iB;
                }
                if (iB < i12) {
                    i12 = iB;
                }
                if (iC > i10) {
                    i10 = iC;
                }
                if (iC < i13) {
                    i13 = iC;
                }
            }
            this.e = i2;
            this.f16203f = i8;
            this.g = i12;
            this.h = i9;
            this.f16204i = i13;
            this.j = i10;
            this.f16202d = i11;
        }

        public final int d() {
            int i2 = this.f16203f - this.e;
            int i8 = this.h - this.g;
            int i9 = this.j - this.f16204i;
            int i10 = (i2 < i8 || i2 < i9) ? (i8 < i2 || i8 < i9) ? -1 : -2 : -3;
            a aVar = a.this;
            int[] iArr = aVar.f16194a;
            int[] iArr2 = aVar.f16195b;
            a.a(iArr, i10, this.f16201c, this.f16199a);
            Arrays.sort(iArr, this.f16201c, this.f16199a + 1);
            a.a(iArr, i10, this.f16201c, this.f16199a);
            int i11 = this.f16202d / 2;
            int i12 = this.f16201c;
            int i13 = 0;
            while (true) {
                int i14 = this.f16199a;
                if (i12 > i14) {
                    return this.f16201c;
                }
                i13 += iArr2[iArr[i12]];
                if (i13 >= i11) {
                    return Math.min(i14 - 1, i12);
                }
                i12++;
            }
        }

        public final c.C0303c e() {
            a aVar = a.this;
            int[] iArr = aVar.f16194a;
            int[] iArr2 = aVar.f16195b;
            int i2 = 0;
            int iA = 0;
            int iB = 0;
            int iC = 0;
            for (int i8 = this.f16201c; i8 <= this.f16199a; i8++) {
                int i9 = iArr[i8];
                int i10 = iArr2[i9];
                i2 += i10;
                iA += a.a(i9) * i10;
                iB += a.b(i9) * i10;
                iC += i10 * a.c(i9);
            }
            if (i2 == 0) {
                return new c.C0303c(a.a(0, 0, 0), i2);
            }
            float f4 = i2;
            return new c.C0303c(a.a(Math.round(iA / f4), Math.round(iB / f4), Math.round(iC / f4)), i2);
        }
    }

    public a(int[] iArr, int i2, c.b[] bVarArr) {
        this.e = bVarArr;
        int[] iArr2 = new int[32768];
        this.f16195b = iArr2;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            int iB = b(Color.blue(i9), 8, 5) | (b(Color.red(i9), 8, 5) << 10) | (b(Color.green(i9), 8, 5) << 5);
            iArr[i8] = iB;
            iArr2[iB] = iArr2[iB] + 1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < 32768; i11++) {
            if (iArr2[i11] > 0) {
                b.a(d(i11), this.f16198f);
                if (a(this.f16198f)) {
                    iArr2[i11] = 0;
                }
            }
            if (iArr2[i11] > 0) {
                i10++;
            }
        }
        int[] iArr3 = new int[i10];
        this.f16194a = iArr3;
        int i12 = 0;
        for (int i13 = 0; i13 < 32768; i13++) {
            if (iArr2[i13] > 0) {
                iArr3[i12] = i13;
                i12++;
            }
        }
        if (i10 > i2) {
            PriorityQueue priorityQueue = new PriorityQueue(i2, g);
            priorityQueue.offer(new C0301a(0, this.f16194a.length - 1));
            a(priorityQueue, i2);
            this.f16196c = a(priorityQueue);
            return;
        }
        this.f16196c = new ArrayList();
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = iArr3[i14];
            this.f16196c.add(new c.C0303c(d(i15), iArr2[i15]));
        }
    }

    public static int a(int i2) {
        return (i2 >> 10) & 31;
    }

    public static int b(int i2) {
        return (i2 >> 5) & 31;
    }

    public static int c(int i2) {
        return i2 & 31;
    }

    private static int d(int i2) {
        return a((i2 >> 10) & 31, (i2 >> 5) & 31, i2 & 31);
    }

    public static int a(int i2, int i8, int i9) {
        return Color.rgb(b(i2, 5, 8), b(i8, 5, 8), b(i9, 5, 8));
    }

    private static int b(int i2, int i8, int i9) {
        return (i9 > i8 ? i2 << (i9 - i8) : i2 >> (i8 - i9)) & ((1 << i9) - 1);
    }

    private List<c.C0303c> a(Collection<C0301a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<C0301a> it = collection.iterator();
        while (it.hasNext()) {
            c.C0303c c0303cE = it.next().e();
            if (!a(c0303cE.a())) {
                arrayList.add(c0303cE);
            }
        }
        return arrayList;
    }

    private static void a(PriorityQueue<C0301a> priorityQueue, int i2) {
        C0301a c0301aPoll;
        while (priorityQueue.size() < i2 && (c0301aPoll = priorityQueue.poll()) != null && c0301aPoll.b()) {
            if (!c0301aPoll.b()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int iD = c0301aPoll.d();
            C0301a c0301a = a.this.new C0301a(iD + 1, c0301aPoll.f16199a);
            c0301aPoll.f16199a = iD;
            c0301aPoll.c();
            priorityQueue.offer(c0301a);
            priorityQueue.offer(c0301aPoll);
        }
    }

    public static void a(int[] iArr, int i2, int i8, int i9) {
        if (i2 == -2) {
            while (i8 <= i9) {
                int i10 = iArr[i8];
                iArr[i8] = (i10 & 31) | (((i10 >> 5) & 31) << 10) | (((i10 >> 10) & 31) << 5);
                i8++;
            }
            return;
        }
        if (i2 != -1) {
            return;
        }
        while (i8 <= i9) {
            int i11 = iArr[i8];
            iArr[i8] = ((i11 >> 10) & 31) | ((i11 & 31) << 10) | (((i11 >> 5) & 31) << 5);
            i8++;
        }
    }

    private boolean a(float[] fArr) {
        c.b[] bVarArr = this.e;
        if (bVarArr != null && bVarArr.length > 0) {
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.e[i2].a(fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
