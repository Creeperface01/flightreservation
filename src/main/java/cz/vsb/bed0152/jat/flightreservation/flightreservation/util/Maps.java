package cz.vsb.bed0152.jat.flightreservation.flightreservation.util;

import com.google.common.collect.ImmutableMap;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Map;

@UtilityClass
public class Maps {

    public <K, V> Map<K, V> of() {
        return Collections.emptyMap();
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1
    ) {
        return ImmutableMap.of(k1, v1);
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1,
            K k2,
            V v2
    ) {
        return ImmutableMap.of(k1, v1, k2, v2);
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1,
            K k2,
            V v2,
            K k3,
            V v3
    ) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3);
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1,
            K k2,
            V v2,
            K k3,
            V v3,
            K k4,
            V v4
    ) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1,
            K k2,
            V v2,
            K k3,
            V v3,
            K k4,
            V v4,
            K k5,
            V v5
    ) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public <K, V> Map<K, V> of(
            K k1,
            V v1,
            K k2,
            V v2,
            K k3,
            V v3,
            K k4,
            V v4,
            K k5,
            V v5,
            K k6,
            V v6
    ) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }
}
