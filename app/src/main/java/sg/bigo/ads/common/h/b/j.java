package sg.bigo.ads.common.h.b;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes6.dex */
final class j {
    public static String a(float f4) {
        String str;
        if (f4 >= 1048576.0f) {
            f4 = (f4 / 1024.0f) / 1024.0f;
            str = "mb/s";
        } else if (f4 >= 1024.0f) {
            f4 /= 1024.0f;
            str = "kb/s";
        } else {
            str = "b/s";
        }
        return a1.a.C(new DecimalFormat("0.00").format(f4), str);
    }
}
