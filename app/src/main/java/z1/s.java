package z1;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f17959a;

    public s(u uVar) {
        this.f17959a = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        u uVar = this.f17959a;
        ListPopupWindow listPopupWindow = uVar.f17963a;
        uVar.setText(uVar.convertSelectionToString(i2 < 0 ? listPopupWindow.getSelectedItem() : uVar.getAdapter().getItem(i2)), false);
        AdapterView.OnItemClickListener onItemClickListener = uVar.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i2 < 0) {
                view = listPopupWindow.getSelectedView();
                i2 = listPopupWindow.getSelectedItemPosition();
                j = listPopupWindow.getSelectedItemId();
            }
            onItemClickListener.onItemClick(listPopupWindow.getListView(), view, i2, j);
        }
        listPopupWindow.dismiss();
    }
}
