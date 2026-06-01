package com.bytedance.adsdk.ugeno.lEW;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MY {
    private final DataSetObservable IlO = new DataSetObservable();
    private DataSetObserver MY;

    public void EO() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.MY;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.IlO.notifyChanged();
    }

    public float IlO(int i2) {
        return 1.0f;
    }

    public abstract int IlO();

    public abstract boolean IlO(View view, Object obj);

    public Parcelable MY() {
        return null;
    }

    public int IlO(Object obj) {
        return -1;
    }

    public Object IlO(ViewGroup viewGroup, int i2) {
        return IlO((View) viewGroup, i2);
    }

    public void IlO(ViewGroup viewGroup, int i2, Object obj) {
        IlO((View) viewGroup, i2, obj);
    }

    @Deprecated
    public Object IlO(View view, int i2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void IlO(View view, int i2, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void IlO(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.MY = dataSetObserver;
        }
    }
}
