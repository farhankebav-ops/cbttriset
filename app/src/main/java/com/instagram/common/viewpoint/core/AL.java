package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public final class AL<K, V> extends AbstractC2025mj<K, V> {
    public static String[] A03 = {"BLd", "8EKeVjTJIU6MDNPM6ZTo", "HWbOsw9VtzWta1ewMSd8SFleZB3uycJV", "4g", "oHZcZe8PYtJP7zuLK1jInYJjmOVWCxEe", "hqSXyAZ2zuGNDHd4PkKakj6NBzhfvhom", "1gwnz8jAk7EqAxYvZHDnpar6edM6d04", "wfrdBhaNwCqY"};
    public static final AbstractC2025mj<Object, Object> A04 = new AL(null, new Object[0], 0);
    public static final long serialVersionUID = 0;
    public final transient Object[] A00;
    public final transient int A01;

    @CheckForNull
    public final transient Object A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static <K, V> AL<K, V> A00(int n2, Object[] alternatingKeysAndValues, C2023mh<K, V> builder) {
        Object obj;
        if (n2 == 0) {
            return (AL) A04;
        }
        if (n2 == 1) {
            AbstractC1966ll.A03(Objects.requireNonNull(alternatingKeysAndValues[0]), Objects.requireNonNull(alternatingKeysAndValues[1]));
            return new AL<>(null, alternatingKeysAndValues, 1);
        }
        AbstractC1819jA.A01(n2, alternatingKeysAndValues.length >> 1);
        Object objA02 = A02(alternatingKeysAndValues, n2, AbstractC0620Al.A03(n2), 0);
        if (objA02 instanceof Object[]) {
            Object[] objArr = (Object[]) objA02;
            C2022mg c2022mg = (C2022mg) objArr[2];
            if (builder == null) {
                throw c2022mg.A02();
            }
            builder.A01 = c2022mg;
            obj = objArr[0];
            n2 = ((Integer) objArr[1]).intValue();
            alternatingKeysAndValues = Arrays.copyOf(alternatingKeysAndValues, n2 * 2);
        } else {
            obj = objA02;
        }
        return new AL<>(obj, alternatingKeysAndValues, n2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    public AL(@CheckForNull Object hashTable, Object[] alternatingKeysAndValues, int size) {
        this.A02 = hashTable;
        this.A00 = alternatingKeysAndValues;
        this.A01 = size;
    }

    @CheckForNull
    public static Object A01(@CheckForNull Object hashTableObject, @CheckForNull Object[] alternatingKeysAndValues, int size, int keyOffset, Object key) {
        int keyIndex;
        if (key == null) {
            return null;
        }
        if (size == 1) {
            if (!Objects.requireNonNull(alternatingKeysAndValues[keyOffset]).equals(key)) {
                return null;
            }
            Object obj = alternatingKeysAndValues[keyOffset ^ 1];
            if (A03[3].length() == 2) {
                String[] strArr = A03;
                strArr[4] = "QVSrtcZKARogVSSTsDMErisHHhx3s08I";
                strArr[2] = "AM5zanCyyloF9oZfJSoNtkvSUtakyhf1";
                return Objects.requireNonNull(obj);
            }
        } else {
            if (hashTableObject == null) {
                return null;
            }
            if (hashTableObject instanceof byte[]) {
                String[] strArr2 = A03;
                if (strArr2[4].charAt(30) != strArr2[2].charAt(30)) {
                    String[] strArr3 = A03;
                    strArr3[0] = "33E";
                    strArr3[7] = "0IVWz8DDpNA7";
                    byte[] bArr = (byte[]) hashTableObject;
                    int mask = bArr.length - 1;
                    int iA00 = AbstractC2010mU.A00(key.hashCode());
                    while (true) {
                        int i2 = iA00 & mask;
                        int i8 = bArr[i2];
                        String[] strArr4 = A03;
                        if (strArr4[0].length() == strArr4[7].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr5 = A03;
                        strArr5[4] = "Av4xGd01JYXCpVUXSFBX5Q3qG21nzo21";
                        strArr5[2] = "UuPO1t2w2j7pNt6wRWMrea5HC47YMJTH";
                        keyIndex = i8 & 255;
                        if (keyIndex == 255) {
                            return null;
                        }
                        boolean zEquals = key.equals(alternatingKeysAndValues[keyIndex]);
                        String[] strArr6 = A03;
                        if (strArr6[0].length() != strArr6[7].length()) {
                            A03[6] = "uEfKnUldtWRHisqrfIDf4ni9PGEoRP0";
                            if (zEquals) {
                                break;
                            }
                            iA00 = i2 + 1;
                        } else {
                            A03[1] = "rg32th7lbb1pJpYlIRnh";
                            if (zEquals) {
                                break;
                            }
                            iA00 = i2 + 1;
                        }
                    }
                    Object obj2 = alternatingKeysAndValues[keyIndex ^ 1];
                    if (A03[1].length() != 20) {
                        return obj2;
                    }
                    A03[1] = "OPXdJDLfRI5AGRwdD0N1";
                    return obj2;
                }
            } else if (hashTableObject instanceof short[]) {
                short[] sArr = (short[]) hashTableObject;
                int mask2 = sArr.length - 1;
                int iA002 = AbstractC2010mU.A00(key.hashCode());
                while (true) {
                    int i9 = iA002 & mask2;
                    int h = sArr[i9] & 65535;
                    if (h == 65535) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues[h])) {
                        return alternatingKeysAndValues[h ^ 1];
                    }
                    iA002 = i9 + 1;
                }
            } else {
                int[] iArr = (int[]) hashTableObject;
                int mask3 = iArr.length - 1;
                int iA003 = AbstractC2010mU.A00(key.hashCode());
                while (true) {
                    int i10 = iA003 & mask3;
                    int h3 = iArr[i10];
                    if (h3 == -1) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues[h3])) {
                        return alternatingKeysAndValues[h3 ^ 1];
                    }
                    iA003 = i10 + 1;
                }
            }
        }
        throw new RuntimeException();
    }

    @CheckForNull
    public static Object A02(Object[] alternatingKeysAndValues, int n2, int tableSize, int keyOffset) {
        if (n2 == 1) {
            AbstractC1966ll.A03(Objects.requireNonNull(alternatingKeysAndValues[keyOffset]), Objects.requireNonNull(alternatingKeysAndValues[keyOffset ^ 1]));
            return null;
        }
        int h = tableSize - 1;
        C2022mg c2022mg = null;
        int i2 = -1;
        if (tableSize > 128) {
            if (tableSize <= 32768) {
                short[] hashTable = new short[tableSize];
                Arrays.fill(hashTable, (short) -1);
                int keyIndex = 0;
                for (int i8 = 0; i8 < n2; i8++) {
                    int i9 = (i8 * 2) + keyOffset;
                    int h3 = (keyIndex * 2) + keyOffset;
                    Object value = Objects.requireNonNull(alternatingKeysAndValues[i9]);
                    Object objRequireNonNull = Objects.requireNonNull(alternatingKeysAndValues[i9 ^ 1]);
                    AbstractC1966ll.A03(value, objRequireNonNull);
                    int iA00 = AbstractC2010mU.A00(value.hashCode());
                    while (true) {
                        int i10 = iA00 & h;
                        int i11 = hashTable[i10] & 65535;
                        if (i11 == 65535) {
                            hashTable[i10] = (short) h3;
                            if (keyIndex < i8) {
                                alternatingKeysAndValues[h3] = value;
                                alternatingKeysAndValues[h3 ^ 1] = objRequireNonNull;
                            }
                            keyIndex++;
                        } else {
                            boolean zEquals = value.equals(alternatingKeysAndValues[i11]);
                            if (A03[5].charAt(16) != 'P') {
                                throw new RuntimeException();
                            }
                            A03[5] = "XeR3XdSVagosh0VhP9e0zQ2n8NaTx8OB";
                            if (zEquals) {
                                c2022mg = new C2022mg(value, objRequireNonNull, Objects.requireNonNull(alternatingKeysAndValues[i11 ^ 1]));
                                alternatingKeysAndValues[i11 ^ 1] = objRequireNonNull;
                                break;
                            }
                            iA00 = i10 + 1;
                        }
                    }
                }
                return keyIndex == n2 ? hashTable : new Object[]{hashTable, Integer.valueOf(keyIndex), c2022mg};
            }
            int[] hashTable2 = new int[tableSize];
            Arrays.fill(hashTable2, -1);
            int i12 = 0;
            int i13 = 0;
            while (i13 < n2) {
                int i14 = (i13 * 2) + keyOffset;
                int i15 = (i12 * 2) + keyOffset;
                Object objRequireNonNull2 = Objects.requireNonNull(alternatingKeysAndValues[i14]);
                Object objRequireNonNull3 = Objects.requireNonNull(alternatingKeysAndValues[i14 ^ 1]);
                AbstractC1966ll.A03(objRequireNonNull2, objRequireNonNull3);
                int outKeyIndex = AbstractC2010mU.A00(objRequireNonNull2.hashCode());
                while (true) {
                    int outKeyIndex2 = outKeyIndex & h;
                    int i16 = hashTable2[outKeyIndex2];
                    if (i16 == i2) {
                        hashTable2[outKeyIndex2] = i15;
                        if (i12 < i13) {
                            alternatingKeysAndValues[i15] = objRequireNonNull2;
                            alternatingKeysAndValues[i15 ^ 1] = objRequireNonNull3;
                        }
                        i12++;
                    } else {
                        if (objRequireNonNull2.equals(alternatingKeysAndValues[i16])) {
                            c2022mg = new C2022mg(objRequireNonNull2, objRequireNonNull3, Objects.requireNonNull(alternatingKeysAndValues[i16 ^ 1]));
                            alternatingKeysAndValues[i16 ^ 1] = objRequireNonNull3;
                            break;
                        }
                        outKeyIndex = outKeyIndex2 + 1;
                        i2 = -1;
                    }
                }
                i13++;
                i2 = -1;
            }
            return i12 == n2 ? hashTable2 : new Object[]{hashTable2, Integer.valueOf(i12), c2022mg};
        }
        byte[] bArr = new byte[tableSize];
        Arrays.fill(bArr, (byte) -1);
        int i17 = 0;
        for (int i18 = 0; i18 < n2; i18++) {
            int i19 = (i18 * 2) + keyOffset;
            int i20 = (i17 * 2) + keyOffset;
            Object objRequireNonNull4 = Objects.requireNonNull(alternatingKeysAndValues[i19]);
            Object objRequireNonNull5 = Objects.requireNonNull(alternatingKeysAndValues[i19 ^ 1]);
            AbstractC1966ll.A03(objRequireNonNull4, objRequireNonNull5);
            int keyIndex2 = AbstractC2010mU.A00(objRequireNonNull4.hashCode());
            while (true) {
                int keyIndex3 = keyIndex2 & h;
                int previousKeyIndex = bArr[keyIndex3] & 255;
                if (previousKeyIndex == 255) {
                    bArr[keyIndex3] = (byte) i20;
                    if (i17 < i18) {
                        alternatingKeysAndValues[i20] = objRequireNonNull4;
                        alternatingKeysAndValues[i20 ^ 1] = objRequireNonNull5;
                    }
                    i17++;
                } else {
                    if (objRequireNonNull4.equals(alternatingKeysAndValues[previousKeyIndex])) {
                        c2022mg = new C2022mg(objRequireNonNull4, objRequireNonNull5, Objects.requireNonNull(alternatingKeysAndValues[previousKeyIndex ^ 1]));
                        alternatingKeysAndValues[previousKeyIndex ^ 1] = objRequireNonNull5;
                        break;
                    }
                    keyIndex2 = keyIndex3 + 1;
                }
            }
        }
        return i17 == n2 ? bArr : new Object[]{bArr, Integer.valueOf(i17), c2022mg};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2025mj
    public final AbstractC2016ma<V> A0A() {
        return new C1X(this.A00, 1, this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2025mj
    public final AbstractC0620Al<Map.Entry<K, V>> A0D() {
        return new C1Z(this, this.A00, 0, this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<K> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2025mj
    public final AbstractC0620Al<K> A0E() {
        final C1X c1x = new C1X(this.A00, 0, this.A01);
        return new AbstractC0620Al<K>(this, c1x) { // from class: com.facebook.ads.redexgen.X.1Y
            public final transient AbstractC0621Am<K> A00;
            public final transient AbstractC2025mj<K, ?> A01;

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<K> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.mj != com.google.common.collect.ImmutableMap<K, ?> */
            {
                this.A01 = this;
                this.A00 = c1x;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.instagram.common.viewpoint.core.AbstractC2016ma
            public final int A0I(Object[] dst, int offset) {
                return A0J().A0I(dst, offset);
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.instagram.common.viewpoint.core.AbstractC0620Al, com.instagram.common.viewpoint.core.AbstractC2016ma
            public final AbstractC0621Am<K> A0J() {
                return this.A00;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.instagram.common.viewpoint.core.AbstractC2016ma
            public final boolean A0K() {
                return true;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: A0N */
            public final AbstractC2188pg<K> iterator() {
                return A0J().iterator();
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.instagram.common.viewpoint.core.AbstractC2016ma, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object object) {
                return this.A01.get(object) != null;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1Y != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.A01.size();
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2025mj
    public final boolean A0F() {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2025mj, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        V v2 = (V) A01(this.A02, this.A00, this.A01, 0, obj);
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AL != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // java.util.Map
    public final int size() {
        return this.A01;
    }
}
