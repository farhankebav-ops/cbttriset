package com.bytedance.sdk.openadsdk.MY;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private int EO;
    private int MY;
    private volatile boolean tV;

    public MY(int i2, int i8) {
        this.MY = 15;
        this.EO = 3;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.MY = i2;
        this.EO = i8;
    }

    private void EO(List<File> list) {
        long jMY = MY(list);
        int size = list.size();
        if (IlO(jMY, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jMY -= length;
            }
            if (IlO(file, jMY, size)) {
                return;
            }
        }
    }

    private void tV(List<File> list) {
        long jMY;
        int size;
        boolean zIlO;
        if (list != null) {
            try {
                if (list.size() != 0 && !(zIlO = IlO((jMY = MY(list)), (size = list.size())))) {
                    TreeMap treeMap = new TreeMap();
                    for (File file : list) {
                        treeMap.put(Long.valueOf(file.lastModified()), file);
                    }
                    for (Map.Entry entry : treeMap.entrySet()) {
                        if (entry != null && !zIlO) {
                            ((Long) entry.getKey()).getClass();
                            File file2 = (File) entry.getValue();
                            long length = file2.length();
                            if (file2.delete()) {
                                size--;
                                jMY -= length;
                            }
                            if (IlO(file2, jMY, size)) {
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.MY.IlO
    public boolean IlO(long j, int i2) {
        return i2 <= this.MY;
    }

    @Override // com.bytedance.sdk.openadsdk.MY.IlO
    public boolean IlO(File file, long j, int i2) {
        return i2 <= this.EO;
    }

    @Override // com.bytedance.sdk.openadsdk.MY.IlO
    public void IlO(List<File> list) {
        if (this.tV) {
            tV(list);
            this.tV = false;
        } else {
            EO(list);
        }
    }

    public MY(int i2, int i8, boolean z2) {
        this.MY = 15;
        this.EO = 3;
        if (i2 > 0) {
            this.MY = i2;
            this.EO = i8;
            this.tV = z2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
