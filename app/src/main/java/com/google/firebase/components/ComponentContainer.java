package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface ComponentContainer {
    <T> T get(Qualified<T> qualified);

    <T> T get(Class<T> cls);

    <T> Deferred<T> getDeferred(Qualified<T> qualified);

    <T> Deferred<T> getDeferred(Class<T> cls);

    <T> Provider<T> getProvider(Qualified<T> qualified);

    <T> Provider<T> getProvider(Class<T> cls);

    <T> Set<T> setOf(Qualified<T> qualified);

    <T> Set<T> setOf(Class<T> cls);

    <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified);

    <T> Provider<Set<T>> setOfProvider(Class<T> cls);
}
