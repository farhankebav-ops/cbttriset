package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class FiamImageLoader {
    private final RequestManager requestManager;
    private final Map<String, Set<CustomTarget>> tags = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Callback extends CustomTarget<Drawable> {
        private ImageView imageView;

        private void setImage(Drawable drawable) {
            ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        public abstract void onError(Exception exc);

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            Logging.logd("Downloading Image Cleared");
            setImage(drawable);
            onSuccess();
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            Logging.logd("Downloading Image Failed");
            setImage(drawable);
            onError(new Exception("Image loading failed!"));
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        public abstract void onSuccess();

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            Logging.logd("Downloading Image Success!!!");
            setImage(drawable);
            onSuccess();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class FiamImageRequestCreator {
        private final RequestBuilder<Drawable> requestBuilder;
        private String tag;
        private Callback target;

        public FiamImageRequestCreator(RequestBuilder<Drawable> requestBuilder) {
            this.requestBuilder = requestBuilder;
        }

        private void checkAndTag() {
            Set hashSet;
            if (this.target == null || TextUtils.isEmpty(this.tag)) {
                return;
            }
            synchronized (FiamImageLoader.this.tags) {
                try {
                    if (FiamImageLoader.this.tags.containsKey(this.tag)) {
                        hashSet = (Set) FiamImageLoader.this.tags.get(this.tag);
                    } else {
                        hashSet = new HashSet();
                        FiamImageLoader.this.tags.put(this.tag, hashSet);
                    }
                    if (!hashSet.contains(this.target)) {
                        hashSet.add(this.target);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FiamImageRequestCreator addErrorListener(GlideErrorListener glideErrorListener) {
            this.requestBuilder.addListener(glideErrorListener);
            return this;
        }

        public void into(ImageView imageView, Callback callback) {
            Logging.logd("Downloading Image Callback : " + callback);
            callback.setImageView(imageView);
            this.requestBuilder.into(callback);
            this.target = callback;
            checkAndTag();
        }

        public FiamImageRequestCreator placeholder(int i2) {
            this.requestBuilder.placeholder(i2);
            Logging.logd("Downloading Image Placeholder : " + i2);
            return this;
        }

        public FiamImageRequestCreator tag(Class cls) {
            this.tag = cls.getSimpleName();
            checkAndTag();
            return this;
        }
    }

    public FiamImageLoader(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public void cancelTag(Class cls) {
        String simpleName = cls.getSimpleName();
        synchronized (simpleName) {
            try {
                if (this.tags.containsKey(simpleName)) {
                    for (CustomTarget customTarget : this.tags.get(simpleName)) {
                        if (customTarget != null) {
                            this.requestManager.clear(customTarget);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public boolean containsTag(String str) {
        Map<String, Set<CustomTarget>> map = this.tags;
        return map != null && map.containsKey(str) && this.tags.get(str) != null && this.tags.get(str).size() > 0;
    }

    public FiamImageRequestCreator load(@Nullable String str) {
        Logging.logd("Starting Downloading Image : " + str);
        return new FiamImageRequestCreator(this.requestManager.load((Object) new GlideUrl(str, new LazyHeaders.Builder().addHeader("Accept", "image/*").build())).format(DecodeFormat.PREFER_ARGB_8888));
    }
}
