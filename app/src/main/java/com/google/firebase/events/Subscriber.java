package com.google.firebase.events;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface Subscriber {
    <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler);

    <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler);
}
