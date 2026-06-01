package com.instagram.common.viewpoint.core;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2038mw implements C8N {
    public static boolean A0v;
    public static int A0w;
    public static ExecutorService A0x;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D23918943: Monitor the audio track usage")
    public static AtomicInteger A0y;
    public static byte[] A0z;
    public static String[] A10 = {"a2KSouRkY2EeYPYlRPuQP1BMARpp6f9O", "Gy", "Dq9VRycV95bIzONst7U9W8VcH5OAT2ac", "T381mgHUGlQbTRbVURm4ZuRF6EOi2D8f", "KkGB0jhfpK5IC", "ogTnlK5ViGnrQ4kTUDUA61bIZynBq2mv", "CJ3ZuNqxaIjwSiQAD7ytgom2H57haWJk", "spWmv2H5WGO5MG6CASCqBbohd0yqIF8X"};
    public static final Object A11;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public AudioTrack A0D;
    public C2160oy A0E;
    public C1P A0F;
    public C2138ob A0G;
    public C05567m A0H;
    public C8J A0I;
    public C05698c A0J;
    public C05718f A0K;
    public C05718f A0L;
    public C05738h A0M;
    public C05738h A0N;
    public C05778n A0O;
    public ByteBuffer A0P;
    public ByteBuffer A0Q;
    public ByteBuffer A0R;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public AnonymousClass38[] A0d;
    public ByteBuffer[] A0e;
    public final int A0f;
    public final AnonymousClass39 A0g;
    public final C3W A0h;
    public final InterfaceC05125u A0i;
    public final C05597p A0j;
    public final C8T A0k;
    public final C9N A0l;
    public final InterfaceC05708d A0m;
    public final C8k<C8H> A0n;
    public final C8k<C8M> A0o;
    public final C9I A0p;
    public final ArrayDeque<C05738h> A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final AnonymousClass38[] A0t;
    public final AnonymousClass38[] A0u;

    public static String A0L(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0z, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0T() {
        A0z = new byte[]{99, 106, 44, 37, 56, 112, 106, 107, 74, 73, 78, 90, 67, 91, 110, 90, 75, 70, 64, 124, 70, 65, 68, 104, 85, 66, 125, 65, 76, 84, 72, 95, 23, 108, 88, 73, 68, 66, 121, 95, 76, 78, 70, 127, 72, 65, 72, 76, 94, 72, 121, 69, 95, 72, 76, 73, 39, 0, 8, 13, 4, 5, 65, 21, 14, 65, 18, 4, 21, 65, 17, 13, 0, 24, 3, 0, 2, 10, 65, 17, 0, 19, 0, 12, 18, 121, 94, 70, 81, 92, 89, 84, 16, 96, 115, 125, 16, 85, 94, 83, 95, 84, 89, 94, 87, 10, 16, 73, 110, 118, 97, 108, 105, 100, 32, 111, 117, 116, 112, 117, 116, 32, 99, 104, 97, 110, 110, 101, 108, 32, 99, 111, 110, 102, 105, 103, 32, 40, 109, 111, 100, 101, 61, 57, 30, 6, 17, 28, 25, 20, 80, 31, 5, 4, 0, 5, 4, 80, 21, 30, 19, 31, 20, 25, 30, 23, 80, 88, 29, 31, 20, 21, 77, 33, 24, 9, 20, 29, 104, 95, 73, 95, 78, 78, 83, 84, 93, 26, 73, 78, 91, 86, 86, 95, 94, 26, 91, 79, 94, 83, 85, 26, 78, 72, 91, 89, 81, 117, 78, 65, 66, 76, 69, 0, 84, 79, 0, 67, 79, 78, 70, 73, 71, 85, 82, 69, 0, 80, 65, 83, 83, 84, 72, 82, 79, 85, 71, 72, 0, 70, 79, 82, 26, 0, 124, 71, 76, 81, 89, 76, 74, 93, 76, 77, 9, 72, 92, 77, 64, 70, 9, 76, 71, 74, 70, 77, 64, 71, 78, 19, 9, 31, 11, 26, 23, 17, 81, 12, 31, 9};
    }

    static {
        A0T();
        A0v = false;
        A11 = new Object();
        A0y = new AtomicInteger(0);
    }

    @Deprecated
    public C2038mw(C05597p c05597p, AnonymousClass38[] anonymousClass38Arr) {
        this(new C8e().A06((C05597p) AbstractC1811j1.A00(c05597p, C05597p.A04)).A07(anonymousClass38Arr));
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    public C2038mw(C8e c8e) {
        int i2;
        this.A0j = c8e.A03;
        this.A0g = c8e.A02;
        this.A0s = AbstractC04664a.A02 >= 21 && c8e.A05;
        this.A0r = AbstractC04664a.A02 >= 23 && c8e.A04;
        if (AbstractC04664a.A02 >= 29) {
            i2 = c8e.A01;
        } else {
            i2 = 0;
        }
        this.A0f = i2;
        this.A0m = c8e.A00;
        this.A0h = new C3W(C3T.A00);
        this.A0h.A04();
        this.A0k = new C8T(new C2039mx(this));
        this.A0l = new C9N();
        this.A0p = new C9I();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new AbstractC2040my() { // from class: com.facebook.ads.redexgen.X.9K
            public static String[] A00 = {"xDq4aPrtB4VOa6dWWLPhCvkNe2Vl9lis", "EsfqB3zUW", "UtEiT2kwdPvCqjHQhdRb9TlQndFxkub5", "Wgbe7hD6UIy", "xb", "RmqoPGkQn7vPyUpVU7ZkSehlX2jVBNRl", "20c7QZBscERNsZTH", "LeRFFk0E0DkpEnw35dU8lGRVd8w5nI17"};

            @Override // com.instagram.common.viewpoint.core.AbstractC2040my
            public final AnonymousClass36 A09(AnonymousClass36 anonymousClass36) throws AnonymousClass37 {
                int i8 = anonymousClass36.A02;
                if (i8 != 3 && i8 != 2) {
                    if (A00[2].charAt(30) != 'b') {
                        throw new RuntimeException();
                    }
                    A00[3] = "ty1ASCrQyl5";
                    if (i8 != 268435456 && i8 != 536870912 && i8 != 805306368 && i8 != 4) {
                        throw new AnonymousClass37(anonymousClass36);
                    }
                }
                if (i8 != 2) {
                    return new AnonymousClass36(anonymousClass36.A03, anonymousClass36.A01, 2);
                }
                return AnonymousClass36.A05;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
            @Override // com.instagram.common.viewpoint.core.AnonymousClass38
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void AGX(java.nio.ByteBuffer r7) {
                /*
                    Method dump skipped, instruction units count: 258
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9K.AGX(java.nio.ByteBuffer):void");
            }
        }, this.A0l, this.A0p);
        Collections.addAll(arrayList, this.A0g.A6r());
        this.A0u = (AnonymousClass38[]) arrayList.toArray(new AnonymousClass38[0]);
        this.A0t = new AnonymousClass38[]{new AbstractC2040my() { // from class: com.facebook.ads.redexgen.X.9L
            public static final int A00 = Float.floatToIntBits(Float.NaN);

            public static void A00(int i8, ByteBuffer byteBuffer) {
                float pcm32BitFloat = (float) (((double) i8) * 4.656612875245797E-10d);
                int floatBits = Float.floatToIntBits(pcm32BitFloat);
                if (floatBits == A00) {
                    floatBits = Float.floatToIntBits(0.0f);
                }
                byteBuffer.putInt(floatBits);
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC2040my
            public final AnonymousClass36 A09(AnonymousClass36 anonymousClass36) throws AnonymousClass37 {
                int i8 = anonymousClass36.A02;
                if (AbstractC04664a.A14(i8)) {
                    if (i8 != 4) {
                        return new AnonymousClass36(anonymousClass36.A03, anonymousClass36.A01, 4);
                    }
                    return AnonymousClass36.A05;
                }
                throw new AnonymousClass37(anonymousClass36);
            }

            @Override // com.instagram.common.viewpoint.core.AnonymousClass38
            public final void AGX(ByteBuffer byteBuffer) {
                ByteBuffer byteBufferA00;
                int i8 = byteBuffer.position();
                int iLimit = byteBuffer.limit();
                int limit = iLimit - i8;
                int position = this.A05.A02;
                switch (position) {
                    case 536870912:
                        int position2 = limit / 3;
                        byteBufferA00 = A00(position2 * 4);
                        while (i8 < iLimit) {
                            int position3 = byteBuffer.get(i8);
                            int limit2 = (position3 & 255) << 8;
                            int position4 = i8 + 1;
                            int limit3 = limit2 | ((byteBuffer.get(position4) & 255) << 16);
                            int position5 = i8 + 2;
                            A00(limit3 | ((byteBuffer.get(position5) & 255) << 24), byteBufferA00);
                            i8 += 3;
                        }
                        break;
                    case 805306368:
                        byteBufferA00 = A00(limit);
                        while (i8 < iLimit) {
                            int position6 = byteBuffer.get(i8);
                            int limit4 = position6 & 255;
                            int position7 = i8 + 1;
                            int limit5 = limit4 | ((byteBuffer.get(position7) & 255) << 8);
                            int position8 = i8 + 2;
                            int limit6 = limit5 | ((byteBuffer.get(position8) & 255) << 16);
                            int position9 = i8 + 3;
                            A00(limit6 | ((byteBuffer.get(position9) & 255) << 24), byteBufferA00);
                            i8 += 4;
                        }
                        break;
                    default:
                        throw new IllegalStateException();
                }
                int position10 = byteBuffer.limit();
                byteBuffer.position(position10);
                byteBufferA00.flip();
            }
        }};
        this.A00 = 1.0f;
        this.A0E = C2160oy.A07;
        this.A01 = 0;
        this.A0F = new C1P(0, 0.0f);
        this.A0N = new C05738h(C2138ob.A06, false, 0L, 0L);
        this.A0G = C2138ob.A06;
        this.A03 = -1;
        this.A0d = new AnonymousClass38[0];
        this.A0e = new ByteBuffer[0];
        this.A0q = new ArrayDeque<>();
        this.A0n = new C8k<>(100L);
        this.A0o = new C8k<>(100L);
        this.A0i = null;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D58560720: customized audio track retry logic. Feature is available upstream already")
    private int A00() {
        if (MetaExoPlayerUpgradeConfig.A03(EnumC1753i2.A1i)) {
            return A01(this.A0K.A06, this.A0K.A02, this.A0K.A03);
        }
        return 1000000;
    }

    public static int A01(int i2, int i8, int i9) {
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i8, i9);
        C3M.A08(minBufferSize != -2);
        return minBufferSize;
    }

    public static int A02(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return GF.A03(byteBuffer);
            case 7:
            case 8:
                int headerDataInBigEndian = GV.A00(byteBuffer);
                return headerDataInBigEndian;
            case 9:
                int headerDataInBigEndian2 = AbstractC04664a.A0F(byteBuffer, byteBuffer.position());
                int headerDataInBigEndian3 = AbstractC0774Gm.A01(headerDataInBigEndian2);
                if (headerDataInBigEndian3 != -1) {
                    return headerDataInBigEndian3;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException(A0L(244, 27, 17) + i2);
            case 14:
                int syncframeOffset = GF.A02(byteBuffer);
                if (syncframeOffset == -1) {
                    return 0;
                }
                return GF.A04(byteBuffer, syncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return GI.A01(byteBuffer);
            case 20:
                return AbstractC0779Gr.A00(byteBuffer);
        }
    }

    private int A03(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        if (AbstractC04664a.A02 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return 0;
        }
        if (AbstractC04664a.A02 != 30) {
            return 1;
        }
        String str = AbstractC04664a.A06;
        String[] strArr = A10;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        A10[7] = "3tkRuQxdBcZlCTwsgu7cjpWlPYr81dQa";
        if (!str.startsWith(A0L(173, 5, 73))) {
            return 1;
        }
        if (A10[7].length() != 32) {
            return 2;
        }
        A10[7] = "7yaDe65lYY86qlvGhmsANLPH6jvNYU2p";
        return 2;
    }

    public static int A04(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int A05(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j) {
        if (AbstractC04664a.A02 >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j * 1000);
        }
        if (this.A0P == null) {
            this.A0P = ByteBuffer.allocate(16);
            this.A0P.order(ByteOrder.BIG_ENDIAN);
            this.A0P.putInt(1431633921);
        }
        if (this.A02 == 0) {
            this.A0P.putInt(4, i2);
            this.A0P.putLong(8, 1000 * j);
            this.A0P.position(0);
            this.A02 = i2;
        }
        int result = this.A0P.remaining();
        if (result > 0) {
            int avSyncHeaderBytesRemaining = audioTrack.write(this.A0P, result, 1);
            if (avSyncHeaderBytesRemaining < 0) {
                this.A02 = 0;
                return avSyncHeaderBytesRemaining;
            }
            if (avSyncHeaderBytesRemaining < result) {
                return 0;
            }
        }
        int iA04 = A04(audioTrack, byteBuffer, i2);
        if (iA04 < 0) {
            this.A02 = 0;
            return iA04;
        }
        int i8 = this.A02 - iA04;
        String[] strArr = A10;
        if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
            throw new RuntimeException();
        }
        A10[7] = "dZEIQVBMkpJ01dOsE3P3AYpi9pP3UgAn";
        this.A02 = i8;
        return iA04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A06() {
        if (this.A0K.A04 == 0) {
            long j = this.A0A;
            if (A10[1].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[2] = "fKroUyDCoriQZ27MdWvBeynNHxXh31S0";
            strArr[6] = "V2Tsqcz9Ivj1DWTn2T33JaE9HhmQCs1A";
            return j / ((long) this.A0K.A01);
        }
        return this.A09;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A07() {
        if (this.A0K.A04 == 0) {
            return this.A0C / ((long) this.A0K.A05);
        }
        return this.A0B;
    }

    private long A08(long j) {
        while (!this.A0q.isEmpty() && j >= this.A0q.getFirst().A00) {
            C05738h c05738hRemove = this.A0q.remove();
            String[] strArr = A10;
            if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
                throw new RuntimeException();
            }
            A10[7] = "uS5QwbhdMNBXkjn1i9eeeV7Jy2FKd79B";
            this.A0N = c05738hRemove;
        }
        long j3 = j - this.A0N.A00;
        if (this.A0N.A02.equals(C2138ob.A06)) {
            return this.A0N.A01 + j3;
        }
        if (this.A0q.isEmpty()) {
            long mediaDurationSinceLastCheckpointUs = this.A0g.A8M(j3);
            long playoutDurationSinceLastCheckpointUs = this.A0N.A01;
            return playoutDurationSinceLastCheckpointUs + mediaDurationSinceLastCheckpointUs;
        }
        C05738h first = this.A0q.getFirst();
        long jA0Q = AbstractC04664a.A0Q(first.A00 - j, this.A0N.A02.A01);
        long playoutDurationSinceLastCheckpointUs2 = first.A01;
        return playoutDurationSinceLastCheckpointUs2 - jA0Q;
    }

    private long A09(long j) {
        return this.A0K.A08(this.A0g.A90()) + j;
    }

    public static AudioFormat A0D(int i2, int i8, int i9) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i8).setEncoding(i9).build();
    }

    private AudioTrack A0F() throws C8H {
        try {
            return A0G((C05718f) C3M.A01(this.A0K));
        } catch (C8H e) {
            int retryBufferSize = A00();
            if (this.A0K.A00 > retryBufferSize) {
                C05718f c05718fA0C = this.A0K.A0C(retryBufferSize);
                try {
                    AudioTrack audioTrackA0G = A0G(c05718fA0C);
                    this.A0K = c05718fA0C;
                    return audioTrackA0G;
                } catch (C8H initialFailure) {
                    e.addSuppressed(initialFailure);
                    A0O();
                    throw e;
                }
            }
            A0O();
            throw e;
        }
    }

    private AudioTrack A0G(C05718f c05718f) throws C8H {
        try {
            AudioTrack audioTrackA0A = c05718f.A0A(this.A0b, this.A0E, this.A01);
            if (0 != 0) {
                A0l(audioTrackA0A);
            }
            return audioTrackA0A;
        } catch (C8H e) {
            if (this.A0I != null) {
                this.A0I.ACV(e);
            }
            throw e;
        }
    }

    private C2138ob A0I() {
        return A0K().A02;
    }

    private C05738h A0K() {
        if (this.A0M != null) {
            return this.A0M;
        }
        if (!this.A0q.isEmpty()) {
            return this.A0q.getLast();
        }
        return this.A0N;
    }

    public static /* synthetic */ AtomicInteger A0M() {
        AtomicInteger atomicInteger = A0y;
        if (A10[4].length() == 6) {
            throw new RuntimeException();
        }
        A10[7] = "bxvwh9PGR3JBxYGaTMYcQ8NcsphLXH3B";
        return atomicInteger;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0N() {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.38[] r0 = r3.A0d
            int r0 = r0.length
            if (r2 >= r0) goto L18
            com.facebook.ads.redexgen.X.38[] r0 = r3.A0d
            r0 = r0[r2]
            r0.flush()
            java.nio.ByteBuffer[] r1 = r3.A0e
            java.nio.ByteBuffer r0 = r0.A8V()
            r1[r2] = r0
            int r2 = r2 + 1
            goto L1
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2038mw.A0N():void");
    }

    private void A0O() {
        if (this.A0K.A0D()) {
            if (A10[1].length() != 2) {
                throw new RuntimeException();
            }
            A10[5] = "ac1bNzRzCepoXog5xkGE2UP5sVZPG6ZN";
            this.A0W = true;
        }
    }

    private void A0P() {
        if (!this.A0a) {
            this.A0a = true;
            this.A0k.A0H(A07());
            this.A0D.stop();
            this.A02 = 0;
        }
    }

    private void A0Q() {
        this.A0A = 0L;
        this.A09 = 0L;
        this.A0C = 0L;
        this.A0B = 0L;
        this.A0V = false;
        this.A04 = 0;
        this.A0N = new C05738h(A0I(), A0p(), 0L, 0L);
        this.A08 = 0L;
        this.A0M = null;
        this.A0q.clear();
        this.A0Q = null;
        this.A05 = 0;
        this.A0R = null;
        this.A0a = false;
        this.A0U = false;
        this.A03 = -1;
        this.A0P = null;
        this.A02 = 0;
        this.A0p.A0D();
        A0N();
    }

    private void A0R() {
        if (!A0h()) {
            return;
        }
        if (AbstractC04664a.A02 >= 21) {
            A0X(this.A0D, this.A00);
        } else {
            A0Y(this.A0D, this.A00);
        }
    }

    private void A0S() {
        AnonymousClass38[] anonymousClass38Arr = this.A0K.A09;
        ArrayList arrayList = new ArrayList();
        for (AnonymousClass38 anonymousClass38 : anonymousClass38Arr) {
            if (anonymousClass38.AAC()) {
                arrayList.add(anonymousClass38);
            } else {
                anonymousClass38.flush();
            }
        }
        int size = arrayList.size();
        AnonymousClass38[] audioProcessors = new AnonymousClass38[size];
        this.A0d = (AnonymousClass38[]) arrayList.toArray(audioProcessors);
        this.A0e = new ByteBuffer[size];
        A0N();
    }

    private void A0U(long j) {
        C2138ob c2138obA47;
        boolean zA48;
        if (A0i()) {
            c2138obA47 = this.A0g.A47(A0I());
        } else {
            c2138obA47 = C2138ob.A06;
            if (A10[7].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A10;
            strArr[0] = "I2oaxDVd9h4oXXSjJqrHfFArwnmkYbuU";
            strArr[3] = "djNSsSrQ9W3py9jFqud3MNGsNXIKPv6H";
        }
        if (A0i()) {
            zA48 = this.A0g.A48(A0p());
        } else {
            zA48 = false;
        }
        this.A0q.add(new C05738h(c2138obA47, zA48, Math.max(0L, j), this.A0K.A08(A07())));
        A0S();
        if (this.A0I != null) {
            this.A0I.AFF(zA48);
        }
    }

    private void A0V(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.A0d.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                ByteBuffer[] byteBufferArr = this.A0e;
                int i8 = i2 - 1;
                String[] strArr = A10;
                String str = strArr[0];
                String str2 = strArr[3];
                int index = str.charAt(31);
                int count = str2.charAt(31);
                if (index == count) {
                    throw new RuntimeException();
                }
                A10[1] = "0P";
                byteBuffer = byteBufferArr[i8];
            } else {
                byteBuffer = this.A0Q != null ? this.A0Q : AnonymousClass38.A00;
            }
            if (i2 == length) {
                A0e(byteBuffer, j);
            } else {
                AnonymousClass38 anonymousClass38 = this.A0d[i2];
                int index2 = this.A03;
                if (i2 > index2) {
                    anonymousClass38.AGX(byteBuffer);
                }
                ByteBuffer byteBufferA8V = anonymousClass38.A8V();
                this.A0e[i2] = byteBufferA8V;
                if (byteBufferA8V.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    private void A0W(AudioTrack audioTrack) {
        if (this.A0O == null) {
            this.A0O = new C05778n(this);
        }
        C05778n c05778n = this.A0O;
        String[] strArr = A10;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        A10[7] = "8t8nFWsxRl9HTQxqXeO3m9pm7diLrI9Q";
        c05778n.A00(audioTrack);
    }

    public static void A0X(AudioTrack audioTrack, float f4) {
        audioTrack.setVolume(f4);
    }

    public static void A0Y(AudioTrack audioTrack, float f4) {
        audioTrack.setStereoVolume(f4, f4);
    }

    private void A0Z(final AudioTrack audioTrack, final C3W c3w, final C8J c8j, final C8F c8f) {
        c3w.A02();
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (A11) {
            if (A0x == null) {
                A0x = AbstractC04664a.A0u(A0L(23, 33, 21));
            }
            A0w++;
            A0x.execute(new Runnable() { // from class: com.facebook.ads.redexgen.X.8Y
                @Override // java.lang.Runnable
                public final void run() {
                    C2038mw.A0a(audioTrack, c8j, handler, c8f, c3w);
                }
            });
        }
    }

    public static /* synthetic */ void A0a(AudioTrack audioTrack, final C8J c8j, Handler handler, final C8F c8f, C3W c3w) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (c8j != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.8X
                    @Override // java.lang.Runnable
                    public final void run() {
                        c8j.ACX(c8f);
                    }
                });
            }
            c3w.A04();
            synchronized (A11) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
            }
        } catch (Throwable th) {
            if (c8j != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.8X
                    @Override // java.lang.Runnable
                    public final void run() {
                        c8j.ACX(c8f);
                    }
                });
            }
            c3w.A04();
            synchronized (A11) {
                A0w--;
                if (A0w == 0) {
                    A0x.shutdown();
                    A0x = null;
                }
                throw th;
            }
        }
    }

    private void A0b(C2138ob c2138ob) {
        if (A0h()) {
            try {
                this.A0D.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(c2138ob.A01).setPitch(c2138ob.A00).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                AnonymousClass44.A0A(A0L(7, 16, 23), A0L(56, 29, 89), e);
            }
            PlaybackParams playbackParams = this.A0D.getPlaybackParams();
            float speed = playbackParams.getSpeed();
            PlaybackParams playbackParams2 = this.A0D.getPlaybackParams();
            c2138ob = new C2138ob(speed, playbackParams2.getPitch());
            this.A0k.A0G(c2138ob.A01);
        }
        this.A0G = c2138ob;
    }

    private void A0c(C2138ob c2138ob, boolean z2) {
        C05738h c05738hA0K = A0K();
        if (!c2138ob.equals(c05738hA0K.A02) || z2 != c05738hA0K.A03) {
            C05738h mediaPositionParameters = new C05738h(c2138ob, z2, -9223372036854775807L, -9223372036854775807L);
            if (A0h()) {
                this.A0M = mediaPositionParameters;
            } else {
                this.A0N = mediaPositionParameters;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0e(java.nio.ByteBuffer r13, long r14) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2038mw.A0e(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8.A0R != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        if (r8.A0R != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0f() throws java.lang.Exception {
        /*
            r8 = this;
            r7 = 0
            int r0 = r8.A03
            r4 = 0
            r3 = -1
            if (r0 != r3) goto La
            r8.A03 = r4
            r7 = 1
        La:
            int r5 = r8.A03
            com.facebook.ads.redexgen.X.38[] r0 = r8.A0d
            int r0 = r0.length
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r5 >= r0) goto L59
            com.facebook.ads.redexgen.X.38[] r5 = r8.A0d
            int r0 = r8.A03
            r0 = r5[r0]
            if (r7 == 0) goto L22
            r0.AGW()
        L22:
            r8.A0V(r1)
            boolean r5 = r0.AAG()
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2038mw.A10
            r0 = 0
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 31
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2038mw.A10
            java.lang.String r1 = "SZlzkFrjT9RrDQln4ds2mG9At4QQTsjU"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "7YjBVNvSPjH845plY2W9SI0PPB4m8Pgz"
            r0 = 3
            r2[r0] = r1
            if (r5 != 0) goto L4c
            return r4
        L4c:
            r7 = 1
            int r0 = r8.A03
            int r0 = r0 + r6
            r8.A03 = r0
            goto La
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L59:
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
            java.nio.ByteBuffer r0 = r8.A0R
            r8.A0e(r0, r1)
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2038mw.A10
            r0 = 2
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7b
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
        L7a:
            return r4
        L7b:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2038mw.A10
            java.lang.String r1 = "ih"
            r0 = 1
            r2[r0] = r1
            java.nio.ByteBuffer r0 = r8.A0R
            if (r0 == 0) goto L87
            goto L7a
        L87:
            r8.A03 = r3
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2038mw.A0f():boolean");
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes; Upstream has this feature")
    private boolean A0g() throws C8H {
        if (!this.A0h.A03()) {
            return false;
        }
        this.A0D = this.A0S ? A0F() : A0G(this.A0K);
        String[] strArr = A10;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A10;
        strArr2[2] = "dWhjJD4ryPYmrGCHimoCOlqhHDAwt6Vc";
        strArr2[6] = "fifoJCnFOIc3PbrGHGLYECSFH4AKcCFA";
        if (A0l(this.A0D)) {
            A0W(this.A0D);
            if (this.A0f != 3) {
                this.A0D.setOffloadDelayPadding(this.A0K.A07.A08, this.A0K.A07.A09);
            }
        }
        if (AbstractC04664a.A02 >= 31 && this.A0H != null) {
            C05688b.A00(this.A0D, this.A0H);
        }
        this.A01 = this.A0D.getAudioSessionId();
        this.A0k.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        A0R();
        if (this.A0F.A01 != 0) {
            this.A0D.attachAuxEffect(this.A0F.A01);
            AudioTrack audioTrack = this.A0D;
            C1P c1p = this.A0F;
            if (A10[7].length() != 32) {
                audioTrack.setAuxEffectSendLevel(c1p.A00);
            } else {
                A10[7] = "RIRRfrrRSIs4t73WNQ17weV6jTByi7uZ";
                audioTrack.setAuxEffectSendLevel(c1p.A00);
            }
        }
        if (this.A0J != null && AbstractC04664a.A02 >= 23) {
            C8a.A00(this.A0D, this.A0J);
        }
        this.A0Y = true;
        if (this.A0I != null) {
            this.A0I.ACW(this.A0K.A0B());
        }
        return true;
    }

    private boolean A0h() {
        return this.A0D != null;
    }

    private boolean A0i() {
        if (!this.A0b) {
            if (A0L(271, 9, 70).equals(this.A0K.A07.A0W) && !A0j(this.A0K.A07.A0C)) {
                return true;
            }
        }
        return false;
    }

    private boolean A0j(int i2) {
        return this.A0s && AbstractC04664a.A14(i2);
    }

    public static boolean A0k(int i2) {
        return (AbstractC04664a.A02 >= 24 && i2 == -6) || i2 == -32;
    }

    public static boolean A0l(AudioTrack audioTrack) {
        return AbstractC04664a.A02 >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0m(com.instagram.common.viewpoint.core.C2154or r5, com.instagram.common.viewpoint.core.C2160oy r6) {
        /*
            r4 = this;
            int r1 = com.instagram.common.viewpoint.core.AbstractC04664a.A02
            r0 = 29
            r3 = 0
            if (r1 < r0) goto Lb
            int r0 = r4.A0f
            if (r0 != 0) goto Lc
        Lb:
            return r3
        Lc:
            java.lang.String r0 = r5.A0W
            java.lang.Object r1 = com.instagram.common.viewpoint.core.C3M.A01(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = r5.A0R
            int r2 = com.instagram.common.viewpoint.core.AbstractC04212h.A03(r1, r0)
            if (r2 != 0) goto L1d
            return r3
        L1d:
            int r0 = r5.A06
            int r1 = com.instagram.common.viewpoint.core.AbstractC04664a.A01(r0)
            if (r1 != 0) goto L26
            return r3
        L26:
            int r0 = r5.A0G
            android.media.AudioFormat r1 = A0D(r0, r1, r2)
            com.facebook.ads.redexgen.X.1N r0 = r6.A01()
            android.media.AudioAttributes r0 = r0.A00
            int r0 = r4.A03(r1, r0)
            r2 = 1
            switch(r0) {
                case 0: goto L59;
                case 1: goto L41;
                case 2: goto L40;
                default: goto L3a;
            }
        L3a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L40:
            return r2
        L41:
            int r0 = r5.A08
            if (r0 != 0) goto L49
            int r0 = r5.A09
            if (r0 == 0) goto L57
        L49:
            r1 = 1
        L4a:
            int r0 = r4.A0f
            if (r0 != r2) goto L55
            r0 = 1
        L4f:
            if (r1 == 0) goto L53
            if (r0 != 0) goto L54
        L53:
            r3 = 1
        L54:
            return r3
        L55:
            r0 = 0
            goto L4f
        L57:
            r1 = 0
            goto L4a
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2038mw.A0m(com.facebook.ads.redexgen.X.or, com.facebook.ads.redexgen.X.oy):boolean");
    }

    public final int A0o(C2154or c2154or) {
        if (!A0L(271, 9, 70).equals(c2154or.A0W)) {
            return ((this.A0W || !A0m(c2154or, this.A0E)) && !this.A0j.A0B(c2154or)) ? 0 : 2;
        }
        if (!AbstractC04664a.A15(c2154or.A0C)) {
            AnonymousClass44.A07(A0L(7, 16, 23), A0L(85, 22, 8) + c2154or.A0C);
            return 0;
        }
        int i2 = c2154or.A0C;
        if (A10[7].length() != 32) {
            throw new RuntimeException();
        }
        A10[1] = "pL";
        return (i2 == 2 || (this.A0s && c2154or.A0C == 4)) ? 2 : 1;
    }

    public final boolean A0p() {
        return A0K().A03;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void A51(C2154or c2154or, int i2, int[] iArr) throws C8G {
        int outputSampleRate;
        AnonymousClass38[] anonymousClass38Arr;
        int outputSampleRate2;
        int outputPcmFrameSize;
        int outputChannelConfig;
        int iIntValue;
        int outputEncoding;
        int outputMode = i2;
        int[] iArr2 = iArr;
        if (A0L(271, 9, 70).equals(c2154or.A0W)) {
            C3M.A07(AbstractC04664a.A15(c2154or.A0C));
            outputSampleRate = AbstractC04664a.A06(c2154or.A0C, c2154or.A06);
            if (A0j(c2154or.A0C)) {
                anonymousClass38Arr = this.A0t;
            } else {
                anonymousClass38Arr = this.A0u;
            }
            C9I c9i = this.A0p;
            int inputPcmFrameSize = c2154or.A08;
            c9i.A0E(inputPcmFrameSize, c2154or.A09);
            int inputPcmFrameSize2 = AbstractC04664a.A02;
            if (inputPcmFrameSize2 < 21) {
                int inputPcmFrameSize3 = c2154or.A06;
                if (inputPcmFrameSize3 == 8 && iArr2 == null) {
                    iArr2 = new int[6];
                    for (int inputPcmFrameSize4 = 0; inputPcmFrameSize4 < iArr2.length; inputPcmFrameSize4++) {
                        iArr2[inputPcmFrameSize4] = inputPcmFrameSize4;
                    }
                }
            }
            this.A0l.A0C(iArr2);
            int i8 = c2154or.A0G;
            int inputPcmFrameSize5 = c2154or.A06;
            AnonymousClass36 anonymousClass36 = new AnonymousClass36(i8, inputPcmFrameSize5, c2154or.A0C);
            for (AnonymousClass38 anonymousClass38 : anonymousClass38Arr) {
                try {
                    AnonymousClass36 anonymousClass36A4z = anonymousClass38.A4z(anonymousClass36);
                    if (anonymousClass38.AAC()) {
                        anonymousClass36 = anonymousClass36A4z;
                    }
                } catch (AnonymousClass37 e) {
                    throw new C8G(e, c2154or);
                }
            }
            outputChannelConfig = 0;
            iIntValue = anonymousClass36.A02;
            outputSampleRate2 = anonymousClass36.A03;
            outputEncoding = AbstractC04664a.A01(anonymousClass36.A01);
            outputPcmFrameSize = AbstractC04664a.A06(iIntValue, anonymousClass36.A01);
        } else {
            outputSampleRate = -1;
            anonymousClass38Arr = new AnonymousClass38[0];
            outputSampleRate2 = c2154or.A0G;
            outputPcmFrameSize = -1;
            if (A0m(c2154or, this.A0E)) {
                outputChannelConfig = 1;
                iIntValue = AbstractC04212h.A03((String) C3M.A01(c2154or.A0W), c2154or.A0R);
                outputEncoding = AbstractC04664a.A01(c2154or.A06);
            } else {
                outputChannelConfig = 2;
                if (A10[1].length() == 2) {
                    A10[5] = "lAbqtU1Up8pAGeHbeXVy9OX5EzAUCGx9";
                    Pair<Integer, Integer> pairA09 = this.A0j.A09(c2154or);
                    if (pairA09 != null) {
                        iIntValue = ((Integer) pairA09.first).intValue();
                        outputEncoding = ((Integer) pairA09.second).intValue();
                        if (A10[7].length() == 32) {
                            A10[1] = "Lw";
                        }
                    } else {
                        throw new C8G(A0L(207, 37, 24) + c2154or, c2154or);
                    }
                }
                throw new RuntimeException();
            }
        }
        String strA0L = A0L(0, 7, 114);
        if (iIntValue != 0) {
            if (outputEncoding != 0) {
                if (outputMode == 0) {
                    InterfaceC05708d interfaceC05708d = this.A0m;
                    int iA01 = A01(outputSampleRate2, outputEncoding, iIntValue);
                    int outputChannelConfig2 = outputPcmFrameSize != -1 ? outputPcmFrameSize : 1;
                    outputMode = interfaceC05708d.A6x(iA01, iIntValue, outputChannelConfig, outputChannelConfig2, outputSampleRate2, c2154or.A05, this.A0r ? 8.0d : 1.0d);
                }
                this.A0W = false;
                C05718f c05718f = new C05718f(c2154or, outputSampleRate, outputChannelConfig, outputPcmFrameSize, outputSampleRate2, outputEncoding, iIntValue, outputMode, anonymousClass38Arr, this.A0b);
                if (A0h()) {
                    this.A0L = c05718f;
                    return;
                } else {
                    this.A0K = c05718f;
                    return;
                }
            }
            throw new C8G(A0L(107, 36, 56) + outputChannelConfig + strA0L + c2154or, c2154or);
        }
        throw new C8G(A0L(143, 30, 72) + outputChannelConfig + strA0L + c2154or, c2154or);
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void A5r() {
        if (this.A0b) {
            this.A0b = false;
            flush();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void A6E() {
        C3M.A08(AbstractC04664a.A02 >= 21);
        C3M.A08(this.A0T);
        if (!this.A0b) {
            this.A0b = true;
            flush();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void A6L() {
        if (AbstractC04664a.A02 < 25) {
            flush();
            return;
        }
        this.A0o.A00();
        this.A0n.A00();
        if (!A0h()) {
            return;
        }
        A0Q();
        if (this.A0k.A0J()) {
            this.A0D.pause();
        }
        this.A0D.flush();
        this.A0k.A0E();
        this.A0k.A0I(this.A0D, this.A0K.A04 == 2, this.A0K.A03, this.A0K.A05, this.A0K.A00);
        this.A0Y = true;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final long A7X(boolean z2) {
        if (!A0h() || this.A0Y) {
            return Long.MIN_VALUE;
        }
        long jA0D = this.A0k.A0D(z2);
        C05718f c05718f = this.A0K;
        long positionUs = A07();
        return A09(A08(Math.min(jA0D, c05718f.A08(positionUs))));
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final C2138ob A8e() {
        if (this.A0r) {
            return this.A0G;
        }
        return A0I();
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final boolean A9W(ByteBuffer byteBuffer, final long adjustmentUs, int i2) throws Exception {
        C3M.A07(this.A0Q == null || byteBuffer == this.A0Q);
        if (this.A0L != null) {
            if (!A0f()) {
                return false;
            }
            if (this.A0L.A0E(this.A0K)) {
                this.A0K = this.A0L;
                this.A0L = null;
                if (A0l(this.A0D) && this.A0f != 3) {
                    if (this.A0D.getPlayState() == 3) {
                        this.A0D.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.A0D;
                    int i8 = this.A0K.A07.A08;
                    String[] strArr = A10;
                    if (strArr[0].charAt(31) != strArr[3].charAt(31)) {
                        String[] strArr2 = A10;
                        strArr2[0] = "jzTmuhmcT6oYK5lhq8C6QOSyUXF7wdwQ";
                        strArr2[3] = "cWMrj79Gd0zdSeVIzQJ8siz7G3nSjdgD";
                        audioTrack.setOffloadDelayPadding(i8, this.A0K.A07.A09);
                        this.A0V = true;
                    } else {
                        throw new RuntimeException();
                    }
                }
            } else {
                A0P();
                if (A9g()) {
                    return false;
                }
                flush();
            }
            A0U(adjustmentUs);
        }
        if (!A0h()) {
            try {
                if (!A0g()) {
                    return false;
                }
            } catch (C8H e) {
                if (!e.A02) {
                    this.A0n.A01(e);
                    return false;
                }
                throw e;
            }
        }
        this.A0n.A00();
        if (this.A0Y) {
            this.A08 = Math.max(0L, adjustmentUs);
            this.A0Z = false;
            this.A0Y = false;
            if (this.A0r && AbstractC04664a.A02 >= 23) {
                A0b(this.A0G);
            }
            A0U(adjustmentUs);
            if (this.A0X) {
                AGG();
            }
        }
        if (!this.A0k.A0N(A07())) {
            return false;
        }
        if (this.A0Q == null) {
            C3M.A07(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.A0K.A04 != 0 && this.A04 == 0) {
                this.A04 = A02(this.A0K.A03, byteBuffer);
                if (this.A04 == 0) {
                    return true;
                }
            }
            if (this.A0M != null) {
                if (!A0f()) {
                    return false;
                }
                A0U(adjustmentUs);
                this.A0M = null;
            }
            final long jA09 = this.A08 + this.A0K.A09(A06() - this.A0p.A0C());
            if (!this.A0Z && Math.abs(jA09 - adjustmentUs) > 200000) {
                if (this.A0I != null) {
                    this.A0I.ACV(new Exception(adjustmentUs, jA09) { // from class: com.facebook.ads.redexgen.X.8L
                        public static byte[] A02;
                        public final long A00;
                        public final long A01;

                        static {
                            A01();
                        }

                        public static String A00(int i9, int i10, int i11) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i9, i9 + i10);
                            for (int i12 = 0; i12 < bArrCopyOfRange.length; i12++) {
                                bArrCopyOfRange[i12] = (byte) ((bArrCopyOfRange[i12] - i11) - 106);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A01() {
                            A02 = new byte[]{-20, -32, 39, 47, 52, -32, 29, 54, 45, 64, 56, 45, 43, 60, 45, 44, -24, 41, 61, 44, 49, 55, -24, 60, 58, 41, 43, 51, -24, 60, 49, 53, 45, 59, 60, 41, 53, 56, -24, 44, 49, 59, 43, 55, 54, 60, 49, 54, 61, 49, 60, 65, 2, -24, 45, 64, 56, 45, 43, 60, 45, 44, -24};
                        }

                        {
                            super(A00(6, 57, 94) + jA09 + A00(0, 6, 86) + adjustmentUs);
                            this.A00 = adjustmentUs;
                            this.A01 = jA09;
                        }
                    });
                }
                this.A0Z = true;
            }
            if (this.A0Z) {
                if (!A0f()) {
                    return false;
                }
                long j = adjustmentUs - jA09;
                this.A08 += j;
                this.A0Z = false;
                A0U(adjustmentUs);
                if (this.A0I != null && j != 0) {
                    this.A0I.AEh();
                }
            }
            if (this.A0K.A04 == 0) {
                this.A0A += (long) byteBuffer.remaining();
            } else {
                this.A09 += ((long) this.A04) * ((long) i2);
            }
            this.A0Q = byteBuffer;
            this.A05 = i2;
        }
        A0V(adjustmentUs);
        if (!this.A0Q.hasRemaining()) {
            this.A0Q = null;
            this.A05 = 0;
            return true;
        }
        if (this.A0k.A0M(A07())) {
            AnonymousClass44.A07(A0L(7, 16, 23), A0L(178, 29, 2));
            flush();
            return true;
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void A9Z() {
        this.A0Z = true;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final boolean A9g() {
        return A0h() && this.A0k.A0L(A07());
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final boolean AAG() {
        return !A0h() || (this.A0U && !A9g());
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AGG() {
        this.A0X = true;
        if (A0h()) {
            this.A0k.A0F();
            this.A0D.play();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AGI() throws C8M {
        if (!this.A0U && A0h() && A0f()) {
            A0P();
            this.A0U = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIW(C2160oy c2160oy) {
        if (this.A0E.equals(c2160oy)) {
            return;
        }
        this.A0E = c2160oy;
        if (this.A0b) {
            return;
        }
        flush();
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIX(int i2) {
        if (this.A01 != i2) {
            this.A01 = i2;
            this.A0T = i2 != 0;
            flush();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIY(C1P c1p) {
        if (this.A0F.equals(c1p)) {
            return;
        }
        int i2 = c1p.A01;
        float f4 = c1p.A00;
        if (this.A0D != null) {
            int effectId = this.A0F.A01;
            if (effectId != i2) {
                AudioTrack audioTrack = this.A0D;
                if (A10[7].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A10;
                strArr[0] = "ejzMDVkCKjmiTtIYDMlHFxA2dL6L7Th4";
                strArr[3] = "3op87oKeQBz5MvPCbX5N1e1cWqib6LOP";
                audioTrack.attachAuxEffect(i2);
            }
            if (i2 != 0) {
                this.A0D.setAuxEffectSendLevel(f4);
            }
        }
        this.A0F = c1p;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D45157249: Retry Audio Track Init failure with less Audio track allocation sizes")
    public final void AIg(boolean z2) {
        this.A0S = z2;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIl(C8J c8j) {
        this.A0I = c8j;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIt(C2138ob c2138ob) {
        C2138ob c2138ob2 = new C2138ob(AbstractC04664a.A00(c2138ob.A01, 0.1f, 8.0f), AbstractC04664a.A00(c2138ob.A00, 0.1f, 8.0f));
        if (this.A0r) {
            int i2 = AbstractC04664a.A02;
            String[] strArr = A10;
            if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A10;
            strArr2[0] = "mNkMATimN2JlCwGmoqKrFKrIOPJhoNaC";
            strArr2[3] = "5L3Fdp27ixuu2nNAlcGmWXwucnCjA2b5";
            if (i2 >= 23) {
                A0b(c2138ob2);
                return;
            }
        }
        A0c(c2138ob2, A0p());
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIw(C05567m c05567m) {
        this.A0H = c05567m;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AIy(AudioDeviceInfo audioDeviceInfo) {
        this.A0J = audioDeviceInfo == null ? null : new C05698c(audioDeviceInfo);
        String[] strArr = A10;
        if (strArr[2].charAt(24) != strArr[6].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A10;
        strArr2[0] = "fdceU7wc4F7eltehFDuXboaWNHZsjBbo";
        strArr2[3] = "ndF9ePFUZlaV1XmuWN8y5PTJytJgMa2t";
        if (this.A0D != null) {
            C8a.A00(this.A0D, this.A0J);
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void AJ4(boolean z2) {
        A0c(A0I(), z2);
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final boolean AJc(C2154or c2154or) {
        return A0o(c2154or) != 0;
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    public final boolean AJe(int i2, int i8) {
        return AbstractC04664a.A15(i8) ? i8 != 4 || AbstractC04664a.A02 >= 21 : this.A0j != null && this.A0j.A0A(i8) && (i2 == -1 || i2 <= this.A0j.A08());
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void flush() {
        if (A0h()) {
            A0Q();
            if (this.A0k.A0J()) {
                this.A0D.pause();
            }
            boolean zA0l = A0l(this.A0D);
            if (A10[4].length() == 6) {
                throw new RuntimeException();
            }
            A10[5] = "i9Rinuw5ztOihCbMK36CN4CjOXT3DfRT";
            if (zA0l) {
                C05778n c05778n = this.A0O;
                if (A10[7].length() != 32) {
                    throw new RuntimeException();
                }
                A10[7] = "H3Tn5qbfAuT8Q6Ln8VWJEFxZf5lTeqqt";
                ((C05778n) C3M.A01(c05778n)).A01(this.A0D);
            }
            if (AbstractC04664a.A02 < 21 && !this.A0T) {
                this.A01 = 0;
            }
            C8F c8fA0B = this.A0K.A0B();
            if (this.A0L != null) {
                this.A0K = this.A0L;
                this.A0L = null;
            }
            this.A0k.A0E();
            A0Z(this.A0D, this.A0h, this.A0I, c8fA0B);
            this.A0D = null;
        }
        this.A0o.A00();
        this.A0n.A00();
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void pause() {
        this.A0X = false;
        if (A0h() && this.A0k.A0K()) {
            this.A0D.pause();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8N
    public final void setVolume(float f4) {
        if (this.A00 != f4) {
            this.A00 = f4;
            String[] strArr = A10;
            if (strArr[0].charAt(31) == strArr[3].charAt(31)) {
                throw new RuntimeException();
            }
            A10[5] = "E1Te023wTVVNappUuQixsG3bphOCE2I8";
            A0R();
        }
    }
}
