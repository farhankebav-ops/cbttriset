package com.instagram.common.viewpoint.core;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HandlerC0952Nk extends Handler {
    public static byte[] A09;
    public static String[] A0A = {"huWs6nyYMzfxZtpl5l", "fgwmKB6Qyc6FtxfQKB9IkKk97cCBhoPq", "Jv452jFQqMHbXRCew", "VJzjxvVEvnwAHRNG0UVfEBBm35lAgOcC", "2O55YLspBlua8aaDjHW6JYUsijhI69vr", "eg8WpOT66b5I3PrsSw6YGr9", "zIsMPTJraAXX1U7X8ddpQ67iDmaNCfrq", "78M1aKJi48odvK"};
    public Messenger A00;
    public InterfaceC1190Wv A01;
    public boolean A02;
    public final ServiceConnection A03;
    public final Handler A04;
    public final Messenger A05;
    public final LH A06;
    public final C1451cu A07;
    public final AbstractRunnableC1164Vt A08;

    public static String A05(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A09 = new byte[]{-102, -83, -85, -83, -79, -66, -83, -84, 104, -80, -87, -74, -84, -69, -80, -87, -77, -83, 104, -82, -87, -79, -76, -83, -84, 116, 104, -85, -73, -84, -83, -126, 104, -116, -115, -117, -104, -119, 122, 124, -124, 122, -128, 126, -104, 122, -123, -117, 126, 122, 125, -110, -104, 126, -111, -126, -116, -115, -116, -104, -124, 126, -110, 0, 1, -1, 12, -3, -18, -16, -8, -18, -12, -14, 12, -10, -5, 0, 1, -18, -7, -7, -14, -15, 12, -8, -14, 6, -28, -27, -29, -16, -31, -46, -44, -36, -46, -40, -42, -16, -36, -42, -22};
    }

    static {
        A06();
    }

    public HandlerC0952Nk(C1451cu c1451cu) {
        super(Looper.getMainLooper());
        this.A04 = new Handler(Looper.getMainLooper());
        this.A03 = new ServiceConnectionC0951Nj(this);
        this.A07 = c1451cu;
        this.A05 = new Messenger(this);
        LL funnelModule = c1451cu.A00(c1451cu);
        if (funnelModule != null) {
            this.A06 = funnelModule.ABn();
        } else {
            this.A06 = new C1813j3();
        }
        this.A08 = new C1688gp(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(Messenger messenger) {
        Message messageObtain = Message.obtain((Handler) null, 1);
        messageObtain.replyTo = this.A05;
        messageObtain.setData(AbstractC0961Nt.A00(this.A07));
        try {
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
        }
    }

    public final void A09() {
        if (this.A02) {
            this.A02 = false;
            this.A07.unbindService(this.A03);
            this.A00 = null;
        }
    }

    public final void A0A(String str, InterfaceC1190Wv interfaceC1190Wv, int i2) {
        if (this.A02) {
            this.A06.AHd(i2);
            this.A01 = interfaceC1190Wv;
            Message messageObtain = Message.obtain((Handler) null, i2);
            messageObtain.replyTo = this.A05;
            if (str != null) {
                Bundle bundle = new Bundle();
                bundle.putString(A05(88, 15, 88), str);
                messageObtain.setData(bundle);
            }
            try {
                if (this.A00 != null) {
                    this.A00.send(messageObtain);
                    return;
                }
                return;
            } catch (RemoteException e) {
                this.A06.AHe(e.toString());
                return;
            }
        }
        LH lh = this.A06;
        if (A0A[3].charAt(16) != '0') {
            throw new RuntimeException();
        }
        A0A[1] = "UrwnsONYHFKEsBm1tj1C3JCQoMa7O9rm";
        lh.AHf();
    }

    public final void A0B(boolean z2) {
        this.A06.AHa();
        this.A02 = C0950Ni.A04(this.A07, z2, this.A03);
        if (this.A02) {
            Messenger messenger = this.A00;
            if (A0A[2].length() != 17) {
                throw new RuntimeException();
            }
            A0A[6] = "P62SHD49IwhaYJMd1yj6mhn8O1XS0mYq";
            if (messenger == null) {
                this.A04.postDelayed(this.A08, UA.A01(this.A07));
                return;
            }
            return;
        }
        TN.A05(this.A07);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (message.what == 2) {
                C0950Ni.A02(this.A07, message);
                this.A06.AHZ();
                return;
            }
            if (message.what == 20 || message.what == 40 || message.what == 30) {
                this.A06.AHb(message.what);
                if (message.what == 20) {
                    UA.A07(this.A07);
                }
                String str = A05(0, 33, 15) + message.what;
                TN.A05(this.A07);
                return;
            }
            if (message.what == 4) {
                this.A06.AHc();
                Bundle data = message.getData();
                if (this.A01 != null) {
                    boolean z2 = data.getBoolean(A05(33, 30, 0), false);
                    String strA05 = A05(88, 15, 88);
                    if (A0A[3].charAt(16) != '0') {
                        throw new RuntimeException();
                    }
                    A0A[0] = "zzNr3SVv6qtYyPyvWR";
                    if (z2) {
                        this.A01.AEQ(data.getString(strA05));
                    } else if (data.getBoolean(A05(63, 25, 116), false)) {
                        this.A01.AER(data.getString(strA05));
                    }
                }
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
