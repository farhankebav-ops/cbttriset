package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.15, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass15 extends AbstractC05949l {
    public int A00;
    public Uri A01;
    public DatagramSocket A02;
    public InetAddress A03;
    public MulticastSocket A04;
    public boolean A05;
    public final int A06;
    public final DatagramPacket A07;
    public final byte[] A08;

    public AnonymousClass15() {
        this(2000);
    }

    public AnonymousClass15(int i2) {
        this(i2, 8000);
    }

    public AnonymousClass15(int i2, int i8) {
        super(true);
        this.A06 = i8;
        this.A08 = new byte[i2];
        this.A07 = new DatagramPacket(this.A08, 0, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final Uri A9H() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final long AFy(AnonymousClass56 anonymousClass56) throws C2077nZ {
        this.A01 = anonymousClass56.A06;
        String str = (String) C3M.A01(this.A01.getHost());
        int port = this.A01.getPort();
        A0G(anonymousClass56);
        try {
            this.A03 = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.A03, port);
            if (this.A03.isMulticastAddress()) {
                this.A04 = new MulticastSocket(inetSocketAddress);
                this.A04.joinGroup(this.A03);
                this.A02 = this.A04;
            } else {
                this.A02 = new DatagramSocket(inetSocketAddress);
            }
            this.A02.setSoTimeout(this.A06);
            this.A05 = true;
            A0H(anonymousClass56);
            return -1L;
        } catch (IOException e) {
            throw new C2077nZ(e, 2001);
        } catch (SecurityException e4) {
            throw new C2077nZ(e4, 2006);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2089nl
    public final void close() {
        this.A01 = null;
        if (this.A04 != null) {
            try {
                this.A04.leaveGroup((InetAddress) C3M.A01(this.A03));
            } catch (IOException unused) {
            }
            this.A04 = null;
        }
        if (this.A02 != null) {
            this.A02.close();
            this.A02 = null;
        }
        this.A03 = null;
        this.A00 = 0;
        if (this.A05) {
            this.A05 = false;
            A0E();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass20
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        if (this.A00 == 0) {
            try {
                ((DatagramSocket) C3M.A01(this.A02)).receive(this.A07);
                this.A00 = this.A07.getLength();
                A0F(this.A00);
            } catch (SocketTimeoutException e) {
                throw new C2077nZ(e, 2002);
            } catch (IOException e4) {
                throw new C2077nZ(e4, 2001);
            }
        }
        int length = this.A07.getLength() - this.A00;
        int packetOffset = this.A00;
        int bytesToRead = Math.min(packetOffset, i8);
        System.arraycopy(this.A08, length, bArr, i2, bytesToRead);
        int packetOffset2 = this.A00;
        this.A00 = packetOffset2 - bytesToRead;
        return bytesToRead;
    }
}
