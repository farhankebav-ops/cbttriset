package com.facebook.ads.androidx.media3.extractor.mkv;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.FirebaseError;
import com.instagram.common.viewpoint.core.AbstractC04664a;
import com.instagram.common.viewpoint.core.AbstractC0778Gq;
import com.instagram.common.viewpoint.core.AnonymousClass45;
import com.instagram.common.viewpoint.core.C04222i;
import com.instagram.common.viewpoint.core.C0781Gt;
import com.instagram.common.viewpoint.core.C1920kp;
import com.instagram.common.viewpoint.core.C1922kr;
import com.instagram.common.viewpoint.core.C1938lI;
import com.instagram.common.viewpoint.core.C3M;
import com.instagram.common.viewpoint.core.C4J;
import com.instagram.common.viewpoint.core.GX;
import com.instagram.common.viewpoint.core.GY;
import com.instagram.common.viewpoint.core.H1;
import com.instagram.common.viewpoint.core.I9;
import com.instagram.common.viewpoint.core.IC;
import com.instagram.common.viewpoint.core.ID;
import com.instagram.common.viewpoint.core.IE;
import com.instagram.common.viewpoint.core.InterfaceC0763Gb;
import com.instagram.common.viewpoint.core.InterfaceC1943lN;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MatroskaExtractor implements GX {
    public static byte[] A0t;
    public static String[] A0u = {"tBqjpPNwSsfRjGbhoSofYeEQJAfxpzeJ", "SQ32k5yHiSqu0tF5bV2mYZI8q27OK2Wk", "Ew8EcvFtYPYsbuW", "MeCkyRYcfoGShRSoQHq7qyLBTkTGcoSQ", "UyV8GtaWyEclMV8OhG", "yLkQb0Xo1O", "PFhexnCJ0GZtqtRWjlJ7uY4w9", "UodjFtXG6f6h7NmMQ857"};
    public static final InterfaceC0763Gb A0v;
    public static final Map<String, Integer> A0w;
    public static final UUID A0x;
    public static final byte[] A0y;
    public static final byte[] A0z;
    public static final byte[] A10;
    public static final byte[] A11;
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public long A0N;
    public long A0O;

    @MetaExoPlayerCustomization("Removed the final from the member variable")
    public SparseArray<IC> A0P;
    public AnonymousClass45 A0Q;
    public AnonymousClass45 A0R;
    public GY A0S;
    public IC A0T;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "AR/VC customizations")
    public String A0U;
    public ByteBuffer A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public int[] A0f;
    public final C4J A0g;
    public final C4J A0h;
    public final C4J A0i;
    public final C4J A0j;
    public final C4J A0k;
    public final C4J A0l;
    public final C4J A0m;
    public final C4J A0n;
    public final C4J A0o;
    public final C4J A0p;
    public final I9 A0q;
    public final IE A0r;
    public final boolean A0s;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020d A[PHI: r0
  0x020d: PHI (r0v193 byte[]) = (r0v192 byte[]), (r0v208 byte[]) binds: [B:63:0x0209, B:37:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0320  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#2.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A02(com.instagram.common.viewpoint.core.InterfaceC1943lN r13, com.instagram.common.viewpoint.core.IC r14, int r15, boolean r16) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1070
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A02(com.facebook.ads.redexgen.X.lN, com.facebook.ads.redexgen.X.IC, int, boolean):int");
    }

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0t, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0t = new byte[]{90, 23, 15, 9, 14, 90, 24, 31, 90, 19, 20, 90, 27, 90, 57, 15, 31, 9, 96, 45, 53, 51, 52, 96, 34, 37, 96, 41, 46, 96, 33, 96, 20, 50, 33, 35, 43, 5, 46, 52, 50, 57, 19, 93, 92, 71, 19, 64, 70, 67, 67, 92, 65, 71, 86, 87, 111, 122, 123, 46, 112, 111, 122, 120, 46, 112, 111, 122, 120, 46, 112, 111, 122, 120, 46, 22, 3, 1, 87, 9, 22, 3, 1, 87, 9, 22, 3, 1, 87, 31, 22, 3, 0, 87, 19, 6, 4, 82, 12, 19, 6, 4, 82, 12, 19, 6, 4, 82, 24, 19, 6, 5, 82, 0, 4, 18, 18, 36, 53, 53, 40, 47, 38, 50, 2, 40, 49, 41, 36, 51, 12, 46, 37, 36, 97, 94, 64, 94, 94, 92, 23, 9, 23, 21, 101, 58, 36, 63, 47, 40, 58, 36, 63, 47, 40, 84, 62, 35, 43, 41, 62, 40, 40, 80, 78, 85, 69, 66, 62, 93, 94, 66, 66, 93, 84, 66, 66, 120, 102, 124, 120, 122, 10, 110, 112, 105, 99, 110, 108, 33, 63, 45, 48, 37, 39, 79, 44, 82, 2, 28, 14, 19, 6, 4, 108, 15, 112, 33, 63, 45, 51, 79, 33, 35, 45, 31, 1, 17, 14, 11, 13, 82, 76, 67, 80, 94, 60, 85, 95, 92, 82, 71, 60, 90, 86, 86, 86, 82, 76, 67, 80, 94, 60, 90, 93, 71, 60, 81, 90, 84, 12, 18, 29, 14, 0, 98, 4, 3, 25, 98, 1, 4, 25, 116, 106, 97, 103, 96, 112, 125, 113, 56, 38, 47, 54, 43, 59, 48, 42, 105, 75, 68, 13, 94, 10, 89, 73, 75, 70, 79, 10, 94, 67, 71, 79, 73, 69, 78, 79, 10, 90, 88, 67, 69, 88, 10, 94, 69, 10, 94, 67, 71, 79, 73, 69, 78, 79, 121, 73, 75, 70, 79, 10, 72, 79, 67, 68, 77, 10, 89, 79, 94, 4, 5, 41, 34, 35, 37, 15, 34, 102, 47, 53, 102, 43, 47, 53, 53, 47, 40, 33, 102, 47, 40, 102, 18, 52, 39, 37, 45, 3, 40, 50, 52, 63, 102, 35, 42, 35, 43, 35, 40, 50, 117, 89, 91, 84, 95, 88, 95, 88, 81, 22, 83, 88, 85, 68, 79, 70, 66, 95, 89, 88, 22, 87, 88, 82, 22, 85, 89, 91, 70, 68, 83, 69, 69, 95, 89, 88, 22, 95, 69, 22, 88, 89, 66, 22, 69, 67, 70, 70, 89, 68, 66, 83, 82, 86, 122, 123, 97, 112, 123, 97, 86, 122, 120, 101, 84, 121, 114, 122, 53, 107, 71, 70, 92, 77, 70, 92, 109, 70, 75, 105, 68, 79, 71, 8, 82, 126, 127, 101, 116, 127, 101, 84, 127, 114, 126, 117, 120, 127, 118, 94, 99, 117, 116, 99, 49, 95, 115, 114, 104, 121, 114, 104, 89, 114, 127, 115, 120, 117, 114, 123, 79, 127, 115, 108, 121, 60, 110, 67, 89, 73, 75, 88, 78, 67, 68, 77, 10, 70, 75, 89, 94, 10, 73, 95, 79, 10, 90, 69, 67, 68, 94, 10, 93, 67, 94, 66, 10, 95, 68, 79, 82, 90, 79, 73, 94, 79, 78, 10, 78, 95, 88, 75, 94, 67, 69, 68, 16, 10, 13, 38, 42, 29, 48, 57, 44, 105, 83, 120, 116, 67, 110, 103, 114, 69, 114, 118, 115, 65, 114, 101, 100, 126, 120, 121, 55, 71, 64, 79, 78, 34, 110, 99, 97, 107, 108, 101, 34, 113, 99, 111, 114, 110, 103, 34, 113, 107, 120, 103, 34, 109, 119, 118, 34, 109, 100, 34, 112, 99, 108, 101, 103, 44, 51, 52, 59, 58, 36, 19, 23, 18, 32, 19, 4, 5, 31, 25, 24, 86, 1, 40, 33, 41, 33, 42, 48, 100, 119, 92, 81, 64, 75, 66, 70, 87, 86, 18, 102, 64, 83, 81, 89, 18, 84, 93, 71, 92, 86, 18, 80, 71, 70, 18, 113, 93, 92, 70, 87, 92, 70, 119, 92, 81, 121, 87, 75, 123, 118, 18, 69, 83, 65, 18, 92, 93, 70, 18, 84, 93, 71, 92, 86, 71, 122, 118, 103, 108, 113, 107, 109, 108, 34, 96, 107, 118, 34, 107, 113, 34, 113, 103, 118, 34, 107, 108, 34, 113, 107, 101, 108, 99, 110, 34, 96, 123, 118, 103, 108, 69, 88, 71, 75, 94, 16, 10, 121, 94, 75, 88, 94, 6, 10, 111, 68, 78, 6, 10, 120, 79, 75, 78, 101, 88, 78, 79, 88, 6, 10, 102, 75, 83, 79, 88, 6, 10, 121, 94, 83, 70, 79, 6, 10, 100, 75, 71, 79, 6, 10, 103, 75, 88, 77, 67, 68, 102, 6, 10, 103, 75, 88, 77, 67, 68, 120, 6, 10, 103, 75, 88, 77, 67, 68, 124, 6, 10, 111, 76, 76, 79, 73, 94, 6, 10, 126, 79, 82, 94, 56, 20, 27, 17, 20, 1, 26, 7, 12, 85, 16, 25, 16, 24, 16, 27, 1, 85, 38, 16, 16, 30, 60, 49, 85, 26, 7, 85, 38, 16, 16, 30, 37, 26, 6, 28, 1, 28, 26, 27, 85, 27, 26, 1, 85, 19, 26, 0, 27, 17, 14, 34, 55, 49, 44, 48, 40, 34, 6, 59, 55, 49, 34, 32, 55, 44, 49, 54, 14, 23, 15, 18, 11, 23, 30, 91, 40, 30, 28, 22, 30, 21, 15, 91, 30, 23, 30, 22, 30, 21, 15, 8, 91, 21, 20, 15, 91, 8, 14, 11, 11, 20, 9, 15, 30, 31, 32, 1, 78, 24, 15, 2, 7, 10, 78, 26, 28, 15, 13, 5, 29, 78, 25, 11, 28, 11, 78, 8, 1, 27, 0, 10, 91, 122, 53, 99, 116, 121, 124, 113, 53, 99, 116, 103, 124, 123, 97, 53, 121, 112, 123, 114, 97, 125, 53, 120, 116, 102, 126, 53, 115, 122, 96, 123, 113, 61, 49, 42, 56, 44, 61, 59, 44, 105, 101, 114, 126, 119, 108, 21, 106, 
        125, 105, 58, 54, 61, 44, 49, 61, 70, 40, 58, 58, 103, 107, 96, 113, 108, 96, 27, 97, 96, 114, 12, 127, 115, 120, 105, 116, 120, 3, 123, 105, 110, 122, 120, 120, 65, 77, 68, 93, 80, 65, 71, 80, 35, 27, 25, 0, 0, 25, 30, 23, 80, 3, 5, 18, 4, 25, 4, 28, 21, 80, 3, 17, 29, 0, 28, 21, 80, 25, 30, 80, 28, 17, 19, 21, 20, 80, 18, 28, 31, 19, 27, 94, 64, 120, 122, 99, 99, 122, 125, 116, 51, 96, 102, 113, 103, 122, 103, 127, 118, 51, 96, 114, 126, 99, 127, 118, 51, 100, 122, 103, 123, 51, 125, 124, 51, 119, 102, 97, 114, 103, 122, 124, 125, 61, 81, 106, 97, 124, 116, 97, 103, 112, 97, 96, 36, 109, 96, 62, 36, 9, 50, 57, 36, 44, 57, 63, 40, 57, 56, 124, 48, 61, 63, 53, 50, 59, 124, 42, 61, 48, 41, 57, 102, 124, 45, 36, 58, 45, 74, 62, 55, 37, 56, 45, 47, 90, 122, 115, 97, 124, 105, 107, 24, 3, 101, 127, 99, 3, 109, 124, 102, 111, 125, 96, 117, 119, 4, 31, 121, 99, 127, 31, 113, 99, 96, 84, 93, 79, 82, 71, 69, 54, 45, 75, 81, 77, 45, 67, 84, 65, 60, 53, 39, 58, 47, 45, 94, 69, 35, 57, 37, 69, 57, 58, 117, 124, 110, 115, 102, 100, 107, 12, 106, 112, 108, 12, 107, 102, 117, 96, 76, 69, 87, 73, 53, 76, 92, 77, 53, 92, 85, 79, 72, 89, 89, 69, 76, 71, 91, 86, 92, 65, 82, 18, 27, 18, 20, 124, 2, 11, 2, 4, 109, 79, 83, 68, 120, 81, 78, 67, 66, 72, 120, 85, 72, 83, 102, 10, 23, 23, 23, 52, 40, 63, 3, 42, 53, 56, 57, 51, 3, 46, 51, 40, 29, 113, 108, 101, 108, 56, 36, 51, 15, 38, 57, 52, 53, 63, 15, 34, 63, 36, 17, 125, 97, 104, 96, 93, 65, 86, 106, 67, 92, 81, 80, 90, 106, 71, 90, 65, 116, 24, 7, 2, 5, 34, 46, 59, 61, 32, 60, 36, 46, 56, 39, 42, 43, 33, 97, 57, 43, 44, 35, 21, 7, 0, 15};
    }

    static {
        A0B();
        A0v = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.kq
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return MatroskaExtractor.A0Q();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
        A10 = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        A0y = AbstractC04664a.A1G(A06(729, 90, 38));
        A0z = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        A11 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        A0x = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put(A06(1285, 18, 43), 0);
        map.put(A06(1303, 18, 80), 90);
        map.put(A06(1321, 18, 92), 180);
        map.put(A06(1339, 18, 57), 270);
        Map<String, Integer> trackNameToRotationDegrees = Collections.unmodifiableMap(map);
        A0w = trackNameToRotationDegrees;
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i2) {
        this(new C1922kr(), i2);
    }

    public MatroskaExtractor(I9 i9, int i2) {
        this.A0M = -1L;
        this.A0O = -9223372036854775807L;
        this.A0I = -9223372036854775807L;
        this.A0J = -9223372036854775807L;
        this.A0H = -1L;
        this.A0L = -1L;
        this.A0G = -9223372036854775807L;
        this.A0q = i9;
        this.A0q.AA5(new C1920kp(this));
        this.A0s = (i2 & 1) == 0;
        this.A0r = new IE();
        this.A0P = new SparseArray<>();
        this.A0l = new C4J(4);
        this.A0p = new C4J(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0m = new C4J(4);
        this.A0j = new C4J(AbstractC0778Gq.A03);
        this.A0i = new C4J(4);
        this.A0k = new C4J();
        this.A0n = new C4J();
        this.A0g = new C4J(8);
        this.A0h = new C4J();
        this.A0o = new C4J();
        this.A0f = new int[1];
    }

    private int A00() {
        int sampleSize = this.A09;
        A0A();
        return sampleSize;
    }

    private int A01(InterfaceC1943lN interfaceC1943lN, H1 h12, int i2) throws IOException {
        int strippedBytesLeft = this.A0k.A07();
        if (strippedBytesLeft > 0) {
            int bytesWritten = Math.min(i2, strippedBytesLeft);
            h12.AI7(this.A0k, bytesWritten);
            return bytesWritten;
        }
        return h12.AI5(interfaceC1943lN, i2, false);
    }

    private long A03(long j) throws C04222i {
        if (this.A0O != -9223372036854775807L) {
            return AbstractC04664a.A0U(j, this.A0O, 1000L);
        }
        throw C04222i.A01(A06(279, 54, 38), null);
    }

    /* JADX WARN: Incorrect condition in loop: B:19:0x0053 */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Adding support AR/VR eventListener")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.instagram.common.viewpoint.core.InterfaceC0784Gw A04(com.instagram.common.viewpoint.core.AnonymousClass45 r11, com.instagram.common.viewpoint.core.AnonymousClass45 r12) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A04(com.facebook.ads.redexgen.X.45, com.facebook.ads.redexgen.X.45):com.facebook.ads.redexgen.X.Gw");
    }

    private final IC A05(int i2) throws C04222i {
        A0D(i2);
        return this.A0T;
    }

    @EnsuresNonNull({"extractorOutput"})
    private void A09() {
        C3M.A02(this.A0S);
    }

    private void A0A() {
        this.A08 = 0;
        this.A09 = 0;
        this.A0A = 0;
        this.A0Y = false;
        this.A0b = false;
        this.A0a = false;
        this.A0B = 0;
        this.A00 = (byte) 0;
        this.A0Z = false;
        this.A0k.A0d(0);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void A0C(int i2) throws C04222i {
        if (this.A0R != null && this.A0Q != null) {
        } else {
            throw C04222i.A01(A06(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, 8, 72) + i2 + A06(0, 18, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void A0D(int i2) throws C04222i {
        if (this.A0T != null) {
        } else {
            throw C04222i.A01(A06(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, 8, 72) + i2 + A06(18, 24, 76), null);
        }
    }

    private void A0E(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        if (this.A0l.A0A() >= i2) {
            return;
        }
        if (this.A0l.A08() < i2) {
            this.A0l.A0c(Math.max(this.A0l.A08() * 2, i2));
        }
        interfaceC1943lN.readFully(this.A0l.A0l(), this.A0l.A0A(), i2 - this.A0l.A0A());
        this.A0l.A0e(i2);
    }

    private void A0F(InterfaceC1943lN interfaceC1943lN, byte[] bArr, int i2) throws IOException {
        int length = bArr.length + i2;
        int sizeWithPrefix = this.A0n.A08();
        if (sizeWithPrefix < length) {
            int sizeWithPrefix2 = length + i2;
            this.A0n.A0i(Arrays.copyOf(bArr, sizeWithPrefix2));
        } else {
            byte[] bArrA0l = this.A0n.A0l();
            int sizeWithPrefix3 = bArr.length;
            System.arraycopy(bArr, 0, bArrA0l, 0, sizeWithPrefix3);
        }
        byte[] bArrA0l2 = this.A0n.A0l();
        int sizeWithPrefix4 = bArr.length;
        interfaceC1943lN.readFully(bArrA0l2, sizeWithPrefix4, i2);
        this.A0n.A0f(0);
        this.A0n.A0e(length);
    }

    private void A0G(InterfaceC1943lN interfaceC1943lN, byte[] bArr, int i2, int i8) throws IOException {
        int iMin = Math.min(i8, this.A0k.A07());
        int pendingStrippedBytes = i2 + iMin;
        interfaceC1943lN.readFully(bArr, pendingStrippedBytes, i8 - iMin);
        if (iMin > 0) {
            this.A0k.A0k(bArr, i2, iMin);
        }
    }

    private final void A0H(IC ic, int i2, InterfaceC1943lN interfaceC1943lN, int i8) throws IOException {
        if (i2 == 4) {
            if (A06(1280, 5, 88).equals(ic.A0d)) {
                this.A0o.A0d(i8);
                interfaceC1943lN.readFully(this.A0o.A0l(), 0, i8);
                return;
            }
        }
        interfaceC1943lN.AJJ(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0I(com.instagram.common.viewpoint.core.IC r15, long r16, int r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0I(com.facebook.ads.redexgen.X.IC, long, int, int, int):void");
    }

    private final void A0J(IC ic, InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        if (ic.A0n != 1685485123) {
            int i8 = ic.A0n;
            String[] strArr = A0u;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0u;
            strArr2[2] = "z7J25JPdzWy80Kd";
            strArr2[4] = "xEqpvZ1X3IvVWW9v69";
            if (i8 != 1685480259) {
                interfaceC1943lN.AJJ(i2);
                return;
            }
        }
        ic.A0k = new byte[i2];
        interfaceC1943lN.readFully(ic.A0k, 0, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0K(java.lang.String r6, long r7, byte[] r9) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0K(java.lang.String, long, byte[]):void");
    }

    private boolean A0L(C0781Gt c0781Gt, long j) {
        if (this.A0c) {
            this.A0L = j;
            c0781Gt.A00 = this.A0H;
            this.A0c = false;
            return true;
        }
        if (!this.A0e || this.A0L == -1) {
            return false;
        }
        c0781Gt.A00 = this.A0L;
        this.A0L = -1L;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x032d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[RETURN] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0M(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0M(java.lang.String):boolean");
    }

    public static byte[] A0O(long j, String str, long j3) {
        C3M.A07(j != -9223372036854775807L);
        int i2 = (int) (j / 3600000000L);
        long j8 = j - ((((long) i2) * 3600) * 1000000);
        int i8 = (int) (j8 / 60000000);
        long j9 = j8 - ((((long) i8) * 60) * 1000000);
        int i9 = (int) (j9 / 1000000);
        int minutes = (int) ((j9 - (((long) i9) * 1000000)) / j3);
        return AbstractC04664a.A1G(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(minutes)));
    }

    public static int[] A0P(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    public static /* synthetic */ GX[] A0Q() {
        return new GX[]{new MatroskaExtractor()};
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "Adding support for AR/VR TAGs")
    public final int A0R(int i2) {
        switch (i2) {
            case MRAID_JS_WRITE_FAILED_VALUE:
            case PRIVACY_URL_ERROR_VALUE:
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
            case 159:
            case 176:
            case 179:
            case 186:
            case AD_RESPONSE_EMPTY_VALUE:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case STORE_REGION_CODE_ERROR_VALUE:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE:
            case AD_LOAD_FAIL_PLACEMENT_ID_MISMATCH_VALUE:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 26568:
            case 28032:
            case 29555:
            case 30113:
            case 30320:
            case 290298740:
            case 307544935:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                String[] strArr = A0u;
                if (strArr[2].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0u;
                strArr2[1] = "HyhNlEIHHjvGo8KvAMWihGCcOuKz7U7o";
                strArr2[0] = "rV4cPIzb4RrvL4U1RF1zVSCUyrwoic3K";
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            case 17543:
            case 17827:
                return 6;
            default:
                return 0;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:62:0x017e */
    /* JADX WARN: Incorrect condition in loop: B:66:0x018b */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0S(int r15) throws com.instagram.common.viewpoint.core.C04222i {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0S(int):void");
    }

    public final void A0T(int i2, double d8) throws C04222i {
        switch (i2) {
            case 181:
                IC icA05 = A05(i2);
                int i8 = (int) d8;
                if (A0u[3].charAt(5) != 'R') {
                    throw new RuntimeException();
                }
                A0u[7] = "mnSBpt4UIloiGRhCy1GZQUK3TYQANP";
                icA05.A0T = i8;
                return;
            case 17545:
                this.A0I = (long) d8;
                return;
            case 21969:
                A05(i2).A06 = (float) d8;
                return;
            case 21970:
                IC icA052 = A05(i2);
                if (A0u[7].length() != 16) {
                    A0u[7] = "bgRhYiIqKVlSmtLlUnVbMuj";
                    icA052.A07 = (float) d8;
                    return;
                } else {
                    icA052.A07 = (float) d8;
                    return;
                }
            case 21971:
                A05(i2).A04 = (float) d8;
                return;
            case 21972:
                A05(i2).A05 = (float) d8;
                return;
            case 21973:
                A05(i2).A02 = (float) d8;
                return;
            case 21974:
                A05(i2).A03 = (float) d8;
                return;
            case 21975:
                A05(i2).A0B = (float) d8;
                return;
            case 21976:
                IC icA053 = A05(i2);
                float f4 = (float) d8;
                String[] strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    A0u[7] = "0K";
                    icA053.A0C = f4;
                    return;
                }
                throw new RuntimeException();
            case 21977:
                A05(i2).A00 = (float) d8;
                return;
            case 21978:
                A05(i2).A01 = (float) d8;
                return;
            case 30323:
                A05(i2).A0A = (float) d8;
                return;
            case 30324:
                A05(i2).A08 = (float) d8;
                return;
            case 30325:
                A05(i2).A09 = (float) d8;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:48:0x01d2 */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x033a A[LOOP:4: B:89:0x0338->B:90:0x033a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0U(int r21, int r22, com.instagram.common.viewpoint.core.InterfaceC1943lN r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1074
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.A0U(int, int, com.facebook.ads.redexgen.X.lN):void");
    }

    public final void A0V(int i2, long j) throws C04222i {
        String strA06 = A06(42, 14, 63);
        switch (i2) {
            case MRAID_JS_WRITE_FAILED_VALUE:
                A05(i2).A0V = (int) j;
                return;
            case PRIVACY_URL_ERROR_VALUE:
                A05(i2).A0f = j == 1;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                this.A0D = A03(j);
                return;
            case 159:
                A05(i2).A0E = (int) j;
                return;
            case 176:
                A05(i2).A0W = (int) j;
                return;
            case 179:
                A0C(i2);
                this.A0R.A04(A03(j));
                return;
            case 186:
                A05(i2).A0M = (int) j;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                A05(i2).A0R = (int) j;
                return;
            case 231:
                this.A0G = A03(j);
                return;
            case 238:
                this.A01 = (int) j;
                return;
            case 241:
                if (this.A0d) {
                    return;
                }
                A0C(i2);
                this.A0Q.A04(j);
                this.A0d = true;
                return;
            case 251:
                this.A0W = true;
                return;
            case 16871:
                A05(i2).A0n = (int) j;
                return;
            case 16980:
                String[] strArr = A0u;
                if (strArr[1].charAt(1) != strArr[0].charAt(1)) {
                    String[] strArr2 = A0u;
                    strArr2[1] = "siSTSWWHFDsKrirn3iU8fidRJrb4DuSX";
                    strArr2[0] = "o7Su23MSMUKyfq0AiKXYGeUTl03UpruG";
                    if (j == 3) {
                        return;
                    }
                } else {
                    String[] strArr3 = A0u;
                    strArr3[5] = "wDyyIq2mnN";
                    strArr3[6] = "u9jmr3hENDVfo4ybwkpsevoxR";
                    if (j == 3) {
                        return;
                    }
                }
                throw C04222i.A01(A06(426, 16, 25) + j + strA06, null);
            case 17029:
                if (j >= 1 && j <= 2) {
                    return;
                } else {
                    throw C04222i.A01(A06(559, 19, 27) + j + strA06, null);
                }
            case 17143:
                if (j == 1) {
                    return;
                } else {
                    throw C04222i.A01(A06(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, 16, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) + j + strA06, null);
                }
            case 18401:
                if (j == 5) {
                    return;
                } else {
                    throw C04222i.A01(A06(442, 15, 36) + j + strA06, null);
                }
            case 18408:
                if (j == 1) {
                    return;
                } else {
                    throw C04222i.A01(A06(113, 22, 77) + j + strA06, null);
                }
            case 20529:
                if (j == 0) {
                    return;
                } else {
                    throw C04222i.A01(A06(457, 21, 29) + j + strA06, null);
                }
            case 20530:
                if (j == 1) {
                    return;
                } else {
                    throw C04222i.A01(A06(478, 21, 16) + j + strA06, null);
                }
            case 21420:
                this.A0K = this.A0M + j;
                return;
            case 21432:
                int i8 = (int) j;
                A0D(i2);
                switch (i8) {
                    case 0:
                        this.A0T.A0U = 0;
                        return;
                    case 1:
                        this.A0T.A0U = 2;
                        return;
                    case 3:
                        this.A0T.A0U = 1;
                        return;
                    case 15:
                        this.A0T.A0U = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                A05(i2).A0L = (int) j;
                return;
            case 21682:
                A05(i2).A0K = (int) j;
                return;
            case 21690:
                A05(i2).A0J = (int) j;
                return;
            case 21930:
                A05(i2).A0g = j == 1;
                return;
            case 21945:
                A0D(i2);
                switch ((int) j) {
                    case 1:
                        IC ic = this.A0T;
                        if (A0u[7].length() != 16) {
                            String[] strArr4 = A0u;
                            strArr4[1] = "46IydxS7gy6otlVQjCqCZWblmnAwVrZG";
                            strArr4[0] = "ABdhU4etfaEDzGqzhVxfZNO7CdkZTY0J";
                            ic.A0F = 2;
                            return;
                        }
                        ic.A0F = 2;
                        return;
                    case 2:
                        this.A0T.A0F = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                A0D(i2);
                int iA01 = ColorInfo.A01((int) j);
                if (iA01 == -1) {
                    return;
                }
                this.A0T.A0H = iA01;
                return;
            case 21947:
                A0D(i2);
                this.A0T.A0h = true;
                int iA00 = ColorInfo.A00((int) j);
                if (iA00 == -1) {
                    return;
                }
                this.A0T.A0G = iA00;
                return;
            case 21948:
                A05(i2).A0O = (int) j;
                return;
            case 21949:
                A05(i2).A0P = (int) j;
                return;
            case 21998:
                A05(i2).A0N = (int) j;
                return;
            case 22186:
                A05(i2).A0X = j;
                return;
            case 22203:
                A05(i2).A0Y = j;
                return;
            case 25188:
                A05(i2).A0D = (int) j;
                return;
            case 30114:
                this.A0E = j;
                return;
            case 30321:
                A0D(i2);
                switch ((int) j) {
                    case 0:
                        this.A0T.A0S = 0;
                        return;
                    case 1:
                        this.A0T.A0S = 1;
                        return;
                    case 2:
                        this.A0T.A0S = 2;
                        return;
                    case 3:
                        this.A0T.A0S = 3;
                        return;
                    default:
                        return;
                }
            case 2352003:
                IC icA05 = A05(i2);
                if (A0u[3].charAt(5) != 'R') {
                    throw new RuntimeException();
                }
                A0u[3] = "17DkRR24xbcR08jR5ve3iaIolPHvV07P";
                icA05.A0I = (int) j;
                return;
            case 2807729:
                this.A0O = j;
                return;
            default:
                return;
        }
    }

    public final void A0W(int i2, long j, long j3) throws C04222i {
        A09();
        switch (i2) {
            case 160:
                this.A0W = false;
                this.A0E = 0L;
                return;
            case 174:
                this.A0T = new IC();
                return;
            case 187:
                this.A0d = false;
                return;
            case 19899:
                this.A0C = -1;
                this.A0K = -1L;
                return;
            case 20533:
                A05(i2).A0i = true;
                return;
            case 21968:
                A05(i2).A0h = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                if (this.A0M == -1 || this.A0M == j) {
                    this.A0M = j;
                    this.A0N = j3;
                    return;
                }
                throw C04222i.A01(A06(886, 39, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), null);
            case 475249515:
                this.A0R = new AnonymousClass45();
                this.A0Q = new AnonymousClass45();
                return;
            case 524531317:
                if (this.A0e) {
                    return;
                }
                if (this.A0s && this.A0H != -1) {
                    this.A0c = true;
                    return;
                } else {
                    this.A0S.AIN(new C1938lI(this.A0J));
                    this.A0e = true;
                    return;
                }
        }
    }

    @MetaExoPlayerCustomization("Adding support for AR/VR TAGs")
    public final void A0X(int i2, String str) throws C04222i {
        switch (i2) {
            case STORE_REGION_CODE_ERROR_VALUE:
                A05(i2).A0d = str;
                return;
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                if (!A06(1375, 4, 110).equals(str) && !A06(1357, 8, 67).equals(str)) {
                    throw C04222i.A01(A06(551, 8, 69) + str + A06(42, 14, 63), null);
                }
                return;
            case 17827:
                this.A0U = str;
                return;
            case 21358:
                IC icA05 = A05(i2);
                if (A0u[7].length() != 16) {
                    String[] strArr = A0u;
                    strArr[1] = "fMu5gmFUMMjyE5zZcj2yfEtnORci9Tka";
                    strArr[0] = "H9jO6y53WPcXDhmRgvdqczqosoX1IojD";
                    icA05.A0e = str;
                    return;
                }
                throw new RuntimeException();
            case 2274716:
                A05(i2).A0o = str;
                return;
            default:
                return;
        }
    }

    public final boolean A0Y(int i2) {
        if (i2 != 357149030 && i2 != 524531317) {
            String[] strArr = A0u;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0u;
            strArr2[5] = "AFdTkHzIX2";
            strArr2[6] = "QjCHXWDM6RodCI1HM4Zn3pBBf";
            if (i2 != 475249515 && i2 != 374648427) {
                return false;
            }
        }
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A0S = gy;
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0027 */
    @Override // com.instagram.common.viewpoint.core.GX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int AGb(com.instagram.common.viewpoint.core.InterfaceC1943lN r5, com.instagram.common.viewpoint.core.C0781Gt r6) throws java.io.IOException {
        /*
            r4 = this;
            r3 = 0
            r4.A0X = r3
            r2 = 1
        L4:
            if (r2 == 0) goto L1e
            boolean r0 = r4.A0X
            if (r0 != 0) goto L1e
            com.facebook.ads.redexgen.X.I9 r0 = r4.A0q
            boolean r2 = r0.AGe(r5)
            if (r2 == 0) goto L4
            long r0 = r5.A8f()
            boolean r0 = r4.A0L(r6, r0)
            if (r0 == 0) goto L4
            r0 = 1
            return r0
        L1e:
            if (r2 != 0) goto L3c
            r1 = 0
        L21:
            android.util.SparseArray<com.facebook.ads.redexgen.X.IC> r0 = r4.A0P
            int r0 = r0.size()
            if (r1 >= r0) goto L3a
            android.util.SparseArray<com.facebook.ads.redexgen.X.IC> r0 = r4.A0P
            java.lang.Object r0 = r0.valueAt(r1)
            com.facebook.ads.redexgen.X.IC r0 = (com.instagram.common.viewpoint.core.IC) r0
            com.instagram.common.viewpoint.core.IC.A08(r0)
            r0.A0E()
            int r1 = r1 + 1
            goto L21
        L3a:
            r0 = -1
            return r0
        L3c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.AGb(com.facebook.ads.redexgen.X.lN, com.facebook.ads.redexgen.X.Gt):int");
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x001e */
    @Override // com.instagram.common.viewpoint.core.GX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AIM(long r3, long r5) {
        /*
            r2 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2.A0G = r0
            r0 = 0
            r2.A05 = r0
            com.facebook.ads.redexgen.X.I9 r0 = r2.A0q
            r0.reset()
            com.facebook.ads.redexgen.X.IE r0 = r2.A0r
            r0.A06()
            r2.A0A()
            r1 = 0
        L18:
            android.util.SparseArray<com.facebook.ads.redexgen.X.IC> r0 = r2.A0P
            int r0 = r0.size()
            if (r1 >= r0) goto L2e
            android.util.SparseArray<com.facebook.ads.redexgen.X.IC> r0 = r2.A0P
            java.lang.Object r0 = r0.valueAt(r1)
            com.facebook.ads.redexgen.X.IC r0 = (com.instagram.common.viewpoint.core.IC) r0
            r0.A0F()
            int r1 = r1 + 1
            goto L18
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor.AIM(long, long):void");
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        return new ID().A01(interfaceC1943lN);
    }
}
