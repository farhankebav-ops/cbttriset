package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private int lastEnd;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;
    private int lastFirstVisible = -1;
    private boolean isIncreasing = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i2);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t3, int i2, int i8);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i2) {
            this.queue = Util.createQueue(i2);
            for (int i8 = 0; i8 < i2; i8++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i2, int i8) {
            PreloadTarget preloadTargetPoll = this.queue.poll();
            this.queue.offer(preloadTargetPoll);
            preloadTargetPoll.photoWidth = i2;
            preloadTargetPoll.photoHeight = i8;
            return preloadTargetPoll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i2) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i2;
        this.preloadTargetQueue = new PreloadTargetQueue(i2 + 1);
    }

    private void cancelAll() {
        for (int i2 = 0; i2 < this.preloadTargetQueue.queue.size(); i2++) {
            this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i2, boolean z2) {
        if (this.isIncreasing != z2) {
            this.isIncreasing = z2;
            cancelAll();
        }
        preload(i2, (z2 ? this.maxPreload : -this.maxPreload) + i2);
    }

    private void preloadAdapterPosition(List<T> list, int i2, boolean z2) {
        int size = list.size();
        if (z2) {
            for (int i8 = 0; i8 < size; i8++) {
                preloadItem(list.get(i8), i2, i8);
            }
            return;
        }
        for (int i9 = size - 1; i9 >= 0; i9--) {
            preloadItem(list.get(i9), i2, i9);
        }
    }

    private void preloadItem(@Nullable T t3, int i2, int i8) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t3 == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t3, i2, i8)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t3)) == null) {
            return;
        }
        preloadRequestBuilder.into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i8, int i9) {
        if (this.totalItemCount == 0 && i9 == 0) {
            return;
        }
        this.totalItemCount = i9;
        int i10 = this.lastFirstVisible;
        if (i2 > i10) {
            preload(i8 + i2, true);
        } else if (i2 < i10) {
            preload(i2, false);
        }
        this.lastFirstVisible = i2;
    }

    private void preload(int i2, int i8) {
        int iMin;
        int iMax;
        if (i2 < i8) {
            iMax = Math.max(this.lastEnd, i2);
            iMin = i8;
        } else {
            iMin = Math.min(this.lastStart, i2);
            iMax = i8;
        }
        int iMin2 = Math.min(this.totalItemCount, iMin);
        int iMin3 = Math.min(this.totalItemCount, Math.max(0, iMax));
        if (i2 < i8) {
            for (int i9 = iMin3; i9 < iMin2; i9++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i9), i9, true);
            }
        } else {
            for (int i10 = iMin2 - 1; i10 >= iMin3; i10--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i10), i10, false);
            }
        }
        this.lastStart = iMin3;
        this.lastEnd = iMin2;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;

        @Nullable
        private Request request;

        @Override // com.bumptech.glide.request.target.Target
        @Nullable
        public Request getRequest() {
            return this.request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(@Nullable Request request) {
            this.request = request;
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
