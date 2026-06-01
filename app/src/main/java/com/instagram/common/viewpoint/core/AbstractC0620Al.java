package com.instagram.common.viewpoint.core;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Al, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC0620Al<E> extends AbstractC2016ma<E> implements Set<E> {
    public static byte[] A01 = null;
    public static String[] A02 = {"tpMJzZrhhsrMkwhOFEYR9GbFlaKVIskH", "YlBA8T7Fro2", "USXGP8OuBAzNSq5CbRyfQ0SKNWZdvns1", "IwkjEd2x85ogj6Hkpqc", "vhSxYEQIRpWfy1n6I2fIJfhoZxh6fLOY", "PMh9AUA5ndLdUxX8KVZJ5S1GU2oeFGKJ", "nfsou9g6KKUnvuudu0UQjvY", "janJ9NtfQ2imEKBo1ypA"};
    public static final long serialVersionUID = 912559;

    @CheckForNull
    @LazyInit
    public transient AbstractC0621Am<E> A00;

    public static String A0B(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A01 = new byte[]{-55, -25, -39, -108, -57, -39, -26, -35, -43, -32, -35, -18, -39, -40, -70, -29, -26, -31, -67, -55, -58, -58, -65, -67, -50, -61, -55, -56, 122, -50, -55, -55, 122, -58, -69, -52, -63, -65};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC2016ma
    public AbstractC0621Am<E> A0J() {
        AbstractC0621Am<E> abstractC0621Am = this.A00;
        if (abstractC0621Am != null) {
            return abstractC0621Am;
        }
        AbstractC0621Am<E> abstractC0621AmA0M = A0M();
        this.A00 = abstractC0621AmA0M;
        return abstractC0621AmA0M;
    }

    /* JADX INFO: renamed from: A0N */
    public abstract AbstractC2188pg<E> iterator();

    static {
        A0C();
    }

    public static int A03(int setSize) {
        int iMax = Math.max(setSize, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        AbstractC1819jA.A0E(iMax < 1073741824, A0B(18, 20, 20));
        return BasicMeasure.EXACTLY;
    }

    public static <E> AbstractC0620Al<E> A04(int n2, Object... elements) {
        Object[] objArrCopyOf = elements;
        switch (n2) {
            case 0:
                C1W c1wA09 = A09();
                if (A02[1].length() == 11) {
                    A02[6] = "xMSzqHeYX9fl0z6G3xaNHOB";
                    return c1wA09;
                }
                break;
            case 1:
                return A0A(Objects.requireNonNull(objArrCopyOf[0]));
            default:
                int iA03 = A03(n2);
                Object[] objArr = new Object[iA03];
                int i2 = iA03 - 1;
                int uniques = 0;
                int i8 = 0;
                for (int j = 0; j < n2; j++) {
                    Object objA00 = AbstractC2129oR.A00(objArrCopyOf[j], j);
                    int iHashCode = objA00.hashCode();
                    int tableSize = AbstractC2010mU.A00(iHashCode);
                    while (true) {
                        int i9 = tableSize & i2;
                        Object obj = objArr[i9];
                        if (obj == null) {
                            int index = i8 + 1;
                            int tableSize2 = A02[3].length();
                            if (tableSize2 != 32) {
                                String[] strArr = A02;
                                strArr[0] = "Zw143axrDatzvvuiLOoxXPNJBQDLOllI";
                                strArr[2] = "imRh362HWPXwfaqxgHfljoqeqcFI5Kex";
                                objArrCopyOf[i8] = objA00;
                                objArr[i9] = objA00;
                                uniques += iHashCode;
                                i8 = index;
                            }
                        } else {
                            if (obj.equals(objA00)) {
                            }
                            tableSize++;
                        }
                        break;
                    }
                }
                Arrays.fill(objArrCopyOf, i8, n2, (Object) null);
                if (i8 == 1) {
                    return new C1J(Objects.requireNonNull(objArrCopyOf[0]));
                }
                int tableSize3 = A03(i8);
                if (tableSize3 < iA03 / 2) {
                    return A04(i8, objArrCopyOf);
                }
                if (A0D(i8, objArrCopyOf.length)) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i8);
                }
                return new C1W(objArrCopyOf, uniques, objArr, i2, i8);
        }
        throw new RuntimeException();
    }

    public static <E> AbstractC0620Al<E> A05(E e12, E e22) {
        return A04(2, e12, e22);
    }

    public static <E> AbstractC0620Al<E> A06(E e12, E e22, E e32) {
        return A04(3, e12, e22, e32);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    public static <E> AbstractC0620Al<E> A07(Collection<? extends E> elements) {
        if ((elements instanceof AbstractC0620Al) && !(elements instanceof SortedSet)) {
            AbstractC0620Al<E> abstractC0620Al = (AbstractC0620Al) elements;
            if (!abstractC0620Al.A0K()) {
                return abstractC0620Al;
            }
        }
        Object[] array = elements.toArray();
        int length = array.length;
        if (A02[3].length() == 32) {
            throw new RuntimeException();
        }
        A02[4] = "vJyPhnBCGNruVJXdAMH0mrO2J76B9Swt";
        return A04(length, array);
    }

    public static <E> AbstractC0620Al<E> A08(E[] elements) {
        switch (elements.length) {
            case 0:
                return A09();
            case 1:
                C1J c1jA0A = A0A(elements[0]);
                if (A02[3].length() == 32) {
                    throw new RuntimeException();
                }
                A02[7] = "14gyZ0VPjhYiFYlwFK2N";
                return c1jA0A;
            default:
                return A04(elements.length, (Object[]) elements.clone());
        }
    }

    public static <E> AbstractC0620Al<E> A09() {
        return C1W.A05;
    }

    public static <E> AbstractC0620Al<E> A0A(E element) {
        return new C1J(element);
    }

    public static boolean A0D(int actualUnique, int expectedUnique) {
        return actualUnique < (expectedUnique >> 1) + (expectedUnique >> 2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    public AbstractC0621Am<E> A0M() {
        return AbstractC0621Am.A06(toArray());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    public boolean A0O() {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if ((object instanceof AbstractC0620Al) && A0O() && ((AbstractC0620Al) object).A0O() && hashCode() != object.hashCode()) {
            return false;
        }
        return AbstractC2157ou.A09(this, object);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return AbstractC2157ou.A00(this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Al != com.google.common.collect.ImmutableSet<E> */
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException(A0B(0, 18, 46));
    }
}
