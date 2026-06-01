package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class C0Z<K, V> extends AbstractC03981i<K, V> implements InterfaceC0616Ah<K, V> {
    public static final long serialVersionUID = 6588350623831699109L;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC03981i
    public final Collection<V> A0F(@ParametricNullness K key, Collection<V> collection) {
        return A0H(key, (List) collection, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0Z != com.google.common.collect.AbstractListMultimap<K, V> */
    public C0Z(Map<K, Collection<V>> map) {
        super(map);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0Z != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC03981i
    public final <E> Collection<E> A0G(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0Z != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.BD, com.instagram.common.viewpoint.core.InterfaceC2117oE
    public Map<K, Collection<V>> A49() {
        return super.A49();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0Z != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC03981i, com.instagram.common.viewpoint.core.InterfaceC2117oE
    public boolean AGU(@ParametricNullness K key, @ParametricNullness V value) {
        return super.AGU(key, value);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.0Z != com.google.common.collect.AbstractListMultimap<K, V> */
    @Override // com.instagram.common.viewpoint.core.BD
    public boolean equals(@CheckForNull Object object) {
        return super.equals(object);
    }
}
