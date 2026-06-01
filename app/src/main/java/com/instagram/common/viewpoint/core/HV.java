package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HV implements InterfaceC1173Wc {
    public static String[] A01 = {"72ztA7TlK5AWnMBFqm0ulEGrNikWU87c", "q9jSjTIXJJeud4mNFdEJpcs0aBWF", "6LBG7Z", "4a80CIrFExPHnWcdf8FRxARvXokzjsAY", "hmt020juZcOK2XVUFVfIwXvCI0upMeB5", "bPuxHbTn8HkB22ksZqTc8mW6RF8jNMxu", "KvPASdtvPFN6v", "W7wSubo8j20OAA03KxoOzu7JM99EpBz5"};
    public final /* synthetic */ AnonymousClass50 A00;

    public HV(AnonymousClass50 anonymousClass50) {
        this.A00 = anonymousClass50;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        if (!(this.A00.A01 instanceof C0862Jx) || !this.A00.A01.A1K()) {
            if (!(this.A00.A01 instanceof C0831Is) || !this.A00.A01.A1K()) {
                InterfaceC1424cT interfaceC1424cT = this.A00.A07;
                String[] strArr = A01;
                if (strArr[4].charAt(11) == strArr[3].charAt(11)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[5] = "jNYMJATRfaQqNW2YkrgQ7vcVmM2IUm0K";
                strArr2[0] = "cX4sd5TjwRWpCL8J3hPSalfD2n4ZIotM";
                interfaceC1424cT.AFE(false);
            } else {
                this.A00.A07.AFE(true);
                this.A00.A06.setToolbarActionMode(1);
            }
        } else {
            this.A00.A07.AFE(true);
            this.A00.A06.setToolbarActionMode(1);
        }
        this.A00.A07.ACy(this.A00.A03);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        this.A00.A07.ADI(this.A00.A03 - f4);
        if (this.A00.A02 != null) {
            this.A00.A02.A07((int) (this.A00.A03 - f4));
        }
    }
}
