package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import com.facebook.ads.androidx.media3.exoplayer.scheduler.Requirements;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BT {
    public static byte[] A0G;
    public static String[] A0H = {"pVyOFxmsQ66MTtm1tfRFfgviAXYtJVde", "2uUwIcomsi7SFa7PXkK2f37odc1wLlYz", "QkwYj4Lqiyfn1sjUd74ET1yWKOC2yQQp", "dFCgemChCTNfDzsLBkcDawIxAoCNtdjt", "sEgyiM3VxaELP8J5ElL8PsjgrXzRWZa", "oraRcW9NweHiYSV9WAd4vPrbGQ1KpHw2", "RucdtTHsidUdQvrsj3emf0t2ky4JUHkt", "bkvUCljONwekC27QIXEAtZgyfnOfNHe"};
    public static final Requirements A0I;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public C0654Bv A05;
    public List<B8> A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final Context A0A;
    public final Handler A0B;
    public final BQ A0C;
    public final InterfaceC2009mT A0D;
    public final InterfaceC0650Br A0E;
    public final CopyOnWriteArraySet<BS> A0F;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0H[0].charAt(31) != 'e') {
                throw new RuntimeException();
            }
            A0H[1] = "Q4q55Cq4Bi7IKuCSPoembBRK5ZQkCbyv";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            i10++;
        }
    }

    public static void A03() {
        A0G = new byte[]{34, 31, 8, 55, 11, 6, 30, 2, 21, 93, 35, 8, 16, 9, 11, 8, 6, 3, 42, 6, 9, 6, 0, 2, 21};
    }

    static {
        A03();
        A0I = new Requirements(1);
    }

    public BT(Context context, InterfaceC04784m interfaceC04784m, InterfaceC0904Ln interfaceC0904Ln, InterfaceC04884w interfaceC04884w, Executor executor) {
        this(context, new C9H(interfaceC04784m), new C2018mc(new C1807ix().A06(interfaceC0904Ln).A05(interfaceC04884w), executor));
    }

    public BT(Context context, InterfaceC2009mT interfaceC2009mT, InterfaceC0641Bh interfaceC0641Bh) {
        this.A0A = context.getApplicationContext();
        this.A0D = interfaceC2009mT;
        this.A01 = 3;
        this.A02 = 5;
        this.A07 = true;
        this.A06 = Collections.emptyList();
        this.A0F = new CopyOnWriteArraySet<>();
        Handler handlerA0b = AbstractC04664a.A0b(new Handler.Callback() { // from class: com.facebook.ads.redexgen.X.BM
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.A00.A0B(message);
            }
        });
        this.A0B = handlerA0b;
        HandlerThread handlerThread = new HandlerThread(A01(0, 25, 28));
        handlerThread.start();
        this.A0C = new BQ(handlerThread, interfaceC2009mT, interfaceC0641Bh, handlerA0b, this.A01, this.A02, this.A07);
        InterfaceC0650Br requirementsListener = new InterfaceC0650Br() { // from class: com.facebook.ads.redexgen.X.mb
            @Override // com.instagram.common.viewpoint.core.InterfaceC0650Br
            public final void AEz(C0654Bv c0654Bv, int i2) {
                this.A00.A07(c0654Bv, i2);
            }
        };
        this.A0E = requirementsListener;
        this.A05 = new C0654Bv(context, requirementsListener, A0I);
        this.A03 = this.A05.A09();
        this.A04 = 1;
        this.A0C.obtainMessage(0, this.A03, 0).sendToTarget();
    }

    public static B8 A00(B8 b8, DownloadRequest downloadRequest, int i2, long j) {
        long j3;
        int i8;
        int i9 = b8.A02;
        if (i9 == 5 || b8.A02()) {
            j3 = j;
        } else {
            j3 = b8.A05;
        }
        if (i9 == 5 || i9 == 7) {
            i8 = 7;
        } else if (i2 != 0) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        return new B8(b8.A07.A02(downloadRequest), i8, j3, j, -1L, i2, 0);
    }

    private void A02() {
        Iterator<BS> it = this.A0F.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0H[2].charAt(11) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[4] = "SmTtusU6hPZNCMRD5EytmTKQlQAuGgF";
            strArr[7] = "GYCdxmdyxLWQsNM7s6qdd5Bkhe8SJ7C";
            if (zHasNext) {
                BS listener = it.next();
                listener.AFv(this, this.A09);
            } else {
                return;
            }
        }
    }

    private void A04(int i2, int i8) {
        this.A04 -= i2;
        this.A00 = i8;
        if (A0I()) {
            Iterator<BS> it = this.A0F.iterator();
            while (it.hasNext()) {
                it.next().ADS(this);
            }
        }
    }

    private void A05(BO bo) {
        this.A06 = Collections.unmodifiableList(bo.A02);
        B8 b8 = bo.A00;
        boolean zA0A = A0A();
        if (bo.A03) {
            Iterator<BS> it = this.A0F.iterator();
            while (it.hasNext()) {
                it.next().AD4(this, b8);
            }
        } else {
            Iterator<BS> it2 = this.A0F.iterator();
            while (true) {
                boolean zHasNext = it2.hasNext();
                if (A0H[5].charAt(25) == 'r') {
                    throw new RuntimeException();
                }
                A0H[5] = "ysMk9cu0SrkjVTb8eZ5DX1SyqV41ya5j";
                if (!zHasNext) {
                    break;
                } else {
                    it2.next().AD3(this, b8, bo.A01);
                }
            }
        }
        if (zA0A) {
            A02();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C0654Bv c0654Bv, int i2) {
        Requirements requirementsA0A = c0654Bv.A0A();
        if (this.A03 != i2) {
            this.A03 = i2;
            this.A04++;
            this.A0C.obtainMessage(2, i2, 0).sendToTarget();
        }
        boolean zA0A = A0A();
        Iterator<BS> it = this.A0F.iterator();
        while (it.hasNext()) {
            it.next().AEy(this, requirementsA0A, i2);
        }
        if (zA0A) {
            A02();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(java.util.List<com.instagram.common.viewpoint.core.B8> r4) {
        /*
            r3 = this;
            r0 = 1
            r3.A08 = r0
            java.util.List r0 = java.util.Collections.unmodifiableList(r4)
            r3.A06 = r0
            boolean r2 = r3.A0A()
            java.util.concurrent.CopyOnWriteArraySet<com.facebook.ads.redexgen.X.BS> r0 = r3.A0F
            java.util.Iterator r1 = r0.iterator()
        L13:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L23
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.BS r0 = (com.instagram.common.viewpoint.core.BS) r0
            r0.ADX(r3)
            goto L13
        L23:
            if (r2 == 0) goto L28
            r3.A02()
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.BT.A08(java.util.List):void");
    }

    private void A09(boolean z2) {
        if (this.A07 == z2) {
            return;
        }
        this.A07 = z2;
        this.A04++;
        this.A0C.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
        boolean zA0A = A0A();
        Iterator<BS> it = this.A0F.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (zA0A) {
            A02();
        }
    }

    private boolean A0A() {
        boolean z2 = false;
        boolean waitingForRequirements = this.A07;
        if (!waitingForRequirements && this.A03 != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.A06.size()) {
                    break;
                }
                if (this.A06.get(i2).A02 == 0) {
                    z2 = true;
                    break;
                }
                i2++;
            }
        }
        boolean waitingForRequirements2 = this.A09;
        boolean z7 = waitingForRequirements2 != z2;
        this.A09 = z2;
        String[] strArr = A0H;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0H;
        strArr2[4] = "HT4e9GATQ3DYWsFwZyJzXpwOkn6HfQP";
        strArr2[7] = "eDZDx6DsGZ1y85uRp2IzKIBDtNa9GCG";
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0B(Message message) {
        switch (message.what) {
            case 0:
                A08((List) message.obj);
                return true;
            case 1:
                int i2 = message.arg1;
                int i8 = message.arg2;
                if (A0H[2].charAt(11) == 'k') {
                    throw new RuntimeException();
                }
                String[] strArr = A0H;
                strArr[3] = "sxyw1qPQ7JLPTOY8e9sgs42WDZnpuN2t";
                strArr[6] = "KeBMIxstq15Te8zzUw5dJy9ueqCuctUt";
                A04(i2, i8);
                return true;
            case 2:
                BO update = (BO) message.obj;
                A05(update);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public final List<B8> A0D() {
        return this.A06;
    }

    public final void A0E() {
        A09(false);
    }

    public final void A0F(BS bs) {
        C3M.A01(bs);
        this.A0F.add(bs);
    }

    public final void A0G(DownloadRequest downloadRequest) {
        A0H(downloadRequest, 0);
    }

    public final void A0H(DownloadRequest downloadRequest, int i2) {
        this.A04++;
        this.A0C.obtainMessage(6, i2, 0, downloadRequest).sendToTarget();
    }

    public final boolean A0I() {
        return this.A00 == 0 && this.A04 == 0;
    }
}
