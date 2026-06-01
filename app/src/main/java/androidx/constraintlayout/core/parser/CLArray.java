package androidx.constraintlayout.core.parser;

import com.ironsource.C2300e4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i8) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i8 > 0 || json.length() + i2 >= CLElement.sMaxLine) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            int i9 = 0;
            boolean z2 = true;
            while (i9 < size) {
                CLElement cLElement = arrayList.get(i9);
                i9++;
                CLElement cLElement2 = cLElement;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.sBaseIndent + i2);
                sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i2, i8 - 1));
            }
            sb.append("\n");
            addIndent(sb, i2);
            sb.append(C2300e4.i.e);
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + C2300e4.i.f8403d);
        boolean z2 = true;
        for (int i2 = 0; i2 < this.mElements.size(); i2++) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i2).toJSON());
        }
        return ((Object) sb) + C2300e4.i.e;
    }
}
