package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2000mK implements InterfaceC0719Ej, CD {
    public static String[] A0E = {"SSDELygzudefytBtRYlDWoyFfpg", "4SEnazR2Nu4dPKZqq", "4H9jqKlT7lQdtxWBQl9xa6akogWkCWsp", "Wknx73gM1GoPE2GN1snRYal1oMjUwY3P", "7txELYcTJwThSLRxJ5dUM1K4qPQ", "gA7GGJKubAjwOro28", "9KdodW4K4GXGszeM7wnefptXiT4TjY3", ""};
    public long A00;
    public AnonymousClass56 A01;
    public H1 A02;
    public boolean A04;
    public final Uri A06;
    public final C3W A07;
    public final C05849b A08;
    public final InterfaceC0659Cb A09;
    public final GY A0A;
    public volatile boolean A0C;
    public final /* synthetic */ C9A A0D;
    public final C0781Gt A0B = new C0781Gt();
    public boolean A03 = true;
    public final long A05 = CE.A00();

    public C2000mK(C9A c9a, Uri uri, InterfaceC2089nl interfaceC2089nl, InterfaceC0659Cb interfaceC0659Cb, GY gy, C3W c3w) {
        this.A0D = c9a;
        this.A06 = uri;
        this.A08 = new C05849b(interfaceC2089nl);
        this.A09 = interfaceC0659Cb;
        this.A0A = gy;
        this.A07 = c3w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(long j, long j3) {
        this.A0B.A00 = j;
        this.A00 = j3;
        this.A03 = true;
        this.A04 = false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0719Ej
    public final void A4j() {
        this.A0C = true;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0719Ej
    public final void AAi() throws IOException {
        int iAGc = 0;
        while (iAGc == 0 && !this.A0C) {
            try {
                long j = this.A0B.A00;
                this.A01 = new AnonymousClass56(this.A06, j, -1L, this.A0D.A0b);
                long jAFy = this.A08.AFy(this.A01);
                if (jAFy != -1) {
                    jAFy += j;
                    this.A0D.A0G();
                }
                this.A0D.A09 = null;
                InterfaceC2089nl interfaceC2089nl = this.A08;
                if (this.A0D.A09 != null && this.A0D.A09.A01 != -1) {
                    final C05849b c05849b = this.A08;
                    final int i2 = this.A0D.A09.A01;
                    interfaceC2089nl = new InterfaceC2089nl(c05849b, i2, this) { // from class: com.facebook.ads.redexgen.X.9B
                        public int A00;
                        public final int A01;
                        public final InterfaceC2089nl A02;
                        public final CD A03;
                        public final byte[] A04;

                        {
                            C3M.A07(i2 > 0);
                            this.A02 = c05849b;
                            this.A01 = i2;
                            this.A03 = this;
                            this.A04 = new byte[1];
                            this.A00 = i2;
                        }

                        private boolean A00() throws IOException {
                            int bytesRead = this.A02.read(this.A04, 0, 1);
                            if (bytesRead == -1) {
                                return false;
                            }
                            int bytesRead2 = this.A04[0];
                            int metadataLength = (bytesRead2 & 255) << 4;
                            if (metadataLength == 0) {
                                return true;
                            }
                            int i8 = 0;
                            int i9 = metadataLength;
                            byte[] bArr = new byte[metadataLength];
                            while (i9 > 0) {
                                int bytesRead3 = this.A02.read(bArr, i8, i9);
                                if (bytesRead3 == -1) {
                                    return false;
                                }
                                i8 += bytesRead3;
                                i9 -= bytesRead3;
                            }
                            while (metadataLength > 0) {
                                int bytesRead4 = metadataLength - 1;
                                if (bArr[bytesRead4] != 0) {
                                    break;
                                }
                                metadataLength--;
                            }
                            if (metadataLength > 0) {
                                this.A03.ADR(new C4J(bArr, metadataLength));
                            }
                            return true;
                        }

                        @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                        public final void A3v(C5H c5h) {
                            C3M.A01(c5h);
                            this.A02.A3v(c5h);
                        }

                        @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                        public final Map<String, List<String>> A8l() {
                            return this.A02.A8l();
                        }

                        @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                        public final Uri A9H() {
                            return this.A02.A9H();
                        }

                        @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                        public final long AFy(AnonymousClass56 anonymousClass56) {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
                        public final void close() {
                            throw new UnsupportedOperationException();
                        }

                        @Override // com.instagram.common.viewpoint.core.AnonymousClass20
                        public final int read(byte[] bArr, int i8, int i9) throws IOException {
                            if (this.A00 == 0) {
                                if (!A00()) {
                                    return -1;
                                }
                                this.A00 = this.A01;
                            }
                            int i10 = this.A02.read(bArr, i8, Math.min(this.A00, i9));
                            if (i10 != -1) {
                                int bytesRead = this.A00;
                                this.A00 = bytesRead - i10;
                            }
                            return i10;
                        }
                    };
                    this.A02 = this.A0D.A0Z();
                    this.A02.A6W(C9A.A0g);
                }
                this.A09.AA3(interfaceC2089nl, this.A06, this.A08.A8l(), j, jAFy, this.A0A);
                if (this.A0D.A09 != null) {
                    this.A09.A5q();
                }
                if (this.A03) {
                    this.A09.AIM(j, this.A00);
                    this.A03 = false;
                }
                while (iAGc == 0 && !this.A0C) {
                    try {
                        this.A07.A00();
                        iAGc = this.A09.AGc(this.A0B);
                        long position = this.A09.A7S();
                        if (position > this.A0D.A0M + j) {
                            j = position;
                            this.A07.A02();
                            this.A0D.A0O.post(this.A0D.A0a);
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (iAGc == 1) {
                    iAGc = 0;
                } else {
                    long jA7S = this.A09.A7S();
                    String[] strArr = A0E;
                    if (strArr[2].charAt(24) != strArr[3].charAt(24)) {
                        throw new RuntimeException();
                    }
                    A0E[6] = "OKjnlHtv3KbBLefZQYMpPe9SdH47QI1";
                    if (jA7S != -1) {
                        this.A0B.A00 = this.A09.A7S();
                    }
                }
                AnonymousClass51.A00(this.A08);
            } catch (Throwable th) {
                if (iAGc != 1 && this.A09.A7S() != -1) {
                    this.A0B.A00 = this.A09.A7S();
                }
                AnonymousClass51.A00(this.A08);
                throw th;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.CD
    public final void ADR(C4J c4j) {
        long jMax;
        if (this.A04) {
            jMax = Math.max(this.A0D.A03(true), this.A00);
        } else {
            jMax = this.A00;
        }
        int iA07 = c4j.A07();
        H1 h12 = (H1) C3M.A01(this.A02);
        h12.AI7(c4j, iA07);
        h12.AIA(jMax, 1, iA07, 0, null);
        this.A04 = true;
    }
}
