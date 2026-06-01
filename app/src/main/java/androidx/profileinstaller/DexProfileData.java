package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class DexProfileData {

    @NonNull
    final String apkName;
    int classSetSize;

    @NonNull
    int[] classes;
    final long dexChecksum;

    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;

    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    public DexProfileData(@NonNull String str, @NonNull String str2, long j, long j3, int i2, int i8, int i9, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j;
        this.mTypeIdCount = j3;
        this.classSetSize = i2;
        this.hotMethodRegionSize = i8;
        this.numMethodIds = i9;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
