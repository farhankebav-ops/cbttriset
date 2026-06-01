package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyFrames {
    ArrayList<Keys> mKeys = new ArrayList<>();

    public void add(Keys keys) {
        this.mKeys.add(keys);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.mKeys.isEmpty()) {
            sb.append("keyFrames:{\n");
            ArrayList<Keys> arrayList = this.mKeys;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Keys keys = arrayList.get(i2);
                i2++;
                sb.append(keys.toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
