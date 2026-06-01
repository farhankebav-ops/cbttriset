package androidx.constraintlayout.core.dsl;

import androidx.camera.core.processing.util.a;
import com.ironsource.C2300e4;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Keys {
    public void append(StringBuilder sb, String str, int i2) {
        if (i2 != Integer.MIN_VALUE) {
            sb.append(str);
            sb.append(":'");
            sb.append(i2);
            sb.append("',\n");
        }
    }

    public String unpack(String[] strArr) {
        StringBuilder sb = new StringBuilder(C2300e4.i.f8403d);
        int i2 = 0;
        while (i2 < strArr.length) {
            sb.append(i2 == 0 ? "'" : ",'");
            sb.append(strArr[i2]);
            sb.append("'");
            i2++;
        }
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    public void append(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            a.A(sb, str, ":'", str2, "',\n");
        }
    }

    public void append(StringBuilder sb, String str, float f4) {
        if (Float.isNaN(f4)) {
            return;
        }
        sb.append(str);
        sb.append(":");
        sb.append(f4);
        sb.append(",\n");
    }

    public void append(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(":");
            sb.append(unpack(strArr));
            sb.append(",\n");
        }
    }

    public void append(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }
}
