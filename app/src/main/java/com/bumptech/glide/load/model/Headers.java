package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.EMPTY_MAP;
        }
    };
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();
}
