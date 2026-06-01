package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0915Ly extends AbstractC1549eW {
    public static String[] A01 = {"M3Te92XvVv4q3bfKEkaCq6oPQP87x4vv", "LzmiiHhJsyKuUkJv7K1Ir2o", "KopJ75", "b4r1pmUHtrvrrbICXjY", "ceBgm8EiRhrot5ffXZtZ35omPt2ZFFf0", "0EayevzsZQe4lRY4RLfa4MEWre", "N9h8Vj", "K1Ob6mZ8MwS9WZtXZ80XEzEALvtTcRJ2"};
    public final /* synthetic */ Y9 A00;

    public C0915Ly(Y9 y9) {
        this.A00 = y9;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1549eW
    public final void A03() {
        if (this.A00.A07 == null || this.A00.A07.A0D()) {
            this.A00.A09.A0V();
            if (!this.A00.A05.A07()) {
                this.A00.A05.A05();
            }
            Y8 listener = (Y8) this.A00.A0B.get();
            if (listener != null) {
                listener.ADW();
            }
            Y9 y9 = this.A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "2rS8p9kEkH8XxeBlGl7RSlB";
            strArr2[3] = "nqXy6qNf0NylKakjBUJ";
            y9.A09.A0V();
            return;
        }
        this.A00.A09.A0T();
    }
}
