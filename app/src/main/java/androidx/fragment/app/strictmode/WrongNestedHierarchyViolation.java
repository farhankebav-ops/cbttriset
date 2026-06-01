package androidx.fragment.app.strictmode;

import a1.a;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class WrongNestedHierarchyViolation extends Violation {
    private final int containerId;
    private final Fragment expectedParentFragment;

    public WrongNestedHierarchyViolation(Fragment fragment, Fragment expectedParentFragment, int i2) {
        k.e(fragment, "fragment");
        k.e(expectedParentFragment, "expectedParentFragment");
        StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
        sb.append(fragment);
        sb.append(" within the view of parent fragment ");
        sb.append(expectedParentFragment);
        sb.append(" via container with ID ");
        super(fragment, a.q(sb, " without using parent's childFragmentManager", i2));
        this.expectedParentFragment = expectedParentFragment;
        this.containerId = i2;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    public final Fragment getExpectedParentFragment() {
        return this.expectedParentFragment;
    }
}
