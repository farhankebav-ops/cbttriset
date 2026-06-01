package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import com.ironsource.C2300e4;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyParser {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface DataType {
        int get(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject cLObject = CLParser.parse(str);
            int size = cLObject.size();
            for (int i2 = 0; i2 < size; i2++) {
                CLKey cLKey = (CLKey) cLObject.get(i2);
                String strContent = cLKey.content();
                CLElement value = cLKey.getValue();
                int i8 = ids.get(strContent);
                if (i8 == -1) {
                    System.err.println("unknown type " + strContent);
                } else {
                    int i9 = dataType.get(i8);
                    if (i9 == 1) {
                        typedBundle.add(i8, cLObject.getBoolean(i2));
                    } else if (i9 == 2) {
                        typedBundle.add(i8, value.getInt());
                        System.out.println("parse " + strContent + " INT_MASK > " + value.getInt());
                    } else if (i9 == 4) {
                        typedBundle.add(i8, value.getFloat());
                        System.out.println("parse " + strContent + " FLOAT_MASK > " + value.getFloat());
                    } else if (i9 == 8) {
                        typedBundle.add(i8, value.content());
                        System.out.println("parse " + strContent + " STRING_MASK > " + value.content());
                    }
                }
            }
            return typedBundle;
        } catch (CLParsingException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace(C2300e4.i.f8403d, "   at ").replace(",", "\n   at").replace(C2300e4.i.e, ""));
            return typedBundle;
        }
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new a(), new a());
    }
}
