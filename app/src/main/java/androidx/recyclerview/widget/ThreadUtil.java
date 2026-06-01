package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface ThreadUtil<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface BackgroundCallback<T> {
        void loadTile(int i2, int i8);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i2);

        void updateRange(int i2, int i8, int i9, int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MainThreadCallback<T> {
        void addTile(int i2, TileList.Tile<T> tile);

        void removeTile(int i2, int i8);

        void updateItemCount(int i2, int i8);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
