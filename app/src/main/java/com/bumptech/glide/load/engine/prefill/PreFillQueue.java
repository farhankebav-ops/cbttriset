package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.bitmapsRemaining = num.intValue() + this.bitmapsRemaining;
        }
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }

    public PreFillType remove() {
        PreFillType preFillType = this.keyList.get(this.keyIndex);
        Integer num = this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType;
    }
}
