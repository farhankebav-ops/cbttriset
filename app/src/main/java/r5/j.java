package r5;

import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class j extends n7.b {
    public static List X(Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.k.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static boolean Y(Object[] objArr, Object obj) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        return q0(objArr, obj) >= 0;
    }

    public static boolean Z(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                Object obj2 = objArr2[i2];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!Z((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof q5.p) && (obj2 instanceof q5.p)) {
                            if (!Arrays.equals(((q5.p) obj).f13512a, ((q5.p) obj2).f13512a)) {
                            }
                        } else if ((obj instanceof q5.w) && (obj2 instanceof q5.w)) {
                            if (!Arrays.equals(((q5.w) obj).f13519a, ((q5.w) obj2).f13519a)) {
                            }
                        } else if ((obj instanceof q5.r) && (obj2 instanceof q5.r)) {
                            if (!Arrays.equals(((q5.r) obj).f13514a, ((q5.r) obj2).f13514a)) {
                            }
                        } else if ((obj instanceof q5.t) && (obj2 instanceof q5.t)) {
                            if (!Arrays.equals(((q5.t) obj).f13516a, ((q5.t) obj2).f13516a)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final void a0(Object[] objArr, StringBuilder sb, ArrayList arrayList) {
        if (arrayList.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        arrayList.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Object[]) {
                a0((Object[]) obj, sb, arrayList);
            } else if (obj instanceof byte[]) {
                String string = Arrays.toString((byte[]) obj);
                kotlin.jvm.internal.k.d(string, "toString(...)");
                sb.append(string);
            } else if (obj instanceof short[]) {
                String string2 = Arrays.toString((short[]) obj);
                kotlin.jvm.internal.k.d(string2, "toString(...)");
                sb.append(string2);
            } else if (obj instanceof int[]) {
                String string3 = Arrays.toString((int[]) obj);
                kotlin.jvm.internal.k.d(string3, "toString(...)");
                sb.append(string3);
            } else if (obj instanceof long[]) {
                String string4 = Arrays.toString((long[]) obj);
                kotlin.jvm.internal.k.d(string4, "toString(...)");
                sb.append(string4);
            } else if (obj instanceof float[]) {
                String string5 = Arrays.toString((float[]) obj);
                kotlin.jvm.internal.k.d(string5, "toString(...)");
                sb.append(string5);
            } else if (obj instanceof double[]) {
                String string6 = Arrays.toString((double[]) obj);
                kotlin.jvm.internal.k.d(string6, "toString(...)");
                sb.append(string6);
            } else if (obj instanceof char[]) {
                String string7 = Arrays.toString((char[]) obj);
                kotlin.jvm.internal.k.d(string7, "toString(...)");
                sb.append(string7);
            } else if (obj instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) obj);
                kotlin.jvm.internal.k.d(string8, "toString(...)");
                sb.append(string8);
            } else if (obj instanceof q5.p) {
                String strC1 = l.c1(new q5.p(((q5.p) obj).f13512a), ", ", C2300e4.i.f8403d, C2300e4.i.e, null, 56);
                sb.append(strC1 != null ? strC1 : "null");
            } else if (obj instanceof q5.w) {
                String strC12 = l.c1(new q5.w(((q5.w) obj).f13519a), ", ", C2300e4.i.f8403d, C2300e4.i.e, null, 56);
                sb.append(strC12 != null ? strC12 : "null");
            } else if (obj instanceof q5.r) {
                String strC13 = l.c1(new q5.r(((q5.r) obj).f13514a), ", ", C2300e4.i.f8403d, C2300e4.i.e, null, 56);
                sb.append(strC13 != null ? strC13 : "null");
            } else if (obj instanceof q5.t) {
                String strC14 = l.c1(new q5.t(((q5.t) obj).f13516a), ", ", C2300e4.i.f8403d, C2300e4.i.e, null, 56);
                sb.append(strC14 != null ? strC14 : "null");
            } else {
                sb.append(obj.toString());
            }
        }
        sb.append(']');
        arrayList.remove(m.G0(arrayList));
    }

    public static void b0(int i2, int i8, int i9, byte[] bArr, byte[] destination) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(bArr, i8, destination, i2, i9 - i8);
    }

    public static void c0(int i2, int i8, int i9, int[] iArr, int[] destination) {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(iArr, i8, destination, i2, i9 - i8);
    }

    public static void d0(float[] fArr, int i2, float[] destination, int i8, int i9) {
        kotlin.jvm.internal.k.e(fArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(fArr, i8, destination, i2, i9 - i8);
    }

    public static void e0(long[] jArr, long[] destination, int i2, int i8, int i9) {
        kotlin.jvm.internal.k.e(jArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(jArr, i8, destination, i2, i9 - i8);
    }

    public static void f0(Object[] objArr, int i2, Object[] destination, int i8, int i9) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(objArr, i8, destination, i2, i9 - i8);
    }

    public static /* synthetic */ void g0(int i2, int i8, int i9, int[] iArr, int[] iArr2) {
        if ((i9 & 2) != 0) {
            i2 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = iArr.length;
        }
        c0(i2, 0, i8, iArr, iArr2);
    }

    public static /* synthetic */ void h0(Object[] objArr, Object[] objArr2, int i2, int i8, int i9, int i10) {
        if ((i10 & 2) != 0) {
            i2 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = objArr.length;
        }
        f0(objArr, i2, objArr2, i8, i9);
    }

    public static byte[] i0(byte[] bArr, int i2, int i8) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        n7.b.k(i8, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i8);
        kotlin.jvm.internal.k.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] j0(int i2, int i8, Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        n7.b.k(i8, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i2, i8);
        kotlin.jvm.internal.k.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void k0(Object obj, Object[] objArr, int i2, int i8) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i8, obj);
    }

    public static void l0(long[] jArr) {
        int length = jArr.length;
        kotlin.jvm.internal.k.e(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static ArrayList n0(Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object o0(Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object p0(int i2, Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        if (i2 < 0 || i2 >= objArr.length) {
            return null;
        }
        return objArr[i2];
    }

    public static int q0(Object[] objArr, Object obj) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        int i2 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i2 < length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i2 < length2) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static String r0(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ", ");
            }
            a.a.i(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static List s0(Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? t0(objArr) : r2.q.j0(objArr[0]) : r.f13638a;
    }

    public static ArrayList t0(Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        return new ArrayList(new h(objArr, false));
    }
}
