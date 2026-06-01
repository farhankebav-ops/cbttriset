package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList;

    public SurfaceCombination() {
        this.mSurfaceConfigList = new ArrayList();
    }

    private static void generateArrangements(List<int[]> list, int i2, int[] iArr, int i8) {
        if (i8 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = 0;
            while (true) {
                if (i10 >= i8) {
                    iArr[i8] = i9;
                    generateArrangements(list, i2, iArr, i8 + 1);
                    break;
                } else if (i9 == iArr[i10]) {
                    break;
                } else {
                    i10++;
                }
            }
        }
    }

    private List<int[]> getElementsArrangements(int i2) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i2, new int[i2], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> list) {
        int i2;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List<int[]> elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator<int[]> it = elementsArrangements.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            boolean zIsSupported = true;
            while (i2 < this.mSurfaceConfigList.size()) {
                if (next[i2] < list.size()) {
                    zIsSupported &= this.mSurfaceConfigList.get(i2).isSupported(list.get(next[i2]));
                    if (!zIsSupported) {
                        break;
                    }
                    surfaceConfigArr[next[i2]] = this.mSurfaceConfigList.get(i2);
                }
                i2++;
            }
            if (zIsSupported) {
                i2 = 1;
                break;
            }
        }
        if (i2 != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }

    public SurfaceCombination(SurfaceConfig... surfaceConfigArr) {
        ArrayList arrayList = new ArrayList();
        this.mSurfaceConfigList = arrayList;
        Collections.addAll(arrayList, surfaceConfigArr);
    }
}
