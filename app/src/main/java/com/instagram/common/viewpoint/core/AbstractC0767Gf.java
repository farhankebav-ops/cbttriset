package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.flac.PictureFrame;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
public abstract class AbstractC0767Gf {
    public static byte[] A00;
    public static String[] A01 = {"jaTfwC0cI533jMSLFdbnMioREeamNCq8", "oxYS1uYBjADPdRUL4vsR12VppXrr4BxP", "o9bG5hJtiKIeIPN2CaXw8mH6vllsT8Pg", "8s8MZLb5TSIkvuwEDH", "W6kvFYauQlSyWCDb8CQhWvVbWb1Alqwq", "aw37R0CiGakhFrBRrvipxmkRXRxeCTzI", "Y2zfIeYjiYIsjSkQMxD0jwTDeetOAull", "DaiobFePrAznnRWN86LDTmrCW9O2HPvR"};

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{5, 34, 42, 47, 38, 39, 99, 55, 44, 99, 49, 38, 34, 39, 99, 5, 15, 2, 0, 99, 48, 55, 49, 38, 34, 46, 99, 46, 34, 49, 40, 38, 49, 109, 125, 82, 73, 72, 79, 27, 93, 73, 90, 86, 94, 27, 95, 84, 94, 72, 27, 85, 84, 79, 27, 72, 79, 90, 73, 79, 27, 76, 82, 79, 83, 27, 72, 66, 85, 88, 27, 88, 84, 95, 94, 21};
    }

    static {
        A08();
    }

    public static int A00(InterfaceC1943lN interfaceC1943lN) throws IOException {
        interfaceC1943lN.AI1();
        C4J c4j = new C4J(2);
        interfaceC1943lN.AG9(c4j.A0l(), 0, 2);
        int syncCode = c4j.A0M();
        int frameStartMarker = syncCode >> 2;
        if (frameStartMarker == 16382) {
            interfaceC1943lN.AI1();
            return syncCode;
        }
        interfaceC1943lN.AI1();
        throw C04222i.A01(A06(34, 42, 75), null);
    }

    public static Metadata A01(InterfaceC1943lN interfaceC1943lN, boolean z2) throws IOException {
        InterfaceC0790Hc id3FramePredicate;
        if (z2) {
            id3FramePredicate = null;
        } else {
            id3FramePredicate = C05748i.A03;
        }
        Metadata metadataA00 = new C0772Gk().A00(interfaceC1943lN, id3FramePredicate);
        if (metadataA00 == null || metadataA00.A02() == 0) {
            return null;
        }
        return metadataA00;
    }

    public static Metadata A02(InterfaceC1943lN interfaceC1943lN, boolean z2) throws IOException {
        interfaceC1943lN.AI1();
        long jA8a = interfaceC1943lN.A8a();
        Metadata metadataA01 = A01(interfaceC1943lN, z2);
        interfaceC1943lN.AJJ((int) (interfaceC1943lN.A8a() - jA8a));
        return metadataA01;
    }

    public static C0768Gg A03(C4J c4j) {
        c4j.A0g(1);
        int iA0K = c4j.A0K();
        int length = c4j.A09();
        long j = ((long) length) + ((long) iA0K);
        int i2 = iA0K / 18;
        long[] jArrCopyOf = new long[i2];
        long[] jArrCopyOf2 = new long[i2];
        int i8 = 0;
        while (true) {
            if (i8 >= i2) {
                break;
            }
            long jA0P = c4j.A0P();
            if (jA0P == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i8);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i8);
                break;
            }
            jArrCopyOf[i8] = jA0P;
            jArrCopyOf2[i8] = c4j.A0P();
            c4j.A0g(2);
            i8++;
        }
        int length2 = c4j.A09();
        c4j.A0g((int) (j - ((long) length2)));
        return new C0768Gg(jArrCopyOf, jArrCopyOf2);
    }

    public static C0768Gg A04(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        C4J c4j = new C4J(i2);
        interfaceC1943lN.readFully(c4j.A0l(), 0, i2);
        return A03(c4j);
    }

    public static C0769Gh A05(InterfaceC1943lN interfaceC1943lN) throws IOException {
        byte[] bArr = new byte[38];
        interfaceC1943lN.readFully(bArr, 0, 38);
        return new C0769Gh(bArr, 4);
    }

    public static List<String> A07(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        C4J c4j = new C4J(i2);
        interfaceC1943lN.readFully(c4j.A0l(), 0, i2);
        c4j.A0g(4);
        return Arrays.asList(H8.A05(c4j, false, false).A02);
    }

    public static void A09(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C4J c4j = new C4J(4);
        interfaceC1943lN.readFully(c4j.A0l(), 0, 4);
        if (c4j.A0Q() == 1716281667) {
        } else {
            throw C04222i.A01(A06(0, 34, 51), null);
        }
    }

    public static boolean A0A(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C4J c4j = new C4J(4);
        interfaceC1943lN.AG9(c4j.A0l(), 0, 4);
        return c4j.A0Q() == 1716281667;
    }

    public static boolean A0B(InterfaceC1943lN interfaceC1943lN, C0766Ge c0766Ge) throws IOException {
        interfaceC1943lN.AI1();
        C4I c4i = new C4I(new byte[4]);
        interfaceC1943lN.AG9(c4i.A00, 0, 4);
        boolean zA0H = c4i.A0H();
        int iA04 = c4i.A04(7);
        int iA042 = c4i.A04(24) + 4;
        if (iA04 == 0) {
            C0769Gh c0769GhA05 = A05(interfaceC1943lN);
            String[] strArr = A01;
            if (strArr[1].charAt(0) != strArr[2].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "oF2KQg39ZEK5V6OHUZM6u4PkuH0D3J87";
            strArr2[2] = "opWNo3Pnwj2PHBTvqD8r5OWylRW508kK";
            c0766Ge.A00 = c0769GhA05;
        } else {
            C0769Gh c0769Gh = c0766Ge.A00;
            if (c0769Gh != null) {
                if (iA04 != 3) {
                    if (iA04 == 4) {
                        c0766Ge.A00 = c0769Gh.A0B(A07(interfaceC1943lN, iA042));
                    } else if (iA04 == 6) {
                        C4J c4j = new C4J(iA042);
                        interfaceC1943lN.readFully(c4j.A0l(), 0, iA042);
                        c4j.A0g(4);
                        PictureFrame pictureFrame = PictureFrame.A00(c4j);
                        c0766Ge.A00 = c0769Gh.A0A(MetaExoPlayerCustomizedCollections.A03(pictureFrame));
                    } else {
                        interfaceC1943lN.AJJ(iA042);
                    }
                } else {
                    c0766Ge.A00 = c0769Gh.A09(A04(interfaceC1943lN, iA042));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return zA0H;
    }
}
