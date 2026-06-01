package com.bumptech.glide.util;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlideSuppliers {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> glideSupplier) {
        return new GlideSupplier<T>() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile T instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        try {
                            if (this.instance == null) {
                                this.instance = (T) Preconditions.checkNotNull(glideSupplier.get());
                            }
                        } finally {
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
