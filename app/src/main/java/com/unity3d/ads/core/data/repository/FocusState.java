package com.unity3d.ads.core.data.repository;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface FocusState {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Focused implements FocusState {
        private final WeakReference<Activity> activity;

        public Focused(WeakReference<Activity> activity) {
            k.e(activity, "activity");
            this.activity = activity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Focused copy$default(Focused focused, WeakReference weakReference, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                weakReference = focused.getActivity();
            }
            return focused.copy(weakReference);
        }

        public final WeakReference<Activity> component1() {
            return getActivity();
        }

        public final Focused copy(WeakReference<Activity> activity) {
            k.e(activity, "activity");
            return new Focused(activity);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Focused) && k.a(getActivity(), ((Focused) obj).getActivity());
        }

        @Override // com.unity3d.ads.core.data.repository.FocusState
        public WeakReference<Activity> getActivity() {
            return this.activity;
        }

        public int hashCode() {
            return getActivity().hashCode();
        }

        public String toString() {
            return "Focused(activity=" + getActivity() + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Unfocused implements FocusState {
        private final WeakReference<Activity> activity;

        public Unfocused(WeakReference<Activity> activity) {
            k.e(activity, "activity");
            this.activity = activity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Unfocused copy$default(Unfocused unfocused, WeakReference weakReference, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                weakReference = unfocused.getActivity();
            }
            return unfocused.copy(weakReference);
        }

        public final WeakReference<Activity> component1() {
            return getActivity();
        }

        public final Unfocused copy(WeakReference<Activity> activity) {
            k.e(activity, "activity");
            return new Unfocused(activity);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unfocused) && k.a(getActivity(), ((Unfocused) obj).getActivity());
        }

        @Override // com.unity3d.ads.core.data.repository.FocusState
        public WeakReference<Activity> getActivity() {
            return this.activity;
        }

        public int hashCode() {
            return getActivity().hashCode();
        }

        public String toString() {
            return "Unfocused(activity=" + getActivity() + ')';
        }
    }

    WeakReference<Activity> getActivity();
}
