package d7;

import f7.y;
import java.util.Iterator;
import java.util.NoSuchElementException;
import q5.q;
import q5.s;
import q5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class i implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11196c;

    public /* synthetic */ i(Object obj, int i2) {
        this.f11194a = i2;
        this.f11196c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f11194a) {
            case 0:
                if (this.f11195b > 0) {
                }
                break;
            case 1:
                if (this.f11195b < ((Object[]) this.f11196c).length) {
                }
                break;
            case 2:
                if (this.f11195b < ((byte[]) this.f11196c).length) {
                }
                break;
            case 3:
                if (this.f11195b < ((int[]) this.f11196c).length) {
                }
                break;
            case 4:
                if (this.f11195b < ((long[]) this.f11196c).length) {
                }
                break;
            case 5:
                if (this.f11195b < ((short[]) this.f11196c).length) {
                }
                break;
            default:
                if (this.f11195b < ((r5.e) this.f11196c).size()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f11194a) {
            case 0:
                y yVar = (y) this.f11196c;
                int i2 = yVar.f11443c;
                int i8 = this.f11195b;
                this.f11195b = i8 - 1;
                return yVar.e[i2 - i8];
            case 1:
                try {
                    Object[] objArr = (Object[]) this.f11196c;
                    int i9 = this.f11195b;
                    this.f11195b = i9 + 1;
                    return objArr[i9];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f11195b--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 2:
                int i10 = this.f11195b;
                byte[] bArr = (byte[]) this.f11196c;
                if (i10 >= bArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f11195b));
                }
                this.f11195b = i10 + 1;
                return new q5.o(bArr[i10]);
            case 3:
                int i11 = this.f11195b;
                int[] iArr = (int[]) this.f11196c;
                if (i11 >= iArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f11195b));
                }
                this.f11195b = i11 + 1;
                return new q(iArr[i11]);
            case 4:
                int i12 = this.f11195b;
                long[] jArr = (long[]) this.f11196c;
                if (i12 >= jArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f11195b));
                }
                this.f11195b = i12 + 1;
                return new s(jArr[i12]);
            case 5:
                int i13 = this.f11195b;
                short[] sArr = (short[]) this.f11196c;
                if (i13 >= sArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f11195b));
                }
                this.f11195b = i13 + 1;
                return new v(sArr[i13]);
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                r5.e eVar = (r5.e) this.f11196c;
                int i14 = this.f11195b;
                this.f11195b = i14 + 1;
                return eVar.get(i14);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f11194a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 5:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(Object[] array) {
        this.f11194a = 1;
        kotlin.jvm.internal.k.e(array, "array");
        this.f11196c = array;
    }

    public i(y yVar) {
        this.f11194a = 0;
        this.f11196c = yVar;
        this.f11195b = yVar.f11443c;
    }
}
