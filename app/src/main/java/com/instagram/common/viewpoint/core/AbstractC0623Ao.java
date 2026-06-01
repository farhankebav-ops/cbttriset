package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0623Ao<E> extends AbstractC2015mZ<E> {
    public static byte[] A03;
    public static String[] A04 = {"emqP2Ifv15ruA3vfOBddLKXSQAhVBBiZ", "hrMd7lJ1e8dj2uYkEp7ZkSLs2D8yKDzP", "R1glWPF1KbPaEDQGu2GwL6vWIpfQR0VI", "T12dHmfXBitdOytN2RtspbU6Ik8qeuAk", "0tCJd3vKXz4Euq7T8InIHSFr9bbtNXIu", "Q", "MwChlhzfsoxh", "7ToYkJZV1iSpkxWyqnmjBpfIK3KeTcwM"};
    public int A00;
    public boolean A01;
    public Object[] A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[3].charAt(25) != 'k') {
                throw new RuntimeException();
            }
            A04[4] = "sNiI9gS6nHnAzu4lGjYMdK7Ee3tNN7Ch";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 87);
            i10++;
        }
    }

    public static void A01() {
        A03 = new byte[]{-6, -1, -6, 5, -6, -14, -3, -44, -14, 1, -14, -12, -6, 5, 10};
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ao != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    public AbstractC0623Ao(int initialCapacity) {
        AbstractC1966ll.A00(initialCapacity, A00(0, 15, 58));
        this.A02 = new Object[initialCapacity];
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ao != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    private void A02(int minCapacity) {
        if (this.A02.length < minCapacity) {
            this.A02 = Arrays.copyOf(this.A02, AbstractC2015mZ.A03(this.A02.length, minCapacity));
            this.A01 = false;
        } else {
            if (!this.A01) {
                return;
            }
            this.A02 = (Object[]) this.A02.clone();
            this.A01 = false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Ao != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    public AbstractC0623Ao<E> A03(E element) {
        AbstractC1819jA.A04(element);
        A02(this.A00 + 1);
        Object[] objArr = this.A02;
        int i2 = this.A00;
        this.A00 = i2 + 1;
        objArr[i2] = element;
        return this;
    }
}
