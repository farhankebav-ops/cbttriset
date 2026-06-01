package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i2) {
        this.mDropDownLayout = i2;
    }

    public void setViewResource(int i2) {
        this.mLayout = i2;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, int i8) {
        super(context, cursor, i8);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
