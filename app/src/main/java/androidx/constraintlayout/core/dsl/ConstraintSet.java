package androidx.constraintlayout.core.dsl;

import a1.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    ArrayList<Constraint> mConstraints = new ArrayList<>();
    ArrayList<Helper> mHelpers = new ArrayList<>();
    private final String mName;

    public ConstraintSet(String str) {
        this.mName = str;
    }

    public void add(Constraint constraint) {
        this.mConstraints.add(constraint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a.r(new StringBuilder(), this.mName, ":{\n"));
        int i2 = 0;
        if (!this.mConstraints.isEmpty()) {
            ArrayList<Constraint> arrayList = this.mConstraints;
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Constraint constraint = arrayList.get(i8);
                i8++;
                sb.append(constraint.toString());
            }
        }
        if (!this.mHelpers.isEmpty()) {
            ArrayList<Helper> arrayList2 = this.mHelpers;
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Helper helper = arrayList2.get(i2);
                i2++;
                sb.append(helper.toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void add(Helper helper) {
        this.mHelpers.add(helper);
    }
}
