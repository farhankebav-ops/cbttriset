package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i2 = this.mLastEventType;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i2 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i2 == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i2, int i8, Object obj) {
        int i9;
        if (this.mLastEventType == 3) {
            int i10 = this.mLastEventPosition;
            int i11 = this.mLastEventCount;
            if (i2 <= i10 + i11 && (i9 = i2 + i8) >= i10 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i2, i10);
                this.mLastEventCount = Math.max(i11 + i10, i9) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i2;
        this.mLastEventCount = i8;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i2, int i8) {
        int i9;
        if (this.mLastEventType == 1 && i2 >= (i9 = this.mLastEventPosition)) {
            int i10 = this.mLastEventCount;
            if (i2 <= i9 + i10) {
                this.mLastEventCount = i10 + i8;
                this.mLastEventPosition = Math.min(i2, i9);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i2;
        this.mLastEventCount = i8;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i2, int i8) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i2, i8);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i2, int i8) {
        int i9;
        if (this.mLastEventType == 2 && (i9 = this.mLastEventPosition) >= i2 && i9 <= i2 + i8) {
            this.mLastEventCount += i8;
            this.mLastEventPosition = i2;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i2;
            this.mLastEventCount = i8;
            this.mLastEventType = 2;
        }
    }
}
