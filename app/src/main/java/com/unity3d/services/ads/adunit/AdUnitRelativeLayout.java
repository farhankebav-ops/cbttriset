package com.unity3d.services.ads.adunit;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdUnitRelativeLayout extends RelativeLayout {
    private InputEvent _lastInputEvent;
    private int _maxEvents;
    private final ArrayList<AdUnitMotionEvent> _motionEvents;
    private boolean _shouldCapture;

    public AdUnitRelativeLayout(Context context) {
        super(context);
        this._motionEvents = new ArrayList<>();
        this._maxEvents = 10000;
        this._shouldCapture = false;
    }

    public void clearCapture() {
        synchronized (this._motionEvents) {
            this._motionEvents.clear();
        }
    }

    public void endCapture() {
        this._shouldCapture = false;
    }

    public int getCurrentEventCount() {
        int size;
        synchronized (this._motionEvents) {
            size = this._motionEvents.size();
        }
        return size;
    }

    public SparseIntArray getEventCount(ArrayList<Integer> arrayList) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        synchronized (this._motionEvents) {
            try {
                ArrayList<AdUnitMotionEvent> arrayList2 = this._motionEvents;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    AdUnitMotionEvent adUnitMotionEvent = arrayList2.get(i2);
                    i2++;
                    AdUnitMotionEvent adUnitMotionEvent2 = adUnitMotionEvent;
                    int size2 = arrayList.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 < size2) {
                            Integer num = arrayList.get(i8);
                            i8++;
                            Integer num2 = num;
                            if (adUnitMotionEvent2.getAction() == num2.intValue()) {
                                sparseIntArray.put(num2.intValue(), sparseIntArray.get(num2.intValue(), 0) + 1);
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sparseIntArray;
    }

    public SparseArray<SparseArray<AdUnitMotionEvent>> getEvents(SparseArray<ArrayList<Integer>> sparseArray) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseArray<SparseArray<AdUnitMotionEvent>> sparseArray2 = new SparseArray<>();
        synchronized (this._motionEvents) {
            try {
                ArrayList<AdUnitMotionEvent> arrayList = this._motionEvents;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    AdUnitMotionEvent adUnitMotionEvent = arrayList.get(i2);
                    i2++;
                    AdUnitMotionEvent adUnitMotionEvent2 = adUnitMotionEvent;
                    ArrayList<Integer> arrayList2 = sparseArray.get(adUnitMotionEvent2.getAction());
                    if (arrayList2 != null) {
                        int iIntValue = arrayList2.get(0).intValue();
                        if (sparseIntArray.get(adUnitMotionEvent2.getAction(), 0) == iIntValue) {
                            if (sparseArray2.get(adUnitMotionEvent2.getAction()) == null) {
                                sparseArray2.put(adUnitMotionEvent2.getAction(), new SparseArray<>());
                            }
                            sparseArray2.get(adUnitMotionEvent2.getAction()).put(iIntValue, adUnitMotionEvent2);
                            arrayList2.remove(0);
                        }
                        sparseIntArray.put(adUnitMotionEvent2.getAction(), sparseIntArray.get(adUnitMotionEvent2.getAction()) + 1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sparseArray2;
    }

    public InputEvent getLastInputEvent() {
        return this._lastInputEvent;
    }

    public int getMaxEventCount() {
        return this._maxEvents;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 5) {
            this._lastInputEvent = motionEvent;
        }
        if (this._shouldCapture && this._motionEvents.size() < this._maxEvents) {
            boolean z2 = (motionEvent.getFlags() & 1) != 0;
            synchronized (this._motionEvents) {
                this._motionEvents.add(new AdUnitMotionEvent(motionEvent.getActionMasked(), z2, motionEvent.getToolType(0), motionEvent.getSource(), motionEvent.getDeviceId(), motionEvent.getX(0), motionEvent.getY(0), motionEvent.getEventTime(), motionEvent.getPressure(0), motionEvent.getSize(0)));
            }
        }
        return false;
    }

    public void startCapture(int i2) {
        this._maxEvents = i2;
        this._shouldCapture = true;
    }
}
